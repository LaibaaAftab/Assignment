package com.example.getpost;

public class guest {

    private String firstName;
    private String id;
    private int age;
    private String password;
    public guest()
    {
        firstName = "";
        id="";
        age = 0;
    }

    public guest(String s,String i,int a)
    {
        firstName = s;
        id=i;
        age = a;
    }
    public void setFirstName(String s)
    {
        firstName = s;
    }
    public void setId(String i)
    {
        id = i;
    }
    public void setAge(int a)
    {
        age = a;
    }
    public void setPassword(String s)
    {
        password = s;
    }
    public String getPassword()
    {
        return password;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getId()
    {
        return id;
    }
    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return "Name: "+firstName+" Id: "+id+" Age: "+age;
    }
}
