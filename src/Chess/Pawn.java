package Chess;

public class Pawn extends Piece
{	
	public Pawn(String pieceType) 
	{
		super(pieceType);
	}

	private static double WHITE_PAWN_Y_STARTING_SPOT = 1;
	private static double BLACK_PAWN_Y_STARTING_SPOT = 6;
	private static double PAWN_MOVEMENT_RESTRICTION = 1;
	private static double PAWN_MOVEMENT_COUNT = 1;

	@Override
	public boolean validMovement(double x1, double y1, double x2, double y2)
	{
		boolean move = false;
		
		return move;
	}
}