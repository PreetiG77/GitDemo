package org.genesitech.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils{
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }
    public void longCLickAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "duration", 2000)
        );
    }
    public void scrollToEnd(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture",
                    ImmutableMap.of("left", 100, "top", 100, "width", 100, "height", 200,
                            "direction", "down", "percent", 3.0));
        }while (canScrollMore);

    }

    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("+text+"));"));

    }
    public void swipeAction(WebElement firstImg){
        ((JavascriptExecutor) driver).executeScript("mobile:swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)firstImg).getId(),
                        "direction","left",
                        "percent", 0.75
                ));
    }

}
