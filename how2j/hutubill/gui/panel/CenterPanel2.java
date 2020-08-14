package hutubill.gui.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel2 extends JPanel {
    //拉伸率
    private double rate;
    //显示的组件
    private JComponent c;
    //是否拉伸的flag
    private boolean stretch;

    public CenterPanel2(double rate){
        this(rate, true);
    }

    public CenterPanel2(double rate, boolean streth){
        //让所有组件都自定义分布
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public void repaint(){
        //如果存在组件
        if(null != c){
            //容器的尺寸
            Dimension containerSize = this.getSize();
            //组件的尺寸
            Dimension componentSize = c.getPreferredSize();

            if(stretch){
                c.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
            }
            else{
                c.setSize(componentSize);
            }

            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p){
        this.c = p;
        Component[] cs = getComponents();
        for(Component c : cs){
            remove(c);
        }
        add(p);
        this.updateUI();
    }

    public static void main(String[] args){
        JFrame jf = new JFrame();
        jf.setSize(200, 200);
        jf.setLocationRelativeTo(null);

        CenterPanel2 cp = new CenterPanel2(0.85, true);
        jf.setContentPane(cp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        JButton jb = new JButton("按E可赛艇");
        cp.show(jb);
    }
}