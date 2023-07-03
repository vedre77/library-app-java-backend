package com.love2code.springbootlibrary.dao;

import com.love2code.springbootlibrary.entitiy.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    /*search by title*/
    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    /*search by category*/
    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);

    @Query("SELECT b FROM Book b WHERE b.id IN :book_ids")
    List<Book> findBooksByIds(@Param("book_ids") List<Long> bookId);

}
