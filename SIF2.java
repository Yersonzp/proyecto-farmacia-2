import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SIF2 {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Venta> ventas = new ArrayList<>();
    public static ArrayList<Producto> inventario = new ArrayList<>();
    public static final int UMBRAL_AGOTAMIENTO = 10;

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        String[][] usuarios = { { "admin", "admin123", "administrador" }, { "vendedor", "vendedor123", "vendedor" } };
        System.out.println("Bienvenido al sistema de inventario de la farmacia");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        String tipoUsuario = verificarCredenciales(nombreUsuario, contraseña, usuarios);

        if (tipoUsuario.equals("administrador")) {
            System.out.println("¡Bienvenido, administrador!");
            mostrarMenuAdministrador();

        } else if (tipoUsuario.equals("vendedor")) {
            System.out.println("¡Bienvenido, vendedor!");
            mostrarMenuVendedor();

        } else {
            System.out.println("Credenciales inválidas. El programa se cerrará.");
            System.exit(0);
        }
    }

    public static String verificarCredenciales(String nombreUsuario, String contraseña, String[][] usuarios) {
        for (String[] usuario : usuarios) {
            if (usuario[0].equals(nombreUsuario) && usuario[1].equals(contraseña)) {
                return usuario[2];
            }
        }
        return "";
    }

    private static void mostrarMenuVendedor() {
        int opcion;

        do {
            System.out.println("----- Menú del Vendedor -----");
            System.out.println("1. Realizar una venta");
            System.out.println("2. Verificar stock de productos");
            System.out.println("3. Consultar productos del inventario");
            System.out.println("4. Generar factura o recibo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarVenta();
                    break;
                case 2:
                    verificarStock();
                    break;
                case 3:
                    consultarInventario();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

        }

        while (opcion != 0);
    }

    

    // Funciones para el vendedor
    public static void realizarVenta() {
        System.out.println("Realizar una venta");

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        // Buscar el producto en el inventario
        Producto productoEncontrado = buscarProductoPorNombre(nombreProducto);

        if (productoEncontrado != null) {

            // Obtener información del producto
            String codigoBarras = productoEncontrado.getCodigoBarras();

            // Solicitar otros detalles de la venta al vendedor
            System.out.print("Cliente: ");
            String cliente = scanner.nextLine();
            System.out.print("Cantidad vendida: ");
            int cantidad = scanner.nextInt();

            // Realizar la venta
            double precio = productoEncontrado.getPrecio();
            double totalVenta = precio * cantidad;

            // Agregar la venta al arreglo de ventas
            ventas.add(new Venta(new Date(), codigoBarras, cantidad, precio, cliente));

            // Generar factura automáticamente
            generarFacturaAutomatica(codigoBarras, cliente, cantidad, precio, totalVenta);

            System.out.println("Venta exitosa. Total a pagar: $" + totalVenta);

        }

        else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    private static void generarFacturaAutomatica(String codigoBarras, String cliente, int cantidad, double precio, double totalVenta) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaVenta = new Date(); // Obten la fecha actual

        // Genera un número de factura único (puedes personalizar esto)
        int numeroFactura = generarNumeroFactura();

        // Imprime la factura en la consola
        System.out.println("Factura generada automáticamente:");
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha de Venta: " + dateFormat.format(fechaVenta));
        System.out.println("Código de barras: " + codigoBarras);
        System.out.println("Cliente: " + cliente);
        System.out.println("Cantidad vendida: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total: $" + totalVenta);
    }

    // Método para generar un número de factura único (puedes personalizar esto)
    private static int generarNumeroFactura() {
        //generamos un número de factura simple basado en el tiempo
        // actual
        return (int) (System.currentTimeMillis() % 1000000);
    }

    private static Producto buscarProductoPorNombre(String nombreProducto) {
        for (Producto producto : inventario) {

            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }

        return null;
    }

    public static void verificarStock() {
        // Implementacion de la lógica para verificar el stock de productos
        System.out.println("Verificar stock de productos");

        // Solicitar el código de barras del producto al vendedor
        System.out.print("Ingrese el código de barras del producto: ");
        String codigoBarras = scanner.nextLine();

        // Buscar el producto en el inventario
        Producto productoEncontrado = buscarProducto(codigoBarras);

        if (productoEncontrado != null) {
            int cantidadDisponible = productoEncontrado.getCantidad();

            System.out.println("Producto: " + productoEncontrado.getNombre());
            System.out.println("Cantidad disponible en stock: " + cantidadDisponible);
        }

        else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    private static void consultarInventario() {
        System.out.println("Consultar inventario");

        if (inventario.isEmpty()) {
            System.out.print("El inventario esta vacio.");
        }

        else {
            System.out.println("Productos en el inventario.");
            for (Producto producto : inventario) {
                System.out.println("Código de barras: " + producto.getCodigoBarras());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Tipo: " + producto.getTipo());
                System.out.println("Lote: " + producto.getLote());
                System.out.println("Fecha de vencimiento: " + producto.getFechaCaducidad());
                System.out.println("Cantidad disponible: " + producto.getCantidad());
                System.out.println("----------------------------------");
            }

        }

    }


    // Funciones para el administrador
    private static void mostrarMenuAdministrador() {
        int opcion;

        do {
            System.out.println("----- Menú del Administrador -----");
            System.out.println("1. Consultar productos del inventario");
            System.out.println("2. Agregar un nuevo producto");
            System.out.println("3. Actualizar información de un producto");
            System.out.println("4.Verificar agotamiento de productos");
            System.out.println("5. Generar informe de ventas");
            System.out.println("6. Generar informe de inventario");
            System.out.println("7. Consultar producto en inventario");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    consultarInventario();
                    break;
                case 2:
                    registrarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4: verificarAgotamientoProductos();
                    break;
                case 5:
                    generarInformeVentas();
                    break;
                case 6:
                    generarInformeInventario();
                    break;
                case 7:
                    consultarProducto();
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 0);
    }

    //funciones requeridas para el administrador

    public static void consultarProducto() {
        System.out.println("Consulta de producto");
        System.out.print("Ingrese el código de barras del producto: ");
        String codigoBarras = scanner.nextLine();
        Producto productoEncontrado = buscarProducto(codigoBarras);

        if (productoEncontrado != null) {
            System.out.println("Información del producto:");
            System.out.println("Nombre: " + productoEncontrado.getNombre());
            System.out.println("Tipo: " + productoEncontrado.getTipo());
            System.out.println("Lote: " + productoEncontrado.getLote());
            System.out.println("Fecha de vencimiento: " + productoEncontrado.getFechaCaducidad());
            System.out.println("Cantidad disponible: " + productoEncontrado.getCantidad());
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    public static void registrarProducto() {
        System.out.println("Registrar nuevo producto");
    
        // Simulación de escaneo de código de barras
        System.out.print("Código de barras (escaneado o manual): ");
        String codigoBarras = scanner.nextLine();
    
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Lote: ");
        String lote = scanner.nextLine();
        System.out.print("Fecha de vencimiento: ");
        String fechaVencimiento = scanner.nextLine();
        System.out.print("Cantidad disponible: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
    
        inventario.add(new Producto(codigoBarras, nombre, tipo, lote, fechaVencimiento, cantidad));
        System.out.println("Producto registrado exitosamente");
    }

    public static void actualizarProducto() {
        System.out.println("Actualizar información de un producto");
    
        // Solicitar el código de barras del producto a actualizar o simular un escaneo
        System.out.print("Ingrese el código de barras del producto a actualizar o escanee el código: ");
        String codigoBarras = scanner.nextLine();
    
        // Comprueba si el código de barras ingresado es una cadena vacía (simulación de escaneo)
        if (codigoBarras.isEmpty()) {
            // En una implementación real, aquí podrías interactuar con un lector de código de barras
            // y obtener el código escaneado en lugar de solicitarlo manualmente.
        }
    
        // Buscar el producto en el inventario por su código de barras
        Producto productoParaActualizar = buscarProducto(codigoBarras);
    
        if (productoParaActualizar != null) {
            // Mostrar los detalles actuales del producto
            System.out.println("Detalles actuales del producto:");
            System.out.println("Nombre: " + productoParaActualizar.getNombre());
            System.out.println("Tipo: " + productoParaActualizar.getTipo());
            System.out.println("Lote: " + productoParaActualizar.getLote());
            System.out.println("Fecha de vencimiento: " + productoParaActualizar.getFechaCaducidad());
            System.out.println("Cantidad disponible: " + productoParaActualizar.getCantidad());
    
            // Solicitar las actualizaciones al usuario
            System.out.println("Ingrese los nuevos detalles:");
    
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            productoParaActualizar.setNombre(nuevoNombre);
    
            System.out.print("Nuevo tipo: ");
            String nuevoTipo = scanner.nextLine();
            productoParaActualizar.setTipo(nuevoTipo);
    
            System.out.print("Nuevo lote: ");
            String nuevoLote = scanner.nextLine();
            productoParaActualizar.setLote(nuevoLote);
    
            System.out.print("Nueva fecha de vencimiento: ");
            String nuevaFechaVencimiento = scanner.nextLine();
            productoParaActualizar.setFechaVencimiento(nuevaFechaVencimiento);
    
            System.out.print("Nueva cantidad disponible: ");
            int nuevaCantidad = Integer.parseInt(scanner.nextLine());
            productoParaActualizar.setCantidad(nuevaCantidad);
    
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }



    public static void verificarAgotamientoProductos() {
        System.out.println("Verificando agotamiento de productos...");
        for (Producto producto : inventario) {
            if (producto.getCantidad() < UMBRAL_AGOTAMIENTO) {
                System.out.println("Alerta: El producto " + producto.getNombre()
                        + " está agotándose. Cantidad disponible: " + producto.getCantidad());
            }
        }
    }

    public static void generarInformeVentas() {
        System.out.println("Generando informe de ventas...");
    
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            // Recorre la lista de ventas y muestra los detalles de cada venta
            for (Venta venta : ventas) {
                System.out.println("Fecha y hora de la venta: " + venta.getFechaVenta());
                System.out.println("Código de barras del producto vendido: " + venta.getCodigoBarras());
                System.out.println("Cantidad vendida: " + venta.getCantidad());
                System.out.println("Precio de venta: " + venta.getPrecio());
                System.out.println("Cliente: " + venta.getCliente());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void registrarCalidadMedicamento() {
        System.out.println("Registro de calidad para medicamentos");
        System.out.print("Ingrese el código de barras del medicamento: ");
        String codigoBarras = scanner.nextLine();
        Producto medicamento = buscarProducto(codigoBarras);

        if (medicamento != null) {
            System.out.print("Ingrese la fecha de caducidad del medicamento: ");
            String fechaCaducidad = scanner.nextLine();
            System.out.print("Ingrese el número de lote del medicamento: ");
            String numeroLote = scanner.nextLine();
            System.out.print("Ingrese los resultados de las pruebas de calidad: ");
            String resultadosCalidad = scanner.nextLine();
            medicamento.setFechaCaducidad(fechaCaducidad);
            medicamento.setNumeroLote(numeroLote);
            medicamento.setResultadosCalidad(resultadosCalidad);
            System.out.println("Registro de calidad del medicamento exitoso");
        } else {
            System.out.println("Medicamento no encontrado en el inventario.");
        }
    }

    public static void generarInformesVentas() {
        System.out.println("Generando informes de ventas...");
        for (Venta venta : ventas) {
            System.out.println("Fecha y hora de la venta: " + venta.getFechaVenta());
            System.out.println("Código de barras del producto vendido: " + venta.getCodigoBarras());
            System.out.println("Cantidad vendida: " + venta.getCantidad());
            System.out.println("Precio de venta: " + venta.getPrecio());
            System.out.println("Cliente: " + venta.getCliente());
            System.out.println("----------------------------------");
        }
    }

    public static void generarInformeInventario() {
        System.out.println("Generando informe de inventario...");
    
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } 
        else {
            // Recorre la lista de productos en el inventario y muestra los detalles de cada producto
            for (Producto producto : inventario) {
                System.out.println("Código de barras: " + producto.getCodigoBarras());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Tipo: " + producto.getTipo());
                System.out.println("Lote: " + producto.getLote());
                System.out.println("Fecha de vencimiento: " + producto.getFechaCaducidad());
                System.out.println("Cantidad disponible: " + producto.getCantidad());
                System.out.println("----------------------------------");

            }
            
        }

    private static Producto buscarProducto(String codigoBarras) {
        for (Producto producto : inventario) {
            if (producto.getCodigoBarras().equals(codigoBarras)) {
                return producto;
            }
        }
        return null;
    }
}

class Producto {
    private String codigoBarras;
    private String nombre;
    private String tipo;
    private String lote;
    private int cantidad;
    private String fechaCaducidad;
    private String numeroLote;
    private String resultadosCalidad;

    public Producto(String codigoBarras, String nombre, String tipo, String lote, String fechaVencimiento,
            int cantidad) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lote = lote;
        this.fechaCaducidad = fechaVencimiento;
        this.cantidad = cantidad;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaCaducidad = fechaVencimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return 0;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLote() {
        return lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getResultadosCalidad() {
        return resultadosCalidad;
    }

    public void setResultadosCalidad(String resultadosCalidad) {
        this.resultadosCalidad = resultadosCalidad;
    }
}

class Venta {
    private Date fechaVenta;
    private String codigoBarras;
    private int cantidad;
    private double precio;
    private String cliente;

    public Venta(Date fechaVenta, String codigoBarras, int cantidad, double precio, String cliente) {
        this.fechaVenta = fechaVenta;
        this.codigoBarras = codigoBarras;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCliente() {
        return cliente;
    }
}
