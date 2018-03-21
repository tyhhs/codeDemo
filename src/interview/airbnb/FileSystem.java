package interview.airbnb;

import interview.airbnb.struct.Interval;

import java.util.*;

/**
 * FileSystem
 * Author: bjtangyunhao
 * Creation date: 2017年09月12日 17:35
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月12日 17:35
 */
public class FileSystem {
    public static void main(String[] args) {
        FileSystem system = new FileSystem();
        System.out.println(system.creat(system.root, "/a", "1"));
        System.out.println(system.creat(system.root, "/a/b/c", "3"));
        System.out.println(system.creat(system.root, "/a/b", "2"));
        System.out.println(system.creat(system.root, "/a/b/c", "3"));
        System.out.println(system.get(system.root, "/a/b/c"));
    }
    TireNode root;
    public FileSystem(){
        this.root = new TireNode(null,null);
    }

    public String creat(TireNode root, String path, String value){
        List<String> files = getFiles(path);
        for(int i = 0; i < files.size() - 1; i++){
            if(!root.files.containsKey(files.get(i))){
                return "ERROR";
            }
            root = root.files.get(files.get(i));
        }
        root.files.put(files.get(files.size() - 1), new TireNode(files.get(files.size() - 1), value));
        return "SUCCESS";
    }

    public String get(TireNode root, String path){
        List<String> files = getFiles(path);
        for(int i = 0; i < files.size(); i++){
            if(!root.files.containsKey(files.get(i))){
                return "ERROR";
            }
            root = root.files.get(files.get(i));
        }
        return root.value;
    }

    public List<String> getFiles(String path){
        List<String> files = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : path.toCharArray()){
            if(c == '/'){
                if(sb.length() != 0){
                    files.add(sb.toString());
                    sb = new StringBuilder();
                }
            }else{
                sb.append(c);
            }
        }
        if(sb.length() != 0){
            files.add(sb.toString());
        }
        return files;
    }
    class TireNode{
        String file;
        String value;
        Map<String, TireNode> files;

        public TireNode(String file, String value){
            this.file = file;
            this.value = value;
            this.files = new HashMap<>();
        }
    }
}
