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

import com.example.demo.validators.RoomValidator;
import com.demo.apis.APIClient;
import com.demo.apis.CinemaAPI;
import com.demo.apis.RoomAPI;
import com.demo.entities.Room;
import com.demo.entities.RoomEntity;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = { "/admin/room" })
public class RoomAController {

	@Autowired
	private RoomValidator roomValidator;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("rooms", null);
		return "redirect:/admin/room/page/1";
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
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("rooms");
		int pagesize = 5;
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		List<Room> list = null;
		try {
			list = (List<Room>) roomAPI.sortByCinema().execute().body();
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
		request.getSession().setAttribute("rooms", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/room/page/";

		modelMap.put("title", "Room");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("rooms", pages);
		return "room.index";
	}
		
	@RequestMapping(value = { "listByCinema/{id}/{pageNumber}" })
	public String showMoviePage(HttpServletRequest request, @PathVariable int pageNumber,@PathVariable("id") int id, ModelMap modelMap) {
		request.getSession().setAttribute("rooms", null);
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
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("rooms");
		int pagesize = 5;
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		List<Room> list = null;
		try {
			list = (List<Room>) roomAPI.listByCinema(id).execute().body();
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
		request.getSession().setAttribute("rooms", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/room/listByCinema/" + id + "/";

		modelMap.put("title", "Room");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("rooms", pages);
		return "room.index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		try {
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelMap.put("title", "Room");
		modelMap.put("room", new Room());
		return "room.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		String path = "room.index";
		roomValidator.validate(room, bindingResult);
		if (bindingResult.hasErrors()) {
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			try {
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelMap.put("title", "Room");
			path = "room.add";
		} else {
			try {
				RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
				Room result = roomAPI.create(room).execute().body();
				if (result.getRoomId() != 0) {
					request.getSession().setAttribute("message", "Added Successfully");
					request.getSession().setAttribute("type", "alert-success");
					request.getSession().setAttribute("d", null);
					path = "redirect:/admin/room/index";
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Add Fail");
				request.getSession().setAttribute("type", "alert-danger");
				path = "room.add";
				System.out.println(e.getMessage());
			}
		}
		return path;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		request.getSession().setAttribute("d", 1);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		try {
			modelMap.put("room", roomAPI.getById(id).execute().body());
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			modelMap.put("title", "Room");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "room.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		String path = "room.index";
		roomValidator.validate(room, bindingResult);
		if (bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Update Fail");
			request.getSession().setAttribute("type", "alert-danger");
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			try {
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelMap.put("title", "Room");
			return "room.edit";
		} else {
			try {
				RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
				Room result = roomAPI.update(room).execute().body();
				if (result != null) {
					request.getSession().setAttribute("message", "Updated Successfully");
					request.getSession().setAttribute("type", "alert-success");
					request.getSession().setAttribute("d", null);
					path = "redirect:/admin/room/index";
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Update Fail");
				request.getSession().setAttribute("type", "alert-danger");
				System.out.println(e.getMessage());
			}
		}
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		try {
			request.getSession().setAttribute("message", "Deleted Successfully");
			request.getSession().setAttribute("type", "alert-success");
			request.getSession().setAttribute("d", null);
			roomAPI.delete(id).execute();
		} catch (IOException e) {
			request.getSession().setAttribute("message", "Delete Fail");
			request.getSession().setAttribute("type", "alert-danger");
			e.printStackTrace();
		}
		return "redirect:/admin/room/index";
	}

	@ResponseBody
	@RequestMapping(value = "listByCinemaId/{cinemaId}", method = RequestMethod.GET)
	public String listByCinemaId(@PathVariable("cinemaId") int cinemaId, HttpServletRequest request) {
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		Gson gson = new Gson();
		List<RoomEntity> result = null;
		try {
			result = roomAPI.listByCinemaId(cinemaId).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gson.toJson(result);
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
			return "redirect:/admin/room/index";
		}
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		List<Room> list = null;
		try {
			list = roomAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/room/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("rooms");
		int pagesize = 5;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("rooms", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/room/search/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("rooms", pages);
		modelMap.put("title", "Room");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "room.index";
	}
}
