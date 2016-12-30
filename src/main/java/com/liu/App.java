package com.liu;

import com.liu.command.Command;
import com.liu.command.CommandManager;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Hello world!
 *  show -f ds
 *  update
 *  delete
 *  insert
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Properties properties = new Properties();
        properties.load(App.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        System.out.println(properties.get("app.description").toString());
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("context "+ context.hashCode());
        CommandManager commandManager = context.getBean(CommandManager.class);
        commandManager.showMenu();
        while(true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                try {
                    commandManager.handle(scanner.nextLine());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }


    }
}
