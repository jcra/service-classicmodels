package org.classicmodels.repositories;

import org.classicmodels.model.entities.Offices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Offices, Long>{}
