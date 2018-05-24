package roland.orangetest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeEmployeeDetailsPage {
	
	@FindBy(xpath = "//*[@id=\"profile-pic\"]/h1")
	private WebElement nameField;
	
	public WebElement getNameField() {
		return nameField;
	}
	
}
