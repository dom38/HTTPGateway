import static org.junit.Assert.*;
import org.junit.Test;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;


public class HTTPGatewaytest {

    @Test
    public void assertGETRequestReturnsAString() throws IOException, HTTPException {

        HTTPGateway gateway = new HTTPGateway();
        String result = gateway.GETRequest("https://httpbin.org/", "https://httpbin.org/ip", "", "");
        //System.out.println(result);
        assertNotNull(result);

    }

    @Test
    public void assertPOSTRequestReturnsAString() throws IOException, HTTPException {

        HTTPGateway gateway = new HTTPGateway();
        String result = gateway.POSTRequest("This should be returned", "https://httpbin.org/", "https://httpbin.org/post", "", "");
        //System.out.println(result);
        assertNotNull(result);

    }

    @Test
    public void assertPOSTSOAPRequestReturnsAString() throws IOException, HTTPException {

        HTTPGateway gateway = new HTTPGateway();
        String result = gateway.POSTRequestSOAP("Add", "<SOAP>insert<SOAP>","https://httpbin.org/", "https://httpbin.org/post", "", "");
        System.out.println(result);
        assertNotNull(result);

    }

    @Test
    public void assertPATCHRequestReturnsAString() throws IOException, HTTPException {

        HTTPGateway gateway = new HTTPGateway();
        String result = gateway.PATCHRequest("Return this", "https://httpbin.org/", "https://httpbin.org/patch","","");
        System.out.println(result);
        assertNotNull(result);

    }

    @Test
    public void assertDELETERequestReturnsAString() throws IOException, HTTPException {

        HTTPGateway gateway = new HTTPGateway();
        String result = gateway.DELETERequest("https://httpbin.org/", "https://httpbin.org/delete", "", "");
        System.out.println(result);
        assertNotNull(result);

    }

}
