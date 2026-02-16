package com.KatalogStripovaCorps;

import connection.ConnectionUtil_HikariCP;
import ui_handler.MainUIHandler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        MainUIHandler mainUIHandler = new MainUIHandler();

        try {
            mainUIHandler.handleMainMenu();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            ConnectionUtil_HikariCP.closeDataSource();
        }
    }


}