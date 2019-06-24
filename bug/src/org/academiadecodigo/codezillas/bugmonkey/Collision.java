package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Collision {


    public boolean checkComputerCollision(Player player, Computer computer) {

        if (player.getX() <= (computer.getX() + 50) && player.getX() >= computer.getX()) {

            if ((player.getY() + 50) <= (computer.getY() + 50) && (player.getY() + 50) >= computer.getY()) {
                computer.resolveBug();
                return true;
            }
        } else {
            System.out.println(player.getX());
            System.out.println(player.getY());
            System.out.println("OUT OF ELSEEE");
        }
        return false;
    }

    //metodo de comparação
    public boolean checkBrigzillaCollision(Player player, Brigzilla brigzilla) {

        if ((player.getPicture().getX() + 50) >= brigzilla.getPicture().getX() && player.getPicture().getX() <= (brigzilla.getPicture().getX() + 50)
                && (player.getPicture().getY() + 50) >= brigzilla.getPicture().getY() && player.getPicture().getY() <= (brigzilla.getPicture().getY() + 50)) {

            player.setCaught();
            player.getPicture().delete();

            return true;
        }
        return false;
    }
}


