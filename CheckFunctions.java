/*
 * класс реализующий методы проверки:
 * public void checkFileExistence() - проверка существования файла по заданному пути, если его нет файл будет создан;
 * public boolean chekUserSelection(String userSelection) - проверка выбранного пользователем пунта меню программы на соответствие существующим пунктам;
 * public boolean checkDictionaryTypeSelection(String Dict) - функция проверяет введённую пользователем цифру(которая обозначает тип словаря);
 * public boolean checkNumericString(String chekedStr) - функция проверяет соответствие введённой пользователем строки для слолваря хранящего числа;
 * public boolean checkSymbolString(String chekedStr) - функция проверяет соответствие введённой пользователем строки для слолваря хранящего слова из латинских букв;
 * public boolean checkSymbolExpressionValue(String chekedStr) - функция проверяет соответствие введённого пользователем значения для слолваря хранящего слова из латинских букв;
 * public boolean checkNumericExpressionValue(String chekedStr) - функция проверяет соответствие введённого пользователем значения для слолваря хранящего чвисла;
 * */
package main.Classes;

import main.Constants.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CheckFunctions {
    String separator = File.separator;
    CommunicationWithTheUser communicationWithTheUser;

    public CheckFunctions(CommunicationWithTheUser communicationWithTheUser) {
        this.communicationWithTheUser = communicationWithTheUser;
    }
    public String getSeparator(){
        return separator;
    }

    Path path1 = Paths.get(Files.DIRECTORY.getFilesInfo() + getSeparator() + Files.LANG_FILE.getFilesInfo());
    Path path2 = Paths.get(Files.DIRECTORY.getFilesInfo() + getSeparator() + Files.NUM_FILE.getFilesInfo());
    File file1 = new File(Files.DIRECTORY.getFilesInfo() + getSeparator() + Files.LANG_FILE.getFilesInfo());
    File file2 = new File(Files.DIRECTORY.getFilesInfo() + getSeparator() + Files.NUM_FILE.getFilesInfo());
    public void checkFileExistence() {
        try {
            File file1 = new File(String.valueOf(path1));
            if (file1.createNewFile())
                communicationWithTheUser.reportLanguageDictionaryFileCreation();
        } catch (IOException e) {
            communicationWithTheUser.reportLanguageDictionaryFileCreationFailed();
        }
        try {
            File file2 = new File(String.valueOf(path2));
            if (file2.createNewFile())
                communicationWithTheUser.reportNumericDictionaryFileCreation();

        } catch (IOException e) {
            communicationWithTheUser.reportNumericDictionaryFileCreationFailed();
        }
    }

    public boolean chekUserSelection(String userSelection){
        String regex = "[12345]";
        if (Pattern.matches(regex, userSelection) == true){
            return true;
        }else return false;
    }

    public boolean checkDictionaryTypeSelection(String Dict){
        String regex = "[12]";
        if (Pattern.matches(regex, Dict) == true){
            return true;
        } else return false;
    }

    public boolean checkNumericString(String chekedStr) {
        if (chekedStr.matches("^[0-9]+$") == true & chekedStr.length() == 5 ) {
            return true;
        }
        return false;
    }

    public boolean checkSymbolString(String chekedStr) {
        if (chekedStr.matches("^[a-z]+$") == true & chekedStr.length() == 4 ) {// A-Z убрал чтобы был чувствителен к регистру
            return true;
        }
        return false;
    }

    public boolean checkSymbolExpressionValue(String chekedStr) {
        if (chekedStr.matches("^[а-яА-Я]+$") == true ) {
            return true;
        }
        return false;
    }

    public boolean checkNumericExpressionValue(String chekedStr) {
        if (chekedStr.matches("^[0-9]+$") == true ) {
            return true;
        }
        return false;
    }
}