package com.qdbp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qdbp.entity.BinaryContent;

public interface BinaryContentDAO extends JpaRepository<BinaryContent, Long> {
}
