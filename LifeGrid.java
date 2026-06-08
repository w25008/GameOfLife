import java.util.Random;

public class LifeGrid {
    private boolean[][] alive;

    public LifeGrid(int size) {
        alive = new boolean[size][size];
    }

    public int size() {
        return alive.length;
    }

    public boolean isAlive(int row, int col) {
        return alive[row][col];
    }

    public void toggle(int row, int col) {
        boolean oldValue = alive[row][col];
        boolean newValue = !oldValue;

        alive[row][col] = newValue;
    }

    public void next() {
        boolean[][] nextGrid = LifeRules.next(alive);
        alive = nextGrid;
    }

    public void randomize() {
        Random random = new Random();

        for (int row = 0; row < size(); row++) {
            for (int col = 0; col < size(); col++) {
                int randomNumber = random.nextInt(4);
                boolean shouldBeAlive = randomNumber == 0;

                alive[row][col] = shouldBeAlive;
            }
        }
    }

    public void clear() {
        int currentSize = size();
        alive = new boolean[currentSize][currentSize];
    }
}
