package collection;

import java.util.HashMap;

public class TestHahMap {
    public static void main(String[] args) {
        HashMap<String, String>dictionary = new HashMap<>();
        dictionary.put("adc", "����Ӣ��");
        dictionary.put("apc", "ħ��Ӣ��");
        dictionary.put("t", "̹��");

        System.out.println(dictionary.get("t"));
    }
}