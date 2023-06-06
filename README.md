Task 9 - 

(a) - I don't think I need to give any special instructions

(b) - 

In this assignment, I have used “org.json” library. JSON is a lightweight, language independent, data interchange format. I chose this library because it's small and easy to reuse Map and List interfaces from JDK. A good thing about this library is that it has no external dependency and both source and binary are JDK 1.2 compatible.

I’m converting small strings, so don’t really need a bigger library. Because even if you use a bigger library with more methods and it provides great features, it looks like a good tool. I’ll not be going to use all the methods. So, in my opinion if it’s a small program, I would prefer to use a small library.

It also includes the capability to convert between JSON and XML, HTTP headers, Cookies, and CDL.
This is a reference implementation. There are many JSON packages in Java.
There are few JSON implementations are available and most of them are open source. Each of them has its own specific advantages and disadvantages.
GSON and Jackson are the most popular solutions for managing JSON data in the developer community.
I would recommend using Jackson for working with JSONs and avoiding using Gson, as it is much slower for deserialization.

Reference

https://mvnrepository.com/artifact/org.json/json

https://stackoverflow.com/questions/42641301/org-json-jsonobject-vs-gson-library-jsonobject

https://medium.com/@dannydamsky99/heres-why-you-probably-shouldn-t-be-using-the-gson-library-in-2018-4bed5698b78b

https://javarevisited.blogspot.com/2016/09/top-5-json-library-in-java-JEE.html#axzz6ttb7mO6h
