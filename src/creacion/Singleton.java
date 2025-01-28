package creacion;

import java.util.Map;
import java.util.HashMap;

public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Example template
		SingletonEntity instanceSingletonEntity = SingletonEntity.getInstance();
		instanceSingletonEntity.initialize("Bancaria II", 2);
		instanceSingletonEntity.performProcess();
		
		
		
		//Exercise #1
		SingletonConfigManager instanceSingletonConfigManager = SingletonConfigManager.getInstance();
		
		Map<String, String> configurations = new HashMap<String, String>();
		configurations.put("name", "emmanuel");
		configurations.put("password", "emm_an#");

		instanceSingletonConfigManager.addConfiguration("port", "8089");
		instanceSingletonConfigManager.addConfiguration(configurations);		
		System.out.println(instanceSingletonConfigManager.getConfigurations());
		System.out.println(instanceSingletonConfigManager.getConfiguration("port"));
	}
}

//Basic example - How to create one Singleton Class.
class SingletonEntity{
	
	public static SingletonEntity instance;
	
	private String configuration;
	
	private int valorConfigurable;
	
	private SingletonEntity() {	
		this.configuration = "Default";
		this.valorConfigurable = 1;
	};
		
	public static synchronized SingletonEntity getInstance() {
		if (instance == null) {
			instance = new SingletonEntity();
		}	
		return instance;
	}
	
	public void initialize(String configuration, int valorConfigurable) {
		if (this.configuration.equals("Default")) {
			this.configuration = configuration;
			this.valorConfigurable = valorConfigurable;
		}else {
			System.out.println("No es posible modificar la instancia después de su creación.");
		}
	}
	
	public String getConfiguration() {
		return this.configuration;
	}
	
	public int getConfigurationValue() {
		return this.valorConfigurable;
	}
	
	public void performProcess() {
		System.out.println("Se accediendo a base de datos...");
		System.out.println("Se acaba de persistir la configuración: " + configuration + ", con un valor de: " + valorConfigurable);
	}
	
}


//Exercise #1: 
/*
You are developing an application that needs to manage configurations for its operation. 
This configuration manager must ensure that:

There is only one instance in the entire application (Singleton pattern).
It must allow loading configurations internally, without interacting with external files.
It must allow obtaining specific values ​​of the configurations using a key (for example, get("key")).
*/
class SingletonConfigManager{
	
	private static SingletonConfigManager instance;
	
	private Map<String, String> configurations;
	
	private SingletonConfigManager() {
		configurations = new HashMap<String, String>();
	};
	
	public static synchronized SingletonConfigManager getInstance() {
		if (instance == null) {
			instance = new SingletonConfigManager();
		}
		return instance;
	}

	public void addConfiguration(String key, String value) {
		this.configurations.put(key, value);
	}
	
	public void addConfiguration(Map<String, String> configurations) {
		for (Map.Entry<String, String> entry : configurations.entrySet()) {
			this.configurations.put(entry.getKey(), entry.getValue());
		}
	}
	
	public String getConfiguration(String key) {
		return this.configurations.get(key);
	}
	
	public Map<String, String> getConfigurations(){
		return this.configurations;
	}
	
} 



