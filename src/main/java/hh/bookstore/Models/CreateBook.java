package hh.bookstore.Models;
//import org.hibernate.annotations.Columns;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // tietokanta entity
@Table(name = "CreateBook") // tietokanta taulu nimi
public class CreateBook {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Tietokanta generoi id:n automaattisesti
    private Long bookid;

    // konstruktorit, getterit ja setterit
    @Column(name = "booktitle")
    public String title;
    public String author;
    public String publicationYear;
    public String isbn;
    public double price;

    public CreateBook() {
    }

    public CreateBook(String title, String author, String publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
