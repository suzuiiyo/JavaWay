package hutubill.gui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class TestGUIUtil {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        p.add(new JButton("��E����ͧ"));
        p.add(new JButton("��F����̹��"));
        GUIUtil.showPanel(p);
    }
}