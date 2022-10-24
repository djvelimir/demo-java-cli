package org.example.display;

public class TerminalImpl implements Terminal {
    @Override
    public void show(String message) {
        System.out.println(message);
    }
}
