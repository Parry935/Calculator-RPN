package myController;

import myPackage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaneController {
	
	@FXML
    private Button clearCalc;

    @FXML
    private Button operatorMinus;

    @FXML
    private Button operatorFactorial;

    @FXML
    private Button number_3;

    @FXML
    private Button operatorSQRT;

    @FXML
    private Button operatorPercent;

    @FXML
    private Button number_6;

    @FXML
    private Button number_2;

    @FXML
    private Button closeBracket;

    @FXML
    private Button operatorPower;

    @FXML
    private Button number_9;

    @FXML
    private Button operatorDot;

    @FXML
    private Button operatorPlus;

    @FXML
    private Button number_8;

    @FXML
    private Button number_5;

    @FXML
    private Button number_0;

    @FXML
    private Button number_1;

    @FXML
    private Button number_4;

    @FXML
    private Button operatorMulti;

    @FXML
    private Button operatorDiv;

    @FXML
    private Button openBracket;

    @FXML
    private Button operatorEquals;

    @FXML
    private Button number_7;

    @FXML
    private Label displayINFIX;

    @FXML
    private Label displayANS;

    @FXML
    private Label displayRPN;
    
    private String inputString = "";
    private String rpnString = "";
	private String ansString = "";
	
	ONP onp = new ONP();
	
	//wyra¿enie lambda
	 Poprawnosc sprawdzPoprawnosc = (rowanie) ->{
			
			if(rowanie.equals("Rownanie nie jest poprawne!"))
				return false;
			else
				return true;
		};

    @FXML
    void buttonAction(ActionEvent event) {
    		
		if (event.getSource() == number_0) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "0";
		}

		else if (event.getSource() == number_1) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "1";
		}

		else if (event.getSource() == number_2) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "2";
		}

		else if (event.getSource() == number_3) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "3";
		}

		else if (event.getSource() == number_4) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "4";
		}

		else if (event.getSource() == number_5) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "5";
		}

		else if (event.getSource() == number_6) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "6";
		}

		else if (event.getSource() == number_7) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "7";
		}

		else if (event.getSource() == number_8) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "8";
		}

		else if (event.getSource() == number_9) {
			if (inputString.length() == 0 || inputString.charAt(inputString.length() - 1) != ')'
					&& inputString.charAt(inputString.length() - 1) != '!')
				inputString += "9";
		}

		else if (event.getSource() == operatorMinus) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
							|| inputString.charAt(inputString.length() - 1) == ')'
							|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "-";
		}

		else if (event.getSource() == operatorPlus) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "+";
		}

		else if (event.getSource() == operatorDiv) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "/";
		}

		else if (event.getSource() == operatorDot) {
			if (inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
				inputString += ".";
		}

		else if (event.getSource() == operatorFactorial) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')')
				inputString += "!";
		} else if (event.getSource() == operatorMulti) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "x";
		} else if (event.getSource() == operatorPercent) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "%";
		}

		else if (event.getSource() == operatorPower) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "^";
		}

		else if (event.getSource() == operatorSQRT) {
			if (inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9'
					|| inputString.charAt(inputString.length() - 1) == ')'
					|| inputString.charAt(inputString.length() - 1) == '!')
				inputString += "#";
		}

		else if (event.getSource() == openBracket) {
			if (inputString.length() == 0 || !(inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9'))
				inputString += "(";
		}

		else if (event.getSource() == closeBracket) {
			if ((inputString.charAt(inputString.length() - 1) >= '0'
					&& inputString.charAt(inputString.length() - 1) <= '9')
					|| inputString.charAt(inputString.length() - 1) == '!'
					|| inputString.charAt(inputString.length() - 1) == ')')
				inputString += ")";
		}

		else if (event.getSource() == clearCalc) {
			inputString = "";
			rpnString = "";
			ansString = "";
		}

		else if (event.getSource() == operatorEquals) {

			calculate(inputString + "=");
		}

		displayINFIX.setText(inputString);
		displayRPN.setText(rpnString);
		displayANS.setText(ansString);
    }
    
    
    public void calculate(String inputString)
    {
    	rpnString = onp.zamienNaONP(inputString);
    	displayRPN.setText(rpnString);
    	
    	if(sprawdzPoprawnosc.sprawdzPoprawonosc(rpnString)) {
	    	ansString = onp.obliczOnp(rpnString);
	    	displayANS.setText(ansString);
    	}
    }
    
	
}