public class Browser {

    // takes in the address as user input and then leads all other methods
    // and then finally outputs the product html of all the processing.
    public void navigate(String address) {
        // this method is the lead method
        String ip_number = findIPAddress(address);
        String html = sendHTTPRequest(ip_number);
        System.out.println(html);

    }


        //converts the user input address to ip number looking it up at DNS
    private String findIPAddress(String address){
        return "ip number";
    }

    //takes ip number as input and return html content received
    private String sendHTTPRequest(String ip_number){
        return "<html> <body>HTTP CONTENT</body> </html>";
    }
}
