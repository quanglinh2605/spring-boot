package com.example.demo.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.validators.ScheduleValidator;
import com.demo.apis.APIClient;
import com.demo.apis.CinemaAPI;
import com.demo.apis.MovieAPI;
import com.demo.apis.RoomAPI;
import com.demo.apis.ScheduleAPI;
import com.demo.entities.Schedule;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = { "/admin/schedule" })
public class ScheduleAController {

	@Autowired
	private ScheduleValidator scheduleValidator;
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("schedules", null);
		return "redirect:/admin/schedule/page/1";
	}

	@RequestMapping(value = { "page/{pageNumber}" })
	public String showSchedulePage(HttpServletRequest request, @PathVariable int pageNumber, ModelMap modelMap) {
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
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("schedules");
		int pagesize = 3;
		ScheduleAPI scheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		List<Schedule> list = null;
		try {
			list = (List<Schedule>) scheduleAPI.sortByDate().execute().body();
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
		request.getSession().setAttribute("schedules", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/schedule/page/";

		modelMap.put("title", "Schedule");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("schedules", pages);

		return "schedule.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);		
		modelMap.put("schedule", new Schedule());
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			modelMap.put("movies", movieAPI.findall().execute().body());
			modelMap.put("title", "Schedule");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "schedule.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("schedule") @Valid Schedule Schedule,BindingResult bindingResult, HttpServletRequest request, ModelMap modelMap) {
		String path = "schedule.index";
		scheduleValidator.validate(Schedule, bindingResult);
		if(bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type","alert-danger");
			request.getSession().setAttribute("d", 1);
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
			try {
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
				modelMap.put("movies", movieAPI.findall().execute().body());				
				modelMap.put("title", "Schedule");
			} catch (IOException e) {
			}
			return "schedule.add";
		}else {
			try {
				ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
				Schedule result = ScheduleAPI.create(Schedule).execute().body();
				if (result.getScheduleId() != 0) {
					request.getSession().setAttribute("message", "Added Successfully");
					request.getSession().setAttribute("type","alert-success");
					request.getSession().setAttribute("d", null);
					path = "redirect:/admin/schedule/index";
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Add Fail");
				request.getSession().setAttribute("type","alert-danger");
				path = "schedule.add";
				System.out.println(e.getMessage());
			}
		}		
		return path;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);
		ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
		try {
			Schedule Schedule = ScheduleAPI.getById(id).execute().body();
			modelMap.put("schedule", Schedule);
			modelMap.put("check", Schedule);
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			modelMap.put("rooms",
					roomAPI.listByCinemaId(Schedule.getRoom().getCinema().getCinemaId()).execute().body());
			modelMap.put("movies", movieAPI.findall().execute().body());
			modelMap.put("title", "Schedule");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "schedule.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("schedule") @Valid Schedule Schedule,BindingResult bindingResult, HttpServletRequest request, ModelMap modelMap) {
		String path = "schedule.index";
		scheduleValidator.validate(Schedule, bindingResult);
		if(bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Update Fail");
			request.getSession().setAttribute("type","alert-danger");
			request.getSession().setAttribute("d", 1);
			ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
			MovieAPI movieAPI = APIClient.getClient().create(MovieAPI.class);
			try {
				Schedule item = ScheduleAPI.getById(Schedule.getScheduleId()).execute().body();
				modelMap.put("check", item);
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
				modelMap.put("rooms",
						roomAPI.listByCinemaId(item.getRoom().getCinema().getCinemaId()).execute().body());
				modelMap.put("movies", movieAPI.findall().execute().body());
				modelMap.put("title", "Schedule");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "schedule.edit";
		}else {
			try {
				ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
				Schedule result = ScheduleAPI.update(Schedule).execute().body();
				if (result != null) {
					request.getSession().setAttribute("message", "Updated Successfully");
					request.getSession().setAttribute("type","alert-success");
					request.getSession().setAttribute("d", null);
					path = "redirect:/admin/schedule/index";
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Update Fail");
				request.getSession().setAttribute("type","alert-danger");
				path = "schedule.edit";
				System.out.println(e.getMessage());
			}
		}	
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type",null);
		ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		try {
			request.getSession().setAttribute("message", "Deleted Successfully");
			request.getSession().setAttribute("type","alert-success");
			ScheduleAPI.delete(id).execute();
		} catch (IOException e) {
			request.getSession().setAttribute("message", "Delete Fail");
			request.getSession().setAttribute("type","alert-danger");
			e.printStackTrace();
		}
		return "redirect:/admin/schedule/index";
	}

	@RequestMapping(value = { "search/{page}" }, method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("keyword") String keyword, HttpServletRequest request,
			@PathVariable("page") int page) {
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
			return "redirect:/admin/schedule/index";
		}
		ScheduleAPI scheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		List<Schedule> list = null;
		try {
			list = scheduleAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/schedule/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("schedules");
		int pagesize = 3;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("schedules", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/schedule/search/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("schedules", pages);
		modelMap.put("title", "Schedule");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "schedule.index";
	}

	@ResponseBody
	@RequestMapping(value = "findByMovie/{movie_id}", method = RequestMethod.GET)
	public String findByRoom(@PathVariable("movie_id") int movie_id) {
		ScheduleAPI ScheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		Gson gson = new Gson();
		List<Schedule> Schedules = null;
		try {
			Schedules = ScheduleAPI.findByMovie(movie_id).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gson.toJson(Schedules);
	}
}
