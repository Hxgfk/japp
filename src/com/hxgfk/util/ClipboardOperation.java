package com.hxgfk.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipboardOperation {
    public static void set(String value){
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(value), null);
    }

    public static String get(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        if (transferable != null){
            if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)){
                try{
                    return (String) transferable.getTransferData(DataFlavor.stringFlavor);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }
}
