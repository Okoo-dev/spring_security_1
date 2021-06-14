package edu.bit.ex.vo;

import java.sql.Timestamp;


public class EmpVO {
   
   @Override
    public String toString() {
        return "EmpVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal
                + ", comm=" + comm + ", deptno=" + deptno + "]";
    }

public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public EmpVO() {
    }

    public EmpVO(String empno, String ename, String job, Timestamp hiredate, int sal, int comm, int deptno) {
        super();
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Timestamp getHiredate() {
        return hiredate;
    }

    public void setHiredate(Timestamp hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

private String empno;
   private String ename;
   private String job;
   private Timestamp hiredate;
   private int sal;
   private int comm;
   private int deptno;
   
   public String getAuthority() {
      if(getJob().toUpperCase().contains("MANAGER")) {
         return "ROLE_ADMIN";
      } else {
         return "ROLE_USER";
      }
      
   }

}