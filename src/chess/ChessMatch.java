package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board = new Board(8, 8); //partida de xadrez, tem como referencia passada no construtor, linhas e colunas
    }

    public ChessPiece[][] getPieces(){
        ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i=0; i<board.getRows();i++){ //percorre as linhas da matriz
            for(int j=0; j<board.getColumns();j++){ //percorre as colunas da matriz
                mat[i][j] = (ChessPiece) board.piece(i, j); //Downcasting, que irá interpretar a peça de xadrez
            }
        }
        return mat; //retorna a matriz de peças da partida de xadrez
    }
    
}
