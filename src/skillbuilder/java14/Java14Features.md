# Java 14 Features

### Java 14 released on March 17, 2020, exactly six months after its previous version as per Java’s new release cadence.

### Below are the list of features of Java 14

1) Switch Expressions (Standard)
2) Pattern Matching for instanceof (Preview)
3) Helpful NullPointerExceptions
4) Records (Preview) [For record Masterclass refer..](../indepth/record/recordMasterclass.md)
5) Text Blocks (Second Preview)

---

1) Switch
    * These were first introduced as a preview feature in JDK 12, and even in Java 13, they continued as preview
      features only. But now, switch expressions have been standardized so that they are part and parcel of the
      development kit.
    * What this effectively means is that this feature can now be used in production code, and not just in the preview
      mode to be experimented with by developers.

2) Helpful NullPointerExceptions
    * JAVA14 version, NullpointerException was redesigned with more meaningful
      manner
    * Java 14 improved NullPointerExceptions with more informative error messages for easier debugging.
    * In Java 14, it tells exactly which variable was null.
3) Records

* Normally in Java, when you want to create a simple data class (only fields, constructor, getters, toString(),
  equals(), and hashCode()), you have to write a lot of code.
* Record is a new keyword to automatically generate all this for you.
* Records in Java 14 are useful to reduce boilerplate code when creating simple data carriers.
* Record is a simple Data carrier, it will include properties, constructor , accessor methods ,
  toString(), hashCode(), equals(), etc. automatically when compiled the code. that is:
    * Every record must be converted to a final class, Note: If record is final class then it is not possible to define
      inheritance between records.
    * Every record should be a child class to java.lang.Record, where java.lang.Record is
      providing hashCode(), equals(), toString() methods to record.
    * Every records contains a parameterized constructor called as Canonical Constructor,
      where parameters of canonical constructor are same as the parameter types which we
      provided in record declaration.
    * In record, all the parameters are converted as private and final, we are unable to access
      them in out side of the record and we are unable to modify their values.
    * In record, for each and every property a separate accessor method is provided , where
      accessor methods names are same as the property names like propertyName() , it will
      not follow getXXX() methods convention.
    * In Records, toString() method was implemented in such a way to return a string contains
      "RecordName[Prop1=Value1,Prop2=Value2,....]"
    * In Records, equals() method was implemented in such a way to perform content
      comparison instead of references comparison.
    * In record we are able to declare our own variables in the body part, but, it must be static,
      because, Record body is not allowing instance variables.
    * Note: In JAVA/J2EE applications, we are able to use records as an alternatives to Java
      Bean classes.