import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class lab4 extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        lab4 e = new lab4(400, 400, 140, 140);
        frame.add(e);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    int xc, yc, rx, ry;

    // constructor
    public lab4(int xc, int yc, int rx, int ry) {
        this.xc = xc;
        this.yc = yc;
        this.rx = rx;
        this.ry = ry;
    }

    void plotQ(Graphics g, int xcenter, int ycenter, int x, int y) {
        // draw q1 q2
        g.drawOval(xcenter + x, ycenter - y, 8, 8);
        g.drawOval(xcenter - x, ycenter - y, 8, 8);
    }

    public void paint(Graphics g) {
        Drawpanel(g, xc, yc, rx, ry);
    }

    void Drawpanel(Graphics g, int xc, int yc, int rx, int ry) {

        g.setColor(Color.red);
        int rx2 = rx * rx;
        int ry2 = ry * ry;
        int tworx2 = 2 * rx2;
        int twory2 = 2 * ry2;

        int x = 0;
        int y = ry;
        int px = 0;
        int py = tworx2 * y;
        int p = (int) (ry2 - (rx2 * ry) + (0.25 * rx2));

        while (px <= py) {
            x = x + 1;
            px = px + twory2;
            if (p < 0) {
                p = p + twory2 * x + ry2;

            }

            else {

                y = y - 1;
                p += twory2 * x + ry2 - tworx2 * y;
                py -= tworx2;

            }

            // send parameter
            plotQ(g, xc, yc, x, y);
        }

        p = (int) (ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - rx2 * ry2);

        while (y > 0) {

            y = y - 1;
            if (p > 0) {
                p += rx2 - tworx2 * y;
            } else {
                x = x + 1;
                p += rx2 - tworx2 * y + twory2 * x;
            }
            // send parameter
            plotQ(g, xc, yc, x, y);
        }
    }

}
