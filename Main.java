package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incomingCharacters = "         ";
        int length_IncomingCharacters = incomingCharacters.length();

        int[][] arrayOfCharacters = new int[3][3];

        int loopCounter = 0;
        int countEmptyValues = 0;
        int countCharX = 0;
        int countCharO = 0;

        // Created matrix of numbers, based on characters.
        for (int i = 0; i < arrayOfCharacters.length; i++) {
            for (int j = 0; j < arrayOfCharacters[i].length; j++) {
                if (incomingCharacters.charAt(loopCounter) == 'O') {
                    arrayOfCharacters[i][j] = 1;
                    countCharO++;
                } else if (incomingCharacters.charAt(loopCounter) == 'X') {
                    arrayOfCharacters[i][j] = -1;
                    countCharX++;
                } else if (incomingCharacters.charAt(loopCounter) == ' ' || incomingCharacters.charAt(loopCounter) == '_') {
                    arrayOfCharacters[i][j] = 0;
                    countEmptyValues++;
                }
                loopCounter++;
            }
        }

        // Output to the console of the playing field.
        System.out.println("---------");
        for (int i = 0; i < length_IncomingCharacters; i += 3) {
            for (int j = 0; j < 1; j++) {
                System.out.print("| ");
                for (int c = 0; c < 3; c++) {
                    System.out.print(incomingCharacters.charAt(i + c) + " ");
                }
                System.out.println("|");
            }
        }
        System.out.println("---------");

        String gameResult = "";

        // Check incoming coordinate & add a value. _XXOO_OX_
        boolean access = false;
        boolean condition = false;
        int switchCount = 0;
        int charNumber = -1;


        do {
            try {
                switch (switchCount) {
                    case 0:
                        charNumber = -1;
                        break;
                    case 1:
                        charNumber = 1;
                        break;
                    case 2:
                        charNumber = -1;
                        break;
                    case 3:
                        charNumber = 1;
                        break;
                    case 4:
                        charNumber = -1;
                        break;
                    case 5:
                        charNumber = 1;
                        break;
                    case 6:
                        charNumber = -1;
                        break;
                    case 7:
                        charNumber = 1;
                        break;
                    case 8:
                        charNumber = -1;
                        break;
                }

                int incomingCoordinateX = scanner.nextInt();
                int incomingCoordinateY = scanner.nextInt();

                if ((incomingCoordinateX < 1 || incomingCoordinateX > 3) || (incomingCoordinateY < 1 || incomingCoordinateY > 3)) {
                    System.out.println("---------");
                    for (int i = 0; i < arrayOfCharacters.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            if (arrayOfCharacters[i][j] == -1) {
                                System.out.print("X ");
                            }
                            if (arrayOfCharacters[i][j] == 1) {
                                System.out.print("O ");
                            }
                            if (arrayOfCharacters[i][j] == 0) {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("|");
                    }
                    System.out.println("---------");
                    System.out.println("Coordinates should be from 1 to 3!");
                    condition = false;

                } else if (arrayOfCharacters[incomingCoordinateX - 1][incomingCoordinateY - 1] == 1 || arrayOfCharacters[incomingCoordinateX - 1][incomingCoordinateY - 1] == -1) {
                    System.out.println("---------");
                    for (int i = 0; i < arrayOfCharacters.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            if (arrayOfCharacters[i][j] == -1) {
                                System.out.print("X ");
                            }
                            if (arrayOfCharacters[i][j] == 1) {
                                System.out.print("O ");
                            }
                            if (arrayOfCharacters[i][j] == 0) {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("|");
                    }
                    System.out.println("---------");

                    System.out.println("This cell is occupied! Choose another one!");
                    condition = false;
                } else {
                    arrayOfCharacters[incomingCoordinateX - 1][incomingCoordinateY - 1] = charNumber;
                    switchCount++;
                    System.out.println("---------");
                    for (int i = 0; i < arrayOfCharacters.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            if (arrayOfCharacters[i][j] == -1) {
                                System.out.print("X ");
                            }
                            if (arrayOfCharacters[i][j] == 1) {
                                System.out.print("O ");
                            }
                            if (arrayOfCharacters[i][j] == 0) {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("|");
                    }
                    System.out.println("---------");

                    // Check of rows.
                    int oCountCheck = 0;
                    int xCountCheck = 0;
                    for (int i = 0; i < arrayOfCharacters.length; i++) {
                        if (arrayOfCharacters[i][0] == arrayOfCharacters[i][1] && arrayOfCharacters[i][1] == arrayOfCharacters[i][2]) {
                            if (arrayOfCharacters[i][0] == 1) {
                                oCountCheck += 1;
                                gameResult = "O wins";
                                condition = true;
                            }
                            if (arrayOfCharacters[i][0] == -1) {
                                xCountCheck += 1;
                                gameResult = "X wins";
                                condition = true;
                            }
                        }
                    }

                    // Check of columns.
                    for (int i = 0; i < arrayOfCharacters.length; i++) {
                        if (arrayOfCharacters[0][i] == arrayOfCharacters[1][i] && arrayOfCharacters[1][i] == arrayOfCharacters[2][i]) {
                            if (arrayOfCharacters[0][i] == 1) {
                                oCountCheck += 1;
                                gameResult = "O wins";
                                condition = true;
                            }
                            if (arrayOfCharacters[0][i] == -1) {
                                xCountCheck += 1;
                                gameResult = "X wins";
                                condition = true;
                            }
                        }
                    }

                    // Check of diagonal (to the right).
                    if (arrayOfCharacters[2][0] == arrayOfCharacters[1][1] && arrayOfCharacters[1][1] == arrayOfCharacters[0][2]) {
                        if (arrayOfCharacters[2][0] == 1) {
                            oCountCheck += 1;
                            gameResult = "O wins";
                            condition = true;
                        } else if (arrayOfCharacters[2][0] == -1) {
                            xCountCheck += 1;
                            gameResult = "X wins";
                            condition = true;
                        }
                    }

                    // Check of diagonal (to the left).
                    if (arrayOfCharacters[0][0] == arrayOfCharacters[1][1] && arrayOfCharacters[1][1] == arrayOfCharacters[2][2]) {
                        if (arrayOfCharacters[0][0] == 1) {
                            oCountCheck += 1;
                            gameResult = "O wins";
                            condition = true;
                        } else if (arrayOfCharacters[0][0] == -1) {
                            xCountCheck += 1;
                            gameResult = "X wins";
                            condition = true;
                        }
                    }

                    // Check the completion of the game
                    if (xCountCheck + oCountCheck == 0 && countEmptyValues > 0) {
                        if ((countCharX - countCharO != 2) || (countCharO - countCharX != 2)) {
                            gameResult = "Game not finished";
                        }
                    }

                    // Check the correctness of the values
                    if (xCountCheck == 1 && oCountCheck == 1) {
                        gameResult = "Impossible";
                    }
                    if ((countCharX - countCharO == 2) || (countCharO - countCharX == 2)) {
                        gameResult = "Impossible";
                    }

                    // Check of the draw result.
                    if (countEmptyValues == 0 && xCountCheck + oCountCheck == 0) {
                        gameResult = "Draw";
                        condition = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                condition = false;
                scanner = new Scanner(System.in);
            }
        } while (condition == false);

        // Output to the console of the playing field. After game step.
        System.out.println(gameResult);
    }
}

