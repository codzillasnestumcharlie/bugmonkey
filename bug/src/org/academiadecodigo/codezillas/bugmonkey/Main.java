package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {

        Picture canvas = new Picture(0, 0, "mapBugHunter.png");
        canvas.draw();

        Player player = new Player();
        player.getPicture().draw();

        initKeyboard(player);


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

            KeyboardEvent moveUpRight = new KeyboardEvent();
            moveUpRight.setKey(KeyboardEvent.KEY_RIGHT);
            moveUpRight.setKey(KeyboardEvent.KEY_UP);
            moveUpRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


            keyboard.addEventListener(moveLeft);
            keyboard.addEventListener(moveRight);
            keyboard.addEventListener(moveUp);
            keyboard.addEventListener(moveDown);
            keyboard.addEventListener(moveUpRight);

        }

    }


