package com.farmer.repository;

import com.farmer.model.FarmerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<FarmerInfo, Long> {

}
