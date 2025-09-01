package com.nt.javaBean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActorVO {  
	private Integer aid;
	private String name;
	private String address;
	private String category;
	private Double fees;
	private String industry;
	private LocalDateTime dob;
	
	public ActorVO() {
		System.out.println("ActorVO.ActorVO()");
	}

}
