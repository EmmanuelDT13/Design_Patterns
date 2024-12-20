package comportamiento;

public class Strategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Example
		ShoppingCartService cart = new ShoppingCartService();
		cart.setPaymentStrategy(new StrategyCreditCardPayment("4152-1090-9872-1386"));
		cart.checkout(200.00);
		
		cart.setPaymentStrategy(new StrategyPayPayPayment("theemanuel211@gmail.com"));
		cart.checkout(800.0);
		
		//Exercise #1
		Calculator calculator = new Calculator();
		
		calculator.setOperation(new StrategyAdditionOperation());
		System.out.println(calculator.calculate(4, 5));
		
		calculator.setOperation(new StrategySubtractionOperation());
		System.out.println(calculator.calculate(10, 2));
		
		calculator.setOperation(new StrategyMultiplicationOperation());
		System.out.println(calculator.calculate(5, 5));
		
		calculator.setOperation(new StrategyDivisionOperation());
		System.out.println(calculator.calculate(100, 2));
		
	}

}


//Example ------------------------------------------------------
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

//Example ------------------------------------------------------


//Excercise #1 -------------------------------------------------
/*
Implement a calculator that can perform basic arithmetic operations 
(addition, subtraction, multiplication, and division). 
The calculator must use the Strategy pattern to choose which operation to perform.
*/
interface StrategyOperation{
	public Integer calculate(Integer num1, Integer num2);
}

class StrategyAdditionOperation implements StrategyOperation{
	@Override
	public Integer calculate(Integer num1, Integer num2) {
		System.out.println("Adding numbers");
		return num1 + num2;
	}
}

class StrategySubtractionOperation implements StrategyOperation{
	@Override
	public Integer calculate(Integer num1, Integer num2) {
		System.out.println("Subtracting numbers");
		return num1 - num2;
	}
}

class StrategyMultiplicationOperation implements StrategyOperation{
	@Override
	public Integer calculate(Integer num1, Integer num2) {
		System.out.println("Multiplicating numbers");
		return num1 * num2;
	}
}

class StrategyDivisionOperation implements StrategyOperation{
	@Override
	public Integer calculate(Integer num1, Integer num2) {
		System.out.println("Dividing numbers");
		return num1 / num2;
	}
}


class Calculator{
	
	private StrategyOperation operation;

	public StrategyOperation getInstance() {
		return operation;
	}

	public void setOperation(StrategyOperation instance) {
		this.operation = instance;
	}
	
	public Integer calculate(Integer num1, Integer num2) {
		return this.operation.calculate(num1, num2);
	}
}

