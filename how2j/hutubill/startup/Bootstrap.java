package hutubill.startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import hutubill.gui.panel.GUIUtil;
import hutubill.gui.frame.MainFrame;
import hutubill.gui.panel.MainPanel;
import hutubill.gui.panel.SpendPanel;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();
        //invokeAndWait  �� invokeAndLater
        SwingUtilities.invokeAndWait(new Runnable(){
			@Override
			public void run() {
				// TODO ������
                MainFrame.instance.setVisible(true);
                //MainPanel��ʵ���ϵ�woringkPanel����ʾSpendPanel
                //ͬ��Ҳ������ʾ������Panel,����RecordPanel
                //MainPanel.instance.workingPanel.show(CategoryPanel.instance);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
        });
    }
}