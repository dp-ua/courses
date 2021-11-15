package com.epam.http;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpTestDomain {

    public int getHttpStatusCode(String url) {

        int statusCode = 0;

        int timeout = 3;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000)
                .setSocketTimeout(timeout * 1000).build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

        HttpGet httpget = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpget);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return statusCode;
    }


    public DomainStatus getCheckdomain(String baseUrl) {
        int resultCode = getHttpStatusCode(baseUrl);
        if (resultCode >= 200 && resultCode < 300)
            return DomainStatus.ENABLE;
        else
            return DomainStatus.DISABLE;
    }

    enum DomainStatus {
        ENABLE, DISABLE;
    }

    public static void main(String[] args) {
        String domain = "test.url";
        HttpTestDomain httpTestDomain = new HttpTestDomain();
        String checkdomain = httpTestDomain.getCheckdomain(domain).toString();
        System.out.println(domain + " " + checkdomain);
    }
}
