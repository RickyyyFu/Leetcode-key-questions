package LC_348;

public class TicTacToe {
	 	private int[][] rows = new int[2][];
	    private int[][] cols = new int[2][];
	    private int[] diag = new int[2];
	    private int[] adiag = new int[2];
	    private int n;
	 
	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        for(int i=0; i<n; i++) {
	            rows[0] = new int[n];
	            rows[1] = new int[n];
	            cols[0] = new int[n];
	            cols[1] = new int[n];
	        }
	        this.n = n;
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        player --;
	        rows[player][row] ++;
	        cols[player][col] ++;
	        if (row == col) diag[player] ++;
	        if (row + col == n - 1) adiag[player] ++;
	        for(int i=0; i<2; i++) {
	            if (diag[i] == n) return i+1;
	            if (adiag[i] == n) return i+1;
	            for(int j=0; j<n; j++) {
	                if (rows[i][j] == n) return i+1;
	                if (cols[i][j] == n) return i+1;
	            }
	        }
	        return 0;
	    }
}

// https://blog.csdn.net/jmspan/article/details/51441236
