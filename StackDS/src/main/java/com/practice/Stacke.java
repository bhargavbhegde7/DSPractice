package com.practice;

/**
 * Created by Bhargav on 12-07-2017.
 */
public class Stacke {
    private int arr[];
    private int index = -1;// stack is empty

    public Stacke(int size){
        arr = new int[size];
    }

    public boolean push(int n){
        try{
            arr[++index] = n;//first increment, then push
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public int pop(){
        return arr[index--];//first pop it, then decrement
    }
}
