package org.example;

// Expense -> {id, category, name, date}

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class Expense {
    int id;
    String category;
    String name;
    String amount;

    public Expense(String amount, String name, String category) {
        this.amount = amount;
        this.name = name;
        this.category = category;
    }

    public void addExpense(String filename) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(this.name);
            myWriter.write(category.toString());
            myWriter.write(amount.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
