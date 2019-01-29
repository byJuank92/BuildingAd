package main.java.utils;

import main.java.model.Advertisement;
import main.java.model.Photo;

public class CalculUtils {
	
	public CalculUtils() {
		
	}
	
	public static boolean hasPictures(final Advertisement advertisement) {
		return advertisement.getPictures().isEmpty()?Boolean.FALSE:Boolean.TRUE;
	}
	
	public static boolean hasDescription(final Advertisement advertisement) {
		return advertisement.getDescription().isEmpty()?Boolean.FALSE:Boolean.TRUE;
	}

	public static Integer calculatePicturesQualityScore(final Photo picture) {
		return isHD(picture)?20:10;
	}
	
	public static boolean isHD(final Photo picture) {
		return QualityValues.HD.equals(picture.getQuality());
	}
	
	public static boolean isFlatOrChalet(final Advertisement advertisement) {
		return TypologyValues.FLAT.equals(advertisement.getTypologyValues()) || TypologyValues.CHALET.equals(advertisement.getTypologyValues());
	}
	
	public static boolean isFlat(final Advertisement advertisement) {
		return TypologyValues.FLAT.toString().equalsIgnoreCase(advertisement.getTypologyValues().toString());
	}
	
	public static boolean isChalet(final Advertisement advertisement) {
		return TypologyValues.CHALET.toString().equalsIgnoreCase(advertisement.getTypologyValues().toString());
	}
	
	public static boolean higherEqualsToTwentyAndLowerThanFifty(final Integer wordsCount) {
		return (wordsCount.equals(20) || (wordsCount>20 && wordsCount<50));
	}
	
	public static boolean higherEqualsToFifty(final Integer wordsCount) {
		return wordsCount>=50;
	}
	
	public static boolean higherToFifty(final Integer wordsCount) {
		return wordsCount>50;
	}
}
