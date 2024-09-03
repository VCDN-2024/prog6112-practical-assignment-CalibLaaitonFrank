package brickgame;
import javax.swing.JOptionPane;

//Create a public class BrickGame
public class BrickGame {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(3, 5);

        while (true) {
            gameBoard.moveBall();
            String report = gameBoard.generateReport();
            JOptionPane.showMessageDialog(null, report, "Brick Game Status", JOptionPane.INFORMATION_MESSAGE);

            String input = JOptionPane.showInputDialog(null, "Enter 'a' to move left, 'd' to move right, 'q' to quit:");

            if (input == null || input.equals("q")) {
                JOptionPane.showMessageDialog(null, "Game Ended by Player. Final Score: " + gameBoard.getScore(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (input.equals("a")) {
                gameBoard.movePaddleLeft();
            } else if (input.equals("d")) {
                gameBoard.movePaddleRight();
            }
        }
    }
}


//REFERENCES
//Farell, J, 2019. Java Programming, 9th edition. Cengage Learning
//Oracle. (uknown) JOptionPane (Java Platform SE 8).[online]. Available at: https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html (Accessed: 1 September 2024).
