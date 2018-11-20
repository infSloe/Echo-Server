// aus Java von Kopf bis Fuß

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    int portNummer;

    public EchoServer(int portnummer_)
    {
        portNummer = portnummer_;
    }

    public void start() {

        String nachricht = "";

        try {
            ServerSocket serverSock = new ServerSocket(portNummer);
            Socket socket = serverSock.accept();
            System.out.println("Verbindung mit Client steht");

            // Zum Schreiben in die Socket
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // Zum Lesen aus der Socket
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            // Warte auf eine Nachricht vom Client und schicke sie zurück
            while((nachricht = reader.readLine())!= null)
            {           
                System.out.println("Habe eine Nachricht empfangen!");

                // Sende das Echo:
                writer.println("Echo: " + nachricht);
                writer.flush();
            }
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } 

}

