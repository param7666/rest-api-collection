package com.nt.model;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	
	private Integer sid;
	private String name;
	private List<String> nicknames;
	private String[] subjects;
	private Set<String>gnames;
	private Map<String, Integer> sMarks;

}
