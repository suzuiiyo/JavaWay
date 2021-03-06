import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener{
    JFrame frame;
    public static void main(String[] args){
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("��E��ɫ");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();
        
        //frame.getContentPane().setBackground(Color.white);
        //frame.getContentPane().setVisible(false);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = -6456862179478315168L;

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(50, 50, 100, 100);
        //Image image = new ImageIcon("rainyblue.jpg").getImage();
        //g.drawImage(image, 150, 150, this);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int)(Math.random() * 255);
        int green = (int)(Math.random() * 255);
        int blue = (int)(Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(150, 150, 150, 150);
    }
}