package myPackage;

import Operacje.*;

public class ONP {

	private Stos stack = new Stos();
	
	//operacje
	Dodawanie add = new Dodawanie();
	Odejmowanie sub = new Odejmowanie();
	Mnozenie mul = new Mnozenie();
	Dzielenie div = new Dzielenie();
	Modulo mod = new Modulo();
	Potega pow = new Potega();
	Pierwiastek sqr = new Pierwiastek();
	Silnia fac = new Silnia();
	
	// czyPoprawne - przecinki i nawiasy
	boolean czyPoprawne(String rownanie) {

		boolean poprawnosc = true;
		String tempNumber = "";
		int howManyDots = 0;
		int howManyOpenBrackets = 0;
		int howManyCloseBrackets = 0;

		for (int i = 0; i < rownanie.length(); i++) {

			if (rownanie.charAt(i) == '(')
				howManyOpenBrackets++;
			if (rownanie.charAt(i) == ')')
				howManyCloseBrackets++;

			if (rownanie.charAt(i) == '.' || (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9')) {
				tempNumber += rownanie.charAt(i);

				if (rownanie.charAt(i) == '.')
					howManyDots++;

				if (!(rownanie.charAt(i + 1) == '.')
						&& !(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9')) {
					if (howManyDots > 1)
						poprawnosc = false;
					howManyDots = 0;
					tempNumber = "";
				}
			}
		}
		
		if(howManyCloseBrackets!=howManyOpenBrackets)
			poprawnosc=false;
		
		return poprawnosc;
	}

	public String zamienNaONP(String rownanie) {

		String wynik = "";
		String tempWynik = "";

		try {
			if (!czyPoprawne(rownanie))
				throw new MyException("Rownanie nie jest poprawne!"); // wyrzucenie wyj¹tku

		} catch (MyException ex) {

			return ex.getMessage(); // zwrocenie komunikatu o b³edzie
		}

		for (int i = 0; i < rownanie.length(); i++) {
			
			// jeœli wyst¹pi liczba w równaniu dodaj j¹ do wyniku
			if (rownanie.charAt(i)=='.' || (rownanie.charAt(i) >= '0' && rownanie.charAt(i) <= '9')) {
				tempWynik += rownanie.charAt(i);

				// jeœli nastêpny znak w równaniu nie jest liczb¹ odseparuj poprzednio dodan¹ liczbe dodan¹ liczbê
				if (!(rownanie.charAt(i+1)=='.') && !(rownanie.charAt(i + 1) >= '0' && rownanie.charAt(i + 1) <= '9')) {
					wynik += tempWynik;
					tempWynik ="";
					wynik += " ";
				}
			}

			// jeœli nastêpny znak w równaniu jest operacj¹
			else {

				switch (rownanie.charAt(i)) {

				case '+':;
				case '-':{
					//jeœli stos nie jest pusty i ostatni znak na stosie nie jest '('
					while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) {
						wynik = wynik + stack.pop() + " ";
					}
					
					String temp = "" + rownanie.charAt(i);
					stack.push(temp);
					break;
				}

				case '*': ;
				case 'x': ;
				case '%': ;
				case '#': ;
				case '/': {
					//jeœli stos nie jest pusty i ostatni znak na stosie nie jest '(' '+' '-'
					while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")
							&& !stack.showValue(stack.getSize() - 1).equals("+")
							&& !stack.showValue(stack.getSize() - 1).equals("-")) {
						wynik = wynik + stack.pop() + " ";
					}
					String temp = "" + rownanie.charAt(i);
					stack.push(temp);
					break;
				}

				case '^': {
					// jeœli stos nie jest pusty i ostatni znak na stosie jest '^' lub '!'
					while (stack.getSize() > 0 && (stack.showValue(stack.getSize() - 1).equals("^")
							|| stack.showValue(stack.getSize() - 1).equals("!"))) {
						wynik = wynik + stack.pop() + " ";
					}
					String temp = "" + rownanie.charAt(i);
					stack.push(temp);
					break;
				}
				
				case '!': {
					// jeœli stos nie jest pusty i ostatni znak na stosie jest '!'
					while (stack.getSize() > 0 && stack.showValue(stack.getSize() - 1).equals("!")) {
						wynik = wynik + stack.pop() + " ";
					}
					String temp = "" + rownanie.charAt(i);
					stack.push(temp);
					break;
				}
				
				case '(':{
					String temp = "" + rownanie.charAt(i);
					stack.push(temp);
					break;
				}
				
				case ')':{
					while (stack.getSize() > 0 && !stack.showValue(stack.getSize() - 1).equals("(")) {
						wynik = wynik + stack.pop() + " ";
					}
					
					stack.pop();
					break;
				}
				
				case '=': {
					while (stack.getSize() > 0) {
						wynik = wynik + stack.pop() + " ";
					}
					wynik += "=";
				}
				}

			}
		}
		
		return wynik;
	}
	
	
	public String obliczOnp (String rownanieONP)
	{	
		String wynik="";
		
		Double arg1 = 0.0;
		Double arg2 = 0.0;
		stack.clearStack();
		
		for (int i = 0; i < rownanieONP.length(); i++) {
			
			if (rownanieONP.charAt(i) == '.' || (rownanieONP.charAt(i) >= '0' && rownanieONP.charAt(i) <= '9')) { //jesli znak jest liczb¹
				wynik += rownanieONP.charAt(i);
				if (!(rownanieONP.charAt(i+1) == '.') && !(rownanieONP.charAt(i + 1) >= '0' && rownanieONP.charAt(i + 1) <= '9')) {
					stack.push(wynik);
					wynik = "";
				}

			}

			else if (rownanieONP.charAt(i) == '=') { //jesli natrafimy na znak '=' zwracamy wynik
				return stack.pop();
			} 
			
			else if (rownanieONP.charAt(i) != ' ') {
				if(rownanieONP.charAt(i)=='!') //operacja jednoargumentowa
					arg1 = Double.parseDouble(stack.pop());
				
				else { //operacja dwuargumentowa
					arg2 = Double.parseDouble(stack.pop());
					arg1 = Double.parseDouble(stack.pop());
				}
				
				switch (rownanieONP.charAt(i)) {
				case ('+'): {
					stack.push(String.valueOf(add.operacja(arg1, arg2)));
					break;
				}
				case ('-'): {
					stack.push(String.valueOf(sub.operacja(arg1, arg2)));
					break;
				}
				case ('x'): ;
				case ('*'): {
					stack.push(String.valueOf(mul.operacja(arg1, arg2)));
					break;
				}
				case ('/'): {
					stack.push(String.valueOf(div.operacja(arg1, arg2)));
					break;
				}
				case ('^'): {
					stack.push(String.valueOf(pow.operacja(arg1, arg2)));
					break;
				}
				case ('%'):{
					stack.push(String.valueOf(mod.operacja(arg1, arg2)));
					break;
				}
				case ('!'):{
					stack.push(String.valueOf(fac.operacja(arg1)));
					break;
				}
				
				case ('#'):{
					stack.push(String.valueOf(sqr.operacja(arg1, arg2)));;
					break;
				}
				}
			}
		}

		return "0.0";
	}

}
