package web4.web4.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String space;
    private String qq;

    public Long getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
    public String getphone()
    {
        return phone;
    }
    public String getemail(){
        return email;
    }
    public String getspace(){
        return space;
    }
    public String getqq(){
        return qq;
    }
    public void setname(String id){
        this.name = id;
    }
    public void setphone(String id){
        this.phone = id;
    }
    public void setemail(String id){
        this.email = id;
    }
    public void setspace(String id){
        this.space = id;
    }
    public void setqq(String id){
        this.qq = id;
    }
    public void setid(Long id){
        this.id = id;
    }
}
