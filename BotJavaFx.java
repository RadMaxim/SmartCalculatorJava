import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.reactions.ReactionCount;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BotJavaFx extends TelegramLongPollingBot   {
    public static String state="start";
    public static String login, gmail, password;
    @Override
    public void onUpdateReceived(Update update) {
        //Для обработки сообщений

        String data = update.getMessage().getText().toString();
        String id = update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(id);
        if (data.equals("/start")){
            try {
//                String info = "login "+login+"\n"+"gmail "+gmail+"\n"+"password "+password;

                execute(new SendMessage(id,"Enter your data in format: name,location,age"));
                state = "data";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (state.equals("data")){
            String[] array = dataPerson(data);
            System.out.println(Arrays.toString(array));
            try {
                HelloApplication.createTable(array[0],array[1],array[2],"person.json");
                execute(new SendMessage(id,"This data send success!!!"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//
        }
        if (data.equals("keyboard")){
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(id);// передаем ID
            sendMessage1.setReplyMarkup(getKeyboard()); //прикрепляем к сообщению клавиатуру
            sendMessage1.setText("Keyboard"); // отправляем текст
            try {
                execute(sendMessage1);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String getBotUsername() {
        // для связи телеграмм бота по username
        return "UltraSuperSmart_bot";

    }
    @Override
    public String getBotToken(){
        // для связи телеграмм бота по токену
        return "7146505185:AAFAQ37Vgl-y7Ngok0traoh41fMiIuACd4c";
    }
    public ReplyKeyboardMarkup getKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> list = new ArrayList<>();// строки
        KeyboardRow keyboardRow = new KeyboardRow();// один ряд
        KeyboardButton keyboardButton = new KeyboardButton("Калькулятор");// кнопка
        new Calculator().getCalculator();
        KeyboardButton keyboardButton1 = new KeyboardButton("Погода");
        keyboardRow.add(keyboardButton);
        keyboardRow.add(keyboardButton1);
        list.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(list);
        return replyKeyboardMarkup;

    }
    public static String[] dataPerson(String info){
        return info.split(",");
    }

}
