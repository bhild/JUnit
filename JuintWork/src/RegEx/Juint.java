package RegEx;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
@SuppressWarnings("deprecation")
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
	@Test
	void canSetAndGet() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canSetAndGetWhenInvalid() {
		String[] input= {"56465444166846464646464649646868436", "validName?!>@#>?", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test
	void noErrorWhenUseInvalidId() {
		String[] input= {"56465444166846464646464649646868436b", "validName?!>@#>?", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test
	void noErrorWhenIdNotExist() {
		String[] input= {"56465444166846464646464649646868436", "validName?!>@#>?", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]+"1"));
	}
	@Test
	void experationWorks() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals("validName expires on: "+new Date(121,1,25).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationReturnsNullWithNonExistantId() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+1));
	}
	@Test
	void invalidIdCausesNoErrorsInExperation() {
		String[] input= {"56465444166846464646464649646868436b", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+1));
	}
	@Test
	void hasExpired() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(120,0,25));
		assertEquals(true,list.itemHasExpired(input[0]));
	}
	@Test
	void itemHasNoExperationHasExpired() {
		String[] input= {"56465444166846464646464649646868436", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(false,list.itemHasExpired(input[0]));
	}
}
