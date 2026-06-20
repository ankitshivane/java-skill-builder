# Java Built-in Classes: Important Methods Reference

## Table of Contents
1. [String Class](#string-class)
2. [StringBuilder Class](#stringbuilder-class)
3. [Collection Interface](#collection-interface)
4. [Collections Class](#collections-class)
5. [Arrays Class](#arrays-class)

---

## String Class

### String Creation & Basics

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `String(char[] chars)` | Constructor to create string from char array | No | `new String(new char[]{'a','b','c'})` → `"abc"` |
| `String(char[] chars, int offset, int count)` | Creates string from char array with offset | Yes | `new String(new char[]{'a','b','c'}, 1, 2)` → `"bc"` |
| `String(byte[] bytes)` | Converts byte array to string using default charset | Yes | `new String(new byte[]{65,66,67})` → `"ABC"` |
| `String(String original)` | Copy constructor | No | `new String("hello")` → `"hello"` |

### String Length & Access

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `length()` | Returns the number of characters | No | `"hello".length()` → `5` |
| `charAt(int index)` | Returns character at specified index | No | `"hello".charAt(0)` → `'h'` |
| `codePointAt(int index)` | Returns Unicode code point at specified index | Yes | `"€".codePointAt(0)` → `8364` |
| `getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)` | Copies characters into destination array | Yes | `"hello".getChars(0, 2, dst, 0)` copies "he" to dst starting at index 0 |

### String Searching

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `indexOf(int ch)` | Returns index of first occurrence of character | No | `"hello".indexOf('l')` → `2` |
| `indexOf(String str)` | Returns index of first occurrence of substring | No | `"hello".indexOf("ll")` → `2` |
| `indexOf(int ch, int fromIndex)` | Searches from specified index | No | `"hello".indexOf('l', 3)` → `3` |
| `lastIndexOf(int ch)` | Returns index of last occurrence | No | `"hello".lastIndexOf('l')` → `3` |
| `lastIndexOf(String str, int fromIndex)` | Last occurrence searching backward from index | Yes | `"hello".lastIndexOf("l", 2)` → `2` |
| `contains(CharSequence s)` | Checks if string contains substring | No | `"hello".contains("ll")` → `true` |

### String Comparison

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `equals(Object obj)` | Case-sensitive comparison | No | `"hello".equals("hello")` → `true` |
| `equalsIgnoreCase(String anotherString)` | Case-insensitive comparison | No | `"HELLO".equalsIgnoreCase("hello")` → `true` |
| `compareTo(String anotherString)` | Lexicographic comparison (returns int) | Yes | `"abc".compareTo("abc")` → `0`, `"a".compareTo("b")` → negative, `"b".compareTo("a")` → positive |
| `compareToIgnoreCase(String str)` | Case-insensitive lexicographic comparison | No | `"ABC".compareToIgnoreCase("abc")` → `0` |
| `startsWith(String prefix)` | Checks if string starts with prefix | No | `"hello".startsWith("hel")` → `true` |
| `startsWith(String prefix, int offset)` | Checks from specified offset | Yes | `"hello".startsWith("ll", 2)` → `true` |
| `endsWith(String suffix)` | Checks if string ends with suffix | No | `"hello".endsWith("lo")` → `true` |

### String Extraction & Manipulation

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `substring(int beginIndex)` | Returns substring from index to end | No | `"hello".substring(1)` → `"ello"` |
| `substring(int beginIndex, int endIndex)` | Returns substring (endIndex exclusive) | Yes | `"hello".substring(1, 4)` → `"ell"` (index 4 is exclusive!) |
| `subSequence(int beginIndex, int endIndex)` | Returns CharSequence (similar to substring) | Yes | Returns CharSequence, not String; `"hello".subSequence(0, 3)` → `"hel"` |
| `concat(String str)` | Concatenates strings | No | `"hello".concat(" world")` → `"hello world"` |
| `split(String regex)` | Splits string by regex pattern | Yes | `"a,b,c".split(",")` → `["a", "b", "c"]`; `"a.b".split("\\.")` → `["a", "b"]` (need to escape special chars!) |
| `split(String regex, int limit)` | Splits with limit on parts | Yes | `"a,b,c,d".split(",", 2)` → `["a", "b,c,d"]` (limit includes remainder) |

### String Replacement

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `replace(char oldChar, char newChar)` | Replaces all occurrences of character | No | `"hello".replace('l', 'x')` → `"hexxo"` |
| `replace(CharSequence target, CharSequence replacement)` | Replaces all occurrences of substring | No | `"hello".replace("ll", "XX")` → `"heXXo"` |
| `replaceAll(String regex, String replacement)` | Replaces all matches of regex | Yes | `"hello123".replaceAll("[0-9]", "X")` → `"helloXXX"`; first arg is regex, not literal! |
| `replaceFirst(String regex, String replacement)` | Replaces first match of regex | Yes | `"hello123".replaceFirst("[0-9]", "X")` → `"helloX23"` |

### String Case & Trimming

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `toUpperCase()` | Converts to uppercase | No | `"hello".toUpperCase()` → `"HELLO"` |
| `toUpperCase(Locale locale)` | Converts to uppercase for specific locale | Yes | Locale matters for some languages |
| `toLowerCase()` | Converts to lowercase | No | `"HELLO".toLowerCase()` → `"hello"` |
| `toLowerCase(Locale locale)` | Converts to lowercase for specific locale | Yes | Locale matters for some languages |
| `trim()` | Removes leading and trailing whitespace | Yes | `" hello ".trim()` → `"hello"`; only removes ASCII whitespace, not Unicode spaces! |
| `strip()` | Removes leading/trailing whitespace (Java 11+) | Yes | `" hello ".strip()` → `"hello"`; removes Unicode whitespace unlike `trim()` |
| `stripLeading()` | Removes leading whitespace (Java 11+) | No | `" hello ".stripLeading()` → `"hello "` |
| `stripTrailing()` | Removes trailing whitespace (Java 11+) | No | `" hello ".stripTrailing()` → `" hello"` |

### String Formatting & Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `valueOf(Object obj)` | Static method: converts object to string | No | `String.valueOf(123)` → `"123"`, `String.valueOf(true)` → `"true"` |
| `valueOf(char[] data)` | Static method: converts char array to string | No | `String.valueOf(new char[]{'a','b'})` → `"ab"` |
| `valueOf(char[] data, int offset, int count)` | Static method: converts part of char array | Yes | `String.valueOf(new char[]{'a','b','c'}, 1, 2)` → `"bc"` |
| `format(String format, Object... args)` | Static method: formatted string (like printf) | Yes | `String.format("%d + %d = %d", 1, 2, 3)` → `"1 + 2 = 3"` |
| `join(CharSequence delimiter, CharSequence... elements)` | Static method: joins strings with delimiter | No | `String.join(",", "a", "b", "c")` → `"a,b,c"` |
| `join(CharSequence delimiter, Iterable elements)` | Static method: joins iterable elements | No | `String.join("-", Arrays.asList("x","y","z"))` → `"x-y-z"` |

### String Character Checks

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `isEmpty()` | Checks if length is 0 | No | `"".isEmpty()` → `true` |
| `isBlank()` | Checks if empty or only whitespace (Java 11+) | Yes | `"   ".isBlank()` → `true`, `" a ".isBlank()` → `false` |
| `matches(String regex)` | Checks if entire string matches regex | Yes | `"123".matches("[0-9]+")` → `true`, must match entire string! |

### String Conversion to Primitives

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `toCharArray()` | Converts string to char array | No | `"hello".toCharArray()` → `['h','e','l','l','o']` |
| `getBytes()` | Converts string to byte array (default charset) | No | `"hello".getBytes()` → `byte[]` |
| `getBytes(String charsetName)` | Converts string to byte array with specific charset | Yes | `"hello".getBytes("UTF-8")` → `byte[]` |
| `getBytes(Charset charset)` | Converts string to byte array | No | `"hello".getBytes(StandardCharsets.UTF_8)` → `byte[]` |

### String Repeated & Indentation (Java 11+)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `repeat(int count)` | Repeats string count times | No | `"ab".repeat(3)` → `"ababab"` |
| `indent(int n)` | Adds indentation (positive adds, negative removes) | Yes | `"line".indent(2)` → `"  line"` (adds 2 spaces and newline) |
| `translateEscapes()` | Translates escape sequences (Java 15+) | Yes | `"Hello\\nWorld".translateEscapes()` → `"Hello\nWorld"` (processes escape sequences) |

---

## StringBuilder Class

### StringBuilder Creation & Capacity

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `StringBuilder()` | Default constructor with initial capacity 16 | No | `new StringBuilder()` |
| `StringBuilder(int capacity)` | Constructor with specified capacity | Yes | `new StringBuilder(50)` improves performance if you know size |
| `StringBuilder(String str)` | Constructor initialized with string | No | `new StringBuilder("hello")` → capacity will be length + 16 |
| `StringBuilder(CharSequence seq)` | Constructor initialized with CharSequence | No | `new StringBuilder("hello")` |
| `capacity()` | Returns current capacity | Yes | `new StringBuilder().capacity()` → `16`, not same as length! |
| `ensureCapacity(int minimumCapacity)` | Ensures capacity is at least the specified value | Yes | Useful for performance when appending many times |

### StringBuilder Modification

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `append(Object obj)` | Appends string representation of object | No | `sb.append(123)` appends "123" |
| `append(String str)` | Appends string | No | `sb.append("hello")` |
| `append(char[] str)` | Appends char array | No | `sb.append(new char[]{'a','b'})` |
| `append(char[] str, int offset, int len)` | Appends part of char array | Yes | `sb.append(new char[]{'a','b','c'}, 1, 2)` appends "bc" |
| `append(CharSequence s)` | Appends CharSequence | No | `sb.append("test")` |
| `append(CharSequence s, int start, int end)` | Appends part of CharSequence | Yes | `sb.append("hello", 1, 4)` appends "ell" |
| `append(int i)` / `append(long l)` / `append(float f)` / `append(double d)` | Appends primitive value | No | `sb.append(42)` |
| `append(boolean b)` | Appends boolean as "true" or "false" | No | `sb.append(true)` |

### StringBuilder Insertion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `insert(int offset, Object obj)` | Inserts string representation at offset | No | `sb.insert(0, "start")` |
| `insert(int offset, String str)` | Inserts string at offset | No | `new StringBuilder("hello").insert(1, "XX")` → `"hXXello"` |
| `insert(int offset, char[] str)` | Inserts char array at offset | No | `sb.insert(2, new char[]{'x','y'})` |
| `insert(int offset, CharSequence s)` | Inserts CharSequence at offset | No | `sb.insert(1, "test")` |
| `insert(int offset, int i)` / primitives | Inserts primitive value at offset | No | `sb.insert(0, 99)` |

### StringBuilder Deletion & Replacement

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `delete(int start, int end)` | Deletes from start (inclusive) to end (exclusive) | Yes | `new StringBuilder("hello").delete(1, 3)` → `"hlo"` (removes indices 1,2) |
| `deleteCharAt(int index)` | Deletes character at index | No | `new StringBuilder("hello").deleteCharAt(1)` → `"hllo"` |
| `replace(int start, int end, String str)` | Replaces from start to end with string | Yes | `new StringBuilder("hello").replace(1, 3, "XX")` → `"hXXlo"` |
| `setCharAt(int index, char ch)` | Sets character at index | No | `sb.setCharAt(0, 'H')` |
| `setLength(int newLength)` | Sets new length (truncates or pads with null) | Yes | `sb.setLength(5)` truncates to 5; `sb.setLength(10)` pads with null chars |

### StringBuilder Reversal & Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `reverse()` | Reverses the string | No | `new StringBuilder("hello").reverse()` → `"olleh"` |
| `substring(int start)` | Returns substring from start to end | No | `sb.substring(1)` |
| `substring(int start, int end)` | Returns substring (end exclusive) | No | `sb.substring(1, 3)` → indices 1,2 only |
| `toString()` | Converts to String | No | `sb.toString()` |
| `length()` | Returns number of characters | No | `sb.length()` |
| `charAt(int index)` | Returns character at index | No | `sb.charAt(0)` |
| `getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)` | Copies characters to array | No | Similar to String version |
| `codePointAt(int index)` | Returns Unicode code point | No | `sb.codePointAt(0)` |
| `codePointBefore(int index)` | Returns code point before index | No | `sb.codePointBefore(1)` |

### StringBuilder Performance Tips

- StringBuilder is mutable (unlike String which is immutable)
- When appending in loops, StringBuilder is much more efficient than String concatenation
- Use capacity constructor if you know approximate size
- append() returns `this` for method chaining: `sb.append("a").append("b").append("c")`

---

## Collection Interface

### Core Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `add(E e)` | Adds element to collection | Yes | Returns boolean; may be false if duplicate set and set rejects duplicates |
| `addAll(Collection<? extends E> c)` | Adds all elements from another collection | No | `list.addAll(anotherList)` |
| `remove(Object o)` | Removes first occurrence of element | Yes | `list.remove("item")` removes by value; `list.remove(0)` in List removes by index! |
| `removeAll(Collection<?> c)` | Removes all elements that are in specified collection | No | `list.removeAll(toRemove)` |
| `retainAll(Collection<?> c)` | Keeps only elements that are in specified collection | Yes | `list.retainAll(toKeep)` removes everything not in toKeep |
| `clear()` | Removes all elements | No | `list.clear()` |
| `contains(Object o)` | Checks if collection contains element | No | `list.contains("item")` |
| `containsAll(Collection<?> c)` | Checks if collection contains all elements from another | No | `list.containsAll(anotherList)` |
| `isEmpty()` | Checks if collection is empty | No | `list.isEmpty()` |
| `size()` | Returns number of elements | No | `list.size()` |
| `iterator()` | Returns iterator for the collection | No | `Iterator<String> it = list.iterator()` |
| `toArray()` | Converts to Object array | Yes | Returns Object[], not generic type; `Object[] arr = list.toArray()` |
| `toArray(T[] a)` | Converts to specified array type | Yes | `String[] arr = list.toArray(new String[0])` creates proper type array |
| `stream()` | Returns Stream (Java 8+) | No | `list.stream().filter(...)` |
| `parallelStream()` | Returns parallel Stream (Java 8+) | Yes | Use for large collections; order not guaranteed for some operations |
| `equals(Object o)` | Compares collections for equality | Yes | For List: order matters; for Set: order doesn't matter; for Map: keys+values must match |
| `hashCode()` | Returns hash code | No | Consistent with equals() |

---

## Collections Class

### Sorting

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `sort(List<T> list)` | Sorts list in natural order | No | `Collections.sort(list)` (elements must implement Comparable) |
| `sort(List<T> list, Comparator<? super T> c)` | Sorts list by comparator | No | `Collections.sort(list, (a, b) -> b.compareTo(a))` for reverse |
| `reverse(List<?> list)` | Reverses list in place | No | `Collections.reverse(list)` modifies original |
| `shuffle(List<?> list)` | Randomly shuffles list | Yes | Uses random seed; different each time unless you provide Random |
| `shuffle(List<?> list, Random rnd)` | Shuffles with specific Random | Yes | `Collections.shuffle(list, new Random(42))` for reproducible shuffle |

### Searching & Min/Max

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `binarySearch(List<? extends Comparable<? super T>> list, T key)` | Binary search in sorted list | Yes | Returns index if found; returns `-(insertion_point + 1)` if not found! |
| `binarySearch(List<? extends T> list, T key, Comparator<? super T> c)` | Binary search with comparator | Yes | List must be sorted according to comparator |
| `min(Collection<? extends T> coll)` | Returns minimum element | No | `Collections.min(list)` |
| `min(Collection<? extends T> coll, Comparator<? super T> comp)` | Returns minimum by comparator | No | `Collections.min(list, comp)` |
| `max(Collection<? extends T> coll)` | Returns maximum element | No | `Collections.max(list)` |
| `max(Collection<? extends T> coll, Comparator<? super T> comp)` | Returns maximum by comparator | No | `Collections.max(list, comp)` |

### Frequency & Rotation

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `frequency(Collection<?> c, Object o)` | Returns count of occurrences | No | `Collections.frequency(list, "item")` |
| `rotate(List<?> list, int distance)` | Rotates list elements by distance | Yes | `Collections.rotate(list, 2)` rotates right; negative rotates left; `rotate([1,2,3,4], 1)` → `[4,1,2,3]` |
| `swap(List<?> list, int i, int j)` | Swaps elements at indices i and j | No | `Collections.swap(list, 0, list.size()-1)` |

### Immutable Collections

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `unmodifiableCollection(Collection<? extends T> c)` | Returns unmodifiable view | Yes | Throws UnsupportedOperationException on modification; backed by original |
| `unmodifiableList(List<? extends T> list)` | Returns unmodifiable List view | Yes | `Collections.unmodifiableList(list)` |
| `unmodifiableSet(Set<? extends T> s)` | Returns unmodifiable Set view | No | `Collections.unmodifiableSet(set)` |
| `unmodifiableMap(Map<? extends K, ? extends V> m)` | Returns unmodifiable Map view | No | `Collections.unmodifiableMap(map)` |
| `emptyList()` | Returns immutable empty list | No | `Collections.emptyList()` |
| `emptySet()` | Returns immutable empty set | No | `Collections.emptySet()` |
| `emptyMap()` | Returns immutable empty map | No | `Collections.emptyMap()` |
| `singletonList(T o)` | Returns immutable list with single element | No | `Collections.singletonList("item")` |
| `singletonSet(T o)` | Returns immutable set with single element | No | `Collections.singletonSet("item")` |
| `singletonMap(K key, V value)` | Returns immutable map with single entry | No | `Collections.singletonMap("key", "value")` |

### Synchronized Collections

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `synchronizedCollection(Collection<T> c)` | Returns synchronized Collection | Yes | Thread-safe but slower; still need external synchronization for iteration |
| `synchronizedList(List<T> list)` | Returns synchronized List | Yes | `Collections.synchronizedList(new ArrayList<>())` |
| `synchronizedSet(Set<T> s)` | Returns synchronized Set | No | `Collections.synchronizedSet(new HashSet<>())` |
| `synchronizedMap(Map<K, V> m)` | Returns synchronized Map | No | `Collections.synchronizedMap(new HashMap<>())` |

### Fill & Copy

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `fill(List<? super T> list, T obj)` | Fills list with specified element | No | `Collections.fill(list, "value")` replaces all elements |
| `copy(List<? super T> dest, List<? extends T> src)` | Copies source list to destination | Yes | Destination must be >= size of source; overwrites destination |
| `nCopies(int n, T o)` | Returns immutable list with n copies of element | No | `Collections.nCopies(5, "x")` → `["x","x","x","x","x"]` |

### Disjoint & Indexing

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `disjoint(Collection<?> c1, Collection<?> c2)` | Returns true if collections have no common elements | No | `Collections.disjoint(list1, list2)` |
| `indexOfSubList(List<?> source, List<?> target)` | Finds first index of sublist | Yes | `Collections.indexOfSubList([1,2,3,4], [2,3])` → `1` |
| `lastIndexOfSubList(List<?> source, List<?> target)` | Finds last index of sublist | No | `Collections.lastIndexOfSubList([1,2,1,2], [1,2])` → `2` |
| `replaceAll(List<T> list, T oldVal, T newVal)` | Replaces all occurrences in list | No | `Collections.replaceAll(list, "old", "new")` |

---

## Arrays Class

### Sorting

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `sort(int[] a)` | Sorts int array in place | No | `Arrays.sort(arr)` modifies original |
| `sort(int[] a, int fromIndex, int toIndex)` | Sorts range (toIndex exclusive) | Yes | `Arrays.sort(arr, 1, 3)` sorts indices 1,2 only |
| `sort(Object[] a)` | Sorts Object array by natural order | No | Elements must implement Comparable |
| `sort(Object[] a, int fromIndex, int toIndex)` | Sorts Object range | No | `Arrays.sort(arr, 0, arr.length)` |
| `sort(T[] a, Comparator<? super T> c)` | Sorts with custom comparator | No | `Arrays.sort(people, (a, b) -> a.age - b.age)` |
| `sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)` | Sorts range with comparator | No | Sorts specified range only |
| `parallelSort(int[] a)` | Sorts using parallel processing | Yes | Faster for large arrays; results same as sort() |
| `parallelSort(Object[] a, Comparator<? super T> c)` | Parallel sort with comparator | Yes | Use for large datasets |

### Searching

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `binarySearch(int[] a, int key)` | Binary search in sorted array | Yes | Returns index if found; `-(insertion_point + 1)` if not found; array MUST be sorted! |
| `binarySearch(Object[] a, Object key)` | Binary search in sorted Object array | No | Array must be sorted by natural order |
| `binarySearch(T[] a, T key, Comparator<? super T> c)` | Binary search with comparator | Yes | Array must be sorted according to comparator |
| `binarySearch(int[] a, int fromIndex, int toIndex, int key)` | Binary search in range | Yes | `Arrays.binarySearch(arr, 1, 5, key)` searches indices 1-4 |

### Conversion & Copying

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `copyOf(int[] original, int newLength)` | Copies array with new length | Yes | If newLength > original.length, pads with 0; if < truncates |
| `copyOf(Object[] original, int newLength)` | Copies Object array | Yes | If longer, pads with null; if shorter, truncates |
| `copyOfRange(int[] original, int from, int to)` | Copies range (to exclusive) | Yes | `Arrays.copyOfRange(arr, 2, 5)` copies indices 2,3,4 |
| `copyOfRange(Object[] original, int from, int to)` | Copies range of Object array | No | |
| `fill(int[] a, int val)` | Fills entire array with value | No | `Arrays.fill(arr, 0)` |
| `fill(int[] a, int fromIndex, int toIndex, int val)` | Fills range with value (toIndex exclusive) | No | `Arrays.fill(arr, 1, 3, 0)` fills indices 1,2 |
| `fill(Object[] a, Object val)` | Fills Object array with value | No | `Arrays.fill(arr, "default")` |

### Comparison

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `equals(int[] a, int[] a2)` | Checks if arrays are equal | No | `Arrays.equals(arr1, arr2)` element-wise comparison |
| `equals(Object[] a, Object[] a2)` | Checks if Object arrays are equal | Yes | Uses .equals() on elements; `[null]` equals `[null]` → true |
| `deepEquals(Object[] a1, Object[] a2)` | Deep equality for multidimensional arrays | Yes | `Arrays.deepEquals(array2D1, array2D2)` compares nested arrays |
| `mismatch(int[] a, int[] b)` | Returns index of first mismatch | Yes | Returns -1 if arrays equal; first differing index otherwise |
| `mismatch(Object[] a, Object[] b)` | Returns index of first mismatch in Object arrays | No | Java 9+ |

### String Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `toString(int[] a)` | Converts array to string representation | No | `Arrays.toString(new int[]{1,2,3})` → `"[1, 2, 3]"` |
| `toString(Object[] a)` | Converts Object array to string | No | `Arrays.toString(arr)` |
| `deepToString(Object[] a)` | Deep string for multidimensional arrays | Yes | `Arrays.deepToString(array2D)` → `"[[1, 2], [3, 4]]"` |

### Streaming (Java 8+)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `stream(int[] array)` | Returns IntStream from array | No | `Arrays.stream(arr).filter(x -> x > 5).forEach(System.out::println)` |
| `stream(Object[] array)` | Returns Stream from Object array | No | `Arrays.stream(arr)` |
| `stream(int[] array, int fromIndex, int toIndex)` | Creates stream from range | No | `Arrays.stream(arr, 1, 3)` for indices 1,2 |

### Hashing

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `hashCode(int[] a)` | Returns hash code for array | No | `Arrays.hashCode(arr)` |
| `hashCode(Object[] a)` | Returns hash code for Object array | No | `Arrays.hashCode(arr)` |
| `deepHashCode(Object[] a)` | Deep hash for multidimensional arrays | No | `Arrays.deepHashCode(array2D)` |

### List Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `asList(T... a)` | Converts array to List | Yes | `Arrays.asList(1, 2, 3)` → mutable List backed by array; modifications affect original array! |
| | | Yes | Cannot add/remove elements (throws UnsupportedOperationException) but can modify elements |

---

## Summary: Quick Tips

### String vs StringBuilder
- Use **String** for fixed or rarely modified strings
- Use **StringBuilder** for frequently modified strings (especially in loops)
- Both can be converted easily: `str.toString()` or `new StringBuilder(str)`

### Collections Common Pitfalls
- `remove()` on Collection: removes by value; on List: can be by index (dangerous!)
- `toArray()` returns Object[], use `toArray(T[])` for proper typing
- Unmodifiable collections throw UnsupportedOperationException on modification
- Iterating concurrent collection can throw ConcurrentModificationException

### Arrays Common Pitfalls
- `binarySearch()` requires SORTED array; returns negative if not found
- `sort()` modifies original array in place
- `copyOfRange()` and `fill()` use exclusive end index
- `asList()` is backed by array; modifications affect original

### Tricky Methods to Memorize
1. **String.substring()** - end index is EXCLUSIVE
2. **String.split()** - takes REGEX, not literal string (escape special chars!)
3. **Collections.binarySearch()** - returns `-(insertion_point + 1)` if not found
4. **Arrays.copyOf()** - pads/truncates to exact new length
5. **Collections.rotate()** - positive = rotate right, negative = rotate left
6. **String.trim()** - only removes ASCII whitespace, use `strip()` in Java 11+