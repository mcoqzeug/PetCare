package edu.osu.cse5234.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Home {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String goToHomePage() throws Exception {
		return "Home";
	}
}
