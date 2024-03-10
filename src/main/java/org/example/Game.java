package org.example;
import lombok.Data;

import java.util.Random;

@Data
public class Game {
    private Door[] doors;
    private Door chosenDoor;
    private Door openedDoor;
    private boolean switchDoor;

    public Game() {
        doors = new Door[3];
        chosenDoor = null;
        openedDoor = null;
    }

    public void play() {
        // Создаем три двери, одна из которых с призом
        doors = new Door[3];
        Random random = new Random();
        int prizeDoor = random.nextInt(3);
        for (int i = 0; i < 3; i++) {
            doors[i] = new Door(i == prizeDoor);
        }

        // Игрок выбирает одну из дверей
        Player player = new Player();
        int chosenDoorNumber = random.nextInt(3);
        player.chooseDoor(chosenDoorNumber);
        chosenDoor = doors[chosenDoorNumber];

        // Ведущий открывает одну из оставшихся дверей без приза
        int openedDoorNumber;
        do {
            openedDoorNumber = random.nextInt(3);
        } while (openedDoorNumber == chosenDoorNumber || doors[openedDoorNumber].isHasPrize());
        doors[openedDoorNumber].open();
        openedDoor = doors[openedDoorNumber];

        // Игрок решает менять выбор или оставаться при своем
        if (switchDoor) {
            player.switchDoor();
            chosenDoor = doors[player.getChosenDoor()];
        }

        // Проверяем, выиграл ли игрок
        if (chosenDoor.isHasPrize()) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }
}