package com.project.dao;

import java.util.List;

import com.project.entity.Newspaper;

public interface NewspaperDao {
	boolean saveNewspaperEntity(Newspaper newspaper);
	Newspaper searchNewspaper(String newspapername);
	List<Newspaper> getAllNewspaperDetails();
 boolean deleteNewspaperEntity(String newspapername);

}
