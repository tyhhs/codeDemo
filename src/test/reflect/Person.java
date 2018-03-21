package test.reflect;

/**
 * Person
 * Author: bjtangyunhao
 * Creation date: 2018年03月16日 11:26
 * Modified by: bjtangyunhao
 * Last modified: 2018年03月16日 11:26
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
