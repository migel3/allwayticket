package by.alex.allwayticket.entities;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;


@Entity
public class Station {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @Column(name = "position")
    private int position;


   /* @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "days_of_week", joinColumns = @JoinColumn(name = "scheduler_id"))
    @Column(name = "day_of_week")
    private List<DayOfWeek> dayOfWeek = new LinkedList<>();*/

    @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "days_of_week", joinColumns = @JoinColumn(name = "scheduler_id"))
    @MapKeyColumn(name = "QUEUE_POSITION")
    @Column(name = "day_of_week")
    private Map<Integer, DayOfWeek> dayOfWeek;

    @Column(name = "time_departure")
    private LocalTime timeDeparture;

    @Column(name = "time_arrival")
    private LocalTime timeArrival;


    @ManyToOne
    @JoinTable(name = "train_station", joinColumns = @JoinColumn(name = "station_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id"))
    private Train train;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Map<Integer, DayOfWeek> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Map<Integer, DayOfWeek> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public LocalTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", dayOfWeek=" + dayOfWeek +
                ", timeDeparture=" + timeDeparture +
                ", timeArrival=" + timeArrival +
                                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;

        Station station = (Station) o;

        if (id != station.id) return false;
        if (position != station.position) return false;
        if (!name.equals(station.name)) return false;
        if (!dayOfWeek.equals(station.dayOfWeek)) return false;
        if (!timeDeparture.equals(station.timeDeparture)) return false;
        if (!timeArrival.equals(station.timeArrival)) return false;
        return train.equals(station.train);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + position;
        result = 31 * result + dayOfWeek.hashCode();
        result = 31 * result + timeDeparture.hashCode();
        result = 31 * result + timeArrival.hashCode();
        result = 31 * result + train.hashCode();
        return result;
    }
}

