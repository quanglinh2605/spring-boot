package com.example.demo.controllers.employee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.AllSchedule;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Movie;
import com.example.demo.entities.Schedule;
import com.example.demo.entities.ScheduleOut;
import com.example.demo.entities.Seat;
import com.example.demo.entities.TimeSchedule;
import com.example.demo.models.BookingModel;
import com.example.demo.models.MovieModel;
import com.example.demo.models.ScheduleModel;
import com.example.demo.models.SeatModel;

@Controller
@RequestMapping(value = { "schedule" })
public class ScheduleController {

	ScheduleModel scheduleModel = new ScheduleModel();

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.put("schedules", scheduleModel.findAll());
		return "schedule.index1";
	}

	@RequestMapping(value = { "movie/{movie_id}/{date}" }, method = RequestMethod.GET)
	public String index2(@PathVariable("movie_id") int movie_id, @PathVariable("date") int date, ModelMap map) {

		String now = null;
		List<Schedule> schedules = new ArrayList<Schedule>();
		if (date == 0) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			now = format.format(new Date());
		} else {
			now = "00:00:00";

		}
		schedules = scheduleModel.findScheduleByMovie(movie_id, date, now);

		Schedule schedule = new Schedule();
		List<ScheduleOut> lisScheduleOuts = new ArrayList<ScheduleOut>();

		// lay nhung room trong schedule xem co schedule nao trung room ko
		List<Integer> arrRoom = new ArrayList<Integer>();

		for (Schedule s : schedules) {
			String room_id = s.getRoom().getRoomId();
			arrRoom.add(new Integer(Integer.parseInt(room_id)));
		}

		// loc nhung schedule co trung room id
		List<Integer> listRoom = new ArrayList<Integer>();
		for (int i = 0; i < arrRoom.size(); i++) {
			if (!listRoom.contains(arrRoom.get(i))) {
				listRoom.add(arrRoom.get(i));
			}
		}
		// lay nhung schedule cua phim co cung room ma khac gio chieu
		List<Schedule> schedules2 = new ArrayList<Schedule>();
		for (int room_id : listRoom) {
			List<TimeSchedule> timeSchedules = new ArrayList<TimeSchedule>();

			schedules2 = scheduleModel.findScheduleByMovieRoom(movie_id, room_id, date, now);
			int schedule_id = 0;
			for (Schedule sche : schedules2) {

				int id = Integer.parseInt(sche.getScheduleId());
				String scheduleTime = sche.getScheduleStart();
				System.out.println(scheduleTime);
				// xem lịch trình này còn bao nhiêu ghế trống
				BookingModel bookingModel = new BookingModel();
				List<Booking> bookings = bookingModel.findByScheduleId(Integer.parseInt(sche.getScheduleId()));
				SeatModel seatModel = new SeatModel();
				List<Seat> seats = seatModel.findByRoomId(Integer.parseInt(sche.getRoom().getRoomId()));
				int seatAvailable = seats.size() - bookings.size();
				// add time vào list time
				timeSchedules.add(new TimeSchedule(id, scheduleTime, seatAvailable));
				System.out.println(id);
				schedule_id = id;
			}

			// add Schedule đại diện mà sẽ bị trùng vào lisSchedule
			schedule = scheduleModel.findSchedule(schedule_id);
			String CinemaName = schedule.getRoom().getCinema().getCinemaName().toString();
			String RoomName = schedule.getRoom().getRoomName().toString();
			ScheduleOut out = new ScheduleOut(CinemaName, RoomName, timeSchedules);
			lisScheduleOuts.add(out);
		}

		MovieModel movieModel = new MovieModel();
		Movie movie = movieModel.findMovieById(movie_id);

		map.put("movie", movie);
		map.put("schedules", lisScheduleOuts);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		Date datex = new Date();
		Date datex1 = new Date();
		Date datex2 = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(datex);
		c.add(Calendar.DATE, 1);
		datex1 = c.getTime();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(datex);
		c2.add(Calendar.DATE, 2);
		datex2 = c2.getTime();
		map.put("date", dateFormat.format(datex));
		map.put("date1", dateFormat.format(datex1));
		map.put("date2", dateFormat.format(datex2));
		return "schedule.index2";
	}

	@RequestMapping(value = { "book/{schedule_id}" }, method = RequestMethod.GET)
	public String index3(@PathVariable("schedule_id") int schedule_id, ModelMap map) {
		ScheduleModel model = new ScheduleModel();
		Schedule schedule = model.findSchedule(schedule_id);
		int movie_id = Integer.parseInt(schedule.getMovie().getMovieId());

		return "redirect:/booking/book/" + schedule_id;
	}

	@RequestMapping(value = { "all" }, method = RequestMethod.GET)
	public String index4(ModelMap map) {
		List<Schedule> AllSchedules = new ArrayList<Schedule>();
		AllSchedules = scheduleModel.findAll();
		List<Integer> arrMovie = new ArrayList<Integer>();
		for (Schedule s : AllSchedules) {
			String movie_id = s.getMovie().getMovieId();
			arrMovie.add(new Integer(Integer.parseInt(movie_id)));
		}
		List<Integer> ListMovie = new ArrayList<Integer>();
		for (int i = 0; i < arrMovie.size(); i++) {
			if (!ListMovie.contains(arrMovie.get(i))) {
				ListMovie.add(arrMovie.get(i));
			}
		}
		String now = null;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		now = format.format(new Date());
		List<AllSchedule> allSchedules = new ArrayList<AllSchedule>();
		for (Integer m : ListMovie) {

			List<Schedule> schedules = new ArrayList<Schedule>();
			schedules = scheduleModel.findScheduleByMovie(m, 0, now);

			Schedule schedule = new Schedule();
			List<ScheduleOut> lisScheduleOuts = new ArrayList<ScheduleOut>();

			// lay nhung room trong schedule xem co schedule nao trung room ko
			List<Integer> arrRoom = new ArrayList<Integer>();

			for (Schedule s : schedules) {
				String room_id = s.getRoom().getRoomId();
				arrRoom.add(new Integer(Integer.parseInt(room_id)));
			}

			// loc nhung schedule co trung room id
			List<Integer> listRoom = new ArrayList<Integer>();
			for (int i = 0; i < arrRoom.size(); i++) {
				if (!listRoom.contains(arrRoom.get(i))) {
					listRoom.add(arrRoom.get(i));
				}
			}
			// lay nhung schedule cua phim co cung room ma khac gio chieu
			List<Schedule> schedules2 = new ArrayList<Schedule>();
			for (int room_id : listRoom) {
				List<TimeSchedule> timeSchedules = new ArrayList<TimeSchedule>();

				schedules2 = scheduleModel.findScheduleByMovieRoom(m, room_id, 0, now);
				int schedule_id = 0;
				for (Schedule sche : schedules2) {

					int id = Integer.parseInt(sche.getScheduleId());
					String scheduleTime = sche.getScheduleStart();
					System.out.println(scheduleTime);
					// xem lịch trình này còn bao nhiêu ghế trống
					BookingModel bookingModel = new BookingModel();
					List<Booking> bookings = bookingModel.findByScheduleId(Integer.parseInt(sche.getScheduleId()));
					SeatModel seatModel = new SeatModel();
					List<Seat> seats = seatModel.findByRoomId(Integer.parseInt(sche.getRoom().getRoomId()));
					int seatAvailable = seats.size() - bookings.size();
					// add time vào list time
					timeSchedules.add(new TimeSchedule(id, scheduleTime, seatAvailable));
					System.out.println(id);
					schedule_id = id;
				}

				// add Schedule đại diện mà sẽ bị trùng vào lisSchedule
				schedule = scheduleModel.findSchedule(schedule_id);
				String CinemaName = schedule.getRoom().getCinema().getCinemaName().toString();
				String RoomName = schedule.getRoom().getRoomName().toString();
				ScheduleOut out = new ScheduleOut(CinemaName, RoomName, timeSchedules);
				lisScheduleOuts.add(out);
			}

			MovieModel movieModel = new MovieModel();
			Movie movie = movieModel.findMovieById(m);
			allSchedules.add(new AllSchedule(movie, lisScheduleOuts));

			/*
			 * map.put("movie", movie); map.put("schedules", lisScheduleOuts);
			 */
		}
		map.put("allSchedule", allSchedules);
		return "schedule.index1";
	}

}
