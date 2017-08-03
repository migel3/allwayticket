package by.alex.allwayticket.daos;

import by.alex.allwayticket.entities.SingleRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SingleRouteRepository extends JpaRepository<SingleRoute, Integer> {

    List<SingleRoute> findByFrom_Name(String name);
}
