package com.example.demo.controllers.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.MovieModel;

@Controller
@RequestMapping(value = {"video"})
public class VideoController {

	private MovieModel movieModel = new MovieModel();
	
	@RequestMapping(value = {"","index" }, method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.put("movies", movieModel.findAllMovie());
		return "video.index";
	}
	
}
