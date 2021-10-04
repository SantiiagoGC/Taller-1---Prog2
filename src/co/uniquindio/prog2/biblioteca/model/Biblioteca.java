package co.uniquindio.prog2.biblioteca.model;

import javax.swing.JOptionPane;

/**
 * Clase
 * @author johangiraldohurtado
 *
 */
public class Biblioteca {
	
	/**
	 * Atributo
	 */
	private String nombre;
	
	/**
	 * 
	 */
	private String direccion;
	
	//Relaciones
	private Libro libro1;
	private Libro libro2;
	private Libro libro3;
	private Prestamo prestamo1;
	private Prestamo prestamo2;
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	private Bibliotecario bibliotecario;
	private Modalidad modalidad;
	
	/**
	 * Construtor
	 * @param nombre
	 * @param direccion
	 */
	public Biblioteca(String nombre, String direccion){
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public Biblioteca(String nombre){
		this.nombre = nombre;
	}
	
	
	public Biblioteca() {
		super();
	}

	/**
	 * set nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * get nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * set direccion
	 * @param direccion Es el parametro que representa la direccion de la biblioteca
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * get direccion
	 * @return retorna la direccion de la biblioteca
	 */
	public String getDireccion() {
		return direccion;
	}
	
	

	public Libro getLibro1() {
		return libro1;
	}

	public void setLibro1(Libro libro1) {
		this.libro1 = libro1;
	}

	public Libro getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro libro2) {
		this.libro2 = libro2;
	}

	public Prestamo getPrestamo1() {
		return prestamo1;
	}

	public void setPrestamo1(Prestamo prestamo1) {
		this.prestamo1 = prestamo1;
	}

	public Prestamo getPrestamo2() {
		return prestamo2;
	}

	public void setPrestamo2(Prestamo prestamo2) {
		this.prestamo2 = prestamo2;
	}

	public Estudiante getEstudiante1() {
		return estudiante1;
	}

	public void setEstudiante1(Estudiante estudiante1) {
		this.estudiante1 = estudiante1;
	}

	public Estudiante getEstudiante2() {
		return estudiante2;
	}

