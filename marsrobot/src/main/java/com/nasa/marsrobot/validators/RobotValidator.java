package com.nasa.marsrobot.validators;

import com.nasa.marsrobot.model.Coordinates;
import org.springframework.stereotype.Component;

@Component
public class RobotValidator {

    private static final int GRID_LIMIT = 5;

    // Valida se a nova posição está fora dos limites
    public void validateCoordinates(Coordinates coordinates) {
        if (isOutOfBounds(coordinates)) {
            throw new IllegalArgumentException("Movimento fora dos limites permitidos.");
        }
    }

    // Verifica se as coordenadas estão fora dos limites do terreno
    private boolean isOutOfBounds(Coordinates coordinates) {
        return coordinates.getX() < -GRID_LIMIT || coordinates.getX() > GRID_LIMIT ||
               coordinates.getY() < -GRID_LIMIT || coordinates.getY() > GRID_LIMIT;
    }

    // Valida comandos recebidos
    public void validateCommand(String command) {
        if (!command.matches("[LMR]*")) {
            throw new IllegalArgumentException("Comando inválido: " + command);
        }
    }
}
