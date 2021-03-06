package ChatServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
public class test {

	public static void main(String[] args) {
        int TA_ROWS = 10;
        int TA_COLS = 60;
        JTextArea talkArea = new JTextArea(TA_ROWS, TA_COLS);
        JFrame f = new JFrame("Main");
        JScrollPane talkPane = new JScrollPane(talkArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel jPanel = new JPanel();
        int gap = 10;
        jPanel.setLayout(new BorderLayout(gap, gap));
        jPanel.add(talkPane, BorderLayout.CENTER);
        f.getContentPane().add(jPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
