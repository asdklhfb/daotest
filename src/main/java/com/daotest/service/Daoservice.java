package com.daotest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daotest.dao.Dao;

@Service
public class Daoservice {
	// DAO
	@Autowired
	Dao dao;
	
	// Insert
	public void insert(Map<String, String> m) {
		dao.insert(m);
	}
	
	// Select
	public ArrayList<HashMap<String, String>> select() {
		return dao.select();
	}
}
