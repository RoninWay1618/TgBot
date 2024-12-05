package com.qdbp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qdbp.entity.AppDocument;

public interface AppDocumentDAO extends JpaRepository<AppDocument, Long>{
}
