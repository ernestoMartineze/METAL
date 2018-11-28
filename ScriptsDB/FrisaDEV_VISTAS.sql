/*VISTA BÚSQUEDA DE LINEAS DE CAPTURA*/
CREATE OR REPLACE FORCE EDITIONABLE VIEW "INGRESOS"."XXFRV_CONSULTA_LC" ("IDLINEACAPTURA", "LINEACAPTURAREF", "SISTEMAORIGEN", "LINEACAPTURA", "REFERENCIA", "FECHACREACION", "FECHAVIGENCIA", "MONTOLINEACAPTURA", "ESTATUSLC", "BANCO", "CUENTABANCARIA", "ENTIDADLEGAL", "UNIDADNEGOCIO", "DIVISION", "CENTROCOSTOSPROYECTO", "NUMERORECIBO", "TIPOCOBRANZA", "FOLIOACUERDOCOBRANZA", "MONTOACUERDOCOBRANZA", "INTERESMORATORIOCONDONADO", "ORDINARIOCONDONADO", "CAPITALRENTACONDONADA") AS 
SELECT idlineacaptura,
       lineacapturaref, 
       sistemaorigen, 
       lineacaptura, 
       referencia, 
       fechacreacion, 
       fechavigencia, 
       montolineacaptura, 
       estatuslc,
       banco, 
       cuentabancaria, 
       entidadlegal, 
       unidadnegocio, 
       division, 
       centrocostosproyecto, 
       numerorecibo, 
       tipocobranza, 
       folioacuerdocobranza, 
       montoacuerdocobranza, 
       interesmoratoriocondonado, 
       ordinariocondonado, 
       capitalrentacondonada 
FROM   xxfr_linea_captura;
/*VISTA FACTURAS ASOCIADAS A UNA LC */
  CREATE OR REPLACE FORCE EDITIONABLE VIEW "INGRESOS"."XXFRV_CONSULTA_LC_FACTURA" ("IDLINEA", "IDFACTURAPRIMAVERA", "RELATEDERPINVOICE", "BILLTOCONSUMERNAME", "COMPANYACCOUNTCODE", "PAYMENTTERMDATE", "PROJECTID", "TOTALAMOUNT", "IDLINEACAPTURA", "LINENUMBER", "MONTOBRUTOLINEA", "TAXRATE") AS 
  SELECT     LPAD(C.idfacturaprimavera, 9, '0') || LPAD(L.linenumber, 4, '0') AS IDLINEA, 
           C.idfacturaprimavera,
           C.relatederpinvoice, 
           C.billtoconsumername, 
           C.companyaccountcode, 
           C.paymenttermdate, 
           C.projectid, 
           C.totalamount, 
           C.idlineacaptura, 
           L.linenumber, 
           L.montobrutolinea, 
           L.taxrate
FROM       xxfr_cabecera_factura C
INNER JOIN xxfr_invoice_lines L
ON         L.idfacturaprimavera = C.idfacturaprimavera;
/*VISTA PAGOS REALIZADOS A UNA LC */
CREATE OR REPLACE FORCE EDITIONABLE VIEW "INGRESOS"."XXFRV_CONSULTA_LC_PAGOS" ("IDPAGO", "IDLINEACAPTURA", "NORECIBO", "FECHARECIBO", "FECHAAPLICACION", "FECHATRANSACCION", "MONTOPAGADO") AS 
SELECT 
IDPAGO, 
idlineacaptura, --XXFRV_CONSULTA_LC_PAGOS
       norecibo, 
       fecharecibo, 
       fechaaplicacion, 
       fechatransaccion, 
       montopagado 
FROM   xxfr_recibo_linea_captura;
/*VISTA JOIN LC-FACTURA-DETALLE*/
CREATE OR REPLACE FORCE editionable VIEW "INGRESOS"."XXFR_CONSULTA_LC_FAC_DET" ("LINEACAPTURA", "FECHAVIGENCIA", "ENTIDADLEGAL", "IDFACTURAPRIMAVERA", "RELATEDERPINVOICE", "BILLTOCONSUMERNAME", "COMPANYACCOUNTCODE", "PAYMENTTERMDATE", "PROJECTID", "TOTALAMOUNT", "BUSINESSUNITNAME", "MONTOBRUTOLINEA", "TAXRATE") AS
SELECT     LC.lineacaptura,
           LC.fechavigencia, 
           LC.entidadlegal, 
           C.idfacturaprimavera, 
           C.relatederpinvoice, 
           C.billtoconsumername, 
           C.companyaccountcode, 
           C.paymenttermdate, 
           C.projectid, 
           C.totalamount, 
           C.businessunitname, 
           L.montobrutolinea, 
           L.taxrate 
FROM       xxfr_cabecera_factura C 
INNER JOIN xxfr_linea_captura LC 
ON         C.idlineacaptura = LC.idlineacaptura 
INNER JOIN xxfr_invoice_lines L 
ON         L.idfacturaprimavera = c.idfacturaprimavera;