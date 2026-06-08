import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

public class GameBoard extends JPanel {
    private LifeGrid lifeGrid;
    private JButton[][] buttons;

    public GameBoard(LifeGrid lifeGrid) {
        this.lifeGrid = lifeGrid;
        this.buttons = new JButton[lifeGrid.size()][lifeGrid.size()];

        setupBoardLook();
        createAllCellButtons();
        draw();
    }

    private void setupBoardLook() {
        int rows = lifeGrid.size();
        int cols = lifeGrid.size();

        setLayout(new GridLayout(rows, cols, 1, 1));
        setBackground(GameStyle.LINES);
        setPreferredSize(GameStyle.BOARD_SIZE);
    }

    private void createAllCellButtons() {
        for (int row = 0; row < lifeGrid.size(); row++) {
            for (int col = 0; col < lifeGrid.size(); col++) {
                JButton button = createOneCellButton(row, col);

                buttons[row][col] = button;
                add(button);
            }
        }
    }

    private JButton createOneCellButton(int row, int col) {
        JButton button = new JButton();

        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBorderPainted(false);
        button.setOpaque(true);

        button.addActionListener(event -> clickCell(row, col));

        return button;
    }

    private void clickCell(int row, int col) {
        lifeGrid.toggle(row, col);
        draw();
    }

    public void draw() {
        for (int row = 0; row < lifeGrid.size(); row++) {
            for (int col = 0; col < lifeGrid.size(); col++) {
                Color cellColor = getCellColor(row, col);
                buttons[row][col].setBackground(cellColor);
            }
        }
    }

    private Color getCellColor(int row, int col) {
        boolean cellIsAlive = lifeGrid.isAlive(row, col);

        if (cellIsAlive) {
            return GameStyle.ALIVE;
        }

        return GameStyle.DEAD;
    }
}
