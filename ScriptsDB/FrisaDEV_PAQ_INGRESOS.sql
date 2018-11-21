--PAQUETE INGRESOS--
CREATE OR replace PACKAGE xxfr_ingresos_lc 
AS  
  FUNCTION Xxfr_ingresos_cuenta_facturas ( 
    entrada IN VARCHAR2 ) 
  RETURN NUMBER; 
  FUNCTION Xxfr_ingresos_recupera_fac ( 
    entrada IN VARCHAR2 ) 
  RETURN XXFR_FACTURA_TABLE; 
  FUNCTION Xxfr_generarlc ( 
    division         IN VARCHAR2, 
    proyecto         IN NUMBER, 
    contrato         IN NUMBER, 
    lineacapturain   IN VARCHAR2, 
    nombrebanco      IN VARCHAR2, 
    fechatransaccion IN VARCHAR2, 
    totalfactuado    IN VARCHAR2, 
    referencia       IN VARCHAR2 ) 
  RETURN VARCHAR2; 
  FUNCTION Xxfr_procesar_batch ( 
    idparbatch VARCHAR2 ) 
  RETURN VARCHAR2; 
  FUNCTION Xxfr_id_lc ( 
    val1 NUMBER ) 
  RETURN VARCHAR2; 
  FUNCTION Xxfr_digitoverificador ( 
    nombrebanco   IN VARCHAR2, 
    fechabase     IN VARCHAR2, 
    constante     IN VARCHAR2, 
    totalfactuado IN VARCHAR2, 
    referencia    IN VARCHAR2 ) 
  RETURN VARCHAR2; 
  FUNCTION Numcondensado( 
    numpocess IN NUMBER) 
  RETURN NUMBER; 
  FUNCTION Calculaimpotecondensado( 
    totalfactuado IN VARCHAR2, 
    nombrebanco   IN VARCHAR2) 
  RETURN NUMBER; 
  FUNCTION Totallc( 
    pidbatch        IN VARCHAR2, 
    pcontractnumber IN VARCHAR2, 
    pdivisiontype   IN VARCHAR2, 
    pprojectid      IN VARCHAR2) 
  RETURN VARCHAR2; 
  FUNCTION Codesumdv ( 
    referencia IN VARCHAR2) 
  RETURN VARCHAR2; 
  FUNCTION Fechalc( 
    pidbatch        IN VARCHAR2, 
    pcontractnumber IN VARCHAR2, 
    pdivisiontype   IN VARCHAR2, 
    pprojectid      IN VARCHAR2 ) 
  RETURN VARCHAR2; 
  FUNCTION Referencialc( 
    pidbatch        IN VARCHAR2, 
    pcontractnumber IN VARCHAR2, 
    pdivisiontype   IN VARCHAR2, 
    pprojectid      IN VARCHAR2 ) 
  RETURN VARCHAR2; 
END xxfr_ingresos_lc; 