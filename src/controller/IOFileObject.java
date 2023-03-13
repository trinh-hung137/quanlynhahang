/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Admin;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Thanh
 */
public class IOFileObject {
    public static Admin readFile(String file){
        Admin ad = new Admin();
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream(file));
            ad = (Admin) o.readObject();
            o.close();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return ad;
    }

    public static void writeFile(String file, Admin ad){
        try{
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(file));
            o.writeObject(ad);
            o.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
