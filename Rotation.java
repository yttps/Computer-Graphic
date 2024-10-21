import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Rotation extends Canvas {


    int x1 , y1 , x2 , y2 , x3 , y3;
    double val = Math.PI/180.00;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Rotation e = new Rotation();
        frame.add(e);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void paint(Graphics g) {
      drawTri(g);
      g.translate(400, 400);
      ratateTri(g);
    }

    void drawTri(Graphics g){

        //rotation 180
        x1 = 100;
        y1 = 200;
        x2=200;
        y2=200;
        x3=200;
        y3=50; 
        g.setColor(Color.GREEN);
        ddaLine(g, x1, y1, x2, y2);
        ddaLine(g, x1, y1, x3, y3);
        ddaLine(g, x2, y2, x3, y3);
    }

    void ratateTri(Graphics g){
        int x1new , y1new , x2new , y2new , x3new , y3new;
        g.setColor(Color.ORANGE);
        int sita = 90;

        x1new = rotatewiseClockX(sita ,x1 ,y1);
        y1new = rotatewiseClockY(sita ,x1 ,y1);

        x2new = rotatewiseClockX(sita ,x2 ,y2);
        y2new = rotatewiseClockY(sita ,x2 ,y2);

        x3new = rotatewiseClockX(sita ,x3 ,y3);
        y3new = rotatewiseClockY(sita ,x3 ,y3);

        ddaLine(g, x1new, y1new, x2new, y2new);
        ddaLine(g, x1new, y1new, x3new, y3new);
        ddaLine(g, x2new, y2new, x3new, y3new);

    }

    int rotatewiseClockX(double sita , int x , int y){
        return (int)(x*Math.cos(sita*val) -y * Math.sin(sita*val));
    }

    int rotatewiseClockY(double sita , int x , int y){
        return (int)(x * Math.sin(sita*val) + y * Math.cos(sita*val));
    }

    public void ddaLine(Graphics g,int x1,int y1,int x2,int y2) {
        //int x1=20,x2=400,y1=300,y2=150;
        double dx,dy;
        double x,y;
        dx=x2-x1;
        dy=y2-y1;
        double m=dx/dy;
        double step;
        double xinc,yinc;
       
        if(Math.abs(dx)>Math.abs(dy)) step=Math.abs(dx);
        else step=Math.abs(dy);
       
        xinc=(dx/step);
        yinc=(dy/step);
        x=x1;
        y=y1;
       
       
        g.fillOval((int)x,(int)y,2,2);
       
        for(float i=0;i<step;i++) {
            x=x+xinc;
            y=y+yinc;
            g.fillOval((int)x,(int)y,2,2);
        }
       
    }



}
