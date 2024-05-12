package com.connect.sql.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connect.sql.store.entity.t302_sales_persons;

public interface t004_lookupRepository extends JpaRepository<t302_sales_persons, Long>
{
}