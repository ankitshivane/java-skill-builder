
# 1. Bit Manipulation Tricks

## Check Even/Odd

```java
if ((n & 1) == 0)
```

Even number.

---

## Multiply by 2

```java
n << 1
```

Example:

```java
5 << 1 = 10
```

---

## Divide by 2

```java
n >> 1
```

Example:

```java
10 >> 1 = 5
```

---

## Check Power of 2

```java
(n & (n - 1)) == 0
```

Example:

```java
8 -> true
16 -> true
10 -> false
```

---

## Remove Last Set Bit

```java
n = n & (n - 1);
```

Used in many bit questions.

---

## Count Set Bits

```java
while(n > 0){
    n = n & (n - 1);
    count++;
}
```

---

## XOR Properties

```java
a ^ a = 0

a ^ 0 = a
```

Used in:

Leetcode 136 - Single Number

---

# 2. Math Tricks

## Number of Digits

Instead of loop:

```java
int digits = (int)Math.log10(n) + 1;
```

---

## Reverse Number

```java
while(n > 0){
    rev = rev * 10 + n % 10;
    n /= 10;
}
```

Used everywhere.

---

## Sum of Digits

```java
while(n > 0){
    sum += n % 10;
    n /= 10;
}
```

---

## Check Prime

Don't check till n.

```java
for(int i=2;i*i<=n;i++)
```

Very important optimization.

---

## GCD

```java
while(b != 0){
    int temp = b;
    b = a % b;
    a = temp;
}
```

Or

```java
Math.gcd()
```

(Java 21+)

---

# 3. Character Class Gold Mine

## Check Digit

```java
Character.isDigit(ch)
```

---

## Check Alphabet

```java
Character.isLetter(ch)
```

---

## Check Letter or Digit

```java
Character.isLetterOrDigit(ch)
```

Used in Valid Palindrome.

---

## Lowercase

```java
Character.toLowerCase(ch)
```

---

## Uppercase

```java
Character.toUpperCase(ch)
```

---

## Char to Int

```java
int num = ch - '0';
```

Example:

```java
'5' - '0' = 5
```

---

# 4. String Tricks

## Reverse String

```java
new StringBuilder(str)
        .reverse()
        .toString();
```

---

## Split

```java
str.split(" ");
```

---

## Contains

```java
str.contains("abc");
```

---

## StartsWith

```java
str.startsWith("leet");
```

---

## EndsWith

```java
str.endsWith("code");
```

---

## String to Char Array

```java
char[] arr = str.toCharArray();
```

Very common.

---

# 5. Arrays Tricks

## Sort

```java
Arrays.sort(arr);
```

---

## Binary Search

```java
Arrays.binarySearch(arr, target);
```

---

## Max

```java
Arrays.stream(arr).max().getAsInt();
```

---

## Min

```java
Arrays.stream(arr).min().getAsInt();
```

---

## Fill

```java
Arrays.fill(arr, -1);
```

DP questions.

---

# 6. HashMap Tricks

## Frequency Map

```java
map.put(num,
        map.getOrDefault(num, 0) + 1);
```

This alone solves 50+ problems.

---

## Contains Key

```java
map.containsKey(key)
```

---

## Iterate

```java
for(Map.Entry<Integer,Integer> e : map.entrySet())
```

---

# 7. HashSet Tricks

## Remove Duplicates

```java
Set<Integer> set = new HashSet<>();
```

---

## O(1) Lookup

```java
set.contains(x)
```

Used in:

* Longest Consecutive Sequence
* Happy Number
* Contains Duplicate

---

# 8. Queue Tricks

## BFS

```java
Queue<Integer> q =
      new LinkedList<>();
```

---

## Add

```java
q.offer(x);
```

---

## Remove

```java
q.poll();
```

---

# 9. Deque Tricks

Very useful for Sliding Window.

```java
Deque<Integer> dq =
      new ArrayDeque<>();
```

---

Add front

```java
dq.offerFirst(x);
```

Add back

```java
dq.offerLast(x);
```

Remove front

```java
dq.pollFirst();
```

Remove back

```java
dq.pollLast();
```

---

# 10. Priority Queue (Heap)

## Min Heap

```java
PriorityQueue<Integer> pq =
      new PriorityQueue<>();
```

---

## Max Heap

```java
PriorityQueue<Integer> pq =
      new PriorityQueue<>(
          Collections.reverseOrder()
      );
```

---

# 11. Two Pointer Patterns

Whenever you see:

* Sorted array
* Pair sum
* Palindrome
* Reverse

Think:

```text
l = 0
r = n-1
```

Move pointers.

---

# 12. Sliding Window Triggers

Keywords:

* Subarray
* Substring
* Continuous
* Longest
* Shortest

Immediately think:

```java
left
right
window
```

---

# 13. Binary Search Triggers

Keywords:

* Sorted
* Search
* Minimize
* Maximize
* Capacity
* Kth

Think:

```java
while(low <= high)
```

Many medium problems are hidden binary search.

---

# 14. Prefix Sum Formula

Range sum:

```java
sum(l,r)
=
prefix[r]
-
prefix[l-1]
```

Used everywhere.

---

# 15. Interview Superpower

When stuck ask:

### Can I use HashMap?

Frequency problems.

### Can I sort?

Many O(n²) become O(n log n).

### Can I use two pointers?

Sorted array.

### Can I use sliding window?

Subarray/substring.

### Can I use binary search?

Search space.

### Can I precompute?

Prefix Sum.

---
