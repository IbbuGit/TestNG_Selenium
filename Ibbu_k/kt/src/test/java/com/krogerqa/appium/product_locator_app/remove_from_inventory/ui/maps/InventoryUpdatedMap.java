package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class InventoryUpdatedMap {
    public By inventoryUpdatedIcon(){ return By.xpath("//*[@text='Inventory Updated']");}
    public By moreOptionsEllipsis(){ return By.xpath("//*[@content-desc='More options']");}
    public By greatJobText(){ return By.xpath("//*[@text='Great Job!']");}
    public By productsRemovedText(){ return By.id("items_count");}
    public By reasonCodeText(String reasonCode) { return By.xpath("//*[@text='"+ reasonCode +"']");}
    public By backToMainMenu() {return By.id("back_to_main_menu_button");}
    public By exitRemoveFromInventoryIcon(){ return By.xpath("//*[@text='Exit Remove From Inventory']");}
    public By signOutIcon(){return By.xpath("//*[@text='Sign Out']"); }
    public By removeFromInventoryIcon(){ return By.xpath("//*[@text='Remove Inventory']");}
}
