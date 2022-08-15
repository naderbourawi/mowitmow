package com.tuto.mowitnow;

import com.tuto.mowitnow.services.Instructions.LaunchInstructions;
import com.tuto.mowitnow.exceptions.ExceptionFile;
import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class MowitnowApplication {
    /**
     * Inject Services
     **/
    private static LaunchInstructions launchInstructions;
    private static Environment env;
    @Autowired
    LaunchInstructions tmpLaunchInstructions;
    @Autowired
    private Environment envTmp;

    @PostConstruct
    public void init() {
        // Inject service into static variable to be used in static main method.
        launchInstructions = tmpLaunchInstructions;
        env = envTmp;
    }

    public static void main(String[] args) throws ExceptionMower, IOException, ExceptionFile {
        SpringApplication.run(MowitnowApplication.class, args);
        //Read file path from application.properties variable.
        File MowerInstructionFile = new File((args.length == 0) && env != null ? env.getProperty("file.path") : args[0]);
        if (MowerInstructionFile.exists()) {
            List<String> finalPostition = launchInstructions.getMowersFinalPositions(MowerInstructionFile); // récupérer les positions final des tondeuses
            finalPostition.stream().forEach(System.out::println);
        } else {
            throw new ExceptionFile(Constants.ERREUR_FICHIER_INEXISTANT);
        }
    }

}
