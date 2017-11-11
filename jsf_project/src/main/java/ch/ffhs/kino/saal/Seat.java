package ch.ffhs.kino.saal;

public class Seat {

	public enum SeatType {
		NORMAL, PREMIUM, HANDYCAP, NONE, SOLD;

		@Override
		public String toString() {
			return name();
		}
	}

	public enum TicketType {
		KIND(8.50, "Kind"), ADULT(19.00, "Erwachsene"), STUDENT(11.50, "Student"), SENIOR(9.00, "Senior");

		private double cost;
		private String title;

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		TicketType(double cost, String title) {
			this.cost = cost;
			this.title = title;
		}
	}

	private Integer seatRow;
	private Integer seatColumn;
	private boolean reserved;
	private boolean hidden = false;
	private SeatType type = SeatType.NORMAL;
	private TicketType ticketType = TicketType.ADULT;

	public SeatType getType() {
		return type;
	}

	public void setType(SeatType type) {
		this.type = type;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Seat(Integer seatRow, Integer seatColumn) {
		this.seatRow = seatRow;
		this.seatColumn = seatColumn;
	}

	public Integer getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}

	public Integer getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(Integer seatColumn) {
		this.seatColumn = seatColumn;
	}

	@Override
	public String toString() {
		return "Reihe " + (getSeatRow() + 1) + ", Platz " + (getSeatColumn() + 1);
	}
}
