package com.nt.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@Table(name="Rest_Actor102")
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql="UPDATE Rest_Actor102 SET STATUS ='INACTIVE' WHERE AID = ? AND UPDATE_COUNT=? ") // FOR SOFT DELETION
@SQLRestriction("STATUS <> 'INACTIVE' ") // FOR MAKING INACTIVE RECORD NOT PARTICEPATE

public class Actor {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ACTOR_SEQ",initialValue = 1000,allocationSize = 1)
    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer aid;
	@NonNull
	@Column(length = 20)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String address;
	
	@NonNull
	@Column(length = 20)
	private Double fees;
	
	@NonNull
	@Column(length = 20)
	private String category;
	
	@Column(length=30)
	private   String  industry;
	 
	@NonNull
	private  LocalDateTime  dob;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	@Version
	private Integer updateCount;
	
	@Column(length = 20, updatable = false)
	private String createdBy;
	
	@Column(length = 20, insertable = false)
	private String updateBy;
	
	@Column(length = 20)
	private String status="active";
	
	public Actor() {
		System.out.println("Actor.Actor()");
	}

}
