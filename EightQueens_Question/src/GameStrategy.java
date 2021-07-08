public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
				
		return cellId%8;	
	}
	
	private int getRow(int cellId) {

		return cellId/8;	
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		if(placedQueens[row][col]==true)
			isValid=false;
		else {
			boolean canplace=false;
			//check rows and columns
			for(int i=0;i<8;i++) {

				canplace=canplace || placedQueens[i][col];
				canplace=canplace || placedQueens[row][i];

			}
			//check for all diagonals
			for(int i=row,j=col;i>=0 && j>=0;i--,j--)
				canplace=canplace || placedQueens[i][j];
			for(int i=row,j=col;j<8 && i<8;i++,j++)
				canplace=canplace || placedQueens[i][j];
			for(int i=row,j=col;j>=0 && i<8;i++,j--) {
				canplace=canplace|| placedQueens[i][j];
			}		
			for(int i=row,j=col;i>=0 && j<8;i--,j++) {
				canplace=canplace || placedQueens[i][j];
			}
			if(canplace==true) {
				isValid=false;
			}
			else {
				placedQueens[row][col]=true;
				numQueens++;
			}
		}
		return isValid;
	}
}














