package com.nasa.marsrobot.service;

import com.nasa.marsrobot.model.Direction;
import com.nasa.marsrobot.model.Robot;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RobotServiceTest {

    @Autowired
    private RobotService service;

    @Test
    void testMoveRobot_RightRotationMovement() {
        Robot robot = service.moveRobot("MMRMMRMM");
        assertEquals(2, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }

    @Test
    void testMoveRobot_LeftRotationMovement() {
        Robot robot = service.moveRobot("MML");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(2, robot.getCoordinates().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testMoveRobot_RepetitionLeftMovement() {
        Robot robot = service.moveRobot("MML");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(2, robot.getCoordinates().getY());
        assertEquals(Direction.WEST, robot.getDirection());
        
        // Repetindo o movimento
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(2, robot.getCoordinates().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testMoveRobot_InvalidCommand() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.moveRobot("AAA");
        });
        assertEquals("Comando inválido: AAA", exception.getMessage());
    }

    @Test
    void testMoveRobot_InvalidPosition() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.moveRobot("MMMMMMMMMMMMMMMMMMMMMMMMMM"); // Mais de 5 passos
        });
        assertEquals("Movimento fora dos limites permitidos.", exception.getMessage());
    }

    @Test
    void testMoveRobot_NorthMovement() {
        Robot robot = service.moveRobot("MMM");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(3, robot.getCoordinates().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testMoveRobot_SouthMovement() {
        Robot robot = service.moveRobot("MRRMM");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(-1, robot.getCoordinates().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }

    @Test
    void testMoveRobot_EastMovement() {
        Robot robot = service.moveRobot("MMRMM");
        assertEquals(2, robot.getCoordinates().getX());
        assertEquals(2, robot.getCoordinates().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    void testMoveRobot_FullMovement() {
        Robot robot = service.moveRobot("MMMMMRMMMMMRMMMMMRMMMMMR");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testMoveRobot_FullMovementSouth() {
        Robot robot = service.moveRobot("RRMMMMM");
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(-5, robot.getCoordinates().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }

    @Test
    void testMoveRobot_WestMovement() {
        Robot robot = service.moveRobot("MMRMM");
        assertEquals(2, robot.getCoordinates().getX());
        assertEquals(2, robot.getCoordinates().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }
}
