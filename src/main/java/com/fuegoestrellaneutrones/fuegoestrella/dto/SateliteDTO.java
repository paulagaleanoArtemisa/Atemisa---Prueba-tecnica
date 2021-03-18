package com.fuegoestrellaneutrones.fuegoestrella.dto;

public class SateliteDTO {

    private String name;
    private double distance;
    private String[] message;
    private double posx;
    private double posy;

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public String[] getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public void setPosx(double posx) {
        this.posx = posx;
    }

    public double getPosx() {
        return posx;
    }

    public double getPosy() {
        return posy;
    }

    public void setPosy(double posy) {
        this.posy = posy;
    }
}
