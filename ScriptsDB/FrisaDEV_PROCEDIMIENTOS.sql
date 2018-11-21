--MANDA A PROCESAR UN BATCH DE FACTURAS--
CREATE OR replace PROCEDURE XXFRP_PROCESAR_BATCH (idparbatch IN VARCHAR2, 
                                                  proceso    OUT NUMBER) 
AS 
BEGIN 
    proceso := xxfr_ingresos_lc.Xxfr_procesar_batch(idparbatch); 
END xxfrp_procesar_batch; 
--CONSULTA DE BATCHES TERMINADOS--
CREATE OR REPLACE PROCEDURE XXFRP_CONSULTA_BATCH 
(
  PIDBATCH IN VARCHAR2, 
  PROCESO OUT NUMBER
) AS 
BEGIN
  SELECT COUNT(*) INTO PROCESO 
  FROM xxfr_cabecera_factura 
  WHERE idlineacaptura IS NULL AND 
  tipocobranza = 'LINEA CAPTURA' AND 
  idbatch = PIDBATCH;
END XXFRP_CONSULTA_BATCH;