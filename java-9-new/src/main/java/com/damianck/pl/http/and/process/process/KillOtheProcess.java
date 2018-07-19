package com.damianck.pl.http.and.process.process;

public class KillOtheProcess {
    public static void main(String[] args) {

        ProcessHandle notepadHandle =
                ProcessHandle
                        .allProcesses()
                        .filter(x -> x.info().command().map(cmd -> cmd.contains("notepad")).orElse(false))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(notepadHandle.info());

        notepadHandle.onExit()
                .thenAccept(x -> System.out.println("The process was killed by java"));

        boolean shutdown = notepadHandle.destroy();

        notepadHandle.onExit().join();

        System.out.println(shutdown);

    }
}
