import java.net.InetAddress;
import java.net.UnknownHostException;

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
        return "<html> <body>HTTP CONTENT</body> </html>";
    }
}
