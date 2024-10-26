package com.nasa.marsrobot.moviment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasa.marsrobot.model.Coordinates;
import com.nasa.marsrobot.model.Direction;
import com.nasa.marsrobot.model.Robot;
import com.nasa.marsrobot.validators.RobotValidator;

@Component
public class RobotMover {

    @Autowired
    private RobotValidator robotValidator; 

    public void moveForward(Robot robot) {
        Coordinates currentCoordinates = robot.getCoordinates();
        Direction direction = robot.getDirection();
        Coordinates newCoordinates = new Coordinates(currentCoordinates.getX() + direction.getXChange(), 
                                                     currentCoordinates.getY() + direction.getYChange());

        // Validar as novas coordenadas
        robotValidator.validateCoordinates(newCoordinates); // Chame o método de validação
        robot.setCoordinates(newCoordinates);
    }

    public void turnLeft(Robot robot) {
        Direction direction = robot.getDirection();
        robot.setDirection(direction.getLeft());
    }

    public void turnRight(Robot robot) {
        Direction direction = robot.getDirection();
        robot.setDirection(direction.getRight());
    }
}