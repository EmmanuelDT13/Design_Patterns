package creacion;

public class Factory {

	public static void main(String[] args) {
		
		//Example
		Vehicle vehicle1 = VehicleFactory.createInstance("Car");
		vehicle1.turnOn();
		
		Vehicle vehicle2 = VehicleFactory.createInstance("Motocycle");
		vehicle2.turnOn();
		
		
		//Exercise #1
		
		System.out.println();
		
		Transaction transaction1 = TransactionFactory.createInstance("Transference");
		transaction1.doTransaction(100);
		
		Transaction transaction2 = TransactionFactory.createInstance("Withdrow");
		transaction2.doTransaction(200);
		
		Transaction transaction3 = TransactionFactory.createInstance("Deposit");
		transaction3.doTransaction(500);
		
		
	}
	
}

//Product
abstract class Vehicle{
	
	protected String name;
	
	public abstract void turnOn();
}

//Subproduct
class Car extends Vehicle{

	public Car() {
		this.name = "Toyota Corolla";
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Turning on the " + this.name);
	}
	
}

//Subproduct
class Motocycle extends Vehicle{

	public Motocycle() {
		this.name = "Italika";
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("You can drive already your " + this.name);
	}
	
}

//Factory
class VehicleFactory{
		
	public static Vehicle createInstance(String vehiculeType) {
		
		switch(vehiculeType) {
		case "Motocycle": {
			return new Motocycle();
		}
		case "Car": {
			return new Car();
		}
		default: throw new RuntimeException("The specified vehicule doesn't exist");
		}
	}
}


//Exercise #1:

/*
You are going to develop a system that allows you to create different types of banking transactions. 
Each transaction will have a specific operation, such as deposits, withdrawals, and transfers. 
The logic for creating these transactions should be handled using the Factory pattern.
*/
abstract class Transaction{
	protected String transaction;
	public abstract void doTransaction(Integer quantity);
}

class TransferenceTransaction extends Transaction{

	public TransferenceTransaction() {
		this.transaction = "Transference";
	}
	
	@Override
	public void doTransaction(Integer quantity) {
		System.out.println("Your operation is: " + this.transaction + ". You have transfered $" + quantity + " dollars");
	}
	
}

class WithdrowTransaction extends Transaction{

	public WithdrowTransaction() {
		this.transaction = "Withdrow";
	}
	
	@Override
	public void doTransaction(Integer quantity) {
		// TODO Auto-generated method stub
		System.out.println("Your operation is: " + this.transaction + ". You have withfrown $" + quantity + " dollars");
	}
}

class DepositTransaction extends Transaction{

	public DepositTransaction() {
		this.transaction = "Deposit";
	}
	
	@Override
	public void doTransaction(Integer quantity) {
		// TODO Auto-generated method stub
		System.out.println("Your operation is: " + this.transaction + ". You have deposited $" + quantity + " dollars");
	}
}

class TransactionFactory{
	
	public static Transaction createInstance(String transactionType) {
		
		switch(transactionType) {
			case "Transference": return new TransferenceTransaction();
			case "Withdrow": return new WithdrowTransaction();
			case "Deposit": return new DepositTransaction();
			default: throw new RuntimeException("This operation doesn't exist");
		}
	}
}
