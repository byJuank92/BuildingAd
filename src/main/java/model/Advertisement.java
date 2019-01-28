package main.java.model;

import java.util.List;

import main.java.utils.TypologyValues;

public class Advertisement {
	
	private String description;
	private TypologyValues typologyValues;
	private Integer houseSize;
	private Integer gardenSize;
	private List<Photo> pictures;
	
	public Advertisement(String description, TypologyValues typologyValues, Integer houseSize, Integer gardenSize,
			List<Photo> pictures) {
		super();
		this.description = description;
		this.typologyValues = typologyValues;
		this.houseSize = houseSize;
		this.gardenSize = gardenSize;
		this.pictures = pictures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypologyValues getTypologyValues() {
		return typologyValues;
	}

	public void setTypologyValues(TypologyValues typologyValues) {
		this.typologyValues = typologyValues;
	}

	public Integer getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(Integer houseSize) {
		this.houseSize = houseSize;
	}

	public Integer getGardenSize() {
		return gardenSize;
	}

	public void setGardenSize(Integer gardenSize) {
		this.gardenSize = gardenSize;
	}

	public List<Photo> getPictures() {
		return pictures;
	}

	public void setPictures(List<Photo> pictures) {
		this.pictures = pictures;
	}
}
