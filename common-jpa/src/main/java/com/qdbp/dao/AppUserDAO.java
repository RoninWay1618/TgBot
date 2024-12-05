package com.qdbp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qdbp.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByTelegramUserId(Long id);
}
