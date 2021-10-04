package co.uniquindio.prog2.biblioteca.aplicacion;

import javax.swing.JOptionPane;

import co.uniquindio.prog2.biblioteca.model.Biblioteca;
import co.uniquindio.prog2.biblioteca.model.Bibliotecario;
import co.uniquindio.prog2.biblioteca.model.Estudiante;
import co.uniquindio.prog2.biblioteca.model.Libro;
import co.uniquindio.prog2.biblioteca.model.Modalidad;
import co.uniquindio.prog2.biblioteca.model.Prestamo;

public class Aplicacion {
	
	public static void main(String[] args) {
		

		int opcion = 0;
		int opcion1=0;
		
		//biblioteca
		String nombreBiblioteca = "";
		String direccionBiblioteca = "";
		Biblioteca biblioteca = null;
		
		//variables libros
		String codigo;
		String isbn;
		String titulo;
		String autor;
		int numeroPaginas;
		String editorial;
		String estado;
		String fechaPublicacion;
		int cantidadDisponible;
		
		//variables estudiante
		String nombreEstudiante;
		String identificacionEstudiante;
		String direccionEstudiante;
		String telefonoEstudiante;
		String identificacionLibro;
		Modalidad modalidad;
		Estudiante estudiante = null;
		Bibliotecario bibliotecario = null;
		
		//variables prestamo
		String fechaPrestamo;
		String fechaDevolucion;
		
		
		String mensaje = "";
		boolean resultado = false;
		
		imprimir("Bienvenidos a la aplicacion Biblioteca");
		
		nombreBiblioteca = leerStringVentana("Ingrese el nombre de la biblioteca");
		direccionBiblioteca = leerStringVentana("Ingrese la direccion de la biblioteca");
		biblioteca = new Biblioteca(nombreBiblioteca,direccionBiblioteca);
		
		do {
			opcion = mostrarMenu();

			switch (opcion) {
			
			case 1:
				//crear estudiante
				nombreEstudiante = leerStringVentana("Ingrese el nombre del estudiante");
				identificacionEstudiante = leerStringVentana("\"Ingrese la identificacion del estudiante\"");
				direccionEstudiante = leerStringVentana("\"Ingrese la direccion del estudiante\"");
				telefonoEstudiante = leerStringVentana("\"Ingrese el telefono del estudiante\"");
				
				resultado = validarInformacionEstudiante(nombreEstudiante,identificacionEstudiante,direccionEstudiante,telefonoEstudiante);
				if(resultado) {
					mensaje = biblioteca.crearEstudiante(nombreEstudiante,identificacionEstudiante,direccionEstudiante,telefonoEstudiante);
					imprimir(mensaje);
				}else {
					imprimirError(mensaje);
				}
				break;
				
			case 2:
				//identificacion estudiante
				identificacionEstudiante = leerStringVentana("\"Ingrese la identificacion del estudiante\"");
				if(resultado) {
					 estudiante = biblioteca.consultarEstudiante(identificacionEstudiante);
					imprimir(estudiante.toString());
				}else {
					imprimirError(mensaje);
				}

				break;
				
			case 3:
				//Eliminar estudiante
				identificacionEstudiante=leerStringVentana("\"Ingrese la identificacion del estudiante\"");
				if(resultado) {
					mensaje = biblioteca.eliminarEstudiante(identificacionEstudiante);
					imprimir(mensaje);
				}else {
					imprimirError(mensaje);
				}
				break;
				
			case 4:
				//Actualizar estudiante
				identificacionEstudiante = leerStringVentana("\"Ingrese la identificacion del estudiante\"");

				if(resultado) {
					nombreEstudiante = leerStringVentana("Ingrese el nuevo nombre del estudiante en caso de cambio");
					direccionEstudiante = leerStringVentana("\"Ingrese la nueva direccion del estudiante en caso de cambio\"");
					telefonoEstudiante = leerStringVentana("\"Ingrese el telefono del estudiante en caso de cambio\"");
					mensaje = biblioteca.actualizarEstudiante(nombreEstudiante,identificacionEstudiante,direccionEstudiante,telefonoEstudiante);
					imprimir(mensaje);
				}else {
					imprimirError(mensaje);
				}
				break;
				
			case 5:
				//libros (HACER CRUD)
				do {
				opcion1=mostrarMenuLibros();
				switch (opcion1) {
				
				case 1:
					//crear libro
					codigo = leerStringVentana("Ingrese el codigo del libro");
					isbn = leerStringVentana("\"Ingrese la identificacion del libro\"");
					titulo = leerStringVentana("\"Ingrese el titulo del libro\"");
					autor = leerStringVentana("\"Ingrese el autor del libro\"");
					numeroPaginas = leerEnteroVentana("\"Ingrese el numero de paginas del libro\"");
					editorial = leerStringVentana("\"Ingrese la editorial del libro\"");
					estado = leerStringVentana("\"Ingrese el estado del libro\"");
					fechaPublicacion = leerStringVentana("\"Ingrese la fecha de publicacion del libro dd/mm/aa\"");
					cantidadDisponible = leerEnteroVentana("\"Ingrese la cantidad de libros disponibles\"");
					
					resultado = validarInformacionLibro(codigo, isbn, titulo, autor, cantidadDisponible);
					if(resultado) {
						mensaje = biblioteca.crearLibro(codigo, isbn, titulo, autor, numeroPaginas, editorial,
								 estado,  fechaPublicacion,  cantidadDisponible);
						imprimir(mensaje);
					}else {
						imprimirError(mensaje);
					}
					break;	
				
				case 2:
					//consultar libro
					codigo = leerStringVentana("\"Ingrese el codigo del libro\"");
					if(resultado) {
						Libro libro = biblioteca.consultarLibro(codigo);
						imprimir(libro.toString());
					}else {
						imprimirError(mensaje);
					}

					break;
					
				case 3:
					//Hacer prestamo
					fechaPrestamo = leerStringVentana("\"Ingrese la fecha del prestamo dd/mm/aa\"");
					titulo= leerStringVentana("\"Ingrese el titulo del libro\"");
					codigo=leerStringVentana("\"Ingrese el codigo del libro\"");
					fechaDevolucion=leerStringVentana("\"Ingrese la fecha de devolucio\"");
					
					resultado= validarInformacionPrestamo(fechaPrestamo, titulo, codigo, fechaDevolucion);
					if(resultado) {
						mensaje = biblioteca.crearPrestamo(fechaPrestamo, titulo,  codigo,  fechaDevolucion, estudiante, bibliotecario);
						imprimir(mensaje);
					}else {
						imprimirError(mensaje);
					}

					break;
					
				case 4:
					//consultarPrestamo
					titulo=leerStringVentana("\"Ingrese el titulo del libro\"");
					
					resultado=validarInformacionConsultarPresta(titulo);
					if(resultado) {
						mensaje=biblioteca.consultarPrestamo(titulo);
						imprimir(mensaje);
					}else {
						imprimirError(mensaje);
					}
					
				case 5:
					
					
				default:
					break;
				}
				}while(opcion1!=6);
				
			break;
			
			}
		}while(opcion!=6);
		
	}
	
