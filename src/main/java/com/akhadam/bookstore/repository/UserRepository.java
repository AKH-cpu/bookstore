package com.akhadam.bookstore.repository;

import com.akhadam.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
