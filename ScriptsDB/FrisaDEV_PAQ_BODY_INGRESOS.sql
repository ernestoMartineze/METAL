create or replace PACKAGE BODY xxfr_ingresos_lc
AS
  tot_fact xxfr_lc_table;
  descNomBancoBBVA VARCHAR2(30) := 'BBVA Bancomer, S.A.';
    descNomBancoBANORTE VARCHAR2(30) := 'BANORTE, S.A.';
  --tot_depts XXFR_FACTURA_TABLE;
  /*Función Contar Facturas*/
  FUNCTION xxfr_ingresos_cuenta_facturas(
      entrada IN VARCHAR2 )
    RETURN NUMBER
  AS
    facturas NUMBER;
  BEGIN
    SELECT COUNT(*)
    INTO facturas
    FROM ingresos.xxfr_cabecera_factura
    WHERE xxfr_cabecera_factura.idbatch = xxfr_ingresos_cuenta_facturas.entrada;
    dbms_output.put_line('Facturas = ' || facturas);
    RETURN facturas;
  END xxfr_ingresos_cuenta_facturas;
/*Función Recuperar Facturas*/
  FUNCTION xxfr_ingresos_recupera_fac(
      entrada IN VARCHAR2 )
    RETURN xxfr_factura_table
  IS
    facturas xxfr_factura_table;
  BEGIN
    SELECT xxfr_factura_rec(idfacturaprimavera, contractnumber, grouptype) BULK COLLECT
    INTO facturas
    FROM ingresos.xxfr_cabecera_factura
    WHERE xxfr_cabecera_factura.idbatch = xxfr_ingresos_recupera_fac.entrada
    AND tipocobranza                    = 'LINEA CAPTURA'
    AND transactiontype                 = 'FAC_INGRESOS_MN';
    RETURN facturas;
  END xxfr_ingresos_recupera_fac;
/*ID Código de Línea de Captura*/
  FUNCTION xxfr_id_lc(
      val1 NUMBER )
    RETURN VARCHAR2
  IS
    idlc VARCHAR2(20);
  BEGIN
    SELECT lpad(ingresos.xxfr_ingresos_id_lc.nextval, 9, '0') INTO idlc FROM dual;
    RETURN idlc;
  END xxfr_id_lc;
/*ARMADO DE LC*/
  FUNCTION xxfr_forma_lc(
      idbatch IN VARCHAR2 )
    RETURN xxfr_lc_table
  IS
    idlc xxfr_lc_table;
  BEGIN
    -------
    SELECT xxfr_lc_rec(transactionsource, projectid, --Estos deberían ser 3 y no 4
      contractnumber                                 --estos deberían ser 8, sólo tengo 3
      ) BULK COLLECT
    INTO tot_fact
    FROM xxfr_cabecera_factura
    WHERE idbatch = xxfr_forma_lc.idbatch;
    -------SELECT COUNT(*) INTO idlc FROM XXFR_FORMA_LC.tot_fact;
    /*RECUPERA ID DE LC  -- OK*/
    /*ARMA LC*/
    /*INSERTA LC*/
    RETURN NULL;
  END xxfr_forma_lc;
