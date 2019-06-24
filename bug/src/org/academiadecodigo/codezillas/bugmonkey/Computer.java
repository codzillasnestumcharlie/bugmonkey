package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Computer {
    private int x;
    private int y;
    private boolean bugged;
    private Picture picture;
    private Picture buggedPicture;
    private static int bugsFixed;

    public Computer(int x, int y){
        picture = new Picture(x, y, "/resources/computer.png");
        buggedPicture = new Picture(x, y, "/resources/buggedComputer.png");
        this.x = x;
        this.y = y;
        bugsFixed = 0;
    }

    public Picture setDraw(){
        picture.draw();
        return picture;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setx(int x){
        this.x = x;
    }

    public void sety(int y){
        this.y = y;
    }

    public boolean isBugged() {
        return bugged;
    }

    public boolean getBugged(){
        return bugged;
    }

    /**
     * Sets computer bugged
     */
    public void setBugged(){
        buggedPicture.draw();
        bugged = true;
        return;
    }

    public void resolveBug(){
        if (!bugged){
            System.out.println(" This pc is running fine!");
        } else {
            bugged = false;
            buggedPicture.delete();
            this.picture = new Picture(getX(),getY(),"/resources/computer.png");
            bugsFixed= bugsFixed + 1;
            counter();
        }
    }
    // Counter
    public void counter(){

        switch (bugsFixed){
            case 1:
                Picture one = new Picture(1250, 390, "/resources/one.png");
                one.draw();
                break;
            case 2:
                Picture two = new Picture(1250, 390, "/resources/two.png");
                two.draw();
                break;
            case 3:
                Picture three = new Picture(1250,390, "/resources/three.png");
                three.draw();
                break;
            case 4:
                Picture four = new Picture(1250,390, "/resources/four.png");
                four.draw();
                break;
            case 5:
                Picture five = new Picture(1250,390, "/resources/five.png");
                five.draw();
                break;
            case 6:
                Picture six = new Picture(1250,390, "/resources/six.png");
                six.draw();
                break;
            case 7:
                Picture seven = new Picture(1250,390, "/resources/seven.png");
                seven.draw();
                break;
            case 8:
                Picture eight = new Picture(1250,390, "/resources/eight.png");
                eight.draw();
                break;
            case 9:
                Picture nine = new Picture(1250,390, "/resources/nine.png");
                nine.draw();
                break;
            case 10:
                Picture ten = new Picture(1250,390, "/resources/ten.png");
                ten.draw();
                break;
            default:
        }
    }
}
