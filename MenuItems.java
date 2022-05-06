package main.Constants;

public enum MenuItems {
    SHOW_ALL("1"),
    FIND("2"),
    ADD("3"),
    DELETE("4"),
    EXIT("5");
    String menuItem;

    MenuItems(String menuItem){
        this.menuItem = menuItem;
    }
    public String getMenuItem(){
        return menuItem;
    }
}
