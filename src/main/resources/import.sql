-- Insertar cliente 1 con ID especificado
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (1, 'Carlos', 'García', 'carlos@example.com', '2024-03-13');

-- Insertar cliente 2 con ID especificado
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (2, 'Ana', 'Martínez', 'ana@example.com', '2024-03-14');

-- Insertar cliente 3 con ID especificado
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (3, 'Luis', 'López', 'luis@example.com', '2024-03-15');

-- Insertar cliente 4 con ID especificado
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (4, 'Laura', 'Díaz', 'laura@example.com', '2024-03-16');

-- Insertar cliente 5 con ID especificado
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES (5, 'Sofía', 'Hernández', 'sofia@example.com', '2024-03-17');

-- Insertar primer producto
INSERT INTO productos (codigo, nombre, precio_venta, precio_compra, create_at)
VALUES (4, 'Producto4', 18.99, 9.99, '2024-03-16');

-- Insertar segundo producto
INSERT INTO productos (codigo, nombre, precio_venta, precio_compra, create_at)
VALUES (5, 'Producto5', 25.49, 14.99, '2024-03-15');

-- Insertar tercer producto
INSERT INTO productos (codigo, nombre, precio_venta, precio_compra, create_at)
VALUES (6, 'Producto6', 12.75, 7.25, '2024-03-14');

-- Insertar cuarto producto
INSERT INTO productos (codigo, nombre, precio_venta, precio_compra, create_at)
VALUES (7, 'Producto7', 30.0, 20.0, '2024-03-13');

-- Insertar quinto producto
INSERT INTO productos (codigo, nombre, precio_venta, precio_compra, create_at)
VALUES (8, 'Producto8', 22.99, 15.99, '2024-03-12');

-- Insertar primer ítem de factura asociado al producto con ID 1
INSERT INTO factura_items (nombre, precioVenta, precioCompra, create_at, producto_id)
VALUES ('Producto A', 20.99, 12.50, '2024-03-19', 1);

-- Insertar segundo ítem de factura asociado al producto con ID 2
INSERT INTO factura_items (nombre, precioVenta, precioCompra, create_at, producto_id)
VALUES ('Producto B', 15.75, 8.25, '2024-03-18', 2);

-- Insertar tercer ítem de factura asociado al producto con ID 3
INSERT INTO factura_items (nombre, precioVenta, precioCompra, create_at, producto_id)
VALUES ('Producto C', 30.50, 18.75, '2024-03-17', 3);

-- Insertar cuarto ítem de factura asociado al producto con ID 4
INSERT INTO factura_items (nombre, precioVenta, precioCompra, create_at, producto_id)
VALUES ('Producto D', 25.99, 15.49, '2024-03-16', 4);

-- Insertar quinto ítem de factura asociado al producto con ID 5
INSERT INTO factura_items (nombre, precioVenta, precioCompra, create_at, producto_id)
VALUES ('Producto E', 22.49, 12.99, '2024-03-15', 5);

