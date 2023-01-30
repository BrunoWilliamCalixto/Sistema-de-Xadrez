package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //peça recém criada, se inicia com um valor nulo, como padrão, já se recebe uma posição como valor nulo
    }

    protected Board getBoard() { // somente pacotes e subclasses terão acessos ao tabuleiro
        return board;
    }
}
