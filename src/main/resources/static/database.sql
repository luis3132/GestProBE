CREATE TABLE IF NOT EXISTS venta (
  `id` varchar(50) NOT NULL PRIMARY KEY,
  `fecha_venta` timestamp NOT NULL,
  `cliente` varchar(10) NOT NULL,
  `empresa` varchar(20) NOT NULL,
  `pagacon` varchar(50) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `cambio` varchar(500),
  `metodo_de_pago` enum('Efectivo', 'TarjetaDebito', 'TarjetaCredito', 'Transferencia') NOT NULL
);

CREATE TABLE IF NOT EXISTS promocion (
  `id` varchar(30) NOT NULL PRIMARY KEY,
  `empresa` varchar(20) NOT NULL,
  `local` varchar(50),
  `categoria` varchar(30),
  `articulo` varchar(30),
  `fecha_inicio` timestamp NOT NULL,
  `fecha_final` timestamp NOT NULL,
  `promocion` int NOT NULL,
  `descripcion` varchar(500)
);

CREATE TABLE IF NOT EXISTS unidad (
  `sku` varchar(50) NOT NULL PRIMARY KEY,
  `nombre` varchar(500) NOT NULL,
  `descripcion` varchar(500),
  `precio_detal` bigint NOT NULL,
  `precio_mayorista` bigint,
  `articulo` varchar(500) NOT NULL,
  `local` varchar(500) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_compra` timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria (
  `id` varchar(30) NOT NULL PRIMARY KEY,
  `empresa` varchar(20) NOT NULL,
  `categoria` varchar(500) NOT NULL,
  `subcategoria` varchar(500)
);

CREATE TABLE IF NOT EXISTS `vigencia_plan` (
	`id` varchar(30) NOT NULL PRIMARY KEY,
	`empresa` varchar(20) NOT NULL,
	`plan` int NOT NULL,
	`fecha_compra` timestamp NOT NULL,
	`fecha_finalizacion` timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `roles` varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS articulo (
  `id` varchar(30) NOT NULL PRIMARY KEY,
  `nombre` varchar(500) NOT NULL,
  `descripcion` varchar(500),
  `impuesto` int,
  `punto_reorden` int,
  `empresa` varchar(20) NOT NULL,
  `caracteristica_dimensional` enum('Talla', 'Tamano', 'Peso', 'Especificaciones', 'Cantidad', 'Sabor', 'Color', 'NVariaciones') NOT NULL,
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL
);

CREATE TABLE IF NOT EXISTS `vent_unid` (
  `unidad` varchar(50) NOT NULL,
  `venta` varchar(50) NOT NULL,
  `precio_final` bigint NOT NULL,
  PRIMARY KEY (`unidad`, `venta`)
);

CREATE TABLE IF NOT EXISTS `arti_cate` (
  `articulo` varchar(30) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  PRIMARY KEY (`articulo`, `categoria`)
);

CREATE TABLE IF NOT EXISTS empleado (
  `id` varchar(60) NOT NULL PRIMARY KEY,
  `usuario` varchar(10) NOT NULL,
  `local` varchar(50) NOT NULL,
  `fecha_contratado` timestamp NOT NULL,
  `fecha_despedido` timestamp,
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario (
  `cedula` varchar(10) NOT NULL PRIMARY KEY,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nombre_usuario` varchar(10) NOT NULL UNIQUE,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(500) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `direccion` varchar(500),
  `fecha_creacion` timestamp NOT NULL,
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL
);

CREATE TABLE IF NOT EXISTS `rol_emp` (
  `empleado` varchar(60) NOT NULL,
  `roles` int NOT NULL,
  PRIMARY KEY (`empleado`, `roles`)
);

CREATE TABLE IF NOT EXISTS `rol_usr` (
  `usuario` varchar(10) NOT NULL,
  `roles` int NOT NULL,
  PRIMARY KEY (`usuario`, `roles`)
);

