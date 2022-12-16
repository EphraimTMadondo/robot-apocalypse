package com.robot.apocalypse.survivorsapp.app;
import com.robot.apocalypse.survivorsapp.models.Robot;
import com.robot.apocalypse.survivorsapp.persistence.RobotRepository;
import com.robot.apocalypse.survivorsapp.service.robots.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private final RobotService robotService;

    LoadDatabase(RobotService robotService) {
        this.robotService = robotService;
    }

    @Bean
    CommandLineRunner initDatabase(RobotRepository repository) {
        Robot[] robots = robotService.find();
        return args -> {
            for (Robot robot : robots) {
                log.info("Preloading " + repository.save(robot));
            }
        };
    }
}