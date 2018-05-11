package test.DesignPattern.Singleton;

/**
 * LazySingleton
 * Author: bjtangyunhao
 * Creation date: 2018年05月09日 16:57
 * Modified by: bjtangyunhao
 * Last modified: 2018年05月09日 16:57
 */

//https://blog.csdn.net/zhengzhb/article/details/7331369
public class LazySingleton {
    private static LazySingleton singleton;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance(){
        if(singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
