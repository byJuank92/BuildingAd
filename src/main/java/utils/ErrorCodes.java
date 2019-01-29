package main.java.utils;

public enum ErrorCodes {
	NOTVALID("Missing or invalid data for the advertisement: Typology [%s], Description [%s], HouseSize [%s], GardenSize[%s], Pictures [%s]");

	private String description;
	
	ErrorCodes(final String description){
		this.description = description;
	}
	
	public String description() {
		return description;
	}
}
