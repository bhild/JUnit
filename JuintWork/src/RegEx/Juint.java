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
		String[] input= {"340348643", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void priceInDesTest2() {
		String[] input= {"430483432042", "validName", "This item costs $120.00?"};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void priceInDesTest3() {
		String[] input= {"145042586-7052-0485204-40542480-08574", "validName", "$19.00 is too much. This only costs $12."};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void priceInDesTest4() {
		String[] input= {"4024860-7455240", "validName", "Why pay $25 when you can pay less. This only costs $14."};
		assertEquals(true, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void notingIsValid() {
		String[] input= {"someId", "potato2369-25@", "no"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidPriceInDesUnPunct() {
		String[] input= {"542105634", "validName", "klasgfn! iewhbfiBWEG. $120.00"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidId() {
		String[] input= {"9y09-365a", "tempName", "No description provided."};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void invalidDescriptionNoPunctAndTooFewChars() {
		String[] input= {"42310-12483", "te", "No description provided"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void desTooShort() {
		String[] input= {"4532-45341", "test", "No."};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	void desNoPunct() {
		String[] input= {"263-428-365", "test", "This has no punctuation"};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void idAndDescriptionContainInvaldChars() {
		String[] input= {"909-365a", "tempName", "No description provided.--''()())(66."};
		assertEquals(false, new WarehouseItemList().isValidItem(input[0], input[1], input[2]));
	}
	@Test
	void canStoreAndGet0() {
		String[] input= {"452412-45324505605", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGet1() {
		String[] input= {"5931238-5", "validName", "$19.00 is too much. This only costs $12."};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGet2() {
		String[] input= {"55-85", "NewName", "Awsome item description. You want to buy this item now!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGet3() {
		String[] input= {"51846-44984", "potato", "This is full of starch."};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGet4() {
		String[] input= {"22-55-44", "bread", "Best ate plain!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGet5() {
		String[] input= {"11-99", "chair", "Not very comfortable."};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertArrayEquals(input,list.getItem(input[0]));
	}
	@Test
	void canStoreAndGetWhenInvalid0() {
		String[] input= {"703545%24-45244814t", "validName?!>@#>?", "klasgfn! iewhbfiBWEG. $120.00"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test
	void noErrorWhenUseInvalidId() {
		String[] input= {"56465444166846464646464649646868436b", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void noErrorWhenInvalid1() {
		String[] input= {"25b", "invalidName?!>@#>?", "Not"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void noErrorWhenInvalid2() {
		String[] input= {"25b", "invalidName", "Not"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void noErrorWhenInvalid3() {
		String[] input= {"25", "invalidName", "Not"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void idIsInvalidTest2(){
		String[] input= {"2-12-34!", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void idIsInvalidTest3(){
		String[] input= {"ss-3333", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void idIsInvalidTest4(){
		String[] input= {"d22-dd66@", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	void idIsInvalidTest5(){
		String[] input= {"7563734/", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void idIsInvalidTest6(){
		String[] input= {"#-55*", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test 
	void idIsInvalidTest7(){
		String[] input= {"6-2d", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]));
	}
	@Test
	void noErrorWhenIdNotExist() {
		String[] input= {"0473048", "validName?!>@#>?", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(null, list.getItem(input[0]+"1"));
	}
	@Test
	void experationWorks0() {
		String[] input= {"34521", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(105,11,7));
		assertEquals("validName expires on: "+new Date(105,11,7).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationWorks1() {
		String[] input= {"4536421", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(11,6,2));
		assertEquals("validName expires on: "+new Date(11,6,2).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationWorks2() {
		String[] input= {"7453048", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(120,1,5));
		assertEquals("validName expires on: "+new Date(120,1,5).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationWorks3() {
		String[] input= {"5312485634", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals("validName expires on: "+new Date(121,1,25).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationWorks4() {
		String[] input= {"3075345", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(56,0,30));
		assertEquals("validName expires on: "+new Date(56,0,30).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationWorks5() {
		String[] input= {"0153078-0738530", "validName", "Is this a good des?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(122,5,6));
		assertEquals("validName expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input[0]));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest0() {
		String[] input= {"40534513-07534", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+1));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest1() {
		String[] input= {"55-99", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+"92919"));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest2() {
		String[] input= {"53043-3070", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+"4846468"));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest3() {
		String[] input= {"45312-73120", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+"1151984"));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest4() {
		String[] input= {"4534-453", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+"8518"));
	}
	@Test
	void experationReturnsNullWithNonExistantIdTest5() {
		String[] input= {"45342-54245", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+"6585"));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent0(){
		String[] input= {"742-54453-435", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"3453-4-453", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addExperation(input[0], new Date(122,5,6));
		list.addExperation(input2[0], new Date(121,1,25));
		assertEquals(input[1]+" expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent1(){
		String[] input= {"453455-4453-5", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"45345-4534-1245", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addExperation(input[0], new Date(125,11,5));
		list.addExperation(input2[0], new Date(122,5,6));
		assertEquals(input2[1]+" expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input2[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent2(){
		String[] input= {"45345-45345", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"4353-45345", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addExperation(input[0], new Date(12,5,6));
		list.addExperation(input2[0], new Date(12,8,1));
		assertEquals(input[1]+" expires on: "+new Date(12,5,6).toString(),list.getItemExperation(input[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent3(){
		String[] input= {"534-786345", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"345312-567", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addExperation(input[0], new Date(122,5,6));
		list.addExperation(input2[0], new Date(122,5,6));
		assertEquals(input2[1]+" expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input2[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent4(){
		String[] input= {"4534-73452", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"10-12", "Name2", "Cool description!"};
		String[] input3= {"6531-85634", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addItem(input3[0], input3[1], input3[2]);
		list.addItem(input3[0], input3[1], input3[2]);
		list.addExperation(input[0], new Date(122,5,6));
		list.addExperation(input2[0], new Date(122,5,6));
		list.addExperation(input3[0], new Date(543,8,15));
		assertEquals(input3[1]+" expires on: "+new Date(543,8,15).toString(),list.getItemExperation(input3[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent5(){
		String[] input= {"3545-07370435", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"452-448352", "Name2", "Cool description!"};
		String[] input3= {"7-78377", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addItem(input3[0], input3[1], input3[2]);
		list.addItem(input3[0], input3[1], input3[2]);
		list.addExperation(input[0], new Date(122,5,6));
		list.addExperation(input2[0], new Date(122,5,6));
		list.addExperation(input3[0], new Date(543,8,15));
		assertEquals(input2[1]+" expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input2[0]));
	}
	@Test 
	void experationDistinguishesBetweenIdsWhenMultipleExperationDatesPressent6(){
		String[] input= {"7730-435", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		String[] input2= {"453-7834", "Name2", "Cool description!"};
		String[] input3= {"3453453-40837", "Name2", "Cool description!"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addItem(input2[0], input2[1], input2[2]);
		list.addItem(input3[0], input3[1], input3[2]);
		list.addExperation(input[0], new Date(122,5,6));
		list.addExperation(input2[0], new Date(122,5,6));
		list.addExperation(input3[0], new Date(543,8,15));
		assertEquals(input2[1]+" expires on: "+new Date(122,5,6).toString(),list.getItemExperation(input2[0]));
	}
	@Test
	void invalidIdCausesNoErrorsInExperation() {
		String[] input= {"708375427", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(121,1,25));
		assertEquals(null,list.getItemExperation(input[0]+1));
	}
	@Test
	void hasExpired0() {
		String[] input= {"453245248", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(120,0,25));
		assertEquals(true,list.itemHasExpired(input[0]));
	}
	@Test
	void hasExpired1() {
		String[] input= {"277867", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(11,4,2));
		assertEquals(true,list.itemHasExpired(input[0]));
	}
	@Test
	void hasExpired2() {
		String[] input= {"527857852", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(182,5,28));
		assertEquals(false,list.itemHasExpired(input[0]));
	}
	@Test
	void hasExpired3() {
		String[] input= {"7208967807837", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(548,4,5));
		assertEquals(false,list.itemHasExpired(input[0]));
	}
	@Test
	void hasExpired4() {
		String[] input= {"7038783087", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(42,4,9));
		assertEquals(true,list.itemHasExpired(input[0]));
	}
	@Test
	void hasExpired5() {
		String[] input= {"78034532078", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		list.addExperation(input[0], new Date(224,5,30));
		assertEquals(false,list.itemHasExpired(input[0]));
	}
	@Test
	void itemHasNoExperationHasExpired() {
		String[] input= {"87307827864534", "validName", "klasgfn! iewhbfiBWEG. $120.00?"};
		WarehouseItemList list = new WarehouseItemList();
		list.addItem(input[0], input[1], input[2]);
		assertEquals(false,list.itemHasExpired(input[0]));
	}
	
}
