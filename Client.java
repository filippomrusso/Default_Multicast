import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client{

    Socket client;
    String nomeServer = "localhost";
    int porta = 6789;

    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){

        try{
            client = new Socket(nomeServer,porta);
            outVersoServer = new DataOutputStream(client.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (Exception e){};

        return client;
    }

    public void comunica(){
        try {

            outVersoServer.writeBytes(" * Ciao mi sono connesso a te, mi chiamo client *" + "\n");

            String s = inDalServer.readLine();
            System.out.println(s);

            outVersoServer.close();
            inDalServer.close();
            client.close();
        }

        catch (Exception e){};

    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connetti();
        c.comunica();
    }


}