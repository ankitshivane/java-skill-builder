## Coding Notes
* if we have a string "abc" and wanted to process each and every character of it one by one:
  * then str.chars().mapToObj(i->(char)i)
  * then Arrays.stream(str.split(""))