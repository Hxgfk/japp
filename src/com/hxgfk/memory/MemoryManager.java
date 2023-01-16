package com.hxgfk.memory;

import com.sun.jna.Library;

import java.io.IOException;

public interface MemoryManager extends Library {
    int OpenProcess(int processId);

    int OpenProcess(String processName) throws IOException;

    void CloseHandle(int processId);

    int ReadIntProcessMemory(int processId, int address);

    int ReadIntProcessMemory(int processId, int... addresss);

    void WriteIntProcessMemory(int processId, long value, int address);

    void WriteIntProcessMemory(int processId, long value, int... addresss);
}
