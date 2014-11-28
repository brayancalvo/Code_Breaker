package com.udea.appempresariales;

public class CodeBreaker {

	private String secretNumber;
	private final String cross = "X";
	private final String hyden = "-";
	
	public CodeBreaker(String secreNumber){
		setSecretNumber(secreNumber);
	}

	public String adivinar(String number){
		
		if(validaLetras(number) || validaLongitud(number)){
			return "error";
		}
		
		StringBuilder sospectNumber = new StringBuilder(); 
		StringBuilder secretNumberCopy = new StringBuilder(getSecretNumber()); 
		boolean [] states = new boolean [getSecretNumber().length()];
		
		for(int position = 0;position<secretNumber.length();position++){
			char first = getSecretNumber().charAt(position);
			char secund = number.charAt(position);
			
			if(first == secund){
				sospectNumber.append(cross);
				states[position] = true;				
			}
			else{
				secretNumberCopy.append(first);
			}
		}
		
		if(sospectNumber.length() < 4){
			
			for(int position = 0;position<secretNumber.length();position++){				
				char first = number.charAt(position);
				
				if(!states[position]){
					int flag = getSecretNumber().indexOf(first);
					if(flag != -1){
						sospectNumber.append(hyden);
						secretNumberCopy.deleteCharAt(position);
					}
				}
			}			
		}
		
		
		return sospectNumber.toString();
		
	}
	
	private boolean validaLetras(String number){
		for(int position=0;position<number.length();position++){
			char first = number.charAt(position);
			if(first < 48 || first > 57){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean validaLongitud(String number){
		if(number.length() != getSecretNumber().length()){
			return true;
		}
		
		return false;
		
	}
	
	public String getSecretNumber() {
		return secretNumber;
	}

	public void setSecretNumber(String secretNumber) {
		this.secretNumber = secretNumber;
	}


}
