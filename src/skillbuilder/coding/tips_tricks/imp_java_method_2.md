# Java Utility Classes for DSA: Important Methods Reference

## Table of Contents
1. [Character Class](#character-class)
2. [Math Class](#math-class)
3. [Integer Class](#integer-class)
4. [Long Class](#long-class)
5. [Double & Float Classes](#double--float-classes)
6. [Boolean Class](#boolean-class)
7. [System Class](#system-class)
8. [Optional Class](#optional-class)
9. [Random Class](#random-class)
10. [Objects Utility Class](#objects-utility-class)

---

## Character Class

### Character Type Checking

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `isDigit(char ch)` | Checks if character is a digit (0-9) | No | `Character.isDigit('5')` → `true`, `Character.isDigit('a')` → `false` |
| `isLetter(char ch)` | Checks if character is a letter | No | `Character.isLetter('a')` → `true`, `Character.isLetter('5')` → `false` |
| `isLetterOrDigit(char ch)` | Checks if character is letter or digit | No | `Character.isLetterOrDigit('5')` → `true` |
| `isLowerCase(char ch)` | Checks if character is lowercase | No | `Character.isLowerCase('a')` → `true` |
| `isUpperCase(char ch)` | Checks if character is uppercase | No | `Character.isUpperCase('A')` → `true` |
| `isWhitespace(char ch)` | Checks if character is whitespace | Yes | Includes space, tab, newline, etc.; `Character.isWhitespace(' ')` → `true` |
| `isSpaceChar(char ch)` | Checks if character is a space | No | Similar to isWhitespace() but more specific |
| `isAlphabetic(char ch)` | Checks if character is alphabetic | No | Like isLetter() but for Unicode |
| `isNumeric(char ch)` | Checks if character represents a number | Yes | Different from isDigit(); includes superscript, Roman numerals, etc. |
| `isDefined(char ch)` | Checks if character is defined in Unicode | No | `Character.isDefined('a')` → `true` |

### Character Case Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `toUpperCase(char ch)` | Converts character to uppercase | No | `Character.toUpperCase('a')` → `'A'` |
| `toLowerCase(char ch)` | Converts character to lowercase | No | `Character.toLowerCase('A')` → `'a'` |
| `toTitleCase(char ch)` | Converts to title case | Yes | `Character.toTitleCase('a')` → `'A'`; rarely used |
| `reverseBytes(char ch)` | Reverses bytes of character | Yes | `Character.reverseBytes('A')` reverses byte order; rarely useful |

### Character Information

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `getNumericValue(char ch)` | Returns numeric value of character | Yes | `Character.getNumericValue('5')` → `5`, `Character.getNumericValue('F')` → `15` (hex!) |
| `digit(char ch, int radix)` | Returns digit value in specified radix | Yes | `Character.digit('F', 16)` → `15`, `Character.digit('2', 2)` → `2` (binary) |
| `forDigit(int digit, int radix)` | Returns character for digit in specified radix | Yes | `Character.forDigit(15, 16)` → `'f'`, `Character.forDigit(1, 2)` → `'1'` |
| `charCount(int codePoint)` | Returns number of char values for code point | No | Usually 1; 2 for supplementary characters |
| `codePointCount(CharSequence seq, int beginIndex, int endIndex)` | Counts code points in range | Yes | Different from character count for Unicode |

### Character Code Point Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `codePointAt(CharSequence seq, int index)` | Gets code point at index | No | `Character.codePointAt("hello", 0)` → `104` (code for 'h') |
| `codePointBefore(CharSequence seq, int index)` | Gets code point before index | No | `Character.codePointBefore("hello", 1)` → `104` |
| `codePointOf(String name)` | Gets code point by name (Java 11+) | Yes | `Character.codePointOf("LATIN SMALL LETTER A")` → `97` |
| `isHighSurrogate(char ch)` | Checks if char is high surrogate | Yes | For supplementary characters; rarely needed |
| `isLowSurrogate(char ch)` | Checks if char is low surrogate | Yes | For supplementary characters; rarely needed |

### Character Wrapper

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `Character(char value)` | Deprecated constructor | No | Avoid; use primitive |
| `charValue()` | Returns primitive char value | No | `new Character('a').charValue()` → `'a'` |
| `compare(char x, char y)` | Compares two characters | No | `Character.compare('a', 'b')` → negative |
| `compareTo(Character anotherCharacter)` | Compares Character objects | No | `char1.compareTo(char2)` |

---

## Math Class

### Basic Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `abs(int a)` | Returns absolute value | No | `Math.abs(-5)` → `5`, but `Math.abs(Integer.MIN_VALUE)` → `Integer.MIN_VALUE` (overflow!) |
| `abs(long a)` / `abs(float f)` / `abs(double d)` | Absolute value for different types | Yes | Watch for Integer/Long overflow with MIN_VALUE |
| `max(int a, int b)` | Returns maximum of two values | No | `Math.max(5, 3)` → `5` |
| `min(int a, int b)` | Returns minimum of two values | No | `Math.min(5, 3)` → `3` |
| `max(long a, long b)` / `min(long a, long b)` | Min/max for long values | No | |

### Power & Root Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `pow(double a, double b)` | Returns a raised to power b | Yes | `Math.pow(2, 3)` → `8.0`; returns double! |
| `sqrt(double a)` | Returns square root | No | `Math.sqrt(16)` → `4.0` |
| `cbrt(double a)` | Returns cube root | No | `Math.cbrt(27)` → `3.0` |
| `hypot(double x, double y)` | Returns sqrt(x² + y²) | Yes | `Math.hypot(3, 4)` → `5.0` |

### Rounding & Truncation

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `floor(double a)` | Returns largest integer ≤ a | Yes | `Math.floor(3.7)` → `3.0`, `Math.floor(-3.2)` → `-4.0` |
| `ceil(double a)` | Returns smallest integer ≥ a | Yes | `Math.ceil(3.2)` → `4.0`, `Math.ceil(-3.7)` → `-3.0` |
| `round(double a)` | Rounds to nearest integer (0.5 rounds up) | Yes | `Math.round(3.5)` → `4`, `Math.round(3.4)` → `3`, `Math.round(-2.5)` → `-2` (banker's rounding!) |
| `round(float a)` | Rounds float to int | No | Returns int, not long |
| `rint(double a)` | Rounds to nearest double | Yes | Similar to round() but returns double; uses banker's rounding (round to even) |

### Trigonometric Functions

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `sin(double a)` | Sine (a in radians) | No | `Math.sin(Math.PI / 2)` → `1.0` |
| `cos(double a)` | Cosine (a in radians) | No | `Math.cos(0)` → `1.0` |
| `tan(double a)` | Tangent (a in radians) | No | `Math.tan(Math.PI / 4)` → `1.0` |
| `asin(double a)` | Arc sine | No | `Math.asin(1)` → `π/2` |
| `acos(double a)` | Arc cosine | No | |
| `atan(double a)` | Arc tangent | No | |
| `atan2(double y, double x)` | Angle from x-axis to (x,y) | Yes | `Math.atan2(1, 1)` → `π/4` |

### Logarithmic & Exponential

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `log(double a)` | Natural logarithm (base e) | No | `Math.log(Math.E)` → `1.0` |
| `log10(double a)` | Logarithm base 10 | No | `Math.log10(100)` → `2.0` |
| `log1p(double x)` | Returns log(1 + x) | Yes | More accurate than log(1+x) for small x |
| `exp(double a)` | Returns e^a | No | `Math.exp(1)` → `2.718...` |
| `expm1(double x)` | Returns e^x - 1 | Yes | More accurate than exp(x)-1 for small x |

### Sign & Utility

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `signum(double d)` | Returns sign of number (-1, 0, or 1) | Yes | `Math.signum(-5.0)` → `-1.0`, `Math.signum(0)` → `0.0` |
| `signum(float f)` | Returns sign as float | No | Similar to double version |
| `copySign(double magnitude, double sign)` | Returns magnitude with sign of sign | Yes | `Math.copySign(5, -1)` → `-5.0` |
| `nextUp(double d)` | Returns next representable number > d | Yes | For IEEE 754 floating point; rarely used |
| `nextDown(double d)` | Returns next representable number < d | Yes | Rarely used in DSA |

### Random & Incremental

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `random()` | Returns random double [0.0, 1.0) | No | `Math.random()` similar to `new Random().nextDouble()` |
| `incrementExact(int a)` | Increments with overflow check | Yes | Throws ArithmeticException on overflow; `incrementExact(Integer.MAX_VALUE)` throws exception |
| `incrementExact(long a)` | Increments long with check | No | |
| `decrementExact(int a)` | Decrements with overflow check | No | |
| `multiplyExact(int x, int y)` | Multiplies with overflow check | Yes | `multiplyExact(Integer.MAX_VALUE, 2)` throws exception |
| `addExact(int x, int y)` | Adds with overflow check | Yes | `addExact(Integer.MAX_VALUE, 1)` throws exception |
| `subtractExact(int x, int y)` | Subtracts with overflow check | Yes | Useful for preventing silent overflow |
| `negateExact(int a)` | Negates with overflow check | Yes | `negateExact(Integer.MIN_VALUE)` throws exception |
| `toIntExact(long value)` | Converts long to int with check | Yes | Throws if value too large for int |

### Constants

| Constant | Value | Usage |
|----------|-------|-------|
| `Math.PI` | 3.14159... | `Math.PI` for π calculations |
| `Math.E` | 2.71828... | `Math.E` for e calculations |

---

## Integer Class

### Conversion Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `parseInt(String s)` | Parses string to int | Yes | `Integer.parseInt("123")` → `123`, `Integer.parseInt("-456")` → `-456`, throws NumberFormatException if invalid |
| `parseInt(String s, int radix)` | Parses string in specified radix | Yes | `Integer.parseInt("1010", 2)` → `10` (binary), `Integer.parseInt("FF", 16)` → `255` (hex) |
| `parseUnsignedInt(String s)` | Parses unsigned int from string | Yes | `Integer.parseUnsignedInt("4294967295")` → `4294967295` (treats as unsigned) |
| `parseUnsignedInt(String s, int radix)` | Parses unsigned int in specified radix | No | |
| `valueOf(String s)` | Parses string and returns Integer object | No | `Integer.valueOf("123")` → `Integer(123)` |
| `valueOf(String s, int radix)` | Parses string in radix, returns Integer | No | `Integer.valueOf("FF", 16)` → `Integer(255)` |
| `valueOf(int i)` | Returns Integer wrapper | Yes | `Integer.valueOf(5)` uses cache [-128, 127]; same reference for cached values |
| `toString(int i)` | Converts int to string | No | `Integer.toString(123)` → `"123"` |
| `toString(int i, int radix)` | Converts int to string in radix | Yes | `Integer.toString(255, 16)` → `"ff"`, `Integer.toString(10, 2)` → `"1010"` |
| `toHexString(int i)` | Converts to hexadecimal string | No | `Integer.toHexString(255)` → `"ff"` |
| `toOctalString(int i)` | Converts to octal string | No | `Integer.toOctalString(8)` → `"10"` |
| `toBinaryString(int i)` | Converts to binary string | No | `Integer.toBinaryString(5)` → `"101"` |
| `toUnsignedString(int i)` | Converts to string (unsigned interpretation) | Yes | `Integer.toUnsignedString(-1)` → `"4294967295"` |
| `toUnsignedString(int i, int radix)` | Unsigned string in radix | No | |
| `intValue()` | Returns primitive int value | No | `Integer.valueOf(5).intValue()` → `5` |

### Bit Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `bitCount(int i)` | Counts number of 1-bits (set bits) | No | `Integer.bitCount(7)` → `3` (binary 111 has three 1s) |
| `highestOneBit(int i)` | Returns only the highest 1-bit | Yes | `Integer.highestOneBit(14)` → `8` (binary 1000); useful for finding highest power of 2 |
| `lowestOneBit(int i)` | Returns only the lowest 1-bit | Yes | `Integer.lowestOneBit(12)` → `4` (binary 0100) |
| `numberOfLeadingZeros(int i)` | Counts leading zeros in binary | Yes | `Integer.numberOfLeadingZeros(1)` → `31` (binary 00...01 has 31 leading zeros) |
| `numberOfTrailingZeros(int i)` | Counts trailing zeros in binary | Yes | `Integer.numberOfTrailingZeros(8)` → `3` (binary 1000 has 3 trailing zeros) |
| `rotateLeft(int i, int distance)` | Rotates bits left by distance | Yes | `Integer.rotateLeft(5, 1)` → `10` (0101 becomes 1010) |
| `rotateRight(int i, int distance)` | Rotates bits right by distance | Yes | `Integer.rotateRight(5, 1)` → `-2147483643` in two's complement |
| `reverse(int i)` | Reverses bits in binary representation | Yes | `Integer.reverse(5)` reverses all 32 bits; rarely useful directly |
| `compareUnsigned(int x, int y)` | Compares as unsigned integers | Yes | `Integer.compareUnsigned(-1, 1)` → positive (treats -1 as large unsigned number) |

### Min, Max, Sign

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `min(int a, int b)` | Returns minimum | No | `Integer.min(5, 3)` → `3` |
| `max(int a, int b)` | Returns maximum | No | `Integer.max(5, 3)` → `5` |
| `signum(int i)` | Returns -1, 0, or 1 | No | `Integer.signum(-5)` → `-1` |
| `compare(int x, int y)` | Compares two integers | No | `Integer.compare(5, 3)` → positive |

### Integer Constants & Limits

| Constant | Value | Usage |
|----------|-------|-------|
| `Integer.MAX_VALUE` | 2147483647 | Maximum int value (2^31 - 1) |
| `Integer.MIN_VALUE` | -2147483648 | Minimum int value (-2^31) |
| `Integer.SIZE` | 32 | Number of bits in int |
| `Integer.BYTES` | 4 | Number of bytes in int |

### Integer Wrapper Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `Integer(int value)` | Constructor (deprecated) | No | Avoid; use valueOf() or primitives |
| `compareTo(Integer anotherInteger)` | Compares Integer objects | No | `Integer.valueOf(5).compareTo(Integer.valueOf(3))` → positive |
| `equals(Object obj)` | Checks equality | No | `Integer.valueOf(5).equals(5)` → `true` (auto-unboxing) |
| `hashCode()` | Returns hash code | No | `Integer.valueOf(5).hashCode()` → `5` |

---

## Long Class

### Conversion Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `parseLong(String s)` | Parses string to long | No | `Long.parseLong("123456789")` → `123456789L` |
| `parseLong(String s, int radix)` | Parses string in specified radix | No | `Long.parseLong("FFFFFFFF", 16)` → `4294967295L` |
| `parseUnsignedLong(String s)` | Parses unsigned long from string | Yes | `Long.parseUnsignedLong("18446744073709551615")` → max unsigned long |
| `valueOf(long l)` | Returns Long wrapper | Yes | `-128 to 127` cached; different ranges than Integer! |
| `valueOf(String s)` | Parses and wraps | No | |
| `toString(long i)` | Converts to string | No | `Long.toString(123L)` → `"123"` |
| `toString(long i, int radix)` | Converts to string in radix | No | `Long.toString(255L, 16)` → `"ff"` |
| `toHexString(long i)` | Converts to hex | No | |
| `toOctalString(long i)` | Converts to octal | No | |
| `toBinaryString(long i)` | Converts to binary | No | |
| `longValue()` | Returns primitive long | No | |

### Bit Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `bitCount(long i)` | Counts 1-bits | No | `Long.bitCount(7L)` → `3` |
| `highestOneBit(long i)` | Highest 1-bit | No | `Long.highestOneBit(14L)` → `8L` |
| `lowestOneBit(long i)` | Lowest 1-bit | No | `Long.lowestOneBit(12L)` → `4L` |
| `numberOfLeadingZeros(long i)` | Counts leading zeros | Yes | `Long.numberOfLeadingZeros(1L)` → `63` (64 bits - 1) |
| `numberOfTrailingZeros(long i)` | Counts trailing zeros | No | `Long.numberOfTrailingZeros(8L)` → `3` |
| `rotateLeft(long i, int distance)` | Rotates bits left | No | |
| `rotateRight(long i, int distance)` | Rotates bits right | No | |
| `reverse(long i)` | Reverses all bits | No | |

### Min, Max, Compare

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `min(long a, long b)` | Returns minimum | No | `Long.min(100L, 50L)` → `50L` |
| `max(long a, long b)` | Returns maximum | No | `Long.max(100L, 50L)` → `100L` |
| `compare(long x, long y)` | Compares two longs | No | Returns negative, 0, or positive |
| `compareUnsigned(long x, long y)` | Unsigned comparison | No | |

### Long Constants

| Constant | Value | Usage |
|----------|-------|-------|
| `Long.MAX_VALUE` | 9223372036854775807L | Max long (2^63 - 1) |
| `Long.MIN_VALUE` | -9223372036854775808L | Min long (-2^63) |
| `Long.SIZE` | 64 | Number of bits |
| `Long.BYTES` | 8 | Number of bytes |

---

## Double & Float Classes

### Double Conversion

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `parseDouble(String s)` | Parses string to double | Yes | `Double.parseDouble("3.14")` → `3.14`, also accepts "Infinity", "NaN" |
| `valueOf(String s)` | Parses and wraps | No | `Double.valueOf("3.14")` → `Double(3.14)` |
| `toString(double d)` | Converts to string | No | `Double.toString(3.14)` → `"3.14"` |
| `toHexString(double d)` | Converts to hex string | Yes | `Double.toHexString(1.0)` → `"0x1.0p0"` (rarely used) |
| `doubleValue()` | Returns primitive double | No | |

### Double Special Values

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `isNaN(double v)` | Checks if value is NaN | Yes | `Double.isNaN(Double.NaN)` → `true`, but `Double.NaN == Double.NaN` → `false`! |
| `isInfinite(double v)` | Checks if value is infinity | Yes | `Double.isInfinite(Double.POSITIVE_INFINITY)` → `true` |
| `isFinite(double d)` | Checks if value is finite (not NaN or infinity) | No | `Double.isFinite(3.14)` → `true` |
| `doubleToLongBits(double value)` | Converts double bits to long | Yes | IEEE 754 representation; rarely used |
| `doubleToRawLongBits(double value)` | Converts double bits to long (preserves NaN) | Yes | Similar to above |
| `longBitsToDouble(long bits)` | Converts long bits to double | Yes | Reverse of doubleToLongBits() |

### Double Constants

| Constant | Value | Usage |
|----------|-------|-------|
| `Double.MAX_VALUE` | 1.7976931348623157E308 | Maximum double |
| `Double.MIN_VALUE` | 4.9E-324 | Smallest positive double (NOT negative!) |
| `Double.MIN_NORMAL` | 2.2250738585072014E-308 | Smallest normal double |
| `Double.POSITIVE_INFINITY` | Infinity | Positive infinity |
| `Double.NEGATIVE_INFINITY` | -Infinity | Negative infinity |
| `Double.NaN` | NaN | Not a Number |
| `Double.SIZE` | 64 | Number of bits |

### Float Methods

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `parseFloat(String s)` | Parses string to float | No | `Float.parseFloat("3.14")` → `3.14f` |
| `intBitsToFloat(int bits)` | Converts int bits to float | Yes | IEEE 754; rarely used in DSA |
| `floatToIntBits(float value)` | Converts float to int bits | Yes | Rarely used |
| `isNaN(float v)` | Checks if NaN | Yes | `Float.isNaN(Float.NaN)` → `true` |
| `isInfinite(float v)` | Checks if infinite | No | |
| `isFinite(float f)` | Checks if finite | No | |

### Float Constants

| Constant | Value | Usage |
|----------|-------|-------|
| `Float.MAX_VALUE` | 3.4028235E38f | Maximum float |
| `Float.MIN_VALUE` | 1.4E-45f | Smallest positive float |
| `Float.POSITIVE_INFINITY` | Infinity | Positive infinity |
| `Float.NEGATIVE_INFINITY` | -Infinity | Negative infinity |
| `Float.NaN` | NaN | Not a Number |

---

## Boolean Class

### Boolean Conversion & Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `parseBoolean(String s)` | Parses string to boolean | Yes | `Boolean.parseBoolean("true")` → `true`, **case-insensitive!** `Boolean.parseBoolean("TRUE")` → `true`, `Boolean.parseBoolean("false")` → `false`, anything else → `false` (no exception!) |
| `valueOf(String s)` | Parses and wraps | No | `Boolean.valueOf("true")` → `Boolean.TRUE` |
| `valueOf(boolean b)` | Wraps boolean | Yes | `Boolean.valueOf(true)` → `Boolean.TRUE` (uses cached constants) |
| `toString(boolean b)` | Converts to string | No | `Boolean.toString(true)` → `"true"` |
| `booleanValue()` | Returns primitive boolean | No | `Boolean.TRUE.booleanValue()` → `true` |
| `compareTo(Boolean b)` | Compares Boolean objects | No | `Boolean.TRUE.compareTo(Boolean.FALSE)` → positive |
| `compare(boolean x, boolean y)` | Compares two booleans | No | `Boolean.compare(true, false)` → positive |
| `logicalAnd(boolean a, boolean b)` | Logical AND | No | `Boolean.logicalAnd(true, false)` → `false` |
| `logicalOr(boolean a, boolean b)` | Logical OR | No | `Boolean.logicalOr(true, false)` → `true` |
| `logicalXor(boolean a, boolean b)` | Logical XOR | No | `Boolean.logicalXor(true, false)` → `true` |

### Boolean Constants

| Constant | Value | Usage |
|----------|-------|-------|
| `Boolean.TRUE` | true | Wrapped true constant |
| `Boolean.FALSE` | false | Wrapped false constant |

---

## System Class

### System Output & Input

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `System.out` | PrintStream for standard output | No | `System.out.println("Hello")` |
| `System.err` | PrintStream for error output | No | `System.err.println("Error")` writes to stderr |
| `System.in` | InputStream for standard input | Yes | Requires wrapping: `new Scanner(System.in)` or `new BufferedReader()` |
| `System.out.println()` | Prints with newline | No | |
| `System.out.print()` | Prints without newline | No | |
| `System.out.printf(String format, Object... args)` | Formatted output | No | `System.out.printf("%d + %d = %d", 1, 2, 3)` |

### System Properties & Environment

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `getProperty(String key)` | Gets system property | No | `System.getProperty("java.version")` |
| `getProperties()` | Returns all system properties | No | `System.getProperties()` → Properties object |
| `setProperty(String key, String value)` | Sets system property | No | `System.setProperty("key", "value")` |
| `getenv(String name)` | Gets environment variable | No | `System.getenv("PATH")` |
| `getenv()` | Gets all environment variables | No | `System.getenv()` → Map |

### System Time

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `currentTimeMillis()` | Returns milliseconds since epoch | No | `System.currentTimeMillis()` useful for timing |
| `nanoTime()` | Returns nanosecond precision time | Yes | Does NOT have millisecond granularity; use for relative timing, not absolute |
| `currentTimeMillis() - startTime` | Measure elapsed time | No | |

### Array Operations

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `arraycopy(Object src, int srcPos, Object dest, int destPos, int length)` | Copies array efficiently | Yes | `System.arraycopy(src, 0, dest, 0, length)` faster than loops; can copy overlapping regions |
| | | Yes | Doesn't do bounds checking; throws exception if out of bounds |

### Misc

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `exit(int status)` | Terminates JVM | No | `System.exit(0)` for success, non-zero for error |
| `gc()` | Suggests garbage collection | No | `System.gc()` (not guaranteed to run) |
| `getSecurityManager()` | Gets security manager | No | Usually null |

---

## Optional Class (Java 8+)

### Creating Optionals

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `Optional.of(T value)` | Creates Optional with non-null value | Yes | Throws NullPointerException if value is null; use `ofNullable()` for nullable values |
| `Optional.ofNullable(T value)` | Creates Optional (value can be null) | No | `Optional.ofNullable(null)` → empty Optional |
| `Optional.empty()` | Creates empty Optional | No | `Optional.empty()` → empty Optional |

### Checking Values

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `isPresent()` | Checks if value exists | No | `opt.isPresent()` → true if value present |
| `isEmpty()` | Checks if Optional is empty (Java 11+) | No | `opt.isEmpty()` → true if no value |
| `ifPresent(Consumer<? super T> action)` | Executes if present | No | `opt.ifPresent(System.out::println)` |
| `ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)` | Execute based on presence (Java 9+) | No | `opt.ifPresentOrElse(x -> print(x), () -> print("empty"))` |
| `orElse(T other)` | Returns value or default | No | `opt.orElse("default")` |
| `orElseGet(Supplier<? extends T> supplier)` | Returns value or supplied value | Yes | `opt.orElseGet(() -> computeDefault())` lazy evaluation! |
| `orElseThrow()` | Returns value or throws exception (Java 10+) | Yes | `opt.orElseThrow()` throws NoSuchElementException if empty |
| `orElseThrow(Supplier<? extends X> exceptionSupplier)` | Throws custom exception if empty | No | `opt.orElseThrow(CustomException::new)` |
| `get()` | Returns value or throws exception | Yes | Throws NoSuchElementException if empty; use `orElse()` instead usually |

### Transforming Optionals

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `map(Function<? super T, ? extends U> mapper)` | Transforms value if present | No | `opt.map(String::length)` transforms to Optional<Integer> |
| `flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)` | Transforms to Optional | Yes | Use when mapper returns Optional; avoids nested Optionals |
| `filter(Predicate<? super T> predicate)` | Filters value | No | `opt.filter(x -> x > 5)` returns empty if doesn't match |
| `stream()` | Converts to Stream (Java 9+) | No | `opt.stream().forEach(...)` |

### Comparison

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `equals(Object obj)` | Checks Optional equality | Yes | `Optional.of(5).equals(Optional.of(5))` → `true`; compares contained values |
| `hashCode()` | Hash code | No | |

---

## Random Class

### Basic Random Generation

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `Random()` | Constructor with default seed | No | `new Random()` uses system time |
| `Random(long seed)` | Constructor with specific seed | Yes | `new Random(42)` reproducible; same seed gives same sequence |
| `nextInt()` | Random int (positive or negative) | No | `rand.nextInt()` range: Integer.MIN_VALUE to Integer.MAX_VALUE |
| `nextInt(int bound)` | Random int [0, bound) | Yes | `rand.nextInt(10)` → 0 to 9; bound must be > 0; exclusive upper bound! |
| `nextInt(int origin, int bound)` | Random int [origin, bound) (Java 17+) | No | `rand.nextInt(1, 11)` → 1 to 10 |
| `nextLong()` | Random long | No | |
| `nextLong(long bound)` | Random long [0, bound) | No | `rand.nextLong(100)` → 0 to 99 |
| `nextDouble()` | Random double [0.0, 1.0) | No | `rand.nextDouble()` |
| `nextDouble(double bound)` | Random double [0.0, bound) (Java 17+) | No | |
| `nextDouble(double origin, double bound)` | Random double [origin, bound) (Java 17+) | No | |
| `nextFloat()` | Random float [0.0, 1.0) | No | |
| `nextBoolean()` | Random boolean | No | `rand.nextBoolean()` → true or false |
| `nextBytes(byte[] bytes)` | Fills byte array with random values | No | `rand.nextBytes(arr)` modifies array |
| `nextGaussian()` | Random double (normal distribution) | Yes | Mean 0, standard deviation 1; bell curve distribution |
| `nextGaussian(double mean, double stddev)` | Gaussian with custom parameters (Java 17+) | No | |

### Stream Methods (Java 8+)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `ints()` | Returns infinite IntStream | No | `rand.ints().limit(10)` |
| `ints(int origin, int bound)` | IntStream [origin, bound) | No | `rand.ints(1, 11)` generates numbers 1-10 |
| `longs()` | Returns infinite LongStream | No | |
| `longs(long origin, long bound)` | LongStream [origin, bound) | No | |
| `doubles()` | Returns infinite DoubleStream | No | |
| `doubles(double origin, double bound)` | DoubleStream [origin, bound) | No | |

### Thread-Safe Alternative

| Class | Description |
|-------|-------------|
| `ThreadLocalRandom` | Thread-safe random; use in multi-threaded programs |
| `ThreadLocalRandom.current()` | Gets thread-local instance |

---

## Objects Utility Class

### Null Checks

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `requireNonNull(T obj)` | Throws NullPointerException if null | No | `Objects.requireNonNull(obj)` throws NPE if obj is null |
| `requireNonNull(T obj, String message)` | NPE with custom message | No | `Objects.requireNonNull(obj, "obj cannot be null")` |
| `requireNonNull(T obj, Supplier<String> messageSupplier)` | NPE with lazy message (Java 8+) | Yes | `Objects.requireNonNull(obj, () -> "expensive message")` message only created if null |
| `requireNonNullElse(T obj, T defaultObj)` | Returns obj or default if null (Java 9+) | No | `Objects.requireNonNullElse(obj, default)` |
| `requireNonNullElseGet(T obj, Supplier<? extends T> supplier)` | Returns obj or supplied default (Java 9+) | No | `Objects.requireNonNullElseGet(obj, () -> newObj)` |
| `isNull(Object obj)` | Checks if null | No | `Objects.isNull(obj)` → `obj == null` |
| `nonNull(Object obj)` | Checks if not null | No | `Objects.nonNull(obj)` → `obj != null` |

### Comparison & Equality

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `equals(Object a, Object b)` | Null-safe equality | Yes | `Objects.equals(null, null)` → `true`, `Objects.equals(a, null)` → `false` |
| `deepEquals(Object a, Object b)` | Deep equality (arrays, nested) | Yes | `Objects.deepEquals([1,2], [1,2])` → `true` |
| `compare(T a, T b, Comparator<? super T> c)` | Null-safe comparison | Yes | `Objects.compare(a, b, comp)` handles null gracefully |
| `hash(Object... values)` | Generates hash code from values | No | `Objects.hash(name, age)` → combined hash |

### String Representation

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `toString(Object o)` | Null-safe toString | No | `Objects.toString(obj)` → `"null"` if obj is null |
| `toString(Object o, String nullDefault)` | toString with null handling | No | `Objects.toString(obj, "N/A")` uses "N/A" if null |

---

## Additional Utility Classes for DSA

### Comparator Class (Java 8+)

| Method | Description | Tricky? | Example |
|--------|-------------|---------|---------|
| `comparing(Function<? super T, ? extends U> keyExtractor)` | Creates comparator from key | No | `Comparator.comparing(String::length)` compares by length |
| `comparingInt(ToIntFunction<? super T> keyExtractor)` | Comparator for int values | Yes | More efficient than `comparing()` for primitives |
| `comparingLong(ToLongFunction<? super T> keyExtractor)` | Comparator for long values | No | |
| `comparingDouble(ToDoubleFunction<? super T> keyExtractor)` | Comparator for double values | No | |
| `reversed()` | Reverses comparator | No | `Comparator.comparing(String::length).reversed()` |
| `thenComparing(Comparator<? super T> other)` | Chains comparators | No | `comp1.thenComparing(comp2)` for multi-level sort |
| `thenComparing(Function<? super T, ? extends U> keyExtractor)` | Chains with another key | No | |
| `nullsFirst(Comparator<? super T> comparator)` | Nulls come first | No | `Comparator.nullsFirst(Comparator.naturalOrder())` |
| `nullsLast(Comparator<? super T> comparator)` | Nulls come last | No | `Comparator.nullsLast(Comparator.naturalOrder())` |
| `naturalOrder()` | Natural ordering | No | `Comparator.naturalOrder()` for Comparable types |
| `reverseOrder()` | Reverse natural order | No | `Comparator.reverseOrder()` descending |

---


### Performance Considerations
- Use primitives (int, long) instead of wrapper classes (Integer, Long) when possible
- Use `Integer.bitCount()` instead of manual loop for counting bits
- Use `Math.multiplyExact()` to detect overflow early
- Use `System.arraycopy()` for efficient array copying
- Cache random seeds for reproducibility in tests
- `Character.getNumericValue()` and `Character.digit()` are key for parsing digits

---

## Method Tricky Points Summary

**Most Tricky Methods in DSA Context:**

1. **Math.round()** - Uses banker's rounding for .5 values
2. **Integer.parseInt()** & **Long.parseLong()** - Need correct radix for binary/hex
3. **Integer.rotateLeft/Right()** - Operates on all 32/64 bits
4. **String.split()** - Takes regex, not literal string
5. **Arrays.copyOf()** - Pads with 0/null or truncates to exact length
6. **Integer.compareUnsigned()** - Treats as unsigned for comparison
7. **Boolean.parseBoolean()** - Anything except "true" → false (no exception!)
8. **Double.isNaN()** - NaN != NaN, must use isNaN() method
9. **Optional.orElseGet()** - Lazy evaluation vs orElse()
10. **System.arraycopy()** - No bounds checking; overlapping regions OK