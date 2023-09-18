package com.zutjmx.master.app;

import com.zutjmx.master.app.entities.Region;
import com.zutjmx.master.app.repositories.RegionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RegionRepository regionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllRegions() {
		Region[] regions = regionRepository.findAll().toArray(new Region[0]);
		for (int i = 0; i < regions.length; i++) {
			System.out.println("regions["+i+"].toString() = " + regions[i].toString());
		}
	}

}
