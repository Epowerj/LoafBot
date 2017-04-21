package space.homecore.loafbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
      if (update.hasMessage() && update.getMessage().hasText()) {
        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
          .setChatId(update.getMessage().getChatId())
          .setText(update.getMessage().getText());
          try {
            sendMessage(message); // Call method to send the message
          } catch (TelegramApiException e) {
            e.printStackTrace();
        }
      }
    }

    @Override
    public String getBotUsername() {
      return "loafbot";
    }

    @Override
    public String getBotToken() {
      return System.getenv("TGBOT_KEY");
    }
}
