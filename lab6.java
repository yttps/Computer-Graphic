import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class lab6 extends Canvas {

    int x1, y1, x2, y2, x3, y3;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        lab6 e = new lab6(200, 100, 350, 300, 50, 300);
        frame.add(e);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // constructor
    public lab6(int x1, int y1, int x2, int y2, int x3, int y3) {
        
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public void paint(Graphics g) {
        drawEquilateralTriangle(g, x1, y1, x2, y2, x3, y3);
    }

    void drawEquilateralTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {

        drawLine(g, x3, y3, x1, y1);
        drawLine(g, x1, y1, x2, y2);
        drawLine(g, x2, y2, x3, y3);

        drawCircle(g, x1, y1, 10);
        drawCircle(g, x2, y2, 10);
        drawCircle(g, x3, y3, 10);

        drawCircle(g, x1, y1, 20);
        drawCircle(g, x2, y2, 20);
        drawCircle(g, x3, y3, 20);

        drawCircle(g, x1, y1, 30);
        drawCircle(g, x2, y2, 30);
        drawCircle(g, x3, y3, 30);

        drawCircle(g, x1, y1, 40);
        drawCircle(g, x2, y2, 40);
        drawCircle(g, x3, y3, 40);

        drawCircle(g, x1, y1, 50);
        drawCircle(g, x2, y2, 50);
        drawCircle(g, x3, y3, 50);

    }

    void drawCircle(Graphics g, int x, int y, int radius) {
        g.setColor(Color.GREEN);

        int centerX = x - radius;
        int centerY = y - radius;

        g.drawOval(centerX, centerY, radius * 2, radius * 2);
    }

    void drawLargeCircleAtLineEnd(Graphics g, int x1, int y1, int x2, int y2, int radius) {
        g.setColor(Color.GREEN);
        int dx = x2 - x1;
        int dy = y2 - y1;
        double length = Math.sqrt(dx * dx + dy * dy);

        int centerX = (int) (x1 + (dx / length) * radius);
        int centerY = (int) (y1 + (dy / length) * radius);

        g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    // Bresenham Algor
    void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(Color.GREEN);
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true) {

            g.drawOval(x1, y1, 2, 2);

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

}
