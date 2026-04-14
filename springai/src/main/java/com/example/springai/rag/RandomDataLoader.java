package com.example.springai.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class RandomDataLoader {

    private final VectorStore vectorStore;

    public RandomDataLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadSentencesIntoVectorStore() {
        List<String> sentences = List.of(
                // Java Related Sentences (50)
                "Java is a general-purpose, object-oriented programming language.",
                "The Java Virtual Machine enables cross-platform compatibility.",
                "Java follows the principle of write once, run anywhere.",
                "The main method is the entry point for a Java application.",
                "Java classes are the fundamental building blocks of OOP.",
                "Inheritance in Java allows classes to inherit properties from parent classes.",
                "Polymorphism enables objects to take multiple forms in Java.",
                "Encapsulation hides internal details and protects data in Java.",
                "Exception handling in Java uses try-catch-finally blocks.",
                "Java has a garbage collection mechanism for automatic memory management.",
                "Arrays are used to store multiple values of the same type.",
                "ArrayList provides dynamic array implementation in Java.",
                "HashMap stores key-value pairs for efficient data retrieval.",
                "Interfaces define contracts that classes must implement.",
                "Abstract classes cannot be instantiated directly.",
                "The this keyword refers to the current object instance.",
                "Static methods belong to the class, not to instances.",
                "Final variables cannot be reassigned after initialization.",
                "Packages organize classes into namespaces in Java.",
                "Import statements bring classes from packages into scope.",
                "The super keyword accesses parent class members.",
                "Method overloading allows multiple methods with the same name.",
                "Method overriding replaces a parent class method.",
                "String concatenation can be done with the plus operator.",
                "StringBuilder is efficient for repeated string concatenation.",
                "Regular expressions provide powerful pattern matching capabilities.",
                "Thread class is used for concurrent programming in Java.",
                "Synchronization prevents data corruption in multi-threaded applications.",
                "The synchronized keyword ensures thread safety.",
                "Wait and notify are used for thread communication.",
                "Collections Framework provides data structures and algorithms.",
                "List, Set, and Map are core collection interfaces.",
                "Streams provide functional programming style processing.",
                "Lambda expressions make code more concise and readable.",
                "Functional interfaces have a single abstract method.",
                "Optional class handles null values safely.",
                "Reflection allows runtime inspection of classes.",
                "Annotations provide metadata about the program.",
                "Generics enable type-safe collections and methods.",
                "Type parameters are specified with angle brackets.",
                "Wildcards allow flexible generic type arguments.",
                "The instanceof operator checks object types.",
                "Type casting converts objects between compatible types.",
                "Autoboxing converts primitives to objects automatically.",
                "Unboxing converts wrapper objects back to primitives.",
                "The Enhanced for loop simplifies iteration over collections.",
                "Varargs allow methods to accept variable number of arguments.",
                "Access modifiers control class and member visibility.",
                "Protected members are accessible to subclasses and package members.",
                "Package-private members are accessible only within the same package.",

                // Python Related Sentences (10)
                "Python is an interpreted, high-level programming language.",
                "Python emphasizes code readability and simplicity.",
                "List comprehensions provide concise syntax for creating lists.",
                "Decorators modify function behavior in Python.",
                "Python supports multiple inheritance from multiple classes.",
                "Duck typing allows flexibility in Python programming.",
                "Context managers handle resource management with with statement.",
                "Generators produce values lazily using yield keyword.",
                "Virtual environments isolate project dependencies.",
                "Python is widely used for data science and machine learning.",

                // Docker Related Sentences (10)
                "Docker containerizes applications for consistent deployment.",
                "Docker images are lightweight and portable.",
                "Containers provide isolation between applications.",
                "Docker containers start faster than virtual machines.",
                "Dockerfile defines instructions to build images.",
                "Docker Compose manages multi-container applications.",
                "Volumes persist data outside container lifecycles.",
                "Port mapping exposes container ports to the host.",
                "Docker Hub is a repository for public images.",
                "Container orchestration platforms manage large-scale deployments.",

                // Database SQL Related Sentences (10)
                "SQL is used to manage relational databases.",
                "Select statement retrieves data from tables.",
                "Where clause filters results based on conditions.",
                "Joins combine data from multiple tables.",
                "Primary keys uniquely identify rows in tables.",
                "Foreign keys establish relationships between tables.",
                "Indexes improve query performance significantly.",
                "Normalization reduces data redundancy in databases.",
                "Transactions ensure data consistency and integrity.",
                "Stored procedures encapsulate complex database operations.",

                // Machine Learning and AI Related Sentences (10)
                "Machine learning algorithms learn patterns from data.",
                "Supervised learning requires labeled training data.",
                "Unsupervised learning finds patterns without labels.",
                "Neural networks mimic biological brain structures.",
                "Deep learning uses multiple layers in neural networks.",
                "Classification predicts categorical outcomes.",
                "Regression predicts continuous numerical values.",
                "Feature engineering improves model performance.",
                "Cross-validation assesses model generalization.",
                "Overfitting occurs when models memorize training data too closely."
        );

        List<Document> documents = sentences.stream().map(Document::new).collect(Collectors.toList());
        vectorStore.add(documents);
    }
}
