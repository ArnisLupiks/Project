package MemoryCatcherApp;


/**
* MemoryCatcherApp/Memory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Arnis/Desktop/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* 11 December 2014 12:42:59 o'clock GMT
*/

public final class Memory implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String description = null;
  public int id = (int)0;

  public Memory ()
  {
  } // ctor

  public Memory (String _name, String _description, int _id)
  {
    name = _name;
    description = _description;
    id = _id;
  } // ctor

} // class Memory
