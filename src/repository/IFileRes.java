/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import java.util.List;
import model.Person;

/**
 *
 * @author ASUS
 */
public interface IFileRes {

    void readFile(List<Person> personList);

    void writeFile();

}
