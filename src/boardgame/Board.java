package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; // declaração da matriz de peças

    public Board(int rows, int columns) {
        if(rows < 1 || columns <1){
            throw new BoardException("Erro ao criando tabuleiro: é necessário que exista 1 linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)){
            throw new BoardException("Posição não se encontra no tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if(!positionExists(position)){
            throw new BoardException("Posição não se encontra no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){ //passado como argumento no método, peça e posição
        if(thereIsAPiece(position)){
            throw new BoardException("Peça já está na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece; // pegamos a matriz na posição dada, e atribuí a peça que informei
        piece.position = position; //Atualização de peça através da classe Piece, consigo então, acessar livremente a posição da peça
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não existe");
        }
        if(piece(position)== null){
            return null;
        }
        Piece aux = piece(position); //variável de peça local para auxiliar a exclusão da peça
        aux.position = null; //posição auxiliar que recebe um valor nulo caso a peça seja removida
        pieces[position.getRow()][position.getColumn()] = null; // Matriz de peças que ao ser acessado pelas linhas e colunas, indica que a peça foi retirada.
        return aux; // retorna o processamento da peça.
    }

    private boolean positionExists(int row, int column){ // posição dentro do tabuleiro
       return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){ // sobrecarga de método, onde se é retornado a posição de linha e coluna do tabuleiro
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){ // se a peça do tabuleiro for diferente de nulo, ela retorna verdadeiro e retona a peça para a matriz de Position
        if(!positionExists(position)){
            throw new BoardException("Posição não se encontra no tabuleiro");
        }
        return piece(position) != null;
    }

    
}
