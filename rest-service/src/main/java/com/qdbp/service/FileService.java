package com.qdbp.service;

import org.springframework.core.io.FileSystemResource;
import com.qdbp.entity.AppDocument;
import com.qdbp.entity.AppPhoto;
import com.qdbp.entity.BinaryContent;


public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);
}
