/**
 * Класс запукает приложение при помощи метода public void runApplication(), в котором у объекта simpleConsoleApplication вызывается метод runApplication() переопределённый в классе SimpleConsoleApplication.
 * */
package main.java.applicationLogic;

import main.java.userInterface.MessegesForUser;
import main.java.userInterface.CommunicationWithTheUser;

public class ApplicationLogic {
    private ApplicationInterface simpleConsoleApplication;
    private CommunicationWithTheUser communicationWithTheUser;
    public ApplicationLogic(ApplicationInterface simpleConsoleApplication, CommunicationWithTheUser communicationWithTheUser){
        this.simpleConsoleApplication = simpleConsoleApplication;
        this.communicationWithTheUser = communicationWithTheUser;
    }
    public void runApplication() {

        try {
            simpleConsoleApplication.runApplication();
        } catch (Exception e){
            communicationWithTheUser.showExeptionMessege(MessegesForUser.APPLICATION_LOGIC_EXEPTION.getMessege(),e);//applicationLogicExeption(e);
        }

    }
}