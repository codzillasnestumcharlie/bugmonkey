package org.academiadecodigo.codezillas.bugmonkey;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Computer {
        private int x;
        private int y;
        private boolean bugged;
        private Picture picture;

        public Computer(int x, int y){
            picture = new Picture(x, y, "computer.png");
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int gety(){
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

        public void setBugged(){
            if(bugged){
                bugged = false;
            } else {
                bugged = true;
            }
        }

        public Picture getComputer() {
            return picture;
        }

}
