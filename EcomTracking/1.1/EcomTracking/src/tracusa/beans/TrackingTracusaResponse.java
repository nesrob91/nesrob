/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracusa.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EACEVES
 */
public class TrackingTracusaResponse {
    
	String code;
    String message;
    ArrayList<ShipmentsTracusa> shipments;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<ShipmentsTracusa> getShipments() {
		return shipments;
	}
	public void setShipments(ArrayList<ShipmentsTracusa> shipments) {
		this.shipments = shipments;
	}
}
