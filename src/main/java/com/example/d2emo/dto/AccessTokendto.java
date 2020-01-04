package com.example.d2emo.dto;

public class AccessTokendto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

    /**
     * @return String return the client_id
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * @param client_id the client_id to set
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * @return String return the client_secret
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     * @param client_secret the client_secret to set
     */
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    /**
     * @return String return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return String return the redirect_uri
     */
    public String getRedirect_uri() {
        return redirect_uri;
    }

    /**
     * @param redirect_uri the redirect_uri to set
     */
    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}