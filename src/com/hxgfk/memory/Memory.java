package com.hxgfk.memory;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface Memory {
    Memory INSTANCE = (Memory) Native.loadLibrary("kernel32", Memory.class);

    int OpenProcess(int desiredAccess, boolean heritHandle, int pocessID);

    void CloseHandle(int process);

    boolean ReadProcessMemory(int process, int baseAddress, Pointer buffer, int size, int bytesread);

    boolean WriteProcessMemory(int process, int baseAddress, long[] value, int size, int byteswrite);
}
