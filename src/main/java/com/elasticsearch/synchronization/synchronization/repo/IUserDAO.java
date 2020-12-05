package com.elasticsearch.synchronization.synchronization.repo;

import com.elasticsearch.synchronization.synchronization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
