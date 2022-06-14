package strangelist.tasks;

import strangelist.pageobject.IElementsToMatch;
import strangelist.pageobject.MainPage;

public class EditItem extends MainPage implements IElementsToMatch {
	/***
	 * to press button edit
	 * @param description
	 */
	public void button_edit(String description) {
		findBy(editItemButton, description).click();
	}
}
