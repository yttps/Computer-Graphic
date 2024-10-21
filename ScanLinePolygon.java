import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScanLinePolygon extends JFrame {

    // กำหนดสีเริ่มต้นเป็นสีเทา
    public Color currentColor = Color.LIGHT_GRAY; //สีเริ่มต้นคือสีเทา
    private int startX, startY, endX, endY; 

    public ScanLinePolygon() {

        // สร้าง Panel ของ DemoScanLine และเพิ่มเข้าไปใน BorderLayout ตำแหน่ง CENTER
        DemoScanLine panel = new DemoScanLine(currentColor);
        add(panel, BorderLayout.CENTER);

        // สร้างปุ่ม เพื่อเลือกสี และเพิ่ม ActionListener เพื่อเลือกสี
        JButton colorButton = new JButton("Selected Color");
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // เมื่อกดปุ่ม จะแสดงตัวเลือกสีและอัปเดตสีที่เลือกให้กับ Panel ของ DemoScanLine
                currentColor = JColorChooser.
                showDialog(null, "Choose a Color", currentColor);
                panel.setCurrentColor(currentColor); 
            }
        });

        // สร้าง JPanel และเพิ่มปุ่ม "Selected Color" เข้าไป
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorButton);

        // เพิ่ม JPanel ที่มีปุ่มเลือกสีเข้าไปใน BorderLayout ตำแหน่งด้านบน panel
        add(buttonPanel, BorderLayout.NORTH);

        // เมื่อมีการเริ่มคลิกเมาส์บน Panel จะเก็บค่า x , y เริ่มต้นของสี่เหลี่ยม
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX(); 
                startY = e.getY(); 
            }

            // เมื่อปล่อยเมาส์จะเก็บพิกัดสิ้นสุดของสี่เหลี่ยมและวาดรูปสี่เหลี่ยม
            public void mouseReleased(MouseEvent e) {
                endX = e.getX(); 
                endY = e.getY(); 
                panel.drawRectangle(startX, startY, endX, endY); 
            }
        });

        // เมื่อมีการลากเมาส์ จะเก็บพิกัดสุดท้ายของสี่เหลี่ยมและวาดสี่เหลี่ยมใหม่
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endX = e.getX(); 
                endY = e.getY(); 
                panel.drawRectangle(startX, startY, endX, endY); 
            }
        });
    }

    public static void main(String[] args) {
        ScanLinePolygon f = new ScanLinePolygon();
        f.setSize(750, 750);
        f.setVisible(true);
    }
}

class DemoScanLine extends JPanel {
    
    // กำหนดขนาดของพื้นที่การวาด
    int num = 750;
    int LE[] = new int[num];
    int RE[] = new int[num];

    private Color currentColor;

    public DemoScanLine(Color color) {
        this.currentColor = color;
        setSize(750, 750);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fill(g); // เรียกเมท็อด fill เพื่อเติมสีให้กับรูปภาพ
    }

    void fill(Graphics g) {
        // เคลียร์ LE และ RE arrays
        for (int i = 0; i < num; i++) {
            LE[i] = num;
            RE[i] = 0;
        }

        g.setColor(currentColor); 

        // วนลูปผ่านทุกบรรทัดและวาดเส้นทแยงบน Panel
        for (int y = 0; y < num; y++) {
            for (int x = LE[y]; x < RE[y]; x++) {
                g.drawLine(x, y, x, y);
            }
        }
    }

    // เมท็อดนี้ใช้ในการอัพเดตสีใหม่
    public void setCurrentColor(Color color) {
        this.currentColor = color;
        repaint(); 
    }

    // เมท็อดนี้ใช้ในการวาดสี่เหลี่ยม
    public void drawRectangle(int startX, int startY, int endX, int endY) {
        Graphics g = getGraphics();
        g.setColor(currentColor);
        int width = Math.abs(endX - startX); 
        int height = Math.abs(endY - startY); 
        int x = Math.min(startX, endX); 
        int y = Math.min(startY, endY); 
        
        // ลบสี่เหลี่ยมก่อนและเติมสีใหม่
        g.clearRect(x, y, width, height);
        g.fillRect(x + 1, y + 1, width - 1, height - 1); 
        
        // วาดเส้นขอบของสี่เหลี่ยม
        g.drawRect(x, y, width, height); 
    }
}
