package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
	    JFrame window = new JFrame("Menu");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window.setBounds(dimension.width/2 - 300, dimension.height/2 - 300, 700, 500);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);
        JLabel text = new JLabel("Interface for Arduino");
        text.setBounds(290,30, 150, 25);
        window.add(text);
        JButton start = new JButton("Start");
        start.setBounds(315,230,70,25);
        JButton doc = new JButton("Отчёт");
        doc.setBounds(315,260,70,25);
        window.add(start);
        window.add(doc);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage("https://www.tinkercad.com/things/krbligoUHrb");
            }
        };
        start.addActionListener(listener1);
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(new File("src/Awesome.docx"));
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        };
        doc.addActionListener(listener2);
    }
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}