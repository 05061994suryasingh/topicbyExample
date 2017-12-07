package com.chromeinfotech.stringoperation;

import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 16/3/17.
 */

public class MyString {
    public void Reverse(String string){
        int i;
        char ch[]=new char[string.length()];
        for(i=string.length()-1;i>=0;i--){
            if(ch[i] == ' '){
                --i;
            }
            else {
                ch[i] = string.charAt(i);
                Utils.printLog("char", "=" + ch[i]);
            }
        }

//        for(i=0;i < string.length();i++)
//
    }
}

