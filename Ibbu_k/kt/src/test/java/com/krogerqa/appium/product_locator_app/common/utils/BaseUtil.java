package com.krogerqa.appium.product_locator_app.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.collect.ImmutableMap;
import com.krogerqa.seleniumcentral.framework.main.BaseTest;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BaseUtil {

    public static AppiumDriver driver;


    public static List<Map<String, String>> readCSV(String path) throws JsonProcessingException, IOException {
        List<Map<String, String>> response = new LinkedList<Map<String, String>>();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> iterator = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(new File(path));
        while (iterator.hasNext()) {
            response.add(iterator.next());
        }
        return response;
    }

    public static Object[][] dataSupplier(List<Map<String, String>> testDataMapList,String dataRowName) throws IOException {
        List<Map<String, String>> mapList=testDataMapList.stream().filter(oMap -> dataRowName.equals(oMap.get("testName")))
                .collect(Collectors.toList());

        Object[][] obj = new Object[mapList.size()][1];

        for (int j = 0; j < mapList.size(); j++) {
            obj[j][0] = mapList.get(j);
        }

        return obj;
    }

    public static AppiumDriverLocalService getAppiumService(String ipAddress) {
        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress(ipAddress);
        builder.usingAnyFreePort();
        builder.withArgument(new ServerArgument(){
            public String getArgument() {
                return "--avd";
            }
        }, "Nexus5");
        builder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf(RandomUtils.nextInt(100,999)));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        return AppiumDriverLocalService.buildService(builder);
    }

    public static final String ACTION_APPIUM_SCAN = "AppiumTestScannerComponent.ACTION_APPIUM_SCAN";
    public static final String EXTRA_UPC = "AppiumTestScannerComponent.EXTRA_UPC";
    public static final String EXTRA_SYMBOLOGY = "AppiumTestScannerComponent.EXTRA_SYMBOLOGY";

    public static void triggerScan(AppiumDriver driver, String upc, Symbology symbology) throws IOException {
        driver.executeScript("mobile: shell", new Object[]{ImmutableMap.of("command", "am", "args", Arrays.asList("broadcast", "-a", "AppiumTestScannerComponent.ACTION_APPIUM_SCAN", "-e", "AppiumTestScannerComponent.EXTRA_UPC", upc, "-e", "AppiumTestScannerComponent.EXTRA_SYMBOLOGY", symbology.name()))});
    }

    public static void scanUPC(WebDriver driver, String UPC, Symbology symbology) throws IOException {
        //LuminanceSource source = new BufferedImageLuminanceSource(ImageIO.read(new File(barcodeImagePath)));
        //BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        triggerScan((AndroidDriver)driver, convertKrogerToUpcA(UPC), symbology);
    }

    public static String convertKrogerToUpcA(String krogerUpc) {

        if (krogerUpc.length() != 13 || krogerUpc.matches("[^0-9]")) {
            throw new IllegalArgumentException("Krogerized UPC should be 13 digits.");
        }
        krogerUpc = krogerUpc.substring(2);
        int sum = 0;
        for (int i=0; i<krogerUpc.length(); i++) {
            sum += (i & 1) == 0 ? (krogerUpc.charAt(i) - '0') * 3 : krogerUpc.charAt(i) - '0';
        }

        if(sum % 10==0){
            return krogerUpc +"0";
        }else{return krogerUpc + (10 - (sum % 10));}
    }

    public static void takeScreenshot() throws Exception {
//        String timeStamp;
//        File screenShotName;
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////The below method will save the screen shot in d drive with name "screenshot.png"
//        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        screenShotName = new File("D:\\MyTest\\Screenshots\\"+timeStamp+".png");
//        FileUtils.copyFile(scrFile, screenShotName);
//
//        String filePath = screenShotName.toString();
//        String path = "<img src="\"file://"" alt="\"\"/" />";
//        Reporter.log(path);

    }
    public static void ScrollPageWithPercentage(AppiumDriver driver, double anchorPercentage, double startPercentage, double endPercentage) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        TouchAction ta = new TouchAction(driver);
        int X, startY, endY;
        try {
            X = (int) ((size.width) * anchorPercentage);
            startY = (int) ((size.height) * startPercentage);
            endY = (int) ((size.height) * endPercentage);
            ta.press(point(X, 578))
                    .waitAction(waitOptions(ofMillis(1000)))
                    .moveTo(point(X, 138))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickAndroidBack() {

        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

    }

    public static Properties readAPIUrls(String path){
        try (InputStream input = new FileInputStream(path)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void scroll(String scrollDirection, int rounds){
        for (int i = 0; i < rounds; i++) {
            scroll(scrollDirection);
        }
    }

    public static void scroll(String scrollDirection) {
        Double screenPerecentage = scrollDirection.trim().equalsIgnoreCase("UP")?0.8D:0.2D;
        try {
            MobileCommands mobileCommands = new MobileCommands();
            Dimension dimensions = mobileCommands.getWebDriver().manage().window().getSize();
            Double screenHeightStart = (double) dimensions.getHeight() * 0.5D;
            int scrollStart = screenHeightStart.intValue();
            double anchor = dimensions.width * 0.5;
            Double screenHeightEnd = (double) dimensions.getHeight() * screenPerecentage;
            int scrollEnd = screenHeightEnd.intValue();
            TouchAction action = new TouchAction((PerformsTouchActions) mobileCommands.getWebDriver());
            action.press(PointOption.point((int) anchor, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L))).moveTo(PointOption.point((int) anchor, scrollEnd)).release().perform();
        } catch (Exception var8) {

            throw var8;
        }
    }

    public static boolean isElementFoundNoException(WebDriver driverTemp,By element) {
        driverTemp.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        boolean Found = false;
        try {
            Found=driverTemp.findElement(element).isDisplayed();
        } catch (Exception e) {
        }
        driverTemp.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return Found;
    }

    public static int visibleWebElementFromListOfWebElement(WebDriver driverTemp,List<By> listOfElement) {

        driverTemp.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int foundIndex = 0;

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (elapsedTime < 20 * 1000 && foundIndex == 0) {
            for (int i = 0; i < listOfElement.size(); i++) {
                if (isElementFoundNoException(driverTemp,listOfElement.get(i))) {
                    foundIndex = i + 1;
                }
            }
            elapsedTime = (new Date()).getTime() - startTime;
        }

        driverTemp.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return foundIndex;
    }

    /**
     * Returns element present or not
     * @param by element identification
     * @param maxWait maxWait
     * @return isElementPresent
     */
    public static boolean isElementPresent(By by, int maxWait){
        boolean isPresent = false;
        AndroidDriver driver = (AndroidDriver) new MobileCommands().getWebDriver();
        driver.manage().timeouts().implicitlyWait(maxWait, TimeUnit.SECONDS);
        if(driver.findElements(by).size() > 0){
            isPresent = true;
        }
        driver.manage().timeouts().implicitlyWait(new BaseTest().getWait(), TimeUnit.SECONDS);
        return isPresent;
    }

    public static String getVisibleElementFromListOfWebElement(WebDriver driverTemp,HashMap<By,String> listOfElement) {

        driverTemp.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String foundElement = "";

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (elapsedTime < 20 * 1000 && foundElement.isEmpty()) {
            for (By key:listOfElement.keySet()){
                if (isElementFoundNoException(driverTemp,key)) {
                    foundElement = listOfElement.get(key);
                }
            }
            elapsedTime = (new Date()).getTime() - startTime;
        }

        driverTemp.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return foundElement;
    }
}
