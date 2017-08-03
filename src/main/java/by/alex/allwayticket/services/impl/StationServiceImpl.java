package by.alex.allwayticket.services.impl;

import by.alex.allwayticket.daos.StationRepository;
import by.alex.allwayticket.daos.TrainRepository;
import by.alex.allwayticket.entities.Station;
import by.alex.allwayticket.services.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StationServiceImpl.class);

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TrainRepository trainRepository;


    @Override
    public List<Station> getStationByTrainId(Integer trainId)  {
        LOGGER.debug("Finding a stations entries with trainId: {} ", trainId);
        List<Station> stations = stationRepository.findByTrainId(trainId);

        return stations;
    }

    @Override
    public List<String> getStationsName() {
        LOGGER.debug("Finding a station-name from station entries ");
        return stationRepository.findStationsName();
    }
}
