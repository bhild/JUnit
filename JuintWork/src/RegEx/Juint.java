package RegEx;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Juint {

	/*
	 * to covert to juint
	 	list.addItem("909-365", "tempName", "No description provided."); // this should work
		list.addItem("909-365a", "tempName", "No description provided.--''()())(66."); // this has an invalid description and id
		list.addItem("909-365", "te", "No description provided"); // the description is missing punctuation and the name is too short
		list.addItem("someId", "potato", "Vegital.");//id is invalid
		list.addItem("someId", "potato2369-25@", "no");//all of these are invalid
		list.addItem("98597", "Item-Name", "This is a two sentence description. This is the second sentence.");
		list.addItem("56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?");
	*/
	@Test
	void everythingIsValid() {
		String[] input= {"909-365", "tempName", "No description provided."};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}

}
