package practica48;

import javax.xml.bind.*;
import java.io.File;

import java.util.*;
public class LecturaEscritura {
	    public static void main(String[] args) throws JAXBException {
	        // Código para el menú
	        Scanner scanner = new Scanner(System.in);
	        String opcion = "";

	        while (!opcion.equals("3")) {
	            System.out.println("Inicio del menú");
	            System.out.println("1) Leer contenido del archivo XML");
	            System.out.println("2) Escribir contenido en el archivo XML");
	            System.out.println("3) Salir del menú");
	            
	            System.out.print("Elige la opcion que quieres elegir:");

	            opcion = scanner.nextLine();

	            switch (opcion) {
	                case "1":
	                    leerArchivo();
	                    break;

	                case "2":
	                    escribirArchivo();
	                    break;

	                case "3":
	                    System.out.println("Gracias por usar el menú :)");
	                    break;

	                default:
	                    System.out.println("Opción incorrecta, por favor selecciona otra.");
	                    break;
	            }
	        }
	        scanner.close();
	    }
	    
	    public static void leerArchivo() throws JAXBException {
	    	JAXBContext context = JAXBContext.newInstance(Autos.class, Auto.class, Transmision.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        Autos auto = (Autos) unmarshaller.unmarshal(new File("autos.xml"));

	        ArrayList<Auto> listaAutos = auto.getAutos();

	        for (Auto a : listaAutos) {
	            System.out.println("ID: " + a.getId());
	            System.out.println("Marca: " + a.getMarca());
	            System.out.println("Modelo: " + a.getModelo());
	            System.out.println("Año: " + a.getAño());
	            System.out.println("Color: " + a.getColor());
	            System.out.println("Tipo de Motor: " + a.getTipoMotor());
	            System.out.println("Cilindrada: " + a.getCilindrada());
	            System.out.println("Potencia: " + a.getPotencia());
	            System.out.println("--------------------------------");
	        }
	    }
	    
	    public static void escribirArchivo() throws  JAXBException {
	    	 JAXBContext context = JAXBContext.newInstance(Autos.class, Auto.class, Transmision.class);
	    	    Marshaller marshaller = context.createMarshaller();
	    	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	    	    Autos autos =  null;
	    	    
	    	    try {
	    	    	Unmarshaller unmarshaller = context.createUnmarshaller();
	    	        autos = (Autos) unmarshaller.unmarshal(new File("autos.xml"));
	    	    } catch (JAXBException e) {
	    	        // Si no se encuentra el archivo o hay algún otro error, se crea un nuevo objeto Autos
	    	        autos = new Autos();
	    	    }
	    	    

	    	    Scanner scanner = new Scanner(System.in);
	    	    String opcion = "";

	    	    while (!opcion.equals("n")) {
	    	        Auto auto = new Auto();
	    	        System.out.println("Ingrese los detalles del auto:");

	    	        System.out.print("ID: ");
	    	        auto.setId(scanner.nextLine());

	    	        System.out.print("Marca: ");
	    	        auto.setMarca(scanner.nextLine());

	    	        System.out.print("Modelo: ");
	    	        auto.setModelo(scanner.nextLine());

	    	        System.out.print("Año: ");
	    	        auto.setAño(scanner.nextLine());

	    	        System.out.print("Color: ");
	    	        auto.setColor(scanner.nextLine());

	    	        System.out.print("Tipo de Motor: ");
	    	        auto.setTipoMotor(scanner.nextLine());

	    	        System.out.print("Cilindrada: ");
	    	        auto.setCilindrada(scanner.nextLine());

	    	        System.out.print("Potencia: ");
	    	        auto.setPotencia(scanner.nextLine());

	    	        System.out.println("¿Desea agregar otro auto? (s/n)");
	    	        opcion = scanner.nextLine();

	    	        autos.getAutos().add(auto);
	    	    }

	    	    scanner.close();

	    	    marshaller.marshal(autos, new File("autos.xml"));
	    	
	    }

	}
