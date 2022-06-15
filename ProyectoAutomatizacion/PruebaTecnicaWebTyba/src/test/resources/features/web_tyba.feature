#language:es

Característica: Realizar el proceso de compras en el portal web de “AdvantageDemo”
  Como cliente de “AdvantageDemo”
  Deseo realizar el proceso de compras de un producto
  Para verificar su correcto funcionamiento

  @Registrousuario
  Escenario:Verificar que se realice el proceso de registro para un nuevo usuario
    Dado Que el usuario ingresa al portal web de AdvantageDemo
    Cuando Ingrese a la opción usuario para crear nueva cuenta con los datos
      | username | email                | password  | confirm_password | name   | last_name | phone   | country  | city     | address  | state     |
      | HernanB  | hernan2669@gmail.com | Test1986* | Test1986*        | Hernan | Barrera   | 3211122 | Colombia | Medellin | calle 23 | Antioquia |
    Entonces El usuario visualizará su nombre en la pantalla principal

  @ProcesoCompra
  Escenario: Realizar el proceso de compra de productos
    Dado Que el usuario ingresa al portal web de AdvantageDemo
    Cuando Ingreso con un usuario existente
      | username   | password  |
      | testing001 | Test0001* |
    Y Selecciono de la opción del menu POPULAR ITEMS el producto deseado, cambio el color, la cantidad y lo añado al carrito de compras
      | product                       | color | quantity |
      | HP ROAR PLUS WIRELESS SPEAKER | BLACK | 2        |
      | HP ELITEBOOK FOLIO            | GRAY  | 1        |
    Y Se realiza la compra de los productos
    Entonces Se verifica que la compra que haya realizado satisfactoriamente