CREATE TABLE IF NOT EXISTS empresa (
  `nit` varchar(20) NOT NULL PRIMARY KEY,
  `nombre` varchar(50) NOT NULL,
  `dueno` varchar(10) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `departamento` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente (
  `cedula` varchar(10) NOT NULL,
  `empresa`varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50),
  `telefono` varchar(10) NOT NULL,
  `fijo` varchar(10),
  `descripcion` varchar(500),
  `mayorista` BOOL NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL,
  `email` varchar(100),
  PRIMARY KEY (`cedula`,`empresa`)
);

CREATE TABLE IF NOT EXISTS `local` (
  `id` varchar(50) NOT NULL PRIMARY KEY,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `telefono` varchar(20),
  `estado` enum('ACTIVO', 'INACTIVO') NOT NULL,
  `empresa_padre` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS planes (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(50) NOT NULL,
  `precio` int NOT NULL,
  `descripcion` varchar(500) NOT NULL
);

ALTER TABLE `arti_cate` ADD CONSTRAINT `arti-cate_articulo_fk` FOREIGN KEY (`articulo`) REFERENCES articulo (`id`) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE `arti_cate` ADD CONSTRAINT `arti-cate_categoria_fk` FOREIGN KEY (`categoria`) REFERENCES categoria (`id`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE articulo ADD CONSTRAINT articulo_empresa_fk FOREIGN KEY (`empresa`) REFERENCES empresa (`nit`);

ALTER TABLE empleado ADD CONSTRAINT empleado_local_fk FOREIGN KEY (`local`) REFERENCES local (`id`);
ALTER TABLE empleado ADD CONSTRAINT empleado_usuario_fk FOREIGN KEY (`usuario`) REFERENCES usuario (`cedula`);

ALTER TABLE empresa ADD CONSTRAINT empresa_dueno_fk FOREIGN KEY (`dueno`) REFERENCES usuario (`cedula`);

ALTER TABLE `vigencia_plan` ADD CONSTRAINT vigencia_plan_empresa_fk FOREIGN KEY (`empresa`) REFERENCES empresa (`nit`);
ALTER TABLE `vigencia_plan` ADD CONSTRAINT vigencia_plan_planes_fk FOREIGN KEY (`plan`) REFERENCES planes (`id`);

ALTER TABLE `local` ADD CONSTRAINT local_empresa_padre_fk FOREIGN KEY (`empresa_padre`) REFERENCES empresa (`nit`);

ALTER TABLE `rol_emp` ADD CONSTRAINT `rol_emp_empleado_fk` FOREIGN KEY (`empleado`) REFERENCES empleado (`id`);
ALTER TABLE `rol_emp` ADD CONSTRAINT `rol_emp_roles_fk` FOREIGN KEY (`roles`) REFERENCES roles (`id`);

ALTER TABLE `rol_usr` ADD CONSTRAINT `rol_usr_usuario_fk` FOREIGN KEY (`usuario`) REFERENCES usuario (`cedula`);
ALTER TABLE `rol_usr` ADD CONSTRAINT `rol_usr_roles_fk` FOREIGN KEY (`roles`) REFERENCES roles (`id`);

ALTER TABLE unidad ADD CONSTRAINT unidad_articulo_fk FOREIGN KEY (`articulo`) REFERENCES articulo (`id`);
ALTER TABLE unidad ADD CONSTRAINT unidad_local_fk FOREIGN KEY (`local`) REFERENCES local (`id`);

ALTER TABLE `vent_unid` ADD CONSTRAINT `vent-unid_unidad_fk` FOREIGN KEY (`unidad`) REFERENCES unidad (`sku`);
ALTER TABLE `vent_unid` ADD CONSTRAINT `vent-unid_venta_fk` FOREIGN KEY (`venta`) REFERENCES venta (`id`);

ALTER TABLE venta ADD CONSTRAINT venta_cliente_empresa_fk FOREIGN KEY (`cliente`, `empresa`) REFERENCES cliente (`cedula`, `empresa`);
ALTER TABLE venta ADD CONSTRAINT venta_usuario_fk FOREIGN KEY (`usuario`) REFERENCES usuario (`cedula`);

INSERT INTO gestpro.roles (roles) VALUES('USER');
INSERT INTO gestpro.roles (roles) VALUES('ADMIN');