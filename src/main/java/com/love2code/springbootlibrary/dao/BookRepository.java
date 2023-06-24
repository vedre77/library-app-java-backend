package com.love2code.springbootlibrary.dao;

import com.love2code.springbootlibrary.entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
