package com.nasa.marsrobot.controller;

import com.nasa.marsrobot.model.Robot;
import com.nasa.marsrobot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

    @Autowired
    private RobotService robotService;

    @PostMapping("/{commands}")
    public ResponseEntity<Robot> moveRobot(@PathVariable String commands) {
        try {
            Robot finalRobot = robotService.moveRobot(commands);
            return ResponseEntity.ok(finalRobot);
        } catch (IllegalArgumentException e) {
            // Retornar um erro 400 (Bad Request) com a mensagem de comando inválido
            throw e;
        }
    }
}
