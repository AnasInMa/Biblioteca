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
	public boolean sacaLibro(Libro lib) {
		
		if (puedeSacarMasLibros()) {
						
			this.numLibrosSacados++;
			
			this.librosSacados.add(lib);
			
			return true;
		}
		
		return false;
	}

	@Override
	public int cantidadLibrosSacados() {
		
		return this.librosSacados.size();
	}

	@Override
	public boolean puedeSacarMasLibros() {
		
		return (this.cantidadLibrosSacados() < 10)? true : false;
	}

	@Override
	public Libro devuelveLibro(String tit) {
		
		Libro libro;
		
		for(Iterator<Libro> iterator = this.librosSacados.iterator();
				iterator.hasNext();) {
			
			libro = iterator.next();
			
			if(libro.getTitulo().equals(tit)) {
				
				
			}
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
		return nombre.equalsIgnoreCase(other.nombre);
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
