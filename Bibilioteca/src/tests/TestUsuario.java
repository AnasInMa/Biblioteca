package tests;

import usuario.Usuario;
import usuario.UsuarioException;

import java.util.Arrays;

import libro.Libro;

public class TestUsuario {

	public static void main(String[] args) {

		Usuario usuario1 = new Usuario("Pedro Sánchez");
		
		Usuario usuario2 = new Usuario("Santiago Abascal");
		
		Libro libro1 = new Libro("0001", "La Metamorfosis", "Franz Kafka", 
			    Arrays.asList("Gregor Samsa"));

		Libro libro2 = new Libro("0002", "Estudio en escarlata", "Arthur Conan Doyle", 
		    Arrays.asList("Sherlock Holmes", "Dr. John Watson"));

		Libro libro3 = new Libro("0003", "Los Juegos del Hambre", "Suzanne Collins", 
		    Arrays.asList("Katniss Everdeen", "Peeta Mellark", "Gale Hawthorne"));

		Libro libro4 = new Libro("0004", "Los Tres Mosqueteros", "Alexandre Dumas", 
		    Arrays.asList("D'Artagnan", "Athos", "Porthos", "Aramis"));

		Libro libro5 = new Libro("0005", "It", "Stephen King", 
		    Arrays.asList("Bill Denbrough", "Beverly Marsh", "Richie Tozier", "Ben Hanscom", "Pennywise"));

		Libro libro6 = new Libro("0006", "Charlie y la fábrica de chocolate", "Roald Dahl", 
		    Arrays.asList("Charlie Bucket", "Willy Wonka", "Augustus Gloop", "Veruca Salt", "Violet Beauregarde", "Mike Teavee"));

		Libro libro7 = new Libro("0007", "Harry Potter y la piedra filosofal", "J.K. Rowling", 
		    Arrays.asList("Harry Potter", "Ron Weasley", "Hermione Granger", "Albus Dumbledore", "Severus Snape", "Rubeus Hagrid", "Draco Malfoy"));

		Libro libro8 = new Libro("0008", "El león, la bruja y el ropero", "C.S. Lewis", 
		    Arrays.asList("Aslan", "Lucy Pevensie", "Edmund Pevensie", "Peter Pevensie", "Susan Pevensie", "Jadis", "Sr. Tumnus", "Sr. Castor"));

		Libro libro9 = new Libro("0009", "La Comunidad del Anillo", "J.R.R. Tolkien", 
		    Arrays.asList("Frodo", "Sam", "Merry", "Pippin", "Aragorn", "Boromir", "Legolas", "Gimli", "Gandalf"));

		Libro libro10 = new Libro("0010", "Diez negritos", "Agatha Christie", 
		    Arrays.asList("Justice Wargrave", "Vera Claythorne", "Philip Lombard", "William Blore", "Dr. Armstrong", "Emily Brent", "Thomas Rogers", "Ethel Rogers", "Anthony Marston", "John MacArthur"));
		
		Libro libro11 = new Libro("0011", "Moby Dick", "Herman Melville", 
			    Arrays.asList("Ismael", "Capitán Ahab", "Queequeg", "Starbuck", "Stubb", "Flask"));

		
		try {
			
			usuario1.sacaLibro(libro1);
			usuario1.sacaLibro(libro2);
			usuario1.sacaLibro(libro3);
			usuario1.sacaLibro(libro4);
			usuario1.sacaLibro(libro5);
			usuario1.sacaLibro(libro6);
			usuario1.sacaLibro(libro7);
			usuario1.sacaLibro(libro8);
			usuario1.sacaLibro(libro9);
			usuario1.sacaLibro(libro10);
			usuario1.sacaLibro(libro11);
		
		} catch (UsuarioException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(usuario1);
		
		System.out.println(usuario2);

	}

}
