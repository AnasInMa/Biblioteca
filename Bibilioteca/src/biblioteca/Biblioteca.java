package biblioteca;

import java.util.*;

import libro.Libro;
import usuario.Usuario;
import usuario.UsuarioException;

public class Biblioteca implements InterfazBiblioteca {

	Set<Usuario> usuarios;
	SortedSet<Libro> libros; // coleccion de libros de la biblioteca

	public Biblioteca(HashSet<Usuario> usuarios, TreeSet<Libro> libros) {

		this.usuarios = usuarios;
		this.libros = libros;
	}

	public Biblioteca() {

		this(new HashSet<>(), new TreeSet<>((o1, o2) -> o1.compareTo(o2)));
	}

	@Override
	public boolean altaUsuario(Usuario usu) {

		if (buscarUsuario(usu.getNombre()) == null) {

			usuarios.add(usu);
			return true;
		}

		return false;
	}

	@Override
	public boolean altaLibro(Libro lib) {

		this.libros.add(lib);
		return true;
	}

	/**
	 * Método que busca un libro en la biblioteca, en caso de encontrarlo lo
	 * devuelve y ademas lo elimina de la coleccion de libros de la biblioteca
	 * 
	 * @return Libro
	 */
	@Override
	public Libro sacarLibro(String tit) {

		Libro libro = null;

		for (Libro lib : this.libros) {

			if (lib.getTitulo().equalsIgnoreCase(tit)) {

				libro = lib;
			}
		}
		
		this.libros.remove(libro);

		return libro;
	}

	@Override
	public Usuario buscarUsuario(String nom) {

		Usuario usuario = null;

		for (Usuario us : this.usuarios) {

			if (us.getNombre().equalsIgnoreCase(nom)) {

				usuario = us;
			}
		}

		return usuario;
	}

	/**
	 * Metodo que busca un libro con el metodo sacarLibro(), y en caso de
	 * encontrarlo lo quita de la coleccion del usuario y lo añade al de la
	 * biblioteca.
	 * 
	 * En caso de haber encontrado el libro, busca el usuario por el nombre pasado
	 * como paramentro con el metodo buscarUsuario(), y si lo quita el libro de la
	 * biblioteca
	 * 
	 * @return boolean
	 */
	@Override
	public boolean prestarLibro(String titulo, String nombre) {

		Libro libro = this.sacarLibro(titulo);

		if (libro != null) {

			try {

				this.buscarUsuario(nombre).sacaLibro(libro);

			} catch (UsuarioException e) {

				System.err.println("ERROR. El usuario no esta registrado");

				return false;
			}

			return true;
		}

		return false;
	}

	/**
	 * Método que devuelve verdadero en caso de que el libro buscado no sea null
	 * 
	 * @return boolean
	 */
	@Override
	public boolean devolverLibro(String titulo, String nombre) {

		boolean encontrado = false;
		Libro libro = this.buscarUsuario(nombre).devuelveLibro(titulo);

		if (libro != null) {

			encontrado = true;
		}

		return encontrado;
	}

	/**
	 * Devuelve una cadena con todas los libros disponibles en la biblioteca
	 * 
	 * @return String
	 */
	@Override
	public String librosDisponibles() {

		String cadena = "";

		for (Libro libro : this.libros) {

			cadena += libro.toString() + "\n";
		}

		return cadena;
	}

	/**
	 * Devuelve una cadena con todos las libros sacados por un determinado usuario
	 * 
	 * @return String
	 */
	@Override
	public String librosPrestadosUsuario(String nombre) {

		String cadena = "";

		for (Libro libro : this.buscarUsuario(nombre).getLibrosSacados()) {

			cadena += libro + "\n";
		}

		return cadena;
	}

	@Override
	public SortedSet<Libro> copias(String titulo) {
		
		SortedSet<Libro> copiaLibros = new TreeSet<>();
		
		for(Libro lib : this.libros) {
			
			if(lib.getTitulo().equalsIgnoreCase(titulo)) {
				
				copiaLibros.add(lib);
			}
		}
			
		return copiaLibros;
	}

	@Override
	public Set<Libro> getLibrosUsuario(String nomCli) {
		
		return this.buscarUsuario(nomCli).getLibrosSacados();
	}

}
