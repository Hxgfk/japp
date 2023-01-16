package com.hxgfk.memory;

import com.sun.jna.Pointer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MemoryManagerImpl {
    public int OpenProcess(int processId) {
        //0x1F0FFF获取最大权限
        return Memory.INSTANCE.OpenProcess(0x1F0FFF, false, processId);
    }

    public int OpenProcess(String processName) throws IOException {
        Process process = Runtime.getRuntime().exec("TASKLIST /FI \"IMAGENAME eq " + processName + "\"");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(process.getInputStream()), StandardCharsets.UTF_8));
        String str;
        int pid = -1;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.contains(processName)) {
                pid = Integer.parseInt(str.substring(processName.length(), str.indexOf("Console")).trim());
            }
        }
        if (pid != -1) {
            return this.OpenProcess(pid);
        } else {
            return -1;
        }
    }

    public void CloseHandle(int processId) {
        Memory.INSTANCE.CloseHandle(processId);
    }

    public int ReadIntProcessMemory(int processId, int address) {
        Pointer buffer = new com.sun.jna.Memory(4);
        Memory.INSTANCE.ReadProcessMemory(processId, address, buffer, 4, 0);
        return buffer.getInt(0);
    }

    public int ReadIntProcessMemory(int processId, int... addresss) {
        int address = 0;
        for (int addr : addresss) {
            address = ReadIntProcessMemory(processId, addr + address);
        }
        return address;
    }

    public void WriteIntProcessMemory(int processId, long value, int address) {
        Memory.INSTANCE.WriteProcessMemory(processId, address, new long[]{value}, 4, 0);
    }

    public void WriteIntProcessMemory(int processId, long value, int... addresss) {
        int[] t_a = new int[addresss.length - 1];
        System.arraycopy(addresss, 0, t_a, 0, t_a.length);
        WriteIntProcessMemory(processId, value, this.ReadIntProcessMemory(processId, t_a) + addresss[addresss.length - 1]);
    }
}
