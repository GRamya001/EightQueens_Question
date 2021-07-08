public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {

		// WRITE YOUR LOGIC HERE...
		if((square%2!=0 && (square/8)%2 == 0) || (square%2 == 0 && (square/8)%2 == 1))
            return true;
        else 
            return false;
	}
}
