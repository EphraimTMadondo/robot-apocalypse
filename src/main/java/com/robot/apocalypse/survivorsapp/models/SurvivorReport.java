package com.robot.apocalypse.survivorsapp.models;

import lombok.Data;

@Data
public class SurvivorReport {
    private long total;
    private float infected;
    private float nonInfected;
}