--Fin--
  FUNCTION xxfr_generarlc(
      division         IN VARCHAR2,
      proyecto         IN NUMBER,
      contrato         IN NUMBER,
      lineacapturain   IN VARCHAR2,
      nombrebanco      IN VARCHAR2,
      fechatransaccion IN VARCHAR2,
      totalFactuado    IN VARCHAR2,
      referencia    IN VARCHAR2 )
      RETURN VARCHAR2
  AS
    lineacaptura         VARCHAR2(30) := '';
    errorparametro       VARCHAR2(30) := '';
    lanzarerrorparametro EXCEPTION;
    proyectotxt          VARCHAR2(3) := '';
    contratotxt          VARCHAR2(8) := '';
    importefechadv       VARCHAR2(9);        --importeFechaVigenciaVerificador
    CONSTANTE_BANCO      VARCHAR2(1) := '2'; --Constante fijo del banco paa el calculo del digito V
  BEGIN                                      --importeFechaVigenciaVerificador
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
    errorparametro     := NVL(division, '101');
    IF ( errorparametro = '101' ) THEN
      RAISE lanzarerrorparametro;
    END IF;
    -- dbms_output.put_line('lineaCapturaP= ' || lineacaptura);
    /*Proyecto sea de 3 digitos, de lo contrario se regresa error
    **102 - Error de datos de entrada : Digitos del Proyecto no es valido, deben ser 3 digitos*/
    errorparametro     := NVL(proyecto, '102');
    IF ( errorparametro = '102' ) THEN
      RAISE lanzarerrorparametro;
    ELSE --Convertir proyecto a cadena 3 digitos
      proyectotxt := lpad(proyecto, 3, '0');
    END IF;
    /*Exista un contrato, de lo contrario se regresa error
    **103 - Error de datos de entrada : Numero de contrato no es valido, deben ser diferente de nulo*/
    errorparametro     := NVL(contrato, '103');
    IF ( errorparametro = '103' ) THEN
      RAISE lanzarerrorparametro;
    ELSE --Convertir contrato a cadena 8 digitos
      contratotxt := lpad(contrato, 8, '0');
    END IF;
    -- dbms_output.put_line('contratoTxt= ' || contratotxt);
    /*Exista línea de captura, de lo contrario se regresa error
    **104 - Error de datos de entrada : Numero de contrato no es valido, deben ser diferente de nulo*/
    errorparametro     := NVL(lineacapturain, '104');
    IF ( errorparametro = '104' ) THEN
      RAISE lanzarerrorparametro;
    END IF;
    -- dbms_output.put_line('lineaCapturaL= ' || lineacaptura);
    /*importeFechaDV sea de 8 digitos, de lo contrario se regresa error
    **105 - Error de datos de entrada : el importe, fecha de vigencia y digito verificador no es valido, deben ser de 8 digitos*/
    errorparametro     := NVL(nombrebanco, '105');
    IF ( errorparametro = '105' ) THEN
      RAISE lanzarerrorparametro;
    ELSE
      errorparametro     := NVL(fechatransaccion, '105');
      IF ( errorparametro = '105' ) THEN
        RAISE lanzarerrorparametro;
      END IF;
    END IF;
    -- constante del banco
      -- to_date (fechatransaccion)
    importefechadv := xxfr_digitoverificador(nombrebanco, fechatransaccion,CONSTANTE_BANCO, nvl(totalFactuado,''), NVL(referencia,''));
    -- dbms_output.put_line('lineaCapturaI= ' || lineacaptura);
    /* Procesar parametros y formar codigo de la LC
    */
    lineacaptura := ( division || proyectotxt || contratotxt || lineacapturain || importefechadv );
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
  FUNCTION xxfr_procesar_batch(
      idParBatch IN VARCHAR2 )
    -- Lanzar actualización del estatus a las
    RETURN VARCHAR2
  AS
    errorparametro       VARCHAR2(30) := '';
    lanzarerrorparametro EXCEPTION;
    proceso              VARCHAR2(3) := '100'; --El valor 100 corresponde a un error de infraestructura siempre y cuando el proceso genere una excepción no manejada
    idValido number :=  0;
    idEstatdoBatch number :=  0;
    numLCVencidas NUMBER := 0;
  BEGIN
    --dbms_output.put_line(' Inicia funcion XXFR_PROCESAR_BATCH Valores de entrada ');
    select count(*) INTO idValido FROM XXFR_CABECERA_FACTURA 
    WHERE idbatch = idParBatch;
    --dbms_output.put_line(' idValido '||idValido);
    if idValido = 0 then 
    errorparametro :=  '107';
      insert into XXFR_ESTADO_BATCH (IDBATCH ,ESTADO ,INICIOPROCESO) values (idParBatch, 'ERROR-107', current_date);
      RAISE lanzarerrorparametro;
    end if;
    -- Insertar la bitácora del proceso de generación de LC
     insert into XXFR_ESTADO_BATCH ( IDBATCH ,ESTADO ,INICIOPROCESO) values (idParBatch, 'PROCESO', current_date);
    select max(IDESTADOBATCH) into idEstatdoBatch from XXFR_ESTADO_BATCH where idbatch = idParBatch;
    
    errorparametro := '100';
    INSERT
    INTO XXFR_LINEA_CAPTURA
      (
        LINEACAPTURA,
        FECHACREACION,
        ESTATUSLC,
        BANCO,
        DIVISION,
        CENTROCOSTOSPROYECTO,
        TIPOCOBRANZA,
        MONTOLINEACAPTURA,
        FECHAVIGENCIA,
        LINEACAPTURAREF,
        REFERENCIA
      )
    SELECT distinct xxfr_ingresos_lc.xxfr_generarlc(flc.divisiontype, flc.PROJECTID, flc.contractnumber, 'CODSEQING',flc.BANKNAME, to_char(flc.CREATIONDATETRX), flc.TOTALAMOUNT, flc.REFERENCENUMBER) LC,
      CURRENT_DATE,
      'ACTIVO',
      flc.BANKNAME,
      flc.divisiontype,
      flc.PROJECTID,
      flc.tipocobranza,
      flc.TOTALAMOUNT,
      XXFRP_FECHA.FECHA_FIN_VIGENCIA(current_date , 15) FECHAVIGENCIA,
      to_char(flc.CREATIONDATETRX)|| '|'|| flc.TOTALAMOUNT,
      flc.REFERENCENUMBER
    FROM XXFRV_FacturasParaLC flc
    WHERE flc.idbatch = idParBatch;
    
    /** Actualizar las LINEA DE CAPTURA CON IDSeq **/
    UPDATE XXFR_LINEA_CAPTURA
    SET lineaCaptura = REPLACE(lineaCaptura,'CODSEQING',lpad(idLineaCaptura,9,'0'));
    
    
    /*Actuaizar las lineas de captura sobre las facturas del batch*/
    insert into XXFR_LINEA_CAPTURA_FACTURA ( idfacturaprimavera, idlineacaptura, CS_ESTATUS )
    select  flc.IDFACTURAPRIMAVERA, lc.idlineacaptura, 1
        from xxfrv_lc_factura flc left outer join xxfr_linea_captura lc 
          on (lineacaptura like  substr(lc_calculada,1,13)||'_________'||substr(lc_calculada,23,8))
          where flc.IDBATCH = idParBatch;
          
    
    /* Actualizar los Identificadores de lineas de captura VIGENTES para cada una de las facturas Primavera
    */
    UPDATE XXFR_CABECERA_FACTURA fac
    SET fac.idlineacaptura =
      (SELECT max (flc.idlineacaptura)
      FROM XXFR_LINEA_CAPTURA_FACTURA flc
      WHERE fac.idfacturaprimavera = flc.idfacturaprimavera and flc.cs_estatus = 1
      )
    WHERE fac.idlineacaptura IS NULL
    AND fac.idbatch           = idParBatch;
    -- Todo está okas hasta aquí, se asigna exitoso el proceso
    update XXFR_ESTADO_BATCH Set ESTADO ='EXITOSO' , finproceso = current_date where idestadobatch = idEstatdoBatch ;
    
    /*
      Procesar lineas de captura que esten VENCIDAS, generar nueva LC
        --1.Clonar lineas de captura vencidadas xxfr_linea_captura
        --2.Recalcular la linea de captura clonada con su correspondiente ID y fecha de vigencia
        --3.Actualizar id linea de captura en cabecera
        --4.Actualizar las linea de captura Vs idFacPimavera a 0:Inactivas e insertar nuevas... en LineaCaptura_Factura
        --5.Actualizar en linea_Captura el Estatus de Activo a Inactivo.(Eliminar el campo)
    
    Previo verificar si existen para el idBatch lineas de captura vencidas    
    */
    select count(*) into numLCVencidas from XXFR_LINEA_CAPTURA where FECHAVIGENCIA < current_date and numeroRecibo is null
        and IDLINEACAPTURA in
        (select lc.IDLINEACAPTURA
         from xxfr_cabecera_factura lc where lc.IDLINEACAPTURA is not null and lc.IDBATCH = idParBatch) ;
    if numLCVencidas>0 then 
        errorparametro := procesarLC_Vencidadas(idParBatch);
        if (errorparametro != '') then -- Si hay algun error en el proceso de LC vencidas, lanzar roll back y manejo de exception
          RAISE lanzarerrorparametro;
        end if;
    end if;
    
    proceso := '0';
    --6.Commit
    COMMIT;
    RETURN proceso; -- Exitoso
  EXCEPTION         -- exception handlers begin
  WHEN lanzarerrorparametro THEN 
   -- Deshacer todos los cambios del procesamiento del Batch
    rollback;
    --Insertar estatus del proceso
      insert into XXFR_ESTADO_BATCH (IDBATCH ,ESTADO ,INICIOPROCESO, finproceso) 
              values (idParBatch, 'ERROR-'||errorparametro, current_date, current_date);
    commit;
    RETURN errorparametro;
  END xxfr_procesar_batch;
  
  function procesarLC_Vencidadas (pIdBatch IN VARCHAR2) return varchar2
  as
    errorparametro       VARCHAR2(30) := '';
    proceso VARCHAR2(3):= '';
    lanzarerrorparametro EXCEPTION;
  Begin
             
        --1.Clonar lineas de captura vencidadas xxfr_linea_captura  y fecha de vigencia
        Insert into XXFR_LINEA_CAPTURA (
        LINEACAPTURAREF,
        SISTEMAORIGEN,
        LINEACAPTURA,
        REFERENCIA,
        FECHACREACION,
        FECHAVIGENCIA,
        MONTOLINEACAPTURA,
        ESTATUSLC,
        BANCO,
        CUENTABANCARIA,
        ENTIDADLEGAL,
        UNIDADNEGOCIO,
        DIVISION,
        CENTROCOSTOSPROYECTO,
        NUMERORECIBO,
        TIPOCOBRANZA,
        FOLIOACUERDOCOBRANZA,
        MONTOACUERDOCOBRANZA,
        INTERESMORATORIOCONDONADO,
        ORDINARIOCONDONADO,
        CAPITALRENTACONDONADA
        )
        select LINEACAPTURAREF,
        SISTEMAORIGEN,
        substr(LINEACAPTURA,1,13)||'CODSEQING'||substr(LINEACAPTURA,23,8) LINEACAPTURA,
        REFERENCIA,
        current_date FECHACREACION,
        XXFRP_FECHA.FECHA_FIN_VIGENCIA(current_date , 15) FECHAVIGENCIA,
        MONTOLINEACAPTURA,
        'PROCESANDO',
        BANCO,
        CUENTABANCARIA,
        ENTIDADLEGAL,
        UNIDADNEGOCIO,
        DIVISION,
        CENTROCOSTOSPROYECTO,
        NUMERORECIBO,
        TIPOCOBRANZA,
        FOLIOACUERDOCOBRANZA,
        MONTOACUERDOCOBRANZA,
        INTERESMORATORIOCONDONADO,
        ORDINARIOCONDONADO,
        CAPITALRENTACONDONADA from XXFR_LINEA_CAPTURA where FECHAVIGENCIA < current_date and numeroRecibo is null
        and IDLINEACAPTURA in
        (select lc.IDLINEACAPTURA
         from xxfr_cabecera_factura lc where lc.IDLINEACAPTURA is not null and lc.IDBATCH = pIdBatch);
         
         
         
        --2.Recalcular la linea de captura clonada con su correspondiente ID
        UPDATE XXFR_LINEA_CAPTURA
            SET lineaCaptura = REPLACE(lineaCaptura,'CODSEQING',lpad(idLineaCaptura,9,'0')) where ESTATUSLC = 'PROCESANDO';
        --4.Actualizar las linea de captura Vs idFacPimavera a 0:Inactivas e insertar nuevas... en LineaCaptura_Factura
        update XXFR_LINEA_CAPTURA_FACTURA lcf set CS_ESTATUS = 0 where lcf.IDLINEACAPTURA in
        (select lc.IDLINEACAPTURA
         from XXFR_LINEA_CAPTURA lc where lc.FECHAVIGENCIA < current_date and lc.numeroRecibo is null and lc.IDLINEACAPTURA in
        (select cf.IDLINEACAPTURA
         from xxfr_cabecera_factura cf where cf.IDLINEACAPTURA is not null and cf.IDBATCH = pIdBatch));
         -- Registrar las nuevas lineas a facturas
         Insert into XXFR_LINEA_CAPTURA_FACTURA (IDFACTURAPRIMAVERA,
        IDLINEACAPTURA,
        CS_ESTATUS)
         select lcf.idFacturaPrimavera,  (select max(idLineaCaptura) from XXFR_LINEA_CAPTURA lcInt where lcInt.lineaCaptura like  substr(lcJoin.lineaCaptura,1,13)||'_________'||substr(lcJoin.lineaCaptura,23,8) ) idLineaCapturaMax 
         , 1 Estatus
         from XXFR_LINEA_CAPTURA_FACTURA lcf 
         
          left outer join XXFR_LINEA_CAPTURA lcJoin on ( lcf.IDLINEACAPTURA =  lcJoin.IDLINEACAPTURA)
         where lcf.IDLINEACAPTURA in
        (select lc.IDLINEACAPTURA
         from XXFR_LINEA_CAPTURA lc where lc.FECHAVIGENCIA < current_date and lc.numeroRecibo is null and lc.IDLINEACAPTURA in
        (select cf.IDLINEACAPTURA
         from xxfr_cabecera_factura cf where cf.IDLINEACAPTURA is not null and cf.IDBATCH = pIdBatch));
        --5.Actualizar en linea_Captura el Estatus de Activo a Inactivo.(Eliminar el campo)    
         
        --2.Recalcular la linea de captura clonada con su correspondiente ID
        UPDATE XXFR_LINEA_CAPTURA
            SET ESTATUSLC = 'VENCIDA' 
            where FECHAVIGENCIA < current_date and numeroRecibo is null;   
            
        --3.Actualizar id linea de captura en cabecera
        
        update xxfr_cabecera_factura fac 
         Set fac.IDLINEACAPTURA =
        (select max(lc.IDLINEACAPTURA)
         from XXFR_LINEA_CAPTURA_FACTURA lc where lc.CS_ESTATUS=1 and  fac.IDFACTURAPRIMAVERA = lc.IDFACTURAPRIMAVERA)
        where fac.idbatch           = pIdBatch;
        -- Finalmente asignar activas las LC nuevas por LCVencidas
        UPDATE XXFR_LINEA_CAPTURA
            SET ESTATUSLC = 'ACTIVO' 
            where ESTATUSLC =  'PROCESANDO'; 
            
      RETURN proceso; -- Exitoso
  EXCEPTION         -- exception handlers begin
  WHEN lanzarerrorparametro THEN   
    RETURN '108';
  END procesarLC_Vencidadas;
  
