package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Rooms {

    private final int totalComputer = 32;

    private Computer[] computer = new Computer[32];
    private Rectangle[] wall;


    public Rooms (){
        //Room 1
        computer[0] = new Computer(420,20);
        computer[1] = new Computer(320,20);
        computer[2] = new Computer(220,20);
        computer[3] = new Computer(120,20);
        computer[4] = new Computer(20,20);
        computer[5] = new Computer(20,120);
        computer[6] = new Computer(20,220);
        computer[7] = new Computer(30,320);

        // Room 2
        computer[8] = new Computer(20,420);
        computer[9] = new Computer(20,530);
        computer[10] = new Computer(20,630);
        computer[11] = new Computer(20,730);
        computer[12] = new Computer(120,730);
        computer[13] = new Computer(220,730);
        computer[14] = new Computer(320,730);
        computer[15] = new Computer(420,730);

        //Room 3
        computer[16] = new Computer(1030,20);
        computer[17] = new Computer(1130,20);
        computer[18] = new Computer(1230,20);
        computer[19] = new Computer(1330,20);
        computer[20] = new Computer(1430,20);
        computer[21] = new Computer(1430,120);
        computer[22] = new Computer(1430,220);
        computer[23] = new Computer(1430,320);

        //Room 4
        computer[24] = new Computer(1430,430);
        computer[25] = new Computer(1430,530);
        computer[26] = new Computer(1430,630);
        computer[27] = new Computer(1430,730);
        computer[28] = new Computer(1330,730);
        computer[29] = new Computer(1230,730);
        computer[30] = new Computer(1130,730);
        computer[31] = new Computer(1030,730);

        returnComputerPic();
    }

    private void setComputerXY(){
        for (int x=0; x < totalComputer; x++){
        }
    }

    /**
     * **
     * @param roomNumber
     * @see Computer
     * Gets the room number, and sets
     * computer bugged
     */

    public void setComputerBugged(int roomNumber){
        switch (roomNumber){
            case 0:
                int rand = (int)  Math.ceil(Math.random() * 7);      // (max - min )  + min
                computer[rand].setBugged();
                break;
            case 1:
                int rand1 = (int)  Math.ceil((int)(Math.random() * ((15 - 8) + 1)) + 8);
                computer[rand1].setBugged();
                break;
            case 2:
                int rand2 = (int)  Math.ceil((int)(Math.random() * ((23 - 16) + 1)) + 16);
                computer[rand2].setBugged();
                break;
            case 3:
                int rand3 = (int)  Math.ceil((int)(Math.random() * ((24 - 31) + 1)) + 24);
                computer[rand3].setBugged();
                break;
        }
    }

    /**
     *
     * Method required to inicialize all
     * computer pictures
     * @see Computer
     */
    public void returnComputerPic(){
        for (int x= 0; x < totalComputer; x++){
            computer[x].setDraw();
        }
    }

}
