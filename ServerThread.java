import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerThread extends Thread{

    Socket client;
    DataOutputStream outVersoClient;
    BufferedReader inDalClient;

    public ServerThread(Socket client){
            this.client = client;
    }

    @Override
    public void run(){

        try{
            comunica();
        }

        catch (Exception e){};

    }

    public void comunica(){

        try {
            outVersoClient = new DataOutputStream(client.getOutputStream());
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String s = inDalClient.readLine();
            System.out.println(s);

            s = " + Mi sono connesso a te, mi chiamo server +";
            outVersoClient.writeBytes(s + "\n");

            outVersoClient.close();
            inDalClient.close();
            client.close();
        }
        catch (Exception e){

        }
    }
}