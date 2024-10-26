package com.nasa.marsrobot.model;

import java.io.Serializable;

public class Robot implements Serializable{
    private Coordinates coordinates; 
    private Direction direction;   

    public Robot() {
        this.coordinates = new Coordinates(0, 0); // Inicializa em (0, 0)
        this.direction = Direction.NORTH; // Direção inicial
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
