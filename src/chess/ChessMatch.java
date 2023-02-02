package chess;

import boardgame.Board;
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
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition()); // Operação de colocar peça, passando a posição para as coordenadas de xadrez.
    }

    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));  //Instanciamos no tabuleiro, uma nova peça (torre) que passa como argumento o tabuleiro, uma cor enumerada como branca, em uma nova posição de linha 2 e colina 1.
        placeNewPiece('e', 8, new King(board, Color.BLACK));  
        placeNewPiece('e', 1, new King(board, Color.WHITE));  
        
    }
}
