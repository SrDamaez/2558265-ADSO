import java.time.temporal.Temporal;
import java.util.*;

public class Factura{

	Scanner entrada_texto = new Scanner(System.in);
	Scanner entrada_numero = new Scanner(System.in);
	String continuar = "";

	int id;
	Date fecha;
	Persona cliente;
	Persona vendedor;
	double total;
	ItemsFactura listaCompra [];

	public Factura(int id, Persona cliente, Persona vendedor){
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;

		fecha = new Date();
		total = 0;

		ItemsFactura temporal [] = new ItemsFactura [50];
		listaCompra = temporal;
	}
	
	public Persona getVendedor(){
		return this.vendedor;
	}

	public Persona getCliente(){
		return this.cliente;
	}

	public void agregarFactura(Producto[] listaProductos){

		boolean seguir_productos = false;
		int aux_producto = 0;
		int cont_productos = 0;
		
		System.out.println("» » Presione enter para continuar... « «");
		continuar = entrada_texto.nextLine();
		
		do {
			boolean valido_producto = false;

			System.out.print("\033[H\033[2J");  
			System.out.flush();

			System.out.println("┌┬────────────────────────────────┬┐");
			System.out.println("││       LISTA DE PRODUCTOS       ││");
			System.out.println("└┴────────────────────────────────┴┘");

			for (int i=0; i<listaProductos.length; i++) {
				if (listaProductos[i]!=null) {
					listaProductos[i].imprimirProductos();
				}else{
					break;
				}
			}

			System.out.println("┌────────────────────────┐");
			System.out.println(  "│       Producto #" + (cont_productos + 1) + "      │");
			System.out.println("└────────────────────────┘");

			System.out.print("» » Ingrese el nombre del producto: ");
			String nombre_producto = entrada_texto.nextLine();

			for (int i=0; i<listaProductos.length; i++) {
				if (listaProductos[i]!=null && listaProductos[i].getNombre().equalsIgnoreCase(nombre_producto)) {
					valido_producto = true;
					aux_producto = i;
					break;
				}
			}

			if (valido_producto) {

				System.out.print("» » Ingrese la cantidad comprada: ");
				int cantidad_producto = entrada_numero.nextInt();

				total += cantidad_producto * listaProductos[aux_producto].getPrecio(); 

				ItemsFactura itemsFactura = new ItemsFactura(listaProductos[aux_producto], cantidad_producto, listaProductos[aux_producto].getPrecio());
				listaCompra[cont_productos] = itemsFactura;
				cont_productos++;

			}else{

				System.out.println("");
				System.out.println("┌┬──────────────────────────────────────────┬┐");
				System.out.println("││       PRODUCTO INGRESADO NO EXISTE       ││");
				System.out.println("└┴──────────────────────────────────────────┴┘");
				System.out.println("");

			}

			System.out.println("\n» » » 1. Para ingresar otro producto ingrese - 2. Terminar factura");
			System.out.print("» » » ");
			int aux_seguir = entrada_numero.nextInt();
			
			if (aux_seguir == 1) {
				seguir_productos = true;
			}else {
				seguir_productos = false;
			}

		} while (seguir_productos);
	}

	public void imprimirFactura(){
		System.out.println("» » » " + this.fecha + " - " + this.id + " - " + getVendedor().nombres + " " + getVendedor().apellidos + " - "  + getCliente().nombres + " " + getCliente().apellidos + " - " + total);
	}

	public void imprimirDetalle(){
		for (int i=0; i<listaCompra.length; i++) {
			if (listaCompra[i] != null) {
				System.out.println(listaCompra[i].mostrarProductosVendidos());
			}
		}
		System.out.println("» » Presione enter para continuar... « «");
		continuar = entrada_texto.nextLine();
	};

}