package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.bookstore.Models.CreateBook;
import hh.bookstore.Models.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository Bookepository) {
		return (args) -> {
			// Tallenna esimerkki kirjoja tietokantaan
			Bookepository
					.save(new CreateBook("The Great Gatsby", "F. Scott Fitzgerald", "1925", "978-0743273565", 10.99));
			Bookepository.save(new CreateBook("To Kill a Mockingbird", "Harper Lee", "1960", "978-0061120084", 7.99));
			Bookepository.save(new CreateBook("1984", "George Orwell", "1949", "978-0451524935", 8.99));
		};
	}

}
