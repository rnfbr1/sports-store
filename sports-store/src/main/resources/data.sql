/**
 * CREATE Script for init of DB
 */


 --Creacion de productos

 insert into producto (id, descripcion, marca, estado, precio_unitario, fecha_creacion) values (1, 'CAMISETA FUTBOL','ADIDAS', 'NUEVO', 30 ,now());

 insert into producto (id, descripcion, marca, estado, precio_unitario, fecha_creacion) values (2, 'BALON', 'ADIDAS', 'NUEVO', 54 , now());

 insert into producto (id, descripcion, marca, estado, precio_unitario, fecha_creacion) values (3, 'ZAPATOS PUPO', 'PUMA', 'NUEVO', 80, now() );

--Creacion de empleado

insert into empleado(id, nombre, rol, estado) values(1, 'Jose Ramirez', 'OPERADOR', 'ACTIVO');

insert into empleado(id, nombre, rol, estado) values(2, 'Adriana Gonzales', 'OPERADOR', 'ACTIVO');

insert into empleado(id, nombre, rol, estado) values(3, 'Raymundo Torres', 'OPERADOR', 'INACTIVO');

--Kardex

insert into kardex(id,producto_id,cantidad,stock,precio_unitario,total,tipo_operacion,fecha_operacion,empleado_id) values(1,1,10,10,30,300,'ENTRADA',now(),1)