package by.alex.allwayticket.dtos;

import by.alex.allwayticket.entities.Train;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;


public class TrainRouteDTO {


    private String trainType;
    private int id;
    private String trainBeginFromStation;
    private String trainEndToStation;
    private String stationFromSearch;

    private LocalTime timeDeparture;
    private String stationToSearch;

    private LocalTime timeArrival;
    private LocalDateTime onTheWay;
    private Map<Integer, DayOfWeek> scheduler;

    private TrainRouteDTO(String trainType, int id, String trainBeginFromStation, String trainEndToStation,
                          String stationFrom, LocalTime timeDeparture, String stationTo, LocalTime timeArrival, LocalDateTime onTheWay, Map<Integer, DayOfWeek> scheduler) {
        this.trainType = trainType;
        this.id = id;
        this.trainBeginFromStation = trainBeginFromStation;
        this.trainEndToStation = trainEndToStation;
        this.stationFromSearch = stationFrom;
        this.timeDeparture = timeDeparture;
        this.stationToSearch = stationTo;
        this.timeArrival = timeArrival;
        this.onTheWay = onTheWay;
        this.scheduler = scheduler;
    }


    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainBeginFromStation() {
        return trainBeginFromStation;
    }

    public void setTrainBeginFromStation(String trainBeginFromStation) {
        this.trainBeginFromStation = trainBeginFromStation;
    }

    public String getTrainEndToStation() {
        return trainEndToStation;
    }

    public void setTrainEndToStation(String trainEndToStation) {
        this.trainEndToStation = trainEndToStation;
    }

    public String getStationFromSearch() {
        return stationFromSearch;
    }

    public void setStationFromSearch(String stationFromSearch) {
        this.stationFromSearch = stationFromSearch;
    }

    public LocalTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getStationToSearch() {
        return stationToSearch;
    }

    public void setStationToSearch(String stationToSearch) {
        this.stationToSearch = stationToSearch;
    }

    public LocalTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public LocalDateTime getOnTheWay() {
        return onTheWay;
    }

    public void setOnTheWay(LocalDateTime onTheWay) {
        this.onTheWay = onTheWay;
    }

    public Map<Integer, DayOfWeek> getScheduler() {
        return scheduler;
    }

    public void setScheduler(Map<Integer, DayOfWeek> scheduler) {
        this.scheduler = scheduler;
    }

    public static TrainRouteDTO build(Train train, String from, String to) {
        return new TrainRouteDTO(
                train.getType().name(),
                train.getId(),
                UtilDTO.getFirstStationFrom(train).getName(),
                UtilDTO.getLastStationTo(train).getName(),
                from,
                UtilDTO.getStationFrom(train, from).getTimeDeparture(),
                to,
                UtilDTO.getStationFrom(train, to).getTimeArrival(),
                UtilDTO.getTimeOnTheWay(train, from, to),
                UtilDTO.getStationFrom(train, from).getDayOfWeek()
        );
    }

    @Override
    public String toString() {
        return "TrainRouteDTO{" +
                "trainType='" + trainType + '\'' +
                ", id=" + id +
                ", trainBeginFromStation='" + trainBeginFromStation + '\'' +
                ", trainEndToStation='" + trainEndToStation + '\'' +
                ", stationFromSearch='" + stationFromSearch + '\'' +
                ", timeDeparture=" + timeDeparture +
                ", stationToSearch='" + stationToSearch + '\'' +
                ", timeArrival=" + timeArrival +
                ", onTheWay=" + onTheWay +
                ", scheduler=" + scheduler +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainRouteDTO)) return false;

        TrainRouteDTO that = (TrainRouteDTO) o;

        if (id != that.id) return false;
        if (!trainType.equals(that.trainType)) return false;
        if (!trainBeginFromStation.equals(that.trainBeginFromStation)) return false;
        if (!trainEndToStation.equals(that.trainEndToStation)) return false;
        if (!stationFromSearch.equals(that.stationFromSearch)) return false;
        if (timeDeparture != null ? !timeDeparture.equals(that.timeDeparture) : that.timeDeparture != null)
            return false;
        if (stationToSearch != null ? !stationToSearch.equals(that.stationToSearch) : that.stationToSearch != null)
            return false;
        if (timeArrival != null ? !timeArrival.equals(that.timeArrival) : that.timeArrival != null) return false;
        if (onTheWay != null ? !onTheWay.equals(that.onTheWay) : that.onTheWay != null) return false;
        return scheduler.equals(that.scheduler);
    }

    @Override
    public int hashCode() {
        int result = trainType.hashCode();
        result = 31 * result + id;
        result = 31 * result + trainBeginFromStation.hashCode();
        result = 31 * result + trainEndToStation.hashCode();
        result = 31 * result + stationFromSearch.hashCode();
        result = 31 * result + (timeDeparture != null ? timeDeparture.hashCode() : 0);
        result = 31 * result + (stationToSearch != null ? stationToSearch.hashCode() : 0);
        result = 31 * result + (timeArrival != null ? timeArrival.hashCode() : 0);
        result = 31 * result + (onTheWay != null ? onTheWay.hashCode() : 0);
        result = 31 * result + scheduler.hashCode();
        return result;
    }
}
