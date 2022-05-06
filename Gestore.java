import java.net.ServerSocket;
import java.net.Socket;

public class Gestore {


    public void start(){

        ServerSocket server = null;

        try {

            server = new ServerSocket(6789);

            while(true){

                Socket client = server.accept();
                ServerThread st = new ServerThread(client);
                st.start();

            }
        }

        catch(Exception e){};

    }

    public static void main(String[] args) {
        Gestore g = new Gestore();
        g.start();

    }
}