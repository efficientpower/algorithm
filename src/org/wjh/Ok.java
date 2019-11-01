package org.wjh;

import java.util.ArrayList;
import java.util.List;

public class Ok {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       List<He> list = new ArrayList<He>();
       He he = new He();
       he.setAge(12);
       he.setName("1234");
       list.add(he);
       for(He str : list) {
           he.setName("wwe");
       }
    }

}

class He{
    String name;
    Integer age;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
}
