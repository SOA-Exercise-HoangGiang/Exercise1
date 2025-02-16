package com.hoanggiang.todoapi.repository;

import com.hoanggiang.todoapi.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {
    List<Todo> findByComplete(boolean complete);
    boolean existsByName(String name);
}
