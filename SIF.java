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
