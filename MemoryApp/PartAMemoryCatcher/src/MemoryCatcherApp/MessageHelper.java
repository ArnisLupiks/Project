package MemoryCatcherApp;


/**
* MemoryCatcherApp/MessageHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Barry/Desktop/College/Network programming and distributed systems/Project/New folder/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* Saturday, 6 December 2014 16:08:33 o'clock GMT
*/

abstract public class MessageHelper
{
  private static String  _id = "IDL:MemoryCatcherApp/Message:1.0";

  public static void insert (org.omg.CORBA.Any a, MemoryCatcherApp.Message that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static MemoryCatcherApp.Message extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "content",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "receiver",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "sender",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[4] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (MemoryCatcherApp.MessageHelper.id (), "Message", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static MemoryCatcherApp.Message read (org.omg.CORBA.portable.InputStream istream)
  {
    MemoryCatcherApp.Message value = new MemoryCatcherApp.Message ();
    value.name = istream.read_string ();
    value.content = istream.read_string ();
    value.receiver = istream.read_string ();
    value.sender = istream.read_string ();
    value.id = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, MemoryCatcherApp.Message value)
  {
    ostream.write_string (value.name);
    ostream.write_string (value.content);
    ostream.write_string (value.receiver);
    ostream.write_string (value.sender);
    ostream.write_long (value.id);
  }

}
