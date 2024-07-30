package br.edu.unoesc.service.validator;

public class ValidadorCpf {

	public class CpfValidator {
	    
	    public static boolean isValid(String cpf) {
	        if (cpf == null || cpf.length() != 11 || cpf.matches("\\d{11}")) {
	            return false;
	        }

	        int sum = 0;
	        int weight = 10;
	        for (int i = 0; i < 9; i++) {
	            sum += Character.getNumericValue(cpf.charAt(i)) * weight--;
	        }
	        
	        int firstDigit = calculateDigit(sum);
	        sum = 0;
	        weight = 11;
	        for (int i = 0; i < 9; i++) {
	            sum += Character.getNumericValue(cpf.charAt(i)) * weight--;
	        }
	        sum += firstDigit * 2;
	        int secondDigit = calculateDigit(sum);

	        return firstDigit == Character.getNumericValue(cpf.charAt(9)) && secondDigit == Character.getNumericValue(cpf.charAt(10));
	    }
	    
	    private static int calculateDigit(int sum) {
	        int remainder = sum % 11;
	        return remainder < 2 ? 0 : 11 - remainder;
	    }
	}

	
}