	/**
	 * Permite imprimir un mensaje
	 * @param mensaje El mensaje a imprimir
	 */
	public static void imprimir (String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
	public static String  leerStringVentana(String mensaje) {
		String respuesta = "";
		respuesta  = JOptionPane.showInputDialog(mensaje);
		return respuesta;

	}
	
	private static boolean validarInformacionEstudiante(String nombreEstudiante, String identificacionEstudiante,
			String direccionEstudiante, String telefonoEstudiante) {
		
		boolean valido = true;
		if(nombreEstudiante.equalsIgnoreCase("") || identificacionEstudiante.equalsIgnoreCase("")
				||direccionEstudiante.equalsIgnoreCase("") ||telefonoEstudiante.equalsIgnoreCase("")) {
			valido = false;
		}
		
		if(!isNumeric(telefonoEstudiante)) {
			valido = false;
		}
		return valido;
	}
	
	private static boolean validarInformacionLibro(String codigo, String isbn, String titulo, String autor, int cantidadDisponible ) {
		
		boolean valido = true;
		if(codigo.equalsIgnoreCase("") || isbn.equalsIgnoreCase("") || titulo.equalsIgnoreCase("") || autor.equalsIgnoreCase("")  ) {
			valido = false;
		}
		
		if(!isNumeric2(codigo, isbn)) {
			valido = false;
		}
	
		return valido;
	}
	
private static boolean validarInformacionPrestamo(String fechaPrestamo, String titulo, String codigo, String fechaDevolucion)
{
		
		boolean valido = true;
		if(fechaPrestamo.equalsIgnoreCase("") || titulo.equalsIgnoreCase("") || codigo.equalsIgnoreCase("") || fechaDevolucion.equalsIgnoreCase("")  ) {
			valido = false;
		}
		
		if(!isNumeric(codigo)) {
			valido = false;
		}
	
		return valido;
	}

private static boolean validarInformacionConsultarPresta(String titulo) {
	
	boolean valido = true;
	if(titulo.equalsIgnoreCase("")) {
		valido = false;
	}
	
	return valido;
}

	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private static boolean isNumeric2(String cadena, String cadena2){
		try {
			Integer.parseInt(cadena);
			Integer.parseInt(cadena2);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private static void imprimirError(String mensaje) {
		JOptionPane.showInputDialog(null, "Por favor ingresar datos validos", "Error!", JOptionPane.ERROR_MESSAGE);
		
	}
	
	private static int mostrarMenu() {
		int opcion = 0;
		String menu = "Seleccione la opcion que desea realizar :\n"
				+ " Opciones Estudiantes\n"
				+ "1 Crear un Estudiante\n"
				+ "2 Consultar un Estudiante\n"
				+ "3 Eliminar un Estudiante\n"
				+ "4 Actualizar un Estudiante\n"
				+ "5 Opciones Libros\n\n"
				+ "6 Salir\n";
		
		opcion = leerEnteroVentana(menu);
		return opcion;
	}
	
	private static int mostrarMenuLibros() {
		int opcion = 0;
		String menu = "Seleccione la opcion que desea realizar :\n"
				+ " Opciones Libros\n"
				+ "1 Crear libro\n"
				+ "2 Consultar un libro por codigo\n"
				+ "3 Hacer un prestamo\n" 
				+ "4 Consultar en prestamos libros\n"
				+ "5 Libros prog2 distancia\n"
				+ "6 Salir\n";


	
		
		opcion = leerEnteroVentana(menu);
		return opcion;
	}
	
	/**
	 * Permite leer un numero entero mediante una caja de dialogo 
	 * @param mensaje El mensaje que ver� el usuario 
	 * @return el numero ingresado por el usuario
	 */
	public static int leerEnteroVentana (String mensaje)
	{
		int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return dato;
	}
	

}
