# Starvation Example in Java

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Build](https://img.shields.io/badge/build-manual-lightgrey)
[![Docs](https://img.shields.io/badge/docs-Javadoc-green)](./doc/index.html)

An educational repository demonstrating starvation in Java multithreading. The learning objectives are:

- Understand what starvation is in concurrent programming.  
- See a minimal reproducible example of two threads competing for resources.

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

## 📃 Description

This example involves creating two threads, one with the highest priority and another with the lowest priority, executing the same task that locks a shared object. Each time the thread acquires the lock on this object, a counter is incremented. The program displays the number of times each thread acquires the lock every 100 acquisitions.

---

## 📂 Repository Structure

```
.
├── src/                   # Source code
│   ├── StarvationExample.java  # Demonstrates starvation of a thread
│   ├── Task.java               # Represents the task to be performed by a thread
└── README.md
```

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 11+ (works with any modern JDK)
- A terminal or IDE (IntelliJ, Eclipse, VS Code, etc.)

### 🔧 Compilation
Inside the project root, compile all sources:

```bash
javac src/*.java -d out
```

This will place compiled `.class` files inside the `out/` directory.

### ▶️ Running

```bash
java -cp out StarvationExample
```

Expected output:

```
High Priority Task acquired the lock (100 times)
High Priority Task acquired the lock (200 times)
High Priority Task acquired the lock (300 times)
High Priority Task acquired the lock (400 times)
High Priority Task acquired the lock (500 times)
Low Priority Task acquired the lock (100 times)
Low Priority Task acquired the lock (200 times)
Low Priority Task acquired the lock (300 times)
Low Priority Task acquired the lock (400 times)
Low Priority Task acquired the lock (500 times)
Low Priority Task acquired the lock (600 times)
Low Priority Task acquired the lock (700 times)
Low Priority Task acquired the lock (800 times)
Low Priority Task acquired the lock (900 times)
High Priority Task acquired the lock (600 times)
High Priority Task acquired the lock (700 times)
...
```

The expected behavior is the *High Priority Task* thread to acquire the lock more times than the *Low Priority Task* thread. However, it is not possible to guarantee that in every run due to the inherent nondeterminism of concurrent programs.

---

## 🤝 Contributing

Contributions are welcome! You can:
- Extend with other starvation scenarios
- Improve documentation or examples

Fork this repository and submit a pull request 🚀

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
