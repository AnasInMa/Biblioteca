package libro;

import java.util.*;

public class Libro {

	private String codigo, titulo, autor;
	private List<String> personajes;
	
	
	public Libro(String codigo, String titulo, String autor, List<String> personajes) {

		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.personajes = personajes;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Libro other = (Libro) obj;
		return Integer.valueOf(this.codigo).equals(Integer.valueOf(other.codigo));
	}
	
	@Override
	public String toString() {
		
		return this.codigo + ": " + this.titulo + 
				"( escrito por " + this.autor + " " + 
				this.personajes.toString() + ")";
	}


	/**Getter y Setter
	 * 
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getNombre() {
		return autor;
	}


	public void setNombre(String nombre) {
		this.autor = nombre;
	}


	public List<String> getPersonajes() {
		return personajes;
	}


	public void setPersonajes(List<String> personajes) {
		this.personajes = personajes;
	}
	
	
}
