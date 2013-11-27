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
//		addInitialPiecesToBoard();
	}
	
	public void addPieceToBoard(Piece piece, int x, int y)
	{
		Position position = new Position(x, y);
		chessBoard[x][y] = new Square(piece, position);
	}
	
	public void addInitialPiecesToBoard()
	{		
//		int a = 0;
//		int b = 1;
//		int c = 2;
//		int d = 3;
//		int e = 4;
//		int f = 5;
//		int g = 6;
//		int h = 7;
//		
//		Piece leftWhiteRook = new Rook();
//		leftWhiteRook.setPieceType("r");
//		leftWhiteRook.setPieceColor("White");
//		Position leftWhiteRookPosition = new Position(a, 1);
//		
//		Piece rightWhiteRook = new Rook();
//		rightWhiteRook.setPieceType("r");	
//		rightWhiteRook.setPieceColor("White");
//		Position rightWhiteRookPosition = new Position(h, 1);
//		
//		Piece leftWhiteKnight = new Knight();
//		leftWhiteKnight.setPieceType("n");
//		leftWhiteKnight.setPieceColor("White");
//		Position leftWhiteKnightPosition = new Position(b, 1);
//		
//		Piece rightWhiteKnight = new Knight();
//		rightWhiteKnight.setPieceType("n");
//		rightWhiteKnight.setPieceColor("White");
//		Position rightWhiteKnightPosition = new Position(g, 1);
//		
//		Piece leftWhiteBishop = new Bishop();
//		leftWhiteBishop.setPieceType("b");
//		leftWhiteBishop.setPieceColor("White");
//		Position leftWhiteBishopPosition = new Position(c, 1);
//		
//		Piece rightWhiteBishop = new Bishop();
//		rightWhiteBishop.setPieceType("b");
//		rightWhiteBishop.setPieceColor("White");
//		Position rightWhiteBishopPosition = new Position(f, 1);
//		
//		Piece whiteQueen = new Queen();
//		whiteQueen.setPieceType("q");
//		whiteQueen.setPieceColor("White");
//		Position whiteQueenPosition = new Position(d, 1);
//		
//		Piece whiteKing = new King();
//		whiteKing.setPieceType("k");
//		whiteKing.setPieceColor("White");
//		Position whiteKingPosition = new Position(e, 1);
//		
//		Piece leftBlackRook = new Rook();
//		leftBlackRook.setPieceType("R");		
//		leftBlackRook.setPieceColor("Black");
//		Position leftBlackRookPosition = new Position(a, 7);
//		
//		Piece rightBlackRook = new Rook();
//		rightBlackRook.setPieceType("R");	
//		rightBlackRook.setPieceColor("Black");
//		Position rightBlackRookPosition = new Position(h, 7);
//		
//		Piece leftBlackKnight = new Knight();
//		leftBlackKnight.setPieceType("N");
//		leftBlackKnight.setPieceColor("Black");
//		Position leftBlackKnightPosition = new Position(b, 7);
//		
//		Piece rightBlackKnight = new Knight();
//		rightBlackKnight.setPieceType("N");
//		rightBlackKnight.setPieceColor("Black");
//		Position rightBlackKnightPosition = new Position(g, 7);
//		
//		Piece leftBlackBishop = new Bishop();
//		leftBlackBishop.setPieceType("B");
//		leftBlackBishop.setPieceColor("Black");
//		Position leftBlackBishopPosition = new Position(c, 7);
//		
//		Piece rightBlackBishop = new Bishop();
//		rightBlackBishop.setPieceType("B");
//		rightBlackBishop.setPieceColor("Black");
//		Position rightBlackBishopPosition = new Position(f, 7);
//		
//		Piece blackQueen = new Queen();
//		blackQueen.setPieceType("Q");
//		blackQueen.setPieceColor("Black");
//		Position blackQueenPosition = new Position(d, 7);
//		
//		Piece blackKing = new King();
//		blackKing.setPieceType("K");
//		blackKing.setPieceColor("Black");
//		Position blackKingPosition = new Position(e, 7);
//		
//		chessBoard[a][0] = new Square(leftWhiteRook, leftWhiteRookPosition);
//		chessBoard[b][0] = new Square(leftWhiteKnight, leftWhiteKnightPosition);
//		chessBoard[c][0] = new Square(leftWhiteBishop, leftWhiteBishopPosition);
//		chessBoard[d][0] = new Square(whiteQueen, whiteQueenPosition);
//		chessBoard[e][0] = new Square(whiteKing, whiteKingPosition);
//		chessBoard[f][0] = new Square(rightWhiteBishop, rightWhiteBishopPosition);
//		chessBoard[g][0] = new Square(rightWhiteKnight, rightWhiteKnightPosition);
//		chessBoard[h][0] = new Square(rightWhiteRook, rightWhiteRookPosition);
//		
//		chessBoard[a][7] = new Square(leftBlackRook, leftBlackRookPosition);
//		chessBoard[b][7] = new Square(leftBlackKnight, leftBlackKnightPosition);
//		chessBoard[c][7] = new Square(leftBlackBishop, leftBlackBishopPosition);
//		chessBoard[d][7] = new Square(blackQueen, blackQueenPosition);
//		chessBoard[e][7] = new Square(blackKing, blackKingPosition);
//		chessBoard[f][7] = new Square(rightBlackBishop, rightBlackBishopPosition);
//		chessBoard[g][7] = new Square(rightBlackKnight, rightBlackKnightPosition);
//		chessBoard[h][7] = new Square(rightBlackRook, rightBlackRookPosition);
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
		}
	}
	
	public boolean otherPieceExistsInPath(int x1, int y1, int x2, int y2)
	{
		boolean moveCompletable = true;
		
		int verticleMovement = y2 - y1;
		int horizontalMovement = x2 - x1;
		int upRightMovement = verticleMovement - horizontalMovement;
		int downRightMovement = verticleMovement + horizontalMovement;
		int upLeftMovement = verticleMovement + horizontalMovement;
		
		// up path
		if(verticleMovement != 0 && (horizontalMovement == 0) && (y2 > y1))
		{
			for(int i = y1+1; i < y2; i++)
			{
				if(chessBoard[x1][i].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
					break;
				}
			}
		}
		// down path
		if(verticleMovement != 0 && (horizontalMovement == 0) && (y2 < y1))
		{			
			for(int i = y1-1; i > y2; i--)
			{
				if(chessBoard[x1][i].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
					break;
				}
			}
		}
		
		// right path
		if(horizontalMovement != 0 && (verticleMovement == 0) && (x2 > x1))
		{
			for(int i = x1+1; i < x2; i++)
			{
				if(chessBoard[i][y1].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
					break;
				}
			}
		}

		// left path
		if(horizontalMovement != 0 && (verticleMovement == 0) && (x2 < x1))
		{
			for(int i = x1-1; i > x2; i--)
			{
				if(chessBoard[i][y1].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
					break;
				}
			}
		}
		
		// up right path
		if(upRightMovement == 0 && (x2 > x1) && (y2 > y1))
		{
			int y = y1+1;
			for(int x = x1+1; x < x2; x++, y++)
			{
				if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
				}
			}
		}
		// down right path
		if(downRightMovement == 0 && (x2 > x1) && (y2 < y1))
		{
			int y = y1-1;
			for(int x = x1+1; x < x2; x++, y--)
			{
				if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
				}
			}
		}
		//down left path
		if(verticleMovement == horizontalMovement && (x2 < x1) && (y2 < y1))
		{
			int y = y1 - 1;
			for(int x = x1-1; x > x2; x--, y--)
			{
				if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
				}
			}
		}
		// up left path
		if(upLeftMovement == 0 && (x2 < x1) && (y2 > y1))
		{
			int y = y1+1;
			for(int x = x1-1; x > x2; x--, y++)
			{
				if(chessBoard[x][y].getPiece().getPieceType().toString() != "-")
				{
					moveCompletable = false;
				}
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