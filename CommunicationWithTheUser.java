/*
 * калсс реализует методы для общения с пользователем
 * */

package main.Classes;

import main.Constants.MessegesForUser;

import java.util.Scanner;

public class CommunicationWithTheUser {

    public void showMenu(){
        System.out.println(MessegesForUser.MAINMENU.getMessege());
    }

    public void reportLanguageDictionaryFileCreation(){
        System.out.println(MessegesForUser.REPORT_LANGUAGE_DICTIONARY_FILE_CREATION.getMessege());
    }

    public void reportLanguageDictionaryFileCreationFailed(){
        System.out.println(MessegesForUser.REPORT_LANGUAGE_DICTIONARY_FILE_CREATION_FAILED.getMessege());
    }

    public void reportNumericDictionaryFileCreation(){
        System.out.println(MessegesForUser.REPORT_NUMERIC_DICTIONARY_FILE_CREATION.getMessege());
    }

    public void reportNumericDictionaryFileCreationFailed(){
        System.out.println(MessegesForUser.REPORT_NUMERIC_DICTIONARY_FILE_CREATION_FAILED.getMessege());
    }

    public void promptDictionary(){
        System.out.println(MessegesForUser.PROMPT_DICTIOARY_MESSEGE.getMessege());
    }

    public void showStringFormatForExpression(){
        System.out.println(MessegesForUser.SHOW_STRING_FORMAT_FOR_EXPRESSION_MESSEGE.getMessege());
    }

    public void showNumberFormatForExpression(){
        System.out.println(MessegesForUser.SHOW_NUMBER_FORMAT_FOR_EXPRESSION_MESSEGE.getMessege());
    }

    public void showStringFormatForExpressionValue(){
        System.out.println(MessegesForUser.SHOW_STRING_FORMAT_FOR_VALUE_MESSEGE.getMessege());
    }
    public void showNumberFormatForExpressionValue(){
        System.out.println(MessegesForUser.SHOW_NUMBER_FORMAT_FOR_VALUE_MESSEGE.getMessege());
    }

    public String promptLine(){
        String line;
        Scanner scanner = new Scanner(System.in);
        System.out.print(MessegesForUser.KEY_REQUEST.getMessege());
        line = scanner.nextLine();
        return line;
    }

    public void promptValue(){
        System.out.println(MessegesForUser.VALUE_REQUEST.getMessege());
    }

    public void promptAction(){
        System.out.println(MessegesForUser.REQUEST_ACTION.getMessege());
    }

    public void stringNotFound(){
        System.out.println(MessegesForUser.STRING_NOT_FOUND.getMessege());
    }

    public void deleteOKMessage(){
        System.out.print(MessegesForUser.DELETE_OK.getMessege());
    }
    public void renameOKMessage(){
        System.out.println(MessegesForUser.RENAME_OK.getMessege());
    }
    public void deleteFailedMessage(){
        System.out.println(MessegesForUser.DELETE_FAILED.getMessege());
    }
    public void renameFailedMessage(){
        System.out.println(MessegesForUser.RENAME_FAILED.getMessege());
    }
    /*
    Методы для Exeption
     */
    public void fileReadError(){
        System.out.println(MessegesForUser.FILE_READ_ERROR.getMessege());
    }

    public void fileWritingError(){
        System.out.println(MessegesForUser.FILE_WRITING_ERROR.getMessege());
    }
    public void applicationLogicExeption(Exception e){
        System.out.println(MessegesForUser.APPLICATION_LOGIC_EXEPTION.getMessege() + e);
    }
}