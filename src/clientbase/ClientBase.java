/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientbase;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertura connessione");
        Scanner sc = new Scanner(System.in);
        try {
            
            while(true){
                Socket server = new Socket("127.0.0.1", 5500);
               
                InputStream dalServer = server.getInputStream();
                BufferedReader lettore = new BufferedReader(
                        new InputStreamReader(dalServer));

                
                OutputStream versoIlServer = server.getOutputStream();
                BufferedWriter scrittore= new BufferedWriter(new OutputStreamWriter(versoIlServer));
                
                System.out.println("Inserisci frase");
                String frase = sc.next();
                scrittore.write(frase);
                
                String risposta = lettore.readLine();
                System.out.println("risposta del server: " + risposta);
                
                    

                lettore.close();
                scrittore.close();
                server.close();
                System.out.println("chiusura connessione");
                Thread.sleep(5000);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {

        }
    }

}
