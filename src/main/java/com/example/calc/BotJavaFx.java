package com.example.calc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.reactions.ReactionCount;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.calc.OperandNumbers.*;

public class BotJavaFx extends TelegramLongPollingBot   {
    public static String state="start";
    public static String login, gmail, password;


    @Override
    public void onUpdateReceived(Update update) {
        String id = update.getMessage().getChatId().toString();
        String data = update.getMessage().getText();
        if (data.equals("history")){
            try {
                SendDocument sendDocument = new SendDocument();
                sendDocument.setChatId(id);
                sendDocument.setDocument(new InputFile(new File("history.txt")));
                execute(sendDocument);
                return;
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        if (data.equals("file")){
            try {
                execute(new SendMessage(id,CreateFile.getString()!=null?CreateFile.getString():"empty")) ;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if(state.equals("num2")){
            num2 = Double.parseDouble(data);
            state = "result";

        }
        if (state.equals("operand")){
            operand = data.charAt(0);
            state="num2";
            System.out.println( operand);
        }
        if (state.equals("num1")){
             num1 = Double.parseDouble(data);
//            OperandNumbers.num1 = data.charAt(0);

            state = "operand";

        }
        if (state.equals("Calculator")){
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(id);
            sendMessage.setReplyMarkup(getKeyboards());
            sendMessage.setText("KEYBOARD");
            state = "num1";

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
        if(state.equals("result")){

            try {
                execute(new SendMessage(id,"results: "+ getResult()));
                state = "num1";}
            catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        if (data.equals("/start")){
            try {
                execute(new SendMessage(id,"Calculate is work!!!"));
                state = "data";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (state.equals("data")){
            String[] array = dataPerson(data);
            System.out.println(Arrays.toString(array));
            state = "Calculator";
            try {

                execute(new SendMessage(id,"This data send success!!! Press /keyboard to start calculator and "));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }





        }

    @Override
    public String getBotUsername() {
        // для связи телеграмм бота по username
        return "Les18_1OpenCv_Radchuk_bot";

    }
    @Override
    public String getBotToken(){
        // для связи телеграмм бота по токену
        return "6567440090:AAGC0oKTz-R9jKOxQUDmevEmvKc7r_RT8m0";
    }
//    public ReplyKeyboardMarkup getKeyboard(){
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        List<KeyboardRow> list = new ArrayList<>();// строки
//        KeyboardRow keyboardRow = new KeyboardRow();// один ряд
//        KeyboardButton keyboardButton = new KeyboardButton("Калькулятор");// кнопка
//
//        KeyboardButton keyboardButton1 = new KeyboardButton("Погода");
//        keyboardRow.add(keyboardButton);
//        keyboardRow.add(keyboardButton1);
//        list.add(keyboardRow);
//        replyKeyboardMarkup.setKeyboard(list);
//        return replyKeyboardMarkup;
//
//    }
    public static String[] dataPerson(String info){
        return info.split(",");
    }
    public  ReplyKeyboardMarkup getKeyboards(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keys = new ArrayList<>();


        KeyboardRow keyboardRow0 = new KeyboardRow();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2= new KeyboardRow();



        KeyboardButton keyboardButton = new KeyboardButton("1");// кнопка

        KeyboardButton keyboardButton1 = new KeyboardButton("2");

        KeyboardButton keyboardButton2 = new KeyboardButton("3");

        KeyboardButton keyboardButton3 = new KeyboardButton("4");

        KeyboardButton keyboardButton4 = new KeyboardButton("5");

        KeyboardButton keyboardButton5 = new KeyboardButton("6");

        KeyboardButton keyboardButton6 = new KeyboardButton("7");

        KeyboardButton keyboardButton7 = new KeyboardButton("8");

        KeyboardButton keyboardButton8 = new KeyboardButton("9");

        KeyboardButton keyboardButton17 = new KeyboardButton("0");

        KeyboardButton keyboardButton9 = new KeyboardButton("+");
        KeyboardButton keyboardButton10 = new KeyboardButton("-");

        KeyboardButton keyboardButton11 = new KeyboardButton("/");

        KeyboardButton keyboardButton12 = new KeyboardButton("*");
        KeyboardButton keyboardButton13 = new KeyboardButton("=");
        KeyboardButton keyboardButton14 = new KeyboardButton("%");
        KeyboardButton keyboardButton15 = new KeyboardButton("^");
//        KeyboardButton keyboardButton16 = new KeyboardButton("");
        keyboardRow0.add(keyboardButton14);
        keyboardRow0.add(keyboardButton15);

        keyboardRow.add(keyboardButton);
        keyboardRow.add(keyboardButton1);
        keyboardRow.add(keyboardButton2);
        keyboardRow.add(keyboardButton9);
        keyboardRow.add(keyboardButton10);
        keyboardRow1.add(keyboardButton3);
        keyboardRow1.add(keyboardButton4);
        keyboardRow1.add(keyboardButton5);
        keyboardRow1.add(keyboardButton11);
        keyboardRow1.add(keyboardButton12);
        keyboardRow2.add(keyboardButton6);
        keyboardRow2.add(keyboardButton7);
        keyboardRow2.add(keyboardButton8);
        keyboardRow2.add(keyboardButton13);
        keyboardRow2.add(keyboardButton17);
        keys.add(keyboardRow0);
        keys.add(keyboardRow);
        keys.add(keyboardRow1);
        keys.add(keyboardRow2);

        replyKeyboardMarkup.setKeyboard(keys);
        return  replyKeyboardMarkup;
    }

}