/*
Función que permite recuperar el digito verificador considerando la cuenta bancaría y la fecha de registro de la factura
En caso de error regresará un código de 4 caracteres, ver referencia a las descriciones de errores en documento de
--Catalogo de errores.
*/
  FUNCTION xxfr_digitoverificador(
      nombrebanco   IN VARCHAR2,
      fechabase     IN VARCHAR2 ,
      constante     IN VARCHAR2,
      totalFactuado IN VARCHAR2,
      referencia IN VARCHAR2
      )
    RETURN VARCHAR2
  AS
    errorparametro       VARCHAR2(30) := '';
    digitoverificador    VARCHAR2(8)  := '';
    anhiobase            NUMBER       := 0;
    mesbase              NUMBER       := 0;
    diabase              NUMBER       := 0;
    fechaBaseTD              date;
    
    fechacondensada      NUMBER;
    importeCondensada    NUMBER;
    lanzarerrorparametro EXCEPTION;
  BEGIN
    -- dbms_output.put_line('nombreBanco = ' || nombrebanco);
    -- dbms_output.put_line('fechaBase = ' || fechabase);
    fechaBaseTD := to_date( fechabase, 'YYYY-MM-DD');
    -- dbms_output.put_line('fechaBaseTD = ' || fechaBaseTD);
    SELECT EXTRACT(YEAR FROM fechaBaseTD)
    INTO anhiobase
    FROM dual;
    -- dbms_output.put_line('anhioBase = ' || anhiobase);
    SELECT EXTRACT(MONTH FROM fechaBaseTD)
    INTO mesbase
    FROM dual;
    SELECT EXTRACT(DAY FROM fechaBaseTD) INTO diabase FROM dual;
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
    WHEN descNomBancoBBVA THEN
      anhiobase := ( anhiobase - 2014 ) * 372;
    WHEN descNomBancoBANORTE THEN
      anhiobase := ( anhiobase - 2013 ) * 372;
    ELSE
      errorparametro := 'ME-106'; -- Error de datos : No corresponde a un banco valido
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
    fechacondensada := lpad((anhiobase + mesbase + diabase), 4, '0');
    -- dbms_output.put_line('fechaCondensada = ' || fechacondensada);
    -- dbms_output.put_line('digitoVerificador = ' || digitoverificador);
    /*
    IMPOrTE CONDENSADO
    */
    -- Finalmente se divide po un facto base10
    importeCondensada := calculaImpoteCondensado (totalFactuado, nombrebanco) ;
    -- dbms_output.put_line('fechacondensada = ' || fechacondensada);
    -- dbms_output.put_line('importeCondensada = ' || importeCondensada);
    -- dbms_output.put_line('constante = ' || constante);
    digitoverificador := codeSumDV(referencia);
    digitoverificador := lpad(fechacondensada, 4, '0') || lpad(importeCondensada, 1, '0') || constante ||digitoverificador;
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
  FUNCTION codeSumDV (referencia IN VARCHAR2) RETURN VARCHAR2 AS
  
  verificationCodeSum VARCHAR2(42);
    digito    VARCHAR2(1);
    acumula   NUMBER := 0;
    pos       NUMBER;
    valoPos   NUMBER;
    residuo NUMBER;
    
  begin
  
  verificationCodeSum := '';
  
    FOR pos IN 1..length(referencia)
    LOOP
      digito  := SUBSTR(referencia,pos,1);
      
      valoPos := TO_NUMBER(digito);
      residuo := mod(pos, 5);
      
      if (residuo= 0) then
				acumula := acumula + (valoPos * 13);
			 elsif (residuo= 1) then
				acumula := acumula + (valoPos * 11);
			 elsif (residuo= 2) then
				acumula := acumula + (valoPos * 23);
			 elsif (residuo= 3) then
				acumula := acumula + (valoPos * 19);
			 else 
				acumula := acumula + (valoPos * 17);
			end if;
      -- dbms_output.put_line('digito = ' || digito||',residuo = ' || residuo||',acumula = ' || acumula);
      
    END LOOP;
    verificationCodeSum := lpad((mod(acumula , 97)) + 1,2,'0');
		
    RETURN verificationCodeSum;
  end codeSumDV;
  
  
  /*
  Calcula el numero condesado de cantidad
  */
  
  FUNCTION numCondensado(
      numPocess IN NUMBER)
    RETURN NUMBER
  AS
    numCadena VARCHAR2(11);
    digito    VARCHAR2(1);
    acumula   NUMBER := 0;
    pos       NUMBER;
    valoPos   NUMBER;
  BEGIN
    numCadena:= numPocess||'';
    FOR pos IN 1..length(numCadena)
    LOOP
      digito  := SUBSTR(numCadena,pos,1);
      valoPos := TO_NUMBER(digito);
      acumula := acumula + valoPos;
    END LOOP;
    RETURN acumula;
  END numCondensado;
