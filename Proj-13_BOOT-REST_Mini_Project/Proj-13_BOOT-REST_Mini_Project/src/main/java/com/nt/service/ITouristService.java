package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface ITouristService {

	public String registerTouristDetails(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer tid)throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist)throws TouristNotFoundException;
	public List<Tourist> findAllTouristsByName(String name);

}
