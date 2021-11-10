package com.epam.proofy;

import com.jsunsoft.http.*;
import org.apache.http.entity.ContentType;

public class Rest {
    private final String uri;

    private static final HttpRequest httpRequest =
            HttpRequestBuilder.create(ClientBuilder.create().build())
                    .addContentType(ContentType.APPLICATION_JSON)
                    .build();

    public Rest(String uri) {
        this.uri = uri;
    }

    public void send(String jsonData) {
        httpRequest.target(uri).get(jsonData, new TypeReference<String>() {
        })
                .ifSuccess(this::whenSuccess) //call whenSuccess method if request is success
                .otherwise(this::whenNotSuccess); //call whenNotSuccess method if request is success
    }

    private void whenSuccess(ResponseHandler<String> responseHandler) {
        //When predicate of filter returns true, calls whenHasContent else calls whenHasNotContent
        responseHandler.filter(ResponseHandler::hasContent) //if request has content will be executed ifPassed consumer else otherwise consumer
                .ifPassed(this::whenHasContent)  //call hasContent method if request body is present
                .otherwise(this::whenHasNotContent);
    }

    private void whenNotSuccess(ResponseHandler<String> responseHandler) {
        //For demo. You can handle what you want
        System.err.println("Error code: " + responseHandler.getStatusCode() + ", error message: " + responseHandler.getErrorText());
    }

    private void whenHasContent(ResponseHandler<String> responseHandler) {
        //For demo.
        String responseBody = responseHandler.get();
        System.out.println("all fine: " + responseBody);
    }

    private void whenHasNotContent(ResponseHandler<String> responseHandler) {
        //For demo.
        System.out.println("Response is success but body is missing. Response code: " + responseHandler.getStatusCode());
    }
}