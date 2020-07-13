package com.example.demo.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.apis.APIClient;
import com.demo.apis.MovieAPI;
import com.demo.entities.Movie;


@Controller
@RequestMapping("admin/movie")
public class MovieAController{
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("movies", null);
		return "redirect:/admin/movie/page/1";
	}

	@RequestMapping(value = { "page/{pageNumber}" })
	public String showMoviePage(HttpServletRequest request, @PathVariable int pageNumber, ModelMap modelMap) {
		int d;
		if (request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		} else {
			d = 0;
		}
		if (pageNumber == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if (pageNumber != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type", null);
			request.getSession().setAttribute("d", null);
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("movies");
		int pagesize = 3;
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		List<Movie> list = null;
		try {
			list = (List<Movie>) movieAPI.findall().execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("movies", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/movie/page/";

		modelMap.put("title", "Movie");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("movies", pages);

		return "movie.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		modelMap.put("movie", new Movie());
		modelMap.put("title", "Movie");
		return "movie.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("movie") Movie movie, HttpServletRequest request, ModelMap modelMap) {
		String path = "movie.index";
		try {
			MovieAPI MovieAPI = APIClient.getClient().create(MovieAPI.class);
			Movie result = MovieAPI.create(movie).execute().body();
			if (result.getMovieId() != 0) {
				request.getSession().setAttribute("message", "Added Successfully");
				request.getSession().setAttribute("type", "alert-success");
				request.getSession().setAttribute("d", null);
				path = "redirect:/admin/movie/index";
			}
		} catch (Exception e) {
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);			
			path = "movie.add";
			System.out.println(e.getMessage());
		}
		modelMap.put("title", "Movie");
		return path;
	}

	/*
	 * private String upload(MultipartFile file) { try { byte[] bytes =
	 * file.getBytes(); Path path =
	 * Paths.get(servletContext.getRealPath("/uploads/images/" +
	 * file.getOriginalFilename())); Files.write(path, bytes); return
	 * "/uploads/images/" + file.getOriginalFilename(); } catch (Exception e) {
	 * System.out.println(e.getMessage()); return null; } }
	 */

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		MovieAPI MovieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			modelMap.put("movie", MovieAPI.getById(id).execute().body());
			modelMap.put("title", "Movie");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "movie.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("movie") Movie movie, HttpServletRequest request) {
		String path = "movie.index";
		try {
			MovieAPI MovieAPI = APIClient.getClient().create(MovieAPI.class);
			Movie result = MovieAPI.update(movie).execute().body();
			if (result != null) {
				request.getSession().setAttribute("message", "Updated Successfully");
				request.getSession().setAttribute("type", "alert-success");
				path = "redirect:/admin/movie/index";
			} else {
				request.getSession().setAttribute("message", "Update Fail");
				request.getSession().setAttribute("type", "alert-danger");
				path = "movie.edit";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		MovieAPI MovieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			request.getSession().setAttribute("message", "Deleted Successfully");
			request.getSession().setAttribute("type", "alert-success");
			MovieAPI.delete(id).execute();
		} catch (IOException e) {
			request.getSession().setAttribute("message", "Delete Fail");
			request.getSession().setAttribute("type", "alert-danger");
			e.printStackTrace();
		}
		return "redirect:/admin/movie/index";
	}

	@RequestMapping(value = { "search/{page}" }, method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword, HttpServletRequest request,
			@PathVariable("page") int page) {
		int d;
		if (request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		} else {
			d = 0;
		}
		if (page == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if (page != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type", null);
			request.getSession().setAttribute("d", null);
		}
		if (keyword.equals("")) {
			return "redirect:/admin/movie/index";
		}
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		List<Movie> list = null;
		try {
			list = movieAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/room/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("movies");
		int pagesize = 3;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("movies", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/movie/search/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("movies", pages);
		modelMap.put("title", "Movie");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "movie.index";
	}
}
