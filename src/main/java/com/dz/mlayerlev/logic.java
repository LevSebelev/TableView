package com.dz.mlayerlev;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class logic {
    ArrayList<phone> phones = new ArrayList<>();
    dal dt;
    List<String> lines;
    logic(String file) throws IOException {
        dt = new dal(file);
        for(int i = 0; i!= dt.GetEndIndex();i++)
        phones.add(new phone(dt.GetLine(i)));
    }
    public int GetEndIndex(){
        return phones.size();
    }
    public String getName(int n) {
        return phones.get(n).getName();
    }

    public String getPhoneNumber(int n) {
        return phones.get(n).getPhoneNumber();
    }

    public String getHomeAddress(int n) {
        return phones.get(n).getHomeAddress();
    }

    public String getEmail(int n) {
        return phones.get(n).getEmail();
    }
    public void remove(int n){
        phones.remove(n);
        dt.deleteLine(n);
    }
    public void add(String a,String b,String c,String d){
        phones.add(new phone(a+"|"+b+"|"+c+"|"+d));
        dt.addLine(a+"|"+b+"|"+c+"|"+d);
    }
    public void save() throws IOException {
        dt.saveToFile();

    }
    public int search(String a){
        for(int i = 0; i!= dt.GetEndIndex();i++){
            if(phones.get(i).getEmail().equals(a))return i;
        if(phones.get(i).getName().equals(a))return i;
        if(phones.get(i).getHomeAddress().equals(a))return i;
        if(phones.get(i).getPhoneNumber().equals(a))return i;
        }
        return -1;
    }
}
