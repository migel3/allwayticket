package by.alex.allwayticket.daos;

import by.alex.allwayticket.entities.Train;
import by.alex.allwayticket.enums.TypeTrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {


    List<Train> findByType(TypeTrain type);




    @Query(" select t from Train  t join t.stations st1 join t.stations st2 join st1.dayOfWeek day where st1.name = :from" +
            " and st2.name = :to and st1.position < st2.position and st1.timeDeparture between :timeFrom and :timeTo " +
            "and day = :dayOfWeek and t.type = :trainType order by t.id asc ")
    List<Train> findByFullQuery(@Param("from") String from, @Param("to") String to, @Param("dayOfWeek") DayOfWeek dayOfWeek,
                                @Param("timeFrom") LocalTime timeFrom, @Param("timeTo") LocalTime timeTo, @Param("trainType") TypeTrain type);


    @Query(" select t from Train  t join t.stations st1 join t.stations st2 join st1.dayOfWeek day where st1.name = :from" +
            " and st2.name = :to and st1.position < st2.position and day = :dayOfWeek order by t.id asc")
    List<Train> findByTwoStationsAndDay(@Param("from") String from, @Param("to") String to, @Param("dayOfWeek") DayOfWeek dayOfWeek);


    @Query(" select distinct t from Train  t join t.stations st1 join t.stations st2  where st1.name = :from" +
            " and st2.name = :to and st1.position < st2.position order by t.id asc")
    List<Train> findByTwoStations(@Param("from") String from, @Param("to") String to);


    @Query(" select distinct t from Train  t join t.stations st1   where st1.name = :from order by t.id asc")
    List<Train> findByStation(@Param("from") String station);


    @Query(" select distinct t from Train  t join t.stations st1 join st1.dayOfWeek day  where st1.name = :from and day = :dayOfWeek order by t.id asc")
    List<Train> findByStationAndDay(@Param("from") String station, @Param("dayOfWeek") DayOfWeek dayOfWeek);
}
