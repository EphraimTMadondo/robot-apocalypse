package com.robot.apocalypse.survivorsapp.persistence;

import com.robot.apocalypse.survivorsapp.models.Survivor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends PagingAndSortingRepository<Survivor,Long>, JpaSpecificationExecutor<Survivor> {
    long countByInfectionGreaterThan(long infection);
    long countByInfectionLessThan(long infection);
}
