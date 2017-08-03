package by.alex.allwayticket.dtos;

import by.alex.allwayticket.entities.Train;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;


public class TrainStationDTO {
    private String trainType;
    private int id;
    private String trainBeginFromStation;
    private String trainEndToStation;
    private String stationSearch;
    private LocalTime timeDeparture;
    private LocalTime timeStop;
    private LocalTime timeArrival;
    private Map<Integer, DayOfWeek> scheduler;


    private TrainStationDTO(String trainType, int id, String trainBeginFromStation, String trainEndToStation, String stationSearch, LocalTime timeArrival, LocalTime timeStop, LocalTime timeDeparture, Map<Integer, DayOfWeek> scheduler) {
        this.trainType = trainType;
        this.id = id;
        this.trainBeginFromStation = trainBeginFromStation;
        this.trainEndToStation = trainEndToStation;
        this.stationSearch = stationSearch;
        this.timeArrival = timeArrival;
        this.timeStop = timeStop;
        this.timeDeparture = timeDeparture;
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

    public String getStationSearch() {
        return stationSearch;
    }

    public void setStationSearch(String stationSearch) {
        this.stationSearch = stationSearch;
    }

    public LocalTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public LocalTime getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(LocalTime timeStop) {
        this.timeStop = timeStop;
    }

    public LocalTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public Map<Integer, DayOfWeek> getScheduler() {
        return scheduler;
    }

    public void setScheduler(Map<Integer, DayOfWeek> scheduler) {
        this.scheduler = scheduler;
    }

    public static TrainStationDTO build(Train train, String station) {
        return new TrainStationDTO(
                train.getType().name(),
                train.getId(),
                UtilDTO.getFirstStationFrom(train).getName(),
                UtilDTO.getLastStationTo(train).getName(),
                UtilDTO.getStationFrom(train, station).getName(),
                UtilDTO.getStationFrom(train, station).getTimeArrival(),
                UtilDTO.getTimeStop(train, station),
                UtilDTO.getStationFrom(train, station).getTimeDeparture(),
                UtilDTO.getStationFrom(train, station).getDayOfWeek()
        );

    }

    @Override
    public String toString() {
        return "TrainStationDTO{" +
                "trainType='" + trainType + '\'' +
                ", id=" + id +
                ", trainBeginFromStation='" + trainBeginFromStation + '\'' +
                ", trainEndToStation='" + trainEndToStation + '\'' +
                ", stationSearch='" + stationSearch + '\'' +
                ", timeDeparture=" + timeDeparture +
                ", timeStop=" + timeStop +
                ", timeArrival=" + timeArrival +
                ", scheduler=" + scheduler +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainStationDTO)) return false;

        TrainStationDTO that = (TrainStationDTO) o;

        if (id != that.id) return false;
        if (!trainType.equals(that.trainType)) return false;
        if (!trainBeginFromStation.equals(that.trainBeginFromStation)) return false;
        if (!trainEndToStation.equals(that.trainEndToStation)) return false;
        if (!stationSearch.equals(that.stationSearch)) return false;
        if (timeDeparture != null ? !timeDeparture.equals(that.timeDeparture) : that.timeDeparture != null)
            return false;
        if (timeStop != null ? !timeStop.equals(that.timeStop) : that.timeStop != null) return false;
        if (timeArrival != null ? !timeArrival.equals(that.timeArrival) : that.timeArrival != null) return false;
        return scheduler.equals(that.scheduler);
    }

    @Override
    public int hashCode() {
        int result = trainType.hashCode();
        result = 31 * result + id;
        result = 31 * result + trainBeginFromStation.hashCode();
        result = 31 * result + trainEndToStation.hashCode();
        result = 31 * result + stationSearch.hashCode();
        result = 31 * result + (timeDeparture != null ? timeDeparture.hashCode() : 0);
        result = 31 * result + (timeStop != null ? timeStop.hashCode() : 0);
        result = 31 * result + (timeArrival != null ? timeArrival.hashCode() : 0);
        result = 31 * result + scheduler.hashCode();
        return result;
    }
}

