package com.heypli.repo.repository;

import com.heypli.repo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    void findByName(String name);
}
