package MemoryCatcherApp;


/**
* MemoryCatcherApp/AllResourcesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Barry/Desktop/College/Network programming and distributed systems/Project/New folder/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* Saturday, 6 December 2014 19:03:50 o'clock GMT
*/

public final class AllResourcesHolder implements org.omg.CORBA.portable.Streamable
{
  public MemoryCatcherApp.Resources value[] = null;

  public AllResourcesHolder ()
  {
  }

  public AllResourcesHolder (MemoryCatcherApp.Resources[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MemoryCatcherApp.AllResourcesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MemoryCatcherApp.AllResourcesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MemoryCatcherApp.AllResourcesHelper.type ();
  }

}
