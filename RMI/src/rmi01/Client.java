package rmi01;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Client {
    MyInterface ss;
    JTextField ta, tb;
    JLabel kq;
    JFrame fr;
    public Client(){
        try {
            ss = (MyInterface)Naming.lookup("//localhost/myObj");
            /**********Phục vụ callback***********************/
            
            /********************************************************/
            fr = new JFrame("Mini Clalc");
            fr.setSize(220, 180);
            fr.setLocationRelativeTo(null);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setLayout(new GridLayout(4, 2));
            fr.add(new JLabel("Nhap a:"));
            ta = new JTextField();
            fr.add(ta);
            fr.add(new JLabel("Nhap b:"));
            tb = new JTextField();
            fr.add(tb);
            fr.add(new JLabel("Ket qua:"));
            kq = new JLabel(".....");
            fr.add(kq);
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 2));
            JButton b1 = new JButton("+");
            JButton b2 = new JButton("-");
            p1.add(b1); 
            p1.add(b2); 
            fr.add(p1);
            JPanel p2 = new JPanel();
            p2.setLayout(new GridLayout(1, 2));
            JButton b3 = new JButton("*");
            JButton b4 = new JButton("/");
            p2.add(b3); 
            p2.add(b4); 
            fr.add(p2);
            b1.addActionListener(new MyListener());
            b2.addActionListener(new MyListener());
            b3.addActionListener(new MyListener());
            b4.addActionListener(new MyListener());
            fr.setVisible(true);
        } catch (Exception ex) {
            System.out.println("Client error: " + ex);
        }
    }
    class MyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            try{
                Double a = Double.parseDouble(ta.getText());
                Double b = Double.parseDouble(tb.getText());
                if(s.equals("+"))
                    kq.setText("" + ss.cong(a, b));
                else
                    if(s.equals("/"))
                        kq.setText("" + ss.chia(a, b));
                    else
                    if(s.equals("-"))
                        kq.setText("" + ss.tru(a, b));
                    else
                        kq.setText("" + ss.nhan(a, b));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Loi dinh dang so", "Title", JOptionPane.ERROR_MESSAGE);
            }
        }        
    }
    public static void main(String[] args) {
        new Client();
    }
}
