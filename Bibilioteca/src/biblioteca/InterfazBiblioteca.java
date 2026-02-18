package biblioteca;

import java.util.*;

import libro.Libro;
import usuario.Usuario;

public interface InterfazBiblioteca {

	boolean altaUsuario(Usuario usu);
	boolean altaLibro(Libro lib);
	Libro sacarLibro(String tit);
	Usuario buscarUsuario(String nom);
	boolean prestarLibro(String titulo, String nombre);
	boolean devolverLibro(String titulo, String nombre);
	String librosDisponibles();
	String librosPrestadosUsuario(String nombre);
	SortedSet<Libro> copias(String titulo);
	Set<Libro> getLibrosUsuario(String nomCli);
}
