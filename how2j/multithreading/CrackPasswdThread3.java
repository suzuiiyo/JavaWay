package multithreading;

import java.util.List;

public class CrackPasswdThread3 extends Thread{
    private boolean found =false;
    private String password;
    private List<String> passwords;

    public CrackPasswdThread3(String password, List<String> passwords){
        this.password = password;
        this.passwords = passwords;
    }

    public void run(){
        char[] guessPassword = new char[password.length()];
        generatePassword(guessPassword, password);
    }

    public void generatePassword(char[] guessPassword, String password){
        generatePassword(guessPassword, 0, password);
    }

    public void generatePassword(char[] guessPassword, int index, String password){
        if(found)
            return;
        for(short i='0'; i<='z'; i++){
            char c = (char) i;
            if(!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index] =c;
            if(index != guessPassword.length-1){
                generatePassword(guessPassword, index+1, password);
            }else{
                String guess =new String(guessPassword);
                //���ÿ�����ɵ�����,���Ž�������
                passwords.add(guess);
                if(guess.equals(password)){
                    System.out.println("�ҵ���, ������" + guess);
                    found = true;
                    return;
                }
            }
        }
        //System.out.println("�߳��ڼ����������: " + passwords.size());
    }
}