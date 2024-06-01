package com.example.calc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public TextField email;
    @FXML
    public TextField login;
    @FXML
    public TextField password;

    @FXML
    protected void sendDataTelegram() {
        String dataEmail = email.getText();
        String dataLogin = login.getText();
        String dataPassword = password.getText();
        //передача данных в класс бота
        BotJavaFx.gmail = dataEmail;
        BotJavaFx.login = dataLogin;
        BotJavaFx.password = dataPassword;

    }
}