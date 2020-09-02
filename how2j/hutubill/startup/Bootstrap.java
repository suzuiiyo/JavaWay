package hutubill.startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import hutubill.gui.frame.MainFrame;
import hutubill.gui.panel.MainPanel;
import hutubill.gui.panel.SpendPanel;
import hutubill.util.GUIUtil;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();
        //invokeAndWait  和 invokeAndLater
        SwingUtilities.invokeAndWait(new Runnable(){
			@Override
			public void run() {
				// TODO 启动！
                MainFrame.instance.setVisible(true);
                //MainPanel的实例上的woringkPanel上显示SpendPanel
                //同理也可以显示其他的Panel,比如RecordPanel
                //MainPanel.instance.workingPanel.show(CategoryPanel.instance);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
        });
    }
}