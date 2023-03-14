package com.tms.kulinar.repository;

import com.tms.kulinar.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<Users,Integer> {
}
