package hutubill.entity;

public class Category {
    private int id;
    private String name;

    public int recordNumber;

    public int getRecordNumber(){
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber){
        this.recordNumber = recordNumber;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    //�Զ�����toString  ��ʾ�ڡ���һ��"ҳ����
    public String toString(){
        return name;
    }
}