package comportamiento;

public class Strategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShoppingCartService cart = new ShoppingCartService();
		cart.setPaymentStrategy(new StrategyCreditCardPayment("4152-1090-9872-1386"));
		cart.checkout(200.00);
		
		
		cart.setPaymentStrategy(new StrategyPayPayPayment("theemanuel211@gmail.com"));
		cart.checkout(800.0);
	}

}

interface StrategyPayment{
	void pay(double price);
}

class StrategyCreditCardPayment implements StrategyPayment{

	private String creditCard;
	
	public StrategyCreditCardPayment(String creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public void pay(double price) {
		System.out.println("You have paid $" + price + " dollars by your credit card: " + creditCard);
	}
	
}

class StrategyPayPayPayment implements StrategyPayment{

	private String email;
	
	public StrategyPayPayPayment(String email) {
		super();
		this.email = email;
	}

	@Override
	public void pay(double price) {
		// TODO Auto-generated method stub
		System.out.println("You have paid $" + price + " dollars by your paypay email: " + email);
	}
		
}

class ShoppingCartService{
	
	private StrategyPayment paymentStrategy;

	public StrategyPayment getPaymentStrategy() {
		return paymentStrategy;
	}

	public void setPaymentStrategy(StrategyPayment paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void checkout(double price) {
		System.out.println("Proccesing payment...");
		paymentStrategy.pay(price);
		System.out.println("Payment done successfully.");
	}
}