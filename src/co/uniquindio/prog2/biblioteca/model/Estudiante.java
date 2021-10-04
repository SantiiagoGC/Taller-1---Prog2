package co.uniquindio.prog2.biblioteca.model;

/**
 * Clase Estudiante que representa al estudiante
 * @author johangiraldohurtado
 * @date 21/09/2021
 */
public class Estudiante {
	
	/**
	 * Este atributo representa al nombre del estudiante
	 */
	private String nombre;
	
	/**
	 * Este atributo representa a la identificacioon del estudiante
	 */
	private String identificacion;
	
	/**
	 * Este atributo representa la direccion del estudiante
	 */
	private String direccion;
	
	/**
	 * Este atributo representa el telefono del estudiante
	 */
	private String telefono;
	
	private Modalidad modalidad;

	/**
	 * Metodo constructor que permite inicializar la clase Estudiante con sus atributos
	 * @param nombre Este parametro representa al nombre del estudiante
	 * @param identificacion Este parametro representa a la identificacioon del estudiante
	 * @param direccion Este parametro representa la direccion del estudiante
	 * @param telefono Este parametro representa el telefono del estudiante
	 */
	public Estudiante(String nombre, String identificacion, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	/**
	 * Metodo get de la clase estudiante que me permite obtener el nombre del estudiante
	 * @return El nombre del estudiante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set de la clase estudiante que me permite modificar el nombre del estudiante
	 * @param nombre El nombre que se va ha modificar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public String toString () {
		String cadenaEstudiante = "";

		cadenaEstudiante = "Mi nombre es " + nombre + ", mi identificacion es " +
				identificacion + ",  vivo en " + direccion + ", mi telefono es " + telefono;

		return cadenaEstudiante;
	}
	
	public boolean verificarNombre(String nombreBuscar) {

		if(getNombre().equals(nombreBuscar)) {
			return true;
		}
		return false;
	}
	
	//metodo que verifica si la modalidad es a distancia
	public boolean verificarModalidad() {
		boolean bandera=false;
		
		if(modalidad.getModalidad()==1) {
			bandera=true;
		}
		
		return bandera;
	}

	
}
