package com.example.JPAStudy.repo;

import com.example.JPAStudy.entity.CompleteItemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteItemConfigRepository  extends JpaRepository<CompleteItemConfig, Long> {
}
