package com.shivam.java_7_collection;
import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {

        /* ------------------ LIST ------------------ */
        // Ordered, allows duplicates, indexed access
        List<String> list = new ArrayList<>();
        list.add("A");   // Add
        list.add("B");
        list.add("C");
        list.set(1, "B2"); // Update (index-based)
        list.remove("C");  // Remove by value
        list.remove(0);    // Remove by index
        // Iterate
        for(String s : list) System.out.println("List item: " + s);

        /* Output:
        List item: B2
        */

        /* ------------------ SET ------------------ */
        // No duplicates, no index, unique elements
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(20); // Duplicate ignored
        set.remove(10);
        for(Integer i : set) System.out.println("Set item: " + i);

        /* Output:
        Set item: 20
        */

        /* ------------------ LINKEDHASHSET ------------------ */
        // Maintains insertion order, unique
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("One");
        lhs.add("Two");
        lhs.add("Three");
        lhs.remove("Two");
        System.out.println("LinkedHashSet: " + lhs);
        /* Output:
        LinkedHashSet: [One, Three]
        */

        /* ------------------ TREESET ------------------ */
        // Sorted, unique
        Set<Integer> ts = new TreeSet<>();
        ts.add(50);
        ts.add(20);
        ts.add(40);
        ts.remove(20);
        System.out.println("TreeSet: " + ts);
        /* Output:
        TreeSet: [40, 50]
        */

        /* ------------------ QUEUE ------------------ */
        // FIFO (First-In-First-Out)
        Queue<String> queue = new LinkedList<>();
        queue.add("X");
        queue.add("Y");
        queue.offer("Z");
        System.out.println("Queue poll: " + queue.poll()); // removes head
        for(String q : queue) System.out.println("Queue item: " + q);

        /* Output:
        Queue poll: X
        Queue item: Y
        Queue item: Z
        */

        /* ------------------ DEQUE ------------------ */
        // Double ended queue
        Deque<String> dq = new ArrayDeque<>();
        dq.addFirst("Front");
        dq.addLast("Back");
        dq.removeFirst();
        dq.removeLast();
        System.out.println("Deque empty? " + dq.isEmpty());
        /* Output:
        Deque empty? true
        */

        /* ------------------ MAP ------------------ */
        // Key-Value pairs, no duplicate keys
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(2, "TwoUpdated"); // Update
        map.remove(1); // Remove by key
        for(Map.Entry<Integer, String> e : map.entrySet())
            System.out.println("Map key=" + e.getKey() + " value=" + e.getValue());

        /* Output:
        Map key=2 value=TwoUpdated
        */

        /* ------------------ LINKEDHASHMAP ------------------ */
        // Maintains insertion order
        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "Apple");
        lhm.put(2, "Banana");
        lhm.put(3, "Cherry");
        lhm.remove(2);
        System.out.println("LinkedHashMap: " + lhm);
        /* Output:
        LinkedHashMap: {1=Apple, 3=Cherry}
        */

        /* ------------------ TREEMAP ------------------ */
        // Sorted order of keys
        Map<Integer, String> tm = new TreeMap<>();
        tm.put(5, "Five");
        tm.put(2, "Two");
        tm.put(8, "Eight");
        tm.remove(5);
        System.out.println("TreeMap: " + tm);
        /* Output:
        TreeMap: {2=Two, 8=Eight}
        */

        /* ------------------ ENUMMAP ------------------ */
        enum Day { MON, TUE, WED }
        EnumMap<Day, String> em = new EnumMap<>(Day.class);
        em.put(Day.MON, "Start");
        em.put(Day.TUE, "Work");
        em.put(Day.WED, "Mid");
        em.remove(Day.TUE);
        System.out.println("EnumMap: " + em);
        /* Output:
        EnumMap: {MON=Start, WED=Mid}
        */
    }
}

/* =================== RULES / NOTES ===================
1. List → Ordered, allows duplicates, index-based.
2. Set → Unique, no index, unordered (HashSet), ordered (LinkedHashSet), sorted (TreeSet).
3. Queue → FIFO, use poll()/peek().
4. Deque → Double-ended queue (add/remove from both ends).
5. Map → Key-Value store, keys unique, values can duplicate.
   - HashMap: Unordered
   - LinkedHashMap: Maintains insertion order
   - TreeMap: Sorted by keys
   - EnumMap: Keys restricted to enum type
6. Update = use set() (List), put() (Map), replace() methods.
7. Iterate with: for-each, Iterator, or Stream API.
=========================================================
*/

/* =================== SUMMARY ===================
✅ Add → add(), put()
✅ Remove → remove(), poll(), clear()
✅ Update → set(), put() (replaces old value)
✅ Iterate → for-each, iterator(), streams
✅ Notes → Pick collection based on:
   - Need order? (List / LinkedHashSet / TreeMap)
   - Need uniqueness? (Set)
   - Need Key-Value? (Map)
=========================================================
*/

