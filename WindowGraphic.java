import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowGraphic extends JFrame{
    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        WindowGraphic frame = new WindowGraphic();
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Demo Window");
    }

    public WindowGraphic(){
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

}

class DrawPanel extends JPanel{
    
    int w = 800 , h = 800;
    
    public DrawPanel(){
        setSize(w, h);
        setLayout(null);
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        float pi = (float)Math.PI;

        // for(int x = 0 ; x < h - 100 ; x++){
        //     for(int y = 0 ; y < w - 100 ; y++){
        //         g.drawOval(x, y, 2, 2);
        //     }
        // }
        // g.translate(100, -100);
        // for(int x = 200 ; x < 500 ; x++){
        //     for(int y = 200 ; y < x ; y++){
        //         g.drawOval(x, y, 2, 2);
        //     }
        // }
        
        // เพิ่มค่าพายการวาดจะกว้างออกเรื่อยๆ
        int x , y;
        g.translate(100, 170); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 2 * pi ; a+=0.01 ){
            float r = - (float) (2 + 4 * (Math.sin(a))) * 15; //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.red);
        }

        g.translate(150, -5); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 2 * pi ; a+=0.01 ){
            float r = (float) (2 * Math.sin(3*a) * 30); //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.yellow);
        }

        g.translate(200, -5); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 2 * 2 * pi ; a+=0.01 ){
            float r = (float) (Math.cos((a * 3) / 2) * 50); //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.blue);
        }

        g.translate(-350, 150); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 2 * pi ; a+=0.01 ){
            float r = (float) (3 + Math.cos(2 * a) * 50); //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.black);
        }

        g.translate(150, 0); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 4 * pi ; a+=0.01 ){
            float r = (float) (3 * Math.cos(5*a) * 20); //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.orange);
        }

        g.translate(200, 0); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        for(float a = 0 ; a < 2 * 2 * pi ; a+=0.01 ){
            float r = (float) (Math.sin(a/2)* 50); //รัศมีความกว้างของวงกลม
            x = (int)(r * Math.cos(a));
            y = (int)(r * Math.sin(a));
            g.drawOval(x, y, 2, 2);
            g.setColor(Color.GREEN);
        }
        

        // g.setColor(Color.blue);
        // g.translate(300, 0); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        // for(float a = 0 ; a < 2 * pi ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //เต็มวง
        // }

        // g.setColor(Color.black);
        // g.translate(-300, 250); //คือการเคลื่อนแกน x y มาอยู่กลางจอ
        // for(float a = 0 ; a < 2 * pi ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //เต็มวง
        // }

        // for(float a = 3 ; a < 2 * pi ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //ครึ่งวงกลมบน
        // }

        // for(float a = 0 ; a < pi ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //ครึ่งวงกลมล่าง
        // }

        // for(double a = 1.6 ; a < pi + 1.5 ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //ครึ่งวงกลมซ้าย
        // }

        // for(double a = pi/2 ; a < 3 * pi / 2 ; a+=0.0001 ){
        //     float r = 100; //รัศมีความกว้างของวงกลม
        //     x = (int)(r * Math.cos(a));
        //     y = (int)(r * Math.sin(a));
        //     g.drawOval(x, y, 2, 2);
        //     //ครึ่งวงกลมขวา
        // }
    }
}