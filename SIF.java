import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SIF {
    // Lista para almacenar los productos del inventario
    private static List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Bienvenido al sistema de inventario de la farmacia");
        System.out.print("Nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

         
        if (usuario.equals("admin") && contraseña.equals("admin123")) {
             
            System.out.println("Inicio de sesión exitoso como administrador");
            mostrarMenuAdministrador();
        } else if (usuario.equals("vendedor") && contraseña.equals("vendedor123")) {
             
            System.out.println("Inicio de sesión exitoso como vendedor");
            mostrarMenuVendedor();
        } else {
             
            System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos");
        }

        scanner.close();
    }

    // Funciones para el administrador
    private static void mostrarMenuAdministrador() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("----- Menú del Administrador -----");
                System.out.println("1. Consultar productos del inventario");
                System.out.println("2. Agregar un nuevo producto");
                System.out.println("3. Eliminar un producto");
                System.out.println("4. Actualizar información de un producto");
                System.out.println("5. Generar informe de ventas");
                System.out.println("6. Generar informe de inventario");
                System.out.println("0. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        consultarInventario();
                        break;
                    case 2:
                        agregarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        actualizarProducto();
                        break;
                    case 5:
                        generarInformeVentas();
                        break;
                    case 6:
                        generarInformeInventario();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
            } while (opcion != 0);
        } 
    }

    private static void consultarInventario() {
        System.out.println("----- Productos del Inventario -----");
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        }
    }

    private static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Agregar un nuevo producto -----");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad disponible en stock del producto: ");
        int CantidadDisponible = scanner.nextInt();
    
        Producto nuevoProducto = new Producto();
        inventario.add(nuevoProducto);
    
        System.out.println("Producto agregado exitosamente al inventario.");
    
        scanner.close();
    }
    
    private static void eliminarProducto() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("----- Eliminar un producto -----");
            System.out.print("Ingrese el nombre del producto a eliminar: ");
            String nombre = scanner.nextLine();

            boolean productoEncontrado = false;
            for (Producto producto : inventario) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    inventario.remove(producto);
                    productoEncontrado = true;
                    break;
                }
            }

            if (productoEncontrado) {
                System.out.println("Producto eliminado exitosamente del inventario.");
            } else {
                System.out.println("No se encontró el producto en el inventario.");
            }
        }
    }

    private static void actualizarProducto() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("----- Actualizar información de un producto -----");
            System.out.print("Ingrese el nombre del producto a actualizar: ");
            String nombre = scanner.nextLine();

            boolean productoEncontrado = false;
            for (Producto producto : inventario) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.print("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Ingrese la nueva cantidad en stock del producto: ");
                    int nuevoStock = scanner.nextInt();

                    producto.setPrecio((int) nuevoPrecio);  
                    producto.setCantidadDisponible(nuevoStock);

                    productoEncontrado = true;
                    break;
                }
            }

            if (productoEncontrado) {
                System.out.println("Información del producto actualizada exitosamente.");
            } else {
                System.out.println("No se encontró el producto en el inventario.");
            }
        }
    }

    private static void generarInformeVentas() {
        System.out.println("----- Generar informe de ventas -----");
        // incompleto
    }

    private static void generarInformeInventario() {
        System.out.println("----- Generar informe de inventario -----");
        // incompleto
    }

    // Funciones para el vendedor
    private static void mostrarMenuVendedor() {
        Scanner scanner = new Scanner(System.in);
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
                case 4:
                    generarFacturaRecibo();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void realizarVenta() {
        System.out.println("----- Realizar una venta -----");
        // incompleto
    }

    private static void verificarStock() {
        System.out.println("----- Verificar stock de productos -----");
        // incompleto
    }

    private static void generarFacturaRecibo() {
        System.out.println("----- Generar factura o recibo -----");
        // incompleto
    }
}

class Producto {
    private String codigoBarras;
    private String nombre;
    private String tipo;
    private String lote;
    private String fechaVencimiento;
    private int cantidadDisponible;
    private int precio;

  public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

      public int getPrecio() {
        return precio;
    }

    public void setPrecio(int nuevoPrecio) { 
        this.precio = nuevoPrecio;
    }

   
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
 

    @Override
    public String toString() {
        return "CodigoBarras: " + codigoBarras + "Nombre:" + nombre + "Precio" + precio + "Tipo:" + tipo + "Lote" + lote + "FechaVencimiento" + fechaVencimiento + "CantidadDisponible" + cantidadDisponible + ",";
    }
}
