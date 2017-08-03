package by.alex.allwayticket.entities;

import by.alex.allwayticket.enums.TypeTrain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "train")
public class Train implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeTrain type;

    @OneToMany(mappedBy = "train",fetch = FetchType.EAGER)
    private List<Station> stations;

   /* @OneToMany(mappedBy ="train", fetch = FetchType.EAGER)
    private Set<TrainScheduler> scheduler;
*/



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public TypeTrain getType() {
        return type;
    }

    public void setType(TypeTrain type) {
        this.type = type;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", type=" + type +
                ", stations=" + stations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        if (type != train.type) return false;
        return stations != null ? stations.equals(train.stations) : train.stations == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (stations != null ? stations.hashCode() : 0);
        return result;
    }
}
