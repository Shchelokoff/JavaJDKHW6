package org.example;
import lombok.Data;
@Data
public class Door {
    private boolean hasPrize;
    private boolean isOpen;

    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
        this.isOpen = false;
    }

    public void open() {
        this.isOpen = true;
    }
}