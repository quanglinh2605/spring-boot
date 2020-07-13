package com.example.demo.validators;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.apis.APIClient;
import com.demo.apis.RoomAPI;
import com.demo.entities.Room;

@Component("roomValidator")
public class RoomValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Room.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Room room = (Room) object;
		List<Room> rooms = null;
		RoomAPI roomAPI = APIClient.getClient().create(RoomAPI.class);
		try {
			rooms = roomAPI.findall().execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(room != null) {
			for (Room item : rooms) {
				if(item.getRoomName().equalsIgnoreCase(room.getRoomName()) && item.getCinema().getCinemaId()==room.getCinema().getCinemaId() && room.getRoomId() != item.getRoomId()) {
					errors.rejectValue("roomName", "room.roomname.exists");
				}
			}
		}
	}
}
