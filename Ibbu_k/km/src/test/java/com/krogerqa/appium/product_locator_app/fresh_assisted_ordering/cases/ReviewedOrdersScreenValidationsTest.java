package com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.cases;



import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.SystemNavigationBar;
import com.krogerqa.appium.product_locator_app.common.ui.pages.HeaderBarPage;
import com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.ui.pages.ReviewedOrdersPage;

import com.krogerqa.httpclient.product_locator_app.apishelper.JSONDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ReviewedOrdersScreenValidationsTest extends Base {

	private HeaderBarPage headerBarPage = new HeaderBarPage();
	private TaskListPage taskListPage = new TaskListPage();
	private ReviewedOrdersPage reviewedOrdersPage = new ReviewedOrdersPage();

	/*
		Test Name: validateUserLandedOnReviewedOrdersScreen
		Test Description:(Pre-condition: There should be no previous orders to be reviewed).
						  1.Validate user lands on Reviewed Orders screen with zero products reviewed.
						  2.Validate scan image and scan text as a group are centered on the grey are between header bar(App bar) and System navigation bar(Android Soft keys at bottom).

        Scenario tested: When user taps on "Fresh Assisted Ordering" task on TaskList screen, user is navigated to Reviewed Orders screen with the initial zero product reviewed screen.
		Story Id: SATART - 647
		Epic Id:  SATART - 710
		Test data: Independent. No UPC required
		Api tested: N/A
		UI Screens tested: TaskList screen, Reviewed Orders screen
	 */
	@BeforeMethod(alwaysRun = true)
	public void validateUserLandedOnReviewedOrdersScreen(){
		headerBarPage.validateHeaderBar();
		headerBarPage.validateScreenTitle(fao_Data.getReviewedOrdersTitle());
		reviewedOrdersPage.validateReviewedOrdersScreenWithZeroProducts(fao_Data.getScanProductText());
	}

	/*
		Test Name: validateTapBackOnReviewedOrdersScreen
		Test Description:(Pre-condition: There should be no previous orders to be reviewed).
		                 On Reviewed Orders screen with zero products on screen,
						 user taps on Back KDS icon on the header bar(App bar)
		Scenario tested: When user taps on Back KDS icon on header bar of Reviewed Orders screen, user should be navigated to TaskList screen.
		Story Id: SATART - 647
		Epic Id:  SATART - 710
		Test data: Independent. No UPC required
		Api tested: N/A
		UI Screens tested: TaskList screen, Reviewed Orders screen
	 */

	@Test(groups = {"regression","satart-647"})
	public void validateTapBackOnReviewedOrdersScreen(){
		headerBarPage.tapOnBackKdsIcon();
		headerBarPage.validateScreenTitle(fao_Data.getTaskListTitle());
		taskListPage.validateTaskListScreen();
		taskListPage.tapOnFreshAssistedOrdering();
	}
	/*
		Test Name: validateTapBackAndroidSoftKeyOnReviewedOrdersScreen
		Test Description:(Pre-condition: There should be no previous orders/products to be reviewed).
		                 On Reviewed Orders screen with zero products/orders on screen,
						 user taps on Android Soft Back key on the system navigation bar(at the bottom of screen)
		Scenario tested: When user taps on Android Soft Back key on system navigation bar of Reviewed Orders screen, user should be navigated to TaskList screen.
		Story Id: SATART - 647
		Epic Id:  SATART - 710
		Test data: Independent. No UPC required
		Api tested: N/A
		UI Screens tested: TaskList screen, Reviewed Orders screen
	 */
	@Test(groups = {"regression","satart-647"})
	public void validateTapBackAndroidSoftKeyOnReviewedOrdersScreen(){
		SystemNavigationBar.tapOn(SystemNavigationBar.BACK);
		headerBarPage.validateScreenTitle(fao_Data.getTaskListTitle());
		taskListPage.validateTaskListScreen();
		taskListPage.tapOnFreshAssistedOrdering();
	}
	/*

	@Test(groups = {"regression","satart-693"},dataProvider = "fetchData_JSON", dataProviderClass = JSONDataProvider.class,enabled = true)
	public void validateScanFreshProduct(){

	}*/

}
