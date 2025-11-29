package com.icici.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entity.Domain;



public interface DomainRepository extends JpaRepository<Domain, Long> {}
