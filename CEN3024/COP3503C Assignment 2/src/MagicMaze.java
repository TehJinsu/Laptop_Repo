import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicMaze {
	// 2D primative char array for the maze itself

	// String object for the name of the maze

	// 2 primitive ints for the rows and coloumns
	public char[][] Maze;
	private int row = 0;
	private int col = 0;

	private int returnRow;
	private int returnCol;

	public void setReturnRow(int returnRow) {
		this.returnRow = returnRow;
	}

	public void setReturnCol(int returnCol) {
		this.returnCol = returnCol;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public MagicMaze(String MazeName, int x, int y) throws IOException {
		// going to make method called readMaze to input into constructor
		String Maze = MazeName;
		setRow(x);
		setCol(y);
		readMaze(Maze);

	}

	public void readMaze(String MazeFile) throws IOException {
		Scanner MyScanner = new Scanner(new FileReader(MazeFile));
		Maze = new char[col][row];

		for (int x = 0; MyScanner.hasNextLine() && x < col; x++) {
			char[] chars = MyScanner.nextLine().toCharArray();
			for (int y = 0; y < row && y < chars.length; y++) {
				Maze[x][y] = chars[y];
			}
		}
		System.out.println(Arrays.deepToString(Maze).replace("], ", "]\n"));

	}

	public boolean solveMagicMaze() {
		// move cardinal directions
		// if an int is located move to same int in a different area
		// be efficient you fuck
		// also remeber to return true if X is found
		// if an X is found up down left right then immediately move to it
		// dont forget backtracking and reseting to initial values
		// if @ symbol cant move in that direction

		// initalize all components
		// recursive call

		return solveMagicMazeR(col - 1, 0, Maze);

	}

	public boolean solveMagicMazeR(int x, int y, char[][] Maze) {

		// backtrackR(k,n)
		// for each x[k]
		// if(bound[k])
		// set to okay values
		// if k == n
		// return true
		// else
		// recursive call k + 1,n
		// reset attributes

		// if the current value is a number store it
		// then turn the value into a .
		// then search for the value of the teleportationNumber
		// set the x&y value to that block
		// for ( int i = 0; i < 300; ++i ) {
		// for ( int j = 0; j < 300; ++j ) {
		// if ( array[i][j] == 255 ) {
		// Found the correct i,j - print them or return them or whatever
		// }
		// }
		// }
		/*
		 * for (int p = 0; p<row; p++) { for (int o = 0; o<col; o++) {
		 * System.out.print(Maze[p][o]); } System.out.print("\n"); }
		 */
		if (inBounds(x, y) == false) {
			return false;
		}

		if (Maze[x][y] == 'X') {
			return true;
		}
		if (Maze[x][y] == '@' || Maze[x][y] == '.') {
			return false;
		}

		if (Character.isDigit(Maze[x][y])) {
			teleportationPad(x,y);
			x = returnCol;
			y = returnRow;
		}
		Maze[x][y] = '.';

		// add contrainsts like && x != 0 for up
		// y != col -1

		boolean attempt;

		// right
		attempt = solveMagicMazeR(x, y + 1, Maze);
		if (attempt)
			return true;

		// Up
		attempt = solveMagicMazeR(x - 1, y, Maze);
		if (attempt)
			return true;

		// Left
		attempt = solveMagicMazeR(x, y - 1, Maze);
		if (attempt)
			return true;

		// Down
		attempt = solveMagicMazeR(x + 1, y, Maze);
		if (attempt)
			return true;

		Maze[x][y] = 'b';
		return false;
	}

	// do i need a function to tell if current grid is useable?
	// just need if "whatever == @" i cant go that way
	// have to pass the array to the checker and if the value at the current is @
	// cant use that direction
	// i can do all that shit in the recursive call
	public boolean inBounds(int x, int y) {
		if (x < 0 || y < 0 || x > col - 1 || y > row - 1) {
			return false;
		}
		return true;
	}

	public void teleportationPad(int x, int y) {
		char teleportationNumber;
		teleportationNumber = Maze[x][y];

		Maze[x][y] = '.';

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				if (Maze[j][i] == teleportationNumber) {
					setReturnRow(i);
					setReturnCol(j);
					return;
				}

			}
		}
	}
}
