package hh.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.bookstore.Models.BookRepository;
import hh.bookstore.Models.CreateBook;

import org.springframework.ui.Model;

@Controller
public class BookController {
    private BookRepository bookRepository;

    // Konstruktorin avulla Spring Boot injektoi BookRepository-olion
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Listaa kaikki kirja automaattisesti tietokannasta ja näyttää ne
    // booklist.html:ssä
    @GetMapping("/booklist")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new CreateBook());

        return "addbook"; // addbook.html
    }

    @PostMapping("/addbook")
    public String saveBook(CreateBook book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookid, Model model) {
        bookRepository.deleteById(bookid);
        return "redirect:/booklist";
    }

}
