package se.yrgo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Author;
import se.yrgo.domain.Book;

import java.util.Set;


public class HarnessTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Book book1= new Book( "123","My book 1" );
        Book book2= new Book("234","My book 2");
        Book book3= new Book( "345", "My book 3");

        Author author = new Author("Arthur Bengt");


        author.addBookToBookCollection(book1);
        author.addBookToBookCollection(book2);
        author.addBookToBookCollection(book3);
       // session.save(book1);
        //session.save(book2);
        //session.save(book3);
        //session.save(author);

        //Retrieve the author from the database
        Author author_from_database = session.get(Author.class, 44);
        System.out.println (author_from_database);
        Set<Book> books = author_from_database.getBookCollection();
        for (Book b :books) {
            System.out.println (b);
        }



        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if(sessionFactory ==null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
