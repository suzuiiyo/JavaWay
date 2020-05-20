package stream;

import java.io.File;

public class GetFileName {                       //��Ҫ�ظ�������,ֱ����File.list()�������Է���Ŀ¼�µ������ļ���
    public static void main(String[] args){
        GetFileName demo = new GetFileName();
        String str = "c:";
        String[] fileNameList = demo.getName(str);
        for(String name : fileNameList){
            System.out.println(name);
        }
    }

    public String reserve(String str){
        char[] ch = str.toCharArray();
        for(int i=0; i<str.length()/2; i++){
            char temp = ch[i];
            ch[i] = ch[str.length()-i-1];
            ch[str.length()-i-1] = temp;
        }
        str = String.valueOf(ch);
        return str;
    }

    public String[] getName(String path){
        File f = new File(path);
        File[] farr = f.listFiles();                           //��ȡĿ¼�µ������ļ�������File[]

        String[] namePath = new String[farr.length];           //����һ���ַ���������ļ��ľ���·�� 
        //String[] nameRsv = new String[farr.length];
        String[] nameFile = new String[farr.length];            //����һ���ַ���������ļ���
        for(int i=0; i<farr.length; i++){
            namePath[i] = String.valueOf(farr[i]);               //��Ŀ¼��ÿ���ļ��ľ���·���浽String������
            char[] namePathCh = namePath[i].toCharArray();
            nameFile[i] = pathChToFileName(namePathCh);          //��ÿһ���ļ��ľ���·���ַ�����ȡ�ļ���
        }
        return nameFile;
    }

    public String pathChToFileName(char[] ch){              //�Ӿ���·���л�ȡ�ļ���
        String nameFile = null;
        String strRsv = reserve(String.valueOf(ch));    //�������·���ַ�����ת���ҵ�һ��\��
        char[] chRsv = strRsv.toCharArray();            //����ת����ַ���ת��Ϊchar[]
        for(int j=0; j<chRsv.length; j++){           
            if(chRsv[j] == '\\'){                       //�����⵽\��(�ҵ���һ������ֹѭ��)
                char[] nameFileCh = new char[j];        //�½�һ��ch[]�������棬��ȡ�������ļ���
                //System.out.println(nameFileCh[j] + " ");
                for(int k = 0; k<j; k++){               //��k=0ʱ��nameFileCh[k]Ϊch[]�����һ��Ԫ��
                    nameFileCh[k] = chRsv[k];                        
                    //System.out.println(nameFileCh[k] + " ");        
                    nameFile = reserve(String.valueOf(nameFileCh));     //��Ϊ�Ƿ���ȡ���ַ�������Ҫ��������
                }
                break;
            }
        }
        return nameFile;
    }
}