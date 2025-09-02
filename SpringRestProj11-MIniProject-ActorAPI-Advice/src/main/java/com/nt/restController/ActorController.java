package com.nt.restController;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.javaBean.ActorVO;
import com.nt.service.IActorService;

@RestController
@RequestMapping("actor-api")
public class ActorController {

	@Autowired
	private IActorService ser;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody ActorVO a) {
		System.out.println("ActorController.registerUser()");
		try {
			String message=ser.registerActor(a);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/register-all")
	public ResponseEntity<String> registerAllActor(@RequestBody List<ActorVO> a) {
		System.out.println("ActorController.registerAllActor()");
		try {
			String message=ser.RegisterAllActor(a);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server Error:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("show-all")
	public ResponseEntity<?> showAllActors(){
		System.out.println("ActorController.showAllActors()");
		try {
			Iterable<ActorVO> list=ser.showAllActor();
			return new ResponseEntity<Iterable<ActorVO>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Internal Server Error:: "+e.getMessage(),HttpStatus.OK);
		}
	}
	
	
	@GetMapping("find/{id}")
	public ResponseEntity<?> findActorById(@PathVariable("id")Integer id) {
		System.out.println("ActorController.findActorById()");
		try {
			ActorVO vo=ser.getActorById(id);
			return new ResponseEntity<ActorVO>(vo,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(" "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@GetMapping("/find/{start}/{end}")
	public ResponseEntity<?> showDoctorByRenge(@PathVariable double start, @PathVariable double end){
		System.out.println("ActorController.showDoctorByRenge()");
		try {
			Iterable<ActorVO> actorList=ser.showActorByRenge(start, end);
			return new ResponseEntity<Iterable<ActorVO>>(actorList,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	@PutMapping("update")
	public ResponseEntity<?> updateActor(@RequestBody ActorVO vo) {
		System.out.println("ActorController.updateActor()");
		try {
			String result=ser.modifyActor(vo);
			System.out.println(result);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Update proble:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable Integer id) {
		System.out.println("ActorController.deleteActor()");
		try {
			String result=ser.removeActorById(id);
			System.out.println(result);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in delete operation:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
