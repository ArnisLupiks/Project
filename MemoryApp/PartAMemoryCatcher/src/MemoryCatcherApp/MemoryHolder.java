package MemoryCatcherApp;

/**
* MemoryCatcherApp/MemoryHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Arnis/Desktop/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* 14 December 2014 20:03:15 o'clock GMT
*/

public final class MemoryHolder implements org.omg.CORBA.portable.Streamable
{
  public MemoryCatcherApp.Memory value = null;

  public MemoryHolder ()
  {
  }

  public MemoryHolder (MemoryCatcherApp.Memory initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MemoryCatcherApp.MemoryHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MemoryCatcherApp.MemoryHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MemoryCatcherApp.MemoryHelper.type ();
  }

}
