package model;

import java.util.ArrayList;
import java.util.List;

public class MenuItemList
{
    private ArrayList<MenuItem> menuItemList;

    public MenuItemList() {
        menuItemList = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}