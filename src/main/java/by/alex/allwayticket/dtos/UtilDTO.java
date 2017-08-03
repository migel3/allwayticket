package by.alex.allwayticket.dtos;

import by.alex.allwayticket.entities.Station;
import by.alex.allwayticket.entities.Train;

import java.time.*;
import java.util.Date;
import java.util.List;


public class UtilDTO {

    private final static int DAYS_IN_WEEK = 7;
    private final static int SECONDS_IN_DAY = 60 * 60 * 24;
    private final static int A_YEAR = 1970;
    private final static int A_MONTH = 1;
    private final static int A_DAY = 1;


    static Station getStationFrom(Train train, String from) {
        List<Station> stations = train.getStations();
        for (Station station : stations) {
            if (from.equals(station.getName()))
                return station;
        }
        return null;
    }

    static Station getFirstStationFrom(Train train) {
        List<Station> stations = train.getStations();
        for (Station station : stations) {
            if (station.getPosition() == 1)
                return station;
        }
        return null;
    }

    static Station getLastStationTo(Train train) {
        List<Station> stations = train.getStations();
        for (Station station : stations) {
            if (station.getPosition() == stations.size())
                return station;
        }
        return null;
    }




    static LocalDateTime getTimeOnTheWay(Train train, String from, String to) {
        Station stationFrom = getStationFrom(train, from);
        Station stationTo = getStationFrom(train, to);



        LocalTime timeDeparture_ = stationFrom != null ? stationFrom.getTimeDeparture() : null;
        LocalTime timeArrival_ = stationTo != null ? stationTo.getTimeArrival() : null;
        if (timeArrival_ == null || timeDeparture_ == null) return null;

        int timeDeparture = timeDeparture_.toSecondOfDay();
        int timeArrival = timeArrival_.toSecondOfDay();


        DayOfWeek dayOfWeekFrom = stationFrom.getDayOfWeek().get(1);
        DayOfWeek dayOfWeekTo = stationTo.getDayOfWeek().get(1);


        int fromVal = dayOfWeekFrom.getValue();
        int toVal = dayOfWeekTo.getValue();

        if (fromVal > toVal) {
            toVal += DAYS_IN_WEEK;
        }
        int dayDiff = toVal - fromVal;

        int secondsBetween = timeArrival - timeDeparture + dayDiff * SECONDS_IN_DAY;;
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(secondsBetween),ZoneOffset.UTC);


    }


    static  LocalTime getTimeStop(Station station){
        LocalTime timeArrival_ = station.getTimeArrival();
        LocalTime timeDeparture_ = station.getTimeDeparture();
        if (timeArrival_ == null || timeDeparture_ == null) return null;
        int timeDeparture = timeDeparture_.toSecondOfDay();
        int timeArrival = timeArrival_.toSecondOfDay();

        if (timeDeparture < timeArrival) {
            return LocalTime.ofSecondOfDay(timeDeparture - timeArrival + SECONDS_IN_DAY);
        } else
            return LocalTime.ofSecondOfDay(timeDeparture - timeArrival);

    }

    static LocalTime getTimeStop(Train train, String station_) {
        Station station = getStationFrom(train, station_);
       return getTimeStop(station);

    }

    public static Date getDateFromLocalTime(LocalTime lt) {
        if (lt == null) return null;


        Instant instant = lt.atDate(LocalDate.of(A_YEAR, A_MONTH, A_DAY)).
                atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


}
