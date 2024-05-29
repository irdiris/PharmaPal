package com.example.pharmapal.interfaces;

import java.io.IOException;

public interface DataBaseServiceInterface {
    String backUpDataBase(String path) throws IOException, InterruptedException;
    String restoreDataBase(String file) throws IOException, InterruptedException;
}
