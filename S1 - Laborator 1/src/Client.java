import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {

    public static void main(String[] args) {
        //Creating the client socket:

        try{
            Socket socket = new Socket ();

            //Binding to the local socket address:
            InetAddress localIpAddress = InetAddress.getByName ("0.0.0.0");
            int localIpPort = 0;
            SocketAddress localSocketAddress = new InetSocketAddress (localIpAddress, localIpPort);
            socket.bind (localSocketAddress);

            //Connecting to the remote socket address:
            InetAddress remoteIpAddress = InetAddress.getByName ("localhost");
            int remoteIpPort = 20000;
            SocketAddress remoteSocketAddress = new InetSocketAddress(remoteIpAddress, remoteIpPort);
            socket.connect (remoteSocketAddress);

            //Receiving and/or sending data through inbound and outbound streams:
            BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream ()));
            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream ()));

            String request = "Hello";
            writer.write (request);
            writer.newLine ();
            // Do not forget to flush
            writer.flush ();

            // Reading the response
            String response = reader.readLine ();

            //Shutting-down the inbound and outbound streams:
            socket.shutdownInput ();
            socket.shutdownOutput ();

            //Closing the socket:
            socket.close ();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
