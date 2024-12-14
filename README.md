# Práctica 06 - Menú overflow y Sharepreferences

**Instrucciones**: Desarrolle una aplicación móvil en plataforma Android, utilizando menú overflow y Sharepreferences, para un negocio de disfraces.

El diseño de la aplicación contempla la Activity principal con un acceso por medio de usuario y contraseña, acompañado de los botones de ingresar y salir. La segunda Activity, conforma el menú principal que tendrá un menú con las opciones: Pedido, Productos, Mis compras, Nosotros y Cerrar sesión. La Activity correspondiente a Pedido será un formulario para registrar la información: nombre (caja de texto), domicilio (caja de texto), producto (Lista desplegable al menos 5 nombres de productos), talla (lista desplegable con tres valores Chico, Mediano, Grande), teléfono de contacto (caja de texto) y dos botones (registrar y cancelar). La Activity correspondiente a Productos será una lista desplegable (ListView) con nombres de los productos (al menos 5). La Activity Mis compras que mostrará los datos registrados en el formulario. Finalmente la Activity Nosotros con información relativa al negocio (incluya una descripción).

La funcionalidad con respecto a cada Activity se detalla a continuación:
* ***Acceso***: se programa que se guarde los datos de usuario y contraseña registrados por el usuario. Para ello utilice la clase Sharepreferences para almacenar la información en el dispositivo, esto al presionar el botón ingresar. El botón salir solamente cierra la aplicación.
* ***Menú***: En el main se programa el menú y por cada opción ejecutar la Activity correspondiente. Así como el paso de información entre cada una (donde aplique). La opción cerrar sesión se debe programar para regresar a acceso principal.
* ***Pedido***. el botón de registrar debe almacenar la información en una instancia de la clase Disfraz y enviar la información como parámetro. En el caso del botón cancelar debe cerrar la Activity y retornar al menú.
* ***Productos***: Se muestra una lista de disfraces y al presionar el nombre de un producto, se debe mostrar información del producto (Descripción, tallas y costo), utilice la clase Toast para mostrar el mensaje.
* ***Mis compras***: Se debe visualizar la información registrada en el formulario.
