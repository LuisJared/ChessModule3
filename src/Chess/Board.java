package Chess;

public class Board 
{
	private final int boardHeight = 8;
	private final int boardWidth = 8;
	
	private Square[][] chessBoard = new Square[boardHeight][boardWidth];
	
	public Board()
	{		
		Piece blankPiece = new Piece();
		blankPiece.setPieceType("-");
		
		for(int i = 0; i < boardHeight; i++)
		{
			for(int k = 0; k < boardWidth; k++)
			{
				Position position = new Position(i, k);
				
				chessBoard[i][k] = new Square(blankPiece, position);
			}
		}
	}
	
	public void addPieceToBoard(Piece piece, int x, int y)
	{
		Position position = new Position(x, y);
		chessBoard[x][y] = new Square(piece, position);
	}
	
	public void movePieceOnBoard(String command, Position start, Position end)
	{
		int x1 = start.getPositionX();
		int y1 = start.getPositionY();
		int x2 = end.getPositionX();
		int y2 = end.getPositionY();
		String startSpot = command.substring(0,2);
		String endSpot = command.substring(3,5);
		
		Piece piece = chessBoard[x1][y1].getPiece();
		
		if(piece.validMovement(x1, y1, x2, y2))
		{						
			piece.setPieceType(chessBoard[x1][y1].getPiece().getPieceType());
			
			if(chessBoard[x2][y2].getPiece().getPieceColor() != (piece.getPieceColor()))
			{
				if(otherPieceExistsInPath(x1, y1, x2, y2))
				{
					chessBoard[x2][y2] = new Square(piece, end);
					
					chessBoard[x1][y1] = new Square(new Piece(), start);
					chessBoard[x1][y1].getPiece().setPieceType("-");
					chessBoard[x1][y1].getPiece().setPieceColor("-");
					
					System.out.println();
					System.out.print("Successfully moved piece " + startSpot + " to " + endSpot);
					printBoard();
					System.out.println();
				}
				else
				{
					System.out.println();
					System.out.println(command + " \nYou can't do that!  Your path is being blocked!");
				}
			}
			else
			{
				System.out.println();
				System.out.print("There is a an ally piece on the spot you are trying to move to! " + endSpot + " \nMove is not valid!");
			}
		}
		else
		{
			System.out.println();
			System.out.print(command + " is an invalid move command! Please revise it!");
			System.out.println();
		}
	}
	
	public boolean otherPieceExistsInPath(int x1, int y1, int x2, int y2)
	{
		boolean moveCompletable = true;
		
		int verticleMovement = y2 - y1;
		int horizontalMovement = x2 - x1;
		int upRightMovement = verticleMovement - horizontalMovement;		
		int diagonalMovement = verticleMovement + horizontalMovement;
		int mathCheck = 0;
		
		if(verticleMovement != mathCheck && (horizontalMovement == mathCheck))
		{			
			moveCompletable = (y2 > y1) ? verticleMovementPathCheck(x1, y1, y2) : verticleMovementPathCheck(x1, y2, y1);
		}
		
		if(horizontalMovement != mathCheck && (verticleMovement == mathCheck))
		{
			moveCompletable = (x2 > x1) ? horizontalMovementPathCheck(y1, x1, x2) : horizontalMovementPathCheck(y1, x2, x1);
		}
		
		if(diagonalMovement == mathCheck)
		{
			moveCompletable = (x2 < x1) && (y2 > y1) ? diagonalMovementPathCheckBottomRightToTopLeft(y1, x1, x2) : diagonalMovementPathCheckBottomRightToTopLeft(y2, x2, x1); 
		}
		
		if(upRightMovement == mathCheck || (verticleMovement == horizontalMovement))
		{
			moveCompletable = (x2 > x1) && (y2 > y1) ? diagonalMovementPathCheckBottomLeftToTopRight(y1, x1, x2) : diagonalMovementPathCheckBottomLeftToTopRight(y2, x2, x1);
		}
		
		return moveCompletable;
	}
	
	private boolean verticleMovementPathCheck(int x1, int y1, int y2)
	{
		boolean moveCompletable = true;
		
		for(int i = y1+1; moveCompletable && (i < y2); i++)
		{
			if(chessBoard[x1][i].getPiece().getPieceType().toString() != "-")
			{
				moveCompletable = false;
			}
		}
		return moveCompletable;
	}
	
	private boolean horizontalMovementPathCheck(int y1, int x1, int x2)
	{
		boolean moveCompletable = true;
		
		for(int i = x1+1; moveCompletable && (i < x2); i++)
		{
			if(chessBoard[i][y1].getPiece().getPieceType().toString() != "-")
			{
				moveCompletable = false;
			}
		}		
		return moveCompletable;
	}
	
	private boolean diagonalMovementPathCheckBottomRightToTopLeft(int y1, int x1, int x2)
	{
		boolean moveCompletable = true;
		int y = y1+1;
		for(int x = x1-1; moveCompletable && (x > x2); x--, y++)
		{
			if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
			{
				moveCompletable = false;
			}
		}
		
		return moveCompletable;
	}
	
	private boolean diagonalMovementPathCheckBottomLeftToTopRight(int y1, int x1, int x2)
	{
		boolean moveCompletable = true;
		
		int y = y1+1;
		for(int x = x1+1; moveCompletable && (x < x2); x++, y++)
		{
			if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
			{
				moveCompletable = false;
			}
		}
		return moveCompletable;
	}

	public void printBoard()
	{
		for(int i = (boardHeight-1); i >= 0; i--)
		{			
			System.out.println();
			
			for(int k = 0; k < boardWidth; k++)
			{
				System.out.print("[ " + chessBoard[k][i].getPiece().getPieceType() + " ]");
			}
		}
	}
}