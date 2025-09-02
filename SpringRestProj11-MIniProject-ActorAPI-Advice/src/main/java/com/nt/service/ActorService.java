package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Actor;
import com.nt.javaBean.ActorVO;
import com.nt.repository.ActorRepository;

@Service
public class ActorService implements IActorService{

	@Autowired
	private ActorRepository repo;

	@Override
	public String registerActor(ActorVO actor) throws Exception {
		System.out.println("ActorService.registerActor()");
		Actor a=new Actor();
		System.out.println("ActorService.registerActor()-ActorVo Data:: "+actor);
		BeanUtils.copyProperties(actor, a);
		a.setCreatedBy(System.getProperty("user.name"));
		Integer id=repo.save(a).getAid();
		return "Actor saved with id= "+id;
	}

	@Override
	public String RegisterAllActor(List<ActorVO> actor) throws Exception {
		System.out.println("ActorService.RegisterAllActor()");
		// empty list
		List<Actor> aList=new ArrayList<>();
		actor.forEach(vo->{
			// empty object of entity
			Actor ac=new Actor();
			// copied propery of bean class object to entity class object
			BeanUtils.copyProperties(vo, ac);
			ac.setCreatedBy(System.getProperty("user.name"));
			// added to list of entity
			aList.add(ac);
		});
		// saved all objects
		List<Actor> savedObjects=repo.saveAll(aList);
		// get all ides from saved objects
		List<Integer> ids=StreamSupport.stream(savedObjects.spliterator(), false).map(Actor::getAid).collect(Collectors.toList());
		return ids.size()+" no.of records are saved having  id Values:: "+ids;
	}

	@Override
	public Iterable<ActorVO> showAllActor() throws Exception {
		List<Actor> alist=repo.findAll();
		// empty List of Bean class
		List<ActorVO> voActors=new ArrayList<>();
		alist.forEach(a->{
			ActorVO vo=new ActorVO();
			BeanUtils.copyProperties(a, vo);
			voActors.add(vo);
		});
		return voActors;
	}

	@Override
	public ActorVO getActorById(int id) throws Exception {
		System.out.println("ActorService.getActorById()");
		Actor actor= repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		ActorVO vo=new ActorVO();
		BeanUtils.copyProperties(actor, vo);
		return vo;
	}

	@Override
	public Iterable<ActorVO> showActorByRenge(double start, double end) throws Exception {
		System.out.println("ActorService.showActorByRenge()");
		// use repo;
		Iterable<Actor> actorlist=repo.findActorByFeesRenge(start, end);
		List<ActorVO> volist=new ArrayList<>();
		actorlist.forEach((a)->{
			ActorVO vo=new ActorVO();
			BeanUtils.copyProperties(a, vo);
			volist.add(vo);
		});
		return volist;
	}

	@Override
	public String modifyActor(ActorVO vo) throws Exception {
		//  use repo to load the object
		Actor actor=repo.findById(vo.getAid()).orElseThrow(()-> new IllegalArgumentException("Actor not found"));
		BeanUtils.copyProperties(vo, actor);
		actor.setUpdateBy(System.getProperty("user.name"));
		repo.save(actor);
		return vo.getAid()+" updated successfully...";
	}
	
	@Override
	public String removeActorById(int id) {
		System.out.println("ActorService.removeActorById()");
		repo.deleteById(id);
		return id+" deleted ";
	}
	
	
}
