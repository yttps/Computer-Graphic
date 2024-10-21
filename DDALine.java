import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DDALine extends JFrame {

    public DDALine() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    public static void main(String[] args) {

        DrawWindow panel = new DrawWindow();
        DDALine frame = new DDALine();
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("DDA Line Graphic");
    }

}

class DrawWindow extends JPanel {

    int w = 800, h = 800;

    public DrawWindow() {
        setSize(w, h);
        setLayout(null);
        // setBackground(Color.GREEN);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        super.paint(g);
        
        // สามเหลี่ยม
        // ddaline(100, 30, 170, 70, g);
        // ddaline2(100, 50, 150, 50, g);
        // ddaline3(100, 10 , 150 , 10 , g);
        // สี่เหลี่ยม
        // ddaline4(10, 50 , 10, 100, g);
        // ddaline5(x2 - 380, y2 + 160, x2 - 380, y2 + 350, g);
        // ddaline6(x2 - 200, y2 + 350, x1 + 180, y1 + 10, g);
        // ddaline7(x1, y1 + 200, x2 - 200, y2 + 350, g);
        // วงกลม
        // ddaline8_circle(50 , g);

        breseham( 6, 2,8 , 4, g);
    }

    public void ddaline(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline2(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline3(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline4(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline5(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline6(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline7(int x1, int y1, int x2, int y2, Graphics g) {

        double dx, dy, x, y, step, m, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    public void ddaline8_circle(int r , Graphics g) {

        float x1, y1, x2, y2, x, y, k;
        int i = 0 , val;

        x1 = r * (float) Math.cos(0);
        y1 = r * (float) Math.sin(0);
        
        x = x1;
        y = y1;

        do {
            val = (int) Math.pow(2, i);
            i++;
        } while (val < r);

        k = 1 / (float) Math.pow(2, i - 1);

        do {
            x2 = x1 + y1 * k;
            y2 = y1 - k * x2;
            g.setColor(Color.BLUE);
            g.drawLine(600 + (int)x, 600 + (int) y, 600 + (int) x2, 600 + (int) y2);
            x1 = x2;
            y1 = y2;
        } while ((y1 - y) < k || (x - x1) > k);
    }

    public void breseham(int x1, int y1, int x2, int y2, Graphics g) {

        int x, y, dx, dy, p;
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        p = (2 * dy) - dx;
        x = x1;
        y = y1;
        g.setColor(Color.red);
        g.fillRect(x, y, 2, 2);

        while (x <= x2) {

            x++;

            if (p < 0) {
                p = p + 2 * dy;
            } else {
                y++;
                p = p + 2 * dy - 2 * dx;
            }

            g.fillRect(x, y, 2, 2);
        }

    }

}