// The package containing our stubs.
import MemoryCatcherApp.*;

//Servant must inherit the generated code
public class MemoryCatcherServant extends _MemoryCatcherImplBase {
	// Add the MemoryCatchers methods here in the next step.

	//int resources = 0;
	//int points = 0;
	//ArrayList<String> memories = new ArrayList<String>();
	//Array
	//ArrayList<String> moments = new ArrayList<String>();

	int resources = 3;

	//Log in
	public boolean login(String username, password){

	}
	//Register
	public boolean register(String username, email, password){

	}
	//Add Memory
	public boolean addMemory(String memory, username){

	}
	//Remove Memory
	public boolean removeMemory(int memoryIndex){

	}
	//Transfer Points
	public boolean transfer(int points, String username){

	}
	//Buy Resource Points
	public int buy(int amount){
		resources = resources + amount;
	}
	public boolean share(int memoryIndex){

	}
	//Get Memory
	public int getMemory(int memoryIndex){
		return memory;

	}

	//View Resouces
	public int getResource(){
		return resources;
	}


	public ArrayList<String> getMemories(){
	  return memories;
	}

	public String share(String memories){
	  moments = memories + moments;
	}

	public boolean login(String userName, String password){
		return false;
	}

	public String invite(String userName){
		return "";
	}

	public boolean addMemory(String memory){
	  return memories.add(memory);
	}

	public boolean removeMemory(String memory){
	  	//TODO
	}

}








