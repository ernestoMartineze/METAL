create or replace PACKAGE xxfr_ingresos_lc AS /**/
    FUNCTION xxfr_ingresos_cuenta_facturas (
        entrada IN   VARCHAR2
    ) RETURN NUMBER;

    FUNCTION xxfr_ingresos_recupera_fac (
        entrada IN   VARCHAR2
    ) RETURN xxfr_factura_table;

    FUNCTION xxfr_generarlc (
        division           IN                 VARCHAR2,
        proyecto           IN                 NUMBER,
        contrato           IN                 NUMBER,
        lineacapturain     IN                 VARCHAR2,
        nombrebanco        IN                 VARCHAR2,
        fechatransaccion   IN                 VARCHAR2,
        totalFactuado   IN                 VARCHAR2,
      referencia    IN VARCHAR2 
    ) RETURN VARCHAR2;

    FUNCTION xxfr_procesar_batch (
        idParBatch VARCHAR2
    ) RETURN VARCHAR2;

    FUNCTION xxfr_id_lc (
        val1 NUMBER
    ) RETURN VARCHAR2;

    FUNCTION xxfr_digitoverificador (
        nombrebanco   IN            VARCHAR2,
        fechabase     IN            VARCHAR2,
        constante IN VARCHAR2,
        totalFactuado IN VARCHAR2,
        referencia IN VARCHAR2
    ) RETURN VARCHAR2;

function numCondensado(numPocess IN number) return number;
FUNCTION calculaImpoteCondensado(
      totalFactuado IN VARCHAR2,
      nombrebanco   IN VARCHAR2)
    RETURN NUMBER;
function totalLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2) RETURN VARCHAR2;
FUNCTION codeSumDV (referencia IN VARCHAR2) RETURN VARCHAR2;

function fechaLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2
  ) RETURN VARCHAR2;
  
  function referenciaLC(pIdBatch IN VARCHAR2,
   pContractnumber  IN VARCHAR2,
   pDivisiontype  IN VARCHAR2,
   pProjectid  IN VARCHAR2
  ) RETURN VARCHAR2;

function procesarLC_Vencidadas (pIdBatch IN VARCHAR2) return varchar2;

END xxfr_ingresos_lc;
