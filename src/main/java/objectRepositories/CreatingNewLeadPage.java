package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
    private WebElement pageHeader;
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(name="company")
	private WebElement companyTF;
	
	@FindBy(xpath = "//input[normalize-space(@value)='Save']")
	private WebElement saveBTN;
	
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setLastName(String lastName) {
		lastnameTF.sendKeys(lastName);
	}
	
	public void setCompanyname(String company) {
	companyTF.sendKeys(company);
    }
	
	public void clicksave() {
		saveBTN.click();
	}
}
