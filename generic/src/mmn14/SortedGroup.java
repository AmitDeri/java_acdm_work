// Name: Amit Deri; ID: 316443548

package mmn14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedGroup<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public SortedGroup() {
        elements = new ArrayList<>();
    }

    // this is the add method
    public void add(T element) {
        int index = 0;
        while (index < elements.size() && element.compareTo(elements.get(index)) > 0) {
            index++;
        }
        elements.add(index, element);
    }

    // this is the remove method it has a counter that count the number of elements that 
    // have been deleted and remove the element the equals method is implemented in the Student class
    // to compare two object of students.
    public int remove(T element) {
        int count = 0;
        int index = 0;
        while (index < elements.size()) {
            if (elements.get(index).equals(element)) {
                elements.remove(index);
                count++;
            } else {
                index++;
            }
        }
        return count;
    }

    public List<T> getElements() {
        return elements;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
    
}


