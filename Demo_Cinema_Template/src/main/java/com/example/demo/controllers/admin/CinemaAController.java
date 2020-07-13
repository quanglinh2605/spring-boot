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
import com.demo.apis.CinemaAPI;
import com.demo.entities.Cinema;

@Controller
@RequestMapping(value = { "/admin/cinema" })
public class CinemaAController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("cinemas", null);
		return "redirect:/admin/cinema/page/1";
	}
	
	@RequestMapping(value = {"page/{pageNumber}"})
	public String showCinemaPage(HttpServletRequest request, 
			@PathVariable int pageNumber, ModelMap modelMap) {
		int d;
		if(request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		}else {
			d = 0;
		}
		if(pageNumber == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if(pageNumber != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type",null);
			request.getSession().setAttribute("d", null);
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("cinemas");
		int pagesize = 3;
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		List<Cinema> list = null;
		try {
			list = (List<Cinema>) cinemaAPI.findall().execute().body();
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
		request.getSession().setAttribute("cinemas", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;
		String baseUrl = "/admin/cinema/page/";
		
		modelMap.put("title", "Cinema");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("cinemas", pages);
		return "cinema.index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);
		modelMap.put("cinema", new Cinema());
		modelMap.put("title", "Cinema");
		return "cinema.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("cinema") Cinema cinema, HttpServletRequest request) {
		String path = "cinema.index";
		try {
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			Cinema result = cinemaAPI.create(cinema).execute().body();
			if (result.getCinemaId() != 0) {
				request.getSession().setAttribute("message", "Added Successfully");
				request.getSession().setAttribute("type","alert-success");
				request.getSession().setAttribute("d", null);
				path = "redirect:/admin/cinema/index";
			} else {
				request.getSession().setAttribute("message", "Add Fail");
				request.getSession().setAttribute("type","alert-danger");
				path = "cinema.add";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);	
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		try {
			modelMap.put("cinema", cinemaAPI.getById(id).execute().body());
			modelMap.put("title", "Cinema");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "cinema.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("cinema") Cinema cinema, HttpServletRequest request) {
		String path = "cinema.index";
		try {
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			Cinema result = cinemaAPI.update(cinema).execute().body();
			if (result != null) {
				request.getSession().setAttribute("message", "Updated Successfully");
				request.getSession().setAttribute("type","alert-success");
				path = "redirect:/admin/cinema/index";
			}
		} catch (Exception e) {
			request.getSession().setAttribute("message", "Update Fail");
			request.getSession().setAttribute("type","alert-danger");
			path = "cinema.edit";
			System.out.println(e.getMessage());
		}
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);	
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		try {
			cinemaAPI.delete(id).execute();
			request.getSession().setAttribute("message", "Deleted Successfully");
			request.getSession().setAttribute("type","alert-success");			
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute("message", "Delete Fail");
			request.getSession().setAttribute("type","alert-danger");
		}
		return "redirect:/admin/cinema/index";
	}

	@RequestMapping(value = { "search/{page}" }, method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword, HttpServletRequest request,@PathVariable("page") int page) {
		int d;
		if(request.getSession().getAttribute("d") != null) {
			d = (int) request.getSession().getAttribute("d");
		}else {
			d = 0;
		}
		if(page == 1) {
			d++;
			request.getSession().setAttribute("d", d);
		}
		if(page != 1 || d != 1) {
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("type",null);
			request.getSession().setAttribute("d", null);
		}
		if (keyword.equals("")) {	
			return "redirect:/admin/cinema/index";	
		}	
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		List<Cinema> list = null;
		try {
			list = cinemaAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		if (list == null) {	
			return "redirect:/admin/cinema/index";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("cinemas");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = page - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("cinemas", pages);	
		int current = pages.getPage() + 1;	
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;
		String baseUrl = "/admin/cinema/search/";	
		modelMap.addAttribute("beginIndex", begin);	
		modelMap.addAttribute("endIndex", end);	
		modelMap.addAttribute("currentIndex", current);	
		modelMap.addAttribute("totalPageCount", totalPageCount);	
		modelMap.addAttribute("baseUrl", baseUrl);	
		modelMap.addAttribute("cinemas", pages);
		modelMap.put("title", "Cinemas");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "cinema.index";	
	}
}
