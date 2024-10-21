import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class lab5 extends JFrame {

    // constructor
    public lab5() {
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    public static void main(String[] args) {
        lab5 frame = new lab5();
        Ex5PanelModified panel = new Ex5PanelModified();
        frame.add(panel);
        frame.setVisible(true);
    }
}

class Ex5PanelModified extends JPanel {

    public Ex5PanelModified() {
        setSize(700, 700);
        setLayout(null);
    }

    public void plotPoints(Graphics g, int xCenter, int yCenter, int x, int y) {
        //draw line border
        g.setColor(Color.red);
        g.fillOval(xCenter + x, yCenter + y, 8, 8);
        g.fillOval(xCenter + x, yCenter - y, 8, 8);
        g.fillOval(xCenter - x, yCenter - y, 8, 8);
        g.fillOval(xCenter - x, yCenter + y, 8, 8);
    }

    public void paint(Graphics g) {

        drawMidpointCircle(g, 200, 200, 140); //center 200 200 r 140
    }

    public void drawMidpointCircle(Graphics g, int xCenter, int yCenter, int r) {

        int x = 0;
        int y = r;
        int p = 1 - r;

        plotPoints(g, xCenter, yCenter, x, y);

        while (x <= y) {
            x++;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y = y - 1;
                p = p + 2 * x + 1 - 2 * y;
            }

            plotPoints(g, xCenter, yCenter, x, y);
        }

        drawBresenhamLine(g, xCenter - x, yCenter - y, xCenter + x, yCenter + y);
        drawBresenhamLine(g, xCenter - x, yCenter + y, xCenter + x, yCenter - y);
    }

    public void drawBresenhamLine(Graphics g, int startX, int startY, int endX, int endY) {
        int x, y, dx, dy, p, xInc, yInc;

        dx = Math.abs(endX - startX);
        dy = Math.abs(endY - startY);
        p = 2 * dy - dx;
        x = startX;
        y = startY;

        g.setColor(Color.red);

        xInc = (startX < endX) ? 1 : -1;
        yInc = (startY < endY) ? 1 : -1;

        if (dx > dy) {
            while (x != endX) {
                x += xInc;
                if (p >= 0) {
                    y += yInc;
                    p = p + 2 * dy - 2 * dx;
                } else {
                    p = p + 2 * dy;
                }
                g.fillOval(x, y, 8, 8);
            }
        } else {
            while (y != endY) {
                y += yInc;
                if (p >= 0) {
                    x += xInc;
                    p = p - 2 * dy;
                }
                p = p + 2 * dx;
                g.fillOval(x, y, 8, 8);
            }
        }
    }
}
