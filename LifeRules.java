public class LifeRules {
    public static boolean[][] next(boolean[][] currentGrid) {
        int size = currentGrid.length;
        boolean[][] nextGrid = new boolean[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                nextGrid[row][col] = calculateNextCell(currentGrid, row, col);
            }
        }

        return nextGrid;
    }

    static boolean calculateNextCell(boolean[][] grid, int row, int col) {
        boolean isAliveNow = grid[row][col];
        int neighbors = countAliveNeighbors(grid, row, col);

        // Rule 1: alive cell dies if it has fewer than 2 neighbors.
        if (isAliveNow && neighbors < 2) {
            return false;
        }

        // Rule 2: alive cell stays alive with 2 or 3 neighbors.
        if (isAliveNow && (neighbors == 2 || neighbors == 3)) {
            return true;
        }

        // Rule 3: alive cell dies if it has more than 3 neighbors.
        if (isAliveNow && neighbors > 3) {
            return false;
        }

        // Rule 4: dead cell becomes alive with exactly 3 neighbors.
        if (!isAliveNow && neighbors == 3) {
            return true;
        }

        // If no rule made it alive, it stays dead.
        return false;
    }

    static int countAliveNeighbors(boolean[][] grid, int row, int col) {
        int topLeft = getCellValue(grid, row - 1, col - 1);
        int top = getCellValue(grid, row - 1, col);
        int topRight = getCellValue(grid, row - 1, col + 1);

        int left = getCellValue(grid, row, col - 1);
        int right = getCellValue(grid, row, col + 1);

        int bottomLeft = getCellValue(grid, row + 1, col - 1);
        int bottom = getCellValue(grid, row + 1, col);
        int bottomRight = getCellValue(grid, row + 1, col + 1);

        int total = 0;
        total = total + topLeft;
        total = total + top;
        total = total + topRight;
        total = total + left;
        total = total + right;
        total = total + bottomLeft;
        total = total + bottom;
        total = total + bottomRight;

        return total;
    }

    static int getCellValue(boolean[][] grid, int row, int col) {
        if (isOutsideGrid(grid, row, col)) {
            return 0;
        }

        if (grid[row][col]) {
            return 1;
        }

        return 0;
    }

    static boolean isOutsideGrid(boolean[][] grid, int row, int col) {
        int size = grid.length;

        if (row < 0) {
            return true;
        }

        if (row >= size) {
            return true;
        }

        if (col < 0) {
            return true;
        }

        if (col >= size) {
            return true;
        }

        return false;
    }
}
