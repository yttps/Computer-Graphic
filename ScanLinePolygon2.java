import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanLinePolygon2 extends JFrame {

    public Color currentColor = Color.LIGHT_GRAY; //default color 

    public ScanLinePolygon2() {
        DemoScanLine panel = new DemoScanLine(currentColor); 
        add(panel);
        setLayout(null);

        JButton colorButton = new JButton("Choose Color");
        colorButton.setBounds(10, 10, 120, 30);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = JColorChooser.showDialog(null, "Choose a Color", currentColor);
                panel.setCurrentColor(currentColor); // Update currentColor in DemoScanLine
            }
        });
        add(colorButton);
    }

    public static void main(String[] args) {
        ScanLinePolygon f = new ScanLinePolygon();
        f.setSize(750, 750);
        f.setVisible(true);
    }
}

class DemoScanLine extends JPanel {
    int num = 750;
    int LE[] = new int[num];
    int RE[] = new int[num];

    private Color currentColor; 

    public DemoScanLine(Color color) {
        this.currentColor = color; // Initialize currentColor
        setSize(750, 750);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fill(g);
    }

    void fill(Graphics g) {

        int x1 = 50, y1 = 150, x2 = 100, y2 = 150, x3 = 75, y3 = 50;

        // Clear LE and RE arrays
        for (int i = 0; i < num; i++) {
            LE[i] = num;
            RE[i] = 0;
        }

        drawLineAndUpdate(x1, y1, x2, y2);
        drawLineAndUpdate(x2, y2, x3, y3);
        drawLineAndUpdate(x3, y3, x1, y1);

        g.setColor(currentColor); // Set the selected color

        // Fill polygons using scanline algorithm
        for (int y = 0; y < num; y++) {
            for (int x = LE[y]; x < RE[y]; x++) {
                g.drawLine(x, y, x, y);
            }
        }
    }

    void drawLineAndUpdate(int x1, int y1, int x2, int y2) {
        float x, M;
        int t;

        if (y1 > y2) {
            t = x1;
            x1 = x2;
            x2 = t;
            t = y1;
            y1 = y2;
            y2 = t;
        }

        if (y2 - y1 == 0) {
            M = (x2 - x1);
        } else {
            M = (float) (x2 - x1) / (float) (y2 - y1);
        }

        x = x1;
        for (int y = y1; y < y2; y++) {
            if (x < LE[y]) {
                LE[y] = (int) x;
            }
            if (x > RE[y]) {
                RE[y] = (int) x;
            }
            x = x + M;
        }
    }

    // Setter method for updating currentColor
    public void setCurrentColor(Color color) {
        this.currentColor = color;
        repaint(); // Repaint the panel when color is updated
    }
}
