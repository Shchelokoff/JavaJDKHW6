package org.example;
import lombok.Data;

@Data
public class Player {
    private int chosenDoor;

    public void chooseDoor(int doorNumber) {
        this.chosenDoor = doorNumber;
    }

    public void switchDoor() {
        // Логика смены выбранной двери
        if (chosenDoor == 1) {
            chosenDoor = 2;
        } else {
            chosenDoor = 1;
        }
    }
}