	public void setEstudiante2(Estudiante estudiante2) {
		this.estudiante2 = estudiante2;
	}

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", libro1=" + libro1 + ", libro2=" + libro2
				+ ", prestamo1=" + prestamo1 + ", prestamo2=" + prestamo2 + ", estudiante1=" + estudiante1
				+ ", estudiante2=" + estudiante2 + ", bibliotecario=" + bibliotecario + "]";
	}

	//CRUD (Create, Research, Update, Delete)
	
	//Estudiante
	
	/**
	 * Crear Estudiante
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param telefono
	 * @return
	 */
	public String crearEstudiante(String nombre, String identificacion, String direccion, String telefono) {
		String mensaje = "No es posible crear más estudiantes";
		if(estudiante1 == null) {
			estudiante1 = new Estudiante(nombre, identificacion, direccion, telefono);
			mensaje = "Estudiante creado con exito";
		}
		else {
			if(estudiante2 == null) {
				estudiante2 = new Estudiante(nombre, identificacion, direccion, telefono);
				mensaje = "Estudiante creado con exito";
			}
		}
		
		return mensaje;
	}
	
	/**
	 * Crear Bibliotecario
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param telefono
	 * @return
	 */
	public String crearBibliotecario(String nombre, String identificacion, String direccion, String telefono) {
		String mensaje = "No es posible crear más estudiantes";
		if(bibliotecario == null) {
			bibliotecario = new Bibliotecario(nombre, identificacion, direccion, telefono);
			mensaje = "Estudiante creado con exito";
		}
		else {
			if(bibliotecario == null) {
				bibliotecario = new Bibliotecario(nombre, identificacion, direccion, telefono);
				mensaje = "Estudiante creado con exito";
			}
		}
		
		return mensaje;
	}
	
	/**
	 * Consultar Estudiante
	 * @param identificacionEstudiante
	 * @return
	 */
	public Estudiante consultarEstudiante(String identificacionEstudiante){
		Estudiante estudianteEncontrado = null;
		if(estudiante1 != null) {
			if(estudiante1.getIdentificacion().equals(identificacionEstudiante)) {
				estudianteEncontrado = estudiante1;
			}
		}
		if(estudianteEncontrado == null && estudiante2 != null ) {
			if(estudiante2.getIdentificacion().equals(identificacionEstudiante)) {
				estudianteEncontrado = estudiante2;
			}
		}
	
		return estudianteEncontrado;
		
	}
	
	/**
	 * Eliminar estudiante
	 * @param identificacionEstudiante
	 * @return
	 */
	public String eliminarEstudiante(String identificacionEstudiante) {
		String mensaje = "Estudiante no eliminardo";
		Estudiante estudianteEncontrado = null;
		estudianteEncontrado = consultarEstudiante(identificacionEstudiante);
		if(estudianteEncontrado != null) {
			if(estudiante1.equals(estudianteEncontrado)) {
				estudiante1 = null;
				mensaje = "Estudiante eliminado";
			} else {
				if(estudiante2.equals(estudianteEncontrado)) {
					estudiante2 = null;
					mensaje = "Estudiante eliminado";
				}
			}
		}
		
		return mensaje;
	}
	
	/**
	 * Actualizar estudiante
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param telefono
	 * @return
	 */
	public String actualizarEstudiante(String nombreEstudiante, String identificacionEstudiante, String direccionEstudiante, String telefonoEstudiante) {
		String mensaje = "Estudiante no actualizado";
		Estudiante estudianteEncontrado = null;
		estudianteEncontrado = consultarEstudiante(identificacionEstudiante);
		if(estudianteEncontrado != null) {
			estudianteEncontrado.setNombre(nombreEstudiante);
			estudianteEncontrado.setDireccion(direccionEstudiante);
			estudianteEncontrado.setTelefono(telefonoEstudiante);
			mensaje = "Estudiante actualizado";
		}
		return mensaje;
	}
	
	/**
	 * Crear libro
	 * @param nombreLibro
	 * @param isbn
	 * @return
	 */
	public String crearLibro(String codigo, String isbn, String titulo, String autor, int numeroPaginas, String editorial,
			String estado, String fechaPublicacion, int cantidadDisponible) {
		
		String mensaje = "No es posible crear mas libros";
		if(libro1 == null) {
			libro1 = new Libro(codigo, isbn, titulo, autor, numeroPaginas,  editorial,
					 estado,  fechaPublicacion,  cantidadDisponible);
			mensaje = "Libro creado con exito";
		}
		
		else {
			if(libro2 == null) {
				libro2 = new Libro(codigo, isbn, titulo, autor, numeroPaginas, editorial,
						 estado, fechaPublicacion, cantidadDisponible);
				mensaje = "Libro creado con exito";
				
			} else {
				if(libro3==null){
					libro3= new Libro(codigo, isbn, titulo, autor, numeroPaginas, editorial,
							 estado, fechaPublicacion, cantidadDisponible);
					mensaje= "Libro creado con exito";
				}
			}
		}
		
		return mensaje;
	}
	
	
	/**
	 * Consultar datosLibro
	 * @param codigoLibro
	 * @return
	 */
	
	public Libro consultarLibro(String codigoLibro){
		Libro libroEncontrado = null;
		if(libro1 != null) {
			if(libro1.getCodigo().equals(codigoLibro)) {
				libroEncontrado = libro1;
			}
		}
		if(libroEncontrado == null && libro2 != null ) {
			if(libro2.getCodigo().equals(codigoLibro)) {
				libroEncontrado = libro2;
			}
		}
		if(libroEncontrado == null && libro3 !=null) {
			if(libro3.getCodigo().equals(codigoLibro)) {
				libroEncontrado= libro3;
			}
		}
	
		return libroEncontrado;
		
	}
	
	
	public String crearPrestamo(String fechaPrestamo, String titulo, String codigo, String fechaDevolucion, Estudiante estudiante, Bibliotecario bibliotecario) {
		
		String mensaje = "Prestamo no creado";
		
		if(prestamo1 == null) {
			if(libro1.getTitulo().equals(titulo) || libro2.getTitulo().equals(titulo) || libro3.getTitulo().equals(titulo)){
			prestamo1 = new Prestamo(fechaPrestamo, titulo, codigo, fechaDevolucion, estudiante1,bibliotecario);
			mensaje = "Prestamo creado con exito";
			}
		}
		else {
			if(prestamo2 == null) {
				if(libro1.getTitulo().equals(titulo) || libro2.getTitulo().equals(titulo) || libro3.getTitulo().equals(titulo)) {
				prestamo2 = new Prestamo( fechaPrestamo, titulo,  codigo,  fechaDevolucion, estudiante2, bibliotecario);
				mensaje = "Prestamo creado con exito";
				}
			}
		}
		
		return mensaje;
	}
	
	
	public String consultarPrestamo(String titulo) {
		
		String mensaje="No esta en ningun prestamo";
		
		if(prestamo1!=null) {
			if(titulo.equals(prestamo1.getTitulo())) {
			mensaje="El libro esta en un prestamo";
			}
		
		if(prestamo2!=null) {
			if(titulo.equals(prestamo2.getTitulo())){
			mensaje="El libro esta en un prestamo";
			}
		} 
				
		if(prestamo1!=null && prestamo2!=null) {
				if(titulo.equals(prestamo1.getTitulo()) && titulo.equals(prestamo2.getTitulo())){
					mensaje="El libro esta en dos prestamos";
				}
		}}
	
		return mensaje;

	}
	
	

	
	

}
