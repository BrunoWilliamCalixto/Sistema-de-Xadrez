package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
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

    public boolean [][] possibleMoves(ChessPosition sourcePosition){ // possiveis movimentações da peça, para que seja imprimido na interface suas possibilidades.
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition(); 
        validateSourcePosition(source); //validação de origem da peça
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target); //variável que será responsável por realizar o movimento da peça, que recebe o resultado de Make Move
        return (ChessPiece)capturedPiece; //Downcasting do tipo piece, que passou a ser alocado em ChessPiece
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){ // Se não existir uma peça nesta posição, da uma exceção
            throw new ChessException("Não existe peça na posição de origem");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("Nao existem movimentos possiveis para a peca escolhida");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){ // se pra peça de origem, a possição de origem não for um movimento possivel, não podemos mexer a peça para lá
            throw new ChessException("A peca nao pode se mover para o local de destino");
        }
    }

    private Piece makeMove(Position source, Position targed){ // operação que recebe como argumento, a posição inicial e posição de destino
        Piece p = board.removePiece(source); // variavel que recebe a retirada de peça da posição de origem
        Piece capturedPiece = board.removePiece(targed); // remove a possivel peça da posição de destino;
        board.placePiece(p, targed);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition()); // Operação de colocar peça, passando a posição para as coordenadas de xadrez.
    }

    private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
