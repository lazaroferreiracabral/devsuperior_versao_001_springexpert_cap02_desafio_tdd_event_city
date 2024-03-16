package com.devsuperior.demo.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomErrorDTO {
	
	private Instant timestmap;
	private Integer status;
	private String error;
	private String path;
	
	

}
