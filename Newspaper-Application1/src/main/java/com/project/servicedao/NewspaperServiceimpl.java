package com.project.servicedao;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.project.dao.NewspaperDao;
import com.project.dto.NewspaperDto;
import com.project.entity.Newspaper;
@Component
public class NewspaperServiceimpl implements NewspaperServiceDao {
	@Autowired
	private NewspaperDao dao;

	@Override
	public boolean validateNewspaperEntity(NewspaperDto newspaperdto) {
		System.out.println("NewspaperServiceimpl.validateNewspaperEntity()");
		boolean flag=false;
		if(newspaperdto.getNewspapername()!=null&&!newspaperdto.getNewspapername().isEmpty()) {
			flag=true;
		}
		else {
			flag=false;
			System.out.println("Newspaper name is invalid,,,,,,,,,,,,,,");
			return flag;
		}
		
		if(newspaperdto.getPrice()>0) {
			flag=true;
		}
		else {
			flag=false;
			System.out.println("newspaperprive is invalid,,,,,,,,");
			return flag;
		}
		if(newspaperdto.getLanguage()!=null&& !newspaperdto.getLanguage().isEmpty()) {
			flag=true;
		}
		else {
			flag=false;
			System.out.println("newspaper language is invalid");
			return flag;
		}
		if(newspaperdto.getNoofpages()>0) {
			flag=true;
			
		}
		else {
			flag=false;
			System.out.println("newspaper no of pages invalid,,,,,,,");
			return flag;
		}
		return flag;
		
	}

	@Override
	public boolean savenewspaperDtoEntity(NewspaperDto newspaperdto) {
		System.out.println("NewspaperServiceimpl.savenewspaperDtoEntity()");
		Newspaper newspaper=new Newspaper();
    BeanUtils.copyProperties(newspaperdto, newspaper);
    boolean result=this.dao.saveNewspaperEntity(newspaper);
		return result;
	}


	

	

	@Override
	public List<Object> getNewspaperEntityDetails() {
		System.out.println("NewspaperServiceimpl.getNewspaperEntityDetails()");
		List<Object> newspaperContainer=null;
		List<Newspaper> newspaperEntitycontainer=this.dao.getAllNewspaperDetails();
		if(newspaperEntitycontainer!=null) {
			return newspaperContainer=new ArrayList<Object>(newspaperEntitycontainer);
		}
		return newspaperContainer;
	}

	@Override
	public boolean DeletenewspaperEntity(String newspapername) {
		System.out.println("NewspaperServiceimpl.DeletenewspaperEntity()");
		boolean newspaper=this.dao.deleteNewspaperEntity(newspapername);
		return true;
	}

	@Override
	public boolean validateNewspaperName(String newspapername) {
		System.out.println("NewspaperServiceimpl.validateNewspaperName()");
		boolean flag=false;
		if(newspapername!=null &&!newspapername.isEmpty()) {
			flag=true;
			return flag;
		}
		else {
			System.out.println("Invalid neespaper name");
		}
		return flag;
	}

	@Override
	public NewspaperDto GetnewspaperName(String newspapername) {
		System.out.println("NewspaperServiceimpl.GetnewspaperName()");
		Newspaper entity=this.dao.searchNewspaper(newspapername);
		if(entity!=null) {
			NewspaperDto dto=new NewspaperDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}
	

}
