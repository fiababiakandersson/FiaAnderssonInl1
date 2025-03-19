package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
// @Table(name="TBL_BOOK" )
public class PowerUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // @Column(name="ISBN_NUM")
    private String powerUpName;
    private int xp;

    // @ManyToOne
    // private Author author;

    public PowerUp() {
    }

    public PowerUp(String powerUpName) {
        this.powerUpName = powerUpName;
    }

    public PowerUp(String powerUpName, int xp) {
        this.powerUpName = powerUpName;
        this.xp = xp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPowerUpName() {
        return powerUpName;
    }

    public void setPowerUpName(String powerUpName) {
        this.powerUpName = powerUpName;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return "PowerUp [id=" + id + ", powerUpName=" + powerUpName + ", xp=" + xp + "]";
    }

}
