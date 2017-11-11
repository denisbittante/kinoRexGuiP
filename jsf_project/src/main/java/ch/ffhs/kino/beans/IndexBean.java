package ch.ffhs.kino.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

	public List<Integer> getValues() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			values.add(i);
		}
		return values;
	}

	public List<Integer> rowNumbers(final int max) {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < max; i++) {
			values.add(i);
		}
		return values;
	}
}