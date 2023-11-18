package com.example.sif2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sif2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sif2Application.class, args);
    }
}
//hasta aqui es sprintboot



function login() {
  const usuarios = [
    ["admin", "admin123", "administrador"],
    ["vendedor", "vendedor123", "vendedor"],
  ];

  console.log("Bienvenido al sistema de inventario de la farmacia");
  console.log("Nombre de usuario: ");
  const nombreUsuario = prompt();
  console.log("Contraseña: ");
  const contraseña = prompt();
  const tipoUsuario = verificarCredenciales(nombreUsuario, contraseña, usuarios);

  if (tipoUsuario === "administrador") {
    console.log("¡Bienvenido, administrador!");
    mostrarMenuAdministrador();
  } else if (tipoUsuario === "vendedor") {
    console.log("¡Bienvenido, vendedor!");
    mostrarMenuVendedor();
  } else {
    console.log("Credenciales inválidas. El programa se cerrará.");
    process.exit();
  }
}

function verificarCredenciales(nombreUsuario, contraseña, usuarios) {
  for (const usuario of usuarios) {
    if (usuario[0] === nombreUsuario && usuario[1] === contraseña) {
      return usuario[2];
    }
  }
  return "";
}


function mostrarMenuVendedor() {
  console.log("Menú de vendedor");
  console.log("1. Vender productos");
  console.log("2. Consultar inventario");
  console.log("3. Generar factura");
  console.log("4. Salir");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      console.log("Vender productos");
      break;
    case "2":
      console.log("Consultar inventario");
      break;
    case "3":
      generarFactura();
      break;
    case "4":
      console.log("Salir");
      break;
    default:
      console.log("Opción no válida");
      break;
  }
}


function mostrarMenuAdministrador() {
  console.log("Menú de administrador");
  console.log("1. Administrar usuarios");
  console.log("2. Administrar productos");
  console.log("3. Salir");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      console.log("Administrar usuarios");
      break;
    case "2":
      console.log("Administrar productos");
      break;
    case "3":
      console.log("Salir");
      break;

// menu y funciones del administrador
          
    function mostrarMenuAdministrador() {
  console.log("Menú de administrador");
  console.log("1. Administrar usuarios");
  console.log("2. Administrar productos");
  console.log("3. Generar informe");
  console.log("4. Salir");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      administrarUsuarios();
      break;
    case "2":
      administrarProductos();
      break;
    case "3":
      generarInforme();
      break;
    case "4":
      console.log("Salir");
      break;
    default:
      console.log("Opción no válida");
      break;
  }
}

function administrarUsuarios() {
  console.log("Administrar usuarios");
  console.log("1. Agregar usuario");
  console.log("2. Eliminar usuario");
  console.log("3. Modificar usuario");
  console.log("4. Regresar");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      agregarUsuario();
      break;
    case "2":
      eliminarUsuario();
      break;
    case "3":
      modificarUsuario();
      break;
    case "4":
      mostrarMenuAdministrador();
      break;
    default:
      console.log("Opción no válida");
      break;
  }
}

function agregarUsuario() {
  console.log("Agregar usuario");

  // Obtener los datos del usuario
  const nombreUsuario = prompt("Ingrese el nombre de usuario: ");
  const contraseña = prompt("Ingrese la contraseña: ");
  const tipoUsuario = prompt("Ingrese el tipo de usuario (administrador/vendedor): ");

  // Agregar el usuario a la base de datos
  // ...

  console.log("Usuario agregado correctamente");
}

function eliminarUsuario() {
  console.log("Eliminar usuario");

  // Obtener el nombre de usuario del usuario a eliminar
  const nombreUsuario = prompt("Ingrese el nombre de usuario del usuario a eliminar: ");

  // Eliminar el usuario de la base de datos
  // ...

  console.log("Usuario eliminado correctamente");
}

