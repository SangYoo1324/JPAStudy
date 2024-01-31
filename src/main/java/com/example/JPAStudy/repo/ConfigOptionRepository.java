package com.example.JPAStudy.repo;

import com.example.JPAStudy.entity.ConfigOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOptionRepository extends JpaRepository<ConfigOption, Long> {
}
