package com.keiko.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keiko.dojos.models.Dojo;
import com.keiko.dojos.models.Ninja;
import com.keiko.dojos.services.DojoService;

@Controller
public class DojosController {
	private final DojoService ds;
	
	
	public DojosController(DojoService ds) {
		this.ds=ds;
	}
	
	//the above are injected
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo ) { //"dojo" came from new.jsp ModelAttribute name and Dojo dojo=object to bind
		return "/dojos/new.jsp";
	}
	
	//@RequestMapping(value="/dojos", method=RequestMapping.POST)--this is the same as @PostMapping--value means to post
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {//@Valid is validations
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		}else {
			Dojo createdDojo=ds.createDojo(dojo); //createDojo comes from Services and dojo from the parameter above
			return "redirect:/dojos/"+ createdDojo.getId();
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String show(@PathVariable("dojoId") Long dojoId, Model model) { //pass info on the model & pathvaraible is ID
		Dojo dojo=ds.findDojo(dojoId);
		
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
	
}
