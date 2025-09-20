package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
import com.nt.repository.ITouristRepo;

@Service
public class TouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristRepo repo;
	@Override
	public String registerTouristDetails(Tourist tourist) {
		
		int idVal=repo.save(tourist).getTid();
		return "Tourist Details Register Succfully With Id::"+idVal;
	}
	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list=repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		
		return repo.findById(tid).orElseThrow(()->new TouristNotFoundException(tid+"Tourist is not found"));
	}
	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		
		Optional<Tourist> optional=repo.findById(tourist.getTid());
		if(optional.isPresent())
		{
			repo.save(tourist);
			return tourist.getTid()+"Tourist is Updated";
		}
		else throw new TouristNotFoundException(tourist.getTid()+"Tourist not found");
	}
	@Override
	public List<Tourist> findAllTouristsByName(String name) {
		//Use repo
		return repo.getTouristByName(name);
	}

}
