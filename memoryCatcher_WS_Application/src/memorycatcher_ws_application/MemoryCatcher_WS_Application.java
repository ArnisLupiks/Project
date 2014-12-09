/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycatcher_ws_application;

/**
 *
 * @author Arnis
 */
public class MemoryCatcher_WS_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    
    }

    private static int addMemory(java.lang.String memoryName, java.lang.String memoryDescription) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.addMemory(memoryName, memoryDescription);
    }

    private static int addMessage(java.lang.String sender, java.lang.String messageName, java.lang.String messageContent, java.lang.String receiver) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.addMessage(sender, messageName, messageContent, receiver);
    }

    private static int addResources(int resources) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.addResources(resources);
    }

    private static int login(java.lang.String username, java.lang.String password) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.login(username, password);
    }

    private static int register(java.lang.String username, java.lang.String email, java.lang.String password) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.register(username, email, password);
    }

    private static boolean removeMemory(int memoryID) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.removeMemory(memoryID);
    }

    private static int shareResources(int resources, java.lang.String name) {
        org.me.memorycatcher.MemoryCatcherWS_Service service = new org.me.memorycatcher.MemoryCatcherWS_Service();
        org.me.memorycatcher.MemoryCatcherWS port = service.getMemoryCatcherWSPort();
        return port.shareResources(resources, name);
    }
       
}
