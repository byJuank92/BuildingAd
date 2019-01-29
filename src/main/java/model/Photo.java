package main.java.model;

import java.net.URL;

import javax.validation.Valid;

import main.java.utils.QualityValues;

public class Photo {

	@Valid
	private URL url;
	@Valid
	private QualityValues quality;
	
	public Photo(URL url, QualityValues quality) {
		super();
		this.url = url;
		this.quality = quality;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public QualityValues getQuality() {
		return quality;
	}

	public void setQuality(QualityValues quality) {
		this.quality = quality;
	}
}
