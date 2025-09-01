package com.nt.service;

import java.util.List;

import com.nt.javaBean.ActorVO;

public interface IActorService {
	
	public String registerActor(ActorVO actor) throws Exception;
	
	public String RegisterAllActor(List<ActorVO> actor) throws Exception;
	
	public Iterable<ActorVO> showAllActor() throws Exception;
	
	public ActorVO getActorById(int id) throws Exception;
	
	public Iterable<ActorVO> showActorByRenge(double start, double end) throws Exception;
	
	public String modifyActor(ActorVO vo) throws Exception;
	
	public String removeActorById(int id) throws Exception;

}
