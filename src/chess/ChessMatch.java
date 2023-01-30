package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board = new Board(8, 8); //partida de xadrez, tem como referencia passada no construtor, linhas e colunas
        initialSetup();
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
    
    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); //Instanciamos no tabuleiro, uma nova peça (torre) que passa como argumento o tabuleiro, uma cor enumerada como branca, em uma nova posição de linha 2 e colina 1.
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }
}
