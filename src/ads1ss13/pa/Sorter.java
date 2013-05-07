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
        quicksortList(left, pivot);
        quicksortList(pivot, right);
    }

    private ListElement partition(ListElement left, ListElement right) {
        ListElement leftCopy = left;
        ListElement rightCopy = right;
        //TODO Find a way to remember the first element

        int pvalue = right.getKey();
        ListElement pivot = right;
        right = right.prev;
        while (left != right) {
            //TODO Check other special cases
            while (left.getKey() <= pvalue && left != right) {
                left = left.next;
            }
            while (right.getKey() > pvalue && left != right) {
                right = right.prev;
            }
            swapListElements(left, right);
        }
        swapListElements(leftCopy, pivot);
        return pivot;
    }

    private void swapListElements(ListElement left, ListElement right) {
        ListElement aux = left;
        left = right;
        right = aux;

        ListElement leftNext = left.next;
        ListElement leftPrev = left.prev;

        left.next = right.next;
        left.prev = right.prev;
        left.prev.next = left;
        left.next.prev = left;

        right.next = leftNext;
        right.prev = leftPrev;
        right.prev.next = right;
        right.next.prev = right;
        //TODO What if left.next == right??
    }

}
