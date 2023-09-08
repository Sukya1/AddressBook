package com.AddressBook.digitalBook.bookFiles;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class EntryController {
	
	//Instance of the CRUD REPO
	@Autowired
	private EntryRepository entryRepository;
	
	@GetMapping(value = "/")
	public String Home() {
		return "/pages/index";
	}
	
	@ModelAttribute()
    public String getAllNotes(Model model)
    {
        model.addAttribute("entries",entryRepository.findAll());
		return "/pages/addressBook";
    } 
	//Dropdownlist 
	@ModelAttribute("/optionDetails")
	public String populateList(Model model) {  
		ArrayList<String> options = new ArrayList<String>();
	    options.add("Add an Entry");
	    options.add("Remove an Entry");
	    options.add("Search for an Entry");
	    options.add("See Address Book");
	    options.add("Clear Address Book");
	    model.addAttribute("optionList", options);
	    return "/pages/index";
	}

	@PostMapping("/createAction")
	public String createAction(@RequestParam("selectedVal") String task, Model model) {
		 model.addAttribute("person", new Entry());
		if (task.equals("Add an Entry")) {
			return "/pages/addEntry";
		} else if (task.equals("Remove an Entry")) {
			return "/pages/addressBook";
		} else if (task.equals("Search for an Entry")) {
			return "/pages/search";
		} else if (task.equals("See Address Book")) {
			return "/pages/addressBook";
		} else if (task.equals("Clear Address Book")) {
			entryRepository.deleteAll();
			return "/pages/index";
		} else {
			return "/pages/index";
		}
	}
	
	@PostMapping(value = "/savePerson")
    public String addNewPerson(@ModelAttribute Entry person, Model model) {
	if (person == null) {
        person = new Entry(); // Initialize the person object if it's null
    }
	entryRepository.save(new Entry(person.getFirstName(), person.getLastName(), person.getPhoneNumber(),person.getEmailAddress(),person.getHomeAddress()));
	model.addAttribute("FirstName", person.getFirstName());
	model.addAttribute("LastName", person.getLastName());
	model.addAttribute("PhoneNumber", person.getPhoneNumber());
	model.addAttribute("EmailAddress", person.getEmailAddress());
	model.addAttribute("HomeAddress", person.getHomeAddress());
	return "/pages/index";
    }
	
	 @RequestMapping(value = "entries/delete/{id}")
	    public String deletePostById(@PathVariable Long id, Entry entry) {
	        entryRepository.deleteById(id);
	        return "/pages/index";
	    }
	 @PostMapping(value = "/getEmail")
		public String searchbyemail(@RequestParam("selectedVal") String email, Model model) {
		 for (Entry ent: entryRepository.findAll()) {
			 if (ent != null && ent.getEmailAddress() != null && ent.getEmailAddress().equals(email)) {
				 model.addAttribute("email",ent);
				 return "/pages/searchOutput";
			 }
		 } 
		return "/pages/search";
		}
}
