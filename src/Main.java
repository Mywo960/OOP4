import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    int diameter = 10;
    int direction = 1;

    public Main() {
        Timer timer = new Timer(5, e -> {
            if (diameter + direction < 10 || diameter + direction > getWidth()) {
                direction *= -1;
            }
            diameter += direction;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(getWidth()/2 - diameter/2, getHeight()/2 - diameter/2, diameter, diameter);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
