package com.robot.apocalypse.survivorsapp.service.survivors;

import com.robot.apocalypse.survivorsapp.commons.GeneralResponse;
import com.robot.apocalypse.survivorsapp.models.Survivor;
import com.robot.apocalypse.survivorsapp.models.SurvivorReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SurvivorsService {
        ResponseEntity<Page<Survivor>> getAll(Pageable pageable);
        ResponseEntity getById(long id);
        Survivor add(Survivor survivor);
        ResponseEntity delete(Long id);
        Survivor update(Survivor survivor, long id);

        ResponseEntity<GeneralResponse> reportInfection(long id);

        SurvivorReport report();
}
