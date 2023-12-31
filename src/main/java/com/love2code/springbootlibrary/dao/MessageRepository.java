package com.love2code.springbootlibrary.dao;

import com.love2code.springbootlibrary.entitiy.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByUserEmail(@RequestParam("user_email") String userEmail, Pageable pageable);
    Page<Message> findByClosed(boolean closed, Pageable pageable);
    List<Message> findByClosedFalse();
}
