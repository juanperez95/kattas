-- SQLBook: Code
create database kattasWeb character set utf8mb4;

use kattasweb;

use kattasWeb;

create table perfil (
idPerfil int(3) primary key not null,
nombrePerfil char(40) not null);


create table habilitado (
idHabilitado int(3) primary key not null,
tipoHabilitado char(40) not null
);


create table cargo (
idCargo int(3) primary key not null,
tipoCargo char(40) not null
);


create table usuario (
identificacion varchar(15) primary key  null,
fk_perfil int(3)  null,
constraint foreign key (fk_perfil) references perfil (idPerfil),
fk_habilitado int(3)  null,
constraint foreign key (fk_habilitado) references habilitado (idHabilitado),
contrasena varchar(100)  null,
nombres char(30)  null,
apellidos char(30)  null,
email varchar(50)  null,
fechaNacimiento date  null,
genero enum('Femenino','Masculino','Otro') null,
telefono varchar (15) null,
fechaRegistro date,
direccion varchar(70) null,
fk_idCargo int(3) null,
constraint foreign key(fk_idCargo) references cargo(idCargo)
);

-- create table estado(
-- idEstado int(3) primary key  null,
-- tipoEstado char(20)not null);
-- create table pqrs(
-- idPqrs int(20) primary key not null,
-- fk_identificacion varchar(15) not null,
-- fk_estado int (3) not null,
-- constraint foreign key(fk_estado) references estado (idEstado),
-- descripcion varchar(200) not null,
-- fechaCreacionPqrs date not null,
-- evidencia varchar(500));


-- create table pedido(
-- idPedido int(5) primary key auto_increment not null,
-- fk_identificacion varchar(15) not null,
-- constraint foreign key (fk_identificacion) references usuario (identificacion),
-- subtotal int(10)not null);  


-- create table venta(
-- idVenta int(20) primary key not null,
-- fk_pedido int(5) not null,
-- constraint foreign key (fk_pedido) references pedido (idPedido),
-- fk_identificacion varchar (15) not null,
-- constraint foreign key (fk_identificacion) references usuario (identificacion),
-- fechaVenta date not null,
-- total int(15) not null);

-- create table domicilios(
-- idDomicilio int (5) primary key not null auto_increment,
-- fk_venta int(20) not null,
-- constraint foreign key (fk_venta) references venta (idVenta),
-- fk_identificacion varchar(15) not null,
-- constraint foreign key (fk_identificacion) references usuario (identificacion),
-- fechaDomicilio date not null,
-- fkEstado int(3) null,
-- constraint foreign key (fkEstado) references estado(idEstado));

-- create table producto(
-- idProducto int (3) primary key not null,
-- fk_estado int (3) not null,
-- constraint foreign key (fk_estado) references estado (idEstado),
-- nombreproducto char (50) not null,
-- descripcion varchar (200) not null,
-- tamaño varchar (100) not null,
-- precio int (7) not null,
-- imagenProducto text null);

-- create table pedido_producto(
-- fk_idPedido int (5) null,
-- constraint foreign key (fk_idPedido) references pedido (idPedido),
-- fk_idProducto int (3) null,
-- constraint foreign key (fk_idProducto) references producto (idProducto),
-- cantidadProducto int(7) null
-- );

-- create table categoria(
-- idCategoria int (3) primary key not null,
-- nombreCategoria char (30) not null);


-- create table insumos(
-- idInsumo int (3) primary key not null,
-- fk_idCategoria int (3) not null,
-- constraint foreign key (fk_idCategoria) references categoria (idCategoria),
-- fk_estado int (3) not null,
-- constraint foreign key (fk_estado) references estado (idEstado),
-- nombreInsumo char (30) not null,
-- fechaVencimiento date not null,
-- cantidadExistente int (3) not null);

-- create table entrada(
-- idEntrada int (3) primary key not null,
-- fk_idInsumo int (3) not null,
-- constraint foreign key (fk_idInsumo) references insumos (idInsumo),
-- cantidadEntrada int (3) not null,
-- fechaEntrada date not null,
-- valorEntrada int (7) not null);

-- create table salida(
-- idSalida int (3) primary key not null,
-- fk_idInsumo int (3) not null,
-- constraint foreign key (fk_idInsumo) references insumos (idInsumo),
-- cantidadSalida int (3) not null,
-- fechaSalida date not null,
-- valorSalida int (7) not null);

-- create table productos_insumos(
-- fk_idProducto int (3) not null,
-- constraint foreign key (fk_idProducto) references producto (idProducto),
-- fk_idInsumo int (3) not null,
-- constraint foreign key (fk_idInsumo) references insumos (idInsumo),
-- cantidadInsumos int(10) null);

-- -- $$DELIMITER
-- -- -- Crear disparador para historial de sesiones.
-- -- create TRIGGER historial after update on usuario for each row
-- -- insert into inicio values(old.identificacion,old.email_c,now())
-- -- DELIMITER;


/* Insertar datos predeterminados en perfiles */
insert into perfil values(1,'Administrador'),(2,'Empleado'),(3,'Cliente');
/* Insertar datos en habilitados */
insert into habilitado values(1,'Habilitado'),(2,'Deshabilitado');

insert into cargo values(1,"Mesero"),(2,"Cajero"),(3,"Domiciliario");

-- insert into estado values(1,"Agotado"),(2,"Existente");

-- insert into categoria values(1,"Carnes"),(2,"Salsas");


-- select * from insumos;

-- desc cargo;
-- select identificacion, nombrePerfil, tipoHabilitado, tipoCargo from usuario as u inner join perfil as pf on u.fk_perfil = pf.idPerfil inner join
-- habilitado as h on u.fk_habilitado = h.idHabilitado inner join cargo as cg on u.fk_idCargo = cg.idCargo;


-- CREATE VIEW empleado AS SELECT  identificacion, nombres, apellidos, nombrePerfil, tipoCargo, fechaRegistro FROM usuario as u inner join perfil as pf on u.fk_perfil = pf.idPerfil
-- inner join cargo as cg on u.fk_idCargo = cg.idCargo;

-- update usuario set fk_perfil = 1 where identificacion = 1019112822;

-- -- select count(*)-1 from usuario;
-- -- drop table inicio;
--  drop database kattasweb; 
-- -- -- drop VIEW empleado;
-- -- drop TRIGGER historial;

-- select * from inicio where fk_documento = 102825438 ORDER by fecha desc limit 1,1;

-- select * from usuario where fechaRegistro in('2023-06-24','2023-06-24') or fk_habilitado = 1 and identificacion like '%1019%';
