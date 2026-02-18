package usuario;

import libro.Libro;
import java.util.*;

public class Usuario implements InterfazUsuario{

	private String nombre;
	private Set<Libro> librosSacados;

	public Usuario(String nombre) {
		
		this.nombre = nombre;
		this.librosSacados = new HashSet<>();
	}
	
	@Override
	public boolean sacaLibro(Libro lib) throws UsuarioException {
		
		if (puedeSacarMasLibros()) {
			
			this.librosSacados.add(lib);
			
			return true;
		}
		
		throw new UsuarioException("El usuario " + this.nombre + " no puede sacar mas de 10 libros");
	}

	@Override
	public int cantidadLibrosSacados() {
		
		return this.librosSacados.size();
	}

	@Override
	public boolean puedeSacarMasLibros() {
		
		return (this.cantidadLibrosSacados() < 10)? true : false;
	}

	/**Metodo que busca un libro por titulo,
	 * en caso de encontrarlo saca ese libro de la
	 * coleccion de libros del usuario y lo devuelve
	 * 
	 * @return Libro
	 */
	@Override
	public Libro devuelveLibro(String tit) {
		
		Libro libro = null;
		boolean encontrado = false;
		
		for(Iterator<Libro> iterator = this.librosSacados.iterator();
				iterator.hasNext() && !encontrado;) {
			
			libro = iterator.next();
			
			if(libro.getTitulo().equalsIgnoreCase(tit)) {
				
				encontrado = true;
			}
			
			libro = null;
		}
		
		return libro;
	}

	
	@Override
	public int hashCode() {
		
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		
		//return Objects.equals(nombre, other.nombre);
		return this.nombre.equalsIgnoreCase(other.nombre);
	}
	
	@Override
	public String toString(){
		
		if(!this.puedeSacarMasLibros()) {
			
			String cadena = this.nombre + " (";
			
			for(Libro lib : this.librosSacados) {
				
				cadena += lib.getTitulo() + "; ";
			}
			
			return cadena + ")";
		}
		
		return this.nombre + " (No tiene libros sacados)";
	}
	

	/**Getters y Setters
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibrosSacados() {
		return librosSacados;
	}

	public void setLibrosSacados(Set<Libro> librosSacados) {
		this.librosSacados = librosSacados;
	}
	
	
}
