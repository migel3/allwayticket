package by.alex.allwayticket.services;

import by.alex.allwayticket.entities.Station;

import java.util.List;


public interface StationService
{
   List<Station> getStationByTrainId(Integer trainId) ;

   List<String> getStationsName();

}
