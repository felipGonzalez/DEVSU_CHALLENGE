package com.devsu.customerservice.infrastructure.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPersonRepository extends JpaRepository<PersonEntity,Long>, JpaSpecificationExecutor<PersonEntity> {
}
