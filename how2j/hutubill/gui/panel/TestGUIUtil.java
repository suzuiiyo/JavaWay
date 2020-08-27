package hutubill.gui.panel;

import javax.swing.JPanel;
import javax.swing.JButton;

public class TestGUIUtil {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        p.add(new JButton("按E可赛艇"));
        p.add(new JButton("按F进入坦克"));
        GUIUtil.showPanel(p);
    }
}