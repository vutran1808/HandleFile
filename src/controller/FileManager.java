/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.ScannerFactory;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import repository.FileRes;
import repository.IFileRes;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class FileManager extends Menu {

    IFileRes mn;
    private List<Person> personList;
    static String[] mc = {"Find person info", "Copy Text to new file", "Exit"};

    public FileManager() {
        super("File Processing", mc);
        mn = new FileRes();
        personList = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                mn.readFile(personList);
            case 2 ->
                mn.writeFile();
        }
    }
}
