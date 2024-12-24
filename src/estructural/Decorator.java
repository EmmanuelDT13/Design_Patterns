package estructural;

public class Decorator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Example #1
		Drink coffee = new Coffee();
		Drink coffe_Milk = new Milk(coffee);
		Drink coffe_Milk_Suggar = new Suggar(coffe_Milk);
		
		System.out.println(coffee.giveDescription());
		System.out.println(coffee.givePrice());
		
		System.out.println(coffe_Milk.giveDescription());
		System.out.println(coffe_Milk.givePrice());
		
		System.out.println(coffe_Milk_Suggar.giveDescription());
		System.out.println(coffe_Milk_Suggar.givePrice());
		
		System.out.println();
		
		
		//Exercise #1
		BankAccount basicAccount = new BankAccountImpl();
		BankAccount vipAccount = new VipBankAccount(basicAccount);
		BankAccount premiumAccount = new PremiumBankAccount(vipAccount);
		
		
		System.out.println("General Data:");
		System.out.println(basicAccount.showBalance());
		System.out.println(basicAccount.transferMoney(10, "9093-1000-0000-1111"));
		basicAccount.withdrowMoney(200);
		
		System.out.println();
		System.out.println("Basic Account benefits");
		basicAccount.showBenefits();
		
		System.out.println();
		System.out.println("VIP Account benefits");
		vipAccount.showBenefits();
		
		System.out.println();
		System.out.println("PREMIUM Account benefits");
		premiumAccount.showBenefits();
		
	}

}

//Base
interface Drink {
	
	public String giveDescription();
	public Integer givePrice();
	
}

//Basic implementation
class Coffee implements Drink{

	@Override
	public String giveDescription() {
		return "Coffee";
	}

	@Override
	public Integer givePrice() {
		return 5;
	}
	
}

//Abstract decorator
abstract class DrinkDecorator implements Drink{

	protected Drink drink;
	
	public DrinkDecorator(Drink drink) {
		this.drink = drink;
	}
}

//Concrete decorator #1
class Suggar extends DrinkDecorator{

	public Suggar(Drink drink) {
		super(drink);
	}
	
	@Override
	public String giveDescription() {
		return super.drink.giveDescription() + ", Suggar";
	}

	@Override
	public Integer givePrice() {
		return super.drink.givePrice() + 2;
	}
	
}

//Concrete decorator #2
class Milk extends DrinkDecorator{
	
	public Milk(Drink drink) {
		super(drink);
	}
	
	@Override
	public String giveDescription() {
		return super.drink.giveDescription() + ", Milk";
	}

	@Override
	public Integer givePrice() {
		return super.drink.givePrice() + 4;
	}
}


//Exercise #1:

/*
 Let's imagine we work with a banking system where customers can have basic accounts and we can 
 add additional features such as cashback, insurance policies, or premium services.
*/

//Base Interface
interface BankAccount{
	public String showBalance();
	public String transferMoney(Integer quantity, String account);
	public void withdrowMoney(Integer quantity);
	public void showBenefits();
}

//Basic implementation
class BankAccountImpl implements BankAccount{

	@Override
	public String showBalance() {
		return "Your balance is: 10,000";
	}

	@Override
	public String transferMoney(Integer quantity, String account) {
		return "You have transfered $" + quantity + " to: " + account;
	}

	@Override
	public void withdrowMoney(Integer quantity) {
		System.out.println("You have withdrown $" + quantity + " dollars.");
	}

	@Override
	public void showBenefits() {
		System.out.println("You have a credit card.");
	}
}

//Vip Decorator
abstract class VipBankAccountDecorator implements BankAccount{
	
	protected BankAccount bankAccount;
	
	public VipBankAccountDecorator(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}

//Premium decorator
abstract class PremiumBankAccountDecodator implements BankAccount{
	
	protected BankAccount bankAccount;
	
	public PremiumBankAccountDecodator(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}

//Vip implementation
class VipBankAccount extends VipBankAccountDecorator{

	public VipBankAccount(BankAccount bankAccount) {
		super(bankAccount);
	}

	@Override
	public String showBalance() {
		return super.bankAccount.showBalance();
	}

	@Override
	public String transferMoney(Integer quantity, String account) {
		return super.bankAccount.transferMoney(quantity, account);
	}

	@Override
	public void withdrowMoney(Integer quantity) {
		super.bankAccount.withdrowMoney(quantity);
	}

	@Override
	public void showBenefits() {
		super.bankAccount.showBenefits();
		this.addVipBenefits();
	}

	private void addVipBenefits() {
		System.out.println( "As you are a VIP member, you have a 5% cashback per month for each bought.");
	}
	
}

//Premium implementation
class PremiumBankAccount extends PremiumBankAccountDecodator{

	public PremiumBankAccount(BankAccount bankAccount) {
		super(bankAccount);
	}

	@Override
	public String showBalance() {
		return super.bankAccount.showBalance();
	}

	@Override
	public String transferMoney(Integer quantity, String account) {
		return super.bankAccount.transferMoney(quantity, account);
	}

	@Override
	public void withdrowMoney(Integer quantity) {
		super.bankAccount.withdrowMoney(quantity);
	}

	@Override
	public void showBenefits() {
		super.bankAccount.showBenefits();
		this.addPremiumBenefits();
	}

	private void addPremiumBenefits() {
		System.out.println("As you are a PREMIUM member, you have a complete Account Unsurance");
	}
	
}