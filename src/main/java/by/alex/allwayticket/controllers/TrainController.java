package by.alex.allwayticket.controllers;


import by.alex.allwayticket.dtos.TrainRouteDTO;
import by.alex.allwayticket.dtos.TrainStationDTO;
import by.alex.allwayticket.entities.Train;
import by.alex.allwayticket.services.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/trains")
public class TrainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainController.class);
    @Autowired
    private TrainService trainService;

    @RequestMapping()
    public String showTrainsPage() {
        LOGGER.debug("Rendering train page.");
        return "trains";
    }

    @RequestMapping(value = "route/{from}/{to}")
    @ResponseBody
    public List<TrainRouteDTO> trainsWithTwoStations(@PathVariable(value = "from") String from,
                                                     @PathVariable(value = "to") String to)  {
        LOGGER.debug("Sending trains-route-dto  from parameters - station from: {} , to: {} ", from, to);
        List<Train> trainByTwoStations = trainService.getTrainByTwoStations(from, to);
        LOGGER.debug("Finding trains  : {} ", trainByTwoStations);
        List<TrainRouteDTO> trainRouteDTOs = createTrainRouteDTOs(trainByTwoStations, from, to);
        LOGGER.debug("Building trains-route-dtos  : {} ", trainRouteDTOs);
        return trainRouteDTOs;
    }

    @RequestMapping(value = "route/{from}/{to}/{date}")
    @ResponseBody
    public List<TrainRouteDTO> trainsWithStationsAndDate(@PathVariable(value = "from") String from,
                                                         @PathVariable(value = "to") String to,
                                                         @PathVariable(value = "date") DayOfWeek dayOfWeek)  {
        LOGGER.debug("Sending trains-route-dto  from parameters - station from: {} , to: {} , dayOfWeek: {} ", from, to, dayOfWeek);
        List<Train> trainByTwoStationsAndDay = trainService.getTrainByTwoStationsAndDay(from, to, dayOfWeek);
        LOGGER.debug("Finding trains  : {} ", trainByTwoStationsAndDay);
        List<TrainRouteDTO> trainRouteDTOs = createTrainRouteDTOs(trainByTwoStationsAndDay, from, to);
        LOGGER.debug("Building trains-route-dtos  : {} ", trainRouteDTOs);
        return trainRouteDTOs;
    }

    @RequestMapping(value = "st/{station}")
    @ResponseBody
    public List<TrainStationDTO> trainsWithOneStation(@PathVariable String station)  {
        LOGGER.debug("Sending trains-station-dto  from parameter - station from: {} ", station);
        List<Train> trainsByStation = trainService.getTrainsByStation(station);
        LOGGER.debug("Finding trains  : {} ", trainsByStation);
        List<TrainStationDTO> trainStationDTOs = createTrainStationDTOs(trainsByStation, station);
        LOGGER.debug("Building trains-dtos-station  : {} ", trainStationDTOs);
        return trainStationDTOs;
    }

    @RequestMapping(value = "st/{station}/{date}")
    @ResponseBody
    public List<TrainStationDTO> trainsWithOneStationAndDate (@PathVariable String station,
                                                             @PathVariable(value = "date") DayOfWeek dayOfWeek) {
        LOGGER.debug("Sending trains-station-dto  from parameters - station from: {} , dayOfWeek: {}", station,dayOfWeek);
        List<Train> trainsByStationAndDay = trainService.getTrainsByStationAndDay(station, dayOfWeek);
        LOGGER.debug("Finding trains  : {} ", trainsByStationAndDay);
        List<TrainStationDTO> trainStationDTOs = createTrainStationDTOs(trainsByStationAndDay, station);
        LOGGER.debug("Building trains-dtos-station  : {} ", trainStationDTOs);
        return trainStationDTOs;
    }

    private List<TrainRouteDTO> createTrainRouteDTOs(List<Train> trains,String from,String to) {

        List<TrainRouteDTO> result = new LinkedList<>();
        for (Train train : trains) {
            result.add(TrainRouteDTO.build(train, from, to));
        }
        return result;
    }

    private List<TrainStationDTO> createTrainStationDTOs(List<Train> trains,String station) {

        List<TrainStationDTO> result = new LinkedList<>();
        for (Train train : trains) {
            result.add(TrainStationDTO.build(train, station));
        }

        return result;
    }
}

