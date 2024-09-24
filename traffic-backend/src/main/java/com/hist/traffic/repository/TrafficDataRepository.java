package com.hist.traffic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hist.traffic.entity.*;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long>{

}


