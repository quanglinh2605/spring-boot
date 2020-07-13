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

import com.demo.apis.SeatsAPI;
import com.example.demo.validators.SeatValidator;
import com.demo.apis.APIClient;
import com.demo.apis.CinemaAPI;
import com.demo.apis.RoomAPI;
import com.demo.entities.Seat;

@Controller
@RequestMapping(value = { "/admin/seat" })
public class SeatAController {

	@Autowired
	private SeatValidator seatValidator;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("seats", null);
		return "redirect:/admin/seat/page/1";
	}

	@RequestMapping(value = { "page/{pageNumber}" })
	public String showSeatPage(HttpServletRequest request, @PathVariable int pageNumber, ModelMap modelMap) {
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
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("seats");
		int pagesize = 5;
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		SeatsAPI seatAPI = APIClient.getClient().create(SeatsAPI.class);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		List<Seat> list = null;
		try {
			modelMap.put("rooms", roomAPI.findall().execute().body());
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			list = (List<Seat>) seatAPI.sortByCinemaRoom().execute().body();
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
		request.getSession().setAttribute("seats", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/seat/page/";

		modelMap.put("title", "Seat");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("seats", pages);
		Seat seat = new Seat();
		modelMap.put("seat", seat);
		return "seat.index";
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
		modelMap.put("seat", new Seat());
		modelMap.put("title", "Seat");
		return "seat.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("seat") @Valid Seat Seat, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		String path = "seat.index";
		seatValidator.validate(Seat, bindingResult);
		if (bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			try {
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelMap.put("title", "Seat");
			path = "seat.add";
		} else {
			try {
				SeatsAPI SeatAPI = APIClient.getClient().create(SeatsAPI.class);
				Seat result = SeatAPI.create(Seat).execute().body();
				if (result.getSeat_id() != 0) {
					request.getSession().setAttribute("message", "Added Successfully");
					request.getSession().setAttribute("type", "alert-success");
					request.getSession().setAttribute("d", null);
					modelMap.put("title", "Seat");
					path = "seat.add";
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Add Fail");
				request.getSession().setAttribute("type", "alert-danger");
				path = "seat.add";
				System.out.println(e.getMessage());
			}
		}
		return path;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("seat") @Valid Seat Seat, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		seatValidator.validate(Seat, bindingResult);
		if (bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Add Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
			try {
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
				modelMap.put("rooms", roomAPI.findall().execute().body());
				modelMap.put("cinemaId", roomAPI.getById(Seat.getRoom().getRoomId()).execute().body().getCinema().getCinemaId());
				modelMap.put("roomId", Seat.getRoom().getRoomId());
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelMap.put("check", "open");
			modelMap.put("title", "Seat");
			return "seat.index";
		} else {
			try {
				SeatsAPI SeatAPI = APIClient.getClient().create(SeatsAPI.class);
				Seat result = SeatAPI.create(Seat).execute().body();
				if (result.getSeat_id() != 0) {
					request.getSession().setAttribute("message", "Added Successfully");
					request.getSession().setAttribute("type", "alert-success");
					request.getSession().setAttribute("d", null);
					modelMap.put("title", "Seat");					
				}
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Add Fail");
				request.getSession().setAttribute("type", "alert-danger");
				System.out.println(e.getMessage());
			}
		}
		return "redirect:/admin/seat/findByRoom/" + Seat.getRoom().getRoomId()+"/1";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		SeatsAPI SeatAPI = APIClient.getClient().create(SeatsAPI.class);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		try {
			Seat seat = SeatAPI.getById(id).execute().body();
			modelMap.put("seat", seat);
			modelMap.put("check", seat);
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			modelMap.put("rooms", roomAPI.listByCinemaId(seat.getRoom().getCinema().getCinemaId()).execute().body());
			modelMap.put("title", "Seat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "seat.edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("seat") @Valid Seat seat, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
		String path = "seat.index";
		seatValidator.validate(seat, bindingResult);
		if (bindingResult.hasErrors()) {
			request.getSession().setAttribute("message", "Update Fail");
			request.getSession().setAttribute("type", "alert-danger");
			request.getSession().setAttribute("d", 1);
			SeatsAPI seatAPI = APIClient.getClient().create(SeatsAPI.class);
			CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
			RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
			try {
				Seat item = seatAPI.getById(seat.getSeat_id()).execute().body();
				modelMap.put("check", seatAPI.getById(seat.getSeat_id()).execute().body());
				modelMap.put("cinemas", cinemaAPI.findall().execute().body());
				modelMap.put("rooms",
						roomAPI.listByCinemaId(item.getRoom().getCinema().getCinemaId()).execute().body());
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelMap.put("title", "Seat");
			return "seat.edit";
		} else {
			try {
				SeatsAPI SeatAPI = APIClient.getClient().create(SeatsAPI.class);
				Seat result = SeatAPI.update(seat).execute().body();
				if (result != null) {
					request.getSession().setAttribute("message", "Updated Successfully");
					request.getSession().setAttribute("type", "alert-success");		
					request.getSession().setAttribute("d", null);
					path = "redirect:/admin/seat/index";
				} 
			} catch (Exception e) {
				request.getSession().setAttribute("message", "Update Fail");
				request.getSession().setAttribute("type", "alert-danger");
				path = "seat.edit";
				System.out.println(e.getMessage());
			}
		}
		return path;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, HttpServletRequest request) {
		request.getSession().setAttribute("message", null);
		request.getSession().setAttribute("type", null);
		SeatsAPI SeatAPI = APIClient.getClient().create(SeatsAPI.class);
		try {
			request.getSession().setAttribute("message", "Deleted Successfully");
			request.getSession().setAttribute("type", "alert-success");
			request.getSession().setAttribute("d", null);
			SeatAPI.delete(id).execute();
		} catch (IOException e) {
			request.getSession().setAttribute("message", "Delete Fail");
			request.getSession().setAttribute("type", "alert-danger");
			e.printStackTrace();
		}
		return "redirect:/admin/seat/index";
	}

	@RequestMapping(value = { "search/{page}" }, method = RequestMethod.GET)
	public String search(ModelMap modelMap, @RequestParam("row") String row, @RequestParam("number") int number,
			@RequestParam("roomId") int roomId, HttpServletRequest request, @PathVariable("page") int page) {
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
		if (row.equals("") && roomId == 0) {
			return "redirect:/admin/seat/index";
		}
		SeatsAPI seatAPI = APIClient.getClient().create(SeatsAPI.class);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		List<Seat> list = null;
		try {
			if (roomId != 0 && row != "") {
				list = seatAPI.search(row, number, roomId).execute().body();
			}
			if (roomId != 0 && row.equals("")) {
				list = seatAPI.findByRoom(roomId).execute().body();
			}
			if (roomId == 0) {
				list = seatAPI.search(row, number).execute().body();
			}
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			if (roomId != 0) {
				modelMap.put("rooms",
						roomAPI.listByCinemaId(roomAPI.getById(roomId).execute().body().getCinema().getCinemaId())
								.execute().body());
				modelMap.put("cinemaId", roomAPI.getById(roomId).execute().body().getCinema().getCinemaId());
				modelMap.put("roomId", roomId);
			} else {
				modelMap.put("rooms", roomAPI.findall().execute().body());
			}
			modelMap.put("row", row);
			modelMap.put("number", number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/seat/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("seats");
		int pagesize = 5;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("seats", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/seat/search/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("seats", pages);
		modelMap.put("title", "Seat");
		modelMap.put("addUrl", "?roomId=" + roomId + "&row=" + row + "&number=" + number);
		Seat seat = new Seat();
		modelMap.put("seat", seat);
		return "seat.index";
	}

	@RequestMapping(value = "findByRoom/{room_id}/{page}", method = RequestMethod.GET)
	public String findByRoom(@PathVariable("room_id") int room_id, ModelMap modelMap, HttpServletRequest request, @PathVariable("page") int page) {
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
		SeatsAPI seatAPI = APIClient.getClient().create(SeatsAPI.class);
		CinemaAPI cinemaAPI = APIClient.getClient().create(CinemaAPI.class);
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);		
		List<Seat> list = null;
		try {
			list = seatAPI.findByRoom(room_id).execute().body();
			modelMap.put("cinemas", cinemaAPI.findall().execute().body());
			modelMap.put("rooms",
					roomAPI.listByCinemaId(roomAPI.getById(room_id).execute().body().getCinema().getCinemaId())
							.execute().body());
			modelMap.put("cinemaId", roomAPI.getById(room_id).execute().body().getCinema().getCinemaId());
			modelMap.put("roomId", room_id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list == null) {
			return "redirect:/admin/seat/index";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("seats");
		int pagesize = 5;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		final int goToPage = page - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
		request.getSession().setAttribute("seats", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1;
		int end = totalPageCount < 5 ? totalPageCount : begin + 4;
		String baseUrl = "/admin/seat/findByRoom/" + room_id + "/";
		modelMap.addAttribute("beginIndex", begin);
		modelMap.addAttribute("endIndex", end);
		modelMap.addAttribute("currentIndex", current);
		modelMap.addAttribute("totalPageCount", totalPageCount);
		modelMap.addAttribute("baseUrl", baseUrl);
		modelMap.addAttribute("seats", pages);
		modelMap.put("title", "Seat");
		Seat seat = new Seat();
		modelMap.put("seat", seat);
		return "seat.index";
	}
}
