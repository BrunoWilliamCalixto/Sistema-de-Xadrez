package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) { //Aqui informo quem é o tabuleiro e quem é a cor da peça e
        super(board, color);         //     repasso os dados para o construtor da classe.
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

    
    
}