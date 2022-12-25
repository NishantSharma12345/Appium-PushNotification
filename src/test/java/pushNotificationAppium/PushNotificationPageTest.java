package pushNotificationAppium;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.PushNotificationPage;

public class PushNotificationPageTest extends BaseClassAndroid
{
	PushNotificationPage pnp;
	
	@BeforeClass
	public void init()
	{
		pnp = new PushNotificationPage(driver);
	}
	
	@Test(priority = 0)
	public void pushNotificationPerform()
	{
		//open notification
		driver.openNotifications();
		sleep(1);//wait while notifications are playing animation to appear to avoid missed taps
		Assert.assertTrue(pnp.isNotificationPage(), "Notification page is not loaded");
		
		int itemsListSize = pnp.getLastItemsContentSize();

		String name, title, text;
		int notificationItemNum = 0;
		for (int i = 0; i <= itemsListSize; i++) 
		{
			name = pnp.getItemName(i);
		    title = pnp.getItemTitle(i);
		    text = pnp.getItemText(i);
		    System.out.println("  Notification title is: " + title);		    
		    if (name.contains(prop.getProperty("itemName"))) 
		    {
		    	System.out.println("  Notification Found  ");
		    	notificationItemNum = i;
				System.out.println(notificationItemNum);
		    	pnp.tapItemTitle(i);
		    	sleep(2);	
		    	System.out.println("  Notification text is: " + text);
		        break;
		    }
		    else
		    {
		    	System.out.println("  No Notification Found  ");
		    }
		}
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	
    @Test(priority = 1)
	public void clearNotificationPerform()
	{
		//open notification
	    driver.openNotifications();
		sleep(1);//wait while notifications are playing animation to appear to avoid missed taps
		Assert.assertTrue(pnp.isNotificationPage(), "Notification page is not loaded");
		
		if (pnp.isClearAllBtnLoaded()) 
		{
			pnp.tapClearAllBtn();
			System.out.println("  Notifications Cleared  ");

	    } 
		else
		{
			System.out.println("  No Notification Found For Clear ");
			driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	        sleep(1);
	    }	    
	}
	
}
