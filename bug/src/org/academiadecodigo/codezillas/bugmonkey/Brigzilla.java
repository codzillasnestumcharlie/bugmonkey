package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Brigzilla extends AbstractPixelPosition implements Moveable {
    private int x;
    private int y;
    private Picture picture;
    private int speed;

    public Brigzilla(){
        this.speed = 10;
        this.x = 750;
        this.y = 600;
        picture = new Picture(x, y, "/resources/brigzilla.png");
    }

    @Override
    public void moveDown() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            y = y + speed;
        }
        if (y > 680){
            y = 680;
        }
    }

    @Override
    public void moveUp() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            y = y - speed;
        }
        if(y<20){
            y = 20;
        }
    }

    @Override
    public void moveLeft() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            x = x - speed;
        }
        if (x<530){
            x = 530;
        }
    }

    @Override
    public void moveRight() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            x = x + speed;
        }
        if(x>890){
            x = 890;
        }
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    public int getSpeed() {
        return speed;
    }

    public Picture getPicture() {
        return picture;
    }

    //Adicionar metodo
    public void incrementSpeed(){
        speed = speed + 5;
    }
}
