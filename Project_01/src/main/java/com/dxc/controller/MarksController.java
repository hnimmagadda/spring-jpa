package com.dxc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.beans.Marks;
import com.dxc.beans.Student;
import com.dxc.repository.MarksRepository;

@Controller
public class MarksController {
	
	@Autowired
	MarksRepository marksRepository;
	
	@RequestMapping("displaymarks")
	public ModelAndView displaymarks() {
		ModelAndView modelAndView = new ModelAndView("displaymarks");
		List<Marks> marks = (List<Marks>) marksRepository.findAll();
		modelAndView.addObject("mrks", marks);
		return modelAndView;

	}
	
	@RequestMapping("addmarks")
	public String newmarksform() {
		return "addmarks";
	}

	@RequestMapping("savemarks")
	public String addMarks(@RequestParam("exid") String exid, @RequestParam("stid") int stid,
			@RequestParam("sub1") int sub1, @RequestParam("sub2") int sub2, @RequestParam("sub3") int sub3)
			throws ParseException {
		Marks marks = new Marks(exid, stid, sub1, sub2, sub3);
		marksRepository.save(marks);
		return "redirect:/displaymarks";
	}

	@RequestMapping("editmarks")
	public String editmarksform() {
		return "editmarks";
	}

	@RequestMapping("updatemarks")
	public String updatemarks(@RequestParam("exid") String exid, @RequestParam("stid") int stid,
			@RequestParam("sub1") int sub1, @RequestParam("sub2") int sub2, @RequestParam("sub3") int sub3)
			throws ParseException {
		Marks marks = new Marks(exid, stid, sub1, sub2, sub3);
		marksRepository.save(marks);
		return "redirect:/displaymarks";
	}
	
	@RequestMapping("marksdelete")
	public String deleteStudent(@RequestParam("stid") int stid) {
		marksRepository.deleteById(stid);
		return "redirect:/displaymarks";
	}
}
