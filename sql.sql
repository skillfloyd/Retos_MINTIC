
SELECT ID_MaterialConstruccion as ID,  Nombre_Material as NOMBRE,  Precio_Unidad as PRECIO FROM MaterialConstruccion WHERE Importado ="Si" ORDER by Nombre_Material;

SELECT proyecto.ID_Proyecto as ID, Proyecto.Constructora,  Proyecto.Ciudad, Proyecto.Clasificacion,  Tipo.Estrato, Lider.Nombre || " " || Primer_Apellido || " " || Segundo_Apellido as LIDER  FROM Proyecto JOIN TIPO ON Proyecto.ID_Tipo = Tipo.ID_Tipo  JOIN LIDER ON Proyecto.ID_Lider = lider.ID_Lider WHERE Banco_Vinculado = "Conavi" ORDER BY Fecha_Inicio DESC, Ciudad, Constructora;

SELECT Ciudad, Clasificacion, count(*)AS TOTAL, MIN(Fecha_Inicio) AS VIEJO, MAX(Fecha_Inicio) AS RECIENTE FROM Proyecto WHERE Clasificacion NOT IN("Casa Campestre", "Condominio") GROUP BY Ciudad, Clasificacion ORDER BY Ciudad, Clasificacion;

SELECT Proyecto.ID_Proyecto, sum(Cantidad * Precio_Unidad) as VALOR FROM Proyecto  JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion  JOIN Compra ON Proyecto.ID_Proyecto = Compra.ID_Proyecto WHERE Pagado = "No" GROUP by Proyecto.ID_Proyecto  HAVING  sum(Cantidad * Precio_Unidad)>50000 ORDER by VALOR DESC;

SELECT Nombre || " " || Primer_Apellido|| " " || Segundo_Apellido AS LIDER, sum(Cantidad*Precio_Unidad) AS VALOR FROM LIDER JOIN Proyecto ON Proyecto.ID_Lider = Lider.ID_Lider JOIN Compra ON Proyecto.ID_Proyecto = Compra.ID_Proyecto JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion GROUP BY Nombre || " " || Primer_Apellido|| " " || Segundo_Apellido ORDER BY VALOR DESC LIMIT 10;