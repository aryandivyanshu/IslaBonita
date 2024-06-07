import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.*;
import java.io.IOException;

public class Browser {

    // takes in the address as user input and then leads all other methods
    // and then finally outputs the product html of all the processing.
    public void navigate(String address) {
        // this method is the lead method

        String ipAddressVariableAsParameter = findIPAddress(address);
        //will set the return of findIPAddress method, aka "ipAddress" variable's value as value of variable (ipAddressVariableAsParameter) to be sent as parameter in next method.

        String html = sendHTTPRequest(ipAddressVariableAsParameter);
        System.out.println(html);

    }


        //converts the user input address to ip number looking it up at DNS
    private String findIPAddress(String address){
        String ipAddress = null;

        try {
            InetAddress addressObject = InetAddress.getByName(address);
            ipAddress = addressObject.getHostAddress();
            System.out.println("IP Address of " + address + " : " + ipAddress);
        }

        catch (UnknownHostException ex) {
            System.out.println("Could not resolve domain: " + address);
            ex.printStackTrace();
        }

        return ipAddress ;

    }

        //takes ip number as input and return html content received
    private String sendHTTPRequest(String ipAddress){


        //establishing a TCP aka Transmission Control Protocol connection with the web server at that IP address
        int serverPort = 443; // Server port number
        //tf is a port n why does serverPort = 80; works too lol

        try {
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

            // No need to send or receive data, just keep the connection open if needed
            // ...

            // Close the connection when done
            socket.close();
        }

        catch (UnknownHostException e) {
            System.err.println("Unknown host: " + ipAddress);
        }

        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }

        return "<html> <body>HTTP CONTENT</body> </html>";

    }
}
