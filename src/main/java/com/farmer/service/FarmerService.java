package com.farmer.service;

import com.farmer.exception.type.UserNotFoundException;
import com.farmer.model.FarmerInfo;
import com.farmer.repository.FarmerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

  private FarmerRepository farmerRepository;

  public FarmerService(FarmerRepository farmerRepository) {
    this.farmerRepository = farmerRepository;
  }

  public FarmerInfo getFarmerInfo(long id) {
    Optional<FarmerInfo> userOptional = farmerRepository.findById(id);
    if (userOptional.isPresent()) {
      return userOptional.get();
    }
    throw new UserNotFoundException("FarmerInfo not Found for Id : " + id);
  }

  public List<FarmerInfo> getAllFarmerInfo() {
    return farmerRepository.findAll();
  }

  public FarmerInfo saveFarmerInfo(FarmerInfo farmerInfo) {
    return farmerRepository.save(farmerInfo);
  }

  public FarmerInfo updateFarmerInfo(FarmerInfo farmerInfo) {
    return farmerRepository.save(farmerInfo);
  }
}
