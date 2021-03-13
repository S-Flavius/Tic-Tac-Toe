package games;

@SuppressWarnings ("NestedMethodCall")
public class TicTacToe {

    // TODO Draw board
    // TODO Check game state
    // TODO Make moves
    // TODO Random AI
    // TODO good AI
    // TODO GUI

    private static final String borders = "---------";
    private static final String emptyLine = "| _ _ _ |";
    private static final int[] positions = { 0,
                                             14, 16, 18,
                                             25, 27, 29,
                                             36, 38, 40};

    public static void main(String[] args) {
        System.out.println(drawBoard());
        int[] xS = {1,3,5};
        int[] oS = {4,6,8};
        System.out.println(drawBoard(xS,oS));
    }

    private static StringBuilder drawBoard( ) {
        StringBuilder board = new StringBuilder();
        board.append(borders).append("\n");
        board.append((emptyLine + "\n").repeat(3));
        board.append(borders);
        return board;
    }

    private static StringBuilder drawBoard(int[] xS, int[] oS) {
        StringBuilder board = new StringBuilder();

        //TODO help me plox
        for (int i: xS) {
            System.out.println(positions[i]);
            System.out.println(positions[i]+1);
            board.replace(positions[i],positions[i]+2,"X");
        }
        for (int i: xS) {
            board.replace(positions[i],positions[i]+2,"O");
        }
        return board;
    }


}
