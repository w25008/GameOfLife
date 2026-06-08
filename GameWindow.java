import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GameWindow {
    private LifeGrid lifeGrid;
    private GameBoard board;
    private GameControls controls;

    public void show() {
        createGameParts();

        JPanel page = createPage();
        JFrame window = createWindow(page);

        window.setVisible(true);
    }

    private void createGameParts() {
        lifeGrid = new LifeGrid(GameStyle.GRID_SIZE);
        board = new GameBoard(lifeGrid);
        controls = new GameControls(lifeGrid, board);
    }

    private JPanel createPage() {
        JPanel page = new JPanel(new BorderLayout());

        page.setBackground(GameStyle.BACKGROUND);
        page.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        page.add(board, BorderLayout.CENTER);
        page.add(controls, BorderLayout.SOUTH);

        return page;
    }

    private JFrame createWindow(JPanel page) {
        JFrame window = new JFrame("Game of Life");

        window.add(page);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return window;
    }
}
