package com.robot.apocalypse.survivorsapp.api.survivors;

import com.robot.apocalypse.survivorsapp.models.Survivor;
import com.robot.apocalypse.survivorsapp.models.SurvivorReport;
import com.robot.apocalypse.survivorsapp.service.survivors.SurvivorsService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.robot.apocalypse.survivorsapp.commons.SwaggerConstants.SURVIVORS;

@RestController
@Api(tags = SURVIVORS)
@RequestMapping("/survivors")
public class SurvivorsController {
    private final SurvivorsService survivorsService;

    public SurvivorsController(SurvivorsService survivorsService) {
        this.survivorsService = survivorsService;
    }

    @GetMapping
    private ResponseEntity<Page<Survivor>> getAll(Pageable pageable){
        return survivorsService.getAll(pageable);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Survivor> getById(@PathVariable long id){
        return survivorsService.getById(id);
    }

    @PostMapping
    Survivor newSurvivor(@RequestBody Survivor survivor) {
        return survivorsService.add(survivor);
    }

    @PostMapping("report-infection/{id}")
    ResponseEntity newSurvivor(@PathVariable long id) {
        return survivorsService.reportInfection(id);
    }
    @PutMapping("/{id}")
    Survivor updateSurvivor(@RequestBody Survivor survivor, @PathVariable long id) {
        return survivorsService.update(survivor, id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity deleteEmployee(@PathVariable long id) {
        return survivorsService.delete(id);
    }
    @GetMapping("/report")
    SurvivorReport report() {
        return survivorsService.report();
    }
}
