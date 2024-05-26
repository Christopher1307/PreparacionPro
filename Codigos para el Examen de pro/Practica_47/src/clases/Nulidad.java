package clases;
import java.io.*;
import java.util.Scanner; // Me pareció una manera más cómoda de obtener cada línea del archivo
import java.util.Vector;


/**
 * Clase que coge los datos de cada nulidad y los almacena para poder enviar los emails y enviar las nulidades correspondientes
 * @author Jonathan Gutiérrez Riego
 */
public class Nulidad {

	/** Proveedores que serán recogidos del txt de nulidad */
	public Vector<Proveedor> proveedores;

	
	/**
	 * Constructor de la clase Nulidad. Este cogerá los datos de una nulidad en específico 
	 */
	public Nulidad() {
		this.proveedores = new Vector<>();
	}
	
	/**
	 * Getter de proveedores (solo lo usaremos en el main)
	 * @return lista de los proveedores con sus datos
	 */
	public Vector<Proveedor> ListaProveedores() {
		return this.proveedores;
	}
	
	/**
	 * Función que coge los datos del txt de nulidad y genera todos los datos para la carta
	 */
	public void GetProveedores(String path) {
    File nulidad = new File(path);
    try {
    	Scanner scanner_archivo = new Scanner(nulidad);
    	while (scanner_archivo.hasNextLine()) {
    		String linea = scanner_archivo.nextLine();
    		String[] separado = linea.split("\t");

    		// Obtener o crear el proveedor correspondiente
    		Proveedor proveedor = ObtenerOCrearProveedor(separado[1],separado);

    		// Crear el pago
    		Pago pago = new Pago(separado[0], separado[2], separado[3], separado[4], separado[5]);

    		// Agregar el pago al proveedor
    		proveedor.pagos.add(pago);
    	}
    	scanner_archivo.close();
    	for (Proveedor proveedor : this.proveedores) {
    		proveedor.SetLegal();
    	}
    } catch (FileNotFoundException error) {
    	System.out.println("El archivo no se ha encontrado.");
    	error.printStackTrace();
    }
}

	/**
	 * Método que decide si un proveedor debe ser añadido o si se suma un pago simplemente
	 * @param nombreProveedor nombre del proveedor que estamos leyendo en esta linea
	 * @param separado Linea del txt separada por sus elementos.
	 * @return El proveedor con el que estamos trabajando ahora o bien uno nuevo con los datos nuevos.
	 */
	protected Proveedor ObtenerOCrearProveedor(String nombreProveedor, String[] separado) {
    // Buscar si el proveedor ya existe en el vector
    for (Proveedor proveedor : this.proveedores) {
    	if (proveedor.GetNombreProveedor().equals(nombreProveedor)) {
    		return proveedor;
    	}
    }

    // Si el proveedor no existe, crear uno nuevo
    Proveedor nuevoProveedor = CrearProveedor(separado);
    this.proveedores.add(nuevoProveedor);
    return nuevoProveedor;
}
	/**
	 * Gestiona que el proveedor pueda o no tener email y separar su apellido del nombre
	 * @param separado Linea del txt separada por sus elementos.
	 * @return Objeto de la clase proveedor con todos sus atributos gestionados.
	 */
	protected Proveedor CrearProveedor(String[] separado) {
		Proveedor nuevo_proveedor = new Proveedor();
		nuevo_proveedor.SetNombreProveedor(separado[1]);
		nuevo_proveedor.SetId(separado[6]);
		
		if (separado.length == 9) { // en el caso de que si haya email
			nuevo_proveedor.SetEmail(separado[7]);
			String[] apellido_nombre = separado[8].split(", ");
			// Obtener el apellido y el nombre del contacto
			String apellido = apellido_nombre[0];
			String nombre = apellido_nombre[1];
			nuevo_proveedor.SetApellidoContacto(apellido);
			nuevo_proveedor.SetNombreContacto(nombre);
		
		} else {
			String[] apellido_nombre = separado[7].split(", ");
			// Obtener el apellido y el nombre del contacto
			String apellido = apellido_nombre[0];
			String nombre = apellido_nombre[1];
			nuevo_proveedor.SetApellidoContacto(apellido);
			nuevo_proveedor.SetNombreContacto(nombre);
			nuevo_proveedor.SetEmail("fax");
		}
		return nuevo_proveedor;
	}
	
