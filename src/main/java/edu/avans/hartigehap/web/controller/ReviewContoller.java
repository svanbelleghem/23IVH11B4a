package edu.avans.hartigehap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.avans.hartigehap.domain.Review;

@Controller
public class ReviewContoller {
	@RequestMapping(value="/review", method=RequestMethod.GET)
    public String reviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review";
    }

    @RequestMapping(value="/review", method=RequestMethod.POST)
    public String reviewSubmit(@ModelAttribute Review review, Model model) {
    	model.addAttribute("review", new Review());
        return "result";
    }
}
