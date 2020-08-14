package hutubill.gui.panel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel2 extends JPanel {
    //������
    private double rate;
    //��ʾ�����
    private JComponent c;
    //�Ƿ������flag
    private boolean stretch;

    public CenterPanel2(double rate){
        this(rate, true);
    }

    public CenterPanel2(double rate, boolean streth){
        //������������Զ���ֲ�
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public void repaint(){
        //����������
        if(null != c){
            //�����ĳߴ�
            Dimension containerSize = this.getSize();
            //����ĳߴ�
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
        JButton jb = new JButton("��E����ͧ");
        cp.show(jb);
    }
}