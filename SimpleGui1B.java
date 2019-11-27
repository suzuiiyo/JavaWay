import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

public class SimpleGui1B implements ActionListener{
    JFrame frame = new JFrame();
    JButton button = new JButton("按E可赛艇！");
    public static void main(String[] args){
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
        MyDrawPanel panel = new MyDrawPanel();
        Graphics picture;
        picture = panel.getGraphics();
        panel.paintComponent(picture);
    }
    public void go(){
        //JFrame frame = new JFrame();
        //JButton button = new JButton();

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        //JButton button = new JButton();
        button.setText("亦可赛艇！");
    }
}

class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        Image image = new ImageIcon("catzilla.jpg").getImage();
        g.drawImage(image, 3, 4, this);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int)(Math.random() * 255);
        int green = (int)(Math.random() * 255);
        int blue = (int)(Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }
}