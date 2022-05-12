/*
 * класс реализует методы запроса данных у пользователя:
 * public String promptUserSelection() - запрос пункта меню;
 * public String promptDictionaryType() - запрос типа словаря с которым хочет работать пользователь;
 * public String requestExpressiont(String numDict) - метод запроса слова(ключа) для словаря и проверка его на удовлетвореня условиям ТЗ для конкретного словаря, в зависимости от того какой словарь выбран;
 * public String requestExpressionValue(String numDict) - метод запроса слова(значения) для словаря и проверка его на удовлетвореня условиям ТЗ для конкретного словаря, в зависимости от того какой словарь выбран;
 *  */
package main.Classes;

import main.Constants.Files;
import main.Constants.MessegesForUser;

import java.util.Scanner;

public class RequestFunctions {
    CommunicationWithTheUser communicationWithTheUser;
    CheckFunctions checkFunctions;
    private String numDict;
    private String selectItem;

    protected RequestFunctions(CommunicationWithTheUser communicationWithTheUser, CheckFunctions checkFunctions) {
        this.communicationWithTheUser = communicationWithTheUser;
        this.checkFunctions = checkFunctions;
    }

    public void setNumDict(String numDict) {
        this.numDict = numDict;
    }

    public void setSelectItem(String selectItem) {
        this.selectItem = selectItem;
    }

    public String promptUserSelection(){
        Scanner scanner = new Scanner(System.in);
        communicationWithTheUser.getMessege(MessegesForUser.REQUEST_ACTION.getMessege());
        setSelectItem(scanner.nextLine());
        if (!checkFunctions.chekUserSelection(selectItem)) {
            promptUserSelection();
        }
        return selectItem;
    }

    public String promptDictionaryType(){
        Scanner scanner = new Scanner(System.in);
        communicationWithTheUser.getMessege(MessegesForUser.PROMPT_DICTIOARY_TYPE.getMessege());
        setNumDict(scanner.nextLine());
        if (!checkFunctions.checkDictionaryTypeSelection(numDict)) {
            promptDictionaryType();
        }
        return numDict;
    }

    public String requestExpressiont(String numDict){
        String stringToFile = communicationWithTheUser.promptLine();
        if("1".equals(numDict)){
            while (!checkFunctions.checkSymbolString(stringToFile)){
                communicationWithTheUser.getMessege(MessegesForUser.SHOW_STRING_FORMAT_FOR_EXPRESSION_MESSEGE.getMessege());//showStringFormatForExpression();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }else if ("2".equals(numDict)){
            while (!checkFunctions.checkNumericString(stringToFile)){
                communicationWithTheUser.getMessege(MessegesForUser.SHOW_NUMBER_FORMAT_FOR_EXPRESSION_MESSEGE.getMessege());//showNumberFormatForExpression();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }
        return stringToFile;
    }

    public String requestExpressionValue(String numDict){
        String stringToFile = communicationWithTheUser.promptLine();
        if("1".equals(numDict)){
            while (!checkFunctions.checkSymbolExpressionValue(stringToFile)){
                communicationWithTheUser.getMessege(MessegesForUser.SHOW_STRING_FORMAT_FOR_VALUE_MESSEGE.getMessege());//showStringFormatForExpressionValue();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }else if ("2".equals(numDict)){
            while (!checkFunctions.checkNumericExpressionValue(stringToFile)){
                communicationWithTheUser.getMessege(MessegesForUser.SHOW_NUMBER_FORMAT_FOR_VALUE_MESSEGE.getMessege());//showNumberFormatForExpressionValue();
                stringToFile = communicationWithTheUser.promptLine();
            }
        }
        return stringToFile;
    }

}