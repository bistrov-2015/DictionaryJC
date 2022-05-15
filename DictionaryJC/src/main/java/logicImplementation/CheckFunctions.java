/**
 * класс реализующий методы проверки:
 * public void checkFileExistence() - проверка существования файла по заданному пути, если его нет файл будет создан;
 * public boolean cheсkUserSelection(String userSelection) - проверка выбранного пользователем пунта меню программы на соответствие существующим пунктам;
 * public boolean checkDictionaryTypeSelection(String Dict) - функция проверяет введённую пользователем цифру(которая обозначает тип словаря);
 * public boolean checkNumericString(String chekedStr) - функция проверяет соответствие введённой пользователем строки для слолваря хранящего числа;
 * public boolean checkSymbolString(String chekedStr) - функция проверяет соответствие введённой пользователем строки для слолваря хранящего слова из латинских букв;
 * public boolean checkSymbolExpressionValue(String chekedStr) - функция проверяет соответствие введённого пользователем значения для слолваря хранящего слова из латинских букв;
 * public boolean checkNumericExpressionValue(String chekedStr) - функция проверяет соответствие введённого пользователем значения для слолваря хранящего чвисла
 * */
package main.java.logicImplementation;

import main.java.userInterface.MessegesForUser;
import main.java.userInterface.CommunicationWithTheUser;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class CheckFunctions {

    private CommunicationWithTheUser communicationWithTheUser;
    private FilesFactory filesFactory;

    public CheckFunctions(CommunicationWithTheUser communicationWithTheUser, FilesFactory filesFactory) {
        this.communicationWithTheUser = communicationWithTheUser;
        this.filesFactory = filesFactory;
    }



    public void checkFileExistence() {
        try {
            File langDictFile = new File(String.valueOf(filesFactory.getPathToLangFile()));
            if (langDictFile.createNewFile())
                communicationWithTheUser.showMessege(MessegesForUser.REPORT_LANGUAGE_DICTIONARY_FILE_CREATION.getMessege());//reportLanguageDictionaryFileCreation();
        } catch (IOException e) {
            communicationWithTheUser.showExeptionMessege(MessegesForUser.REPORT_LANGUAGE_DICTIONARY_FILE_CREATION_FAILED.getMessege(), e);//reportLanguageDictionaryFileCreationFailed();
        }
        try {
            File numDictFile = new File(String.valueOf(filesFactory.getPathToNumFile()));
            if (numDictFile.createNewFile())
                communicationWithTheUser.showMessege(MessegesForUser.REPORT_NUMERIC_DICTIONARY_FILE_CREATION.getMessege());//reportNumericDictionaryFileCreation();

        } catch (IOException e) {
            communicationWithTheUser.showExeptionMessege(MessegesForUser.REPORT_NUMERIC_DICTIONARY_FILE_CREATION_FAILED.getMessege(), e);//reportNumericDictionaryFileCreationFailed();
        }
    }

    public boolean checkUserSelection(String userSelection){
        return Pattern.matches(Rejex.SELECTION_FORMAT.getRejexType(), userSelection);
    }

    public boolean checkDictionaryTypeSelection(String Dict){
        return Pattern.matches(Rejex.AVAILABLE_DICTIONARY_NUMBER_FORMAT.getRejexType(), Dict);
    }

    public boolean checkNumericString(String chekedStr) {
        return chekedStr.matches(Rejex.NUMERIC_EXPRESSION_FORMAT.getRejexType());
    }

    public boolean checkSymbolString(String chekedStr) {
        return chekedStr.matches(Rejex.LANGUAGE_EXPRESSION_FORMAT.getRejexType());
    }

    public boolean checkSymbolExpressionValue(String chekedStr) {
        return chekedStr.matches(Rejex.SYMBOL_VALUE_FORMAT.getRejexType());
    }

    public boolean checkNumericExpressionValue(String chekedStr) {
        return chekedStr.matches(Rejex.NUMERIC_VALUE_FORMAT.getRejexType());
    }
}