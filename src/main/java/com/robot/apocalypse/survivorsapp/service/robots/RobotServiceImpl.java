package com.robot.apocalypse.survivorsapp.service.robots;

import com.robot.apocalypse.survivorsapp.models.DateRange;
import com.robot.apocalypse.survivorsapp.models.Robot;
import com.robot.apocalypse.survivorsapp.models.RobotReport;
import com.robot.apocalypse.survivorsapp.persistence.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RobotServiceImpl implements RobotService {
    @Value("${apocalypse.robotcpurl}")
    private String robotcpurl;

    private final RestTemplate restTemplate;
    private final RobotRepository robotRepository;
    @Autowired
    public RobotServiceImpl(RestTemplate restTemplate, RobotRepository robotRepository) {
        this.restTemplate = restTemplate;
        this.robotRepository = robotRepository;
    }
    public Robot[] find() {
        return restTemplate.getForObject(robotcpurl, Robot[].class);
    }

    public List<Robot> findAll() {
        return (List<Robot>) robotRepository.findAll();
    }

    @Override
    public List<Robot> findFlying() {
        return robotRepository.findByCategory("Flying");
    }

    @Override
    public List<Robot> findLand() {
        return robotRepository.findByCategory("Land");
    }

    @Override
    public List<Robot> findDateRange(DateRange dateRange) {
        return robotRepository.findByManufacturedDateBetween(dateRange.getStartDate(), dateRange.getEndDate());
    }

    @Override
    public List<Robot> findDateBefore(String date) {
        return robotRepository.findByManufacturedDateBefore(date);
    }

    @Override
    public List<Robot> findDateAfter(String date) {
        return robotRepository.findByManufacturedDateAfter(date);
    }

    @Override
    public RobotReport report() {
        RobotReport report = new RobotReport();
        report.setTotalFlyingRobots(robotRepository.countByCategory("Flying"));
        report.setTotalLandRobots(robotRepository.countByCategory("Land"));
        report.setTotal(robotRepository.count());
        return report;
    }
}
