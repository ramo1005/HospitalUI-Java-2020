package com.ramon.proyectofinal.modelos;

/**
 *
 * @author el_an
 */
public class Doctor {
    
        //Personal Information
    	private String name;
	    private String lastName;
	    private int age;
	    private String especiality;
	    private String sex;
	    private String user;
        private String password;
	

       //Set and Get from the Doctor

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
}
