package com.chromeinfotech.dialog;

/**
 *implements to set title,actionmessage,titleicon and actionbuttonname
 */

public interface DialogInterface {
    public  void setTitle(String title);
    public  void setActionMessage(String message);
    public  void  titleicom( int iconId);
    public  void setActionButtonname(String btnpositive , String btnnegative);
}
