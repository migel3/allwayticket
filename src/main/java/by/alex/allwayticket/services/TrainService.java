package by.alex.allwayticket.services;


import by.alex.allwayticket.entities.Train;

import java.time.DayOfWeek;
import java.util.List;

public interface TrainService {

    Train get(int id);

    void delete(int id);

    List<Train> getAll();

    Train save(Train train);

    List<Train> getTrainByTwoStationsAndDay(String from, String to, DayOfWeek dayOfWeek) ;

    List<Train> getTrainByTwoStations(String from, String to);

    List<Train> getTrainsByStation(String station);

    List<Train> getTrainsByStationAndDay(String station,DayOfWeek dayOfWeek);


}
