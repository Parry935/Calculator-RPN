package Operacje;

public class Silnia {
	
	public double operacja(double arg1)
	{
		Double silnia = 1.0;
		if(arg1 == 0 || arg1 ==1)
			return silnia;
			
		for(int i = 2; i<=arg1;i++)
		{
			silnia*=i;
		}
		
		return silnia;
	}
}
