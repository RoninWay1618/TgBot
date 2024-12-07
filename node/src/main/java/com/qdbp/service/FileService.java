package com.qdbp.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import com.qdbp.entity.AppDocument;
import com.qdbp.entity.AppPhoto;
import com.qdbp.service.enums.LinkType;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
    String generateLink(Long docId, LinkType linkType);
}
