/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.FileDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;

/**
 *
 * @author ASUS
 */
public class FileRes implements IFileRes {



    @Override
    public void readFile(List<Person> personlist) {
        FileDao.Instance().readFile(personlist);
    }

    @Override
    public void writeFile() {
        FileDao.Instance().writeFile();
    }
}
