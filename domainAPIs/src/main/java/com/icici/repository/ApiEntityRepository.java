package com.icici.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entity.ApiEntity;

public interface ApiEntityRepository extends JpaRepository<ApiEntity, Long> {}