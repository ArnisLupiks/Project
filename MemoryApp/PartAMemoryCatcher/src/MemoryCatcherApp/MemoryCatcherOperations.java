package MemoryCatcherApp;


/**
* MemoryCatcherApp/MemoryCatcherOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Arnis/Desktop/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* 14 December 2014 14:30:23 o'clock GMT
*/

public interface MemoryCatcherOperations 
{
  int login (String username, String password);
  int register (String username, String email, String password);
  int addMemory (String memoryName, String memoryDescription);
  boolean removeMemory (int memoryID);
  MemoryCatcherApp.Memory[] getAllMemories ();
  int addResources (int resources);
  int viewResources ();
  int shareResources (int resources, String name);
  int addMessage (String messageName, String messageContent, String receiver);
  MemoryCatcherApp.Message[] getAllMessages ();
} // interface MemoryCatcherOperations
