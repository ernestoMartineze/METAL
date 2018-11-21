----BORRADO DE TABLAS----
drop table ingresos.xxfr_aplicacion_recibo;
drop table ingresos.xxfr_catalogo_conceptos;
drop table ingresos.xxfr_invoice_lines;
drop table ingresos.xxfr_linea_captura;
drop table ingresos.xxfr_linea_captura_factura;
drop table ingresos.xxfr_recibo_linea_captura;
drop table ingresos.xxfr_cabecera_factura;
drop table ingresos.xxfr_estado_batch;
--TABLA DE LINEAS DE CAPTURA--
CREATE TABLE ingresos.xxfr_linea_captura(
idLineaCaptura  NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
lineaCapturaRef VARCHAR(50),
sistemaOrigen VARCHAR(20),
lineaCaptura VARCHAR(50),
referencia VARCHAR(20),
fechaCreacion DATE,
fechaVigencia DATE,
montoLineaCaptura NUMBER(20,2),
estatusLC VARCHAR(20),
banco VARCHAR (20),
cuentaBancaria VARCHAR(20),
entidadLegal VARCHAR(20),
unidadNegocio VARCHAR(20),
division VARCHAR(20),
centroCostosProyecto VARCHAR(20),
numeroRecibo VARCHAR(20),
tipoCobranza VARCHAR(20),
folioAcuerdoCobranza VARCHAR(20),
montoAcuerdoCobranza VARCHAR(20),
interesMoratorioCondonado VARCHAR(20),
ordinarioCondonado VARCHAR(20),
capitalRentaCondonada VARCHAR(20)
);
COMMENT ON TABLE ingresos.xxfr_linea_captura IS 'Información de líneas de captura';
--SELECT * FROM xxfr_linea_captura;

--TABLA DE FACTURAS DE PRIMAVERA--
CREATE TABLE ingresos.xxfr_cabecera_factura(
idFacturaPrimavera NUMBER(20) PRIMARY KEY,
facilityNumber VARCHAR(20),
companyAccountCode NUMBER(10),
businessUnitName VARCHAR (20),
transactionSource VARCHAR(20),
transactionType VARCHAR(20),
creationDateTRX DATE,
creationDateGL DATE,
currency VARCHAR(20),
conversionRateType VARCHAR(20),
conversionRateValue VARCHAR(20),
billToConsumerName VARCHAR(240),
billToLocation NUMBER(10),
paymentTermDays NUMBER(3),
paymentTermDate VARCHAR(20),
gracePeriod NUMBER(3),
paymentMethod VARCHAR(10),
DFFheaderContext VARCHAR(20),
contractNumber NUMBER(10),
contextRentas VARCHAR(20),
localNumber VARCHAR(20),
landTaxAccount VARCHAR(20),
referenceNumber VARCHAR(20),
relatedERPInvoice VARCHAR(20),
legalInvoiceUse VARCHAR(20),
addendum VARCHAR(20),
tipoCobranza VARCHAR(20),
divisionType VARCHAR(20),
projectId NUMBER(10),
generationType VARCHAR(20),
folioAvisoCargo VARCHAR(20),
groupType VARCHAR(20),
bankName VARCHAR(20),
bankAccountNumber VARCHAR(20),
totalAmount NUMBER(20,2),
idLineaCaptura VARCHAR(20),
estadoProcesamiento VARCHAR(20),
idBatch VARCHAR(20)
);
COMMENT ON TABLE ingresos.xxfr_cabecera_factura IS 'Cabeceras de facturas depositadas por Primavera';
--SELECT * FROM xxfr_cabecera_factura;

--TABLA DE LINEAS DE FACTURA--
CREATE TABLE ingresos.xxfr_invoice_lines(
idFacturaPrimavera NUMBER(20),
lineNumber NUMBER(3),
description_origen VARCHAR(100),
descriptionManual VARCHAR(100),
memoLineName VARCHAR(100),
quantity NUMBER(5),
taxClassificationCode NUMBER(10),
taxRate VARCHAR(20),
clasificadorDescuento VARCHAR(20),
descAdicional1 VARCHAR(240),
descAdicional2 VARCHAR(240),
descAdicional3 VARCHAR(240),
descAdicional4 VARCHAR(240),
descAdicional5 VARCHAR(240),
montoBrutoLinea NUMBER(20,2),
montoNetoLinea NUMBER(20,2),
idConcepto NUMBER(10),
fechaDesde DATE,
fechaHasta DATE,
fechaExigibilidad DATE,
CONSTRAINT linea_factura_pk PRIMARY KEY (idFacturaPrimavera,lineNumber) 
);
COMMENT ON TABLE ingresos.xxfr_invoice_lines IS 'Detalle de facturas Primavera';
--SELECT * FROM xxfr_invoice_lines;

--CATALOGO CONCEPTOS FACTURA--
CREATE TABLE ingresos.xxfr_catalogo_conceptos(
idConcepto VARCHAR(100),
descripcion VARCHAR(100)
);
COMMENT ON TABLE ingresos.xxfr_catalogo_conceptos IS 'Catálogo de conceptos de líneas de facturas';
--SELECT * FROM xxfr_catalogo_conceptos;

--LINEA CAPTURA FACTURA (TRANSACCIONAL)--
CREATE TABLE ingresos.xxfr_linea_captura_factura(
idTransaccion NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
idFacturaPrimavera NUMBER(20),
idLineaCaptura VARCHAR(20),
CONSTRAINT FK_idFacPri_idFacPri 
FOREIGN KEY (idFacturaPrimavera)
REFERENCES ingresos.xxfr_cabecera_factura(idFacturaPrimavera)
);
COMMENT ON TABLE ingresos.xxfr_linea_captura_factura IS 'Tabla relacional de facturas Primavera y líneas de captura';
--SELECT * FROM xxfr_linea_captura_factura;

--RECIBOS LINEA DE CAPTURA--
CREATE TABLE ingresos.xxfr_recibo_linea_captura(
idPago NUMBER(20) PRIMARY KEY,
idLineaCaptura NUMBER(10),
idPagoERP NUMBER(20),
noRecibo NUMBER(10),
montoPagado NUMBER(20,2),
fechaRecibo DATE,
fechaAplicacion DATE,
fechaTransaccion DATE,
referencia VARCHAR(20)
);
COMMENT ON TABLE ingresos.xxfr_recibo_linea_captura IS 'Relación de líneas pagadas';
--SELECT * FROM xxfr_recibo_linea_captura;

--CATALOGO CONCEPTOS FACTURA--
CREATE TABLE ingresos.xxfr_aplicacion_recibo(
idFacturaERP NUMBER(20),
idPago NUMBER(20)
);
COMMENT ON TABLE ingresos.xxfr_aplicacion_recibo IS 'Montos aplicados en facturas ERP';
--SELECT * FROM xxfr_aplicacion_recibo;

--TABLE ESTADO DE BATCH--
CREATE TABLE XXFR_ESTADO_BATCH(
IDESTADOBATCH NUMBER(10,0) GENERATED ALWAYS AS IDENTITY, 
IDBATCH VARCHAR2(10), 
ESTADO VARCHAR2(10), 
INICIOPROCESO TIMESTAMP, 
FINPROCESO TIMESTAMP
);
COMMENT ON TABLE ingresos.xxfr_estado_batch IS 'Estado de los batch procesados, sin procesar y con errores.';
--SELECT * FROM XXFR_ESTADO_BATCH;