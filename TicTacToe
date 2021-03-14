import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // TODO good AI
    // TODO GUI

    private static final String borders = "---------";
    private static final String emptyLine = "| _ _ _ |";
    private static final int[] positions = {0,
            32, 34, 36,
            22, 24, 26,
            12, 14, 16};
    private static int movecnt = 0;

    public static void main(String[] args) {
        StringBuilder board = createBoard();

        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.print("Input the number of players (0 / 1 / 2): ");
        int players = input.nextInt();

        switch (players) {
            case 0:
                while (!finished(board)) {
                    boolean xMov = movecnt % 2 == 0;

                    if (xMov) {
                        xAi(board);
                    } else {
                        oAi(board);
                    }
                    System.out.println(board);

                    movecnt++;
                }
                break;
            case 1:
                System.out.print("X moves: ");

                while (!finished(board)) {
                    boolean xMov = movecnt % 2 == 0;

                    if (xMov) {
                        int position = input.nextInt();
                        xMove(board, position);
                    } else {
                        oAi(board);
                    }
                    System.out.println(board);

                    if (!xMov || finished(board)) {
                        System.out.print("X moves: ");
                    }

                    movecnt++;
                }
                break;
            case 2:
                System.out.print("X moves: ");

                while (!finished(board)) {
                    int position = input.nextInt();
                    boolean xMov = movecnt % 2 == 0;

                    if (xMov) {
                        xMove(board, position);
                    } else {
                        oMove(board, position);
                    }
                    System.out.println(board);

                    if (xMov && !finished(board)) {
                        System.out.print("O moves: ");
                    } else {
                        System.out.print("X moves: ");
                    }

                    movecnt++;
                }
                break;
            default:
                System.out.println("Learn to read, dum, dum... I said 0, 1 or 2!");
        }


        input.close();
        System.out.println(gameState(board));

    }


    private static StringBuilder createBoard( ) {
        StringBuilder board = new StringBuilder();
        board.append(borders).append("\n");
        board.append((emptyLine + "\n").repeat(3));
        board.append(borders);
        return board;
    }

    private static StringBuilder createBoard(int[] xS, int[] oS) {
        StringBuilder board = new StringBuilder();
        board.append(borders).append("\n");
        board.append((emptyLine + "\n").repeat(3));
        board.append(borders);

        for (int i : xS) {
            board.replace(positions[i], positions[i] + 1, "X");
        }
        for (int i : oS) {
            board.replace(positions[i], positions[i] + 1, "O");
        }
        return board;
    }

    private static boolean xWon(StringBuilder board) {
        boolean line1, line2, line3, row1, row2, row3, diag1, diag2;
        row1 = board.substring(positions[1], positions[3] + 1).equals("X X X");
        row2 = board.substring(positions[4], positions[6] + 1).equals("X X X");
        row3 = board.substring(positions[7], positions[9] + 1).equals("X X X");
        line1 = board.substring(positions[1], positions[1] + 1).equals("X") &&
                board.substring(positions[4], positions[4] + 1).equals("X") &&
                board.substring(positions[7], positions[7] + 1).equals("X");
        line2 = board.substring(positions[2], positions[2] + 1).equals("X") &&
                board.substring(positions[5], positions[5] + 1).equals("X") &&
                board.substring(positions[8], positions[8] + 1).equals("X");
        line3 = board.substring(positions[3], positions[3] + 1).equals("X") &&
                board.substring(positions[6], positions[6] + 1).equals("X") &&
                board.substring(positions[9], positions[9] + 1).equals("X");
        diag1 = board.substring(positions[1], positions[1] + 1).equals("X") &&
                board.substring(positions[5], positions[5] + 1).equals("X") &&
                board.substring(positions[9], positions[9] + 1).equals("X");
        diag2 = board.substring(positions[3], positions[3] + 1).equals("X") &&
                board.substring(positions[5], positions[5] + 1).equals("X") &&
                board.substring(positions[7], positions[7] + 1).equals("X");
        return line1 || line2 || line3 || row1 || row2 || row3 || diag1 || diag2;
    }

    private static boolean oWon(StringBuilder board) {
        boolean line1, line2, line3, row1, row2, row3, diag1, diag2;
        row1 = board.substring(positions[1], positions[3] + 1).equals("O O O");
        row2 = board.substring(positions[4], positions[6] + 1).equals("O O O");
        row3 = board.substring(positions[7], positions[9] + 1).equals("O O O");
        line1 = board.substring(positions[1], positions[1] + 1).equals("O") &&
                board.substring(positions[4], positions[4] + 1).equals("O") &&
                board.substring(positions[7], positions[7] + 1).equals("O");
        line2 = board.substring(positions[2], positions[2] + 1).equals("O") &&
                board.substring(positions[5], positions[5] + 1).equals("O") &&
                board.substring(positions[8], positions[8] + 1).equals("O");
        line3 = board.substring(positions[3], positions[3] + 1).equals("O") &&
                board.substring(positions[6], positions[6] + 1).equals("O") &&
                board.substring(positions[9], positions[9] + 1).equals("O");
        diag1 = board.substring(positions[1], positions[1] + 1).equals("O") &&
                board.substring(positions[5], positions[5] + 1).equals("O") &&
                board.substring(positions[9], positions[9] + 1).equals("O");
        diag2 = board.substring(positions[3], positions[3] + 1).equals("O") &&
                board.substring(positions[5], positions[5] + 1).equals("O") &&
                board.substring(positions[7], positions[7] + 1).equals("O");
        return line1 || line2 || line3 || row1 || row2 || row3 || diag1 || diag2;
    }

    private static boolean finished(StringBuilder board) {
        boolean x = xWon(board);
        boolean o = oWon(board);
        boolean emptySpace = true;
        for (int i = 1; i < positions.length; i++) {
            if (board.substring(positions[i], positions[i] + 1).equals("_")) {
                emptySpace = true;
                break;
            } else {
                emptySpace = false;
            }
        }
        boolean draw = !emptySpace && !x && !o;

        return draw || x || o;
    }

    private static String gameState(StringBuilder board) {
        if (finished(board)) {
            if (xWon(board)) {
                return "Player X won the game!";
            } else if (oWon(board)) {
                return "Player O won the game!";
            } else {
                return "Draw!";
            }
        } else {
            return "The game has not yet finished!";
        }
    }

    private static void xMove(StringBuilder board, int position) {
        if (freeSpace(board, position)) {
            board.replace(positions[position], positions[position] + 1, "X");
        } else {
            System.out.println("Spot taken, choose another spot");
            movecnt--;
        }
    }

    private static void oMove(StringBuilder board, int position) {
        if (freeSpace(board, position)) {
            board.replace(positions[position], positions[position] + 1, "O");
        } else {
            System.out.println("Spot taken, choose another spot");
            movecnt--;
        }
    }

    private static void oAi(StringBuilder board) {
        Random generator = new Random();
        int move = generator.nextInt(9) + 1;

        do {
            if (!freeSpace(board, move)) {
                move = generator.nextInt(9) + 1;
            }
        } while (!freeSpace(board, move));
        board.replace(positions[move], positions[move] + 1, "O");
    }

    private static void xAi(StringBuilder board) {
        Random generator = new Random();
        int move = generator.nextInt(9) + 1;

        do {
            if (!freeSpace(board, move)) {
                move = generator.nextInt(9) + 1;
            }
        } while (!freeSpace(board, move));
        board.replace(positions[move], positions[move] + 1, "X");
    }

    private static boolean freeSpace(StringBuilder board, int position) {
        return board.substring(positions[position], positions[position] + 1).equals("_");
    }

}