function modificarUsuario() {
  console.log("Modificar usuario");

  // Obtener el nombre de usuario del usuario a modificar
  const nombreUsuario = prompt("Ingrese el nombre de usuario del usuario a modificar: ");

  // Obtener los datos del usuario a modificar
  const contraseña = prompt("Ingrese la nueva contraseña: ");
  const tipoUsuario = prompt("Ingrese el nuevo tipo de usuario (administrador/vendedor): ");

  // Modificar el usuario en la base de datos
  // ...

  console.log("Usuario modificado correctamente");
}

function administrarProductos() {
  console.log("Administrar productos");
  console.log("1. Agregar producto");
  console.log("2. Eliminar producto");
  console.log("3. Modificar producto");
  console.log("4. Regresar");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      agregarProducto();
      break;
    case "2":
      eliminarProducto();
      break;
    case "3":
      modificarProducto();
      break;
    case "4":
      mostrarMenuAdministrador();
      break;
    default:
      console.log("Opción no válida");
      break;
  }
}

function agregarProducto() {
  console.log("Agregar producto");

  // Obtener los datos del producto
  const codigo = prompt("Ingrese el código del producto: ");
  const nombre = prompt("Ingrese el nombre del producto: ");
  const descripcion = prompt("Ingrese la descripción del producto: ");
  const precio = prompt("Ingrese el precio del producto: ");
  const stock = prompt("Ingrese el stock del producto: ");
    default:
      console.log("Opción no válida");
      break;
  }
}

// menu y las funciones del vendedor
    
function mostrarMenuVendedor() {
  console.log("Menú de vendedor");
  console.log("1. Vender productos");
  console.log("2. Consultar inventario");
  console.log("3. Generar factura");
  console.log("4. Salir");

  const opcion = prompt("Seleccione una opción: ");

  switch (opcion) {
    case "1":
      venderProductos();
      break;
    case "2":
      consultarInventario();
      break;
    case "3":
      generarFactura();
      break;
    case "4":
      console.log("Salir");
      break;
    default:
      console.log("Opción no válida");
      break;
  }
}

function venderProductos() {
  console.log("Vender productos");

  // Obtener los datos de la venta
  const productos = [];
  do {
    const producto = prompt("Ingrese el código del producto: ");
    const cantidad = prompt("Ingrese la cantidad del producto: ");
    productos.push({
      codigo: producto,
      cantidad: cantidad,
    });
  } while (prompt("¿Desea agregar otro producto? (S/N): ") === "S");

  // Realizar la venta
  // ...

  // Generar la factura
  generarFactura(productos);

  console.log("Venta realizada correctamente");
}

function consultarInventario() {
  console.log("Consultar inventario");

  // Obtener los productos del inventario
  // ...

  // Imprimir los productos
  // ...
}

function generarFactura() {
  console.log("Generar factura");

  // Obtener los datos de la factura
  const cliente = prompt("Ingrese el nombre del cliente: ");
  const fecha = prompt("Ingrese la fecha de la factura: ");
  const productos = [];
  do {
    const producto = prompt("Ingrese el código del producto: ");
    const cantidad = prompt("Ingrese la cantidad del producto: ");
    const precio = prompt("Ingrese el precio del producto: ");
    productos.push({
      codigo: producto,
      cantidad: cantidad,
      precio: precio,
    });
  } while (prompt("¿Desea agregar otro producto? (S/N): ") === "S");

  // Calcular el total de la factura
  const total = productos.reduce((acumulador, producto) => acumulador + producto.cantidad * producto.precio, 0);

  // Imprimir la factura
  console.log("--------------------------------------------------------");
  console.log("Factura");
  console.log("Fecha: " + fecha);
  console.log("Cliente: " + cliente);
  console.log("--------------------------------------------------------");
  console.log("Producto | Cantidad | Precio | Subtotal");
  console.log("--------------------------------------------------------");
  productos.forEach((producto) => {
    console.log(
      producto.codigo + " | " +
      producto.cantidad + " | " +
      producto.precio + " | " +
      producto.cantidad * producto.precio
    );
  });
  console.log("--------------------------------------------------------");
  console.log("Total: " + total);
  console.log("--------------------------------------------------------");
}
