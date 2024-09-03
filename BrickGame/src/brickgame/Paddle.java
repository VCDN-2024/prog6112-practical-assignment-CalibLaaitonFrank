package brickgame;

// The Paddle class represents the paddle in the brick game, which can move left and right.
class Paddle extends GameObject {
    private int width; // The width of the paddle

    // Constructor initializes the paddle's position (x, y) and its width
    public Paddle(int x, int y, int width) {
        super(x, y);
        this.width = width;
    }

    // Moves the paddle 2 units to the left
    public void moveLeft() {
        x -= 2;
    }

    // Moves the paddle 2 units to the right
    public void moveRight() {
        x += 2;
    }

    // Returns the width of the paddle
    public int getWidth() {
        return width;
    }
}



//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning