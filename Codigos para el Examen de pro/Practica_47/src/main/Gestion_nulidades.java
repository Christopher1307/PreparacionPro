package main;

import clases.Proveedor;
import clases.Pago;
import clases.Nulidad;
import java.util.Vector;
import java.util.Scanner;
import java.io.File;

/**
 * Main de la práctica 47 y donde gestionaremos todas las nulidades de cada empresa que tendremos en nuestro programa.
 * @author Jonathan Gutiérrez Riego
 */
public class Gestion_nulidades {
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Opcion 1 del main: generar las nulidades de una empresa. Generará una carpeta con todas las nulidades.
   * @param empresa Nombre de la empresa a la que le vamos a generar las nulidades
   */
  static void CrearNulidades(String empresa) {
  	Nulidad gestor_nulidades = new Nulidad();
  	File carpeta = new File (empresa);
		Vector<String> rutas_nulidades = new Vector<>();
		
		if (carpeta.isDirectory()) {
			// Obtenemos todas las nulidades de la carpeta de esta empresa
			File[] archivos = carpeta.listFiles();
			
			for (File archivo : archivos) {
				rutas_nulidades.add(archivo.getName());
			}
		} else {
			System.out.println("Introduce una empresa válida");
		}
		
		File nueva_carpeta = new File(empresa + File.separator + empresa + "_nulidades");
		
		try {
      if (nueva_carpeta.mkdirs()) {
      	System.out.println("Carpeta creada exitosamente.");
      } else {
      	System.out.println("Las nulidades ya han sido generadas.");
      }
		} catch (SecurityException error) {
      System.err.println("Error de permisos: " + error.getMessage());
  }
		
		// Si quisieramos crear una carpeta para cada archivo de nulidades la tendríamos que crear aquí dentro
		for (String rutas : rutas_nulidades) {
			gestor_nulidades.GetProveedores(empresa + "/" + rutas); 
			gestor_nulidades.CrearCartaNulidad(empresa + "/" + empresa + "_nulidades/");
			
			System.out.println("¿Quieres mandar las nulidades por email? S/N");
			String decision = scanner.nextLine();
			if (decision.equals("S")) {
				for (Proveedor proveedor : gestor_nulidades.ListaProveedores()) {
					if (proveedor.GetEmail().equals("fax")) {
						System.out.println("Fax mandado a la empresa " + proveedor.GetNombreProveedor());
					} else {
						System.out.println("Email mandado a " + proveedor.GetEmail());
					}
				}
			} else {
				System.out.println("Acuérdate de mandarlas antes de salir del trabajo."); 
			}
		}
		
		
  }
  
	public static void main(String[] args) {
		
		String opcion = "";
		
		while (!opcion.equals("2")) {
			System.out.println("1.- Generar nulidades");
			System.out.println("2.- Salir");
			System.out.println("Elige una de las opciones: ");
			opcion = scanner.nextLine();
			System.out.println();
			switch (opcion) {
			case "1":
				String empresa;
				System.out.println("Introduce el nombre de la empresa a la que le vas a generar las nulidades: ");
				empresa = scanner.nextLine();
				CrearNulidades(empresa);
				System.out.println();
				break;
			
			case "2":
				System.out.println("Adiooooooos");
				break;
			
			default: 
				System.out.println("Elije una opción válida.");
				
			}
		}
	
		
	}
}
