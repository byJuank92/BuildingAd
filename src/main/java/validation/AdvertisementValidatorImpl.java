package main.java.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import main.java.model.Advertisement;
import main.java.utils.CalculUtils;
import main.java.utils.TypologyValues;
import static main.java.utils.ErrorCodes.NOTVALID;

public class AdvertisementValidatorImpl extends CommonValidator
		implements ConstraintValidator<AdvertisementValidator, Advertisement> {

	@Override
	public boolean isValid(final Advertisement advertisement, final ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();

		boolean valid = advertisementIsComplete(advertisement);

		if (!valid) {
			addError(context, NOTVALID.name(),
					String.format(NOTVALID.description(), advertisement.getTypologyValues(), advertisement.getDescription(),
						    advertisement.getHouseSize(), advertisement.getGardenSize(), 
						    advertisement.getPictures()));
		}
		return valid;
	}

	private boolean advertisementIsComplete(final Advertisement advertisement) {
		boolean complete = CalculUtils.hasPictures(advertisement);
		String typology = advertisement.getTypologyValues().toString(); // .name();
		return complete &= (completeFlat(advertisement, typology) || completeChalet(advertisement, typology)
				|| completeGarage(advertisement, typology));
	}

	private boolean completeFlat(final Advertisement advertisement, final String typology) {
		return isFlat(typology) && advertisement.getHouseSize() != null && CalculUtils.hasDescription(advertisement);
	}

	private boolean completeChalet(final Advertisement advertisement, final String typology) {
		return isChalet(typology) && advertisement.getHouseSize() != null && advertisement.getGardenSize() != null
				&& CalculUtils.hasDescription(advertisement);
	}

	private boolean completeGarage(final Advertisement advertisement, final String typology) {
		return isGarage(typology);
	}

	private boolean isFlat(final String typologyValues) {
		return TypologyValues.FLAT.toString().equalsIgnoreCase(typologyValues);
	}

	private boolean isChalet(final String typologyValues) {
		return TypologyValues.CHALET.toString().equalsIgnoreCase(typologyValues);
	}

	private boolean isGarage(final String typologyValues) {
		return TypologyValues.GARAGE.toString().equalsIgnoreCase(typologyValues);
	}
}
