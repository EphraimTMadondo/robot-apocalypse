package com.robot.apocalypse.survivorsapp.api.robots;

import com.robot.apocalypse.survivorsapp.models.DateRange;
import com.robot.apocalypse.survivorsapp.models.Robot;
import com.robot.apocalypse.survivorsapp.models.RobotReport;
import com.robot.apocalypse.survivorsapp.models.SurvivorReport;
import com.robot.apocalypse.survivorsapp.service.robots.RobotService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.robot.apocalypse.survivorsapp.commons.SwaggerConstants.ROBOTS;

@RestController
@Api(tags = ROBOTS)
@RequestMapping("/robots")
public class RobotsController {

    private final RobotService robotService;

    public RobotsController(RobotService robotService) {
        this.robotService = robotService;
    }
    @GetMapping("/all")
    List<Robot> findAll() {
        return robotService.findAll();
    }
    @GetMapping("/land")
    List<Robot> findLand() {
        return robotService.findLand();
    }

    @GetMapping("/flying")
    List<Robot> findFlying() {
        return robotService.findFlying();
    }
    @PostMapping("/date-range")
    List<Robot> findDateRange(@RequestBody DateRange dateRange) {
        return robotService.findDateRange(dateRange);
    }

    @PostMapping("/made-before")
    List<Robot> findDateBefore(@RequestBody String date) {
        return robotService.findDateBefore(date);
    }
    @PostMapping("/made-after")
    List<Robot> findDateAfter(@RequestBody String date) {
        return robotService.findDateAfter(date);
    }
    @GetMapping("/report")
    RobotReport report() {
        return robotService.report();
    }
}
