package roland.orangetest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeAddEmployeePage {
	
	@FindBy(id = "firstName")
	private WebElement firstNameEntry;
	
	public void enterFirstName(CharSequence firstName) {
		firstNameEntry.sendKeys(firstName);
	}
	
	@FindBy(id = "lastName")
	private WebElement lastNameEntry;
	
	public void enterLastName(CharSequence lastName) {
		lastNameEntry.sendKeys(lastName);
	}
	
	@FindBy(id = "employeeId")
	private WebElement employeeID;
	
	public void enterEmployeeID(CharSequence id) {
		employeeID.clear();
		employeeID.sendKeys(id);
	}
	
	@FindBy(id = "chkLogin")
	private WebElement loginCheck;
	
	public void toggleLoginCheck() {
		loginCheck.click();
	}
	
	@FindBy(id = "user_name")
	private WebElement setUsernameField;
	
	public void setUserName(CharSequence username) {
		setUsernameField.sendKeys(username);
	}
	
	@FindBy(id = "user_password")
	private WebElement setPasswordField;
	
	@FindBy(id = "re_password")
	private WebElement confirmPasswordField;
	
	public void setPassword(CharSequence password) {
		setPasswordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
	}
	
	@FindBy(id = "btnSave")
	private WebElement saveButton;
	public void clickSave() {
		saveButton.click();
	}
	
}
