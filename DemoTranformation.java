import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DemoTranformation extends JFrame {

    public DemoTranformation() {

    }

    public static void main(String[] args) {
        DrawImage panel = new DrawImage();
        DemoTranformation frame = new DemoTranformation();
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.add(panel);
        Color c = new Color(255, 255, 255);
        frame.getContentPane().setBackground(c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class DrawImage extends JPanel implements ActionListener {
    int ev = 0;

    JButton btscale, btreflec, btshear, btclear;
    int x1, y1, x2, y2, x3, y3;
    int x1new, x2new, x3new, y1new, y2new, y3new;
    boolean drawing;
    int xDrag, yDrag;
    int sx,sy;
	int ex,ey;
	int tx,ty;
    int click=0;

    public DrawImage() {

        setSize(750, 750);
        setLayout(null);
        setBackground(Color.WHITE);

        JToolBar toolBar = new JToolBar();
        btscale = new JButton("Scale");
        btreflec = new JButton("Reflect");
        btshear = new JButton("Shearing");
        btclear = new JButton("Clear");

        toolBar.add(btscale);
        toolBar.add(btreflec);
        toolBar.add(btshear);
        toolBar.add(btclear);
        toolBar.setBounds(0, 0, 750, 40);
        add(toolBar);

        btscale.addActionListener(this);
        btreflec.addActionListener(this);
        btshear.addActionListener(this);
        btclear.addActionListener(this);

        // Add mouse listeners
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    @Override
    public void paint(Graphics g) {
        
        super.paint(g);

        g.setColor(Color.BLACK);
        drawTri(g);

        if (ev == 1) {
            g.setColor(Color.BLUE);
            scaling(g);
        } else if (ev == 2) {
            g.setColor(Color.GREEN);
            reflection(g);
        } else if (ev == 3) {
            g.setColor(Color.PINK);
            shearing(g);
        }
        else if(ev == 4){
            g.translate(250, 200);
			drawTri(g);
			g.setColor(Color.red);
			reflection(g);
        }
        else if(ev == 5){
            repaint();
        }
    }

    void drawTri(Graphics g) {

        x1=100;y1=250;x2=200;y2=250;x3=200;y3=100;

        ddaline(x1, y1, x2, y2, g); // 1
        ddaline(x1, y1, x3, y3, g); // 2
        ddaline(x2, y2, x3, y3, g); // 3

        repaint();
    }

    void Translation(Graphics g) {
		tx=sx-ex;
		ty=sy-ey;
		x1new=translationX(x1,tx);
		y1new=translationY(y1,ty);
		x2new=translationX(x2,tx);
		y2new=translationY(y2,ty);
		System.out.println(x1new+" "+y1new+" "+x2new+" "+y2new);
		ddaline( x1new, y1new, x2new, y2new , g);//1
		
		x1new=translationX(x1,tx);
		y1new=translationY(y1,ty);
		x3new=translationX(x3,tx);
		y3new=translationY(y3,ty);
		ddaline(x1new, y1new, x3new, y3new , g);//1
		
		x2new=translationX(x2,tx);
		y2new=translationY(y2,ty);
		x3new=translationX(x3,tx);
		y3new=translationY(y3,ty);
		ddaline(x2new, y2new, x3new, y3new , g);//1
	}

    void scaling(Graphics g) {
        int sx = 3, sy = 2;

        x1new = scaleX(x1, sx);
        y1new = scaleY(y1, sy);
        x2new = scaleX(x2, sx);
        y2new = scaleY(y2, sy);
        ddaline(x1new, y1new, x2new, y2new, g); // 1

        x1new = scaleX(x1, sx);
        y1new = scaleY(y1, sy);
        x3new = scaleX(x3, sx);
        y3new = scaleY(y3, sy);
        ddaline(x1new, y1new, x3new, y3new, g); // 2

        x2new = scaleX(x2, sx);
        y2new = scaleY(y2, sy);
        x3new = scaleX(x3, sx);
        y3new = scaleY(y3, sy);
        ddaline(x2new, y2new, x3new, y3new, g); // 3
    }

    void reflection(Graphics g) {

        g.translate(x1 - 100, y2 + 300);

        y1new = reflectX(y1);
        y2new = reflectX(y2);
        ddaline(x1, y1new, x2, y2new, g);

        y1new = reflectX(y1);
        y3new = reflectX(y3);
        ddaline(x1, y1new, x3, y3new, g);

        y2new = reflectX(y2);
        y3new = reflectX(y3);
        ddaline(x2, y2new, x3, y3new, g);

    }

	int translationX(int x,int tx) {
		return x+tx;
	}
	int translationY(int y,int ty) {
		return y+ty;
	}
	int reflectX(int x) {
		return x*-1;
	}
	int scaleX(int x,int sx) {
		return x*sx;
	}
	int scaleY(int y,int sy) {
		return y*sy;
	}
	int shear_X(int x,int sx,int y) {
		return x+sx*y;
	}
	int shear_Y(int y,int sy,int x) {
		return y+sy*x;
	}

    public void shearing(Graphics g) {

        int shx = 2, shy = 1;

        // Shear 1
        int x1sheared = shearX(x1, shx, y1);
        int y1sheared = shearY(y1, shy, x1);
        int x2sheared = shearX(x2, shx, y2);
        int y2sheared = shearY(y2, shy, x2);
        ddaline(x1sheared, y1sheared, x2sheared, y2sheared, g); // 1

        // Shear 2
        int x1sheared2 = shearX(x1, shx, y1);
        int y1sheared2 = shearY(y1, shy, x1);
        int x3sheared = shearX(x3, shx, y3);
        int y3sheared = shearY(y3, shy, x3);
        ddaline(x1sheared2, y1sheared2, x3sheared, y3sheared, g); // 2

        // Shear 3
        int x2sheared2 = shearX(x2, shx, y2);
        int y2sheared2 = shearY(y2, shy, x2);
        int x3sheared2 = shearX(x3, shx, y3);
        int y3sheared2 = shearY(y3, shy, x3);
        ddaline(x2sheared2, y2sheared2, x3sheared2, y3sheared2, g); // 3
    }

    int shearX(int x, int shx, int y) {
        return x + shx * y;
    }

    int shearY(int y, int shy, int x) {
        return y + shy * x;
    }

    public void ddaline(int x1, int y1, int x2, int y2, Graphics g) {
        double dx, dy, x, y, step, xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        xinc = dx / step;
        yinc = dy / step;

        x = x1;
        y = y1;

        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btscale) {
            ev = 1;
            repaint();
        } else if (e.getSource() == btreflec) {
            ev = 2;
            repaint();
        } else if (e.getSource() == btshear) {
            ev = 3;
            repaint();
        } else if (e.getSource() == btclear) {
            ev = 5 ;
            repaint();
        } else {
            System.out.println('e');
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {

            if (click==1) {
                sx=e.getX();
                sy=e.getY();
                ev=4;
                click=0;
                repaint();
            }
            if(e.getX()>=x1 && e.getX()<=x2 && e.getY()>=y3 && e.getY()<=y1) {
                ex=e.getX();
                ey=e.getY();
                click++;
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    private class MyMouseMotionListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {

        }
    }
}
