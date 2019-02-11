package com.springdata.springJPA.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdata.springJPA.service.BookService;
/*
 * 200384
 */
@Controller
public class AppController {
	@Autowired BookService bookService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	    
	}
	

	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcomemessage(Model model) {
      model.addAttribute("message", "Please select the functions!");
      return "welcome";
   }


}
