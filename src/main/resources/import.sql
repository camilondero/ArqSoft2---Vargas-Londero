-- You can use this file to load seed data into the database using SQL statements

INSERT INTO USUARIO(NOMBRE,APELLIDO,EMAIL) VALUES ('CMAILA','LONDERO', 'CMAI@GMAIL.COM');

INSERT INTO PROYECTO(NOMBRE,DESCRIPCION) VALUES ('ARQ SOFT','ENTREGABLE SEGUNDO PARCIAL');
INSERT INTO ESTADO(NOMBRE)VALUES ('COMPLETADO');
INSERT INTO TAREA(NOMBRE,DESCRIPCION,PROYECTO_ID,USUARIO_ID,ID_ESTADO) VALUES ('ACT1','HACER UN MODELO',1,1,1);
INSERT INTO COMENTARIO(DETALLE,TAREA_ID,USUARIO_ID) VALUES ('EXCELENTE',1,1);