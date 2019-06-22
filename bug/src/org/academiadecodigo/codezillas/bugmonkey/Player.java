package org.academiadecodigo.codezillas.bugmonkey;

import jdk.swing.interop.SwingInterOpUtils;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler, Moveable { //extends abstract implement keyboard handler

    int x;
    int y;
    private Picture picture;
    private boolean caught;
    private int speed;
    private boolean moving;

    public Player() {
        speed = 5;
        x = 20;
        y = 20;
        moving = false;
        picture = new Picture(x, y, "brigzilla.png");
    }

    public void moveUp() {

        moving = true;
        //Sala 1
        y = y - speed;

        if (y > 20 && y < 370 && x > 20 && x < 470) {
            if (y <= 20) {
                y = 20;
            }
        }
        //Porta 1
        if (y > 20 && y < 120 && x > 470 && x < 530) {
            if (y <= 20) {
                y = 20;
            }
        }
        //Sala 2
        if (y > 430 && y < 780 && x > 20 && x < 470) {
            if (y <= 20) {
                y = 20;
            }
        }
        //Porta 2
        if (y > 680 && y < 780 && x > 470 && x < 530) {
            if (y <= 680) {
                y = 680;
            }
        }
        //Sala 3
        if (y > 20 && y < 370 && x > 1030 && x < 1480) {
            if (y <= 20) {
                y = 20;
            }
        }
        //Porta 3
        if (y > 20 && y < 120 && x > 970 && x < 1030) {
            if (y <= 20) {
                y = 20;
            }
        }
        //Sala 4
        if (y > 430 && y < 780 && x > 1030 && x < 1480) {
            if (y <= 430) {
                y = 430;
            }
        }
        //Porta 4
        if (y > 680 && y < 780 && x > 970 && x < 1030) {
            if (y <= 680) {
                y = 680;
            }
        }
        System.out.println(x);
        System.out.println(y);

    }

    public void moveDown() {
        moving = true;
        //Sala 1
        y = y + speed;

        if (y > 20 && y < 370 && x > 20 && x < 470) {
            if (y > 360) {
                y = 360;
            }
        }
        //Porta 1
        if (y > 20 && y < 120 && x > 470 && x < 530) {
            if (y > 120) {
                y = 120;
            }
        }
        //Sala 2
        if (y > 430 && y < 780 && x > 20 && x < 470) {
            if (y > 780) {
                y = 780;
            }
        }
        //Porta 2
        if (y > 680 && y < 780 && x > 470 && x < 530) {
            if (y > 780) {
                y = 780;
            }
        }
        //Sala 3
        if (y > 20 && y < 370 && x > 1030 && x < 1480) {
            if (y > 120) {
                y = 120;
            }
        }
        //Porta 3
        if (y > 20 && y < 120 && x > 970 && x < 1030) {
            if (y > 120) {
                y = 120;
            }
        }
        //Sala 4
        if (y > 430 && y < 780 && x > 1030 && x < 1480) {
            if (y > 780) {
                y = 780;
            }
        }
        //Porta 4
        if (y > 680 && y < 780 && x > 970 && x < 1030) {
            if (y > 780) {
                y = 780;
            }
        }
        System.out.println(x);
        System.out.println(y);

    }

    public void moveRight() {

        moving = true;
        //Sala 1
        x = x + speed;

        if (y > 20 && y < 370 && x > 20 && x < 470) {
            if (x > 460) {
                x = 460;
            }
        }
        //Porta 1
        if (y > 20 && y < 120 && x > 470 && x < 530) {
        }
        //Sala 2
        if (y > 430 && y < 780 && x > 20 && x < 470) {
            if (x > 470) {
                x = 470;
            }
        }
        //Porta 2
        if (y > 680 && y < 780 && x > 470 && x < 530) {
        }
        //Sala 3
        if (y > 20 && y < 370 && x > 1030 && x < 1480) {
            if (x > 1480) {
                x = 1480;
            }
        }
        //Porta 3
        if (y > 20 && y < 120 && x > 970 && x < 1030) {
        }
        //Sala 4
        if (y > 430 && y < 780 && x > 1030 && x < 1480) {
            if (x < 1480) {
                x = 1480;
            }
        }
        //Porta 4
        if (y > 680 && y < 780 && x > 970 && x < 1030) {
        }
        System.out.println(x);
        System.out.println(y);
    }

    public void moveLeft() {
        moving = true;
        //Sala 1
        x =  x - speed;

        if (y > 20 && y < 370 && x > 20 && x < 470) {
            if (x < 20) {
                x = 20;
            }
        }
        //Porta 1
        if (y > 20 && y < 120 && x > 470 && x < 530) {
        }
        //Sala 2
        if (y > 430 && y < 780 && x > 20 && x < 470) {
            if (x < 20) {
                x = 20;
            }
        }
        //Porta 2
        if (y > 680 && y < 780 && x > 470 && x < 530) {
        }
        //Sala 3
        if (y > 20 && y < 370 && x > 1030 && x < 1480) {
            if (x < 1030) {
                x = 1030;
            }
        }
        //Porta 3
        if (y > 20 && y < 120 && x > 970 && x < 1030) {
        }
        //Sala 4
        if (y > 430 && y < 780 && x > 1030 && x < 1480) {
            if (x < 1030) {
                x = 1030;
            }
        }
        //Porta 4
        if (y > 680 && y < 780 && x > 970 && x < 1030) {
        }
        System.out.println(x);
        System.out.println(y);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if (x > 20) {
            if (key == KeyboardEvent.KEY_LEFT) {
                moveLeft();
                picture.translate(-speed, 0);
            }
        }

        if (x < 440) {
            if (key == KeyboardEvent.KEY_RIGHT) {
                moveRight();
                picture.translate(speed, 0);
            }
        }

        if (y > 20) {
            if (key == KeyboardEvent.KEY_UP) {
                moveUp();
                picture.translate(0, -speed);
            }
        }

        if (y < 320) {
            if (key == KeyboardEvent.KEY_DOWN) {
                moveDown();
                picture.translate(0, speed);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public Picture getPicture() {
        return picture;
    }


}
