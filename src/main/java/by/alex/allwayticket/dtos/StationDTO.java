package by.alex.allwayticket.dtos;

import by.alex.allwayticket.entities.Station;
import by.alex.allwayticket.entities.Train;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static by.alex.allwayticket.dtos.UtilDTO.*;


public class StationDTO {

    private int position;
    private String name;
    private LocalTime timeArrival;
    private LocalTime timeStop;
    private LocalTime timeDeparture;
    private LocalDateTime onTheWay;

    private StationDTO(int position, String name, LocalTime timeArrival, LocalTime timeStop, LocalTime timeDeparture, LocalDateTime onTheWay) {
        this.position = position;
        this.name = name;
        this.timeArrival = timeArrival;
        this.timeStop = timeStop;
        this.timeDeparture = timeDeparture;
        this.onTheWay = onTheWay;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public LocalTime getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(LocalTime timeStop) {
        this.timeStop = timeStop;
    }

    public LocalTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public LocalDateTime getOnTheWay() {
        return onTheWay;
    }

    public void setOnTheWay(LocalDateTime onTheWay) {
        this.onTheWay = onTheWay;
    }

    public static StationDTO build(Station station, Train train) {
        return new StationDTO(
                station.getPosition(),
                station.getName(),
                station.getTimeArrival(),
                UtilDTO.getTimeStop(station),
                station.getTimeDeparture(),
                getTimeOnTheWay(train, getFirstStationFrom(train).getName(), station.getName())

        );

    }

    @Override
    public String toString() {
        return "StationDTO{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", timeArrival=" + timeArrival +
                ", timeStop=" + timeStop +
                ", timeDeparture=" + timeDeparture +
                ", onTheWay=" + onTheWay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationDTO)) return false;

        StationDTO that = (StationDTO) o;

        if (position != that.position) return false;
        if (!name.equals(that.name)) return false;
        if (timeArrival != null ? !timeArrival.equals(that.timeArrival) : that.timeArrival != null) return false;
        if (timeStop != null ? !timeStop.equals(that.timeStop) : that.timeStop != null) return false;
        if (timeDeparture != null ? !timeDeparture.equals(that.timeDeparture) : that.timeDeparture != null)
            return false;
        return onTheWay != null ? onTheWay.equals(that.onTheWay) : that.onTheWay == null;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + name.hashCode();
        result = 31 * result + (timeArrival != null ? timeArrival.hashCode() : 0);
        result = 31 * result + (timeStop != null ? timeStop.hashCode() : 0);
        result = 31 * result + (timeDeparture != null ? timeDeparture.hashCode() : 0);
        result = 31 * result + (onTheWay != null ? onTheWay.hashCode() : 0);
        return result;
    }
}
