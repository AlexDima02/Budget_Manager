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

        int month;
        String input;
        String editName;
        String expenseName;
        String amount;
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenseList = new ArrayList<Expense>();
        FileInteraction db = new FileInteraction();
        Expense expense = new Expense();

        while (true){

            db.readingExpenses("database.txt");
            System.out.println("Choose what you want to do: ");
            System.out.println("7 -- Remove expense: ");
            System.out.println("6 -- Edit expense: ");
            System.out.println("5 -- Show total expense for a specific month: ");
            System.out.println("4 -- Check your budget against monthly expenses");
            System.out.println("3 -- Set a budget");
            System.out.println("2 -- Next");
            System.out.println("1 -- Show all expenses");
            System.out.println("0 -- Exit");
            input = sc.nextLine();
            switch (input) {
                case "7":

                    System.out.println("Enter the name of the expense: ");
                    expenseName = sc.nextLine();
                    expense.removeExpense("database.txt", expenseName);

                    continue;
                case "6":

                    System.out.println("Enter the name of the expense: ");
                    expenseName = sc.nextLine();
                    System.out.println("Edit the expense name: ");
                    editName = sc.nextLine();
                    System.out.println("Editor the amount: ");
                    amount = sc.nextLine();
                    expense.editExpense("database.txt", amount, editName, expenseName);

                    continue;
                case "5":

                    System.out.println("Enter your month: ");
                    month = Integer.valueOf(sc.nextLine());
                    db.calculateMonthExpense(month);

                    continue;
                case "4":

                    System.out.println("Enter month budget: ");
                    month = Integer.valueOf(sc.nextLine());
                    db.checkSpendingAgainstBudget(month);

                    continue;
                case "3":

                    System.out.println("Choose what budget do you want to set: ");
                    String budget = sc.nextLine();
                    System.out.println("Choose for what month do you want to set: ");
                    String budgetMonth = sc.nextLine();
                    System.out.println("Choose for what year do you want to set: ");
                    String budgetYear = sc.nextLine();

                    db.writingBudgetList.add(new Budget(budget, budgetMonth, budgetYear));
                    db.writingBudget("budgets.txt");

                continue;

                case "2":

                    System.out.println("Insert amount: ");
                    String number = sc.nextLine();
                    System.out.println("Insert month: ");
                    String expenseMonth = sc.nextLine();
                    System.out.println("Insert year: ");
                    String expenseYear = sc.nextLine();
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

                    db.writingExpenseList.add(new Expense(number, name, category, expenseMonth, expenseYear));
                    db.writingExpense("database.txt");

                    continue;

                case "1":

                    if (db.readingExpenseList.size() == 0){
                        System.out.println("No expenses found");
                        continue;
                    }

                    for (int i = 0; i <  db.readingExpenseList.size(); i++){
                        System.out.println(db.readingExpenseList.get(i).amount + " / " + db.readingExpenseList.get(i).name + " / " + db.readingExpenseList.get(i).category + " / " + db.readingExpenseList.get(i).month + " / " + db.readingExpenseList.get(i).year);
                    }

                 continue;

                default:
                break;
            }

            break;

        }

    }
}