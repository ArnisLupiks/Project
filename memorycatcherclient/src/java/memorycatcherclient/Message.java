/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycatcherclient;

/**
 *
 * @author Arnis
 */
public final class  Message {
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
}
