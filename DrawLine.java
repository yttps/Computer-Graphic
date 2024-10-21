import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DrawLine extends JFrame {

    public DrawLine() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Panel panel = new Panel();
        add(panel);

        // Register the panel as a mouse input listener
        panel.addMouseListener(panel);
        panel.addMouseMotionListener(panel);

        setVisible(true);
        setTitle("Draw Line Homework");
    }

    public static void main(String[] args) {
        new DrawLine();
    }
}

class Line {
    
    int x1 , y1 , x2 , y2;

    public Line(int x1 , int y1 , int x2 , int y2){
        
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

class Panel extends JPanel implements MouseInputListener {

    int x1 , y1 , x2 , y2 ;
    List<Line> lines = new ArrayList<>();


    public Panel() {
        setSize(1000, 1000);
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);

        for(Line line : lines){
            breseham(line.x1, line.y1, line.x2, line.y2, g);
        }

        if (x1 != 0 && y1 != 0 && x2 != 0 && y2 != 0) {
            breseham(x1, y1, x2, y2, g);
            System.out.println("x1=" + x1 + "y1=" + y1 + "x2=" + x2 + "y2=" + y2);
        }

    }

    public void breseham(int x1, int y1, int x2, int y2, Graphics g) {
        int x, y, dx, dy, p , incY ;        
        g.setColor(Color.red);
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        if (y1 < y2) {
            incY = 1;
        } else {
            incY = -1;
        }

        p = (2 * dy) - dx;
        x = x1;
        y = y1;

        g.fillRect(x, y, 2, 2);

        while (x <= x2) {
            g.fillRect(x, y, 2, 2);
            x++;
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                y+= incY;
                p = p + 2 * dy - 2 * dx;
            }
            g.fillRect(x, y, 2, 2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x" + e.getX() + "y" + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        lines.add(new Line(x1, y1 , x2 , y2));
        
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse enter events here
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Handle mouse exit events here
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Update the line coordinates during mouse drag
        x2 = e.getX();
        y2 = e.getY();
        x1 = x2;
        y1 = y2;
        lines.add(new Line(x1, y1, x2, y2));
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Handle mouse move events here
    }
}
