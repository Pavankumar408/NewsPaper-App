package com.project.servicedao;

import java.util.List;

import com.project.dto.NewspaperDto;
public interface  NewspaperServiceDao {
	boolean validateNewspaperEntity(NewspaperDto newspaperdto);
	boolean savenewspaperDtoEntity(NewspaperDto newspaperdto);
	boolean validateNewspaperName(String newspapername);
	NewspaperDto GetnewspaperName(String newspapername);
	List<Object> getNewspaperEntityDetails();
	boolean DeletenewspaperEntity(String newspapername);

}
