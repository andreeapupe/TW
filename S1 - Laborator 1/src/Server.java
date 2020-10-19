import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Server {
    public static void main(String[] args){

        try{
            //Creating the server socket:
            ServerSocket socket = new ServerSocket ();

            //Binding to the local socket address -- this is the one the clients should be connecting to:
            InetAddress localIpAddress = InetAddress.getByName ("0.0.0.0");
            int localIpPort = 20000;
            SocketAddress localSocketAddress = new InetSocketAddress(localIpAddress, localIpPort);
            socket.bind (localSocketAddress);

            while (true) {

                //For each connection accepting a client socket, and:
                final Socket client = socket.accept ();

                // Starting a new Thread for each client
                new Thread () {

                    public void run () {
                        try {
                            //Receiving and/or sending data;
                            BufferedReader reader = new BufferedReader (new InputStreamReader(client.getInputStream ()));
                            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(client.getOutputStream ()));

                            // Reading the request
                            String request = reader.readLine ();
                            // Write the response
                            String response = "Welcome";
                            writer.write(response);
                            writer.newLine();
                            // Do not forget to flush!
                            writer.flush();

                            client.close ();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }

            //Closing the server socket;
            socket.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
