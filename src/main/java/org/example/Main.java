package org.example;

import Entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.time.Instant;

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

        Map<String,String> cookies = new TreeMap<>();

        cookies.put("Joao", "123456");
        cookies.put("Alex", "543745354");
        cookies.put("Junior", "36054");
        cookies.put("Albert", "58375252");
        cookies.put("Laurance", "2573523723");
        cookies.put("Robert", "57374542");

        cookies.put("Joao", "123456");
        // cookies.remove("Robert");

        System.out.println("All Cookies");
        for ( String key : cookies.keySet()){
            System.out.println(key + ": " + cookies.get(key));


        //For this one, we used the Map element, with TreeMap, it follows the same basic rules of Set's
        //but it stands for "MAP", in this case, Map manage to get a Key and a Value, and here is an example
        //
        // ps: this map is similar to the map we see in Stream, but with strams we use it to execute a method and
        //transforms the entire Stream
        }




    }

    }
}