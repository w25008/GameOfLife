import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameControls extends JPanel {
    private LifeGrid lifeGrid;
    private GameBoard board;
    private JButton startButton;
    private JButton stepButton;
    private JButton randomButton;
    private JButton clearButton;
    private Timer timer;

    public GameControls(LifeGrid lifeGrid, GameBoard board) {
        this.lifeGrid = lifeGrid;
        this.board = board;

        createButtons();
        createTimer();
        connectButtonsToActions();
        addButtonsToScreen();
    }

    private void createButtons() {
        startButton = new JButton("Start");
        stepButton = new JButton("Step");
        randomButton = new JButton("Random");
        clearButton = new JButton("Clear");

        setBackground(GameStyle.BACKGROUND);
    }

    private void createTimer() {
        timer = new Timer(GameStyle.SPEED, event -> stepOnce());
    }

    private void connectButtonsToActions() {
        startButton.addActionListener(event -> startOrStop());
        stepButton.addActionListener(event -> stepOnce());
        randomButton.addActionListener(event -> makeRandomGrid());
        clearButton.addActionListener(event -> clearGrid());
    }

    private void addButtonsToScreen() {
        add(startButton);
        add(stepButton);
        add(randomButton);
        add(clearButton);
    }

    private void stepOnce() {
        lifeGrid.next();
        board.draw();
    }

    private void makeRandomGrid() {
        lifeGrid.randomize();
        board.draw();
    }

    private void clearGrid() {
        lifeGrid.clear();
        board.draw();
    }

    private void startOrStop() {
        if (timer.isRunning()) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer() {
        timer.start();
        startButton.setText("Stop");
    }

    private void stopTimer() {
        timer.stop();
        startButton.setText("Start");
    }
}
