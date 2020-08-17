package hutubill.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class TestCircleProgressBar {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        //面板
        JPanel p = new JPanel();
        //进度条组件
        CircleProgressBar cpb = new CircleProgressBar();
        cpb.setBackgroundColor(ColorUtil.blueColor);
        cpb.setProgress(0);
        //添加按钮
        JButton b = new JButton("点击开抢！");
        //添加组件
        //设定组件布局
        p.setLayout(new BorderLayout());
        p.add(cpb, BorderLayout.CENTER);
        p.add(b, BorderLayout.SOUTH);
        //用写好的showPanel方法启动面板
        //showPanel方法预置了JFrame和CenterPanel
        //CenterPanle的show方法,先移除所有组件然后绘制最新添加的组件,调用了updateUI方法
        //showPanel方法接受单参数默认拉伸0.85倍
        //如果不拉伸会导致环形进度条不显示
        GUIUtil.showPanel(p);

        //给按钮加监听
        b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new SwingWorker(){
					@Override
					protected Object doInBackground() throws Exception {
                        // TODO Auto-generated method stub
                        for(int i=0; i<100; i++){
                            cpb.setProgress(i + 1);
                            cpb.setForegroundColor(ColorUtil.getByPercentage(i + 1));
                            try{
                                Thread.sleep(100);
                            }catch(InterruptedException e1){
                                e1.printStackTrace();
                            }
                        }
						return null;
					}
                }.execute();
            }
        });
    }
}