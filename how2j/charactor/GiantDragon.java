package charactor;

public class GiantDragon {
    //˽�л����췽��ʹ�ø����޷����ⲿͨ��new����ʵ����
    private GiantDragon(){
    }

    //׼��һ�������ԣ�����ָ��һ��ʵ�������󣬵�����ʱָ��null
    private static GiantDragon instance;

    //public static ����������ʵ������
    public static GiantDragon getInstance(){
        //��һ�η��ʵ�ʱ�򣬷���instanceû��ָ���κζ�����ʱʵ����һ������
        if(null==instance){
            instance = new GiantDragon();
        }
        //����instanceָ��ö���
        return instance;
    }
}