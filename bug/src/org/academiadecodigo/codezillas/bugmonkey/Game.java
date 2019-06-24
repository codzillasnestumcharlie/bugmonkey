package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import static org.academiadecodigo.codezillas.bugmonkey.Utilities.randomMovement;

public class Game implements KeyboardHandler {

    Player player;
    Brigzilla brigzilla;
    Computer[] computer;
    Collision collision;
    private int move;
    Music music;
    private boolean running = false;
    Computer buggedComputer;
    //private boolean pressStart;

    public Game() {
        this.move = randomMovement();
        collision = new Collision();
        computer = new Computer[32];
        player = new Player();
        brigzilla = new Brigzilla();
        music = new Music();
        //pressStart=false;
        //initMenu();

    }

    public void init() {

        //music
        music.startMusic();

        running = true;

        Picture canvas = new Picture(0, 0, "/resources/mapBugHunter.png");
        canvas.draw();
        brigzilla.getPicture().draw();

        computer[0] = new Computer(420, 20);
        computer[1] = new Computer(320, 20);
        computer[2] = new Computer(220, 20);
        computer[3] = new Computer(120, 20);
        computer[4] = new Computer(20, 20);
        computer[5] = new Computer(20, 120);
        computer[6] = new Computer(20, 220);
        computer[7] = new Computer(30, 320);

        // Room 2
        computer[8] = new Computer(20, 430);
        computer[9] = new Computer(20, 530);
        computer[10] = new Computer(20, 630);
        computer[11] = new Computer(20, 730);
        computer[12] = new Computer(120, 730);
        computer[13] = new Computer(220, 730);
        computer[14] = new Computer(320, 730);
        computer[15] = new Computer(420, 730);

        //Room 3
        computer[16] = new Computer(1030, 20);
        computer[17] = new Computer(1130, 20);
        computer[18] = new Computer(1230, 20);
        computer[19] = new Computer(1330, 20);
        computer[20] = new Computer(1430, 20);
        computer[21] = new Computer(1430, 120);
        computer[22] = new Computer(1430, 220);
        computer[23] = new Computer(1430, 320);

        //Room 4
        computer[24] = new Computer(1430, 430);
        computer[25] = new Computer(1430, 530);
        computer[26] = new Computer(1430, 630);
        computer[27] = new Computer(1430, 730);
        computer[28] = new Computer(1330, 730);
        computer[29] = new Computer(1230, 730);
        computer[30] = new Computer(1130, 730);
        computer[31] = new Computer(1030, 730);
        returnComputerPic();

        player.getPicture().draw();
        initKeyboard(this);

        generateBug();
    }

    public void start() throws InterruptedException {
        //initMenu();
        init();
        moveBrigzilla();
        gameOver();
    }

