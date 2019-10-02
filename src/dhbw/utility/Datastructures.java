package dhbw.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Datastructures {


	public static void CollectionMethods() {
		// important Collection Methods
		Collection c = new ArrayList<Integer>();
		Collection c2 = new TreeSet<Integer>();
		c.add(1); // adds Element
		c.addAll(c2); // adds Collection
		c.remove(1); // removes Element
		c.contains(1); // checks if Collection contains Element
		c.size(); // size of Collection
		for (Iterator iterator = c.iterator(); iterator.hasNext();) {
			Integer element = (Integer) iterator.next();
		}

		// CollectionsMethods:
		Collections.max(c);
		Collections.min(c);
		Collections.sort((List) c);
		Collections.shuffle((List) c);
		Collections.reverse((List) c);
		Collections.binarySearch((List) c, 1);
	}

	public static void ListMethods() {
		// important List Methods
		// LinkedList,ArrayList,Vector
		List l = new ArrayList<Integer>();
		l.get(0); // gets Element at Index
		l.indexOf(1); // finds first Index of Element
		l.lastIndexOf(1); // finds last Index of Element
		l.remove(0); // removes Element at Index (Integer-List -> removes Element!!)
	}

	public static void MapMethods() {
		// important Map Methods
		// HashMap, WeakHashMap, TreeMap, Hashtable
		Map m = new HashMap<Integer, Integer>();
		m.put(1, 2); // puts Key+Value in Map
		m.get(1); // gets value with key
		m.size(); // size of Map
		m.remove(1); // removes value with key
		m.clear(); // removes all values
		m.containsKey(1); // checks if key is in Map
		m.containsValue(1); // checks if value is in Map
		m.isEmpty();// checks if empty
		m.keySet(); // set of all keys
		m.values(); // collection of all values
		for (Object key : m.keySet()) {
			m.get(key);
		}
	}

}
