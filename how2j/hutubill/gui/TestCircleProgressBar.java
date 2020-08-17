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
        //���
        JPanel p = new JPanel();
        //���������
        CircleProgressBar cpb = new CircleProgressBar();
        cpb.setBackgroundColor(ColorUtil.blueColor);
        cpb.setProgress(0);
        //��Ӱ�ť
        JButton b = new JButton("���������");
        //������
        //�趨�������
        p.setLayout(new BorderLayout());
        p.add(cpb, BorderLayout.CENTER);
        p.add(b, BorderLayout.SOUTH);
        //��д�õ�showPanel�����������
        //showPanel����Ԥ����JFrame��CenterPanel
        //CenterPanle��show����,���Ƴ��������Ȼ�����������ӵ����,������updateUI����
        //showPanel�������ܵ�����Ĭ������0.85��
        //���������ᵼ�»��ν���������ʾ
        GUIUtil.showPanel(p);

        //����ť�Ӽ���
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