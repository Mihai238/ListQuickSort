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

    private DoublyLinkedList lst;

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
        lst = in;
        ListElement left = in.first;
        ListElement right = in.first.prev;
        quicksortList(left, right);

        printList(left, right);
        while (left.prev.getKey() < left.getKey()) left = left.next;
        in.first = left;
		return in;
	}

    private void quicksortList(ListElement left, ListElement right) {
        if (left != right) {
            if (left.next == right) {
                if (left.getKey() > right.getKey()) {
                    swapListElements(left, right);
                }
                return;
            }
            //printList(left, right);
            ListElement[] ans = partition(left, right);
            left = ans[0];
            right = ans[1];
            //printList(left, right);
            ListElement pivot = ans[2];
            if (left != pivot && left != right) {
                quicksortList(left, pivot.prev);
            }
            if (right != pivot && left != right) {
                quicksortList(pivot.next, right);
            }
        }
    }

    private ListElement[] partition(ListElement left, ListElement right) {
        ListElement leftLeft = left.prev;

        int pvalue = right.getKey();
        ListElement pivot = right;
        while (left != right) {
            while (left.getKey() <= pvalue && left != right) {
                left = left.next;
            }
            if (left == right) break;
            do {
                right = right.prev;
            } while (right.getKey() > pvalue && left != right);
            if (left == right) break;
            swapListElements(left, right);
            ListElement aux = left;
            left = right;
            right = aux;
            left = left.next;
            if (left == right) break;
        }

        boolean cyc = false;
        if (leftLeft == pivot) {
            cyc = true;
        } else {
            left = leftLeft.next;
        }
        swapListElements(right, pivot);
        if (cyc) left = right.next;
        else left = leftLeft.next;

        ListElement[] ans = new ListElement[] {left, right, pivot};
        return ans;
    }

    private void swapListElements(ListElement left, ListElement right) {
        ListElement aux;
        if (left.next == right) {
            left.prev.next = right;
            right.next.prev = left;
            left.next = right.next;
            right.prev = left.prev;
            left.prev = right;
            right.next = left;
        } else {
            if (right.next == left) {
                left.next.prev = right;
                right.prev.next = left;
                right.next = left.next;
                left.prev = right.prev;
                right.prev = left;
                left.next = right;
            } else {
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
            }
        }
    }

    private void printList(ListElement left, ListElement right) {
        while (left != right) {
            System.out.print(left.getKey() + " ");
            left = left.next;
        }
        System.out.println(left.getKey() + " ");
    }

}
