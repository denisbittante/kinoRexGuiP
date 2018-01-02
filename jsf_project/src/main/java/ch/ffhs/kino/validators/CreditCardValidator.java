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
	    // get the card type form the binding object instead of the model object
//	    HtmlSelectOneListBox cardChoiceComp= (HtmlSelectOneListBox) context.getApplication().createValueBinding("#{backing_requestscope.cardTypeChoice}").getValue(context);
//	    int cardType = ((Integer)cardChoiceComp.getValue()).intValue();

	    System.out.println("ccNumber: " + ccNumber);
	    boolean validCard = validateCard(ccNumber);
	    if (validCard==false) throw new ValidatorException(new FacesMessage(" Invalid credit card format!!!!"));
	  }

	  private boolean validateCard(String ccNumber){
//	     // visa cards always start with 4 and are either 13 or 16 digits in length
//	     final int VISA=1;
//	     // master cards are 16 digits in length and the first 2 digits range from 51 to 55
//	     final int MASTER=2;
//	     // Amex cards are 15 digits in length and the first 2 digits range from 34 to 37
//	     final int AMEX=3;
//	     switch(cardType) {
//	       case VISA:
//	                if ((ccNumber.length() != 13 && ccNumber.length() != 16) ||
//	                      Integer.parseInt(ccNumber.substring(0,1))!=4)
//	                    return false;
//	                break;
//	       case MASTER:
//	                if (ccNumber.length() != 16 ||
//	                       Integer.parseInt(ccNumber.substring(0,2)) <> 55)
//	                    return false;
//	                break;
////	       case AMEX:
////	                if (ccnum.length() != 15 ||
////	                      (Integer.parseInt(ccnum.substring(0,2)) != 34 &&
////	                       Integer.parseInt(ccnum.substring(0,2))) != 37))
////	                    return false;
////	                break;
//	     }

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
