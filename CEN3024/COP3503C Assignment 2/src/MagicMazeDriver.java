/** Dr. Andrew Steinberg
 *  COP3503 Computer Science 2
 *  Programming Assignment 2 Driver
 *  Fall 2022
 */
 


public class MagicMazeDriver 
{   
    public static void main(String args[]) throws Exception
    {
        MagicMaze maze = new MagicMaze("maze2.txt", 15, 11);
           
        if(maze.solveMagicMaze())
			System.out.println("Maze 1" + " passed!");
		else
			System.out.println("Maze 1" + " did not passed!");
    }
}
