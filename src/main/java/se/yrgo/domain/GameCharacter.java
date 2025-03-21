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
    @JoinColumn(name = "POWERUP_FK")
    private List<PowerUp> powerUpCollection;

    public GameCharacter() {
    }

    public GameCharacter(String name) {
        this.name = name;
        this.powerUpCollection = new ArrayList<PowerUp>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPowerUpToCharacterGroup(PowerUp newPowerUp) {
        this.powerUpCollection.add(newPowerUp);
    }

    public List<PowerUp> getPowerUpCollection() {
        List<PowerUp> unmodifiable = Collections.unmodifiableList(this.powerUpCollection);
        return unmodifiable;
    }

    @Override
    public String toString() {
        return "GameCharacter [id=" + id + ", name=" + name + ", powerUpCollection=" + powerUpCollection + "]";
    }

}
