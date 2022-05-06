/**/
package main.Classes;

import main.Interfaces.ApplicationInterface;
import main.Interfaces.DictionaryInterface;

public class Main {
/*    SimpleConsoleApplication simpleConsoleApplication;
    SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods;
    CommunicationWithTheUser communicationWithTheUser;
    CheckFunctions checkFunctions;
    RequestFunctions requestFunctions;

    public Main(SimpleConsoleApplication simpleConsoleApplication,
                SimpleConsoleApplicationIOMethods simpleConsoleApplicationIOMethods,
                CommunicationWithTheUser communicationWithTheUser,
                CheckFunctions checkFunctions,
                RequestFunctions requestFunctions) {
        this.communicationWithTheUser = new CommunicationWithTheUser();
        this.checkFunctions = new CheckFunctions(communicationWithTheUser);
        this.requestFunctions = new RequestFunctions(communicationWithTheUser,checkFunctions);
        this.simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods(checkFunctions, requestFunctions, communicationWithTheUser);
        this.simpleConsoleApplication = new SimpleConsoleApplication(simpleConsoleApplicationIOMethods, communicationWithTheUser, checkFunctions, requestFunctions);
    }*/
    public static void main(String[] args) {
        CommunicationWithTheUser communicationWithTheUser = new CommunicationWithTheUser();
        CheckFunctions checkFunctions = new CheckFunctions(communicationWithTheUser);
        RequestFunctions requestFunctions = new RequestFunctions(communicationWithTheUser, checkFunctions);
        DictionaryInterface simpleConsoleApplicationIOMethods = new SimpleConsoleApplicationIOMethods(checkFunctions, requestFunctions, communicationWithTheUser);
        ApplicationInterface simpleConsoleApplication = new SimpleConsoleApplication(simpleConsoleApplicationIOMethods,communicationWithTheUser,checkFunctions,requestFunctions);
        ApplicationLogic applicationLogic = new ApplicationLogic(simpleConsoleApplication, communicationWithTheUser);
        applicationLogic.runApplication();
    }
}