package tracusa.beans;

public class DeliveryTracusa {
	String id;
	String route;
	String estimatedDate;
	boolean success;
	double latitude;
	double longitude;
	boolean signature;
	String signatureDate;
	String imageSignature;
	String deliveryDate;
	String signedBy;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getEstimatedDate() {
		return estimatedDate;
	}
	public void setEstimatedDate(String estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public boolean isSignature() {
		return signature;
	}
	public void setSignature(boolean signature) {
		this.signature = signature;
	}
	
	public String getImageSignature() {
		return imageSignature;
	}
	public void setImageSignature(String imageSignature) {
		this.imageSignature = imageSignature;
	}
	public String getSignatureDate() {
		return signatureDate;
	}
	public void setSignatureDate(String signatureDate) {
		this.signatureDate = signatureDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getSignedBy() {
		return signedBy;
	}
	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}
	
}
