package com.nasa.marsrobot.service;

import com.nasa.marsrobot.model.Robot;
import com.nasa.marsrobot.moviment.RobotMover;
import com.nasa.marsrobot.validators.RobotValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    @Autowired
    private RobotValidator robotValidator; 

    @Autowired
    private RobotMover robotMover;
    
    public Robot moveRobot(String commands) {
        Robot robot = new Robot();
        robotValidator.validateCommand(commands); 

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'M':
                    robotMover.moveForward(robot);
                    break;
                case 'L':
                    robotMover.turnLeft(robot);
                    break;
                case 'R':
                    robotMover.turnRight(robot);
                    break;
            }
        }
        return robot; 
    }
}
