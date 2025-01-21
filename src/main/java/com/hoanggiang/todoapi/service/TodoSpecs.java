package com.hoanggiang.todoapi.service;

import com.hoanggiang.todoapi.domain.Todo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class TodoSpecs {
    public static Specification<Todo> nameLike(String name){
        return new Specification<Todo>() {
            @Override
            public Predicate toPredicate(Root<Todo> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                String pattern = "%" + name.toLowerCase() + "%";
                return criteriaBuilder.like(root.get("name"), pattern);
            }
        };
    }
}
