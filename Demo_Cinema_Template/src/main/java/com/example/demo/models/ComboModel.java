package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Combo;

public class ComboModel {
	
	public List<Combo> findAll(){
		List<Combo> combos = new ArrayList<Combo>();
		
		combos.add(new Combo("1 Popcorn 1 soda", "Combo1", 1));
		combos.add(new Combo("1 Popcorn 2 soda", "Combo2", 2));
		combos.add(new Combo("2 Popcorn 2 soda", "Combo3", 3));
		
		return combos;
		
	}

}
