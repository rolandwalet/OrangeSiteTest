package roland.orangetest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeLandingPage {
	
	@FindBy(id = "txtUsername")
	private WebElement usernameField;
	
	@FindBy(id = "txtPassword")
	private WebElement passwordField;
	
	@FindBy(id = "btnLogin")
	private WebElement loginButton;
	
	public void login(CharSequence username, CharSequence password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}
