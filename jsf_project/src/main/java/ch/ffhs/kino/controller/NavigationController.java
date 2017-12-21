package ch.ffhs.kino.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigationController")
@SessionScoped
public class NavigationController {
	private boolean step1Disabled = false; // programm
	private boolean step2Disabled = true;  // movieshow
	private boolean step3Disabled = true;  // payment
	private boolean step4Disabled = true;  // confirm
	
	private boolean step1Active = true;
	private boolean step2Active = false;
	private boolean step3Active = false;
	private boolean step4Active = false;
	
	// programm
	public String goToStep1(){
		setStatusStep1();
		return "index.jsf";
	}
	
	// movieshow
	public String goToStep2(){
		setStatusStep2();
		return "movieShow.jsf";
	}
	
	// payment
	public String goToStep3(){
		setStatusStep3();
		return "payment.jsf";
	}	
	
	// confirm
	public String goToStep4(){
		setStatusStep4();
		return "bookingConfirm.jsf";
	}

	public void setStatusStep1(){
		step1Disabled = false;
		step2Disabled = true;
		step3Disabled = true;
		step4Disabled = true;
		
		step1Active = true;
		step2Active = false;
		step3Active = false;
		step4Active = false;
	}
	
	public void setStatusStep2(){
		step1Disabled = false;
		step2Disabled = false;
		step3Disabled = true;
		step4Disabled = true;
		
		step1Active = false;
		step2Active = true;
		step3Active = false;
		step4Active = false;
	}
	
	public void setStatusStep3(){
		step1Disabled = false;
		step2Disabled = false;
		step3Disabled = false;
		step4Disabled = true;
		
		step1Active = false;
		step2Active = false;
		step3Active = true;
		step4Active = false;
	}	

	public void setStatusStep4(){
		step1Disabled = false;
		step2Disabled = true;
		step3Disabled = true;
		step4Disabled = true;
		
		step1Active = false;
		step2Active = false;
		step3Active = false;
		step4Active = true;
	}
	
	// #### getters and setters ####
	public boolean isStep1Disabled() {
		return step1Disabled;
	}
	public void setStep1Disabled(boolean step1Disabled) {
		this.step1Disabled = step1Disabled;
	}
	public boolean isStep2Disabled() {
		return step2Disabled;
	}
	public void setStep2Disabled(boolean step2Disabled) {
		this.step2Disabled = step2Disabled;
	}
	public boolean isStep3Disabled() {
		return step3Disabled;
	}
	public void setStep3Disabled(boolean step3Disabled) {
		this.step3Disabled = step3Disabled;
	}	
	public boolean isStep4Disabled() {
		return step4Disabled;
	}
	public void setStep4Disabled(boolean step4Disabled) {
		this.step4Disabled = step4Disabled;
	}
	public boolean isStep1Active() {
		return step1Active;
	}
	public void setStep1Active(boolean step1Active) {
		this.step1Active = step1Active;
	}
	public boolean isStep2Active() {
		return step2Active;
	}
	public void setStep2Active(boolean step2Active) {
		this.step2Active = step2Active;
	}
	public boolean isStep3Active() {
		return step3Active;
	}
	public void setStep3Active(boolean step3Active) {
		this.step3Active = step3Active;
	}
	public boolean isStep4Active() {
		return step4Active;
	}
	public void setStep4Active(boolean step4Active) {
		this.step4Active = step4Active;
	}
}
