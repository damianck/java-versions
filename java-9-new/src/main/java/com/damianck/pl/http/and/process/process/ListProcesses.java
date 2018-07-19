package com.damianck.pl.http.and.process.process;

public class ListProcesses {
    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .forEach(ListProcesses::printInfo);
    }

    public static void printInfo(ProcessHandle.Info info) {
        if (info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get() +
                    ", command: " + info.command().get());
        }
    }
}
