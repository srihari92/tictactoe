public class TicTacToe {

    String[][] board;
    int boardSize;

    enum PLAYER {
        X("X"), O("O");

        private String displayName;

        PLAYER(String name) {
            this.displayName = name;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    String playerXVictoryStr = "";
    String playerOVictoryStr = "";
    private PLAYER winner = null;

    public TicTacToe(int size) {
        this.boardSize = size;
        board = new String[size][size];
        fillBoard();
        playerXVictoryStr = PLAYER.X.getDisplayName().repeat(size);
        playerOVictoryStr = PLAYER.O.getDisplayName().repeat(size);
    }

    public PLAYER getWinningPlayer() {
        return winner;
    }

    public boolean move(int poistion, PLAYER player) {
        int x = (poistion-1) / this.boardSize;
        int y = (poistion-1) % this.boardSize;
        if(board[x][y].equals("X") || board[x][y].equals("O")){
            return false;
        }
        board[x][y] = player.getDisplayName();
        return true;
    }

    private void fillBoard() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ++count + "";
            }
        }
    }

    public void printBoard() {
        StringBuilder builder = new StringBuilder();
        String headings = "";
        for (int i = 0; i < board.length; i++) {
            builder.append("|");
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    headings += "|---";
                }
                builder.append(" ").append(board[i][j]).append(" |");
            }
            if (i == board.length - 1) {
                headings += "|\n";
            }
            builder.append("\n");
        }
        builder.insert(0, headings);
        builder.append(headings);
        System.out.println(builder.toString());
    }

    public void checkGameState() {
      
        String rightDiagonal = "";
        String leftDiagonal = "";
        for (int i = 0; i < board.length; i++) {
            String vertical = "";
            String horizontal = "";
            for (int j = 0, l = board[i].length - 1; j < board[i].length; j++, l--) {
                vertical += board[i][j];
                horizontal += board[j][i];
                if (i == j) {
                    rightDiagonal += board[i][j];
                    leftDiagonal += board[i][l];
                }
            }
            if (vertical.matches("[X]{" + this.boardSize + ",}")
                    || horizontal.matches("[X]{" + this.boardSize + ",}")) {
                winner = PLAYER.X;
                break;
            }
            if (vertical.matches("[O]{" + this.boardSize + ",}")
                    || horizontal.matches("[O]{" + this.boardSize + ",}")) {
                winner = PLAYER.O;
                break;
            }
        }
        if (rightDiagonal.matches("[X]{" + this.boardSize + ",}")
                || leftDiagonal.matches("[X]{" + this.boardSize + ",}")) {
            winner = PLAYER.X;
        }
        if (leftDiagonal.matches("[O]{" + this.boardSize + ",}")
                || rightDiagonal.matches("[O]{" + this.boardSize + ",}")) {
            winner = PLAYER.O;
        }
    }

    private String getStringByMultipler(String str, int multipler) {
        return str.repeat(multipler);
    }

}
