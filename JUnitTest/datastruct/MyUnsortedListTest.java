package datastruct;

import static org.junit.Assert.*;

import org.junit.*;

public class MyUnsortedListTest {
	MyUnsortedList<String> listString;
	MyUnsortedList<Integer> emptyListInt;

	@Before
	public void init() {
		listString = MyUnsortedList.of("5", "6", "7");
		emptyListInt = MyUnsortedList.of();
	}
	@Test
	public void testIsEmpty() {
		assertTrue("creation of a list", emptyListInt.isEmpty());
	}
	@Test
	public void testIsEmptyFalse() {
		assertFalse("creation of unempty list", listString.isEmpty());
	}
	@Test
	public void testIsEmptyFalse2() {
		emptyListInt.append(5);
		assertFalse("adding an element", emptyListInt.isEmpty());
	}
	@Test
	public void testSizeAtInitialisation() {
		assertEquals("initialise a 3-elements list", 3,listString.size());
	}
	@Test
	public void testSizeAfterManipulations() {
		listString.append("4");
		listString.append("6");
		listString.pop();
		assertEquals("size after adding 2 elements and deleting 1", 4,listString.size());
	}
	@Test
	public void testPrependWithNotEmptyList() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("1", "5", "6", "7");
		listString.prepend("1");
		assertEquals("test premier élément ajouté", listString2, listString);
	}
	@Test
	public void testPrependWithEmptyList() {
		MyUnsortedList<Integer> listInt2 = MyUnsortedList.of(2);
		emptyListInt.prepend(2);
		assertEquals("test d'ajout d'un élément à une liste vide", listInt2, emptyListInt);
	}
	@Test
	public void testInsertAtFirstPosition() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("1", "5", "6", "7");
		listString.insert("1", 0);
		assertEquals("test ajout d'un élément à la première position", listString2, listString);
	}
	@Test
	public void testInsertAtIntermediatePosition() {
		MyUnsortedList<Integer> listInt2 = MyUnsortedList.of(1, 2, 3);
		emptyListInt.append(1);
		emptyListInt.append(3);
		emptyListInt.insert(2, 1);
		assertEquals("test ajout d'un élément à la deuxième position", listInt2, emptyListInt);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAtBadPosition() {
		listString.insert("test", -1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAtBadPosition2() {
		listString.insert("test", 4);
	}
	@Test
	public void testAppendWithNotEmptyList() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6", "7","dernier");
		listString.append("dernier");
		assertEquals("test d'ajout à la fin d'une liste non vide", listString2, listString);
	}
	@Test
	public void testAppendWithEmptyList() {
		MyUnsortedList<Integer> listInt2 = MyUnsortedList.of(2);
		emptyListInt.append(2);
		assertEquals("test d'ajout à la fin d'une liste vide", listInt2, emptyListInt);
	}
	@Test
	public void testPopWithNotEmptyList() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("6", "7");
		listString.pop();
		assertEquals("test de suppression du premier élément d'une liste non vide", listString2, listString);
	}
	@Test(expected = EmptyListException.class)
	public void testPopWithEmptyList() {
		emptyListInt.pop();
	}
	@Test
	public void testReturnPop() {
		assertEquals("test de retour du premier élément supprimé dans la liste", "5", listString.pop());
	}
	@Test
	public void testRemoveFirstElement() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6", "7");
		assertEquals("test de suppression du premier élément d'une liste non vide", listString2.remove(0), listString.remove(0));
	}
	@Test
	public void testRemoveWithNotEmptyList() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "7");
		listString.remove(1);
		assertEquals("test de suppression au milieu d'une liste non vide", listString2, listString);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveWithIndexOutOfBounds() {
		listString.remove(5);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveWithIndexOutOfBounds2() {
		listString.remove(-1);
	}
	@Test
	public void testReturnRemove() {
		assertEquals("test de retour du second élément supprimé dans la liste", "6", listString.remove(1));
	}
	@Test
	public void testPopLast() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6");
		listString.popLast();
		assertEquals("test d'ajout à la fin d'une liste non vide", listString2, listString);
	}
	@Test(expected = EmptyListException.class)
	public void testPopLastWithEmptyList() {
		emptyListInt.popLast();
	}
	@Test
	public void testReturnPopLast() {
		assertEquals("test de retour du dernier élément supprimé dans la liste", "7", listString.popLast());
	}
	@Test
	public void testEqualsWithDifferentObjectType() {
		assertFalse("test de non égalité entre un objet liste et un entier", emptyListInt.equals(0));
	}
	@Test
	public void testEqualsWithDifferentListType() {
		MyUnsortedList<Integer> listInt2 = MyUnsortedList.of(5, 6, 7);
		assertFalse("test de non égalité entre un objet liste et un entier", emptyListInt.equals(listInt2));
	}
	@Test
	public void testEqualsWithDifferentSizes() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6");
		assertFalse("test d'égalité entre deux listes de taille différente", listString.equals(listString2));
	}
	@Test
	public void testEqualsWithDifferentElements() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6", "7");
		assertTrue("test d'égalité entre deux listes ayant les mêmes éléments", listString.equals(listString2));
		listString2.pop();
		listString2.append("8");
		assertFalse("test de non égalité entre deux listes ayant des éléments différents", listString.equals(listString2));
	}
	@Test
	public void testEqualsWithNullElements() {
		MyUnsortedList<String> listString2 = MyUnsortedList.of("5", "6", "7");
		listString.pop();
		listString.append(null);
		assertFalse("test de non égalité entre deux listes ayant des éléments différents dont 1 null", listString.equals(listString2));
	}
	@Test
	public void testEqualsWithEmptyLists() {
		MyUnsortedList<Integer> listInt2 = MyUnsortedList.of();
		assertTrue("test de non égalité entre deux listes ayant des éléments différents dont 1 null", emptyListInt.equals(listInt2));
	}
	@Test
	public void testToStringEquals() {
		String ch = "MyUnsortedList { size = 3, [5, 6, 7] }";
		assertEquals("test d'affichage d'une liste", listString.toString(), ch);
	}

}
