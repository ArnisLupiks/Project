package MemoryCatcherApp;


/**
* MemoryCatcherApp/Message.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Barry/Desktop/College/Network programming and distributed systems/Project/New folder/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* Saturday, 6 December 2014 16:08:33 o'clock GMT
*/

public final class Message implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String content = null;
  public String receiver = null;
  public String sender = null;
  public int id = (int)0;

  public Message ()
  {
  } // ctor

  public Message (String _name, String _content, String _receiver, String _sender, int _id)
  {
    name = _name;
    content = _content;
    receiver = _receiver;
    sender = _sender;
    id = _id;
  } // ctor

} // class Message
