package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
//@Table(name="TBL_BOOK" )
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    //@Column(name="ISBN_NUM")
    private String isbn;
    private String title;

    //@ManyToOne
    //private Author author;

    @Transient
    private Integer numberOfPages;

    public Book() {}

    public Book(String title) {
        this.title= title;
    }

    public Book(String isbn, String title) {
        this.isbn= isbn;
        this.title = title;
    }

    public String getIsbn (){
        return isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    /*
    public Author getAuthor() {
        return author;
    }




    public void allocateAuthor(Author author) {
        this.author=author;
    }

    public String getAuthorName() {
        return this.author.getName();
    }

*/
    public void setTitle(String title) {
        this.title= title;
    }

    public String toString() {
        return  " isbn: " + isbn  + " , title: "+  title  ;
    }
}
