import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10,10,200, 200);
    }
}
