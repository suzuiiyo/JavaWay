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
    private double rate; // �������
    private JComponent c;    //��ʾ�����
    private boolean stretch;   //�Ƿ�����

    //���캯��
    public CenterPanel(double rate, boolean stretch){
        this.setLayout(null);
        this.rate = rate;
        //�Ƿ�����
        //������ᵼ�º��滷�ν���������ʾ
        this.stretch = stretch;
    }

    public CenterPanel(double rate){
        this(rate, true);
    }

    //ʵ������Ч�� 
    public void repaint(){
        if(null != c){
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();

            //��������
            if(stretch)
                c.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
            else
                c.setSize(componentSize);

            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        //���ø���repaint()����
        super.repaint();
    }

    //���Ƴ��������  �ٻ��������
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
        //��������Ⱥ��Ƿ�����
        CenterPanel cp = new CenterPanel(0.25, true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b = new JButton("��E����ͧ");
        cp.show(b);
    }
}