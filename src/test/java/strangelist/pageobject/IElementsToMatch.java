package strangelist.pageobject;

public interface IElementsToMatch {

	String descriptionItem = "//p[contains(@class,'story') and contains(text(),'{0}')]";
	String pathImageItem = "//p[contains(@class,'story') and contains(text(),'{0}')]/../../../figure/img";
	String editItemButton = "//body/div[@id='content']/div[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/div[1]/button[1]";
	String deleteItemButton = "//body/div[@id='content']/div[1]/div[1]/ul[1]/li[14]/div[1]/div[1]/div[1]/button[2]";
}
