package main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main {
  
  public static void main(String args[]) {
    
    Profile p = new ProfileImpl();
    p.setParameter(Profile.MAIN_HOST, "localhost"); //$NON-NLS-1$
    p.setParameter(Profile.MAIN_PORT, "3250"); //$NON-NLS-1$
    
    Runtime r = Runtime.instance();
    ContainerController cc = r.createMainContainer(p);
    if (cc != null) {
      try {
        AgentController ac = cc.createNewAgent("deneme", "agent.Human", null); //$NON-NLS-1$ //$NON-NLS-2$
        ac.start();
      } catch (StaleProxyException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
     

  }
  
}
