package model.services;

public class PaypalPaymentService implements PaymentService {
	
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double interest(double amount, int number) {				
		return amount * MONTHLY_INTEREST * number;
	}

	@Override
	public double paymentFee(double amount) {		
		return amount * PAYMENT_FEE;
	}

	
	
}
