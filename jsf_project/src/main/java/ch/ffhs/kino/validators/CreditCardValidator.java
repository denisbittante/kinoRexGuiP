package ch.ffhs.kino.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ch.ffhs.kino.validators.CreditCardValidator")
public class CreditCardValidator implements Validator{

	@Override
	 public void validate(FacesContext ctx,UIComponent component,Object value) throws ValidatorException{
	    String ccNumber=(String)value;
	    boolean validCard = validateCard(ccNumber);
	    if (validCard==false) throw new ValidatorException(new FacesMessage("Keine gültige Kreditkarten-Nummer."));
	  }

	  private boolean validateCard(String ccNumber){

		// Gültige KeditkartenNr: 4916129201076959 (VISA), 5580742790142172 (MASTER CARD)
		int sum = 0;
		boolean alternate = false;
		ccNumber = ccNumber.replaceAll("[^0-9]", "");
		if(Integer.parseInt(ccNumber.substring(0,1))==4 && (ccNumber.length() != 13 && ccNumber.length() != 16)){
			// VISA (start with 4 and are either 13 or 16 digits in length)
			return false;
		}else if (Integer.parseInt(ccNumber.substring(0,2)) >= 51 && Integer.parseInt(ccNumber.substring(0,2)) <= 55 && ccNumber.length() != 16){
			// MASTER (are 16 digits in length and the first 2 digits range from 51 to 55)
			return false;
		}

		// Luhn validate
		for (int i = ccNumber.length() - 1; i >= 0; i--){
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate){
				n *= 2;
				if (n > 9)
					n = (n % 10) + 1;
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	  }
}
