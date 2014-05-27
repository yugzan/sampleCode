package org.iii.rest.client;

import com.google.gson.Gson;

public class LoginRequest {
    private String data;
    
    public LoginRequest(String id, String pw) {
        Gson gson = new Gson();
        String json = gson.toJson(new Login(id, pw));
        try {
            this.data = new RSAEncoder().encrypt(json);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

}
