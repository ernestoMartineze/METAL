CREATE USER ingresos IDENTIFIED BY ingresos;
GRANT CONNECT, RESOURCE, DBA TO ingresos;
GRANT CREATE SESSION GRANT ANY PRIVILEGE TO ingresos;
GRANT UNLIMITED TABLESPACE TO ingresos;