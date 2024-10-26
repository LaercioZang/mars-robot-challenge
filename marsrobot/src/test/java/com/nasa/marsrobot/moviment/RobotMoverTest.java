package com.nasa.marsrobot.moviment;

import com.nasa.marsrobot.model.Direction;
import com.nasa.marsrobot.model.Robot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RobotMoverTest {

    @Autowired
    private RobotMover robotMover;

    @Test
    void testMoveForward() {
        Robot robot = new Robot();
        robotMover.moveForward(robot);
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(1, robot.getCoordinates().getY());
    }

    @Test
    void testTurnLeft() {
        Robot robot = new Robot();
        robotMover.turnLeft(robot);
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testTurnRight() {
        Robot robot = new Robot();
        robotMover.turnRight(robot);
        assertEquals(Direction.EAST, robot.getDirection());
    }
}

