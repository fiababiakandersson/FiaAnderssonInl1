package se.yrgo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.GameCharacter;
import se.yrgo.domain.PowerUp;

import java.util.Set;


public class HarnessTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        PowerUp book1= new PowerUp( "123","My book 1" );
        PowerUp book2= new PowerUp("234","My book 2");
        PowerUp book3= new PowerUp( "345", "My book 3");

        GameCharacter author = new GameCharacter("Arthur Bengt");


        author.addBookToBookCollection(book1);
        author.addBookToBookCollection(book2);
        author.addBookToBookCollection(book3);
       // session.save(book1);
        //session.save(book2);
        //session.save(book3);
        //session.save(author);

        //Retrieve the author from the database
        GameCharacter author_from_database = session.get(GameCharacter.class, 44);
        System.out.println (author_from_database);
        Set<PowerUp> books = author_from_database.getBookCollection();
        for (PowerUp b :books) {
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
