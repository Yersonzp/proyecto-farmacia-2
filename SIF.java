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
    default:
      console.log("Opción no válida");
      break;
  }
}
