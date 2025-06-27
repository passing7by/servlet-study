package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Planet {
	private String name;
	private double distance;
	private boolean isHabitable;
	
	public boolean getHabitable() {
		return isHabitable;
	}
}
