package com.robot.apocalypse.survivorsapp.commons;

public class GeneralResponse {
    private String message;

public  static GeneralResponse of(String message){
    return new GeneralResponse(message);
}

private GeneralResponse(String message){
    this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
