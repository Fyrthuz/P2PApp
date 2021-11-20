/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Diego
 */
public class Servidor {
    
    static Registry r;
    
    //This method starts a RMI registry on the local host, if
    //it does not already exists at the specified port number.
    private static void startRegistry(int RMIPortNum)
            throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
            // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {
            // No valid registry at that port.
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
        }
    } // end startRegistry

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        //RMI en un hilo(escucha todas las peticiones)
        baseDatos.FachadaBaseDatos fbase = new baseDatos.FachadaBaseDatos();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String portNum, registryURL;
        try {
            System.out.println("Enter the RMIregistry port number:");
            portNum = (br.readLine()).trim();
            int RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            ImplServidor exportedObj = new ImplServidor(fbase);
            registryURL = "rmi://localhost:" + portNum + "/callback";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("Callback Server ready.");
        }// end try
        catch (Exception re) {
            System.out.println("Exception in HelloServer.main: " + re);
        } // end catch

    } // end main

    
}
