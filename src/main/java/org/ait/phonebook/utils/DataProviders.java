package org.ait.phonebook.utils;

import org.ait.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver1","Oliver Twist", "1243500000567","hty@lkfjlkdf.juh","Berlin","kfje"});
        list.add(new Object[]{"Oliver2","Oliver Twist", "124358686987","hty@lkfjlkdf.juh","Berlin","kfje"});
        list.add(new Object[]{"Oliver3","Oliver Twist", "1243534352627", "hty@lkfjlkdf.juh","Berlin","kfje"});
        return list.iterator();
    }
//newContactWithCSVFile
    @DataProvider
    public Iterator<Object[]> newContactWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));


        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSurname(split[1]).setPhoneNumber(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDiscription(split[5])});
            line = reader.readLine();
        }


        return list.iterator();
    }

}
