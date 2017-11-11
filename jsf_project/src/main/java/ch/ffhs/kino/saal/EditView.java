package ch.ffhs.kino.saal;

import java.io.Serializable;
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

}