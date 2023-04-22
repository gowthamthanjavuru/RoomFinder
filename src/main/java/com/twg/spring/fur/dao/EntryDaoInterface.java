package com.twg.spring.fur.dao;

import java.util.List;

import com.twg.spring.fur.entities.Entry;

public interface EntryDaoInterface {
	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findById(int id);
	public List<Entry> findAll();
	public List<Entry> findByUserid(int id);
	//
	public List<Entry> findByUni(String uni);
}
