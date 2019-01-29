package main.java.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import main.java.model.Advertisement;
import main.java.utils.CalculUtils;
import main.java.utils.TypologyValues;

public class AdvertisementValidatorImpl extends CommonValidator implements ConstraintValidator<AdvertisementValidator, Advertisement>{

	@Override
	public boolean isValid(final Advertisement advertisement, final ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		
		boolean valid = advertisementIsComplete(advertisement);
		
		if(!valid) {
			
		}
		return valid;
	}
	
	/*
	 * 
	 * 
	 * ◦ Que el anuncio esté completo también aporta puntos. Para considerar un
	 * anuncio completo este tiene que tener descripción, al menos una foto y los
	 * datos particulares de cada tipología, esto es, en el caso de los pisos tiene
	 * que tener también tamaño de vivienda, en el de los chalets, tamaño de
	 * vivienda y de jardín. Además, excepcionalmente, en los garajes no es
	 * necesario que el anuncio tenga descripción. Si el anuncio tiene todos los
	 * datos anteriores, proporciona otros 40 puntos.
	 * 
	 * */
	
	private boolean advertisementIsComplete(final Advertisement advertisement) {
		boolean complete = CalculUtils.hasPictures(advertisement);
		String typology = advertisement.getTypologyValues().toString(); //.name();
		complete &= (completeFlat(advertisement, typology)
				   ||completeChalet(advertisement, typology)
				   ||completeGarage(advertisement, typology));
	}
	
	private boolean completeFlat(final Advertisement advertisement, final String typology) {
		return isFlat(typology) && advertisement.getHouseSize()!=null && CalculUtils.hasDescription(advertisement);
	}
	
	private boolean completeChalet(final Advertisement advertisement, final String typology) {
		return isChalet(typology) && advertisement.getHouseSize()!=null && advertisement.getGardenSize()!=null && CalculUtils.hasDescription(advertisement);
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
