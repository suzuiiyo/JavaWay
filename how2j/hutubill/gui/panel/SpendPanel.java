package hutubill.gui.panel;

import javax.swing.JLabel;

public class SpendPanel {
    //����һ����̬ʵ��ָ��SpendPanel����
    //������˵��Ӧ��˽�л�������ָ��ʵ��������
    //Ȼ���ṩһ��public���������ظ�������,�Ӷ��ﵽ��ȡ�����Ŀ��
    //�������������ֵ���ģʽ
    public static SpendPanel instance = new SpendPanel();

    JLabel lMonthSpend = new JLabel("��������");
    JLabel lToday = new JLabel("��������");
    JLabel lAvgSpendPerDay = new JLabel("�վ�����");
    JLabel lMonthLeft = new JLabel("����ʣ��");
    JLabel lDayAvgAvailable = new JLabel("�վ�����");
    JLabel lMonthLeftDay = new JLabel("������ĩ");

    JLabel vMonthSpend = new JLabel("��������");
    JLabel vToday = new JLabel("��������");
    JLabel vAvgSpendPerDay = new JLabel("�վ�����");
    JLabel vMonthLeft = new JLabel("����ʣ��");
    JLabel vDayAvgAvailable = new JLabel("�վ�����");
    JLabel vMonthLeftDay = new JLabel("������ĩ");

    //˽�л����췽��
    private SpendPanel(){
    }
}