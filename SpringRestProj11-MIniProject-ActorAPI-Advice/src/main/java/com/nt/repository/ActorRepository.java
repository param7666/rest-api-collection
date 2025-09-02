package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.Entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
	
	@Query("from Actor where fees>=:start and fees<=:end")
	public Iterable<Actor> findActorByFeesRenge(double start, double end);

}
