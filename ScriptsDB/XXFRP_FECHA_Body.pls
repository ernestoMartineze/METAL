create or replace PACKAGE BODY XXFRP_FECHA AS

FUNCTION DIAS_HABILES
(fecha_inicio IN DATE, fecha_fin IN DATE)
 RETURN NUMBER IS
      diasNoHabiles     NUMBER;
      numero_dias NUMBER := 0;
      fecha_actual DATE;
  BEGIN
      --Validar que la información de entrada sea correcta
    /*dbms_output.put_line('** Valores de entrada **');
    dbms_output.put_line('fecha_inicio= ' || fecha_inicio);
    dbms_output.put_line('fecha_fin = ' || fecha_fin);*/
      IF fecha_fin >= fecha_inicio THEN    
         fecha_actual := fecha_inicio;
         WHILE fecha_actual <= fecha_fin LOOP
             -- dbms_output.put_line('TO_CHAR(fecha_actual,DY) = ' || TO_CHAR(fecha_actual,'DY'));  
             IF TO_CHAR(fecha_actual,'DY') NOT IN ('SÁB','DOM')
             THEN numero_dias := numero_dias + 1;
             END IF;
             fecha_actual := fecha_actual + 1;
         END LOOP;
         
         SELECT COUNT (FECHA)
         INTO diasNoHabiles
         FROM XXFXC_DIAS_FESTIVOS
         WHERE FECHA BETWEEN fecha_inicio AND fecha_fin and ind_activo = 1;
         
         RETURN numero_dias - diasNoHabiles;
     ELSE
     	RETURN 0;
     END IF;
 END DIAS_HABILES;
 
 
 FUNCTION FECHA_FIN_VIGENCIA
(fecha_inicio IN DATE, plazo IN number)
 RETURN date As
  numeroDias Number := 0;
  diferenciaDias Number := 0;
  fechaFinalVigencia Date ;
 begin
    /*dbms_output.put_line('** Valores de entrada **');
    dbms_output.put_line('fecha_inicio= ' || fecha_inicio);
    dbms_output.put_line('plazo= ' || plazo);
    dbms_output.put_line('numeroDias= ' || numeroDias);*/
  WHILE numeroDias < plazo
    LOOP
    
      
      -- dbms_output.put_line('diferenciaDias ' || diferenciaDias);
       fechaFinalVigencia := fecha_inicio + (diferenciaDias + plazo);
      -- dbms_output.put_line('fechaFinalVigencia= ' || fechaFinalVigencia);
       numeroDias := DIAS_HABILES(fecha_inicio, fechaFinalVigencia);
      -- dbms_output.put_line('numeroDias= ' || numeroDias);
       diferenciaDias := (plazo-numeroDias) + diferenciaDias;
      -- dbms_output.put_line('diferenciaDias= ' || diferenciaDias);
    END LOOP;
  -- dbms_output.put_line('fechaFinalVigencia= ' || fechaFinalVigencia);
  return fechaFinalVigencia;
 
 end FECHA_FIN_VIGENCIA;

END XXFRP_FECHA;