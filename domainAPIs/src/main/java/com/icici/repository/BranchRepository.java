package com.icici.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {}
