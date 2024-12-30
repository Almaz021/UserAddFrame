package ru.itis.fisd;

import ru.itis.fisd.database.DBConnection;
import ru.itis.fisd.listener.ButtonActionListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    public MainWindow() {
        super();

        DBConnection.getInstance();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 200, 460, 300);
        this.setTitle("Add User Window");
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        JLabel label = new JLabel("Add New User");
        label.setBounds(210, 30, 100, 50);
        this.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(145, 60, 50, 50);
        this.add(name);

        JLabel password = new JLabel("Password");
        password.setBounds(125, 110, 100, 50);
        this.add(password);

        JTextField username = new JTextField(15);
        username.setBounds(195, 70, 110, 30);
        this.add(username);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(195, 120, 110, 30);
        this.add(passwordField);

        JButton addUser = new JButton("Add User");
        addUser.setBounds(240, 160, 100, 25);
        addUser.addActionListener(new ButtonActionListener(username, passwordField));
        this.add(addUser);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(120, 160, 100, 25);
        cancel.addActionListener(new ButtonActionListener(username, passwordField));
        this.add(cancel);

        JButton info = new JButton("Info");
        info.setBounds(180, 200, 100, 25);
        info.addActionListener(new ButtonActionListener());
        this.add(info);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DBConnection.getInstance().destroy();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
