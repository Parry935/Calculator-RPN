package myPackage;
import java.util.LinkedList;
import java.util.List;

public class Stos {

	private List<String> stack = new LinkedList<String>();

	// zdejmij wartosc ze stosu
	public String pop() {
		
		String temp = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		
		return temp;
	}

	// umiesc wartosc na stosie
	public void push(String element) {

		stack.add(element);
	}

	// zwroc ilosc elementow na stosie
	public int getSize() {
		return stack.size();
	}

	// poka¿ wartosci na stosie
	public String toString() {

		String temp = "Zawartoœæ stosu: ";

		for (String string : stack) {
			temp += string + " ";
		}

		return temp;
	}

	// zwroc wartoœc z danej pozycji na stosie
	public String showValue(int i) {
		if (i < stack.size())
			return stack.get(i);
		else
			return null;
	}
	
	public void clearStack(){
		stack.clear();
	}

}
