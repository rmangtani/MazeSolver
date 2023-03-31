/**
 * Solves the given maze using DFS or BFS
 * @author Ms. Namasivayam
 * @version 03/10/2023
 */

import java.util.ArrayList;
import java.util.Stack;

public class MazeSolver {
    private Maze maze;

    public MazeSolver() {
        this.maze = null;
    }

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Starting from the end cell, backtracks through
     * the parents to determine the solution
     * @return An arraylist of MazeCells to visit in order
     */
    public ArrayList<MazeCell> getSolution() {
        // TODO: Get the solution from the maze
        // Should be from start to end cells
        ArrayList<MazeCell> solution = new ArrayList<MazeCell>();
        MazeCell currentCell = maze.getEndCell();
        solution.add(currentCell);
        while (currentCell != maze.getStartCell()) {
            solution.add(currentCell.getParent());
            currentCell = currentCell.getParent();
        }
        Stack<MazeCell> inOrder = new Stack<MazeCell>();
        while (!solution.isEmpty()) {
            inOrder.push(solution.remove(0));
        }
        while (!inOrder.isEmpty()) {
            solution.add(inOrder.pop());
        }
        return solution;
    }

    /**
     * Performs a Depth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeDFS() {
        // TODO: Use DFS to solve the maze
        Stack<MazeCell> cellsToVisit = new Stack<MazeCell>();
        MazeCell currentCell = maze.getStartCell();
        while (currentCell!=maze.getEndCell()) {
            // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
            // NORTH
            MazeCell nextCell = null;
            // CALL IS VALID CELL INSTEAD OF THESE TWO IF STATEMENTS
            if (maze.isValidCell(currentCell.getRow()-1, currentCell.getCol())) {
                nextCell = maze.getCell(currentCell.getRow()-1, currentCell.getCol());
                nextCell.setParent(currentCell);
                cellsToVisit.add(nextCell);
                nextCell.setExplored(true);
            }
            // EAST
            if (maze.isValidCell(currentCell.getRow(), currentCell.getCol()+1)) {
                nextCell = maze.getCell(currentCell.getRow(), currentCell.getCol()+1);
                nextCell.setParent(currentCell);
                cellsToVisit.add(nextCell);
                nextCell.setExplored(true);
            }
            // SOUTH
            if (maze.isValidCell(currentCell.getRow() + 1, currentCell.getCol())) {
                nextCell = maze.getCell(currentCell.getRow() + 1, currentCell.getCol());
                nextCell.setParent(currentCell);
                cellsToVisit.add(nextCell);
                nextCell.setExplored(true);
            }
            // WEST
            if (maze.isValidCell(currentCell.getRow(), currentCell.getCol()-1)) {
                nextCell = maze.getCell(currentCell.getRow(), currentCell.getCol()-1);
                nextCell.setParent(currentCell);
                cellsToVisit.add(nextCell);
                nextCell.setExplored(true);
            }
        }
        return null;
    }

    /**
     * Performs a Breadth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeBFS() {
        // TODO: Use BFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        return null;
    }

    public static void main(String[] args) {
        // Create the Maze to be solved
        Maze maze = new Maze("Resources/maze3.txt");

        // Create the MazeSolver object and give it the maze
        MazeSolver ms = new MazeSolver();
        ms.setMaze(maze);

        // Solve the maze using DFS and print the solution
        ArrayList<MazeCell> sol = ms.solveMazeDFS();
        maze.printSolution(sol);

        // Reset the maze
        maze.reset();

        // Solve the maze using BFS and print the solution
        sol = ms.solveMazeBFS();
        maze.printSolution(sol);
    }
}
