import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Game {
	// probably dont need all of these setters and getters but habit
	private int[][] Board;

	private char[] Moves = new char[15];

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

	public Game(int currBoard, String moveIn) throws FileNotFoundException {
		int[][] Board = new int[currBoard][currBoard];
		String Filename = moveIn;
		readMoves(Filename);
	}

	// r = xvar++
	// b = yvar++
	// d = xvar++, yvar++
	public char readMoves(String Filename) throws FileNotFoundException {
		int i = 0;
		// have to use a throw cause eclipse yells at me
		Scanner input = new Scanner((Readable) new FileReader(Filename)).useDelimiter(" ");
		while (input.hasNextLine()) {
			char line = input.nextLine().charAt(0);
			Moves[i] = line;
			i++;
		}
		return 0;
	}

	public int play(int player) {
		// if player one is passed p1 one must win
		// if player 2 is passed p1 must LOSE
		// P1 is always first no matter what

		// take how many diagonal moves to win ie [1][1] then 7 diagonal
		// and move diagonal until closer once
		// it is P1 turn and he is 1 move away move diagonal and win
		// if he is 2 away move down or right
		// if he is > 2 always diagonal
		// if xvar and y var == 7 return whatever player is playing
		int xVar = 0;
		int yVar = 0;
		int i = 0;
		int moves = 1;
		// uses playeronewins
		if (player == 1) {

			while (xVar <= 7 && yVar <= 7) {

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}
				// i++ after p1 moves
				char p1Move = playerOneWins(xVar, yVar);
				
				if (p1Move == 'r') {
					xVar++;
				}
				if (p1Move == 'b') {
					xVar++;
				}
				if (p1Move == 'd') {
					xVar++;
					yVar++;
				}

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}
				moves++;

				char compMove = computerMoves(xVar, yVar, i);
				if (compMove == 'r') {
					xVar++;
				}
				if (compMove == 'b') {
					xVar++;
				}
				if (compMove == 'd') {
					xVar++;
					yVar++;
				}

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}

				i++;
				moves++;
			}

			if(moves % 2 == 1) {
				return 1;
			}
			return 2;
		}

		// uses player one loses
		if (player == 2) {

			while (xVar <= 7 && yVar <= 7) {

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}
				
				char p1MoveLose = playerOneLoses(xVar, yVar);

				if (p1MoveLose == 'r') {
					xVar++;
				}
				if (p1MoveLose == 'b') {
					yVar++;
				}
				if (p1MoveLose == 'd') {
					xVar++;
					yVar++;
				}

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}
				moves++;
				
				char compMove = computerMoves(xVar, yVar, i);

				if (compMove == 'r') {
					xVar++;
				}
				if (compMove == 'b') {
					yVar++;
				}
				if (compMove == 'd') {
					xVar++;
					yVar++;
				}

				if (xVar == 7 && yVar == 7) {
					if(moves % 2 == 1) {
						return 1;
					}
					return 2;
				}
				i++;
				moves++;
			}
			if(moves % 2 == 1) {
				return 1;
			}
			return 2;
		}
		if(moves % 2 == 1) {
			return 1;
		}
		return 2;
	}

	public char playerOneWins(int x, int y) {

		if (x < 5 && y < 5) {
			return 'd';
		}

		if (x == 6 && y == 6) {
			return 'd';
		}

		if (x == 6 && y == 7) {
			return 'r';
		}

		if (x == 7 && y == 6) {
			return 'b';
		}

		if (x < y) {
			return 'r';
		}

		if (y < x) {
			return 'b';
		}

		return 0;

	}

	public char playerOneLoses(int x, int y) {
		Random generator = new Random();

		if (x < 6 && y < 6) {

			int rand = generator.nextInt(2);

			if (rand == 0) {
				return 'b';
			}
			if (rand == 1) {
				return 'r';
			}

		}
		
		if (x == 6 && y == 5) {
			return 'b';
		}
		
		if (x == 5 && y == 6) {
			return 'r';
		}

		if (x <= 6 && y <= 6) {
			int rand = generator.nextInt(2);

			if (y == 7 && rand == 0) {
				return 'r';
			}

			if (x == 7 && rand == 1) {
				return 'b';
			}

			if (rand == 0) {
				return 'b';
			}

			if (rand == 1) {
				return 'r';
			}
		}

		if (x == 7 && y < 5) {
			return 'b';
		}

		if (x < 5 && y == 7) {
			return 'r';
		}

		return 0;
	}

	public char computerMoves(int x, int y, int i) {

		if (x == 6 && y == 7) {
			return 'r';
		}

		if (x == 6 && y == 6) {
			return 'd';
		}

		if (x == 7 && y == 6) {
			return 'b';
		}

		if (Moves[i] == 'r') {
			if(x == 7) {
				return 'b';
			}
			return 'r';
			
		}
		if (Moves[i] == 'b') {
			if(y == 7) {
				return 'r';
			}
			return 'b';
		}
		if (Moves[i] == 'd') {
			if(x == 7) {
				return 'b';
			}
			if(y == 7) {
				return 'r';
			}
			return 'd';
		}
		return 0;
	}
}
