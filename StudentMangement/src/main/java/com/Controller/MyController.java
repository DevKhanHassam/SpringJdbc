package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Service.ServiceImp;

import Dto.DtoStudent;
import Pojo.Student;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SessionAttributes("DtoStudent")
public class MyController 
{
	
	@Autowired
	private ServiceImp serviceImp;

	
	@RequestMapping("/")
	public String homePage(Model model, DtoStudent dtoStudent)
	{
		List<Student> getAllData = serviceImp.getAllData();
		model.addAttribute("studentList", getAllData);
		model.addAttribute("dtoStudent", dtoStudent);
		return "index";
	}
	

	
	@RequestMapping("/addStudent")
	public String addStudent(@ModelAttribute("dtoStudent") DtoStudent dtoStudent)
	{
		return "addStudent";
	}
	
	
	@PostMapping("/saveData")
	public String saveData(Model model,DtoStudent dtoStudent)
	{
		serviceImp.addStudent(dtoStudent);
		List<Student> allData = serviceImp.getAllData();
		model.addAttribute("studentList",allData);
		return "redirect:/";                        //postredirect method     //Here we redirect not return to indexPage becasue if we go to page and there user refresh the page data will enter again
	}
	
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(Model model,DtoStudent dtoStudent)
	{
		String pageValueFromService = serviceImp.deleteStudent(dtoStudent.getId());
		List<Student> allData = serviceImp.getAllData();
		model.addAttribute("studentList",allData);
		return pageValueFromService;
	}
	
	
	@RequestMapping("/updateStudent")
	public String updateStudent(DtoStudent dtoStudent, @RequestParam("rollno") int id,Model model ) {
		model.addAttribute(dtoStudent);
		
		return "updateStudent";
	}
	
	
	
	
	
	

}
