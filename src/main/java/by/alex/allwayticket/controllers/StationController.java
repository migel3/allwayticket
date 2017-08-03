package by.alex.allwayticket.controllers;

import by.alex.allwayticket.dtos.StationDTO;
import by.alex.allwayticket.entities.Station;
import by.alex.allwayticket.entities.Train;
import by.alex.allwayticket.services.StationService;
import by.alex.allwayticket.services.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping(value = "/stations")
public class StationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StationController.class);
    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/{trainId}")
    @ResponseBody
    public List<StationDTO> stationsFromTrain(@PathVariable(value = "trainId") int trainId)  {
        LOGGER.debug("Sending station-dto json from parameter - train id: {} ", trainId);
        List<Station> stationsByTrainId = stationService.getStationByTrainId(trainId);
        Train train = trainService.get(trainId);
        LOGGER.debug("Finding a train entry : {} ", train);
        List<StationDTO> stationDTOs = createStationDTOs(stationsByTrainId, train);
        LOGGER.debug("Finding station-dto  : {} -  ", stationDTOs);

        return stationDTOs;

    }



    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<String> getStationsName() {
        LOGGER.debug("Sending all stations name json");
        List<String> stationsName = stationService.getStationsName();
        LOGGER.debug("Finding all stations name json: {}",stationsName);
        return stationsName;
    }

    private List<StationDTO> createStationDTOs(List<Station> stations, Train train) {

        LinkedList<StationDTO> result = new LinkedList<>();
        for (Station station : stations) {
            result.add(StationDTO.build(station, train));
        }
        return result;
    }

}