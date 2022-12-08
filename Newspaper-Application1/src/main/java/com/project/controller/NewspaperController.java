package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.NewspaperDto;
import com.project.servicedao.NewspaperServiceDao;

@Component
@RequestMapping("/")
public class NewspaperController {
	@Autowired
	private NewspaperServiceDao service;
	public NewspaperController() {
		System.out.println("object is created:"+this.getClass().getName());
	}
	@RequestMapping("/submit.do")
	public String saveNewspaper(@ModelAttribute NewspaperDto newspaperdto , Model model) {
		System.out.println("object is created savenewspaper,,,,,");
		if(service.validateNewspaperEntity(newspaperdto)) {
			boolean issaved=this.service.savenewspaperDtoEntity(newspaperdto);
			if(issaved) {
		model.addAttribute("name",newspaperdto.getNewspapername());
		model.addAttribute("price", newspaperdto.getPrice());
		model.addAttribute("Language",newspaperdto.getLanguage());
		model.addAttribute("NOofpages",newspaperdto.getNoofpages() );
		model.addAttribute("validateMessage", "data is saved sucessfully");
				
				
			}
			else {
				model.addAttribute("Invaildvalidate", "Input is invalid,please check once,,,,,,,,,,");
			}
		}
		
		
		
		
		return"WEB-INF/pages/NewsPaperDetails.jsp";
		
		
	}
	@RequestMapping("/SearchNewspaper.do")
	public String getNewspaperDetails(@RequestParam String newspapername,Model model) {
		System.out.println("NewspaperController.getNewspaperDetails()");
		if(this.service.validateNewspaperName(newspapername)) {
			NewspaperDto dto=this.service.GetnewspaperName(newspapername);
			if(dto!=null) {
				model.addAttribute("newspapername", dto.getNewspapername());
				model.addAttribute("price", dto.getPrice());
				model.addAttribute("language", dto.getLanguage());
				model.addAttribute("noofpages", dto.getNoofpages());
				model.addAttribute("validateMessage","newspaper details fetched sucessfully");
				return"WEB-INF/pages/viewNewsPaperDetails.jsp";
			}
			else {
				model.addAttribute("validateMessage","newspaper details not found");
				return "WEB-INF/pages/Error.jsp";
			}
		}
		return"WEB-INF/pages/viewNewsPaperDetails.jsp" ;
		
	}
	
	@RequestMapping("/view.do")
	public String getallNewspaperDetails(Model model) {
		System.out.println("NewspaperController.getallNewspaperDetails()");
		List<Object> allnewspaperEntity=this.service.getNewspaperEntityDetails();
		model.addAttribute("ListofNewspaper", allnewspaperEntity);
		return "WEB-INF/pages/viewAllNewspaperDetails.jsp";
		
		
	}
	@RequestMapping("/Delete.do")
	public String DeletenewspaperEntity(@RequestParam String newspapername,Model model) {
		System.out.println("NewspaperController.DeletenewspaperEntity()");
		boolean isDeleted=this.service.DeletenewspaperEntity(newspapername);
		if(isDeleted) {
			model.addAttribute("validationMessage", "Newspaper details deleted sucessfully");
			return"WEB-INF/pages/deleteNewspaperDetails.jsp";
		}
		else {
			model.addAttribute("ErrorvalidationMessage", "Could not deleted ");
			return "WEB-INF/pages/Error.jsp";
			
		}
		
		
	}

}
