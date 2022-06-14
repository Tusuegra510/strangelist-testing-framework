package strangelist.stepsdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import strangelist.pageobject.MainPage;
import strangelist.tasks.EditItem;

public class UserSteps {

	@Steps
	MainPage mainPage;
	EditItem editItem;

	/**
	 * PRE-CONDITION
	 */
	@Given("a user open the browser and go to the main page")
	public void goToMainPage(){
		mainPage.setDefaultBaseUrl("http://immense-hollows-74271.herokuapp.com/");
		mainPage.open();
	}

	/**
	 * Test_Case_01 - Create an item
	 */
	@Given("^the user upload an image on the choose file button")
	public void uploadAnImage(){
		mainPage.upLoadImage();
	}

	@When("^the user write a description (.*)$")
	public void writeADescription(String description){
		mainPage.writeDescription(description);
	}

	@And("^the user clicks on the button to create item$")
	public void clicksOnTheButtonToCreateItem(){
		mainPage.clickCreateItem();
	}

	@Then("^the user can see your item added with its image and description (.*)$")
	public void seeYourItemAddedWithItsImageAndDescription(String description, DataTable table){
		mainPage.validate_description_and_image(description, table.asList().get(0));
	}

	/**
	 * Test_Case_02 - Edit an existing item
	 */
	@Given("^The user click on the button edit an item with (.+)$")
	public void userEditAnItemWithDescription(String description) throws InterruptedException {
		editItem.button_edit(description);
		Thread.sleep(5000);
	}

	@When("^The user writes something in the textarea (.+)$")
	public void userWritesSomethingInTextArea(String newDescription){
		mainPage.write_description(newDescription);
		mainPage.click_button_update();
	}

	@Then("^The user can see the changes$")
	public void userCanSeeTheChanges(DataTable table){
		mainPage.validate_description(table.asList().get(0));
	}

	/**
	 * Test_Case_03 - Delete item created
	 */
	@Given("^the user identify the item created with (.+) and click on the button delete$")
	public void userIdentifyTheItemCreatedWithDescription(String description){
		mainPage.click_on_delete_item(description);
	}
	@When("^the user tries to delete item$")
	public void userTriesToDeleteItem(){
		mainPage.click_on_delete_modal();
	}

	@Then("^the user verify that the item it is not present anymore$")
	public void userVerifyItemIsNotPresent(DataTable table){
		mainPage.verify_item_not_preset(table.asList().get(0));
	}

	/**
	 * Test_Case_04 - Check max long in description
	 */
	@Given("^the user select an item$")
	public void user_select_item() {
		//nothing...
	}

	@Then("^the user check the length of the (.+) of that item$")
	public void user_check_length_of_item(String description) {
		mainPage.validate_length_description(description);
	}

	/**
	 * Test_Case_05 - Check if exist in the list the item with text “Creators: Matt Duffer, Ross Duffer”
	 */
	@Given("^the user search the item$")
	public void user_search_item() {
		//nothing...
	}

	@Then("^the user verify that the (.+) is correct$")
	public void user_verify_description(String description) {
		mainPage.validate_exist_description(description);
	}
}
