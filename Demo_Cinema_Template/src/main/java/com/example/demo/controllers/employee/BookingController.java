package com.example.demo.controllers.employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.apis.APIClient;
import com.example.demo.apis.BookingAPI;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Cols;
import com.example.demo.entities.Combo;
import com.example.demo.entities.RowCol;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.Seat;
import com.example.demo.entities.User;
import com.example.demo.models.BookingModel;
import com.example.demo.models.ComboModel;
import com.example.demo.models.ScheduleModel;
import com.example.demo.models.SeatModel;
import com.example.demo.services.PaypalService;

@Controller
@RequestMapping(value = { "booking" })
public class BookingController {

	@Autowired
	private PaypalService paypalService;

	// danh sach booking
	@RequestMapping(value = { "book/{schedule_id}" }, method = RequestMethod.GET)
	public String index(@PathVariable("schedule_id") int schedule_id, ModelMap modelMap, HttpServletRequest request) {
		ScheduleModel scheduleModel = new ScheduleModel();
		SeatModel seatModel = new SeatModel();
		BookingModel bookingModel = new BookingModel();
		Schedule schedule = scheduleModel.findSchedule(schedule_id);
		List<Seat> seats = null;
		User user = new User();
		user = (User) request.getSession().getAttribute("currentUser");
		if (user != null) {
			modelMap.put("user", user);
		} else {
			return "redirect:/login";
		}

		int room_id = Integer.parseInt(schedule.getRoom().getRoomId());
		try {
			seats = new ArrayList<Seat>();
			seats = seatModel.findByRoomId(room_id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<String> row = new ArrayList<String>();
		List<RowCol> rowCols = new ArrayList<RowCol>();
		// lay ra tat ca cac hang
		for (Seat s : seats) {
			row.add(s.getRow().trim().toLowerCase().toString());
		}
		// lay ra nhung hang khong trung nhau
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < row.size(); i++) {
			if (!temp.contains(row.get(i))) {
				temp.add(row.get(i).toString());
			}
		}
		List<Booking> bookings = bookingModel.findByScheduleId(schedule_id);
		// tim theo tung hang so ghe trong hang do
		for (String row1 : temp) {
			List<Cols> cols = new ArrayList<Cols>();
			String imgChar = "seat_icon.png";
			// duyet qua cac cho ngoi
			List<Seat> arraySeat = new ArrayList<Seat>();
			for (Seat s : seatModel.selectByRow(row1, room_id)) {
				arraySeat.add(s);
			}
			// chay qua day ghe co 5 cho ngoi xem co duoc dat het 5 cho khong
			int step = 1;
			for (int i = 1; i <= arraySeat.size(); i++) {
				Seat s = new Seat();
				if (arraySeat.size() < i) {
					s = arraySeat.get(i - 2);
				} else {
					s = arraySeat.get(i - step);
				}

				/*
				 * if (s.getNumber().contains(String.valueOf(i))) { for (Booking b : bookings) {
				 * if (b.getSeat().getSeatId().equalsIgnoreCase(s.getSeatId())) { imgChar =
				 * "seat_checked.png"; } } cols.add(new Cols(Integer.parseInt(s.getSeatId()),
				 * s.getNumber(), imgChar)); imgChar = "seat_icon.png"; } else {
				 * 
				 * cols.add(new Cols(0, null, null)); step++; }
				 */
				for (Booking b : bookings) {
					if (b.getSeat().getSeatId().equalsIgnoreCase(s.getSeatId())) {
						imgChar = "seat_checked.png";
					}
				}
				cols.add(new Cols(Integer.parseInt(s.getSeatId()), s.getNumber(), imgChar));
				imgChar = "seat_icon.png";
				if(i==5) break;
			}
			rowCols.add(new RowCol(row1, cols));
		}

		modelMap.put("booking", bookings);
		modelMap.put("rowCol", rowCols);
		modelMap.put("schedule", schedule);
		modelMap.put("title", "Booking | Cinema XXII");
		// lay user da dang nhap

		return "booking.index1";

	}

	// book
	@RequestMapping(value = { "book/{schedule_id}/{seat_id}" }, method = RequestMethod.GET)
	public String index2(@PathVariable("schedule_id") int schedule_id, @PathVariable("seat_id") int seat_id,
			ModelMap modelMap, HttpServletRequest request) {

		SeatModel seatModel = new SeatModel();
		ScheduleModel scheduleModel = new ScheduleModel();
		ComboModel comboModel = new ComboModel();

		List<Combo> combos = comboModel.findAll();
		Schedule schedule = scheduleModel.findSchedule(schedule_id);

		Seat seat = seatModel.findSeatById(seat_id);

		// price
		int price = 4;
		if (seat.getSeatType().equalsIgnoreCase("2")) {
			price = 5;
		} else if (seat.getSeatType().equalsIgnoreCase("1")) {
			price = 4;
		}
		String time = schedule.getScheduleStart();
		String[] timeout = time.split(":", 0);
		if (Integer.parseInt(timeout[0]) >= 18) {
			price += 10000;
		}

		modelMap.put("price", price);
		modelMap.put("combos", combos);
		modelMap.put("title", "Booking | Cinema XXII");
		modelMap.put("booking", new Booking());
		// lay user da dang nhap
		User user = new User();
		user = (User) request.getSession().getAttribute("currentUser");
		modelMap.put("user", user);
		modelMap.put("seat", seat);
		modelMap.put("schedule", schedule);
		return "booking.index2";

	}

	@RequestMapping(value = "book/{schedule_id}/{seat_id}", method = RequestMethod.POST)
	public String save(@PathVariable("schedule_id") int schedule_id, @PathVariable("seat_id") int seat_id,
			@ModelAttribute("booking") Booking booking, @RequestParam("Combo1") String Combo1,
			@RequestParam("Combo2") String Combo2, @RequestParam("Combo3") String Combo3, HttpServletRequest request) {
		Seat seat = new Seat();
		SeatModel seatModel = new SeatModel();
		ScheduleModel scheduleModel = new ScheduleModel();

		Schedule schedule = scheduleModel.findSchedule(schedule_id);
		seat = seatModel.findSeatById(seat_id);

		// price
		int price = 4;
		if (seat.getSeatType().equalsIgnoreCase("2")) {
			price = 5;
		} else if (seat.getSeatType().equalsIgnoreCase("1")) {
			price = 4;
		}
		String time = schedule.getScheduleStart();
		String[] timeout = time.split(":", 0);
		if (Integer.parseInt(timeout[0]) >= 18) {
			price += 1;
		}
		price += Integer.parseInt(Combo1) * 1 + Integer.parseInt(Combo2) * 2 + Integer.parseInt(Combo3) * 3;
		/*
		 * if(booking.getComboWater().contains("Combo 1")) { price +=25000; }else
		 * if(booking.getComboWater().contains("Combo 2")) { price +=35000; }else
		 * if(booking.getComboWater().contains("Combo 3")) { price +=45000; }else
		 * if(booking.getComboWater().contains("Combo 1,Combo 3")) { price +=65000;
		 * }else if(booking.getComboWater().contains("Combo 2,Combo 3")) { price
		 * +=75000; }else if(booking.getComboWater().contains("Combo 1,Combo 2")) {
		 * price +=55000; }else
		 * if(booking.getComboWater().contains("Combo 1,Combo 2,Combo 3")) { price
		 * +=95000; }
		 */
		List<Combo> combos = new ArrayList<Combo>();
		if (!Combo1.equals("0")) {
			combos.add(new Combo(Combo1, "Combo1", 1));
		}
		if (!Combo2.equals("0")) {
			combos.add(new Combo(Combo2, "Combo2", 2));
		}
		if (!Combo3.equals("0")) {
			combos.add(new Combo(Combo3, "Combo3", 3));
		}
		String combo = null;
		if (price > 4) {
			combo = (!Combo1.equals("0") ? "Combo1: " + Combo1 : "")  + (!Combo2.equals("0") ? "  Combo2: " + Combo2 : "") + (!Combo3.equals("0") ? "  Combo3: " + Combo3 : "");
		}

		booking.setBookingDate(LocalDate.now().toString());
		booking.setComboWater(combo);
		booking.setPrice(String.valueOf(price));
		booking.setSchedule(schedule);
		booking.setSeat(seat);
		// lay user da dang nhap
		User user = new User();
		user = (User) request.getSession().getAttribute("currentUser");
		booking.setUser(user);
		/*
		 * try { BookingAPI bookingAPI = APIClient.getClient().create(BookingAPI.class);
		 * bookingAPI.booking(booking).enqueue(new Callback<Booking>() {
		 * 
		 * public void onResponse(Call<Booking> call, Response<Booking> response) {
		 * 
		 * try { System.out.println("Status code: " + response.code());
		 * System.out.println("Is success: " + response.isSuccessful()); } catch
		 * (Exception e) { System.out.println(e.getMessage()); } }
		 * 
		 * public void onFailure(Call<Booking> call, Throwable t) {
		 * System.out.println(t.getMessage()); } });
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); }
		 */
		request.getSession().setAttribute("booking", booking);
		request.getSession().setAttribute("combos", combos);
		return "redirect:/booking/payment";

	}

	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String payment(ModelMap modelMap) {
		modelMap.put("paypalConfig", paypalService.getPayPalConfig());
		return "booking.payment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String payment() {
		return "booking.success";
	}

	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String Success(HttpServletRequest request) {
		Booking booking = new Booking();
		booking = (Booking) request.getSession().getAttribute("booking");
		BookingAPI api = APIClient.getClient().create(BookingAPI.class);
		try {
			api.booking(booking).execute().body();
			request.getSession().setAttribute("booking", null);
			request.getSession().setAttribute("combos", null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "booking.success";
	}
}
