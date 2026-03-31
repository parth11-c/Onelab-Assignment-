# Onelab-Assignment-
# 🔍 AI Fitness Assessment — Transaction Reconciliation System

## 📌 Overview

This project implements a **Transaction Reconciliation System** that compares platform transactions with bank settlements and identifies discrepancies.

In real-world payment systems, mismatches occur due to delays, duplicates, and rounding differences. This system detects such inconsistencies and provides a clear, structured report.

---

## 🚀 Features

* ✅ Detects **Missing Settlements**
* ⏳ Identifies **Late Settlements (Next Month)**
* 🔁 Flags **Duplicate Entries**
* 💰 Handles **Rounding Differences**
* ❌ Detects **Invalid Refunds (No Original Transaction)**
* 📊 Calculates **Total Difference**
* 🧾 Returns **Clean JSON Output**

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot (Java)
* **Language:** Java
* **Architecture:** Controller → Service → Model
* **Data:** In-memory (synthetic test data)

---

## ⚙️ How It Works

1. Synthetic transaction and settlement data is generated
2. Transactions are mapped using `transaction_id`
3. Settlements are processed to:

   * Match transactions
   * Detect duplicates
   * Identify late settlements
   * Check rounding differences
4. Final reconciliation report is returned as JSON

---

## 📡 API Endpoint

```http
GET /api/reconcile
```

### 🔗 Example:

```bash
http://localhost:8080/api/reconcile
```

---

## 📊 Sample Output

```json
{
  "missing": [],
  "late": ["T2"],
  "duplicates": ["T5"],
  "rounding": ["T4"],
  "difference": 0.01,
  "note": "Duplicate settlements excluded from total calculation"
}
```

---

## 🧪 Test Cases Covered

* ✔ Perfect match scenario
* ✔ Late settlement (next month)
* ✔ Duplicate settlement entries
* ✔ Rounding mismatch
* ✔ Missing settlement
* ✔ Refund without original transaction

---

## 🧠 Assumptions

* Transactions and settlements are matched using `transaction_id`
* Settlement delay can be up to **1–2 days**
* Rounding tolerance: **±0.01**
* All data is in a **single currency**
* Duplicate settlements may occur due to system issues

---

## ⚠️ Limitations

* Does not handle **partial settlements**
* Assumes **consistent transaction IDs**
* No support for **currency conversion**
* Uses **in-memory data** (no database)

---

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-repo-name.git
```

2. Navigate to project:

```bash
cd your-repo-name
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Open in browser:

```bash
http://localhost:8080/api/reconcile
```

---

## 🎥 Demo

> A short demo video is included in the submission showing API execution and output.

---

## 💡 Key Highlights

* Focus on **real-world financial reconciliation**
* Designed for **clarity and correctness**
* Handles **edge cases explicitly**
* Built using **AI-assisted development approach**

---

## 👨‍💻 Author

**Parth**
B.Tech CSE — MIT ADT University
AI Native Engineer Candidate

---

## 📬 Contact

* Email: [your email]
* LinkedIn: [your link]

---

⭐ If you found this project useful, feel free to star the repository!
