package com.example.demo.validators;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.apis.APIClient;
import com.demo.apis.ScheduleAPI;
import com.demo.entities.Schedule;

@Component("scheduleValidator")
public class ScheduleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Schedule.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Schedule schedule = (Schedule) target;
		ScheduleAPI scheduleAPI = APIClient.getClient().create(ScheduleAPI.class);
		List<Schedule> schedules = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(schedule.getScheduleDate());
			try {
				schedules = scheduleAPI.findByDate(schedule.getScheduleDate()).execute().body();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (LocalTime.parse(schedule.getScheduleStart()).isAfter(LocalTime.parse(schedule.getScheduleEnd()))) {
			errors.rejectValue("scheduleEnd", "schedule.scheduleend");
		}
		if (new Date().compareTo(date) > 0) {
			errors.rejectValue("scheduleDate", "schedule.scheduledate");
		} else {
			if (schedules != null) {
				for (Schedule item : schedules) {
					if (LocalTime.parse(schedule.getScheduleStart()).isBefore(LocalTime.parse(item.getScheduleEnd()))&&item.getRoom().getRoomId()==schedule.getRoom().getRoomId()&&item.getScheduleDate().equalsIgnoreCase(schedule.getScheduleDate())&&item.getScheduleId()!=schedule.getScheduleId()) {
						errors.rejectValue("scheduleStart", "schedule.schedulestart");
					}
				}
			}
		}
		if(schedule.getMovie().getMovieId() == 0) {
			errors.rejectValue("movie", "movie.choose");
		}
		if(schedule.getRoom().getRoomId() == 0) {
			errors.rejectValue("room", "room.choose");
		}
	}

}
