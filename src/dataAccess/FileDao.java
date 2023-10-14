/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.ScannerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import repository.FileRes;
import repository.IFileRes;

/**
 *
 * @author ASUS
 */
public class FileDao {

    public static FileDao instance = null;
    IFileRes mn;
    ScannerFactory sc;

    public FileDao() {
        mn = new FileRes();
        sc = new ScannerFactory();
    }

    public static FileDao Instance() {
        if (instance == null) {
            synchronized (FileDao.class) {
                if (instance == null) {
                    instance = new FileDao();
                }
            }
        }
        return instance;
    }

    public void readFile(List<Person> personList) {
        System.out.println("Enter the file path: ");
        String input = sc.getScanner().nextLine();
        String path = "src\\model\\" + input;
        System.out.println("Enter the salary: ");
        float salary = sc.getScanner().nextFloat();
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                if (data.length == 3) {
                    String name = data[0].trim();
                    String address = data[1].trim();
                    if (!(data[2].isEmpty() || checkSalary(data[2]))) {
                        personList.add(new Person(name, address, Float.parseFloat(data[2].trim())));
                    } else {
                        personList.add(new Person(name, address, 0));
                    }
                }
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println("Can't read file");
        }
        showAll(personList);
    }

    public void writeFile() {
        System.out.println("Enter the file source path: ");
        String source = sc.getScanner().nextLine();
        System.out.println("Enter the file destination path");
        String destination = sc.getScanner().nextLine();
        String path1 = "src\\model\\" + source;
        String path2 = "src\\model\\" + destination;
        File pathS = new File(path1);
        File pathD = new File(path2);
        try {
            pathD.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(pathD));
            BufferedReader br = new BufferedReader(new FileReader(pathS));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(";");
                if (data.length == 3) {
                    pw.println(data[0].trim() + "; " + data[1].trim() + "; " + data[2].trim());
                }
                line = br.readLine();
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Invalid file path");
        }
    }

    public void showAll(List<Person> personList) {
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    public boolean checkSalary(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
