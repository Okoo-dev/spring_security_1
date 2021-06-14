package edu.bit.ex.vo;

// USERNAME NOT NULL VARCHAR2(50)
// PASSWORD NOT NULL VARCHAR2(100)
// ENABLED           CHAR(1)

public class AuthVO {
    private String username;
    private String authority;
    
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    @Override
    public String toString() {
        return "AuthVO [username=" + username + ", authority=" + authority + "]";
    }
    public AuthVO(String username, String authority) {
        super();
        this.username = username;
        this.authority = authority;
    }
    
    public AuthVO() {}
    
}
