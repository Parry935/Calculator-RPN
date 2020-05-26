package Operacje;

public class Pierwiastek extends Operacja{

	@Override
	public double operacja(double arg1, double arg2) {
		return Math.pow(arg2, 1/arg1);
	}

}
