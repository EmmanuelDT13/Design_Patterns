package estructural;

public class Facade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Example 1
		System.out.println("EXAMPLE 1");
		System.out.println("");
		ProjectsFacade projectsFacade = new ProjectsFacade();
		projectsFacade.createProject("Spring Tools Suite", "Java", 17, "Design Patterns");
		
		
		
		//Exercise 1
		System.out.println("");
		System.out.println("EXERCISE 1");
		System.out.println("");
		OperationsFacade operationsFacade = new OperationsFacade();
		operationsFacade.deposit(new Account("Emmanuel", "0182632727272", 100000.00), 900.00);
		System.out.println();
		operationsFacade.withdrow(new Account("Emmanuel", "0182632727272", 100000.00), 900000.00);
	}

}


//EXAMPLE 1.
class Ide {
	public void downloadIde(String ide) {
		System.out.println("The IDE " + ide + " has been downloaded.");
	}
}

class ProgrammingLanguage{
	public void downloadProgramingLanguage(String programmingLanguage, int version) {
		System.out.println("The programming language " + programmingLanguage + " " + version + " has been downloaded and installed.");
	}
}

class Project{
	public void createProject(String nameProject) {
		System.out.println("The project '" + nameProject +"' has been created.");
	}
}


class ProjectsFacade{
	private Ide ide;
	private ProgrammingLanguage programmingLanguage;
	private Project project;
	public ProjectsFacade() {
		super();
		this.ide = new Ide();
		this.programmingLanguage = new ProgrammingLanguage();
		this.project = new Project();
	}
	
	public void createProject(String ide, String programmingLanguage, int version, String nameProject) {	
		System.out.println("Creating project...");
		this.ide.downloadIde(ide);
		this.programmingLanguage.downloadProgramingLanguage(programmingLanguage, version);
		this.project.createProject(nameProject);
		System.out.println("You can start to type code.");
	}
}

/*
 * EXERCISE 01
 * A bank needs to offer a simplified interface to handle banking transactions. Internally, the system has several operations including:

	Verifying customer data.
	Validating whether the customer has sufficient funds.
	Processing the withdrawal or deposit of money.
 
 */
class Account{
	
	private String user;
	private String clabe;
	private Double aviableFounds;
	
	public Account(String user, String clabe, Double aviableFounds) {
		super();
		this.user = user;
		this.clabe = clabe;
		this.aviableFounds = aviableFounds;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getClabe() {
		return clabe;
	}
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	public Double getAviableFounds() {
		return aviableFounds;
	}
	public void setAviableFounds(Double aviableFounds) {
		this.aviableFounds = aviableFounds;
	}
	
	public Double deposit(Double ammount) {
		this.aviableFounds += ammount;
		System.out.println("The deposit has been successfuly performed. Current balance: " + aviableFounds);	
		return this.aviableFounds;
	}
	
	public Double whithDrow(Double ammount) {
		
		if (this.aviableFounds > ammount) {
			this.aviableFounds -= ammount;
			System.out.println("The withdrow has been successfuly performed. Current balance: " + aviableFounds);	
			return this.aviableFounds;
		}
		
		System.out.println("Insufficient balance.");
		
		return this.aviableFounds;
	}
	
}

class SecurityService{
	
	public void verifyClientInformation(Account originAccount) {
		System.out.println("Veryfing client information...");
		System.out.println("Validated information.");
	}
}

class TransactionService{
	public void depositAmmount(Account account, Double ammount) {
		account.deposit(ammount);
		System.out.println("You have deposited " + ammount + " to: " + account.getUser());
	}
	
	public void withDrowAmmount(Account account, Double ammount) {
		Double previousBalance = account.getAviableFounds();
		account.whithDrow(ammount);
		if (previousBalance == account.getAviableFounds()) return;
		System.out.println("You have withdrown " + ammount + " to: " + account.getUser());
	}
}

class OperationsFacade{
	
	private SecurityService securityService;
	private TransactionService transactionService;
	
	public OperationsFacade() {
		this.securityService = new SecurityService();
		this.transactionService = new TransactionService();
	}
	
	public void deposit(Account account, Double ammount) {
		this.securityService.verifyClientInformation(account);
		this.transactionService.depositAmmount(account, ammount);
		System.out.println("Operation finished successfuly.");
	}
	
	public void withdrow(Account account, Double ammount) {
		
		this.securityService.verifyClientInformation(account);
		this.transactionService.withDrowAmmount(account, ammount);
		System.out.println("Operation finished.");
	}
}

