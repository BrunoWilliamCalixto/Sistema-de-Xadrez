package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; // peça recém criada, se inicia com um valor nulo, como padrão, já se recebe uma
                         // posição como valor nulo
    }

    protected Board getBoard() { // somente pacotes e subclasses terão acessos ao tabuleiro
        return board;
    }

    public abstract boolean[][] possibleMoves(); //

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()]; // Método que faz um gancho com a subclasse
                                                                         // Piece
    }

    public boolean isThereAnyPossibleMove() { // Método de implementação padrão que depende de um método abstrato
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
