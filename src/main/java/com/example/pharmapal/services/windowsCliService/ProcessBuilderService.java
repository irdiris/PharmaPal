package com.example.pharmapal.services.windowsCliService;

import com.example.pharmapal.interfaces.ProcessBuilderServiceInterface;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class ProcessBuilderService implements ProcessBuilderServiceInterface {

    Process process;

    public int openCli(List<String> commandFragments) throws IOException, InterruptedException {

            ProcessBuilder processBuilder = new ProcessBuilder(commandFragments);
            Process process = processBuilder.start();

            // Read the standard output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Read the error stream of the process
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder errorOutput = new StringBuilder();

            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            return exitCode;

    }
}
