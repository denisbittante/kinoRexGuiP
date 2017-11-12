package ch.ffhs.kino.saal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.ffhs.kino.saal.Seat.SeatType;
import ch.ffhs.kino.saal.Seat.TicketType;

@ManagedBean(name = "kinoSaalManager")
@SessionScoped
public class BookingController {

	ArrayList<Seat> allSeats = new ArrayList<Seat>();
	int columns_count = 16;
	int seats = 176;

	private String paymentmethod = "false";

	Date timeout;
	private Integer timeoutSecond = 180;

	public Integer getTimeoutSecond() {
		return timeoutSecond;
	}

	public void setTimeoutSecond(Integer timeoutSecond) {
		this.timeoutSecond = timeoutSecond;
	}

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

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public void remainingSeconds() {
		timeoutSecond--;

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

	public String hasNoTickets() {
		if (returnMySeats().size() > 0) {
			return "false";
		}
		return "true";

	}

	public void resetReservedSeats() {
		for (Seat seat : allSeats) {

			seat.setReserved(false);
		}

	}

	public int count(String category) {

		TicketType valueOf = TicketType.valueOf(category);

		List<Seat> returnMySeats = returnMySeats();
		int count = 0;
		for (Seat seat : returnMySeats) {
			if (seat.getTicketType().equals(valueOf)) {
				count++;
			}
		}

		return count;
	}

	public double totalprice() {

		List<Seat> returnMySeats = returnMySeats();
		double total = 0.0;
		for (Seat seat : returnMySeats) {
			total += seat.getTicketType().getCost();
		}
		return total;
	}

	public String endSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "programm?faces-redirect=true";
	}

}
