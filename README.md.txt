# 🐕 Concurso de Perros Java

A desktop application built with Java Swing for managing a dog show competition. Allows registering, editing, deleting, sorting, and visualizing dogs with their data and scores.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-007396?style=flat&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=flat&logo=apache-netbeans-ide&logoColor=white)
![Ant](https://img.shields.io/badge/Apache%20Ant-A81C7D?style=flat&logo=apache&logoColor=white)

---

## 📸 Features

- 📋 Display dog list in an interactive table
- ➕ Register new dogs with name, breed, age, score, and image
- ✏️ Edit existing dog data via dialog
- ❌ Delete dogs from the competition
- 🔍 Search dogs by name
- 📊 Sort by name, breed, age, or score
- 🃏 Info cards showing top scorer, lowest scorer, oldest dog, and total count
- 💾 Data persistence using Java Properties file

---

## 🛠 Tech Stack

- **Language:** Java 17+
- **UI:** Java Swing with custom `paintComponent` rendering
- **Layout:** GridBagLayout, GridLayout, BorderLayout, BoxLayout
- **Persistence:** Java `Properties` + `FileInputStream` / `FileOutputStream`
- **Pattern:** DAO (Data Access Object) + MVC separation
- **Build tool:** Apache Ant
- **Version control:** Git + GitHub Actions CI/CD

---

## 📁 Project Structure

```
src/
├── com.aplication.concursoCanino.Logica/
│   ├── Perro.java              # Domain model
│   └── PerroImplements.java    # Business logic & file persistence
└── com.aplication.concursoCanino.interfaces/
    ├── InterfazPrincipal.java  # Main JFrame, app coordinator
    ├── PanelTablaPerros.java   # Dog list table panel
    ├── PanelDatosPerros.java   # Dog detail panel
    ├── PanelFormulario.java    # Add dog form panel
    ├── PanelBotonesOrdenamientos.java  # Sort buttons panel
    ├── PanelCardsInformativas.java     # Info cards container
    └── Cards.java              # Custom info card component
data/
└── perros.txt                  # Properties file with dog data
```

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 17 or higher
- Apache NetBeans (recommended) or any Java IDE
- Apache Ant

### Running the project

1. Clone the repository:
```bash
git clone https://github.com/sebas731/Concurso_de_Perros_Java.git
```

2. Open the project in NetBeans

3. Make sure the `data/` folder exists with `perros.txt` inside

4. Run `InterfazPrincipal.java`

---

## 💡 Key Concepts Applied

- Object-Oriented Programming (encapsulation, inheritance, polymorphism)
- DAO pattern separating business logic from UI
- Custom Swing rendering with `paintComponent` and `Graphics2D`
- Lambda expressions for sorting collections
- Exception handling with try/catch/finally and try-with-resources
- File I/O with `Properties`, `FileInputStream`, `FileOutputStream`
- Event-driven programming with `ActionListener`, `FocusListener`, `ListSelectionListener`

---

## 👤 Author

**Sebastian Mamani**
- GitHub: [@sebas731](https://github.com/sebas731)
- LinkedIn: [sebastian-guillermo-mamani-guillen](https://linkedin.com/in/sebastian-guillermo-mamani-guillen-9327901bb)