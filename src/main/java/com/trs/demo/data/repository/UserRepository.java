package com.trs.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trs.demo.data.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
