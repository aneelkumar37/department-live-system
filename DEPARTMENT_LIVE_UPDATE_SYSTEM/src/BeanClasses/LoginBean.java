/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

public class LoginBean {
    
private int USER_ID;
private String USER_NAME;
private String USER_PASS;
private String ROLE;

    public int getUSER_ID() {
        return USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getUSER_PASS() {
        return USER_PASS;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public void setUSER_PASS(String USER_PASS) {
        this.USER_PASS = USER_PASS;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    @Override
    public String toString() {
        return "LoginBean{" + "USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", USER_PASS=" + USER_PASS + ", ROLE=" + ROLE + '}';
    }


    
}
