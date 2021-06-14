package edu.bit.ex.vo;

import java.util.List;

// USERNAME NOT NULL VARCHAR2(50)
// PASSWORD NOT NULL VARCHAR2(100)
// ENABLED           CHAR(1)

public class MemberVO {
    
    private String username;
    private String password;
    private String enabled;
    
    private List<AuthVO> authList;

    
    public List<AuthVO> getAuthList() {
        return authList;
    }

    public void setAuthList(List<AuthVO> authList) {
        this.authList = authList;
    }

    @Override
    public String toString() {
        return "MemberVO [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authList="
                + authList + "]";
    }
    
    public MemberVO() {}
    
    public MemberVO(String username, String password, String enabled, List<AuthVO> authList) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authList = authList;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


    
}
