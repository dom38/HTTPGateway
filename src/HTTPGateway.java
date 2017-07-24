import org.apache.http.HttpEntity;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.ws.http.HTTPException;

public class HTTPGateway {

    public String GETRequest(String instance, String instanceGETRequest, String username, String password) throws HTTPException, IOException{

        StringBuilder returnedResponse = new StringBuilder();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(new HttpHost(instance)),
                new UsernamePasswordCredentials(username, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        try {

            HttpGet httpget = new HttpGet(instanceGETRequest);
            httpget.setHeader("Accept", "application/json");
            returnedResponse.append("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);

            try {

                returnedResponse.append("----------------------------------------");
                returnedResponse.append(response.getStatusLine());
                String responseBody = EntityUtils.toString(response.getEntity());
                returnedResponse.append(responseBody);

            } catch (Exception e) {

                return e.toString();

            } finally {

                response.close();
                return returnedResponse.toString();

            }

        } finally {

            httpclient.close();


        }


    }

    public String POSTRequest(String data, String instance, String username, String password, String postURL) throws HTTPException, IOException {

        StringBuilder returnedResponse = new StringBuilder();
        String postData = data;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(new HttpHost(instance)),
                new UsernamePasswordCredentials(username, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        try {

            HttpPost httpPost = new HttpPost(postURL);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            HttpEntity entity = new ByteArrayEntity(postData.getBytes("utf-8"));
            httpPost.setEntity(entity);
            returnedResponse.append("Executing request " + httpPost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {

                returnedResponse.append("----------------------------------------");
                returnedResponse.append(response.getStatusLine());
                String responseBody = EntityUtils.toString(response.getEntity());
                returnedResponse.append(responseBody);

            } catch (Exception e) {

                return e.toString();

            } finally {

                response.close();
                return returnedResponse.toString();

            }

        } finally {

            httpclient.close();

        }

    }

    public String PATCHRequest(String data, String instance, String username, String password, String patchURL) throws HTTPException, IOException {

        StringBuilder returnedResponse = new StringBuilder();
        String postData = data;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(new HttpHost(instance)),
                new UsernamePasswordCredentials(username, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        try {

            HttpPatch httpPatch = new HttpPatch(patchURL);
            httpPatch.setHeader("Accept", "application/json");
            httpPatch.setHeader("Content-Type", "application/json");
            HttpEntity entity = new ByteArrayEntity(postData.getBytes("utf-8"));
            httpPatch.setEntity(entity);
            returnedResponse.append("Executing request " + httpPatch.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpPatch);

            try {

                returnedResponse.append("----------------------------------------");
                returnedResponse.append(response.getStatusLine());
                String responseBody = EntityUtils.toString(response.getEntity());
                returnedResponse.append(responseBody);

            } catch (Exception e) {

                return e.toString();

            } finally {

                response.close();
                return returnedResponse.toString();

            }

        } finally {

            httpclient.close();

        }

    }

    public String DELETERequest(String instance, String instanceDELETERequest, String username, String password) throws HTTPException, IOException {

        StringBuilder returnedResponse = new StringBuilder();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(new HttpHost(instance)),
                new UsernamePasswordCredentials(username, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        try {

            HttpDelete httpDelete = new HttpDelete(instanceDELETERequest);
            httpDelete.setHeader("Accept", "application/json");
            returnedResponse.append("Executing request " + httpDelete.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpDelete);

            try {

                returnedResponse.append("----------------------------------------");
                returnedResponse.append(response.getStatusLine());

            } catch (Exception e) {

                return e.toString();

            } finally {

                response.close();
                return returnedResponse.toString();

            }

        } finally {

            httpclient.close();

        }

    }

}
