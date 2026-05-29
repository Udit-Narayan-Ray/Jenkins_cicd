package com.test.repository;

import com.test.model.DbData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DbJPA extends JpaRepository<DbData, String> {
}
