package RegEx;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Juint {

	@Test
	void everythingIsValid() {
		String[] input= {"909-365", "tempName", "No description provided."};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void everythingIsValidPriceInDescription() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void notingIsValid() {
		String[] input= {"someId", "potato2369-25@", "no"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidPriceInDesUnPunct() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidId() {
		String[] input= {"909-365a", "tempName", "No description provided."};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidDescriptionNoPunctAndTooFewChars() {
		String[] input= {"909-365", "te", "No description provided"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void idAndDescriptionContainInvaldChars() {
		String[] input= {"909-365a", "tempName", "No description provided.--''()())(66."};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}

}
