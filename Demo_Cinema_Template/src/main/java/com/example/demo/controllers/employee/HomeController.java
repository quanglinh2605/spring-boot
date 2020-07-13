package com.example.demo.controllers.employee;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.MovieAPI;
import com.example.demo.entities.Movie;
import com.example.demo.entities.User;
import com.example.demo.models.MovieModel;

@Controller
@RequestMapping(value = { "", "home" })
public class HomeController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {

		User user = null;
		if (session.getAttribute("currenUser") != null) {
			user = new User();
			user = (User) session.getAttribute("currenUser");
		}
		MovieModel model = new MovieModel();
		System.out.println("product List: ");
		modelMap.put("movies", model.findAllMovie());
		modelMap.put("movie", model.findNewMovie());
		modelMap.put("user", user);
		modelMap.put("title", "Home | Cinema XXII");
		return "home.index";
	}
	
	@RequestMapping(value="movieNameAutocomplete", method = RequestMethod.GET)
	@ResponseBody
	public List<String> autocompletee(@RequestParam ("term") String term){
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		List<Movie> movies= new ArrayList<Movie>();
		try {
			movies = new ArrayList<Movie>();
			movies =  movieAPI.searchMovieName(term).execute().body();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		List<String> names = new ArrayList<String>();
		for(Movie m : movies) {
			names.add(m.getMovieName());
		}
		return names;
	}
	
	@RequestMapping(value = { "search" }, method = RequestMethod.POST)
	public String search(@RequestParam("movieName") String movieName) {
		MovieModel model = new MovieModel();
		Movie movie = model.findMovieByName(movieName);
		int movie_id =  Integer.parseInt(movie.getMovieId());
		
		return "redirect:/schedule/movie/" + movie_id + "/0";
	}
}
