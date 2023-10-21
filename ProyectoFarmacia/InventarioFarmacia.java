import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Producto {
    private String codigoBarras;
    private String nombre;
    private String tipo;
    private String lote;
    private String fechaVencimiento;
    private int cantidad;

    public Producto(String codigoBarras, String nombre, String tipo, String lote, String fechaVencimiento, int cantidad) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lote = lote;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", lote='" + lote + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

class GestionInventarioFarmacia {
    private List<Producto> inventario;
    private static final int CANTIDAD_MINIMA_ALERTA = 10;

    public GestionInventarioFarmacia() {
        this.inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public void ordenarPorNombre() {
        Collections.sort(inventario, Comparator.comparing(Producto::getNombre));
    }

    public void ordenarPorCodigoBarras() {
        Collections.sort(inventario, Comparator.comparing(Producto::getCodigoBarras));
    }

    public void mostrarInventario() {
        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }

    public void mostrarProductosAgotados() {
        for (Producto producto : inventario) {
            if (producto.getCantidad() == 0) {
                System.out.println("Producto agotado: " + producto.getNombre());
            }
        }
    }

    public void mostrarProductosAlerta() {
        for (Producto producto : inventario) {
            if (producto.getCantidad() <= CANTIDAD_MINIMA_ALERTA) {
                System.out.println("Producto en alerta: " + producto.getNombre());
            }
        }
    }
}

public class InventarioFarmacia {
    public static void main(String[] args) {
        GestionInventarioFarmacia gestionInventarioFarmacia = new GestionInventarioFarmacia();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú de opciones -----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Ordenar inventario por nombre");
            System.out.println("3. Ordenar inventario por código de barras");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Mostrar productos agotados");
            System.out.println("6. Mostrar productos en alerta");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código de barras: ");
                    String codigoBarras = scanner.next();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el tipo del producto: ");
                    String tipo = scanner.next();
                    System.out.print("Ingrese el número de lote: ");
                    String lote = scanner.next();
                    System.out.print("Ingrese la fecha de vencimiento: ");
                    String fechaVencimiento = scanner.next();
                    System.out.print("Ingrese la cantidad disponible: ");
                    int cantidad = scanner.nextInt();

                    Producto producto = new Producto(codigoBarras, nombre, tipo, lote, fechaVencimiento, cantidad);
                    gestionInventarioFarmacia.agregarProducto(producto);
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 2:
                    gestionInventarioFarmacia.ordenarPorNombre();
                    System.out.println("Inventario ordenado por nombre.");
                    break;
                case 3:
                    gestionInventarioFarmacia.ordenarPorCodigoBarras();
                    System.out.println("Inventario ordenado por código de barras.");
                    break;
                case 4:
                    gestionInventarioFarmacia.mostrarInventario();
                    break;
                case 5:
                    gestionInventarioFarmacia.mostrarProductosAgotados();
                    break;
                case 6:
                    gestionInventarioFarmacia.mostrarProductosAlerta();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}