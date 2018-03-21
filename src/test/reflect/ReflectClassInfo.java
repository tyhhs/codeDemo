package test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ReflectClassInfo
 * Author: bjtangyunhao
 * Creation date: 2018年03月16日 11:25
 * Modified by: bjtangyunhao
 * Last modified: 2018年03月16日 11:25
 */
public class ReflectClassInfo {
    public static void main(String[] args) {
        Employee employee = new Employee("tony", "engineer", 20000D);
        employee.desc();

        Class c = employee.getClass();
        String cModifier = Modifier.toString(c.getModifiers());
        System.out.println(cModifier + " class " + c.getName());

        Field[] cFields = c.getDeclaredFields();
        if(cFields.length != 0){
            for(Field field : cFields){
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getGenericType().getTypeName() + " " + field.getName() + ";");
            }
        }

        Method[] methods = c.getDeclaredMethods();
        if(methods.length != 0){
            for(Method method : methods){
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getGenericReturnType().getTypeName() + " " + method.getName());
            }
        }
    }
}
