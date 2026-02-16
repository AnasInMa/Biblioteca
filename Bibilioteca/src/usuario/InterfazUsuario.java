package usuario;

import libro.Libro;

public interface InterfazUsuario {

	public boolean sacaLibro(Libro lib) throws UsuarioException;
	public int cantidadLibrosSacados();
	public boolean puedeSacarMasLibros();
	public Libro devuelveLibro(String tit);
}
