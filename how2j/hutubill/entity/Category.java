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
    //自动调用toString  显示在“记一笔"页面上
    //TODO  toString方法，在后续JComboBox中显示得时候，会调用此方法,用于显示分类名称
    public String toString(){
        return name;
    }
}