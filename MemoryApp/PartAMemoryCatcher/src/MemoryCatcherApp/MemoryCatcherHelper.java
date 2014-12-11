package MemoryCatcherApp;


/**
* MemoryCatcherApp/MemoryCatcherHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Arnis/Desktop/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* 11 December 2014 12:42:59 o'clock GMT
*/

abstract public class MemoryCatcherHelper
{
  private static String  _id = "IDL:MemoryCatcherApp/MemoryCatcher:1.0";

  public static void insert (org.omg.CORBA.Any a, MemoryCatcherApp.MemoryCatcher that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static MemoryCatcherApp.MemoryCatcher extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MemoryCatcherApp.MemoryCatcherHelper.id (), "MemoryCatcher");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static MemoryCatcherApp.MemoryCatcher read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MemoryCatcherStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, MemoryCatcherApp.MemoryCatcher value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static MemoryCatcherApp.MemoryCatcher narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MemoryCatcherApp.MemoryCatcher)
      return (MemoryCatcherApp.MemoryCatcher)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MemoryCatcherApp._MemoryCatcherStub stub = new MemoryCatcherApp._MemoryCatcherStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static MemoryCatcherApp.MemoryCatcher unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MemoryCatcherApp.MemoryCatcher)
      return (MemoryCatcherApp.MemoryCatcher)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MemoryCatcherApp._MemoryCatcherStub stub = new MemoryCatcherApp._MemoryCatcherStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
