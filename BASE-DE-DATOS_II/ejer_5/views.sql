CREATE VIEW listados_pagos_clientes AS
SELECT nombre_cliente AS "Nombre cliente",
    telefono,
    ciudad,
    pais,
    fecha_pago,
    total,
    id_transaccion
FROM cliente
    NATURAL JOIN pago;

CREATE VIEW listado_pedidos_clientes AS
SELECT nombre_cliente,
    telefono,
    ciudad,
    pais,
    codigo_pedido,
    fecha_pedido,
    fecha_esperada,
    fecha_entrega,
    sum(cantidad * precio_unidad) as "Precio total"
FROM cliente
    NATURAL JOIN pedido
    NATURAL JOIN detalle_pedido
    NATURAL JOIN producto
GROUP BY codigo_pedido;

-- Listado de los clientes de la ciudad de Madrid que han hecho pagos
SELECT *
FROM listados_pagos_clientes
WHERE ciudad = "madrid";

-- listado de los clientes que todavía no han recibido su pedido
SELECT *
FROM listado_pedidos_clientes
WHERE fecha_entrega IS NULL;

-- calcular el número de pedidos que se ha efectuado cada uno de los clientes
SELECT nombre_cliente,
    count(*) AS "Pedidos efectuados"
FROM listado_pedidos_clientes
WHERE fecha_entrega IS NOT NULL
group by nombre_cliente;

-- DROP VIEW listados_pagos_clientes;
-- DROP VIEW listado_pedidos_clientes;