package com.example.mints.dialogexmp1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mints on 2/21/2017.
 */

public class MyJava {

    public static void main(String[] args) {
        Collection<Integer> c=new ArrayList<Integer>();

        c.add(5);
        c.add(8);
        c.add(20);

        System.out.println(c.size());

        for (Integer o:c) {
            System.out.println(o);
        }
    }
}
