package main.Interfaces;

public interface ApplicationInterface extends UserInteractionInterface {
    void runApplication();
    void showUserMenu();
    void  handleUserSelection();
    void performSelectedAction();
}