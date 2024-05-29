package com.example.pharmapal.services;

import com.example.pharmapal.exceptionHandling.commandLineExceptionHandling.exceptions.PathDoesNotExistException;
import com.example.pharmapal.interfaces.DataBaseServiceInterface;
import com.example.pharmapal.services.windowsCliService.DateService;
import com.example.pharmapal.services.windowsCliService.ProcessBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class DataBaseService implements DataBaseServiceInterface {

    private final ProcessBuilderService processBuilderService;
   private  final DateService dateService;

@Autowired
    public DataBaseService(ProcessBuilderService processBuilderService, DateService dateService) {
        this.processBuilderService = processBuilderService;
    this.dateService = dateService;
}

    public String backUpDataBase(String path) throws IOException, InterruptedException {

        List<String> commands = new ArrayList<>();
        commands.add("pg_dump");
        commands.add("-U");
        commands.add("postgres");
        commands.add("-W");
        commands.add("--no-password");
        commands.add("-d");
        commands.add("PaginationTest");

        String timestamp = dateService.getCurrentTimestamp();
        final String defaultPath = "D:\\";
        String outputFileName;

        String sanitizedTimestamp = timestamp.replace(':', '_').replace('/', '_');

        System.out.println(path.isEmpty());
        // determine backup path.
        if (path != null && !path.isEmpty() && !path.trim().isEmpty()) {
            System.out.println("Using provided path");
            outputFileName = path + "test_" + sanitizedTimestamp + ".sql";
            System.out.println(outputFileName);
        } else {
            System.out.println("Using default path");
            outputFileName = defaultPath + "test_" + sanitizedTimestamp + ".sql";
        }


        commands.add("-f");
        commands.add(outputFileName);
        int exitCode = processBuilderService.openCli(commands);
        if(exitCode == 0){
            return "database backed up successfully.";
        }else {

            throw  new PathDoesNotExistException("the specified path does not exist");
        }
    }
    public String restoreDataBase(String file) throws IOException, InterruptedException {

        List<String> commands = new ArrayList<>();

        // Add the psql command
        commands.add("psql");

        // Add the -U parameter with the username
        commands.add("-U");
        commands.add("postgres");

        // Add the -d parameter with the database name
        commands.add("-d");
        commands.add("PaginationTest");

        // Add the -f parameter with the file path
        commands.add("-f");


        commands.add(file);

        // Open the command line interface using ProcessBuilder
        if(processBuilderService.openCli(commands) == 0){
            return "database restored.";
        }else {
            throw  new PathDoesNotExistException("the file does not exist or is incompatible.");
        }
    }

    }