package com.robot.apocalypse.survivorsapp.service.survivors;

import com.robot.apocalypse.survivorsapp.commons.GeneralResponse;
import com.robot.apocalypse.survivorsapp.models.Survivor;
import com.robot.apocalypse.survivorsapp.models.SurvivorReport;
import com.robot.apocalypse.survivorsapp.persistence.SurvivorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.robot.apocalypse.survivorsapp.commons.SystemConstants.RESOURCE_NOT_FOUND;
@Service
public class SurvivorsServiceImpl implements SurvivorsService{

    private final SurvivorRepository survivorRepository;

    public SurvivorsServiceImpl(SurvivorRepository survivorRepository) {
        this.survivorRepository = survivorRepository;
    }

    @Override
    public ResponseEntity<Page<Survivor>> getAll(Pageable pageable) {
        return ResponseEntity.ok(survivorRepository.findAll(pageable));
    }

    @Override
    public ResponseEntity getById(long id) {
        Optional<Survivor> location = survivorRepository.findById(id);
        if(location.isEmpty())
            return  ResponseEntity
                    .badRequest()
                    .body(GeneralResponse.of(RESOURCE_NOT_FOUND.replace("{resource}","Location")));
        return ResponseEntity.ok(location);
    }

    @Override
    public Survivor add(Survivor survivor) {
        String[] resources = new String[] {"Water","Food","Medication","Ammunition"};
        survivor.setResources(resources.toString());
        return survivorRepository.save(survivor);
    }

    @Override
    public ResponseEntity delete(Long id) {
        survivorRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }
    @Override
    public Survivor update(Survivor survivor, long id) {
        return survivorRepository.findById(id)
                .map(s -> {
                    s.setName(survivor.getLastLocation());
                    return survivorRepository.save(s);
                })
                .orElseGet(() -> {
                    survivor.setID(id);
                    return survivorRepository.save(survivor);
                });
    }

    @Override
    public SurvivorReport report() {
        SurvivorReport survivorReport = new SurvivorReport();
        long total = survivorRepository.count();
        long infected = survivorRepository.countByInfectionGreaterThan(2);
        long noninfected = survivorRepository.countByInfectionLessThan(3);
        survivorReport.setTotal(total);
        survivorReport.setInfected(infected / total);
        survivorReport.setNonInfected(noninfected / total);
        return null;
    }

    @Override
    public ResponseEntity reportInfection(long id) {
        Optional<Survivor> s = survivorRepository.findById(id);
        if(s.isEmpty())
            return  ResponseEntity
                    .badRequest()
                    .body(GeneralResponse.of(RESOURCE_NOT_FOUND.replace("{resource}","Survivor")));
        Survivor survivor = s.get();
        survivor.setInfection(survivor.getInfection() + 1);
        survivorRepository.save(survivor);
        return ResponseEntity.ok(survivor);
    }
}
