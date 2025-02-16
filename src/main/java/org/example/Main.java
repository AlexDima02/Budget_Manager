package org.example;

// Cum functioneaza aplicatia:
// Inregistreaza o cheltuiala care este compusa din urmatoarele info:
// Categorie
// Amount
// Date
// Cheltuiala este inregistrata mai apoi intr-un fisier text

// Clase: Expense, BudgetUtility

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String input;
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenseList = new ArrayList<Expense>();
        FileInteraction db = new FileInteraction();

        while (true){

            db.readingExpenses("database.txt");
            System.out.println("Choose what you want to do: ");
            System.out.println("3 -- Set a budget");
            System.out.println("2 -- Next");
            System.out.println("1 -- Show all expenses");
            System.out.println("0 -- Exit");
            input = sc.nextLine();
            switch (input) {
                case "3":

                    System.out.println("Choose what budget do you want to set: ");
                    String budget = sc.nextLine();
                    System.out.println("Choose for what month do you want to set: ");
                    String month = sc.nextLine();
                    System.out.println("Choose for what year do you want to set: ");
                    String year = sc.nextLine();

                    db.writingBudgetList.add(new Budget(budget, month, year));
                    db.writingBudget("budgets.txt");

                continue;

                case "2":

                    System.out.println("Insert amount: ");
                    String number = sc.nextLine();
                    System.out.println("Insert name: ");
                    String name = sc.nextLine();
                    System.out.println("Insert category: ");
                    System.out.println("1 - Food");
                    System.out.println("2 - Utilities");
                    System.out.println("3 - Entertainment");
                    String category = sc.nextLine();
                    if (category.equals("1")) category = "Food";
                    if (category.equals("2")) category = "Utilities";
                    if (category.equals("3")) category = "Entertainment";

                    db.writingExpenseList.add(new Expense(number, name, category));
                    db.writingExpense("database.txt");

                    continue;

                case "1":

                    for (int i = 0; i <  db.readingExpenseList.size(); i++){
                        System.out.println(" / " + db.readingExpenseList.get(i).name + " / " + db.readingExpenseList.get(i).category + " / " + db.readingExpenseList.get(i).amount + " / ");
                    }

                 continue;

                default:
                break;
            }

            break;

        }

    }
}