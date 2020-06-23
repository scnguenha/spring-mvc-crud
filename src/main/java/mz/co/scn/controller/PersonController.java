package mz.co.scn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.scn.model.Person;
import mz.co.scn.repository.PersonRepository;

/**
 *
 * @author Sidónio Goenha on Jun 23, 2020
 *
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/form")
	public String initForm(Model model) {
		model.addAttribute("person", new Person());
		return "person/form";
	}
	
	@PostMapping
	public String save(Person person) {
		personRepository.save(person);
		return "redirect:/persons/form";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "person/list";
	}
	
	@GetMapping("/{id}/update")
	public String processUpdate(Model model, @PathVariable Long id) {
		model.addAttribute("person", personRepository.findById(id).get());
		return "person/form";
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		personRepository.deleteById(id);
		return "redirect:/persons/list";
	}
}
