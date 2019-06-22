package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private int lastRoom = 5;

    Rooms[] rooms = new Rooms[4];
    Player player;
    Brigzilla brigzilla;
    Picture canvas;

    public void init(){

        Picture canvas = new Picture(0,0,"mapBugHunter.png");
        canvas.draw();
        Rooms[] rooms = new Rooms[4];

        generatePCs();

        generateBug();
        generateBug();


    }

    public void start(){

    }

    public void chooseComputer(){

    }

    public void getCaught(){

    }


    /**
     * Gets a random room to
     * generate the bug
     */
    private void generateBug(){
        int x = (int) Math.ceil(Math.random() * 3);
            if (x != lastRoom){
                lastRoom = x;
                rooms[x].setComputerBugged(x);
                return;
            } else {
               generateBug();
            }
    }


    /**
     * Populates arrays with computers
     * @see Rooms
     */
    private void generatePCs(){
        rooms[0] = new Rooms();
        rooms[1] = new Rooms();
        rooms[2] = new Rooms();
        rooms[3] = new Rooms();

        for (int x=0; x < 4; x++) {
            rooms[x].returnComputerPic();
        }
    }


}

