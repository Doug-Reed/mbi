package mbi.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;


@Document(collection = "archives", schemaVersion= "1.0")
public class Archive{
    @Id
    private String responseID; 
    private String response;
    private String comment;

    public Archive(Response response) {
        setComment(response.getComment());
        setResponse(response.getResponse());
        this.responseID = response.getResponseID();
    }
    public String getResponseID() {
        return this.responseID;
    }
    public String getResponse() {
        return this.response;
    }

    public String getComment() {
        return this.comment;
    }
    public void setResponse(String response) {
        this.response = response;
    } 

    public void setComment(String comment) {
        this.comment = comment;
    } 
}