package com.dima;

import collections.HashMap;
import collections.HashTable;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Create empty hash table.");
            HashTable ht = new HashTable();
            System.out.println(ht.toString());
            System.out.println("Adding 10.");
            ht.add(new Integer(10));
            System.out.println(ht.toString());
            System.out.println("Adding 1.");
            ht.add(new Integer(1));
            System.out.println(ht.toString());
            System.out.println("Adding 2.");
            ht.add(new Integer(2));
            System.out.println(ht.toString());
            System.out.println("Adding 10.");
            ht.add(new Integer(10));
            System.out.println(ht.toString());
            System.out.println("Removing 10.");
            ht.remove(new Integer(10));
            System.out.println(ht.toString());
            System.out.println("Removing 10.");
            ht.remove(new Integer(10));
            System.out.println(ht.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            HashMap ht = new HashMap();
            System.out.println(ht.toString());
            Integer in = new Integer(1);

            ht.put(in, "213");
            System.out.println(ht.toString());
            ht.put(new Integer(2), "213");
            System.out.println(ht.toString());
            ht.remove(in);
            System.out.println(ht.toString());
            ht.remove(new Integer(2));
            System.out.println(ht.toString());
            ht.put(new Integer(6), "213");
            System.out.println(ht.toString());
            System.out.println("Is Empty: " + ht.isEmpty());
            ht.remove(new Integer(6));
            System.out.println(ht.toString());
            System.out.println("Is Empty: " + ht.isEmpty());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
