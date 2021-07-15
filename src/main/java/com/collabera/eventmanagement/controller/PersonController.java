package com.collabera.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.collabera.eventmanagement.entities.Person;
import com.collabera.eventmanagement.service.PersonService;
//this is controller class it handles the request and forward it to next layer
@Controller
public class PersonController {

	//autowired the service
	@Autowired
	private PersonService personService;

	//this is home page endpoint
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Person> listPersons;
		try {
			listPersons = personService.listAll();
			model.addAttribute("listPersons", listPersons);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	//this is add new person endpoint
	@RequestMapping("/new")
	public String showNewPersonPage(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);

		return "new_person";
	}

	//its for save person
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("person") Person person) {
		try {
			personService.save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

	//its for edit the person record
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_person");
		Person person;
		try {
			person = personService.get(id);
			mav.addObject("person", person);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	//its for deleting the person record
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		try {
			personService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
