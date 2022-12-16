package com.robot.apocalypse.survivorsapp.service.robots;

import com.robot.apocalypse.survivorsapp.models.DateRange;
import com.robot.apocalypse.survivorsapp.models.Robot;
import com.robot.apocalypse.survivorsapp.models.RobotReport;

import java.util.List;

public interface RobotService {
    public Robot[] find();

    RobotReport report();

    List<Robot> findAll();

    List<Robot> findFlying();

    List<Robot> findLand();

    List<Robot> findDateRange(DateRange dateRange);

    List<Robot> findDateBefore(String date);

    List<Robot> findDateAfter(String date);
}
