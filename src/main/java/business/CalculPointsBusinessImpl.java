package main.java.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import main.java.model.Advertisement;
import main.java.model.Photo;
import main.java.utils.Keywords;
import main.java.utils.CalculUtils;

public class CalculPointsBusinessImpl implements CalculPointsBusiness {
	
	private static final Integer FOURTY = 40;

	@Override
	public Integer calculateAdsTotalScore(final Advertisement advertisement) {

		Integer score = FOURTY;
		if (!CalculUtils.hasPictures(advertisement)) {
			score -= 10;
		} else {
			calculatePictureScore(score, advertisement.getPictures());
		}
		if (CalculUtils.hasDescription(advertisement)) {
			score += 5;
			if (CalculUtils.isFlatOrChalet(advertisement)) {
				calculateDescriptionScore(score, advertisement);
			}
		}
		return score;
	}

	// private Integer calculatePictureScore(Integer score, final Photo... pictures)
	// {
	private void calculatePictureScore(Integer score, final List<Photo> pictures) {
		for (Photo picture : pictures) {
			score += CalculUtils.calculatePicturesQualityScore(picture);
		}
	}

	private void calculateDescriptionScore(Integer score, final Advertisement advertisement) {
		String description = advertisement.getDescription();
		Integer wordsCount = countWordsFromDescription(description);
		if (CalculUtils.isFlat(advertisement)) {
			score += extraPointsFlat(wordsCount) + bonusKeyWords(description);
		} else {
			score+= extraPointsChalet(wordsCount) + bonusKeyWords(description);
		}
	}

	private Integer countWordsFromDescription(final String description) { // int --> params advertisement
		if (description != null) { // || !description.isEmpty()) {
			StringTokenizer tokens = new StringTokenizer(description);
			return tokens.countTokens();
		} else {
			return 0;
		}
	}

	private Integer extraPointsFlat(final Integer wordsCount) {
		Integer extraPoints = 0;
		if (CalculUtils.higherEqualsToTwentyAndLowerThanFifty(wordsCount)) {
			extraPoints += 10;
		} else if (CalculUtils.higherEqualsToFifty(wordsCount)) {
			extraPoints += 30;
		}
		return extraPoints;
	}
	
	private Integer extraPointsChalet(final Integer wordsCount) {
		Integer extraPoints = 0;
		if (CalculUtils.higherToFifty(wordsCount)) {
			extraPoints += 20;
		}
		return extraPoints;
	}

	private Integer bonusKeyWords(final String description) {
		Integer bonusCount = 0;
		List<String> words = new ArrayList<String>(Arrays.asList(description.split("¿?,\\s+!¡;.\n")));
		for (String keyword : words) {
			if (Keywords.CÉNTRICO.toString().equalsIgnoreCase(keyword)) { // TODO should be done in just one condition
				bonusCount += 5;
			} else if (Keywords.CÉNTRICO.toString().equalsIgnoreCase(keyword)) {
				bonusCount += 5;
			} else if (Keywords.CÉNTRICO.toString().equalsIgnoreCase(keyword)) {
				bonusCount += 5;
			}
		}
		return bonusCount;
	}
}
