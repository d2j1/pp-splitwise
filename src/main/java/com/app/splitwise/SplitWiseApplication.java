package com.app.splitwise;

import com.app.splitwise.command.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);
    private CommandExecutor commandExecutor;

    public SplitWiseApplication(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
        System.out.print(" Enter command: > ");
        String command = scanner.nextLine();
        commandExecutor.execute(command);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }

}
