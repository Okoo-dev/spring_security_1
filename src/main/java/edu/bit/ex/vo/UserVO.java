package edu.bit.ex.vo;

// USERNAME NOT NULL VARCHAR2(50)
// PASSWORD NOT NULL VARCHAR2(100)
// ENABLED           CHAR(1)

public class UserVO {
    
    private String username;
    private String password;
    private int enabled;
    
    public UserVO() {
        this("user", "1111" ,1);
    }

    @Override
    public String toString() {
        return "UserVO [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public UserVO(String username, String password, int enabled) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    
}
