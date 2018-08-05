Source : https://www.journaldev.com/378/java-util-concurrentmodificationexception

java.util.ConcurrentModificationException
-----------------------------------------

java.util.ConcurrentModificationException is a very common exception when working with java collection classes. 

Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException. 

Concurrent modification exception can come in case of multi-threaded as well as single threaded java programming environment.

Concurrent modification exception comes when we call iterator next() function. 

If you are wondering how Iterator checks for the modification, its implementation is present in AbstractList class where an int variable modCount is defined. 

modCount provides the number of times list size has been changed. 

modCount value is used in every next() call to check for any modifications in a function checkForComodification().


To Avoid ConcurrentModificationException in multi-threaded environment
----------------------------------------------------------------------
- convert the list to an array and then iterate on the array. This approach works well for small or medium size list but if the list is large then it will affect the performance a lot.
- lock the list while iterating by putting it in a synchronized block. This approach is not recommended because it will cease the benefits of multi-threading.
- If using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. This is the recommended approach to avoid concurrent modification exception.


To Avoid ConcurrentModificationException in single-threaded environment
-----------------------------------------------------------------------
Use the iterator remove() function to remove the object from underlying collection object. 

But in this case you can remove the same object and not any other object from the list.


Use for loop to avoid java.util.ConcurrentModificationException
---------------------------------------------------------------
If working on single-threaded environment and want your code to take care of the extra added objects in the list then you can do so using for-loop rather than iterator.

for(int i = 0; i<list.size(); i++){
	System.out.println(list.get(i));
	if(list.get(i).equals("3")){
		list.remove(i);
		i--;
		list.add("6");
	}
}

NOTE: here the counter is decreased because the same object i removed, if you have to remove the next or further
far object then you don’t need to decrease the counter.