/*
Calcula los calculaImpoteCondensado
*/
  FUNCTION calculaImpoteCondensado(
      totalFactuado IN VARCHAR2,
      nombrebanco   IN VARCHAR2)
    RETURN NUMBER
  AS
    ciclo             NUMBER := 0;
    residuo           NUMBER := 0;
    multiplicado      NUMBER := 0;
    tamano            NUMBER := 0;
    fechacondensada   NUMBER;
    importeCondensada NUMBER;
    temporal          VARCHAR2(16);
    lanzarerrorparametro    EXCEPTION;
    errorparametro    VARCHAR2(16);
  BEGIN
    -- dbms_output.put_line('nombrebanco = ' || nombrebanco);
    importeCondensada := 0;
    tamano            := LENGTH (totalFactuado);
    -- dbms_output.put_line(' totalFactuado = ' || totalFactuado);
    FOR ciclo IN 0..12
    LOOP
      temporal       := SUBSTR(totalFactuado,ciclo+1,1);
      residuo        := MOD(ciclo, 3);
      
      IF residuo      = 0 THEN
        multiplicado := 7;
      elsif residuo   = 1 THEN
        multiplicado := 1;
      ELSE
        multiplicado := 3;
      END IF;
      
      -- dbms_output.put_line('*** ciclo:'||ciclo||',temporal = ' || temporal || ', residuo: '||residuo);
      -- dbms_output.put_line('multiplicando por = ' ||multiplicado);
      
      CASE nombrebanco
      WHEN descNomBancoBBVA THEN
        importeCondensada := importeCondensada + numCondensado((temporal * multiplicado));
      WHEN descNomBancoBANORTE THEN
        importeCondensada := importeCondensada + ((temporal * multiplicado));
      ELSE
        errorparametro := 'ME-106'; -- Error de datos : No corresponde a un banco valido
        RAISE lanzarerrorparametro;
      END CASE;
      importeCondensada :=  mod (importeCondensada , 10);
      --  dbms_output.put_line(' importeCondensada = ' || importeCondensada);
    END LOOP;
    -- dbms_output.put_line(' importeCondensada = ' || importeCondensada);
    RETURN importeCondensada;
  EXCEPTION
  WHEN lanzarerrorparametro THEN
    RETURN errorparametro;
  END calculaImpoteCondensado;
  
  /*
  Busca el total de la linea
  */
  function totalLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2
  ) RETURN VARCHAR2 as
  
  total            VARCHAR2(13) := '';
  lanzarerrorparametro Exception;
  begin
  
  
    Select sum (nvl (TOTALAMOUNT,0)) into total from XXFRV_FACTURASPARALC
    WHERE rownum = 1 and  tipocobranza                    = 'LINEA CAPTURA'
    and IdBatch =  pIdBatch 
        and contractnumber  = pContractnumber
    and divisiontype   =  pDivisiontype
    and projectid   =  pProjectid
    group by idbatch,contractnumber,grouptype
    ;
    
    
     total := lpad((total), 13, '0' );
    
          RETURN  total;
   EXCEPTION
       WHEN NO_DATA_FOUND THEN
    RETURN lpad ('0',13,'0');
  end totalLC;

