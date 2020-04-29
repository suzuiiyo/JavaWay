package digit;

public class MyStringBuffer implements IStringButter{
        int capacity = 16;
        int length = 0;
        char[] value;
        public MyStringBuffer(){
            value = new char[capacity];
        }
        public MyStringBuffer(String str){
            this();
            if(null==str)
                return;
            
            if(capacity < str.length()){
                capacity = value.length *2;
                value = new char[capacity];
            }
            
            if(capacity >= str.length())
                System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
            length = str.length();
        }
        public void append(String str){
            insert(length, str);
        }
        public void append(char c){
            append(String.valueOf(c));
        }
        public void insert(int pos, char b){
            insert(pos, String.valueOf(b));
        }
        public void insert(int pos, String b){
            //边界体条件判断
            if(pos<0){
                return;
            }
            if(pos>length){
                return;
            }
            if(null==b){
                return;
            }
            //拓容
            while(length+b.length()>capacity){
                capacity = (int)((length+b.length())*1.5f);
                char[] newValue =new char[capacity];
                System.arraycopy(value, 0, newValue, 0, length);
                value = newValue;
            }

            char[] cs = b.toCharArray();
            //先把已经存在的数据往后移
            System.arraycopy(value, pos, value, pos+cs.length, length-pos);
            //把药插入的数据插入到指定位置
            System.arraycopy(cs, 0, value, pos, cs.length);

            length = length + cs.length;
        }
        public void delete(int start){
            delete(start,  length);
        }
        public void delete(int start, int end){
            //判断边界条件
            if(start<0)
                return;
            if(start>length)            
                return;
            if(end<0)
                return;
            if(end>length)
                return;
            if(start>=end)
                return;

            System.arraycopy(value, end, value, start, length-end);
            length-=end-start;
        }
        public void reverse(){
            for(int i=0; i<length / 2; i++){
                char temp = value[i];
                value[i] = value[length - i -1];
                value[length -i -1] = temp;
            }
        }
        public int length(){
            return length;
        }

        public String toString(){
            char[] realValue = new char[length];
            System.arraycopy(value, 0, realValue, 0, length);
            return new String(realValue);
        }

        public static void main(String[] args){
            MyStringBuffer sb = new MyStringBuffer("there light");
            //sb.reverse();
            System.out.println(sb);
            sb.insert(0, "let");
            System.out.println(sb);

            sb.insert(10, "be");
            System.out.println(sb);
            sb.insert(0, "God say");
            System.out.println(sb);
            sb.append("!");
            System.out.println(sb);
            sb.append("?");
            System.out.println(sb);
            sb.reverse();
            System.out.println(sb);

            String str= "jsdjajsdjfhdgndkskfksajdjslajd";
            MyStringBuffer str2 = new MyStringBuffer(str);
            double t5=System.currentTimeMillis();
            for(int j=0; j<10000; j++)
                str2.append((char)(Math.random()*1000));
            double t6 = System.currentTimeMillis();
            System.out.println(str2);
            System.out.printf("MyStringBuffer耗时: %.2f\n", t6-t5);
        }
		public void append(int i) {
		}
}

