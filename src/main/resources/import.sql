INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (1, 'Carlos', 'García', 'carlos@example.com', '2024-03-13');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (2, 'Ana', 'Martínez', 'ana@example.com', '2024-03-14');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (3, 'Luis', 'López', 'luis@example.com', '2024-03-15');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (4, 'Laura', 'Díaz', 'laura@example.com', '2024-03-16');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (5, 'Sofía', 'Hernández', 'sofia@example.com', '2024-03-17');

INSERT INTO productos (nombre, precio_venta, precio_compra, create_at)VALUES ('Panasonic Pantalla LCD', 18.99, 9.99, NOW());
INSERT INTO productos (nombre, precio_venta, precio_compra, create_at)VALUES ('Sony Camara digital DSC-W320B', 25.49, 14.99, NOW());
INSERT INTO productos ( nombre, precio_venta, precio_compra, create_at)VALUES ('Apple iPod shuffle', 12.75, 7.25, NOW());
INSERT INTO productos ( nombre, precio_venta, precio_compra, create_at)VALUES ('Sony Notebook Z110', 30.0, 20.0, NOW());
INSERT INTO productos ( nombre, precio_venta, precio_compra, create_at)VALUES ('Hewlett Packard Multifuncional F2280', 22.99, 15.99,NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 3, NOW());

INSERT INTO factura_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO factura_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO factura_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO factura_items (cantidad, factura_id, producto_id) VALUES(1, 1, 3);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 4, NOW());
INSERT INTO factura_items (cantidad, factura_id, producto_id) VALUES(3, 2, 2);

-- Insertar datos en la tabla users
INSERT INTO users (email, pwd) VALUES ('account@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('cards@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('loans@debuggeandoieas.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('balance@debuggeandoieas.com', 'to_be_encoded');

--Insertar datos en las tabla de roles
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'cant view account endpoint', 1);      
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'cant view cards endpoint', 2); 
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'cant view account endpoint', 3); 
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_USER', 'cant view account endpoint', 4); 