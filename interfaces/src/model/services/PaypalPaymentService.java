package model.services;

public class PaypalPaymentService implements PaymentService {

	@Override
	public double calculate(double amount, int number) {		
		double value = amount + (amount * 0.01 * number);
		return value + (value * 0.02);
	}

	
	
}
