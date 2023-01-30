package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; // declaração da matriz de peças

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){ //passado como argumento no método, peça e posição
        pieces[position.getRow()][position.getColumn()] = piece; // pegamos a matriz na posição dada, e atribuí a peça que informei
        piece.position = position; //Atualização de peça através da classe Piece, consigo então, acessar livremente a posição da peça
    }
}
