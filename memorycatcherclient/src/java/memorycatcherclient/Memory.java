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
public final class Memory
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
}
