package com.qoppa.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.email.models.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
