package usuario;

import libro.Libro;

public interface InterfazUsuario {

	public boolean sacaLibro(Libro lib);
	public int cantidadLibrosSacados();
	public boolean puedeSacarMasLibros();
	public Libro devuelveLibro(String tit);
}