	public void CrearCartaNulidad(String path) {
		try {
			// Generaremos una carta de nulidad en cada uno de los proveedores que tenemos
			for (Proveedor proveedor : proveedores) {
				
				if (proveedor.legal) {
					// Cogemos el contenido de la carta de aceptados y empezamos a volcar los datos
					String carta_legal = new Scanner(new File("Carta_ejemplo.txt")).useDelimiter("\\Z").next();
					carta_legal = carta_legal.replace("[Nombre_cliente]", proveedor.GetNombreContacto() + proveedor.GetApellidoContacto());
					carta_legal = carta_legal.replace("[Numero_nulidad]", proveedor.GetPagos().get(0).GetIdNulidad());
					carta_legal = carta_legal.replace("[nombre_empresa]", proveedor.GetNombreProveedor());
					carta_legal = carta_legal.replace("[total_servicios]", Double.toString(proveedor.total)); // Convertimos el double en una string
					
					Vector<String> cadena_pagos = new Vector<>();
					String cadena_aux = "";
					// Necesitamos generar una string con cada uno de los pagos
					for (Pago pago : proveedor.GetPagos()) {
				    cadena_aux += "ID: " + pago.GetId_pago() + " - Pago: " + pago.GetImporte() + "- Fecha: " + pago.GetFecha_pago()
				                + "- ID producto: " + pago.GetId_producto() + "\n-----------------\n";
				}
				carta_legal = carta_legal.replace("[Lista_pago_servicios]", cadena_aux);
				
				// Creamos el txt con la nulidad ya reemplazada
				BufferedWriter writer = new BufferedWriter(new FileWriter(path + proveedor.nombre_proveedor + ".txt"));
				writer.write(carta_legal);
				writer.close();
				
				// En el caso de que la tengamos que denegar
				} else {
				// Cogemos el contenido de la carta de aceptados y empezamos a volcar los datos
					String carta_legal = new Scanner(new File("carta_ejemplo_denegada.txt")).useDelimiter("\\Z").next();
					carta_legal = carta_legal.replace("[Nombre_cliente]", proveedor.GetNombreContacto() + " " + proveedor.GetApellidoContacto());
					carta_legal = carta_legal.replace("[Numero_nulidad]", proveedor.GetPagos().get(0).GetIdNulidad());
					carta_legal = carta_legal.replace("[nombre_empresa]", proveedor.GetNombreProveedor());
					carta_legal = carta_legal.replace("[total_servicios]", Double.toString(proveedor.total)); // Convertimos el double en una string
					
					Vector<String> cadena_pagos = new Vector<>();
					String cadena_aux = "";
					// Necesitamos generar una string con cada uno de los pagos
					for (Pago pago : proveedor.GetPagos()) {
				    cadena_aux += "ID: " + pago.GetId_pago() + " - Pago: " + pago.GetImporte() + " - Fecha: " + pago.GetFecha_pago()
				                + " - ID producto: " + pago.GetId_producto() + "\n-----------------\n";
				}
				carta_legal = carta_legal.replace("[Lista_pago_servicios]", cadena_aux);
				
				// Creamos el txt con la nulidad ya reemplazada
				BufferedWriter writer = new BufferedWriter(new FileWriter(path + proveedor.nombre_proveedor + ".txt"));
				writer.write(carta_legal);
				writer.close();
				}
				
			}
			
		} catch (FileNotFoundException error) {
    	System.out.println("El archivo no se ha encontrado.");
    	error.printStackTrace();
    } catch (IOException error) {
    	System.out.println("No se ha podido escribir en el archivo");
    	error.printStackTrace();
    }
	}
	
}
