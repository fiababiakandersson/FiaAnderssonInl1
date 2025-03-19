package se.yrgo.domain;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "AUTHOR_FK")
    private Set<PowerUp> powerUpCollection;

    public GameCharacter() {
    }

    public GameCharacter(String name) {
        this.name = name;
        this.powerUpCollection = new HashSet<PowerUp>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPowerUpToPowerUpCollection(PowerUp newPowerUp) {
        this.powerUpCollection.add(newPowerUp);
    }

    public Set<PowerUp> getPowerUpCollection() {
        Set<PowerUp> unmodifiable = Collections.unmodifiableSet(this.powerUpCollection);
        return unmodifiable;
    }

    @Override
    public String toString() {
        return "GameCharacter [id=" + id + ", name=" + name + ", powerUpCollection=" + powerUpCollection + "]";
    }

}
