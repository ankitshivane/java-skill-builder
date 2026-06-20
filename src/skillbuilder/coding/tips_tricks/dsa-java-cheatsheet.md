# DSA Java Cheat Sheet

A quick-reference of bit tricks, math shortcuts, and built-in Java methods (`String`, `Character`, `Math`, `Collections`) that come up repeatedly while solving DSA problems.

## Table of Contents

- [Bit Manipulation](#bit-manipulation)
- [Math Tricks](#math-tricks)
- [String & StringBuilder](#string--stringbuilder)
- [Character Class](#character-class)
- [Collections & Arrays](#collections--arrays)
- [One-Liner Patterns](#one-liner-patterns)

---

## Bit Manipulation

**Check if even/odd**
```java
(n & 1) == 0  // even
(n & 1) == 1  // odd
```
> Faster than `n % 2`

**Check if power of 2**
```java
(n > 0) && (n & (n - 1)) == 0
```
> Power of 2 has exactly one bit set

**Check i-th bit**
```java
(n & (1 << i)) != 0
```

**Get i-th bit**
```java
(n >> i) & 1
```
> Returns 0 or 1

**Set i-th bit**
```java
n | (1 << i)
```
> Forces bit i to 1

**Clear i-th bit**
```java
n & ~(1 << i)
```
> Forces bit i to 0

**Toggle i-th bit**
```java
n ^ (1 << i)
```
> Flip bit i

**Remove lowest set bit**
```java
n & (n - 1)
```
> Used to count set bits (Brian Kernighan)

**Get lowest set bit**
```java
n & (-n)
```
> Isolates rightmost 1-bit (used in Fenwick tree)

**Count set bits**
```java
Integer.bitCount(n)
```
> Built-in, O(1)

**XOR trick — find missing/unique**
```java
// All elements XOR'd: duplicates cancel
int res = 0;
for (int x : arr) res ^= x;
```
> a ^ a = 0, a ^ 0 = a
- Used in:
  - Find single number (one unique)
  - Find two unique numbers (XOR all, then separate by rightmost set bit)
  - Find missing number in 1..n (XOR all indices and values)
  - Check if two numbers are the same (XOR == 0)
  - swap two numbers without temp (XOR swap)

**Swap without temp**
```java
a ^= b; b ^= a; a ^= b;
```
> Classic XOR swap

**Multiply / Divide by 2**
```java
n << 1  // n * 2
n >> 1  // n / 2
```
> Signed right shift

**Unsigned right shift**
```java
n >>> 1
```
> Use for mid in binary search to avoid overflow

**Check if two numbers have opposite signs**
```java
(a ^ b) < 0
```
> MSB (sign bit) will be 1 if signs differ

---

## Math Tricks


**Sum of squares**
```java
n *(n+1)*(2*n+1)/6
```

**Safe mid in binary search**
```java
int mid = left + (right - left) / 2;
// or
int mid = (left + right) >>> 1;
```
> Avoids integer overflow

**GCD (Euclidean)**
```java
int gcd(int a, int b) {
  return b == 0 ? a : gcd(b, a % b);
}
```
> LCM = (a * b) / gcd(a, b)

**Check prime**
```java
boolean isPrime(int n) {
  if (n < 2) return false;
  for (int i = 2; i * i <= n; i++)
    if (n % i == 0) return false;
  return true;
}
```
> O(√n) — check up to sqrt only

**Fast power (modular exponentiation)**
```java
long pow(long base, long exp, long mod) {
  long res = 1;
  base %= mod;
  while (exp > 0) {
    if ((exp & 1) == 1) res = res * base % mod;
    base = base * base % mod;
    exp >>= 1;
  }
  return res;
}
```
> O(log n) — essential for large exponents

**Sum of 1 to N**
```java
long sum = (long) n * (n + 1) / 2;
```
> Cast to long to avoid overflow

**Ceil division without float**
```java
int ceil = (a + b - 1) / b;
// or
int ceil = (a - 1) / b + 1;
```
> For positive integers only

**Absolute value**
```java
Math.abs(n)
```
> Watch out: `Math.abs(Integer.MIN_VALUE)` returns negative!

**Min / Max of two values**
```java
Math.min(a, b)
Math.max(a, b)
```
> Also works with long, float, double

**Log base 2 (floor)**
```java
int log2 = 31 - Integer.numberOfLeadingZeros(n);
```
> Or: `(int)(Math.log(n) / Math.log(2))`

**Digit count of a number**
```java
int digits = (int) Math.log10(n) + 1;
```
> For n > 0

**Modulo handling (negative numbers)**
```java
int mod = ((n % m) + m) % m;
```
> Java `%` can return negative for negative n

**Integer overflow guard**
```java
// Use long when multiplying large ints
long res = (long) a * b;
```
> Cast before multiplication, not after

**Modulo tricks**
```java
(a+b) % mod
(a*b) % mod
(a-b+mod) % mod // avoid negative
(a/b) % mod // only if b has modular inverse
```
---

## String & StringBuilder

**char at index**
```java
s.charAt(i)
```

**Substring**
```java
s.substring(start, end) // end exclusive
```
> `s.substring(start)` → from start to end

**String to char array**
```java
char[] arr = s.toCharArray();
```
> Useful for in-place manipulation

**char array to String**
```java
String s = new String(arr);
// or
String s = String.valueOf(arr);
```

**Split string**
```java
String[] parts = s.split(",");
String[] words = s.split("\\s+"); // by whitespace
```
> Regex-based — use carefully

**Trim whitespace**
```java
s.trim()       // trims spaces
s.strip()      // trims Unicode whitespace (Java 11+)
```

**Check prefix / suffix**
```java
s.startsWith("abc")
s.endsWith("xyz")
```

**Contains / indexOf**
```java
s.contains("ab")
s.indexOf("ab")     // -1 if not found
s.lastIndexOf("ab")
```

**Replace**
```java
s.replace("a", "b")        // literal
s.replaceAll("[aeiou]", "") // regex
```
> `replace()` also accepts char

**Compare strings**
```java
s1.equals(s2)
s1.equalsIgnoreCase(s2)
s1.compareTo(s2) // 0 if equal
```
> Never use `==` for string comparison

**Convert int ↔ String**
```java
String s = String.valueOf(42);
String s = Integer.toString(42);
int n = Integer.parseInt("42");
```

**Reverse a string**
```java
String rev = new StringBuilder(s).reverse().toString();
```

**StringBuilder — append / delete / insert**
```java
StringBuilder sb = new StringBuilder();
sb.append("hi");
sb.insert(0, "!");
sb.delete(1, 3);
sb.deleteCharAt(0);
sb.reverse();
sb.toString();
```
> Always prefer StringBuilder in loops over `+=`

**Join strings**
```java
String.join("-", "a", "b", "c") // "a-b-c"
String.join(", ", list)         // from List<String>
```

**Repeat a string (Java 11+)**
```java
"ab".repeat(3) // "ababab"
```

**Count occurrences of char**
```java
long count = s.chars().filter(c -> c == 'a').count();
```

---

## Character Class

**Check digit / letter / alphanumeric**
```java
Character.isDigit(c)
Character.isLetter(c)
Character.isLetterOrDigit(c)
```

**Check case**
```java
Character.isUpperCase(c)
Character.isLowerCase(c)
```

**Convert case**
```java
Character.toUpperCase(c)
Character.toLowerCase(c)
```

**Check whitespace**
```java
Character.isWhitespace(c)
```
> Includes space, tab, newline

**char to int (digit value)**
```java
int d = Character.getNumericValue(c); // '7' → 7
int d = c - '0';                      // only for '0'-'9'
```
> `c - '0'` is faster for ASCII digits

**char to int (ASCII)**
```java
int ascii = (int) c;
```
> 'a' = 97, 'A' = 65, '0' = 48

**Letter index (0-based)**
```java
int idx = c - 'a'; // for lowercase
int idx = c - 'A'; // for uppercase
```
> Used in frequency arrays: `int[26]`

**int to char**
```java
char c = (char) ('a' + idx);
```
> e.g., idx=2 → 'c'

---

## Collections & Arrays

**Sort array**
```java
Arrays.sort(arr);
Arrays.sort(arr, (a, b) -> b - a); // descending (Integer[])
```
> Primitive arrays: no custom comparator. Use `Integer[]` for that.

**Fill array**
```java
Arrays.fill(arr, 0);
Arrays.fill(arr, 2, 5, -1); // if array of 6 len then Result: [0, 0, -1, -1, -1, 0] (Fills indices 2, 3, and 4 with -1)
```

**Copy array**
```java
int[] copy = Arrays.copyOf(arr, arr.length); //Creates a brand new array that is a complete duplicate of the original arr. This creates a new memory reference. If you modify values inside copy, the original arr remains completely unchanged
int[] part = Arrays.copyOfRange(arr, 1, 4); // it only grabs indices 1, 2, and 3. Resulting Size: The new array part will always have a length equal to toIndex - fromIndex (which is 4 - 1 = 3).
```

**2D array: row sort**
```java
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
```
> Sort by first element — classic for interval problems

**Frequency map (one-liner)**
```java
int[] arr={1,2,2,1,3,4,1};
Map<Integer, Integer> freq = new HashMap<>();
for (int x : arr)
  freq.merge(x, 1, Integer::sum);
System.out.println(freq); //{1=3, 2=2, 3=1, 4=1}
```
> `merge()` is cleaner than `getOrDefault`

**getOrDefault**
```java
map.getOrDefault(key, 0)
```
> Returns default if key absent — no NPE

**computeIfAbsent (grouping)**
```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
```
> Used in group anagrams, graph adjacency list

**TreeMap — floor / ceiling**
```java
TreeMap<Integer,Integer> tm = new TreeMap<>();
tm.floorKey(x)   // largest key ≤ x
tm.ceilingKey(x) // smallest key ≥ x
tm.firstKey()    // min
tm.lastKey()     // max
```
> O(log n) — great for sliding window + sorted order

**PriorityQueue — min/max heap**
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// Custom:
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
```

**Deque as stack + queue**
```java
Deque<Integer> dq = new ArrayDeque<>();
dq.push(x); dq.pop();    // stack
dq.offer(x); dq.poll();  // queue
dq.peekFirst(); dq.peekLast();
```
> Prefer `ArrayDeque` over `Stack`/`LinkedList`

**Collections utilities**
```java
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
Collections.min(list);
Collections.max(list);
Collections.frequency(list, x);
```

**Binary search on sorted list/array**
```java
int idx = Arrays.binarySearch(arr, target);
// returns negative if not found
int idx = Collections.binarySearch(list, target);
```

---

## One-Liner Patterns

**Swap two elements in array**
```java
int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
```

**Clamp a value**
```java
int clamped = Math.min(Math.max(val, lo), hi);
```

**Is palindrome (string)**
```java
new StringBuilder(s).reverse().toString().equals(s)
```

**Sum of array**
```java
int sum = Arrays.stream(arr).sum();
long sum = Arrays.stream(arr).asLongStream().sum();
```

**Max of array**
```java
int max = Arrays.stream(arr).max().getAsInt();
```

**Convert List\<Integer\> to int[]**
```java
int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
```

**Convert int[] to List\<Integer\>**
```java
List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
```

**Check anagram**
```java
// Sort both strings and compare
char[] a = s1.toCharArray(); Arrays.sort(a);
char[] b = s2.toCharArray(); Arrays.sort(b);
Arrays.equals(a, b);
```

**Frequency array for lowercase letters**
```java
int[] freq = new int[26];
for (char c : s.toCharArray()) freq[c - 'a']++;
```
> O(n) — faster than HashMap for fixed alphabet

**Prefix sum array**
```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++)
  prefix[i + 1] = prefix[i] + arr[i];
// sum from i to j:
int rangeSum = prefix[j + 1] - prefix[i];
```
> O(1) range sum queries after O(n) build

---

*Java 11+ · 70+ tricks · Built for spaced-repetition review*
