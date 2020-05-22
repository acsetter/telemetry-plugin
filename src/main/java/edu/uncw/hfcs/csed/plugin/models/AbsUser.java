package edu.uncw.hfcs.csed.plugin.models;

public abstract class AbsUser {
    private String userName;
    private String token;
    private boolean authenticated;

    AbsUser(String userName, String token, boolean authenticated) {
        this.userName = userName;
        this.token = token;
        this.authenticated = authenticated;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

}
