/**
 * Класс Main - точка входа программы.
 * В классе создаётся объект BeanFactory, ответственный за создание объектов всех классов в и запуск прилржения в методе start()
 * */
package main.java.applicationLogic;

import main.java.logicImplementation.CheckFunctions;
import main.java.logicImplementation.DictionaryInterface;
import main.java.logicImplementation.RequestFunctions;
import main.java.logicImplementation.SimpleConsoleApplicationIOMethods;
import main.java.userInterface.CommunicationWithTheUser;

public class Main {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.createObjects();
        beanFactory.start();
    }
}