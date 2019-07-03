package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Brigzilla;
import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer;
import org.academiadecodigo.codezillas.bugmonkey.gameobjects.Player;
import org.academiadecodigo.codezillas.bugmonkey.utils.Music;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Game implements KeyboardHandler {

    private org.academiadecodigo.codezillas.bugmonkey.gameobjects.Player player;
    private org.academiadecodigo.codezillas.bugmonkey.gameobjects.Brigzilla brigzilla;
    private org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer[] computers;
    private Collision collision;
    private org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer buggedComputer;

    public Game() {
        collision = new Collision();
        computers = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer[32];
        player = new Player();
        brigzilla = new Brigzilla();
    }

    public void init() {
        Music.startMusic();

        Picture canvas = new Picture(0, 0, "resources/mapBugHunter.png");
        canvas.draw();

        showComputers();
        brigzilla.show();
        brigzilla.changeDirection();
        player.show();

        generateBug();

        initKeyboard(this);
    }

    public void start() throws InterruptedException {

        while (!player.isCaught()) {

            int prob10 = (int) (Math.random() * 1000);

            if (prob10 < 215) {
                brigzilla.changeDirection();
            }

            brigzilla.move();
            player.move();

            if (collision.checkCollision(player, brigzilla)) {
                player.die();
            }

            if (!buggedComputer.isBugged()) {
                buggedComputer.toggleBuggedImg();
                generateBug();
            }

            Thread.sleep(50);
        }

        gameOver();
    }

    private void gameOver() {
        Picture gameOver = new Picture(450, 30, "resources/gameover.png");
        gameOver.draw();
    }

    private void generateBug() {
        int randomComputerIndex = (int) Math.floor(Math.random() * computers.length);
        buggedComputer = computers[randomComputerIndex];
        buggedComputer.setBugged(true);
        buggedComputer.toggleBuggedImg();
    }

    private void showComputers() {
        computers[0] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(420, 20);
        computers[1] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(320, 20);
        computers[2] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(220, 20);
        computers[3] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(120, 20);
        computers[4] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 20);
        computers[5] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 120);
        computers[6] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 220);
        computers[7] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(30, 320);

        // Room 2
        computers[8] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 430);
        computers[9] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 530);
        computers[10] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 630);
        computers[11] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(20, 730);
        computers[12] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(120, 730);
        computers[13] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(220, 730);
        computers[14] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(320, 730);
        computers[15] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(420, 730);

        //Room 3
        computers[16] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1030, 20);
        computers[17] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1130, 20);
        computers[18] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1230, 20);
        computers[19] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1330, 20);
        computers[20] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 20);
        computers[21] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 120);
        computers[22] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 220);
        computers[23] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 320);

        //Room 4
        computers[24] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 430);
        computers[25] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 530);
        computers[26] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 630);
        computers[27] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1430, 730);
        computers[28] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1330, 730);
        computers[29] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1230, 730);
        computers[30] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1130, 730);
        computers[31] = new org.academiadecodigo.codezillas.bugmonkey.gameobjects.Computer(1030, 730);

        for (Computer pc : computers) {
            pc.draw();
        }
    }

    private static void initKeyboard(KeyboardHandler handler) {
        Keyboard keyboard = new Keyboard(handler);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();


        switch (key) {
            case KEY_SPACE:
                if (collision.checkCollision(player, buggedComputer)) {
                    buggedComputer.setBugged(false);
                    brigzilla.incrementSpeed();
                }
                break;
            case KEY_LEFT:
                if (player.getX() >= 20) {
                    player.setDirection(Direction.LEFT);
                }
                break;
            case KEY_RIGHT:
                if (player.getX() <= 1480) {
                    player.setDirection(Direction.RIGHT);
                }
                break;
            case KEY_UP:
                if (player.getY() >= 20) {
                    player.setDirection(Direction.UP);
                }
                break;
            case KEY_DOWN:
                if (player.getY() <= 780) {
                    player.setDirection(Direction.DOWN);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}