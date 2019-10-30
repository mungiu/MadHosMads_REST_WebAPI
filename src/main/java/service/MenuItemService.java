package service;

import model.MenuItem;
import model.MenuItemList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MenuItemService implements IMenuItemService {
    private static String DB_NAME;
    private final SimpleDateFormat SDF;
    private IUserService addressService;

    public MenuItemService(Connection dbConnection) {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.addressService = new UserService();
        this.DB_NAME = Database.DB_NAME;
    }

    @Override
    public MenuItemList getAllMenuItems() throws SQLException {
        MenuItemList menuItemList = new MenuItemList();
        Statement statement = Database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".dbo.MenuItems;");

        while (resultSet.next()) {
            menuItemList.getMenuItemList().add(populateMenuItem(resultSet));
        }

        return menuItemList;
    }

    public MenuItem populateMenuItem(ResultSet resultSet) throws SQLException {
        MenuItem menuItem = new MenuItem().populateFromResultSet(resultSet);
        return menuItem;
    }
}




