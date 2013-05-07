package ads1ss13.pa;

/**
 * Sorter Klasse in der die Methode {@link #quicksort(DoublyLinkedList, int)}
 * implementiert werden soll.
 * 
 * <p>
 * In dieser Klasse m&uuml;ssen Sie Ihren Code einf&uuml;gen und die Method
 * {@link #quicksort(DoublyLinkedList, int)} implementieren.
 * </p>
 * 
 * <p>
 * Sie k&ouml;nnen beliebige neue Variablen und Methoden in dieser Klasse
 * hinzuf&uuml;gen. 
 * </p>
 */

public class Sorter {

	/**
	 * Quicksort Implementierung
	 * 
	 * @param in Unsortierte Eingabefolge
	 * @param numOfElements Gr&ouml;&szlig;e der Eingabefolge 
	 * @return Sortiterte Eingabefolge
	 */
	public DoublyLinkedList quicksort(DoublyLinkedList in, int numOfElements) {
		/*
		 * Hier ist die richtige Stelle f&uuml;r Ihre Implementierung.
		 */
        ListElement left = in.first;
        ListElement right = in.first;
        while (right.next != left) {
            right = right.next;
        }

        quicksortList(left, right);
		return in;
	}

    private void quicksortList(ListElement left, ListElement right) {
       ListElement pivot = partition(left, right);

    }

    private ListElement partition(ListElement left, ListElement right) {
    }

}
