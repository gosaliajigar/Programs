Source : 
https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
https://docs.oracle.com/javase/8/docs/technotes/guides/collections/reference.html
https://stackoverflow.com/questions/559839/big-o-summary-for-java-collections-framework-implementations

List implementations:
---------------------
                      		get  		add  		contains 		next 		remove(0) 	iterator.remove
ArrayList            	O(1) 	O(1) 	O(n)     	O(1) 	O(n)      	O(n)
LinkedList            	O(n) 	O(1) 	O(n)     	O(1) 	O(1)      	O(1)
CopyOnWriteArrayList 	O(1) 	O(n) 	O(n)     	O(1) 	O(n)      	O(n)

Set implementations:
--------------------
                     		add      		contains 		next     notes
HashSet               	O(1)     	O(1)     	O(h/n)   h is the table capacity
LinkedHashSet         	O(1)     	O(1)     	O(1) 
CopyOnWriteArraySet   	O(n)     	O(n)     	O(1) 
EnumSet               	O(1)     	O(1)     	O(1) 
TreeSet               	O(log n) 	O(log n) 	O(log n)
ConcurrentSkipListSet 	O(log n) 	O(log n) 	O(1)

Map implementations:
--------------------
                      		get      		containsKey 	next     		Notes
HashMap               	O(1)     	O(1)        	O(h/n)   h is the table capacity
LinkedHashMap         	O(1)     	O(1)        	O(1) 
IdentityHashMap       	O(1)     	O(1)        	O(h/n)   h is the table capacity 
EnumMap               	O(1)     	O(1)        	O(1) 
TreeMap               	O(log n) 	O(log n)    	O(log n) 
ConcurrentHashMap     	O(1)     	O(1)        	O(h/n)   h is the table capacity 
ConcurrentSkipListMap 	O(log n) 	O(log n)    	O(1)

Queue implementations:
----------------------
                      		offer    		peek 		poll     		size
PriorityQueue         	O(log n) 	O(1) 	O(log n) 	O(1)
ConcurrentLinkedQueue	O(1)     	O(1) 	O(1)     	O(n)
ArrayBlockingQueue    	O(1)     	O(1) 	O(1)     	O(1)
LinkedBlockingQueue   	O(1)     	O(1) 	O(1)     	O(1)
PriorityBlockingQueue 	O(log n) 	O(1) 	O(log n) 	O(1)
DelayQueue            	O(log n) 	O(1) 	O(log n) 	O(1)
LinkedList            	O(1)     	O(1) 	O(1)     	O(1)
ArrayDeque            	O(1)     	O(1) 	O(1)     	O(1)
LinkedBlockingDeque   	O(1)     	O(1) 	O(1)     	O(1)



https://javarevisited.blogspot.com/2013/01/difference-between-identityhashmap-and-hashmap-java.html

IdentityHashMap vs HashMap
--------------------------
1) IdentityHashMap uses equality operator "==" for comparing keys and values inside Map while HashMap uses equals method for comparing keys and values.

2) Unlike HashMap, who uses hashcode to find bucket location, IdentityHashMap also doesn't use hashCode() instead it uses System.identityHashCode(object).

3) Since IdentityHashMap doesn't use equals() its comparatively faster than HashMap for object with expensive equals() and hashCode().

4) One more difference between HashMap and IdentityHashMap is Immutability of the key. One of the basic requirement to safely store Objects in HashMap is keys needs to be immutable, IdentityHashMap doesn't require keys to be immutable as it is not relied on equals and hashCode.

http://javahungry.blogspot.com/2015/09/difference-between-weakhashmap-and-hashmap-with-exmaple.html

WeakHashMap vs HashMap
----------------------

1) Entry object Garbage Collected :  In HashMap , entry object(entry object stores key-value pairs) is not eligible for garbage collection .In other words, entry object will remain in the memory even if the key object associated with key-value pair is null.

According to WeakHashMap Oracle docs, An entry in a  WeakHashMap will automatically be removed when its key is no longer in ordinary use (even having mapping for a given key will not prevent the key from being discarded by the garbage collector that is made finalizable , finalized and then reclaimed). When a key is discarded then its entry is automatically removed from the map , in other words, garbage collected.

2) Key objects Reference :  In HashMap key objects have strong(also called soft) reference.

Each key object in the WeakHashMap  is stored indirectly as the referent of a Weak reference(also called hard ) reference. Therefore , a key will automatically be removed only after the weak references to it , both inside and outside of the map , have been cleared by the garbage collector. Check here for  the difference between strong and weak reference.

3) Automatic Size decrease : Calling size()  method on HashMap object will return the same number of key-value pairs. size will decrease only if remove() method is called explicitly on the HashMap object.

Because the garbage collector may discard keys at anytime, a WeakHashMap may behave as though an unknown thread is silently removing entries. So it is possible for the size method to return smaller values over time.So, in WeakHashMap  size decrease happens automatically.

4)  Clone method :   HashMap implements Cloneable interface . HashMap class clone() method returns the shallow copy of the object , although , keys and values themselves are not cloned.

WeakHashMap does not implement Cloneable interface , it only implements Map interface. Hence , there is no clone() method in the WeakHashMap class.


5) Serialize and Deserialize objects : HashMap implements Serializable interface . So HashMap class object state can be serialized or deserialized (i.e state of the HashMap object can be saved and again resume from the saved state). 

WeakHashMap does not implement Serializable interface . As a result , WeakHashMap object will not have any of their state serialized or deserialized.(i.e state of the WeakHashMap object cannot be saved and again resume from the saved state). 
