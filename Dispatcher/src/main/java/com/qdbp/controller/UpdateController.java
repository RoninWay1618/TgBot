package com.qdbp.controller;


import com.qdbp.service.UpdateProducer;
import com.qdbp.utils.MessageUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


import static com.qdbp.model.RabbitQueue.*;

@Component
@Log4j
public class UpdateController {
    private TelegramBot telegramBot;
    private final MessageUtils messageUtils;
    private final UpdateProducer updateProducer;

    public UpdateController(MessageUtils messageUtils, UpdateProducer updateProducer) {
        this.messageUtils = messageUtils;
        this.updateProducer = updateProducer;
    }

    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void processUpdates(Update update) {
        if(update == null) {
            log.error("Received update is null");
            return;
        }

        if(update.hasMessage()) {
            distributeMessageByType(update);
        } else {
            log.error("Unsupported message type is received" + update);
        }
    }

    private void distributeMessageByType(Update update) {
        var message = update.getMessage();
        if(message.hasText()) {
            processTextMessage(update);
        } else if(message.hasDocument()){
            processDocMessage(update);
        } else if(message.hasPhoto()) {
            processPhotoMessage(update);
        } else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {
        var sender = messageUtils.generateSendMessageWithText(update,
                "Не поддерживаемый тип сообщения!");
        setView(sender);
    }

    private void setFileIsReceivedView(Update update) {
        var sender = messageUtils.generateSendMessageWithText(update,
                "Файл получен! Обрабатывается...");
        setView(sender);
    }

    public void setView(SendMessage sender) {

        telegramBot.sendAnswerMessage(sender);
    }

    private void processPhotoMessage(Update update) {
        updateProducer.produce(PHOTO_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }


    private void processDocMessage(Update update) {
        updateProducer.produce(DOC_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }

    private void processTextMessage(Update update) {

        updateProducer.produce(TEXT_MESSAGE_UPDATE, update);
    }
}
