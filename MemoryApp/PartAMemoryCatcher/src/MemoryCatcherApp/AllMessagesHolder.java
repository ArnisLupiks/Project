package MemoryCatcherApp;


/**
* MemoryCatcherApp/AllMessagesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Barry/Desktop/College/Network programming and distributed systems/Project/New folder/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* Saturday, 6 December 2014 16:08:33 o'clock GMT
*/

public final class AllMessagesHolder implements org.omg.CORBA.portable.Streamable
{
  public MemoryCatcherApp.Message value[] = null;

  public AllMessagesHolder ()
  {
  }

  public AllMessagesHolder (MemoryCatcherApp.Message[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MemoryCatcherApp.AllMessagesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MemoryCatcherApp.AllMessagesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MemoryCatcherApp.AllMessagesHelper.type ();
  }

}
