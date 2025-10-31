public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(searchMazeMoves(new String[][]{
			{"", "", "", "", ""},
     		{"", "", "", "", ""},
      		{"", "", "*", "", ""},
      		{"S", "*", "F", "", ""}
		}));
	}

	public static int searchMazeMoves (String[][] maze) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
	    int moves = 0;
	    int row = maze.length - 1;
	    int col = 0;
	    
	    return dfsHelper (maze, row, col, moves, visited);
	}
	
	public static int dfsHelper (String[][] maze, int row, int col, int moves, boolean[][] visited) {
		 if (row < 0 || col >= maze[0].length || col < 0 || row >= maze.length || maze[row][col] == "*" || visited[row][col]) {
	        return -1;
	    }
	    
	    if (maze[row][col] == "F") {
	        return moves;
	    }

	    moves++;
		visited[row][col] = true;
		int movesRight = dfsHelper(maze, row, col + 1, moves, visited);
		int movesUp = dfsHelper(maze, row - 1, col, moves, visited);
		int movesLeft = dfsHelper(maze, row, col - 1, moves, visited);
		int movesDown = dfsHelper(maze, row + 1, col, moves, visited);

		int[] uniqueMoves = {movesDown, movesRight, movesUp, movesLeft};
		int min = Integer.MAX_VALUE;
	    
		for (int i : uniqueMoves) {
			if (i > 0 && i < min) {
				min = i;
			}
		}
		if (movesRight == -1 && movesLeft == -1 && movesUp == -1 && movesDown == -1) {
			min = -1;
		}
		visited[row][col] = false;
		return min;
	}
}
