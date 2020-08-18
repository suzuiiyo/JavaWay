package hutubill.gui.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double rate; // 拉伸比例
    private JComponent c;    //显示的组件
    private boolean stretch;   //是否拉伸

    //构造函数
    public CenterPanel(double rate, boolean stretch){
        this.setLayout(null);
        this.rate = rate;
        //是否拉伸
        //不拉伸会导致后面环形进度条不显示
        this.stretch = stretch;
    }

    public CenterPanel(double rate){
        this(rate, true);
    }

    //实现拉伸效果 
    public void repaint(){
        if(null != c){
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();

            //可以拉伸
            if(stretch)
                c.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
            else
                c.setSize(componentSize);

            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        //调用父类repaint()方法
        super.repaint();
    }

    //先移除所有组件  再绘制新组件
    public void show(JComponent p){
        this.c = p;
        Component[] cs = getComponents();
        for(Component c :  cs){
            remove(c);
        }
        add(p);
        this.updateUI();
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        //设置拉伸比和是否拉伸
        CenterPanel cp = new CenterPanel(0.25, true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b = new JButton("按E可赛艇");
        cp.show(b);
    }
}