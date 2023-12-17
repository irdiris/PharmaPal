package com.example.pharmapal.Interfaces;

import java.io.IOException;
import java.util.List;

public interface ProcessBuilderServiceInterface {
    public int openCli(List<String> commandFragments) throws IOException, InterruptedException;
}
