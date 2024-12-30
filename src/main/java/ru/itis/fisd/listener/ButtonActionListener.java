package ru.itis.fisd.listener;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.fisd.model.UserEntity;
import ru.itis.fisd.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
public class ButtonActionListener implements ActionListener {

    private final UserService userService = new UserService();
    private JTextField username;
    private JPasswordField passwordField;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton button) {
            String text = button.getText();
            switch (text) {
                case "Add User" -> {
                    if (username.getText().isEmpty() || passwordField.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields", "info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
                        UserEntity user = UserEntity
                                .builder()
                                .name(username.getText())
                                .password(bCrypt.encode(Arrays.toString(passwordField.getPassword())))
                                .build();
                        username.setText("");
                        passwordField.setText("");
                        userService.save(user);
                    }
                }
                case "Cancel" -> {
                    username.setText("");
                    passwordField.setText("");
                }
                case "Info" -> JOptionPane.showMessageDialog(
                        null,
                        """
                                Это форма для добавления нового пользователя.
                                Введите имя пользователя и пароль, затем нажмите 'Add User'.
                                Чтобы очистить поля, нажмите Cancel
                                """,
                        "Справка",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
