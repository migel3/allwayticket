package by.alex.allwayticket.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "single_route")
public class SingleRoute implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "from_st")
    private Station from;

    @OneToOne
    @JoinColumn(name = "to_st")
    private Station to;


    private double distance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
