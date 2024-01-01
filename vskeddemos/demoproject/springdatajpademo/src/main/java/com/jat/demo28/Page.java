package com.jat.demo28;

import java.util.LinkedList;
import java.util.List;

public class Page {
	List<String> conditions = new LinkedList<String>();

	public List<String> getConditions() {
		return conditions;
	}

	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}
	
	public Page() {
	}

	public Page(List<String> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		return "Page [conditions=" + conditions + "]";
	}

}
