package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
	public Pawn(PlayerColour colour) {
		super(Piece.PieceType.PAWN, colour);
	}

	@Override
	public List<Move> getAllowedMoves(Coordinates from, Board board) {

		int dir = 1;
		int origin = 1;
		if (this.getColour().equals(PlayerColour.WHITE)) {
			dir = -1;
			origin = 6;
		}

		ArrayList<Move> moves = new ArrayList<>();

		Coordinates to = new Coordinates(from.getRow() + dir, from.getCol());
		if(board.isEmpty(to))
		{
		moves.add(new Move(from, to));
		if (from.getRow()==origin && board.isEmpty(to.plus(dir,0))) {
			moves.add(new Move(from, new Coordinates(from.getRow() + (2*dir), from.getCol())));
		}
		}





		return moves;
	}
}
