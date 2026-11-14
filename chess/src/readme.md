# Requirements
- A chess game
- validate move
- Entity.Player turn one by one
- player can control only his pieces
- Chess board 8*8
- Pieces (King, Queen, Knight, Rook, Bishop, Pawn)
- should detect checkmate & stale elevator.atm.state


# Entities
- Entity.Player
- ChessBoard
- Entity.Cell
- piece.Piece
  - King
  - Queen
  - Bishop
  - Knight
  - Rook
  - Pawn

# Classes

## ChessGame
  - startGame()
  - makeMove()

## Entity.Player
  - userId
  - color
  - rating

## Entity.Board
  - Entity.Board()


## Entity.Cell
  - color
  - isEmpty
  - piece.Piece

## piece.Piece
   - color
   - isAlive
   - position

   + isValidMove()
   + markDead()