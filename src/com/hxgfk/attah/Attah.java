package com.hxgfk.attah;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class Attah {
    private VirtualMachine vm;

    public Attah(String pid) throws IOException, AttachNotSupportedException {
        this.vm = VirtualMachine.attach(pid);
    }

    public VirtualMachine getVm() {
        return this.vm;
    }

    public void agent(String path){
        try{
            try {
                this.vm.loadAgent(path);
            }finally {
                this.vm.detach();
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
