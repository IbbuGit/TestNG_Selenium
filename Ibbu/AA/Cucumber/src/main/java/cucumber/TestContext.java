package cucumber;

import managers.PageObjectManager;
import managers.WebDriversManager;


public class TestContext {

	private WebDriversManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;

	public TestContext(){
		webDriverManager = new WebDriversManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public WebDriversManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}