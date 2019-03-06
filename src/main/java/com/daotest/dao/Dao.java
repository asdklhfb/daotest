package com.daotest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import commons.Db;

@Component
public class Dao {
	// Insert
	public void insert(Map<String, String> m) {
		String sql = String.format("INSERT INTO spr_test2 VALUES(SQ_spr_test2.NEXTVAL, '%s', %s)", m.get("s_name"), m.get("s_age"));
		Db.executeUpdate(sql);
	}
	
	// Select
	public ArrayList<HashMap<String, String>> select() {
		return Db.selectListMap("SELECT * FROM spr_test2 ORDER BY S_NUM DESC");
	}
}
