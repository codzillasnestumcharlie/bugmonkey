package org.academiadecodigo.codezillas.bugmonkey.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Computer {
    private int x;
    private int y;
    private boolean bugged;
    private Picture picture;
    private Picture buggedPicture;
    private static int bugsFixed;

    public Computer(int x, int y) {
        this.x = x;
        this.y = y;
        picture = new Picture(x, y, "/resources/computer.png");
        buggedPicture = new Picture(x, y, "/resources/buggedComputer.png");
        bugsFixed = 0;
    }

    public void draw() {
        picture.draw();
    }

    // Counter
    public void counter() {

        //TODO: can be done with an array
        switch (bugsFixed) {
            case 1:
                Picture one = new Picture(1250, 390, "/resources/one.png");
                one.draw();
                break;
            case 2:
                Picture two = new Picture(1250, 390, "/resources/two.png");
                two.draw();
                break;
            case 3:
                Picture three = new Picture(1250, 390, "/resources/three.png");
                three.draw();
                break;
            case 4:
                Picture four = new Picture(1250, 390, "/resources/four.png");
                four.draw();
                break;
            case 5:
                Picture five = new Picture(1250, 390, "/resources/five.png");
                five.draw();
                break;
            case 6:
                Picture six = new Picture(1250, 390, "/resources/six.png");
                six.draw();
                break;
            case 7:
                Picture seven = new Picture(1250, 390, "/resources/seven.png");
                seven.draw();
                break;
            case 8:
                Picture eight = new Picture(1250, 390, "/resources/eight.png");
                eight.draw();
                break;
            case 9:
                Picture nine = new Picture(1250, 390, "/resources/nine.png");
                nine.draw();
                break;
            case 10:
                Picture ten = new Picture(1250, 390, "/resources/ten.png");
                ten.draw();
                break;
            default:
        }
    }

    public void toggleBuggedImg() {
        if (bugged) {
            buggedPicture.draw();
            return;
        }

        buggedPicture.delete();
        //this.picture = new Picture(x, y, "/resources/computer.png");
        bugsFixed++;
        counter();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBugged() {
        return bugged;
    }

    public void setBugged(boolean bugged) {
        this.bugged = bugged;
    }


}