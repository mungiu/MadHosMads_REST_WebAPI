package controller;

import model.MenuItem;
import model.MenuItemList;
import service.IMenuItemService;
import service.MenuItemService;
import utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class MenuItemController {
    private IMenuItemService iMenuItemService;

    public MenuItemController() {
        this.iMenuItemService = new MenuItemService(Database.getConnection());
    }

    @GET
    @Path("/getAllMenuItems")
    public Response getAllMenuItems() {
        // FULL ACCESS URL EXAMPLE http://178.155.142.127:8080/server_war_exploded/root/api/getAllMenuItems
        // NOTE STATIC IP AND PORT FORWARDING WILL VARY ACROSS DIFFERENT SERVERS
        try {
            MenuItemList menuItemList = iMenuItemService.getAllMenuItems();
            return Response.status(200).entity(menuItemList).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}