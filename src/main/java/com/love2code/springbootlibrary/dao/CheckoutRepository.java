package com.love2code.springbootlibrary.dao;

import com.love2code.springbootlibrary.entitiy.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
}
