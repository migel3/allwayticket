package by.alex.allwayticket.services.impl;

import by.alex.allwayticket.daos.TrainRepository;
import by.alex.allwayticket.entities.Train;
import by.alex.allwayticket.services.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainServiceImpl.class);

    @Autowired
    private TrainRepository trainRepository;


    @Override
    @Transactional(readOnly = true)
    public Train get(int id)  {
        LOGGER.debug("Finding a train entry with id: {}", id);
        return trainRepository.findOne(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        LOGGER.debug("Deleting train entry with id: {}", id);
        trainRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public List<Train> getAll() {
        LOGGER.debug("Finding all trains entries");
        return trainRepository.findAll();
    }

    @Override
    @Transactional
    public Train save(Train train) {
        LOGGER.debug("Adding a new train entry with information: {}", train);
        return trainRepository.save(train);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Train> getTrainByTwoStationsAndDay(String from, String to, DayOfWeek dayOfWeek)  {
        LOGGER.debug("Finding a trains-route-dto entries with station from: {} ,station to: {} , dayOfWeek: {} ", from, to, dayOfWeek);
        return trainRepository.findByTwoStationsAndDay(from, to, dayOfWeek);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Train> getTrainByTwoStations(String from, String to)  {
        LOGGER.debug("Finding a trains-route-dto entries with station from: {} ,station to: {} ", from, to);
        return trainRepository.findByTwoStations(from, to);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Train> getTrainsByStation(String station)  {
        LOGGER.debug("Finding a trains-station-dto entries with station: {} ", station);
        return trainRepository.findByStation(station);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Train> getTrainsByStationAndDay(String station, DayOfWeek dayOfWeek)  {
        LOGGER.debug("Finding a trains-station-dto entries with station: {} ,dayOfWeek: {} ", station, dayOfWeek);
        return trainRepository.findByStationAndDay(station, dayOfWeek);

    }


}