/*
  Busca el total de la linea
  */
  function fechaLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2
  ) RETURN VARCHAR2 as
  
  fechaTX            VARCHAR2(13) := '';
  lanzarerrorparametro Exception;
  begin
  
  
    Select min (nvl (CREATIONDATETRX,0)) into fechaTX from XXFRV_FACTURASPARALC
    WHERE rownum = 1 and  tipocobranza                    = 'LINEA CAPTURA'
    and IdBatch =  pIdBatch 
        and contractnumber  = pContractnumber
    and divisiontype   =  pDivisiontype
    and projectid   =  pProjectid
    group by idbatch,contractnumber,grouptype
    ;
    
          RETURN  fechaTX;
   EXCEPTION
       WHEN NO_DATA_FOUND THEN
    RETURN '2014-01-01';
  end fechaLC;


/*
  Busca el total de la linea
  */
  function referenciaLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2
  ) RETURN VARCHAR2 as
  
  referenceTX            VARCHAR2(16) := '';
  lanzarerrorparametro Exception;
  begin
  
  
    Select min (nvl (REFERENCENUMBER,0)) into referenceTX from XXFRV_FACTURASPARALC
    WHERE rownum = 1 and  tipocobranza                    = 'LINEA CAPTURA'
    and IdBatch =  pIdBatch 
        and contractnumber  = pContractnumber
    and divisiontype   =  pDivisiontype
    and projectid   =  pProjectid
    group by idbatch,contractnumber,grouptype;
    
          RETURN  referenceTX;
   EXCEPTION
       WHEN NO_DATA_FOUND THEN
    RETURN lpad ('0',16-1,'0');
  end referenciaLC;

  
END xxfr_ingresos_lc;
