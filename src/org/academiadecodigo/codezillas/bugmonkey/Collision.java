package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Brigzilla;
import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer;
import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Player;

public class Collision {

    public boolean checkCollision(org.academiadecodigo.codezillas.bugmonkey.gameobjects.Player player, Computer computer) {
        return  (player.getX() <= (computer.getX() + 50) && player.getX() >= computer.getX()) &&
                ((player.getY() + 50) <= (computer.getY() + 50) && (player.getY() + 50) >= computer.getY());
    }

    public boolean checkCollision(Player player, Brigzilla brigzilla) {
        return (player.getX() + 50) >= brigzilla.getX() && player.getX() <= (brigzilla.getX() + 50)
                && (player.getY() + 50) >= brigzilla.getY() && player.getY() <= (brigzilla.getY() + 50);
    }
}


