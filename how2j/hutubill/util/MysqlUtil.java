package hutubill.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
    public static void backup(String mysqlPath, String backupfile) throws IOException {
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s -hlocalhost -P%d %s -r \"%s\"";
        String command = String.format(commandFormat, mysqlPath, DBUtil.LoginName, DBUtil.password, DBUtil.port, DBUtil.database, backupfile);
        System.out.println(command);
        Runtime.getRuntime().exec(command);
    }

    public static void recover(String mysqlPath, String recoverfile){
        try{
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s %s ";
            String command = String.format(commandFormat, mysqlPath, DBUtil.LoginName, DBUtil.password, DBUtil.database);
            System.out.println(command);
            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();

            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));

            while((inStr = br.readLine()) != null){
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String mysqlPath = "C:/Program" + " Files/MySQL/MySQL" + " Server" + " 8.0";
        //System.out.println(mysqlPath);

        String file = "D:/Studio/JavaWay/AC/DC/hutubillDemo/hutubill.sql";
        String file2 = "D:/Studio/JavaWay/AC/DC/hutubillDemo/backup.sql";
        //System.out.println(file);
        //backup(mysqlPath, file);
        //restore();
        //recover(mysqlPath, file);
        //recover(file);
        recover(mysqlPath, file);
        //backup(mysqlPath, file2);
    }
}