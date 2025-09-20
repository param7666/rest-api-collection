package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
    @Query("from Tourist where tname=:name")
	public List<Tourist> getTouristByName(@Param("name")String name);
}
