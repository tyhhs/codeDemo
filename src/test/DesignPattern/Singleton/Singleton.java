package test.DesignPattern.Singleton;

/**
 * Singleton
 * Author: bjtangyunhao
 * Creation date: 2018年05月09日 16:51
 * Modified by: bjtangyunhao
 * Last modified: 2018年05月09日 16:51
 */

//https://blog.csdn.net/zhengzhb/article/details/7331369
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}
