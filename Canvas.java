import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {

    public Canvas(){

    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(70,50,600,600);
        //Drawing the grid lines
        int gapx = 70;
        int gapy = 50;
        for(int i = 0; i < 9; i++){
            g.setColor(Color.BLACK);
            g.drawLine(gapx,gapy,gapx,650);
            gapx+=75;
        }
        gapx = 70;
        for(int i = 0; i<9;i++){
            g.setColor(Color.BLACK);
            g.drawLine(gapx,gapy,670,gapy);
            gapy+=75;
        }
        gapy = 50;
        //Drawing the pieces
        g.setColor(Color.WHITE);
        g.fillOval(gapx+230,gapy+230,60,60);
        g.fillOval(gapx+305,gapy+305,60,60);
        g.setColor(Color.BLACK);
        g.fillOval(gapx+305,gapy+230,60,60);
        g.fillOval(gapx+230,gapy+305,60,60);
    }
    public static void main(String[] args){
        Canvas c = new Canvas();
        JFrame frame = new JFrame("Rversi");
        frame.add(c);
        frame.setSize(700,850);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

