package tracusa.beans;

import java.util.ArrayList;

public class ShipmentsTracusa {
	String idGuide;
	String reference;
	String observations;
	DeliveryTracusa delivery;
	ArrayList<TrackerTracusa> tracker;
	public String getIdGuide() {
		return idGuide;
	}
	public void setIdGuide(String idGuide) {
		this.idGuide = idGuide;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public DeliveryTracusa getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryTracusa delivery) {
		this.delivery = delivery;
	}
	public ArrayList<TrackerTracusa> getTracker() {
		return tracker;
	}
	public void setTracker(ArrayList<TrackerTracusa> tracker) {
		this.tracker = tracker;
	}
	
	
	
}
