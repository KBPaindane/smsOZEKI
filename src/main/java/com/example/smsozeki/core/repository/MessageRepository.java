package com.example.smsozeki.core.repository;

import com.example.smsozeki.core.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
