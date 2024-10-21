import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleDraw extends JFrame {

    public CircleDraw() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    public static void main(String[] args) {

        PanelMidpoint panel = new PanelMidpoint();
        CircleDraw frame = new CircleDraw();
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Circle Draw");
    }
}

class PanelMidpoint extends JPanel {

    int w = 800, h = 800;

    public PanelMidpoint() {
        setSize(w, h);
        setLayout(null);
        setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        super.paint(g);
        midPointCircle(g, 100, 100, 100);
        dda_line1(g, 100, 100, 100, 100);
        dda_line2(g, 100 , 100, 100, 500);

    }

    //4 5 6
    
    void plotQ(Graphics g, int xcenter, int ycenter, int x, int y) {

        g.fillOval(xcenter + x, ycenter + y, 2, 2 );//q1
        g.fillOval(xcenter + y, ycenter + x, 2, 2  );//q2
        // g.fillOval(xcenter + y, ycenter - x, 2, 2 );//q3
        // g.fillOval(xcenter + x, ycenter - y, 2, 2 );//q4


        g.fillOval(xcenter - x, ycenter - y, 2, 2);//q5
        g.fillOval(xcenter - y, ycenter - x, 2, 2);//q6
        g.fillOval(xcenter - y, ycenter + x, 2, 2);//q7
        g.fillOval(xcenter - x, ycenter + y, 2, 2);//q8
    }

    void midPointCircle(Graphics g, int xcenter, int ycenter, int r) {

        int x = 0;
        int y = r;
        int p = 1 - r;
        g.setColor(Color.GREEN);
        // g.fillOval(xcenter + x, ycenter + y, 20, 20);
        plotQ(g, xcenter, ycenter, x, y);
        while (x <= y) {

            x++;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y--;
                p = p + 2 * x + 1 - 2 * y;
            }
            // g.fillOval(xcenter + x, ycenter + y, 20, 20);
            plotQ(g, xcenter, ycenter, x, y);
        }
    }

    void dda_line1(Graphics g , int x1 , int y1 , int x2 , int y2){
        g.setColor(Color.ORANGE);
        
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        float x_inc = dx / (float) steps;
        float y_inc = dy / (float) steps;
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++) {
            g.fillRect((int) x, (int) y, 2, 2); 
            x += x_inc;
            y += y_inc;
        }
    }

    void dda_line2(Graphics g , int x1 , int y1 , int x2 , int y2){
        g.setColor(Color.PINK);
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        float x_inc = dx / (float) steps;
        float y_inc = dy / (float) steps;
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++) {
            g.fillRect((int) x, (int) y, 2, 2); 
            x += x_inc;
            y += y_inc;
        }
    }

}
