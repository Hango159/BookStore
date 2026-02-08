package hh.bookstore.Models;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<CreateBook, Long> {
    // CRUD-metodit (Create, Read, Update, Delete) periytyvät CrudRepositoryltä
}
