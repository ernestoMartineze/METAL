create or replace PACKAGE XXFRP_FECHA AS 

FUNCTION DIAS_HABILES
(fecha_inicio IN DATE, fecha_fin IN DATE)
 RETURN NUMBER;
 
FUNCTION FECHA_FIN_VIGENCIA
(fecha_inicio IN DATE, plazo IN number)
 RETURN date;
 
END XXFRP_FECHA;