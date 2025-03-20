package se.yrgo.test;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

import se.yrgo.domain.*;

public class TestMain {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        // create session

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // create SpiderMan and his abilites

        GameCharacter spiderman = new GameCharacter("Spider-Man");
        PowerUp spiderPower = new PowerUp("Spider-Power", 25);
        PowerUp webCluster = new PowerUp("Web-Cluster", 30);
        PowerUp spectacularSpid = new PowerUp("Spectacular Spin", 40);

        spiderman.addPowerUpToCharacterGroup(spiderPower);
        spiderman.addPowerUpToCharacterGroup(webCluster);
        spiderman.addPowerUpToCharacterGroup(spectacularSpid);

        List<PowerUp> spiderManPowerUps = spiderman.getPowerUpCollection();

        for (PowerUp powerUp : spiderManPowerUps) {
            System.out.println(powerUp);
        }

        session.save(spiderPower);
        session.save(webCluster);
        session.save(spectacularSpid);
        session.save(spiderman);

        // create Venom and his abilites

        GameCharacter venom = new GameCharacter("Venom");
        PowerUp darkPredation = new PowerUp("Dark Predation", 20);
        PowerUp feastOfTheAbyss = new PowerUp("Feast Of The Abyss", 50);
        PowerUp frenziedArrival = new PowerUp("Frenzied Arrival", 65);

        venom.addPowerUpToCharacterGroup(darkPredation);
        venom.addPowerUpToCharacterGroup(feastOfTheAbyss);
        venom.addPowerUpToCharacterGroup(frenziedArrival);

        List<PowerUp> venomPowerUps = venom.getPowerUpCollection();

        for (PowerUp powerUp : venomPowerUps) {
            System.out.println(powerUp);
        }

        session.save(darkPredation);
        session.save(feastOfTheAbyss);
        session.save(frenziedArrival);
        session.save(venom);

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
