package com.example.demo.controllers.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.apis.ReportAPI;
import com.demo.entities.CinemaEntity;
import com.example.demo.apis.APIClient;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin/report")
public class ReportController {
	
	@RequestMapping(value = {"","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpServletRequest request) {
		ReportAPI reportAPI = APIClient.getClient().create(ReportAPI.class);
		try {
			modelMap.put("bookings", reportAPI.bookingToday(LocalDate.now().toString()).execute().body());
			modelMap.put("total", reportAPI.total(String.valueOf(LocalDateTime.now().getMonthValue())).execute().body());	
			modelMap.put("cinemas", reportAPI.bestCinema(String.valueOf(LocalDateTime.now().getMonthValue())).execute().body());
			modelMap.put("title","Report");
			modelMap.put("month", LocalDateTime.now().getMonthValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "report.index";
	}
	
	@ResponseBody
	@RequestMapping(value = "findByMonth/{month}", method = RequestMethod.GET)
	public String findByMonth(@PathVariable("month") String month) {
		Gson gson = new Gson();
		ReportAPI reportAPI = APIClient.getClient().create(ReportAPI.class);
		List<CinemaEntity> result = null;
		try {
			result = reportAPI.bestCinema(month).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return gson.toJson(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "totalByMonth/{month}", method = RequestMethod.GET)
	public String totalByMonth(@PathVariable("month") String month) {
		Gson gson = new Gson();
		ReportAPI reportAPI = APIClient.getClient().create(ReportAPI.class);
		double result = 0;
		try {
			result = reportAPI.total(month).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return gson.toJson(result);
	}
}
