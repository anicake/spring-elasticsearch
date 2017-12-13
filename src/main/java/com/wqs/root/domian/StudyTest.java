package com.wqs.root.domian;

import java.util.*;

public class StudyTest<T> {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> listS=new ArrayList<Integer>();
        listS.add(11);
        listS.add(22);
        listS.add(33);
        Integer i=5;
        ListIterator<Integer> it=list.listIterator();
        System.out.println(it.hasPrevious());
        while (it.hasPrevious()){
            i=it.next();
        }
        it=listS.listIterator();

        while (it.hasPrevious()){
            System.out.println(it.previous());
            it.set(i);
        }
        System.out.println(i+listS.toString());
    }

}
