package org.example.service;

public interface ArgumentProcessor {
    boolean validate(String[] args);

    void process(String[] args);
}
