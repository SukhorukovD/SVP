package com.dima;

import collections.LinnearList;
import collections.Stack;

public class Main {
    public static void main(String[] args) {

        LinnearList list_1 = new LinnearList();
        System.out.println(list_1.isEmpty());

        LinnearList list_2 = new LinnearList();
        list_1.add(list_2);

        System.out.println(list_1.contains(list_2));
        System.out.println(list_1.get(0));

        list_1.remove(0);
        System.out.println(list_1.contains(list_2));

        list_1.add(0, list_2);
        System.out.println(list_1.contains(list_2));

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
    }
}
