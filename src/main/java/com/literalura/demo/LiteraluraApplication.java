package com.literAlura;

import com.literalura.model.Book;
import com.literalura.service.BookService;
import com.literalura.service.ExternalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private BookService bookService;

	@Autowired
	private ExternalBookService externalBookService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar libros registrados");
			System.out.println("3. Listar autores registrados");
			System.out.println("4. Listar autores vivos en determinado año");
			System.out.println("5. Listar libros por idioma");
			System.out.println("6. Salir");

			int option = 0;
			try {
				option = scanner.nextInt();
				scanner.nextLine(); // consume newline
			} catch (InputMismatchException e) {
				System.out.println("Opción no válida. Por favor ingrese un número.");
				scanner.nextLine(); // clear invalid input
				continue;
			}

			switch (option) {
				case 1:
					System.out.println("Ingrese el título del libro:");
					String title = scanner.nextLine();
					if (title.trim().isEmpty()) {
						System.out.println("El título no puede estar vacío.");
						break;
					}
					Book book = externalBookService.searchBookByTitle(title);
					if (book != null) {
						if (bookService.isBookExists(book)) {
							System.out.println("El libro ya existe en la base de datos.");
						} else {
							bookService.saveBook(book);
							System.out.println("Libro agregado: " + book.getTitle());
						}
					} else {
						System.out.println("Libro no encontrado.");
					}
					break;
				case 2:
					bookService.listAllBooks().forEach(b -> System.out.println(b.getTitle()));
					break;
				case 3:
					bookService.listAuthors().forEach(a -> System.out.println(a.getName()));
					break;
				case 4:
					System.out.println("Ingrese el año:");
					int year;
					try {
						year = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Año no válido.");
						scanner.nextLine(); // clear invalid input
						break;
					}
					bookService.listAuthorsAliveInYear(year).forEach(a -> System.out.println(a.getName()));
					scanner.nextLine(); // consume newline
					break;
				case 5:
					System.out.println("Ingrese el idioma del libro (ES, EN, FR, PT):");
					String language = scanner.nextLine().toUpperCase();
					if (!language.matches("ES|EN|FR|PT")) {
						System.out.println("Idioma no válido.");
						break;
					}
					bookService.listBooksByLanguage(language).forEach(b -> System.out.println(b.getTitle()));
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Opción no válida.");
			}
		}
	}
}
