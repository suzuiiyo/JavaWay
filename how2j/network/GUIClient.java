package network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        JFrame f = new JFrame();
        f.setTitle("client");

        f.setSize(400, 300);
        f.setLocation(100, 200);
        f.setLayout(null);

        JButton b = new JButton("send");
        b.setBounds(10, 10, 80, 30);
        f.add(b);

        final JTextField tf = new JTextField();
        tf.setBounds(10, 110, 80, 30);
        f.add(tf);

        final JTextArea ta = new JTextArea();
        ta.setBounds(110, 10, 200, 300);
        f.add(ta);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Socket s = new Socket("127.0.0.1", 8888);
        System.out.println("listenning on port:8888");

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                        Scanner sc = new Scanner(System.in);
                        System.out.println("请输入要发送的信息:");
                        String text = sc.nextLine();
                        dos.writeUTF(text);
                        ta.append(text + "\r\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String text = tf.getText();
                ta.append(text + "\r\n");

                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    dis.readUTF();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}