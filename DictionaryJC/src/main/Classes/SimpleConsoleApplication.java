/*
 * класс реализует логику работы приложения имплементируя ApplicationInterface;
 * public void runApplication() - вызывает методы до тех пор пока переменная runAp = true;
 * public void showUserMenu() - метод реализует показ пользователю пунктов меню приложения;
 * public void  handleUserSelection() - метод реализует запрос действия от пользователя;
 * public void performSelectedAction() - метод обрабатывет выбор пользователя в зависимости от выбранного пункта меню;
 * */
package main.Classes;

import main.Constants.MenuItems;
import main.Interfaces.ApplicationInterface;
import main.Interfaces.DictionaryInterface;

import java.io.IOException;

public class SimpleConsoleApplication implements ApplicationInterface {
    private String selectedItem;
    private DictionaryInterface simpleConsoleApplicationIOMethods;
    private CommunicationWithTheUser communicationWithTheUser;
    private CheckFunctions checkFunctions;
    private RequestFunctions requestFunctions;
    private boolean runAp;

    protected SimpleConsoleApplication(DictionaryInterface simpleConsoleApplicationIOMethods, CommunicationWithTheUser communicationWithTheUser, CheckFunctions checkFunctions, RequestFunctions requestFunctions) {
        this.simpleConsoleApplicationIOMethods = simpleConsoleApplicationIOMethods;
        this.communicationWithTheUser = communicationWithTheUser;
        this.checkFunctions = checkFunctions;
        this.requestFunctions = requestFunctions;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    private void setRunUp(boolean value){
        this.runAp = value;
    }
    private boolean getRunAp(){
        return runAp;
    }


    public void runApplication(){
        checkFunctions.checkFileExistence();
        setRunUp(true);
        while (getRunAp()) {
            showUserMenu();
            handleUserSelection();
            performSelectedAction();
        }
    }

    public void showUserMenu(){
        communicationWithTheUser.showMenu();
    }

    public void  handleUserSelection(){
        setSelectedItem(requestFunctions.promptUserSelection());
    }

    public void performSelectedAction(){
        if(selectedItem.equals(MenuItems.SHOW_ALL.getMenuItem())){
            try {
                simpleConsoleApplicationIOMethods.showDictionary();
            } catch (IOException e) {
                communicationWithTheUser.getExeptionMessege(main.Constants.MessegesForUser.FILE_READ_ERROR.getMessege(),e);
            }
        } else if(selectedItem.equals(MenuItems.FIND.getMenuItem())){
            try {
                simpleConsoleApplicationIOMethods.findEntryInDictionary();
            } catch (IOException e) {
                communicationWithTheUser.getExeptionMessege(main.Constants.MessegesForUser.FILE_READ_ERROR.getMessege(),e);
            }
        } else if(selectedItem.equals(MenuItems.ADD.getMenuItem())){
            simpleConsoleApplicationIOMethods.makeEntryInDictionary();
        } else if(selectedItem.equals(MenuItems.DELETE.getMenuItem())){
            simpleConsoleApplicationIOMethods.deleteEntryInDictionary();
        } else if (selectedItem.equals(MenuItems.EXIT.getMenuItem())){
            setRunUp(false);
        }
    }
}