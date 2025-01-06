package it.polito.ski;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class Parking {
	private String name;
	private Integer numberOfSlots;
	private ArrayList<String> servedLifts;
	
	public Parking(String name, Integer numberOfSlots) {
		super();
		this.name = name;
		this.numberOfSlots = numberOfSlots;
		servedLifts=new ArrayList<>();
	}

	public ArrayList<String> getServedLifts() {
		return servedLifts;
	}

	public void setServedLifts(ArrayList<String> servedLifts) {
		this.servedLifts = servedLifts;
	}
	
	public void addNewLifts(String x) {
		servedLifts.add(x);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfSlots() {
		return numberOfSlots;
	}

	public void setNumberOfSlots(Integer numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}
	
}
