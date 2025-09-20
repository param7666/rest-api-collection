package com.nt.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Tourist_Information")
@Entity
public class Tourist {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	
	@Column(length = 20)
	@NonNull
	private String tname;
	
	@Column(length = 20)
	@NonNull
	private String taddr;

    
    @NonNull
	private Double tbudget;
    
    
}
