package brickgame;

//Create a ball class that extends GameObject
class Ball extends GameObject {
    private int dx, dy;

    public Ball(int x, int y, int dx, int dy) {
        super(x, y);
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void reverseX() {
        dx = -dx;
    }

    public void reverseY() {
        dy = -dy;
    }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning