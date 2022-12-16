package com.robot.apocalypse.survivorsapp.persistence;

import com.robot.apocalypse.survivorsapp.models.Robot;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobotRepository extends PagingAndSortingRepository<Robot,Long>, JpaSpecificationExecutor<Robot> {
    long countByCategory(String cat);
    List<Robot> findByCategory(String cat);
    List<Robot> findByManufacturedDateAfter(String startDate);
    List<Robot> findByManufacturedDateBefore(String endDate);
    List<Robot> findByManufacturedDateBetween(String startDate, String endDate);

}
