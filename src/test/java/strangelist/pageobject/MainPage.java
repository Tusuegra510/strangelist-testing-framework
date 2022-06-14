package strangelist.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

@DefaultUrl("http://immense-hollows-74271.herokuapp.com/")
public class MainPage extends PageObject implements IElementsToMatch {

	@FindBy(id = "inputImage")
	protected WebElementFacade chooseFile;

	@FindBy(name = "text")
	protected WebElementFacade textDescription;

	@FindBy(xpath = "//button[contains(.,'Create Item')]")
	protected WebElementFacade buttonCreate;

	@FindBy(xpath = "//p[contains(text(),'')]")
	protected WebElementFacade listTitle;

	@FindBy(xpath = "//button[contains(.,'Update Item')]")
	protected WebElementFacade buttonUpdate;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/div[2]/p[1]")
	protected WebElementFacade itemDescription;

	@FindBy(xpath = "//button[contains(.,'Yes, delete it!')]")
	protected WebElementFacade buttonDeleteModal;

	public void upLoadImage(){
		chooseFile.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\Duke.png");
	}

	public void writeDescription(String description){
		textDescription.sendKeys(description);
	}

	public void clickCreateItem(){
		buttonCreate.click();
	}

	public void validate_description_and_image(String description, String image){
		assertEquals(obtain_description_item(description), description);
		assertThat(obtain_path_image(description), containsString(image));
	}

	public void write_description(String description){
		textDescription.type(description);
	}

	public void click_button_update(){
		buttonUpdate.click();
	}

	public void validate_description(String description){
		assertEquals(obtain_description_item(description), description);
	}

	public void click_on_delete_item(String description) {
		findBy(deleteItemButton, description).click();
	}

	public void click_on_delete_modal(){
		buttonDeleteModal.click();
	}

	public void verify_item_not_preset(String description){
		assertNotSame(obtain_description_item(description), description);
	}

	public void validate_length_description(String description){
		assertTrue(obtain_description_item(description).length() < 300);
	}

	public void validate_exist_description(String description){
		assertEquals(obtain_description_item(description), description);
	}

	/***
	 * This method return the description of the item
	 * @param description
	 * @return
	 */
	public String obtain_description_item(String description) {
		return findBy(descriptionItem, description).getText();
	}

	/***
	 * This method return the path image of the item
	 * @param description
	 * @return
	 */
	public String obtain_path_image(String description) {
		return findBy(pathImageItem, description).getAttribute("src");
	}
}
