package hutubill.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Image;

public class ReportPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel jl = new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        Image I = ChartUtil.getImage(400, 300);
        ImageIcon icon = new ImageIcon(I);
        //°ÑiconÌí¼Óµ½JLabel
        jl.setIcon(icon);
        this.add(jl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
}