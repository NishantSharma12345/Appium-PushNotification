package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PushNotificationPage 
{
    AndroidDriver driver;

	public PushNotificationPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.android.systemui:id/header_label")
	private List<WebElement> notificationPanel;
	
	@AndroidFindBy(id = "android:id/notification_header")
    private List<WebElement> lastItemsContainer;
	
	@AndroidFindBy(id = "android:id/notification_header")
    private List<WebElement> expandBtn;
	
	@AndroidFindBy(id = "android:id/app_name_text")
    private List<WebElement> itemName;
	
	@AndroidFindBy(id = "android:id/title")
    private List<WebElement> itemTitle;
	
	@AndroidFindBy(id = "android:id/text")
    private List<WebElement> itemText;
	
	@AndroidFindBy(id = "android:id/time")
    private List<WebElement> itemTime;
	
	@AndroidFindBy(id = "com.android.systemui:id/dismiss_text")
	private List<WebElement> clearAllBtn;
	
	public boolean isNotificationPage() 
	{
        System.out.println("  Check 'Notification' Screen loaded");
        return  !notificationPanel.isEmpty();
    }
	
	public boolean isClearAllBtnLoaded() 
	{
        return !clearAllBtn.isEmpty();
    }
	
	public int getLastItemsContentSize() 
	{
		 return lastItemsContainer.size();
	}
	
	public String getItemName(int num) 
	{
		return itemName.get(num).getText();
	}
	
	public String getItemTitle(int num) 
	{
		return itemTitle.get(num).getText();
	}
	
	public String getItemText(int num) 
	{
		return itemText.get(num).getText();
    }
	
	public String getItemTime(int num) 
	{
		return itemTime.get(num).getText();
    }
	
	 public void tapItemTitle(int num) 
	 {
		 expandBtn.get(num).click();	        
	 }
	 
	 public void tapClearAllBtn() 
	 {
		 clearAllBtn.get(0).click();
		 
	 }
}
