import java.util.*;

public class Principal{
	public static void main(String[] args) {
	
		int opcion = 0;
		String continuar = "";
		Scanner entrada_numero = new Scanner(System.in);
		Scanner entrada_texto = new Scanner(System.in);

		Factura listaFacturas [] = new Factura [100];
		Persona listaClientes [] = new Persona [100];
		Persona listaVendedores [] = new Persona [100];
		Producto listaProductos [] = new Producto [100];
		ItemsFactura listaItemsFactura [][] = new ItemsFactura [100][100];
		int indiceFacturas = 0;
		int indiceClientes = 0;
		int indiceProductos = 0;
		int indiceVendedores = 0;
		int indiceItemsFactura = 0;
		
		do{
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("┌┬────────────────────────────────────┬┐");
			System.out.println("││       SISTEMA DE FACTURACION       ││");
			System.out.println("├┼────────────────────────────────────┼┤");
			System.out.println("││                                    ││");
			System.out.println(  "││            Clientes: " + formatoIndice(indiceClientes) + "            ││");
			System.out.println(  "││          Vendedores: " + formatoIndice(indiceVendedores) + "            ││");
			System.out.println(  "││           Productos: " + formatoIndice(indiceProductos) + "            ││");
			System.out.println(  "││            Facturas: " + formatoIndice(indiceFacturas) + "            ││");
			System.out.println("││                                    ││");
			System.out.println("││    1. Creacion de cliente          ││");
			System.out.println("││    2. Creacion de Vendedor         ││");
			System.out.println("││    3. Creacion de Productos        ││");
			System.out.println("││    4. Creacion de Factura          ││");
			System.out.println("││    5. Ver lista de Clientes        ││");
			System.out.println("││    6. Ver lista de Vendedores      ││");
			System.out.println("││    7. Ver lista de Productos       ││");
			System.out.println("││    8. Ver lista de Facturas        ││");
			System.out.println("││    9. Ver detalle de Factura       ││");
			System.out.println("││    0. Salir                        ││");
			System.out.println("││                                    ││");
			System.out.println("└┴────────────────────────────────────┴┘");
			System.out.print("» » Ingrese una opcion: ");
			opcion = entrada_numero.nextInt();

			if(opcion==1){ //Creacion de cliente

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬─────────────────────────────────┬┐");
				System.out.println("││       CREACION DE CLIENTE       ││");
				System.out.println("└┴─────────────────────────────────┴┘");
				System.out.print("» » » Documento: ");
				int documento = entrada_numero.nextInt();

				boolean valido = true;
				for (int i=0; i<listaClientes.length; i++) {
					if (listaClientes[i]!=null && listaClientes[i].getDocumento() == documento ) {
						valido = false;
					}
				}

				if (valido) {
					System.out.print("» » » Nombres: ");
					String nombres = entrada_texto.nextLine();

					System.out.print("» » » Apellidos: ");
					String apellidos = entrada_texto.nextLine();

					listaClientes[indiceClientes] = new Persona(documento, nombres, apellidos);
					indiceClientes++;

					System.out.println("");
					System.out.println("┌───────────────────────────────────┐");
					System.out.println("│  Cliente ingresado correctamente  │");
					System.out.println("└───────────────────────────────────┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();
				}else{

					System.out.println("");
					System.out.println("┌┬────────────────────────────────────────────┬┐");
					System.out.println("││       EL CLIENTE INGRESADO YA EXISTE       ││");
					System.out.println("└┴────────────────────────────────────────────┴┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();
				}

			}else if(opcion==2){ //Creacion de Vendedor

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬──────────────────────────────────┬┐");
				System.out.println("││       CREACION DE VENDEDOR       ││");
				System.out.println("└┴──────────────────────────────────┴┘");
				System.out.print("» » » Documento: ");
				int documento = entrada_numero.nextInt();

				boolean valido = true;
				for (int i=0; i<listaVendedores.length; i++) {
					if (listaVendedores[i]!=null && listaVendedores[i].getDocumento()==documento ) {
						valido = false;
					}
				}

				if (valido) {

					System.out.print("» » » Nombres: ");
					String nombres = entrada_texto.nextLine();

					System.out.print("» » » Apellidos: ");
					String apellidos = entrada_texto.nextLine();

					listaVendedores[indiceVendedores] = new Persona(documento, nombres, apellidos);
					indiceVendedores++;

					System.out.println("");
					System.out.println("┌────────────────────────────────────┐");
					System.out.println("│  Vendedor ingresado correctamente  │");
					System.out.println("└────────────────────────────────────┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();

				}else{

					System.out.println("");
					System.out.println("┌┬─────────────────────────────────────────────┬┐");
					System.out.println("││       EL VENDEDOR INGRESADO YA EXISTE       ││");
					System.out.println("└┴─────────────────────────────────────────────┴┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();

				}

			}else if(opcion==3){ //Creacion de Productos

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬──────────────────────────────────┬┐");
				System.out.println("││       CREACION DE PRODUCTO       ││");
				System.out.println("└┴──────────────────────────────────┴┘");
				System.out.print("» » » Nombre: ");
				String nombre = entrada_texto.nextLine();

				boolean valido = true;
				for (int i=0; i<listaProductos.length; i++) {
					if (listaProductos[i]!=null && listaProductos[i].getNombre().equalsIgnoreCase(nombre)){
						valido = false;
					}
				}

				if (valido) {

					System.out.print("» » » Precio: ");
					double precio = entrada_numero.nextInt();

					listaProductos[indiceProductos] = new Producto(nombre.toUpperCase(), precio);
					indiceProductos++;

					System.out.println("");
					System.out.println("┌────────────────────────────────────┐");
					System.out.println("│  Producto ingresado correctamente  │");
					System.out.println("└────────────────────────────────────┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();

				}else{

					System.out.println("");
					System.out.println("┌┬─────────────────────────────────────────────┬┐");
					System.out.println("││       EL PRODUCTO INGRESADO YA EXISTE       ││");
					System.out.println("└┴─────────────────────────────────────────────┴┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();

				}

			}else if(opcion==4){ //Creacion de Factura

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬─────────────────────────────────┬┐");
				System.out.println("││       CREACION DE FACTURA       ││");
				System.out.println("└┴─────────────────────────────────┴┘");
				System.out.print("» » » Documento del vendedor: ");
				int documento_vendedor = entrada_numero.nextInt();

				int aux_cliente = 0;
				int aux_vendedor = 0;
				boolean valido_1 = false;
				boolean valido_2 = false;

				for (int i=0; i<listaVendedores.length; i++) {
					if (listaVendedores[i]!=null && listaVendedores[i].getDocumento() == documento_vendedor ) {
						valido_1 = true;
						System.out.println("» » » Vendedor: " + listaVendedores[i].getNombres() + " " + listaVendedores[i].getApellidos() + " « « «");
						aux_vendedor = i;
						break;
					}
				}
				
				if (valido_1 == false){
					System.out.println("");
					System.out.println("┌┬──────────────────────────────────────────┬┐");
					System.out.println("││       VENDEDOR INGRESADO NO EXISTE       ││");
					System.out.println("└┴──────────────────────────────────────────┴┘");
					System.out.println("");

				}else{
					System.out.print("» » » Documento del cliente: ");
					int documento_cliente = entrada_numero.nextInt();

					for (int i=0; i<listaClientes.length; i++) {
						if (listaClientes[i]!=null && listaClientes[i].getDocumento() == documento_cliente ) {
							valido_2 = true;
							System.out.println("» » » Cliente: " + listaClientes[i].getNombres() + " " + listaClientes[i].getApellidos() + " « « «");
							aux_cliente = i;
							break;
						}
					}

					if (valido_2 == false){
						System.out.println("");
						System.out.println("┌┬─────────────────────────────────────────┬┐");
						System.out.println("││       CLIENTE INGRESADO NO EXISTE       ││");
						System.out.println("└┴─────────────────────────────────────────┴┘");
						System.out.println("");
					}
				}


				if (valido_1 && valido_2) {
					
					boolean seguir_productos = false;
					boolean busqueda_producto = false;
					int aux_producto = 0;
					
					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();
					
					do {
						boolean valido_producto = false;

						System.out.print("\033[H\033[2J");  
						System.out.flush();

						System.out.println("┌┬─────────────────────────┬┐");
						System.out.println(  "││       Producto #" + formatoIndice(indiceItemsFactura + 1) + "      ││");
						System.out.println("└┴─────────────────────────┴┘");

						System.out.print("» » » Ingrese el nombre del producto: ");
						String nombre_producto = entrada_texto.nextLine();

						for (int i=0; i<listaProductos.length; i++) {
							if (listaProductos[i]!=null && listaProductos[i].getNombre().equalsIgnoreCase(nombre_producto)) {
								valido_producto = true;
								aux_producto = i;
								break;
							}
						}

						if (valido_producto) {

							System.out.print("» » » Ingrese la cantidad comprada: ");
							int cantidad_producto = entrada_numero.nextInt();

							listaItemsFactura[indiceFacturas][indiceItemsFactura] = new ItemsFactura(listaProductos[aux_producto], cantidad_producto, (cantidad_producto * listaProductos[aux_producto].getPrecio()));
							indiceItemsFactura++;

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

					listaFacturas[indiceFacturas] = new Factura((indiceFacturas + 1), listaClientes[aux_cliente], listaVendedores[aux_vendedor]);
					indiceFacturas++;

					System.out.println("");
					System.out.println("┌───────────────────────────────────┐");
					System.out.println("│  Factura ingresada correctamente  │");
					System.out.println("└───────────────────────────────────┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();
				}else{

					System.out.println("");
					System.out.println("┌┬────────────────────────────────┬┐");
					System.out.println("││       INTENTE NUEVAMENTE       ││");
					System.out.println("└┴────────────────────────────────┴┘");
					System.out.println("");

					System.out.println("» » Presione enter para continuar... « «");
					continuar = entrada_texto.nextLine();
				}

			}else if(opcion==5){ //Ver lista de Clientes

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬───────────────────────────────┬┐");
				System.out.println("││       LISTA DE CLIENTES       ││");
				System.out.println("└┴───────────────────────────────┴┘");

				for (int i=0; i<listaClientes.length; i++) {
					if (listaClientes[i]!=null) {
						listaClientes[i].imprimirDetalle();
					}else{
						break;
					}
				}

				System.out.println("\n» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else if(opcion==6){ //Ver lista de Vendedores

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬─────────────────────────────────┬┐");
				System.out.println("││       LISTA DE VENDEDORES       ││");
				System.out.println("└┴─────────────────────────────────┴┘");

				for (int i=0; i<listaVendedores.length; i++) {
					if (listaVendedores[i]!=null) {
						listaVendedores[i].imprimirDetalle();
					}else{
						break;
					}
				}

				System.out.println("\n» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else if(opcion==7){ //Ver lista de Productos

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

				System.out.println("\n» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else if(opcion==8){ //Ver lista de Facturas

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("┌┬───────────────────────────────┬┐");
				System.out.println("││       LISTA DE FACTURAS       ││");
				System.out.println("└┴───────────────────────────────┴┘");

				for (int i=0; i<listaFacturas.length; i++) {
					if (listaFacturas[i]!=null) {
						listaFacturas[i].imprimirFactura();
					}else{
						break;
					}
				}

				System.out.println("\n» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else if(opcion==9){ //Ver detalle de Factura

				System.out.println("┌┬─────────────────────────────────┬┐");
				System.out.println("││       ALGORITMO PENDIENTE       ││");
				System.out.println("└┴─────────────────────────────────┴┘");

				System.out.println("\n» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else if(opcion==0){ //Salir

				System.out.print("\033[H\033[2J");  
				System.out.flush();

				System.out.println("");
				System.out.println("┌┬───────────────────────────────────────┬┐");
				System.out.println("││       SALIENDO DE LA APLICACION       ││");
				System.out.println("└┴───────────────────────────────────────┴┘");
				System.out.println("");

				System.out.println("» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}else{ //Opcion incorrecta
				
				System.out.println("");
				System.out.println("┌┬───────────────────────────────┬┐");
				System.out.println("││       OPCION INCORRECTA       ││");
				System.out.println("└┴───────────────────────────────┴┘");
				System.out.println("");

				System.out.println("» » Presione enter para continuar... « «");
				continuar = entrada_texto.nextLine();

			}

		}while(opcion!=0);

		if (continuar == ""){ //Salir
			entrada_numero.close();
			entrada_texto.close();
		}else{ //salir
			entrada_numero.close();
			entrada_texto.close();
		}
		
	}


	public static String formatoIndice(int indice){
		return (indice<10)? "0"+indice : ""+indice;
	}
	
}