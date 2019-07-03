package org.academiadecodigo.codezillas.bugmonkey.gameobjects;

import org.academiadecodigo.codezillas.bugmonkey.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int x;
    private int y;
    private Picture picture;
    private boolean caught;
    private int speed;
    private Direction direction;


    public Player() {
        x = 750;
        y = 200;
        picture = new Picture(x, y, "resources/Player.png");
        speed = 10;
        direction = Direction.DOWN;
    }

    public void show() {
        picture.draw();
    }

    public void die() {
        caught = true;
        picture.delete();
    }

    public void move() {
        switch (direction) {
            case RIGHT:
                picture.load("resources/Player_Right.png");
                for (int i = 0; i < speed; i++) {
                    moveRight();
                }
                break;
            case LEFT:
                picture.load("resources/Player.png");
                for (int i = 0; i < speed; i++) {
                    moveLeft();
                }
                break;
            case DOWN:
                for (int i = 0; i < speed; i++) {
                    moveDown();

                }
                break;
            case UP:
                for (int i = 0; i < speed; i++) {
                    moveUp();
                }
                break;
        }
    }

    public void moveUp() {
        if (y == 680 && x >= 970 - 50 && x < 1030) {
            return;
        }
        if (y == 430 && x >= 1030) {
            return;
        }
        if (y == 680 && x >= 470 - 50 && x < 530) {
            return;
        }
        if (y == 430 && x < 470) {
            return;
        }
        if (y <= 20 && x >= 970 && x < 1480) {
            return;
        }
        if (y <= 20 && x >= 530 && x < 970) {
            return;
        }
        if (y <= 20 && x >= 470 && x < 530) {
            return;
        }
        if (y <= 20 && x < 470) {
            return;
        }

        y--;

        if (picture.getY() == 680 && picture.getX() >= 970 && picture.getX() < 1030) {
            picture.translate(0, 0);
        } else if (picture.getY() == 430 && picture.getX() > 1030) {
            picture.translate(0, 0);
        } else if (picture.getY() == 680 && picture.getX() >= 470 && picture.getX() < 530) {
            picture.translate(0, 0);
        } else if (picture.getY() == 430 && picture.getX() < 470) {
            picture.translate(0, 0);
        } else if (picture.getY() <= 20 && picture.getX() >= 970 && picture.getX() < 1480) {
            picture.translate(0, 0);
        } else if (picture.getY() <= 20 && picture.getX() >= 530 && picture.getX() < 970) {
            picture.translate(0, 0);
        } else if (picture.getY() <= 20 && picture.getX() >= 470 && picture.getX() < 530) {
            picture.translate(0, 0);
        } else if (picture.getY() < 20 && picture.getX() < 470) {
            picture.translate(0, 0);
        } else {
            picture.translate(0, -1);
        }
    }


    public void moveDown() {
        //TODO: use a collision detector
        if (y == 120 - 50 && x >= 970 - 50 && x < 1030) {
            return;
        }
        if (y == 370 - 50 && x >= 1030) {
            return;
        }
        if (y == 120 - 50 && x >= 470 - 50 && x < 530) {
            return;
        }
        if (y == 370 - 50 && x < 470) {
            return;
        }
        if (y >= 780 - 50 && x >= 970 && x < 1480) {
            return;
        }
        if (y >= 780 - 50 && x >= 530 && x < 970) {
            return;
        }
        if (y >= 780 - 50 && x >= 470 && x < 530) {
            return;
        }
        if (y >= 780 - 50 && x < 470) {
            return;
        }

        y++;

        if (picture.getY() == 120 - 50 && picture.getX() >= 970 && picture.getX() < 1030) {
            picture.translate(0, 0);
        } else if (picture.getY() == 370 - 50 && picture.getX() > 1030) {
            picture.translate(0, 0);
        } else if (picture.getY() == 120 - 50 && picture.getX() >= 470 && picture.getX() < 530) {
            picture.translate(0, 0);
        } else if (picture.getY() == 370 - 50 && picture.getX() < 470) {
            picture.translate(0, 0);
        } else if (picture.getY() >= 780 - 50 && picture.getX() >= 970 && picture.getX() < 1480) {
            picture.translate(0, 0);
        } else if (picture.getY() >= 780 - 50 && picture.getX() >= 530 && picture.getX() < 970) {
            picture.translate(0, 0);
        } else if (picture.getY() >= 780 - 50 && picture.getX() >= 470 && picture.getX() < 530) {
            picture.translate(0, 0);
        } else if (picture.getY() >= 780 - 50 && picture.getX() < 470) {
            picture.translate(0, 0);
        } else {
            picture.translate(0, 1);
        }
    }

    public void moveRight() {
        if (x >= 970 - 50 && x < 1030 && y < 680 && y > 120 - 50) {
            return;
        }
        if (x >= 470 - 50 && x < 530 && y < 680 && y > 120 - 50) {
            return;
        }
        if (x > 1480 - 50) {
            return;
        }

        x++;

        if (picture.getX() == 970 - 50 && picture.getY() < 680 && picture.getY() >= 120) {
            picture.translate(0, 0);
        } else if (picture.getX() == 470 - 50 && picture.getY() < 680 && picture.getY() >= 120) {
            picture.translate(0, 0);
        } else if (picture.getX() > 1480) {
            picture.translate(0, 0);
        } else {
            picture.translate(1, 0);
        }
    }


    public void moveLeft() {

        if (x <= 20) {
            return;
        }
        if (x <= 530 && x > 470 && y < 680 && y > 120 - 50) {
            return;
        }
        if (x <= 1030 && x > 970 && y < 680 && y > 120 - 50) {
            return;
        }

        x--;

        if (picture.getX() == 1030 && picture.getY() < 680 && picture.getY() >= 120) {
            picture.translate(0, 0);
        } else if (picture.getX() == 530 && picture.getY() < 680 && picture.getY() >= 120) {
            picture.translate(0, 0);
        } else if (picture.getX() < 20) {
            picture.translate(0, 0);
        } else {
            picture.translate(-1, 0);
        }
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public boolean isCaught() {
        return caught;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
