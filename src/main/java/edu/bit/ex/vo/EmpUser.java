package edu.bit.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class EmpUser extends User {

    private EmpVO emp;

    // 기본적으로 부모의 생성자를 호출해야만 정상적으로 작동

    @Override
    public String toString() {
        return "EmpUser [emp=" + emp + "]";
    }

    public EmpVO getEmp() {
        return emp;
    }

    public void setEmp(EmpVO emp) {
        this.emp = emp;
    }

    public EmpUser(String ename, String empno, Collection<? extends GrantedAuthority> authorities) {
        super(ename, empno, authorities);
    }

    public EmpUser(EmpVO emp) {

        super(emp.getEname(), emp.getEmpno(), getAuth(emp));

        this.emp = emp;
    }

    // 유저가 갖고 있는 권한 목록
    public static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(empVO.getAuthority()));

        return authorities;
    }
}