    //Adicionar metodo
    public void gameOver() {
        if (player.isCaught()) {
            Picture gameOver = new Picture(450, 30, "/resources/gameover.png");
            gameOver.draw();
        }
    }
/*
    public void initMenu(){
        if (!pressStart){
            Rectangle initMenu = new Rectangle(0,0,1500,800);
            initMenu.setColor(Color.BLUE);
            initMenu.fill();
        }
    }
*/
    private void moveBrigzilla() throws InterruptedException {

        while (!player.isCaught()) {
            //probabilidade 0-50
            int prob10 = (int) (Math.random() * 1000);

            //comparing with player
            collision.checkBrigzillaCollision(player, brigzilla);

            // slow motion
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }

            switch (move) {
                case 0:
                    // loop to speed faster 1 to 1
                    for (int i = 0; i < brigzilla.getSpeed(); i++) {
                        brigzilla.moveUp();

                        //controlo de prob de virar
                        if (prob10 < 215) {
                            move = randomMovement();
                        }

                        //Limites do movimento das imagens
                        if (brigzilla.getPicture().getY() > 30) {
                            brigzilla.getPicture().translate(0, -1);
                        } else if (brigzilla.getPicture().getX() > 430 || brigzilla.getPicture().getX() > 840) {
                            brigzilla.getPicture().translate(0, 1);
                        }
                    }
                    break;

                case 1:
                    // loop to speed faster 1 to 1
                    for (int i = 0; i < brigzilla.getSpeed(); i++) {
                        brigzilla.moveDown();

                        //controlo de prob de virar
                        if (prob10 < 215) {
                            move = randomMovement();
                        }

                        //Limites do movimento das imagens
                        if (brigzilla.getPicture().getY() < 680) {
                            brigzilla.getPicture().translate(0, 1);
                        } else if (brigzilla.getPicture().getX() > 430 || brigzilla.getPicture().getX() > 840) {
                            brigzilla.getPicture().translate(0, -1);
                        }
                    }
                    break;

                case 2:
                    //loads the opposite picture
                    brigzilla.getPicture().load("/resources/brigzilla.png");
                    // loop to speed faster 1 to 1
                    for (int i = 0; i < brigzilla.getSpeed(); i++) {
                        brigzilla.moveLeft();

                        //controlo de prob de virar
                        if (prob10 < 215) {
                            move = randomMovement();
                        }

                        //Limites do movimento das imagens
                        if (brigzilla.getPicture().getX() > 530) {
                            brigzilla.getPicture().translate(-1, 0);
                        } else if (brigzilla.getPicture().getY() > 430 || brigzilla.getPicture().getY() > 630) {
                            brigzilla.getPicture().translate(1, 0);
                        }
                    }
                    break;

                case 3:
                    //loads the opposite picture
                    brigzilla.getPicture().load("/resources/brigzilla_Right.png");
                    // loop to speed faster 1 to 1
                    for (int i = 0; i < brigzilla.getSpeed(); i++) {
                        brigzilla.moveRight();

                        //controlo de prob de virar
                        if (prob10 < 215) {
                            move = randomMovement();
                        }

                        //Limites do movimento das imagens
                        if (brigzilla.getPicture().getX() < 890) {
                            brigzilla.getPicture().translate(1, 0);
                        } else if (brigzilla.getPicture().getY() > 430 || brigzilla.getPicture().getY() > 630) {
                            move = randomMovement();
                            brigzilla.getPicture().translate(-1, 0);
                        }
                    }
                    break;
            }
            //player moving
            player.move();
        }
    }

    /**
     * Gets a random room to
     * generate the bug
     */
    private Computer generateBug() {
        int x = (int) Math.floor(Math.random() * 32);
        computer[x].setBugged();
        return buggedComputer = computer[x];
    }

    private boolean checkCollision() {
        return collision.checkComputerCollision(player, buggedComputer);
    }

    public void returnComputerPic() {
        for (int x = 0; x < computer.length; x++) {
            computer[x].setDraw();
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
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
/*      // KEY TO ENTER GAME
        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
*/
        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(space);
        //keyboard.addEventListener(enter);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        if (key == KeyboardEvent.KEY_SPACE) {
            if (checkCollision()) {  //checkCollision
                checkCollision();
                buggedComputer = generateBug();
                //new!!! incrementSpeed of brigzilla!!
                brigzilla.incrementSpeed();
            }
        }
/*
        if (key == KeyboardEvent.KEY_ENTER){
            pressStart = true;
        }
*/
        if (key == KeyboardEvent.KEY_LEFT) {
            player.getPicture().load("/resources/Player.png");
            if (player.getX() >= 20) {
                player.setDirection(Direction.LEFT);
            }
        }

        if (key == KeyboardEvent.KEY_RIGHT) {
            player.getPicture().load("/resources/Player_Right.png");
            if (player.getX() <= 1480) {
                player.setDirection(Direction.RIGHT);
            }
        }

        if (key == KeyboardEvent.KEY_UP) {
            if (player.getY() >= 20) {
                player.setDirection(Direction.UP);
            }
        }

        if (key == KeyboardEvent.KEY_DOWN) {
            if (player.getY() <= 780) {
                player.setDirection(Direction.DOWN);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}