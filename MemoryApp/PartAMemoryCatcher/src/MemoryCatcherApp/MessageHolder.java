package MemoryCatcherApp;

/**
* MemoryCatcherApp/MessageHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Barry/Desktop/College/Network programming and distributed systems/Project/New folder/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* Saturday, 6 December 2014 19:03:51 o'clock GMT
*/

public final class MessageHolder implements org.omg.CORBA.portable.Streamable
{
  public MemoryCatcherApp.Message value = null;

  public MessageHolder ()
  {
  }

  public MessageHolder (MemoryCatcherApp.Message initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MemoryCatcherApp.MessageHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MemoryCatcherApp.MessageHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MemoryCatcherApp.MessageHelper.type ();
  }

}
