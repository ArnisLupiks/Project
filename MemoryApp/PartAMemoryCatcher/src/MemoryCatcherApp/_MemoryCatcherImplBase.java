package MemoryCatcherApp;


/**
* MemoryCatcherApp/_MemoryCatcherImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Arnis/Desktop/Project/MemoryApp/PartAMemoryCatcher/src/partamemorycatcher/MemoryCatcher.idl
* 14 December 2014 20:03:15 o'clock GMT
*/

public abstract class _MemoryCatcherImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements MemoryCatcherApp.MemoryCatcher, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _MemoryCatcherImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("login", new java.lang.Integer (0));
    _methods.put ("register", new java.lang.Integer (1));
    _methods.put ("addMemory", new java.lang.Integer (2));
    _methods.put ("removeMemory", new java.lang.Integer (3));
    _methods.put ("getAllMemories", new java.lang.Integer (4));
    _methods.put ("addResources", new java.lang.Integer (5));
    _methods.put ("viewResources", new java.lang.Integer (6));
    _methods.put ("shareMemory", new java.lang.Integer (7));
    _methods.put ("shareResources", new java.lang.Integer (8));
    _methods.put ("addMessage", new java.lang.Integer (9));
    _methods.put ("getAllMessages", new java.lang.Integer (10));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MemoryCatcherApp/MemoryCatcher/login
       {
         String username = in.read_string ();
         String password = in.read_string ();
         int $result = (int)0;
         $result = this.login (username, password);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // MemoryCatcherApp/MemoryCatcher/register
       {
         String username = in.read_string ();
         String email = in.read_string ();
         String password = in.read_string ();
         int $result = (int)0;
         $result = this.register (username, email, password);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // MemoryCatcherApp/MemoryCatcher/addMemory
       {
         String memoryName = in.read_string ();
         String memoryDescription = in.read_string ();
         int $result = (int)0;
         $result = this.addMemory (memoryName, memoryDescription);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // MemoryCatcherApp/MemoryCatcher/removeMemory
       {
         int memoryID = in.read_long ();
         boolean $result = false;
         $result = this.removeMemory (memoryID);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // MemoryCatcherApp/MemoryCatcher/getAllMemories
       {
         MemoryCatcherApp.Memory $result[] = null;
         $result = this.getAllMemories ();
         out = $rh.createReply();
         MemoryCatcherApp.AllMemoriesHelper.write (out, $result);
         break;
       }

       case 5:  // MemoryCatcherApp/MemoryCatcher/addResources
       {
         int resources = in.read_long ();
         int $result = (int)0;
         $result = this.addResources (resources);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 6:  // MemoryCatcherApp/MemoryCatcher/viewResources
       {
         int $result = (int)0;
         $result = this.viewResources ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 7:  // MemoryCatcherApp/MemoryCatcher/shareMemory
       {
         int memoryId = in.read_long ();
         String ShareUserId = in.read_string ();
         int $result = (int)0;
         $result = this.shareMemory (memoryId, ShareUserId);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 8:  // MemoryCatcherApp/MemoryCatcher/shareResources
       {
         int resources = in.read_long ();
         String name = in.read_string ();
         int $result = (int)0;
         $result = this.shareResources (resources, name);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 9:  // MemoryCatcherApp/MemoryCatcher/addMessage
       {
         String messageName = in.read_string ();
         String messageContent = in.read_string ();
         String receiver = in.read_string ();
         int $result = (int)0;
         $result = this.addMessage (messageName, messageContent, receiver);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 10:  // MemoryCatcherApp/MemoryCatcher/getAllMessages
       {
         MemoryCatcherApp.Message $result[] = null;
         $result = this.getAllMessages ();
         out = $rh.createReply();
         MemoryCatcherApp.AllMessagesHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MemoryCatcherApp/MemoryCatcher:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _MemoryCatcherImplBase
