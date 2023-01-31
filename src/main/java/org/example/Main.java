package org.example;

import Entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.next();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null){

                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));

                line = br.readLine();

            }

            System.out.println("Total users: " + set.size());

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }


        //If TreeSet was used, the order of print would be alphabetical, and linked hash set would be in oirder of insertion
        //All of sets do not accept any repeated input, so for this examples, with files etc, set would be the right choice
        //ps: Set is the faster method.

    }
}