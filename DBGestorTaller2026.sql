/*
	Programador: Estuardo Gómez
    fecha de creación: 14/11/2026
    fecha de modificación: 
*/

Drop database if exists DBGestorTaller2026;
Create database DBGestorTaller2026;

Use DBGestorTaller2026;

Create table Empresa(
	codigoEmpresa int not null auto_increment,
    nombreEmpresa varchar(60) not null,
    telefonoEmpresa varchar(12) not null,
    direccionEmpresa varchar(100) not null,
    primary key PK_codigoEmpresa (codigoEmpresa)
);

Create table Rol(
	codigoRol int not null auto_increment,
    nombreRol varchar(50) not null,
    createdAt datetime default now(),
    updatedAt datetime default now(),
    primary key PK_codigoRol (codigoRol)
);

Create table Usuarios(
	codigoUsuario int not null auto_increment,
    nombreUsuario varchar(200) not null,
    usuarioLogin varchar(200) not null,
    correoUsuario varchar(200) not null,
    telefonoUsuario varchar(12) not null,
    contraseniaUsuario varchar(50) not null,
    codigoRol int not null,
    primary key PK_codigoUsuario (codigoUsuario),
    constraint FK_Usuarios_Rol foreign key (codigoRol)
		references Rol (codigoRol)
);

Create table Vehiculo(
	codigoVehiculo int not null auto_increment,
    placa varchar(20) not null,
    marca varchar(200) not null,
    modelo varchar(12) not null,
    anio varchar(50) not null,
    imagen varchar (5200) not null,
    kilometrajeActual int not null,
    primary key PK_codigoVehiculo (codigoVehiculo)
);

Create table Solicitud(
	codigoSolicitud int not null auto_increment,
    fechaEntrada date not null,
    horaEntrada date not null,
    descripcion varchar(300) not null,
    estadoSolicitud enum('En proceso', 'Finalizado', 'Cancelado') not null,
    codigoUsuario int not null,
    codigoVehiculo int not null,
    primary key PK_codigoSolicitud (codigoSolicitud),
    constraint FK_Solicitud_Usuarios foreign key (codigoUsuario)
		references Usuarios (codigoUsuario),
	constraint FK_Solicitud_Vehiculo foreign key (codigoVehiculo)
		references Vehiculo (codigoVehiculo)
);

Create table Reparacion(
	codigoReparacion int not null auto_increment,
    fechaInicio date not null,
    fechaFin date not null,
    diagnostico varchar(300) not null,
    estadoReparacion enum('En proceso', 'Finalizado', 'Cancelado') not null,
    descripcionPieza varchar(300) not null,
    cantidadPieza int not null,
    precioUnitario decimal(8,2) not null,
    codigoUsuario int not null,
    codigoSolicitud int not null,
    primary key PK_codigoReparacion (codigoReparacion),
    constraint FK_Reparacion_Usuarios foreign key (codigoUsuario)
		references Usuarios (codigoUsuario),
	constraint FK_Reparacion_Solicitud foreign key (codigoSolicitud)
		references Solicitud (codigoSolicitud)
);

Create table Facturacion(
	codigoFactura int not null auto_increment,
    numeroFactura date not null,
    total decimal(8,2) not null,
	subTotal decimal(8,2) not null,
    iva decimal not null,
    createdAt datetime not null,
    descripcionPieza varchar(300) not null,
    codigoUsuario int not null,
    codigoSolicitud int not null,
    codigoReparacion int not null,
    primary key PK_codigoFacturacion (codigoFactura),
    constraint FK_Facturacion_Usuarios foreign key (codigoUsuario)
		references Usuarios (codigoUsuario),
	constraint FK_Facturacion_Solicitud foreign key (codigoSolicitud)
		references Solicitud (codigoSolicitud),
	constraint FK_Facturacion_Reparacion foreign key (codigoReparacion)
		references Reparacion (codigoReparacion)
);

-- ------------ PROCEDIMIENTOS ALMACENADOS ---------------------

-- EMPRESA --------------------------

-- AGREGAR


-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------



-- ROL --------------------------


-- AGREGAR
Delimiter $$
	Create procedure sp_AgregarRol(
		in nombreRol varchar(50),
        in createdAt datetime,
        in updatedAt datetime)
        Begin
			Insert into Rol(nombreRol, createdAt, updatedAt)
				values (nombreRol, createdAt, updatedAt);
        End$$
Delimiter ;

call sp_AgregarRol('ADMIN', '2026-11-14', '2026-11-15');

-- LISTAR
Delimiter $$
	Create procedure sp_ListarRoles()
		Begin
			select
				R.codigoRol,
				R.nombreRol,
                R.createdAt,
                R.updatedAt
			From Rol R;
        End$$
Delimiter ;

-- drop procedure if exists sp_ListarRoles;
call sp_ListarRoles();

-- ELIMINAR
Delimiter $$
	Create procedure sp_EliminarRol()
Delimiter ;
-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------



-- USUARIOS --------------------------

-- AGREGAR
Delimiter $$
	Create procedure sp_AgregarUsuario(
		in nombreUsuario varchar(200),
        in usuarioLogin varchar(200),
        in correoUsuario varchar(200),
        in telefonoUsuario varchar(12),
        in contraseniaUsuario varchar(50))
        Begin
			Insert into Usuario(nombreUsuario, usuarioLogin, correoUsuario, telefonoUsuario, contraseniaUsuario) 
				values(nombreUsuario, usuarioLogin, correoUsuario, telefonoUsuario, contraseniaUsuario);
        End$$
Delimiter ;
call sp_AgregarUsuario('Estuardo', 'egomez', 'estuardogomez6b@gmail.com', '42570586', 'admin1234', 1);

-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------


-- VEHICULO --------------------------

-- AGREGAR

-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------


-- SOLICITUD --------------------------

-- AGREGAR

-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------


-- REPARACION --------------------------

-- AGREGAR

-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------


-- FACTURACION --------------------------

-- AGREGAR

-- LISTAR

-- ELIMINAR

-- BUSCAR

-- EDITAR
-- -----------------------------------------------------------------








