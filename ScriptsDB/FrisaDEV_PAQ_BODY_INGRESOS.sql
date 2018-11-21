CREATE OR replace PACKAGE BODY xxfr_ingresos_lc 
AS 
  tot_fact            XXFR_LC_TABLE; 
  descnombancobbva    VARCHAR2(30) := 'BBVA Bancomer, S.A.'; 
  descnombancobanorte VARCHAR2(30) := 'BANORTE, S.A.'; 
  --tot_depts XXFR_FACTURA_TABLE; 
  /*Función Contar Facturas*/ 
  FUNCTION Xxfr_ingresos_cuenta_facturas(entrada IN VARCHAR2) 
  RETURN NUMBER 
  AS 
    facturas NUMBER; 
  BEGIN 
      SELECT Count(*) 
      INTO   facturas 
      FROM   ingresos.xxfr_cabecera_factura 
      WHERE  xxfr_cabecera_factura.idbatch = 
      Xxfr_ingresos_cuenta_facturas.entrada; 

      dbms_output.Put_line('Facturas = ' 
                           || facturas); 

      RETURN facturas; 
  END xxfr_ingresos_cuenta_facturas; 
  /*Función Recuperar Facturas*/ 
  FUNCTION Xxfr_ingresos_recupera_fac(entrada IN VARCHAR2) 
  RETURN XXFR_FACTURA_TABLE 
  IS 
    facturas XXFR_FACTURA_TABLE; 
  BEGIN 
      SELECT Xxfr_factura_rec(idfacturaprimavera, contractnumber, grouptype) 
      bulk   collect INTO facturas 
      FROM   ingresos.xxfr_cabecera_factura 
      WHERE  xxfr_cabecera_factura.idbatch = Xxfr_ingresos_recupera_fac.entrada 
             AND tipocobranza = 'LINEA CAPTURA' 
             AND transactiontype = 'FAC_INGRESOS_MN'; 

      RETURN facturas; 
  END xxfr_ingresos_recupera_fac; 
  /*ID Código de Línea de Captura*/ 
  FUNCTION Xxfr_id_lc(val1 NUMBER) 
  RETURN VARCHAR2 
  IS 
    idlc VARCHAR2(20); 
  BEGIN 
      SELECT Lpad(ingresos.xxfr_ingresos_id_lc.NEXTVAL, 9, '0') 
      INTO   idlc 
      FROM   dual; 

      RETURN idlc; 
  END xxfr_id_lc; 
  /*ARMADO DE LC*/ 
  FUNCTION Xxfr_forma_lc(idbatch IN VARCHAR2) 
  RETURN XXFR_LC_TABLE 
  IS 
    idlc XXFR_LC_TABLE; 
  BEGIN 
      ------- 
      SELECT Xxfr_lc_rec(transactionsource, projectid, 
             --Estos deberían ser 3 y no 4 
             contractnumber --estos deberían ser 8, sólo tengo 3 
             ) 
      bulk   collect INTO tot_fact 
      FROM   xxfr_cabecera_factura 
      WHERE  idbatch = Xxfr_forma_lc.idbatch; 

      -------SELECT COUNT(*) INTO idlc FROM XXFR_FORMA_LC.tot_fact; 
      /*RECUPERA ID DE LC  -- OK*/ 
      /*ARMA LC*/ 
      /*INSERTA LC*/ 
      RETURN NULL; 
  END xxfr_forma_lc; 
  --Fin-- 
  FUNCTION Xxfr_generarlc(division         IN VARCHAR2, 
                          proyecto         IN NUMBER, 
                          contrato         IN NUMBER, 
                          lineacapturain   IN VARCHAR2, 
                          nombrebanco      IN VARCHAR2, 
                          fechatransaccion IN VARCHAR2, 
                          totalfactuado    IN VARCHAR2, 
                          referencia       IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    lineacaptura    VARCHAR2(30) := ''; 
    errorparametro  VARCHAR2(30) := ''; 
    lanzarerrorparametro EXCEPTION; 
    proyectotxt     VARCHAR2(3) := ''; 
    contratotxt     VARCHAR2(8) := ''; 
    importefechadv  VARCHAR2(9); --importeFechaVigenciaVerificador 
    constante_banco VARCHAR2(1) := '2'; 
  --Constante fijo del banco paa el calculo del digito V 
  BEGIN --importeFechaVigenciaVerificador 
      --Validar que la información de entrada sea correcta 
  /* dbms_output.put_line('** Valores de entrada **'); 
   dbms_output.put_line('division= ' || division); 
   dbms_output.put_line('proyecto = ' || proyecto); 
   dbms_output.put_line('contrato = ' || contrato); 
   dbms_output.put_line('lineaCapturaIN = ' || lineacapturain); 
   dbms_output.put_line('importeFechaDV = ' || importefechadv); 
   dbms_output.put_line('nombrebanco = ' || nombrebanco); 
   dbms_output.put_line('fechatransaccion = ' || fechatransaccion); 
   dbms_output.put_line('totalFactuado = ' || totalFactuado); 
   dbms_output.put_line('referencia = ' || referencia);*/ 
      /*Que la división sean dos digitos 01 o 02, de lo contrario se regresa error 
      **101 - Error de datos de entrada : División solo puede ser 01 Renta, 02 Venta*/ 
      errorparametro := Nvl(division, '101'); 

      IF ( errorparametro = '101' ) THEN 
        RAISE lanzarerrorparametro; 
      END IF; 

      -- dbms_output.put_line('lineaCapturaP= ' || lineacaptura); 
      /*Proyecto sea de 3 digitos, de lo contrario se regresa error 
      **102 - Error de datos de entrada : Digitos del Proyecto no es valido, deben ser 3 digitos*/
      errorparametro := Nvl(proyecto, '102'); 

      IF ( errorparametro = '102' ) THEN 
        RAISE lanzarerrorparametro; 
      ELSE --Convertir proyecto a cadena 3 digitos 
        proyectotxt := Lpad(proyecto, 3, '0'); 
      END IF; 

      /*Exista un contrato, de lo contrario se regresa error 
      **103 - Error de datos de entrada : Numero de contrato no es valido, deben ser diferente de nulo*/
      errorparametro := Nvl(contrato, '103'); 

      IF ( errorparametro = '103' ) THEN 
        RAISE lanzarerrorparametro; 
      ELSE --Convertir contrato a cadena 8 digitos 
        contratotxt := Lpad(contrato, 8, '0'); 
      END IF; 

      -- dbms_output.put_line('contratoTxt= ' || contratotxt); 
      /*Exista línea de captura, de lo contrario se regresa error 
      **104 - Error de datos de entrada : Numero de contrato no es valido, deben ser diferente de nulo*/
      errorparametro := Nvl(lineacapturain, '104'); 

      IF ( errorparametro = '104' ) THEN 
        RAISE lanzarerrorparametro; 
      END IF; 

      -- dbms_output.put_line('lineaCapturaL= ' || lineacaptura); 
      /*importeFechaDV sea de 8 digitos, de lo contrario se regresa error 
      **105 - Error de datos de entrada : el importe, fecha de vigencia y digito verificador no es valido, deben ser de 8 digitos*/
      errorparametro := Nvl(nombrebanco, '105'); 

      IF ( errorparametro = '105' ) THEN 
        RAISE lanzarerrorparametro; 
      ELSE 
        errorparametro := Nvl(fechatransaccion, '105'); 

        IF ( errorparametro = '105' ) THEN 
          RAISE lanzarerrorparametro; 
        END IF; 
      END IF; 

      -- constante del banco 
      -- to_date (fechatransaccion) 
      importefechadv := Xxfr_digitoverificador(nombrebanco, fechatransaccion, 
                        constante_banco, Nvl( 
                                          totalfactuado, ''), 
                        Nvl(referencia, '')) 
      ; 

      -- dbms_output.put_line('lineaCapturaI= ' || lineacaptura); 
      /* Procesar parametros y formar codigo de la LC 
      */ 
      lineacaptura := ( division 
                        || proyectotxt 
                        || contratotxt 
                        || lineacapturain 
                        || importefechadv ); 

      -- dbms_output.put_line('lineaCaptura = ' || lineacaptura); 
      RETURN lineacaptura; 
  EXCEPTION -- exception handlers begin 
    WHEN lanzarerrorparametro THEN 
               RETURN errorparametro; 
  END xxfr_generarlc; 
  /* 
  Función que permite procesar el lote de facturas definidas por un IDBATCH, y lograr Generar la línea de captura
  aplicando las reglas especificadas en los requerimientos funcionales 
  */ 
  FUNCTION Xxfr_procesar_batch(idparbatch IN VARCHAR2) 
  -- Lanzar actualización del estatus a las 
  RETURN VARCHAR2 
  AS 
    errorparametro VARCHAR2(30) := ''; 
    lanzarerrorparametro EXCEPTION; 
    proceso        VARCHAR2(3) := '100'; 
    --El valor 100 corresponde a un error de infraestructura siempre y cuando el proceso genere una excepción no manejada
    idvalido       NUMBER := 0; 
    idestatdobatch NUMBER := 0; 
  BEGIN 
      --dbms_output.put_line(' Inicia funcion XXFR_PROCESAR_BATCH Valores de entrada '); 
      SELECT Count(*) 
      INTO   idvalido 
      FROM   xxfr_cabecera_factura 
      WHERE  idbatch = idparbatch; 

      --dbms_output.put_line(' idValido '||idValido); 
      IF idvalido = 0 THEN 
        errorparametro := '107'; 

        INSERT INTO xxfr_estado_batch 
                    (idbatch, 
                     estado, 
                     inicioproceso) 
        VALUES      (idparbatch, 
                     'ERROR-107', 
                     current_date); 

        RAISE lanzarerrorparametro; 
      END IF; 

      -- Insertar la bitácora del proceso de generación de LC 
      INSERT INTO xxfr_estado_batch 
                  (idbatch, 
                   estado, 
                   inicioproceso) 
      VALUES      (idparbatch, 
                   'PROCESO', 
                   current_date); 

      SELECT Max(idestadobatch) 
      INTO   idestatdobatch 
      FROM   xxfr_estado_batch 
      WHERE  idbatch = idparbatch; 

      errorparametro := '100'; 

      INSERT INTO xxfr_linea_captura 
                  (lineacaptura, 
                   fechacreacion, 
                   estatuslc, 
                   banco, 
                   division, 
                   centrocostosproyecto, 
                   tipocobranza, 
                   montolineacaptura, 
                   fechavigencia, 
                   lineacapturaref, 
                   referencia) 
      SELECT DISTINCT xxfr_ingresos_lc.Xxfr_generarlc(flc.divisiontype, 
                      flc.projectid, 
                                      flc.contractnumber, 
                      'CODSEQING', flc.bankname, 
                                      To_char(flc.creationdatetrx), 
                                      flc.totalamount, flc.referencenumber) LC, 
                      current_date, 
                      'ACTIVO', 
                      flc.bankname, 
                      flc.divisiontype, 
                      flc.projectid, 
                      flc.tipocobranza, 
                      flc.totalamount, 
                      SYSDATE + 15, 
                      To_char(flc.creationdatetrx) 
                      || '|' 
                      || flc.totalamount, 
                      flc.referencenumber 
      FROM   xxfrv_facturasparalc flc 
      WHERE  flc.idbatch = idparbatch; 

      /** Actualizar las LINEA DE CAPTURA CON IDSeq **/ 
      UPDATE xxfr_linea_captura 
      SET    lineacaptura = Replace(lineacaptura, 'CODSEQING', 
                            Lpad(idlineacaptura, 9, '0')); 

      /*Actuaizar las lineas de captura sobre las facturas del batch*/ 
      INSERT INTO xxfr_linea_captura_factura 
                  (idfacturaprimavera, 
                   idlineacaptura) 
      SELECT flc.idfacturaprimavera, 
             lc.idlineacaptura 
      FROM   xxfrv_lc_factura flc 
             left outer join xxfr_linea_captura lc 
                          ON ( lineacaptura LIKE Substr(lc_calculada, 1, 13) 
                                                 ||'_________' 
                                                 ||Substr(lc_calculada, 23, 8) ) 
      WHERE  flc.idbatch = idparbatch; 

      DELETE FROM xxfr_linea_captura_factura 
      WHERE  idlineacaptura IS NULL; 

      UPDATE xxfr_cabecera_factura fac 
      SET    fac.idlineacaptura = (SELECT Min (flc.idlineacaptura) 
                                   FROM   xxfr_linea_captura_factura flc 
                                   WHERE 
             fac.idfacturaprimavera = flc.idfacturaprimavera) 
      WHERE  fac.idlineacaptura IS NULL 
             AND fac.idbatch = idparbatch; 

      -- Todo está okas hasta aquí, se asigna exitoso el proceso 
      UPDATE xxfr_estado_batch 
      SET    estado = 'EXITOSO', 
             finproceso = current_date 
      WHERE  idestadobatch = idestatdobatch; 

      proceso := '0'; 

      COMMIT; 

      RETURN proceso; -- Exitoso 
  EXCEPTION -- exception handlers begin 
    WHEN lanzarerrorparametro THEN 
               UPDATE xxfr_estado_batch 
               SET    estado = 'ERROR', 
                      finproceso = current_date 
               WHERE  idestadobatch = idestatdobatch; 

               RETURN errorparametro; 
  END xxfr_procesar_batch; 
  /* 
  Función que permite recuperar el digito verificador considerando la cuenta bancaría y la fecha de registro de la factura
  En caso de error regresará un código de 4 caracteres, ver referencia a las descriciones de errores en documento de
  --Catalogo de errores. 
  */ 
  FUNCTION Xxfr_digitoverificador(nombrebanco   IN VARCHAR2, 
                                  fechabase     IN VARCHAR2, 
                                  constante     IN VARCHAR2, 
                                  totalfactuado IN VARCHAR2, 
                                  referencia    IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    errorparametro    VARCHAR2(30) := ''; 
    digitoverificador VARCHAR2(8) := ''; 
    anhiobase         NUMBER := 0; 
    mesbase           NUMBER := 0; 
    diabase           NUMBER := 0; 
    fechabasetd       DATE; 
    fechacondensada   NUMBER; 
    importecondensada NUMBER; 
    lanzarerrorparametro EXCEPTION; 
  BEGIN 
      -- dbms_output.put_line('nombreBanco = ' || nombrebanco); 
      -- dbms_output.put_line('fechaBase = ' || fechabase); 
      fechabasetd := To_date(fechabase, 'YYYY-MM-DD'); 

      -- dbms_output.put_line('fechaBaseTD = ' || fechaBaseTD); 
      SELECT Extract(year FROM fechabasetd) 
      INTO   anhiobase 
      FROM   dual; 

      -- dbms_output.put_line('anhioBase = ' || anhiobase); 
      SELECT Extract(month FROM fechabasetd) 
      INTO   mesbase 
      FROM   dual; 

      SELECT Extract(day FROM fechabasetd) 
      INTO   diabase 
      FROM   dual; 

      /* 
      i) Al año se le resta el valor 2014 
      i) Al resultado de la resta se le multiplica por 372 
      ii) Al mes se le resta el valor 1 
      i) Al resultado de la resta se le multiplica por 31 
      iii) Al día se le resta el valor 1 
      iv) Se suman los valores resultantes (año, mes y día) y el resultado es la Nueva Fecha Condensada Base 2014
      */ 
      /* RESOLVIENDO - FECHA CONDENSADA 
      i) Al año se le resta el valor 2014BBVA o 2013BANORTE 
      i) Al resultado de la resta se le multiplica por 372*/ 
      CASE nombrebanco 
        WHEN descnombancobbva THEN 
          anhiobase := ( anhiobase - 2014 ) * 372; 
        WHEN descnombancobanorte THEN 
          anhiobase := ( anhiobase - 2013 ) * 372; 
        ELSE 
          errorparametro := 'ME-106'; 
      -- Error de datos : No corresponde a un banco valido 
      END CASE; 

      /* 
      ii) Al mes se le resta el valor 1 
      i) Al resultado de la resta se le multiplica por 31*/ 
      mesbase := ( mesbase - 1 ) * 31; 

      /* 
      iii) Al día se le resta el valor 1*/ 
      diabase := ( diabase - 1 ); 

      /* dbms_output.put_line('anhioBase = ' || anhiobase); 
      dbms_output.put_line('mesBase = ' || mesbase); 
      dbms_output.put_line('diaBase = ' || diabase); */ 
      /* 
      iv) Se suman los valores resultantes (año, mes y día) y el resultado es la Nueva Fecha Condensada Base 2014
      */ 
      fechacondensada := Lpad(( anhiobase + mesbase + diabase ), 4, '0'); 

      -- dbms_output.put_line('fechaCondensada = ' || fechacondensada); 
      -- dbms_output.put_line('digitoVerificador = ' || digitoverificador); 
      /* 
      IMPOrTE CONDENSADO 
      */ 
      -- Finalmente se divide po un facto base10 
      importecondensada := Calculaimpotecondensado (totalfactuado, nombrebanco); 

      -- dbms_output.put_line('fechacondensada = ' || fechacondensada); 
      -- dbms_output.put_line('importeCondensada = ' || importeCondensada); 
      -- dbms_output.put_line('constante = ' || constante); 
      digitoverificador := Codesumdv(referencia); 

      digitoverificador := Lpad(fechacondensada, 4, '0') 
                           || Lpad(importecondensada, 1, '0') 
                           || constante 
                           ||digitoverificador; 

      /* 
      DVs 
      */ 
      -- dbms_output.put_line('digitoverificador = ' || digitoverificador); 
      -- dbms_output.put_line('referencia = ' || referencia); 
      RETURN digitoverificador; 
  EXCEPTION -- exception handlers begin 
    WHEN lanzarerrorparametro THEN 
               RETURN errorparametro; 
  END xxfr_digitoverificador; 
  /* 
   CodeSum 
  */ 
  FUNCTION Codesumdv (referencia IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    verificationcodesum VARCHAR2(42); 
    digito              VARCHAR2(1); 
    acumula             NUMBER := 0; 
    pos                 NUMBER; 
    valopos             NUMBER; 
    residuo             NUMBER; 
  BEGIN 
      verificationcodesum := ''; 

      FOR pos IN 1..Length(referencia) LOOP 
          digito := Substr(referencia, pos, 1); 

          valopos := To_number(digito); 

          residuo := MOD(pos, 5); 

          IF ( residuo = 0 ) THEN 
            acumula := acumula + ( valopos * 13 ); 
          ELSIF ( residuo = 1 ) THEN 
            acumula := acumula + ( valopos * 11 ); 
          ELSIF ( residuo = 2 ) THEN 
            acumula := acumula + ( valopos * 23 ); 
          ELSIF ( residuo = 3 ) THEN 
            acumula := acumula + ( valopos * 19 ); 
          ELSE 
            acumula := acumula + ( valopos * 17 ); 
          END IF; 
      -- dbms_output.put_line('digito = ' || digito||',residuo = ' || residuo||',acumula = ' || acumula);
      END LOOP; 

      verificationcodesum := Lpad(( MOD(acumula, 97) ) + 1, 2, '0'); 

      RETURN verificationcodesum; 
  END codesumdv; 
  /* 
  Calcula el numero condesado de cantidad 
  */ 
  FUNCTION Numcondensado(numpocess IN NUMBER) 
  RETURN NUMBER 
  AS 
    numcadena VARCHAR2(11); 
    digito    VARCHAR2(1); 
    acumula   NUMBER := 0; 
    pos       NUMBER; 
    valopos   NUMBER; 
  BEGIN 
      numcadena := numpocess 
                   ||''; 

      FOR pos IN 1..Length(numcadena) LOOP 
          digito := Substr(numcadena, pos, 1); 

          valopos := To_number(digito); 

          acumula := acumula + valopos; 
      END LOOP; 

      RETURN acumula; 
  END numcondensado; 
  /* 
  Calcula los calculaImpoteCondensado 
  */ 
  FUNCTION Calculaimpotecondensado(totalfactuado IN VARCHAR2, 
                                   nombrebanco   IN VARCHAR2) 
  RETURN NUMBER 
  AS 
    ciclo             NUMBER := 0; 
    residuo           NUMBER := 0; 
    multiplicado      NUMBER := 0; 
    tamano            NUMBER := 0; 
    fechacondensada   NUMBER; 
    importecondensada NUMBER; 
    temporal          VARCHAR2(16); 
    lanzarerrorparametro EXCEPTION; 
    errorparametro    VARCHAR2(16); 
  BEGIN 
      -- dbms_output.put_line('nombrebanco = ' || nombrebanco); 
      importecondensada := 0; 

      tamano := Length (totalfactuado); 

      -- dbms_output.put_line(' totalFactuado = ' || totalFactuado); 
      FOR ciclo IN 0..12 LOOP 
          temporal := Substr(totalfactuado, ciclo + 1, 1); 

          residuo := MOD(ciclo, 3); 

          IF residuo = 0 THEN 
            multiplicado := 7; 
          ELSIF residuo = 1 THEN 
            multiplicado := 1; 
          ELSE 
            multiplicado := 3; 
          END IF; 

          -- dbms_output.put_line('*** ciclo:'||ciclo||',temporal = ' || temporal || ', residuo: '||residuo);
          -- dbms_output.put_line('multiplicando por = ' ||multiplicado); 
          CASE nombrebanco 
            WHEN descnombancobbva THEN 
              importecondensada := importecondensada 
                                   + Numcondensado((temporal * multiplicado)); 
            WHEN descnombancobanorte THEN 
              importecondensada := importecondensada + (( 
                                   temporal * multiplicado 
                                                        )); 
            ELSE 
              errorparametro := 'ME-106'; 
              -- Error de datos : No corresponde a un banco valido 

              RAISE lanzarerrorparametro; 
          END CASE; 

          importecondensada := MOD (importecondensada, 10); 
      --  dbms_output.put_line(' importeCondensada = ' || importeCondensada); 
      END LOOP; 

      -- dbms_output.put_line(' importeCondensada = ' || importeCondensada); 
      RETURN importecondensada; 
  EXCEPTION 
    WHEN lanzarerrorparametro THEN 
               RETURN errorparametro; 
  END calculaimpotecondensado; 
  /* 
  Busca el total de la linea 
  */ 
  FUNCTION Totallc(pidbatch        IN VARCHAR2, 
                   pcontractnumber IN VARCHAR2, 
                   pdivisiontype   IN VARCHAR2, 
                   pprojectid      IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    total VARCHAR2(13) := ''; 
    lanzarerrorparametro EXCEPTION; 
  BEGIN 
      SELECT SUM (Nvl (totalamount, 0)) 
      INTO   total 
      FROM   xxfrv_facturasparalc 
      WHERE  ROWNUM = 1 
             AND tipocobranza = 'LINEA CAPTURA' 
             AND idbatch = pidbatch 
             AND contractnumber = pcontractnumber 
             AND divisiontype = pdivisiontype 
             AND projectid = pprojectid 
      GROUP  BY idbatch, 
                contractnumber, 
                grouptype; 

      total := Lpad(( total ), 13, '0'); 

      RETURN total; 
  EXCEPTION 
    WHEN no_data_found THEN 
               RETURN Lpad ('0', 13, '0'); 
  END totallc; 
  /* 
    Busca el total de la linea 
    */ 
  FUNCTION Fechalc(pidbatch        IN VARCHAR2, 
                   pcontractnumber IN VARCHAR2, 
                   pdivisiontype   IN VARCHAR2, 
                   pprojectid      IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    fechatx VARCHAR2(13) := ''; 
    lanzarerrorparametro EXCEPTION; 
  BEGIN 
      SELECT Min (Nvl (creationdatetrx, 0)) 
      INTO   fechatx 
      FROM   xxfrv_facturasparalc 
      WHERE  ROWNUM = 1 
             AND tipocobranza = 'LINEA CAPTURA' 
             AND idbatch = pidbatch 
             AND contractnumber = pcontractnumber 
             AND divisiontype = pdivisiontype 
             AND projectid = pprojectid 
      GROUP  BY idbatch, 
                contractnumber, 
                grouptype; 

      RETURN fechatx; 
  EXCEPTION 
    WHEN no_data_found THEN 
               RETURN '2014-01-01'; 
  END fechalc; 
  /* 
    Busca el total de la linea 
    */ 
  FUNCTION Referencialc(pidbatch        IN VARCHAR2, 
                        pcontractnumber IN VARCHAR2, 
                        pdivisiontype   IN VARCHAR2, 
                        pprojectid      IN VARCHAR2) 
  RETURN VARCHAR2 
  AS 
    referencetx VARCHAR2(16) := ''; 
    lanzarerrorparametro EXCEPTION; 
  BEGIN 
      SELECT Min (Nvl (referencenumber, 0)) 
      INTO   referencetx 
      FROM   xxfrv_facturasparalc 
      WHERE  ROWNUM = 1 
             AND tipocobranza = 'LINEA CAPTURA' 
             AND idbatch = pidbatch 
             AND contractnumber = pcontractnumber 
             AND divisiontype = pdivisiontype 
             AND projectid = pprojectid 
      GROUP  BY idbatch, 
                contractnumber, 
                grouptype; 

      RETURN referencetx; 
  EXCEPTION 
    WHEN no_data_found THEN 
               RETURN Lpad ('0', 16 - 1, '0'); 
  END referencialc; 
END xxfr_ingresos_lc; 