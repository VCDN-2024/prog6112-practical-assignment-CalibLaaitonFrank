package brickgame;

class Brick extends GameObject {
    private boolean destroyed;

    public Brick(int x, int y) {
        super(x, y);
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning
