package by.alex.allwayticket.daos;

import by.alex.allwayticket.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    @Query(" select st from Station st join st.train t where t.id= :id")
    List<Station> findByTrainId(@Param("id") Integer trainId);

    @Query("select distinct st.name from Station st order by st.name asc")
    List<String> findStationsName();

}
