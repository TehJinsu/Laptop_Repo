public class Game {
    
    private int [][] Board = new int [8][8];

    private char [] Moves = new char [0];

    private int xvar = 0;

    private int yvar = 0;

    public int getXvar() {
        return this.xvar;
    }

    public void setXvar(int xvar) {
        this.xvar = xvar;
    }

    public int getYvar() {
        return this.yvar;
    }

    public void setYvar(int yvar) {
        this.yvar = yvar;
    }
    
    public int[][] getBoard() {
        return this.Board;
    }

    public void setBoard(int[][] Board) {
        this.Board = Board;
    }

    public char[] getMoves() {
        return this.Moves;
    }

    public void setMoves(char[] Moves) {
        this.Moves = Moves;
    }
    public Game (int currBoard, String moveIn) {
        setBoard(currBoard);
        File file = new file(moveIn);
    }
    
    // r = xvar++
    // b = yvar++
    // d = xvar++, yvar++ 
    public char readMoves() {
        int i = 0;
        Scanner input = new Scanner(new FileReader(file)).useDelimiter(" ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Moves[i] = line;
            i++;
        }
        Symstem.out.println(Moves);
    }

    public int play() {

    }



}

