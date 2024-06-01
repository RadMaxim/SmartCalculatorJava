import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.reactions.ReactionCount;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class  Calculator {
    public ReplyKeyboardMarkup getCalculator() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keys = new ArrayList<>();
        List<CalculatorRow> list = new ArrayList<>();
        CalculatorRow calculatorRow = new CalculatorRow();
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
        KeyboardButton keyboardButton9 = new KeyboardButton("+");
        KeyboardButton keyboardButton10 = new KeyboardButton("-");
        KeyboardButton keyboardButton11 = new KeyboardButton("/");
        KeyboardButton keyboardButton12 = new KeyboardButton("*");
        KeyboardButton keyboardButton13 = new KeyboardButton("=");
        KeyboardButton keyboardButton14 = new KeyboardButton("%");
        KeyboardButton keyboardButton15 = new KeyboardButton("^");
        KeyboardButton keyboardButton16 = new KeyboardButton("");
        keyboardRow0.add(keyboardButton14);
        keyboardRow0.add(keyboardButton15);
        keyboardRow0.add(keyboardButton16);
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
        keys.add(keyboardRow);
        keys.add(keyboardRow1);
        keys.add(keyboardRow2);
        list.add(calculatorRow);
        replyKeyboardMarkup.setKeyboard(keys);
        return replyKeyboardMarkup;
    }
}
