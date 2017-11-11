package ch.ffhs.kino.saal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.ffhs.kino.saal.Seat.SeatType;

@ManagedBean
@SessionScoped
public class KinoSaalManager {

	ArrayList<Seat> allSeats = new ArrayList<Seat>();
	int columns_count = 16;
	int seats = 176;

	@PostConstruct
	public void init() {
		for (int i = 0; i < seats; i++) {

			Seat e = new Seat(i / columns_count, i % columns_count);
			allSeats.add(e);

		}

		allSeats.get(5).setType(SeatType.HANDYCAP);
		allSeats.get(6).setType(SeatType.HANDYCAP);
		allSeats.get(7).setType(SeatType.HANDYCAP);

		allSeats.get(100).setType(SeatType.PREMIUM);
		allSeats.get(101).setType(SeatType.PREMIUM);
		allSeats.get(102).setType(SeatType.PREMIUM);
		allSeats.get(104).setType(SeatType.PREMIUM);

		allSeats.get(40).setType(SeatType.SOLD);
		allSeats.get(41).setType(SeatType.SOLD);
		allSeats.get(42).setType(SeatType.SOLD);
		allSeats.get(66).setType(SeatType.SOLD);
		allSeats.get(67).setType(SeatType.SOLD);

		allSeats.get(88).setHidden(true);
		allSeats.get(98).setHidden(true);
		allSeats.get(101).setHidden(true);
		allSeats.get(157).setHidden(true);

	}

	public List<Integer> returnRows() {

		ArrayList<Integer> rows = new ArrayList<Integer>();
		for (int i = 0; i < seats / columns_count; i++) {
			rows.add(i);
		}
		return rows;

	}

	public List<Seat> returnOneRow(int row) {

		return allSeats.subList(columns_count * row, (columns_count * (row + 1)));

	}

	public void reserve(Seat s) {

		System.out.println("Seat " + s.toString() + "was reserved");

		if (s.isReserved()) {
			s.setReserved(false);
		} else {
			s.setReserved(true);
		}

	}

	public String style(Seat s) {

		if (s.isReserved()) {
			return "RESERVED";
		} else if (s.isHidden()) {
			return "HIDDEN";
		} else {

			return s.getType().toString();
		}

	}

	public List<Seat> returnMySeats() {

		List<Seat> mySeats = new ArrayList<Seat>();

		for (Seat seat : allSeats) {
			if (seat.isReserved()) {
				mySeats.add(seat);
			}
		}

		return mySeats;

	}

}
