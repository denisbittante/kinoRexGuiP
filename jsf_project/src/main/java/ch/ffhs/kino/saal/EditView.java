package ch.ffhs.kino.saal;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.ffhs.kino.saal.Seat.TicketType;

@ManagedBean(name = "dtEditView")
@ViewScoped
public class EditView implements Serializable {

	public List<TicketType> getTicketTypes() {

		ArrayList<TicketType> a = new ArrayList<TicketType>();
		a.add(TicketType.ADULT);
		a.add(TicketType.KIND);
		a.add(TicketType.SENIOR);
		a.add(TicketType.STUDENT);
		return a;
	}

	public void handleKeyEvent() {
	}

	public List<String> getYears() {

		List<String> options = new ArrayList<String>();
		DecimalFormat decim = new DecimalFormat("2000");
		for (int i = 17; i <= 27; i++) {
			options.add(decim.format(i));
		}
		return options;

	}

	public List<String> getMonths() {
		// Kreditkarten-Felder
		List<String> options = new ArrayList<String>();
		DecimalFormat decim = new DecimalFormat("00");
		for (int i = 1; i <= 12; i++) {
			options.add(decim.format(i));
		}
		return options;
	}

}