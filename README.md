# Sudoku Solver and Generator - SCAN 1st Projects
By Alexane Rose, Etienne Casanova, Ewen Fagon and Tristan Bourvon.

## Generating the Javadoc
    javadoc -link -cp *.java -d doc/

## Usage

### Generates a sudoku.
    java Sudoku generate <size> <difficulty>

### Generates a sudoku and lets the user check his/her solution.
    java Sudoku generate_check <size> <difficulty>

### Generates a sudoku and solves it.
    java Sudoku generate_solve <size> <difficulty>

### Solves a sudoku given by the user.
    java Sudoku solve <size>

### Options
    size: any squared number, preferrably 4 or 9
    difficulty: EASY, MEDIUM, HARD or EXTREME
