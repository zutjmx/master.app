package com.zutjmx.master.app.repositories;

import com.zutjmx.master.app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
