-- SQLBook: Code
create database kattasWeb character set utf8mb4;

use kattasweb;

create table perfil (
idPerfil int(3) primary key  null,
nombrePerfil char(40)  null);


create table habilitado (
idHabilitado int(3) primary key  null,
tipoHabilitado char(40)  null
);


create table cargo (
idCargo int(3) primary key  null,
tipoCargo char(40)  null
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

create table estado(
idEstado int(3) primary key  null,
tipoEstado char(20) null);

create table pedido(
idPedido int(5) primary key auto_increment  null AUTO_INCREMENT,
fk_identificacion varchar(15)  null,
constraint foreign key (fk_identificacion) references usuario (identificacion),
subtotal int(10) null);  


create table venta(
idVenta int(20) primary key  null AUTO_INCREMENT,
fk_pedido int(5)  null,
constraint foreign key (fk_pedido) references pedido (idPedido),
fk_identificacion varchar (15)  null,
constraint foreign key (fk_identificacion) references usuario (identificacion),
fechaVenta date  null,
total int(15)  null);

create table domicilios(
idDomicilio int (5) primary key  null auto_increment,
fk_venta int(20)  null,
constraint foreign key (fk_venta) references venta (idVenta),
fk_identificacion varchar(15)  null,
constraint foreign key (fk_identificacion) references usuario (identificacion),
fechaDomicilio date  null,
fkEstado int(3) null,
constraint foreign key (fkEstado) references estado(idEstado));

create table tamañoproducto(
    idTamaño int(5) primary key AUTO_INCREMENT,
    nombreTamaño varchar(50)
);



create table producto(
idProducto int (3) primary key  null auto_increment,
fk_estado int (3)  null,
constraint foreign key (fk_estado) references estado (idEstado),
nombreproducto char (50)  null,
descripcion varchar (200)  null,
fk_tamaño int (5)  null,
constraint Foreign Key (fk_tamaño) REFERENCES tamañoproducto(idTamaño),
precio int (7)  null,
imagenProducto text null);

create table pedido_producto(
idpp int(3) null primary key auto_increment,
fk_idPedido int (5) null,
constraint foreign key (fk_idPedido) references pedido (idPedido),
fk_idProducto int (3) null,
constraint foreign key (fk_idProducto) references producto (idProducto),
cantidadProducto int(7) null
);

create table categoria(
idCategoria int (3) primary key  null,
nombreCategoria char (30)  null);


create table insumo(
idInsumo int (3) primary key  null AUTO_INCREMENT,
fk_idCategoria int (3)  null,
constraint foreign key (fk_idCategoria) references categoria (idCategoria),
fk_estado int (3)  null,
constraint foreign key (fk_estado) references estado (idEstado),
nombreInsumo char (30)  null,
fechaVencimiento date  null,
fechaEntrada date  null,
cantidadExistente int (3)  null);


create table entrada(
idEntrada int (3) primary key  null,
fk_idInsumo int (3)  null,
constraint foreign key (fk_idInsumo) references insumo (idInsumo),
cantidadEntrada int (3)  null,
fechaEntrada date  null,
valorEntrada int (7)  null);

create table salida(
idSalida int (3) primary key  null,
fk_idInsumo int (3)  null,
constraint foreign key (fk_idInsumo) references insumo (idInsumo),
cantidadSalida int (3)  null,
fechaSalida date  null,
valorSalida int (7)  null);

create table productos_insumos(
idpi int(7) primary key null auto_increment,
fk_idProducto int (3)  null,
constraint foreign key (fk_idProducto) references producto (idProducto),
fk_idInsumo int (3)  null,
constraint foreign key (fk_idInsumo) references insumo (idInsumo),
cantidadInsumos int(10) null);


insert into tamañoproducto(nombreTamaño) values("Familiar"),("Personal"),("Mediana");

-- -- $$DELIMITER
-- -- -- Crear disparador para historial de sesiones.
-- -- create TRIGGER historial after update on usuario for each row
-- -- insert into inicio values(old.identificacion,old.email_c,now())
-- -- DELIMITER;


/* Insertar datos predeterminados en perfiles */
insert into perfil values(1,'Administrador'),(2,'Empleado'),(3,'Cliente');
-- insertar las categorias
insert into categoria VALUES(1,"Carnes"),(2,"Salsas"),(3,"Quesos");
/* Insertar datos en habilitados */
insert into habilitado values(1,'Habilitado'),(2,'Deshabilitado');

insert into cargo values(1,"Mesero"),(2,"Cajero"),(3,"Domiciliario");


insert into insumo (fk_idCategoria,fk_estado,nombreInsumo,fechaVencimiento,fechaEntrada,cantidadExistente) values(1,1,'Jamon Serrano','2023-12-25','2023-12-09',10);
insert into insumo (fk_idCategoria,fk_estado,nombreInsumo,fechaVencimiento,fechaEntrada,cantidadExistente) values(1,1,'Queso Mozarella','2023-12-25','2023-12-09',10);

insert into estado values(1,"En stock"),(2,"Bajo stock"),(3,"Sin stock");

insert into producto(fk_estado,nombreproducto,descripcion,fk_tamaño,precio,imagenProducto) values(1,"piazza","Rikka",2,4500,null);
insert into producto(fk_estado,nombreproducto,descripcion,fk_tamaño,precio,imagenProducto) values(1,"Pizza Hawaina","Deliciosa",2,7800,null);

insert into productos_insumos(fk_idProducto,fk_idInsumo,cantidadInsumos) values(1,26,2);

--  drop database kattasweb; 

SELECT * from insumo;
update producto set fk_estado = 1;
-- drop DATABASE kattasweb;
