package com.example.demo.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Booking;
import com.demo.apis.APIClient;
import com.demo.apis.BookingAPI;



@Controller
@RequestMapping("/user/booking")
public class BookingAController {
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		request.getSession().setAttribute("bookings", null);
		return "redirect:/user/booking/page/1";
	}
	
	@RequestMapping(value = {"page/{pageNumber}"})
	public String showBookingPage(HttpServletRequest request, 
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
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("bookings");
		int pagesize = 3;
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		List<Booking> list = null;
		try {
			list = (List<Booking>) bookingAPI.listall().execute().body();
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
		request.getSession().setAttribute("bookings", pages);
		int current = pages.getPage() + 1;
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;	
		String baseUrl = "/user/booking/page/";
		
		modelMap.put("title", "Booking");
		modelMap.put("beginIndex", begin);
		modelMap.put("endIndex", end);
		modelMap.put("currentIndex", current);
		modelMap.put("totalPageCount", totalPageCount);
		modelMap.put("baseUrl", baseUrl);
		modelMap.put("bookings", pages);

		return "booking.index";
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
			return "redirect:/user/booking/index";	
		}	
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		List<Booking> list = null;
		try {
			list = bookingAPI.search(keyword).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		if (list == null) {	
			return "redirect:/user/booking/index";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("bookings");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = page - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("bookings", pages);	
		int current = pages.getPage() + 1;	
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;
		String baseUrl = "/user/booking/search/";	
		modelMap.addAttribute("beginIndex", begin);	
		modelMap.addAttribute("endIndex", end);	
		modelMap.addAttribute("currentIndex", current);	
		modelMap.addAttribute("totalPageCount", totalPageCount);	
		modelMap.addAttribute("baseUrl", baseUrl);	
		modelMap.addAttribute("bookings", pages);
		modelMap.put("title", "Booking");
		modelMap.put("keyword", keyword);
		modelMap.put("addUrl", "?keyword=" + keyword);
		return "booking.index";	
	}
	@RequestMapping(value = { "find/{page}" }, method = RequestMethod.GET)
	public String findByDate(ModelMap modelMap, @RequestParam("date") String date, HttpServletRequest request,@PathVariable("page") int page) {
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
		if (date.equals("")) {	
			return "redirect:/user/booking/index";	
		}	
		BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		List<Booking> list = null;
		try {
			list = bookingAPI.findByDate(date).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		if (list == null) {	
			return "redirect:/user/booking/index";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("bookings");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = page - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("bookings", pages);	
		int current = pages.getPage() + 1;	
		int totalPageCount = pages.getPageCount();
		int begin = current > 4 ? ((current + 4) > totalPageCount ? (totalPageCount - 4) : (current - 2)) : 1; 
		int end = totalPageCount < 5 ? totalPageCount : begin + 4 ;
		String baseUrl = "/user/booking/search/";	
		modelMap.addAttribute("beginIndex", begin);	
		modelMap.addAttribute("endIndex", end);	
		modelMap.addAttribute("currentIndex", current);	
		modelMap.addAttribute("totalPageCount", totalPageCount);	
		modelMap.addAttribute("baseUrl", baseUrl);	
		modelMap.addAttribute("bookings", pages);
		modelMap.put("title", "Booking");
		modelMap.put("date", date);
		modelMap.put("addUrl", "?date=" + date);
		return "booking.index";	
	}
}
