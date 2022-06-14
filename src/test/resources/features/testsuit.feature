@Test_Suite
Feature: As a user I want to validate the main functionalities of the website.

  Background:
    Given a user open the browser and go to the main page

  @Test_Case_01
  Scenario Outline: Create an item
    Given the user upload an image on the choose file button
    When the user write a description <description>
    And the user clicks on the button to create item
    Then the user can see your item added with its image and description <description>
      | Duke.png |
    Examples:
      | description                         |
      | Duke, la mascota de Java, saludando |

  @Test_Case_02
  Scenario Outline: Edit an existing item
    Given The user click on the button edit an item with <description>
    When The user writes something in the textarea <edited_description>
    Then The user can see the changes
      | <edited_description> |
    Examples:
      | description           | edited_description   |
      | Mike plays the guitar | Mike plays the piano |

  @Test_Case_03
  Scenario Outline: Delete item created
    Given the user identify the item created with <description> and click on the button delete
    When the user tries to delete item
    Then the user verify that the item it is not present anymore
      | <description> |
    Examples:
      | description           |
      | this is a description |

  @Test_Case_04
  Scenario Outline: Check max long in description
    Given the user select an item
    Then the user check the length of the <description> of that item
    Examples:
      | description                                                                                                    |
      | Will is hunted by a strange entity whereas his friends search for him only to find a lonely girl in the woods. |

  @Test_Case_05
  Scenario Outline: Check if exist in the list the item with text “Creators: Matt Duffer, Ross Duffer”
    Given the user search the item
    Then the user verify that the <description> is correct
    Examples:
      | description                        |
      | Creators: Matt Duffer, Ross Duffer |