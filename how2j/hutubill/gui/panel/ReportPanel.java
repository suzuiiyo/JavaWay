package hutubill.gui.panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import hutubill.dao.RecordDAO;
import hutubill.entity.Record;
import hutubill.service.ReportService;
import hutubill.util.ChartUtil;
import hutubill.util.GUIUtil;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

public class ReportPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel jl = new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthPerDayRecords();
        Image I = ChartUtil.getImage(rs, 400, 300);
        ImageIcon icon = new ImageIcon(I);
        // 把icon添加到JLabel
        jl.setIcon(icon);
        this.add(jl);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    // 并不需要实时刷新
    @Override
    public void updateData() {
        // TODO Auto-generated method stub
        List<Record> rs = new ReportService().listThisMonthPerDayRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        jl.setIcon(icon);
    }

    @Override
    public void addListener() {
        // TODO Auto-generated method stub

    }
}