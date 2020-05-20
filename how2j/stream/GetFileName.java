package stream;

import java.io.File;

public class GetFileName {                       //不要重复造轮子,直接用File.list()方法可以返回目录下的所有文件名
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
        File[] farr = f.listFiles();                           //获取目录下的所有文件，存入File[]

        String[] namePath = new String[farr.length];           //定义一个字符串数组存文件的绝对路径 
        //String[] nameRsv = new String[farr.length];
        String[] nameFile = new String[farr.length];            //定义一个字符串数组存文件名
        for(int i=0; i<farr.length; i++){
            namePath[i] = String.valueOf(farr[i]);               //将目录下每个文件的绝对路径存到String数组中
            char[] namePathCh = namePath[i].toCharArray();
            nameFile[i] = pathChToFileName(namePathCh);          //对每一个文件的绝对路径字符串截取文件名
        }
        return nameFile;
    }

    public String pathChToFileName(char[] ch){              //从绝对路径中获取文件名
        String nameFile = null;
        String strRsv = reserve(String.valueOf(ch));    //将传入的路径字符串反转后找第一个\号
        char[] chRsv = strRsv.toCharArray();            //将反转后的字符串转换为char[]
        for(int j=0; j<chRsv.length; j++){           
            if(chRsv[j] == '\\'){                       //如果监测到\符(找到第一个就终止循环)
                char[] nameFileCh = new char[j];        //新建一个ch[]用来保存，截取下来的文件名
                //System.out.println(nameFileCh[j] + " ");
                for(int k = 0; k<j; k++){               //当k=0时，nameFileCh[k]为ch[]的最后一个元素
                    nameFileCh[k] = chRsv[k];                        
                    //System.out.println(nameFileCh[k] + " ");        
                    nameFile = reserve(String.valueOf(nameFileCh));     //因为是反着取得字符，所以要将反回来
                }
                break;
            }
        }
        return nameFile;
    }
}