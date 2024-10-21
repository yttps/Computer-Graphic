import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ExcelMipointEllipse extends Canvas{

    int xc , yc , rx , ry;
    
    public ExcelMipointEllipse(int xc , int yc , int rx , int ry) {
        this.xc = xc;
        this.yc = yc;
        this.rx = rx;
        this.ry = ry;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ellipse(g, xc, yc, rx, ry);
    }

    void plotQ(Graphics g,int x , int y , int xc , int yc){
        g.drawOval(xc+x, yc+y, 2, 2); //q1
        g.drawOval(xc+x, yc-y, 2, 2); //q2
        g.drawOval(xc-x, yc-y, 2, 2); //q3
        g.drawOval(xc-x, yc+y, 2, 2); //q4
    }

    void ellipse(Graphics g , int xc , int yc , int rx , int ry){

        int rx2 = rx*rx;
        int ry2 = ry*ry;
        int tworx2 = 2*rx2;
        int twory2 = 2*ry2;

        int x = 0;
        int y = ry;
        int px = 0;
        int py = tworx2*ry;
        int p = (int) (ry2-(rx2*ry) + (0.25*rx2));

        g.setColor(Color.RED);
        plotQ(g, x, y, xc, yc);
        //r1
        while(px <= py){
            x++;
            px+=twory2;

            if(p < 0){
                p += twory2*x+ry2;
            }else{
                y--;
                p += twory2 * x + ry2 - tworx2 *y;
                py-= tworx2;
            }
            
            plotQ(g, x, y, xc, yc);
        }

        //r2
        p=(int)(ry2*(x+0.5) * (x+0.5) + rx2 * (y-1) * (y-1) - rx2 * ry2);
        while ( y > 0) {
            y--;
            if(p > 0){ 
                p += rx2 - tworx2 * y;
            }else{
                x++;
                p += rx2-tworx2 * y + twory2 * x;
            }
            // g.drawOval(xc+x, yc+y, 10, 10);
            plotQ(g, x, y, xc, yc);
        }


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        ExcelMipointEllipse e = new ExcelMipointEllipse(100,100,80,100);
        frame.add(e);        
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        




    }
}
