package com.qdbp.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import com.qdbp.entity.AppDocument;
import com.qdbp.entity.AppPhoto;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
}
