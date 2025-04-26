# Java 13 Features

##### September 2019 saw the release of JDK 13, per Java’s new release cadence of six months.

#### Below are the features of te Java 13 release

> ## NOTE:
> * If we want to execute preview features we have to enable preview Features first
    before execution

1) Text Blocks (preview feature)
2) New Methods in String Class for Text Blocks
3) Switch Expressions Enhancements
4) Reimplement the Legacy Socket API
5) Dynamic CDS Archive
6) ZGC: Uncommit Unused Memory
7) FileSystems.newFileSystem() Method

---

1) Text Block
    * Upto Java12 version, if we want to write String data in more than one line then we have
      to use \n character in middle of the String
    * To overcome the above problems, JAVA13 version has provided a new preview feature
      called as "Text Blocks", where we can write String data in multiple lines without providing
      \n and \t escape symbols.
    * we can even compare both string declared in "" and """ """ using == and .equals() method.
    * It is possible to perform concatenation operation between the strings which
      represented in "" and """ """
    * It is possible to pass Text Blocks as parameters to the methods, it is possible to
      return Text Blocks from the methods
2) New Methods in String Class for Text Blocks
    * For Text Blocks, JAVA13 version has provided the following three methods in String class.
        1) public String formatted(Object ... values)
            * In Text Blocks we can provide data formating by using the following method.
              public String formatted(val1,val2,...val_n)
        2) public String stripIndent()
            * If we have any spaces at beginning and Ending of String.
        3) public String translateEscapes()
            * It able to remove Escape symbols like \ in our String data.
3) Switch Expressions Enhancements
    * Switch Expression in JAVA12 was introduced as preview feature, in JAVA13 also it was
      very same except break statement. In JAVA13 version, we can use "yield" in place of break
      statement to return a value.