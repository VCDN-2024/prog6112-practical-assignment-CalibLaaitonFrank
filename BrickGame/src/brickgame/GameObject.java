package brickgame;

class GameObject {
    protected int x, y;  // Protected fields allow access to subclasses while keeping encapsulation

    //Constructor to initialize the GameObject with specified x and y coordinates
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getter method for the x coordinate.
    public int getX() {
        return x;
    }

    //Getter method for the y coordinate
    public int getY() {
        return y;
    }

    //Method to set the position of the GameObject to new x and y coordinates
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning