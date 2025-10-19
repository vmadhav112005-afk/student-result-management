# 🎓 Advanced Student Result Management System

A **Java-based console application** to manage and generate student result reports.
It allows users to input multiple students' marks, calculate their totals, averages, grades, and automatically sort results by average marks before saving them to a text file.

---

## 🚀 Features

* ✅ Input details of multiple students (Name, Subject marks)
* 📊 Automatically calculates **Total**, **Average**, and **Grade**
* 🧮 Sorts students based on **Average Marks (Descending Order)**
* 💾 Generates and saves the report to a file — `StudentReport.txt`
* 🖥️ Console-friendly, easy to use, and beginner-friendly Java project

---

## 🧠 How It Works

1. The program prompts the user to enter the **number of students**.
2. For each student, it collects:

   * Name
   * Marks in 3 subjects
3. It calculates:

   * Total Marks
   * Average Marks
   * Grade (based on average)
4. The students are **sorted** by average marks in descending order.
5. The final report is displayed in the console and also saved as `StudentReport.txt`.

---

## 📁 Output Example

```
=== STUDENT REPORT (Sorted by Average Marks) ===
Name       Sub1     Sub2     Sub3     Total    Average    Grade
--------------------------------------------------------------
Riya       90       95       92       277      92.33      A
Arjun      80       85       88       253      84.33      B
Meena      75       70       72       217      72.33      C

✅ Report saved successfully in 'StudentReport.txt'
```

---

## 🧩 File Structure

```
📦 StudentResultManagementSystem
├── StudentResultManagement.java
├── Student.java
├── StudentReport.txt (Generated after program run)
└── README.md
```

---

## 🧱 Classes Overview

### 1. `StudentResultManagement`

* The main driver class that handles:

  * Input from user
  * Sorting logic
  * Display and file output

### 2. `Student`

* Handles student details and computation.
* Includes methods:

  * `inputDetails(Scanner sc)`
  * `calculateResults()`
  * `display()`
  * `toFileString()`

---

## 🧰 Technologies Used

* **Language:** Java
* **File Handling:** `FileWriter` for saving results
* **Input Handling:** `Scanner`
* **Sorting:** Manual comparison sorting

---

## ▶️ How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/StudentResultManagement.git
   cd StudentResultManagement
   ```

2. Compile the program:

   ```bash
   javac StudentResultManagement.java Student.java
   ```

3. Run the program:

   ```bash
   java StudentResultManagement
   ```

4. After completion, check the generated file:

   ```
   StudentReport.txt
   ```

---

## 📜 License

This project is open-source and available under the **MIT License**.

---

## 💡 Future Enhancements

* Add GPA and rank system
* Support for more subjects dynamically
* GUI version using JavaFX or Swing
* Export report to CSV or PDF format

---

**Author:** *Vansh*
**Language:** Java ☕
**Purpose:** Academic / Learning Project on File Handling and OOP in Java
