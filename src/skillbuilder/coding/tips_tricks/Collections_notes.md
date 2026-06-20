# Java Collection Classes: Complete Reference

## Table of Contents
1. [Collection Interface (Root)](#collection-interface-root)
2. [List Interface & Implementations](#list-interface--implementations)
    - ArrayList
    - LinkedList
    - Vector
    - Stack
    - CopyOnWriteArrayList
3. [Set Interface & Implementations](#set-interface--implementations)
    - HashSet
    - LinkedHashSet
    - TreeSet
    - CopyOnWriteArraySet
    - EnumSet
4. [Queue Interface & Implementations](#queue-interface--implementations)
    - PriorityQueue
    - Deque Interface
    - ArrayDeque
    - LinkedList (as Deque)
5. [Map Interface & Implementations](#map-interface--implementations)
    - HashMap
    - LinkedHashMap
    - TreeMap
    - WeakHashMap
    - IdentityHashMap
    - ConcurrentHashMap
    - EnumMap
    - Hashtable (Legacy)
6. [Iterators & Other Utilities](#iterators--other-utilities)

---

## Collection Interface (Root)

### Collection Interface Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `add(E e)` | Adds element | Yes | Returns boolean; may be false if duplicate rejected (Set behavior) |
| `addAll(Collection<? extends E> c)` | Adds all elements from another collection | No | `list.addAll(anotherList)` |
| `remove(Object o)` | Removes first occurrence | Yes | For List: removes by value; for Map: not applicable directly |
| `removeAll(Collection<?> c)` | Removes all elements in collection | No | `list.removeAll(toRemove)` |
| `retainAll(Collection<?> c)` | Keeps only elements in collection (intersection) | Yes | `list.retainAll(keep)` modifies list to contain only elements in keep |
| `clear()` | Removes all elements | No | `list.clear()` |
| `contains(Object o)` | Checks if contains element | No | Uses equals() for comparison |
| `containsAll(Collection<?> c)` | Checks if contains all elements | No | `list.containsAll(subset)` |
| `isEmpty()` | Checks if empty | No | `list.isEmpty()` |
| `size()` | Returns number of elements | No | `list.size()` |
| `iterator()` | Returns iterator | No | `Iterator<String> it = list.iterator()` |
| `stream()` | Returns Stream (Java 8+) | No | `list.stream().filter(...)` |
| `parallelStream()` | Returns parallel Stream | Yes | Order not guaranteed for stateful operations |
| `removeIf(Predicate<? super E> filter)` | Removes elements matching predicate (Java 8+) | No | `list.removeIf(x -> x > 5)` |
| `toArray()` | Converts to Object array | Yes | Returns Object[], not generic |
| `toArray(T[] a)` | Converts to specified array type | Yes | `String[] arr = list.toArray(new String[0])` |
| `toArray(IntFunction<T[]> generator)` | Converts using generator (Java 11+) | No | `list.toArray(String[]::new)` |
| `equals(Object o)` | Equality comparison | Yes | For List: order matters; for Set: order doesn't matter |
| `hashCode()` | Hash code | No | Consistent with equals() |

---

## List Interface & Implementations

### List Interface Additional Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `add(int index, E element)` | Inserts at index | No | `list.add(0, "first")` shifts others right |
| `addAll(int index, Collection<? extends E> c)` | Inserts all at index | No | |
| `get(int index)` | Returns element at index | No | `list.get(0)` |
| `set(int index, E element)` | Replaces element at index | No | `list.set(0, "new")` returns old value |
| `remove(int index)` | Removes element at index | Yes | Returns removed element; different from remove(Object) |
| `indexOf(Object o)` | Returns first index of element | No | `list.indexOf("item")` returns -1 if not found |
| `lastIndexOf(Object o)` | Returns last index of element | No | `list.lastIndexOf("item")` |
| `listIterator()` | Returns ListIterator | No | Can iterate forward/backward, modify during iteration |
| `listIterator(int index)` | Returns ListIterator starting at index | No | |
| `subList(int fromIndex, int toIndex)` | Returns sublist view (toIndex exclusive) | Yes | Returns view backed by original list; modifications affect original! |
| `replaceAll(UnaryOperator<E> operator)` | Replaces all elements (Java 8+) | No | `list.replaceAll(x -> x * 2)` |
| `sort(Comparator<? super E> c)` | Sorts list (Java 8+) | No | `list.sort((a, b) -> a.compareTo(b))` |
| `of(E... elements)` | Static factory (Java 9+) | Yes | `List.of(1, 2, 3)` creates immutable list |
| `copyOf(Collection<? extends E> coll)` | Immutable copy (Java 10+) | No | `List.copyOf(original)` |

---

### ArrayList

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `ArrayList()` | Default capacity 10 | No | `new ArrayList<>()` |
| `ArrayList(int initialCapacity)` | Specific initial capacity | Yes | `new ArrayList<>(50)` improves performance if size known |
| `ArrayList(Collection<? extends E> c)` | Creates from collection | No | `new ArrayList<>(anotherList)` |

#### Important Fields

| Field | Type | Description |
|-------|------|-------------|
| `size` (implicit) | int | Number of elements (access via size()) |
| `capacity` (implicit) | int | Underlying array capacity |

#### Important Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `ensureCapacity(int minCapacity)` | Ensures capacity for performance | Yes | `list.ensureCapacity(1000)` useful before adding many elements |
| `trimToSize()` | Reduces capacity to size | No | `list.trimToSize()` frees unused memory |
| `clone()` | Creates shallow copy | Yes | `ArrayList<String> copy = (ArrayList<String>) list.clone()` |

#### Performance Notes
- **Add:** O(1) amortized, O(n) worst case (if resize)
- **Remove:** O(n) (shifts elements)
- **Get:** O(1)
- **Search:** O(n)
- **Best for:** Random access, few insertions/deletions

---

### LinkedList

#### Constructors

| Constructor | Description | Example |
|-------------|-------------|---------|
| `LinkedList()` | Empty list | `new LinkedList<>()` |
| `LinkedList(Collection<? extends E> c)` | Creates from collection | `new LinkedList<>(anotherList)` |

#### Important Methods (beyond List)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `addFirst(E e)` | Adds element at beginning | No | `list.addFirst("first")` |
| `addLast(E e)` | Adds element at end | No | `list.addLast("last")` or `add()` |
| `removeFirst()` | Removes and returns first element | Yes | Throws NoSuchElementException if empty |
| `removeLast()` | Removes and returns last element | Yes | Throws NoSuchElementException if empty |
| `getFirst()` | Returns first element | Yes | Throws NoSuchElementException if empty |
| `getLast()` | Returns last element | Yes | Throws NoSuchElementException if empty |
| `pollFirst()` | Removes and returns first, or null | No | `LinkedList` implements Deque |
| `pollLast()` | Removes and returns last, or null | No | |
| `peekFirst()` | Returns first without removing, or null | No | |
| `peekLast()` | Returns last without removing, or null | No | |
| `pop()` | Pops from stack (removes first) | No | `list.pop()` equivalent to `removeFirst()` |
| `push(E e)` | Pushes to stack (adds first) | No | `list.push(x)` equivalent to `addFirst()` |

#### Performance Notes
- **Add/Remove at both ends:** O(1)
- **Add/Remove in middle:** O(n)
- **Get:** O(n)
- **Search:** O(n)
- **Best for:** Queue/Deque operations, frequent insertions/deletions at ends

---

### Vector (Legacy - Synchronized)

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `Vector()` | Default capacity 10 | No | `new Vector<>()` (rarely used) |
| `Vector(int initialCapacity)` | Specific capacity | No | |
| `Vector(int initialCapacity, int capacityIncrement)` | Capacity with increment | Yes | `capacityIncrement` controls growth rate |
| `Vector(Collection<? extends E> c)` | From collection | No | |

#### Important Methods

| Method | Description |
|--------|-------------|
| `addElement(E obj)` | Legacy add method |
| `removeElement(Object obj)` | Legacy remove method |
| `elementAt(int index)` | Legacy get method |
| `setElementAt(E obj, int index)` | Legacy set method |
| `firstElement()` | Legacy getFirst |
| `lastElement()` | Legacy getLast |
| `capacity()` | Returns current capacity |
| `ensureCapacity(int minCapacity)` | Ensures capacity |

**Note:** Vector is synchronized (thread-safe) but slower. Use ArrayList or CopyOnWriteArrayList instead.

---

### Stack (extends Vector)

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `Stack()` | Creates empty stack |

#### Important Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `push(E item)` | Pushes element onto stack | No | `stack.push(5)` |
| `pop()` | Pops and returns top element | Yes | Throws EmptyStackException if empty |
| `peek()` | Returns top element without removing | Yes | Throws EmptyStackException if empty |
| `empty()` | Checks if empty | No | `stack.empty()` |
| `search(Object o)` | Returns 1-based position from top | Yes | `stack.search(5)` returns position; -1 if not found |

**Note:** Extends Vector so synchronized. For modern stack use `Deque<T> stack = new ArrayDeque<>()`.

---

### CopyOnWriteArrayList (Thread-Safe)

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `CopyOnWriteArrayList()` | Empty list |
| `CopyOnWriteArrayList(Collection<? extends E> c)` | From collection |
| `CopyOnWriteArrayList(E[] toCopyIn)` | From array |

#### Key Characteristics

| Feature | Behavior | Tricky? |
|---------|----------|---------|
| Thread-safety | All operations are synchronized | No |
| Iteration | Safe; doesn't throw ConcurrentModificationException | Yes |
| Performance | Write-heavy operations slow (copies on write) | Yes |
| Use case | Read-heavy, multi-threaded scenarios | Yes |

#### Methods

- All List methods work same as ArrayList
- **Difference:** Safe iteration during concurrent modifications

---

## Set Interface & Implementations

### Set Interface Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `add(E e)` | Adds element if not present | Yes | Returns false if already present (Set contract) |
| `contains(Object o)` | Checks membership | No | Uses equals() and hashCode() |
| All Collection methods | See Collection interface | No | |
| `of(E... elements)` | Static factory (Java 9+) | Yes | `Set.of(1, 2, 3)` throws exception on duplicates |
| `copyOf(Collection<? extends E> coll)` | Immutable copy (Java 10+) | No | |

---

### HashSet

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `HashSet()` | Default capacity 16, load factor 0.75 | No | `new HashSet<>()` |
| `HashSet(int initialCapacity)` | Specific capacity | Yes | `new HashSet<>(100)` |
| `HashSet(int initialCapacity, float loadFactor)` | Capacity and load factor | Yes | Higher load factor = more collisions, less memory |
| `HashSet(Collection<? extends E> c)` | From collection | No | |

#### Important Fields (implicit)

| Aspect | Description |
|--------|-------------|
| Load Factor | Default 0.75; controls rehashing |
| Capacity | Doubles when load factor exceeded |
| Hash Function | Uses `hashCode()` and `equals()` |

#### Important Methods

| Method | Description |
|--------|-------------|
| All Set methods | Standard set operations |
| Iteration | Order is unpredictable |

#### Performance Notes
- **Add:** O(1) average, O(n) worst case (all hash collisions)
- **Remove:** O(1) average
- **Contains:** O(1) average
- **Iteration:** O(n + capacity)
- **Best for:** Checking membership, avoiding duplicates

#### Key Points
- **Not thread-safe:** Use `Collections.synchronizedSet()` or CopyOnWriteArraySet
- **Iterator:** Fails if set modified during iteration (ConcurrentModificationException)
- **Null:** Allows one null element

---

### LinkedHashSet

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `LinkedHashSet()` | Default capacity 16, load factor 0.75 |
| `LinkedHashSet(int initialCapacity)` | Specific capacity |
| `LinkedHashSet(int initialCapacity, float loadFactor)` | Capacity and load factor |
| `LinkedHashSet(Collection<? extends E> c)` | From collection |

#### Key Characteristics

| Feature | Behavior |
|---------|----------|
| Maintains insertion order | Yes (doubly-linked list) |
| Performance | Same as HashSet for operations |
| Iteration order | Insertion order |
| Memory | More than HashSet (maintains doubly-linked list) |

#### Performance Notes
- **Add:** O(1) average
- **Remove:** O(1) average
- **Iteration:** O(n) (always in insertion order)
- **Best for:** Need set behavior with insertion order preserved

---

### TreeSet

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `TreeSet()` | Uses natural ordering | No | Elements must implement Comparable |
| `TreeSet(Comparator<? super E> comparator)` | Uses custom comparator | No | `new TreeSet<>((a, b) -> b.compareTo(a))` for reverse order |
| `TreeSet(Collection<? extends E> c)` | From collection | No | |
| `TreeSet(SortedSet<E> s)` | From SortedSet | No | |

#### Important Methods (beyond Set)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `first()` | Returns smallest element | Yes | Throws NoSuchElementException if empty |
| `last()` | Returns largest element | Yes | Throws NoSuchElementException if empty |
| `pollFirst()` | Removes and returns smallest | No | `set.pollFirst()` returns null if empty |
| `pollLast()` | Removes and returns largest | No | |
| `lower(E e)` | Returns greatest element < e | Yes | `set.lower(5)` returns null if no such element |
| `floor(E e)` | Returns greatest element <= e | Yes | `set.floor(5)` returns null if no such element |
| `ceiling(E e)` | Returns least element >= e | Yes | `set.ceiling(5)` returns null if no such element |
| `higher(E e)` | Returns least element > e | Yes | `set.higher(5)` returns null if no such element |
| `headSet(E toElement)` | Returns set with elements < toElement | Yes | Returns view (modifications affect original); toElement exclusive for NavigableSet |
| `tailSet(E fromElement)` | Returns set with elements >= fromElement | Yes | Returns view; fromElement inclusive |
| `subSet(E fromElement, E toElement)` | Returns set [fromElement, toElement) | Yes | View; both bounds exclusive in NavigableSet variant |
| `headSet(E toElement, boolean inclusive)` | Controls inclusivity (Java 6+) | No | `set.headSet(5, true)` includes 5 |
| `tailSet(E fromElement, boolean inclusive)` | Controls inclusivity | No | |
| `subSet(E from, boolean fromInclusive, E to, boolean toInclusive)` | Controls both bounds | No | |
| `descendingSet()` | Returns reverse-order view | No | |
| `descendingIterator()` | Iterates in descending order | No | |
| `comparator()` | Returns comparator | No | `set.comparator()` returns null if natural order |

#### Performance Notes
- **Add:** O(log n)
- **Remove:** O(log n)
- **Contains:** O(log n)
- **Iteration:** O(n)
- **Best for:** Sorted set, range queries, finding min/max

#### Key Points
- **Red-Black Tree:** Maintains balance automatically
- **No null:** Throws NullPointerException
- **Iteration:** Always in sorted order

---

### CopyOnWriteArraySet (Thread-Safe)

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `CopyOnWriteArraySet()` | Empty set |
| `CopyOnWriteArraySet(Collection<? extends E> c)` | From collection |

#### Key Characteristics
- Backed by CopyOnWriteArrayList
- Safe iteration during concurrent modifications
- Write operations slow (copy on write)
- Best for read-heavy scenarios

---

### EnumSet

#### Creation Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `noneOf(Class<E> elementType)` | Empty set for enum type | No | `EnumSet.noneOf(Color.class)` |
| `allOf(Class<E> elementType)` | Set with all enum values | No | `EnumSet.allOf(Color.class)` |
| `of(E e)` | Set with single element | No | `EnumSet.of(Color.RED)` |
| `of(E e1, E e2, ...)` | Set with multiple elements (up to 5) | No | `EnumSet.of(RED, BLUE, GREEN)` |
| `of(E first, E... rest)` | Set with one or more elements | No | |
| `complementOf(EnumSet<E> s)` | Set with all except those in s | No | `EnumSet.complementOf(set)` |
| `range(E from, E to)` | Set with enum range | No | `EnumSet.range(Color.RED, Color.GREEN)` |
| `copyOf(EnumSet<E> s)` | Copy of another EnumSet | No | |
| `copyOf(Collection<E> c)` | Convert collection to EnumSet | No | |

#### Performance Notes
- **Internal Representation:** Bit vector (extremely fast)
- **Add/Remove/Contains:** O(1) constant time!
- **Memory:** Very compact (single or two longs)
- **Best for:** Set of enum values, flag operations

#### Key Points
- **No null:** Cannot add null
- **Thread-unsafe:** Not synchronized
- **Type-safe:** Compile-time type checking for enum

---

## Queue Interface & Implementations

### Queue Interface Methods

| Method (normal) | Method (exception) | Method (returns null/false) | Description | Tricky? |
|----------|----------|----------|----------|---------|
| `add(E e)` | | | Adds element | Yes |
| | `offer(E e)` | | Adds element (returns false if full) | Yes |
| `remove()` | | `poll()` | Removes head | Yes |
| `element()` | | `peek()` | Retrieves head | Yes |

#### Exceptions

| Method | Exception | Condition |
|--------|-----------|-----------|
| `remove()` | NoSuchElementException | If queue empty |
| `element()` | NoSuchElementException | If queue empty |
| `add(E e)` | IllegalStateException | If capacity exceeded |

---

### PriorityQueue

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `PriorityQueue()` | Default capacity 11, natural ordering | No | `new PriorityQueue<>()` |
| `PriorityQueue(int initialCapacity)` | Specific capacity | No | `new PriorityQueue<>(100)` |
| `PriorityQueue(Comparator<? super E> comparator)` | Custom comparator | No | `new PriorityQueue<>((a, b) -> b - a)` for max heap |
| `PriorityQueue(int initialCapacity, Comparator<? super E> comparator)` | Both | No | |
| `PriorityQueue(Collection<? extends E> c)` | From collection | No | |
| `PriorityQueue(PriorityQueue<? extends E> c)` | From PriorityQueue | No | |
| `PriorityQueue(SortedSet<? extends E> c)` | From SortedSet | No | |

#### Important Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `add(E e)` | Adds element | No | `pq.add(5)` |
| `offer(E e)` | Adds element | No | Always returns true |
| `poll()` | Removes and returns head | No | `pq.poll()` returns null if empty |
| `remove()` | Removes and returns head | Yes | Throws NoSuchElementException if empty |
| `peek()` | Returns head without removing | No | `pq.peek()` returns null if empty |
| `element()` | Returns head | Yes | Throws NoSuchElementException if empty |
| `comparator()` | Returns comparator | No | |

#### Performance Notes
- **Add:** O(log n)
- **Remove:** O(log n)
- **Peek:** O(1)
- **Poll/Remove:** O(log n)
- **Iteration:** O(n)
- **Best for:** Min/Max heap operations

#### Key Points
- **Min-heap by default:** Use custom comparator for max-heap
- **Not sorted:** Use peek() for min, don't iterate
- **No null:** Cannot add null
- **Common DSA patterns:**
  ```java
  // Max heap for integers
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
  
  // Min heap for custom objects
  PriorityQueue<Person> minHeap = new PriorityQueue<>(
    (p1, p2) -> Integer.compare(p1.age, p2.age)
  );

### Deque Interface

#### Deque Methods (both ends)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `addFirst(E e)` | Adds at beginning | No | `deque.addFirst(x)` |
| `addLast(E e)` | Adds at end | No | `deque.addLast(x)` |
| `removeFirst()` | Removes and returns first | Yes | Throws NoSuchElementException if empty |
| `removeLast()` | Removes and returns last | Yes | Throws NoSuchElementException if empty |
| `getFirst()` | Returns first | Yes | Throws NoSuchElementException if empty |
| `getLast()` | Returns last | Yes | Throws NoSuchElementException if empty |
| `pollFirst()` | Removes and returns first, or null | No | |
| `pollLast()` | Removes and returns last, or null | No | |
| `peekFirst()` | Returns first, or null | No | |
| `peekLast()` | Returns last, or null | No | |
| `push(E e)` | Pushes element (addFirst) | No | Stack-like |
| `pop()` | Pops element (removeFirst) | Yes | Throws if empty |
| `descendingIterator()` | Iterates in reverse | No | |

#### Stack vs Queue methods

| Purpose | Stack Method | Queue Method |
|---------|--------------|--------------|
| Add | `push()` | `offer()` / `add()` |
| Remove | `pop()` | `poll()` / `remove()` |
| Get | `peek()` | `peek()` / `element()` |

---

### ArrayDeque

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `ArrayDeque()` | Default capacity 16 | No | `new ArrayDeque<>()` |
| `ArrayDeque(int numElements)` | Specific capacity | Yes | `new ArrayDeque<>(100)` |
| `ArrayDeque(Collection<? extends E> c)` | From collection | No | |

#### Important Methods
- All Deque methods (see Deque interface)
- All Queue methods
- All List methods (though not List implementation)

#### Performance Notes
- **Add at either end:** O(1) amortized
- **Remove at either end:** O(1) amortized
- **Get at either end:** O(1)
- **Iteration:** O(n)
- **Best for:** Stack, Queue, Deque operations

#### Key Points
- **Preferred over Stack:** More efficient than Vector-based Stack
- **Preferred for Queue:** More efficient than LinkedList for queues
- **No null:** Cannot add null
- **Circular buffer:** Internally uses circular array

#### DSA Common Patterns
```java
// Stack
Deque<Integer> stack = new ArrayDeque<>();
stack.push(5);
stack.pop();

// Queue
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(5);
queue.poll();

// Deque (both ends)
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
```

---

## Map Interface & Implementations

### Map Interface Methods

#### Adding/Updating

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `put(K key, V value)` | Adds/updates entry | Yes | Returns old value or null; null if key didn't exist |
| `putAll(Map<? extends K, ? extends V> m)` | Adds all entries from another map | No | `map.putAll(anotherMap)` |
| `putIfAbsent(K key, V value)` | Puts only if key absent (Java 8+) | No | Returns previous value or null |
| `compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes value (Java 8+) | Yes | `map.compute("key", (k, v) -> v == null ? "default" : v + 1)` |
| `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes if key exists (Java 8+) | No | |
| `computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)` | Computes if key absent (Java 8+) | No | `map.computeIfAbsent("key", k -> new ArrayList<>())` |
| `merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)` | Merges values (Java 8+) | Yes | `map.merge("key", 1, Integer::sum)` |

#### Removing

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `remove(Object key)` | Removes entry | Yes | Returns value or null if key didn't exist |
| `remove(Object key, Object value)` | Removes if value matches (Java 8+) | Yes | `map.remove("key", "value")` returns boolean |
| `clear()` | Removes all entries | No | `map.clear()` |

#### Retrieval

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `get(Object key)` | Gets value by key | No | `map.get("key")` returns null if not found |
| `getOrDefault(Object key, V defaultValue)` | Gets value or default (Java 8+) | No | `map.getOrDefault("key", "default")` |
| `containsKey(Object key)` | Checks if key exists | No | Uses equals() and hashCode() |
| `containsValue(Object value)` | Checks if value exists | Yes | O(n) operation; slower than containsKey() |
| `keySet()` | Returns Set view of keys | Yes | Modifications affect original map; not thread-safe |
| `values()` | Returns Collection view of values | Yes | Modifications affect original map |
| `entrySet()` | Returns Set view of entries | Yes | Most efficient way to iterate |
| `size()` | Returns number of entries | No | |
| `isEmpty()` | Checks if empty | No | |

#### Functional Operations (Java 8+)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `forEach(BiConsumer<? super K, ? super V> action)` | Iterates all entries | No | `map.forEach((k, v) -> System.out.println(k + ":" + v))` |
| `replaceAll(BiFunction<? super K, ? super V, ? extends V> function)` | Replaces all values | No | `map.replaceAll((k, v) -> v + 1)` |
| `replace(K key, V value)` | Replaces value for key | No | Returns old value or null |
| `replace(K key, V oldValue, V newValue)` | Replaces if old value matches | No | Returns boolean |

#### Static Factories (Java 9+)

| Method | Description | Example |
|--------|-------------|---------|
| `Map.of(K k1, V v1, ...)` | Immutable map (up to 10 entries) | `Map.of("a", 1, "b", 2)` |
| `Map.ofEntries(Entry... entries)` | Immutable map from entries | `Map.ofEntries(Map.entry("a", 1))` |
| `Map.entry(K k, V v)` | Creates map entry | `Map.entry("key", "value")` |
| `Map.copyOf(Map<? extends K, ? extends V> map)` | Immutable copy (Java 10+) | `Map.copyOf(original)` |

---

### HashMap

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `HashMap()` | Default capacity 16, load factor 0.75 | No | `new HashMap<>()` |
| `HashMap(int initialCapacity)` | Specific capacity | Yes | `new HashMap<>(100)` |
| `HashMap(int initialCapacity, float loadFactor)` | Capacity and load factor | Yes | Higher load factor = more collisions, less memory |
| `HashMap(Map<? extends K, ? extends V> m)` | From another map | No | |

#### Important Fields (implicit)

| Aspect | Description | Tricky? |
|--------|-------------|---------|
| Load Factor | Default 0.75; controls when rehash occurs | Yes |
| Capacity | Doubles when size exceeds capacity × load factor | Yes |
| Threshold | capacity × loadFactor; rehash when exceeded | Yes |
| Collisions | Handled by chaining (linked lists) or tree (if > 8 elements) | Yes |

#### Important Methods

- All Map methods (see Map interface)
- `clone()` - Shallow copy

#### Performance Notes
- **Get:** O(1) average, O(n) worst case (all collisions)
- **Put:** O(1) average, O(n) worst case
- **Remove:** O(1) average
- **Iteration:** O(n + capacity)
- **Best for:** General-purpose key-value storage

#### Key Points
- **Null keys/values:** Allows one null key, multiple null values
- **Not synchronized:** Use Collections.synchronizedMap() or ConcurrentHashMap
- **Iteration order:** Unpredictable
- **Tree conversion:** Uses balanced trees when chain length > 8 (Java 8+)

---

### LinkedHashMap

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `LinkedHashMap()` | Default, insertion order | No | `new LinkedHashMap<>()` |
| `LinkedHashMap(int initialCapacity)` | Specific capacity | No | |
| `LinkedHashMap(int initialCapacity, float loadFactor)` | Both | No | |
| `LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)` | Access vs insertion order | Yes | `true` = LRU order (access-order); `false` = insertion-order |
| `LinkedHashMap(Map<? extends K, ? extends V> m)` | From map | No | |

#### Important Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `removeEldestEntry(Map.Entry<K,V> eldest)` | Override for LRU cache | Yes | Return `true` to remove oldest entry; called after each insertion |

#### Performance Notes
- **Get:** O(1) average (like HashMap)
- **Put:** O(1) average
- **Iteration:** O(n) in order
- **Memory:** More than HashMap (maintains doubly-linked list)
- **Best for:** Maintaining insertion/access order

#### Key Points
- **Insertion order:** Maintains by default (doubly-linked list)
- **Access order (LRU):** When `accessOrder = true`, records are reordered on access
- **Override removeEldestEntry():** Implement LRU cache pattern

#### LRU Cache Example
```java
LinkedHashMap<String, String> lruCache = 
    new LinkedHashMap<String, String>(16, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 100; // Keep max 100 entries
        }
    };
```

---

### TreeMap

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `TreeMap()` | Natural ordering | No | Keys must implement Comparable |
| `TreeMap(Comparator<? super K> comparator)` | Custom comparator | No | `new TreeMap<>((a, b) -> b.compareTo(a))` for reverse |
| `TreeMap(Map<? extends K, ? extends V> m)` | From map (natural order) | No | |
| `TreeMap(SortedMap<K, ? extends V> m)` | From SortedMap | No | |

#### Important Methods (beyond Map)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `firstKey()` | Returns smallest key | Yes | Throws NoSuchElementException if empty |
| `lastKey()` | Returns largest key | Yes | Throws NoSuchElementException if empty |
| `pollFirstEntry()` | Removes and returns smallest entry | No | `map.pollFirstEntry()` returns null if empty |
| `pollLastEntry()` | Removes and returns largest entry | No | |
| `firstEntry()` | Returns smallest entry | No | `map.firstEntry()` returns null if empty |
| `lastEntry()` | Returns largest entry | No | |
| `lowerKey(K key)` | Returns greatest key < key | Yes | Returns null if no such key |
| `floorKey(K key)` | Returns greatest key <= key | Yes | Returns null if no such key |
| `ceilingKey(K key)` | Returns least key >= key | Yes | Returns null if no such key |
| `higherKey(K key)` | Returns least key > key | Yes | Returns null if no such key |
| `lowerEntry(K key)` | Returns entry with greatest key < key | No | |
| `floorEntry(K key)` | Returns entry with greatest key <= key | No | |
| `ceilingEntry(K key)` | Returns entry with least key >= key | No | |
| `higherEntry(K key)` | Returns entry with least key > key | No | |
| `headMap(K toKey)` | Returns map with keys < toKey | Yes | View; toKey exclusive |
| `tailMap(K fromKey)` | Returns map with keys >= fromKey | Yes | View; fromKey inclusive |
| `subMap(K fromKey, K toKey)` | Returns map [fromKey, toKey) | Yes | View; fromKey inclusive, toKey exclusive |
| `headMap(K toKey, boolean inclusive)` | Controls inclusivity | No | Java 6+ variant |
| `tailMap(K fromKey, boolean inclusive)` | Controls inclusivity | No | |
| `subMap(K from, boolean fromInclusive, K to, boolean toInclusive)` | Controls both bounds | No | |
| `descendingMap()` | Returns reverse-order view | No | |
| `descendingKeySet()` | Returns reverse-order key set | No | |
| `navigableKeySet()` | Returns NavigableSet view of keys | No | |
| `comparator()` | Returns comparator | No | Null if natural order |

#### Performance Notes
- **Get:** O(log n)
- **Put:** O(log n)
- **Remove:** O(log n)
- **Iteration:** O(n) in sorted order
- **Range query:** O(log n + result size)
- **Best for:** Sorted map, range queries

#### Key Points
- **Red-Black Tree:** Maintains balance automatically
- **No null keys:** Throws NullPointerException
- **Null values:** Allowed
- **Common DSA patterns:**
  ```java
  // Reverse sorted map
  TreeMap<Integer, String> reversedMap = 
      new TreeMap<>((a, b) -> b.compareTo(a));
  
  // Range query
  Set<Integer> range = 
      sortedMap.subMap(10, 20).keySet();
  ```

---

### WeakHashMap

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `WeakHashMap()` | Default capacity 16 |
| `WeakHashMap(int initialCapacity)` | Specific capacity |
| `WeakHashMap(int initialCapacity, float loadFactor)` | Both |
| `WeakHashMap(Map<? extends K, ? extends V> m)` | From map |

#### Key Characteristics

| Feature | Behavior | Tricky? |
|---------|----------|---------|
| Key references | Weak (eligible for GC) | Yes |
| Garbage collection | Keys removed when GC'd | Yes |
| Use case | Caches, listeners | Yes |
| Performance | Same as HashMap but with GC overhead | No |

#### Key Points
- **Automatic cleanup:** Keys removed when only weakly referenced
- **Not for general use:** Use HashMap normally
- **Good for:** Caches where stale entries don't matter, listener maps

---

### IdentityHashMap

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `IdentityHashMap()` | Default capacity 32 |
| `IdentityHashMap(int expectedMaxSize)` | Specific size |
| `IdentityHashMap(Map<? extends K, ? extends V> m)` | From map |

#### Key Characteristics

| Feature | Behavior | Tricky? |
|---------|----------|---------|
| Key comparison | Uses == (identity) not equals() | Yes |
| Hash function | System.identityHashCode() | Yes |
| Use case | Rare; identity-based maps | Yes |
| Performance | Same as HashMap | No |

#### Key Points
- **Identity-based:** Uses reference equality (==) not value equality (equals())
- **Rarely used:** Only when you need identity comparison
- **Example:** Map where keys are specific object instances

---

### ConcurrentHashMap (Thread-Safe)

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `ConcurrentHashMap()` | Default capacity 16, default concurrency | No | `new ConcurrentHashMap<>()` |
| `ConcurrentHashMap(int initialCapacity)` | Specific capacity | No | |
| `ConcurrentHashMap(int initialCapacity, float loadFactor)` | Both | No | |
| `ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)` | All three (Java 8+ uses different defaults) | Yes | Higher concurrency level = more segments locked independently |
| `ConcurrentHashMap(Map<? extends K, ? extends V> m)` | From map | No | |

#### Important Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| All Map methods | Supported | No | Operations are atomic and thread-safe |
| `putIfAbsent(K key, V value)` | Puts only if absent | Yes | Returns old value or null |
| `remove(Object key, Object value)` | Removes if value matches | Yes | Returns boolean |
| `replace(K key, V oldValue, V newValue)` | Replaces if old value matches | Yes | Returns boolean |
| `replace(K key, V value)` | Replaces value | No | Returns old value or null |
| `forEach(BiConsumer<? super K, ? super V> action)` | Concurrent iteration (Java 8+) | Yes | See all entries as they were at iteration start |
| `reduce(BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer)` | Concurrent reduce (Java 8+) | No | |
| `reduceKeys(BiFunction<? super K, ? super K, ? extends K> reducer)` | Reduce keys only (Java 8+) | No | |

#### Performance Notes
- **Get:** O(1) average
- **Put:** O(1) average (with locking)
- **Iteration:** Safe; no ConcurrentModificationException
- **Locking:** Segment-based (multiple locks)
- **Best for:** High-concurrency scenarios

#### Key Points
- **Thread-safe:** Segment-based locking allows concurrent reads/writes to different segments
- **No null keys/values:** Unlike HashMap; throws NullPointerException
- **Safe iteration:** Doesn't throw ConcurrentModificationException
- **Preferred over:** Synchronized HashMap in multi-threaded scenarios

---

### EnumMap

#### Constructors

| Constructor | Description | Tricky? | Example |
|-------------|-------------|---------|---------|
| `EnumMap(Class<K> keyType)` | Empty map for enum type | No | `new EnumMap<>(Color.class)` |
| `EnumMap(EnumMap<K, ? extends V> m)` | Copy of another EnumMap | No | |
| `EnumMap(Map<K, ? extends V> m)` | Convert from map | Yes | `m` must have at least one element to determine enum class |

#### Performance Notes
- **Internal representation:** Array indexed by enum ordinal
- **Get:** O(1) constant!
- **Put:** O(1) constant!
- **Iteration:** O(n + enum constants)
- **Memory:** Very compact (array of enum size)
- **Best for:** Maps with enum keys

#### Key Points
- **No null keys:** Throws NullPointerException
- **Null values:** Allowed
- **Type-safe:** Compile-time type checking
- **Iteration:** In enum constant declaration order
- **Very fast:** Use whenever keys are enums

---

### Hashtable (Legacy - Synchronized)

#### Constructors

| Constructor | Description |
|-------------|-------------|
| `Hashtable()` | Default capacity 11 |
| `Hashtable(int initialCapacity)` | Specific capacity |
| `Hashtable(int initialCapacity, float loadFactor)` | Both |
| `Hashtable(Map<? extends K, ? extends V> t)` | From map |

#### Important Methods

| Method | Description |
|--------|-------------|
| `put(K key, V value)` | Adds entry (synchronized) |
| `get(Object key)` | Gets value (synchronized) |
| `remove(Object key)` | Removes entry (synchronized) |
| `keys()` | Legacy enumeration of keys |
| `elements()` | Legacy enumeration of values |

**Note:** Hashtable is synchronized (thread-safe) but **slower and legacy**. Use ConcurrentHashMap instead.

---

## Iterators & Other Utilities

### Iterator Interface

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `hasNext()` | Checks if more elements | No | `while(it.hasNext())` |
| `next()` | Returns next element | Yes | Throws NoSuchElementException if no more |
| `remove()` | Removes current element | Yes | Throws ConcurrentModificationException if collection modified outside iterator |
| `forEachRemaining(Consumer<? super E> action)` | Iterates remaining (Java 8+) | No | `it.forEachRemaining(System.out::println)` |

#### Key Points
- **ConcurrentModificationException:** If collection modified during iteration (except via remove())
- **Safe removal:** Use iterator.remove() instead of collection.remove()

---

### ListIterator Interface (extends Iterator)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `hasPrevious()` | Checks if previous element exists | No | |
| `previous()` | Returns previous element | Yes | Throws NoSuchElementException if none |
| `nextIndex()` | Returns next index | No | |
| `previousIndex()` | Returns previous index | No | |
| `set(E e)` | Replaces current element | Yes | Can only be called after next() or previous() |
| `add(E e)` | Inserts element | Yes | Inserts before next element; modifies list |

---

### Iterable Interface (Java 5+)

| Method | Description | Example |
|--------|-------------|---------|
| `iterator()` | Returns iterator | `for (String s : list)` calls this |
| `forEach(Consumer<? super T> action)` | Iterate with consumer (Java 8+) | `list.forEach(System.out::println)` |
| `spliterator()` | Returns Spliterator (Java 8+) | For parallel operations |

---

### Comparator Interface (Functional)

| Method | Description | Example |
|--------|-------------|---------|
| `compare(T o1, T o2)` | Compares two objects | Returns negative, 0, or positive |
| `reversed()` | Reverses order | `comp.reversed()` |
| `thenComparing(Comparator<? super T> other)` | Chains comparators | Multi-level sorting |

---

### Comparable Interface

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `compareTo(T o)` | Compares with another object | Yes | Returns negative, 0, or positive; must be consistent with equals() |

---

## Collection Selection Guide for DSA

### When to Use Which Collection

| Use Case | Recommendation | Why |
|----------|-----------------|-----|
| Random access, few modifications | ArrayList | O(1) get, O(n) add/remove |
| Frequent add/remove at ends | ArrayDeque | O(1) at both ends |
| Stack operations | ArrayDeque | More efficient than Stack class |
| Queue operations | ArrayDeque or LinkedList | O(1) offer/poll |
| Deque (both ends) | ArrayDeque | Circular buffer implementation |
| Checking membership | HashSet | O(1) contains |
| Unique elements + iteration order | LinkedHashSet | O(1) contains + insertion order |
| Sorted elements + range queries | TreeSet | O(log n) operations, sorted iteration |
| Min/Max heap | PriorityQueue | O(log n) add/remove, O(1) peek |
| General key-value storage | HashMap | O(1) get/put |
| Key-value + insertion order | LinkedHashMap | O(1) operations + order |
| Key-value + sorted keys | TreeMap | O(log n) operations, sorted iteration |
| Key-value + high concurrency | ConcurrentHashMap | Thread-safe, no synchronized overhead |
| Key-value with enum keys | EnumMap | O(1), most efficient for enums |
| Thread-safe list | CopyOnWriteArrayList | Safe iteration, frequent reads |
| Thread-safe set | CopyOnWriteArraySet | Safe iteration, frequent reads |
| Range queries, sorted map | TreeMap subMap() | O(log n) to get range |

---

## Quick DSA Patterns

### Stack
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(5);
int top = stack.pop();
```

### Queue
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(5);
int front = queue.poll();
```

### Min Heap
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5);
int min = minHeap.poll();
```

### Max Heap
```java
PriorityQueue<Integer> maxHeap = 
    new PriorityQueue<>((a, b) -> b - a);
maxHeap.offer(5);
int max = maxHeap.poll();
```

### Frequency Map
```java
Map<Character, Integer> freq = new HashMap<>();
freq.put('a', freq.getOrDefault('a', 0) + 1);
```

### LRU Cache
```java
LinkedHashMap<String, String> cache = 
    new LinkedHashMap<String, String>(16, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 100;
        }
    };
```

### Sorted Set with Custom Comparator
```java
Set<Person> sortedPeople = 
    new TreeSet<>((p1, p2) -> Integer.compare(p1.age, p2.age));
```

### Range Query
```java
NavigableMap<Integer, String> range = 
    treeMap.subMap(10, true, 20, true);
```

---

## Common Pitfalls & Solutions

| Pitfall | Problem | Solution |
|---------|---------|----------|
| Using ArrayList for stack | O(n) add/remove at beginning | Use ArrayDeque |
| Using LinkedList for queue | Slower than ArrayDeque | Use ArrayDeque |
| Modifying collection during iteration | ConcurrentModificationException | Use iterator.remove() or Stream |
| HashMap instead of LinkedHashMap for order | Lost insertion order | Use LinkedHashMap if order needed |
| Not specifying initial capacity | Frequent resizing | Specify capacity in constructor |
| Using null as key/value | NullPointerException in some maps | Avoid null in ConcurrentHashMap, TreeMap |
| Unaware of load factor | Poor performance due to collisions | Understand load factor trade-off |
| Using synchronized collections | Slower, limited granularity | Use Concurrent* classes instead |
| Iterator.remove() not called after last next() | IllegalStateException | Call next() before remove() |
| Forgetting about subList() backing | Modifications affect original | Be aware of view semantics |
| Comparing with compareTo() inconsistent | Violates contract | Ensure compareTo() consistent with equals() |
```

