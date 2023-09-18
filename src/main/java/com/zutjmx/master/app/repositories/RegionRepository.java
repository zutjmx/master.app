package com.zutjmx.master.app.repositories;

import com.zutjmx.master.app.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
