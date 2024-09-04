// Name: Amit Deri; ID: 316443548

package mmn14;

public class Reduce {
	
    // this is the reduce method as we asked we compare the element to the x value which is 60 
	// and if we get a value that >= 60 then we will print it else we are reduce this object
	public static <T extends Comparable<T>> SortedGroup<T> reduce(SortedGroup<T> sGroup, T x) {
        SortedGroup<T> reducedGroup = new SortedGroup<>();
        
        for (T element : sGroup) {
            if (element.compareTo(x) >= 0) {
                reducedGroup.add(element);
            }
        }
        
        return reducedGroup;
    }

}
