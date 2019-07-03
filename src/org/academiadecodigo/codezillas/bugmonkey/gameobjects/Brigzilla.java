package org.academiadecodigo.codezillas.bugmonkey.gameobjects;

import org.academiadecodigo.codezillas.bugmonkey.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Brigzilla {
    private int x;
    private int y;
    private Picture picture;
    private int speed;
    private Direction currentDirection;

    public Brigzilla(){
        this.speed = 10;
        this.x = 750;
        this.y = 600;
        picture = new Picture(x, y, "resources/brigzilla.png");
    }

    public void show() {
        picture.draw();
    }

    public void moveDown() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            y += speed;
        }
        if (y > 680){
            y = 680;
        }
    }

    public void moveUp() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            y -= speed;
        }
        if(y<20){
            y = 20;
        }
    }

    public void moveLeft() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            x -= speed;
        }
        if (x<530){
            x = 530;
        }
    }

    public void moveRight() {
        // loop to speed faster 1 to 1
        for (int i = 0; i < speed; i++) {
            x += speed;
        }
        if(x>890){
            x = 890;
        }
    }

    public int getY() {
        return picture.getY();
    }

    public int getX() {
        return picture.getX();
    }


    public void incrementSpeed(){
        //TODO: magic number
        speed += 5;
    }

    public void changeDirection() {
        currentDirection = Direction.getRandomDirection();
    }

    public void move() {
        switch (currentDirection) {
            case UP:
                for (int i = 0; i < speed; i++) {
                    moveUp();

                    if (picture.getY() > 30) {
                        picture.translate(0, -1);
                    } else if (picture.getX() > 430 || picture.getX() > 840) {
                        picture.translate(0, 1);
                    }
                }
                break;

            case DOWN:
                for (int i = 0; i < speed; i++) {
                    moveDown();

                    if (picture.getY() < 680) {
                        picture.translate(0, 1);
                    } else if (picture.getX() > 430 || picture.getX() > 840) {
                        picture.translate(0, -1);
                    }
                }
                break;
            case LEFT:
                picture.load("resources/brigzilla.png");
                for (int i = 0; i < speed; i++) {
                    moveLeft();

                    if (picture.getX() > 530) {
                        picture.translate(-1, 0);
                    } else if (picture.getY() > 430 || picture.getY() > 630) {
                        picture.translate(1, 0);
                    }
                }
                break;
            case RIGHT:
                picture.load("resources/brigzilla_Right.png");

                for (int i = 0; i < speed; i++) {
                    moveRight();

                    if (picture.getX() < 890) {
                        picture.translate(1, 0);
                    } else if (picture.getY() > 430 || picture.getY() > 630) {
                        picture.translate(-1, 0);
                    }
                }
                break;
        }
    }
}