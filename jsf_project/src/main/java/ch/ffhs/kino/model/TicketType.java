package ch.ffhs.kino.model;

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