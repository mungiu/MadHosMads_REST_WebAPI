package service;

import model.MenuItem;
import model.MenuItemList;

import java.sql.SQLException;

public interface IMenuItemService {
    MenuItemList getAllMenuItems() throws SQLException;
}
