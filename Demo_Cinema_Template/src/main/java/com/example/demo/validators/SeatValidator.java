package com.example.demo.validators;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.demo.apis.APIClient;
import com.demo.apis.SeatsAPI;
import com.demo.entities.Seat;

@Component("seatValidator")
public class SeatValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Seat.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Seat seat = (Seat) target;
		SeatsAPI seatAPI = APIClient.getClient().create(SeatsAPI.class);
		List<Seat> seats = null;
		try {
			seats = seatAPI.findall().execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Seat item : seats) {
			if (item.getRoom().getRoomId() == seat.getRoom().getRoomId() && item.getNumber() == seat.getNumber()
					&& item.getRow().equalsIgnoreCase(seat.getRow()) && item.getSeat_id() != seat.getSeat_id()) {
				errors.rejectValue("number", "seat.number.exists");
			}
		}
		if (seat.getRoom().getRoomId() == 0) {
			errors.rejectValue("room", "room.choose");
		}
	}

}
