package brickgame;

class GameBoard {
    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks;
    private int rows, columns;
    private int score;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        ball = new Ball(5, 5, 1, 1);
        paddle = new Paddle(5, 10, 3);
        bricks = new Brick[rows][columns];
        score = 0;
        initializeBricks();
    }

    private void initializeBricks() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bricks[i][j] = new Brick(j * 2, i * 2);
            }
        }
    }

    public void moveBall() {
        ball.move();
        checkCollisions();
    }

    private void checkCollisions() {
        // Collision with walls
        if (ball.getX() <= 0 || ball.getX() >= columns * 2) {
            ball.reverseX();
        }
        if (ball.getY() <= 0) {
            ball.reverseY();
        }

        // Collision with paddle
        if (ball.getY() == paddle.getY() && ball.getX() >= paddle.getX() && ball.getX() <= paddle.getX() + paddle.getWidth()) {
            ball.reverseY();
        }

        // Collision with bricks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Brick brick = bricks[i][j];
                if (!brick.isDestroyed() && ball.getX() == brick.getX() && ball.getY() == brick.getY()) {
                    brick.destroy();
                    ball.reverseY();
                    score += 10;
                }
            }
        }

        // Game over condition
        if (ball.getY() > paddle.getY()) {
            System.out.println("Game Over! Final Score: " + score);
            System.exit(0);
        }
    }

    public void movePaddleLeft() {
        paddle.moveLeft();
    }

    public void movePaddleRight() {
        paddle.moveRight();
    }

    public void printReport() {
        System.out.println("Ball Position: (" + ball.getX() + ", " + ball.getY() + ")");
        System.out.println("Paddle Position: (" + paddle.getX() + ", " + paddle.getY() + ")");
        System.out.println("Bricks Remaining: " + countRemainingBricks());
        System.out.println("Score: " + score);
    }

    private int countRemainingBricks() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!bricks[i][j].isDestroyed()) {
                    count++;
                }
            }
        }
        return count;
    }
      
    public String generateReport() {
    StringBuilder report = new StringBuilder();
    report.append("Ball Position: (").append(ball.getX()).append(", ").append(ball.getY()).append(")\n");
    report.append("Paddle Position: (").append(paddle.getX()).append(", ").append(paddle.getY()).append(")\n");
    report.append("Bricks Remaining: ").append(countRemainingBricks()).append("\n");
    report.append("Score: ").append(score);
    return report.toString();
}

    public int getScore() {
       return score;
   }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning
//GeeksforGeeks. (2024) Java Swing Tutorial – Game Board.[online] Available at: https://www.geeksforgeeks.org/java-swing-tutorial (Accessed: 1 September 2024)
//TutorialsPoint. (2024) Java Game Development: Brick Breaker. [online] Available at: https://www.tutorialspoint.com/java-game-development-brick-breaker (Accessed: 2 September 2024).