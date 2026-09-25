# 📂 File Persistence Manager (Java NIO & NIO.2)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

Uma solução modular e eficiente em Java para gerenciamento e persistência de dados em arquivos de texto (`.csv`), explorando tanto a API clássica **Java NIO (Channels & Buffers)** quanto a moderna **Java NIO.2 (`java.nio.file.Files`)**.

---

## 🚀 Funcionalidades

O projeto define uma abstração robusta através da interface `FilePersistence`, permitindo operações completas de manipulação de dados baseadas em strings e sentenças:

* **Escrita (`write`):** Adiciona novos registros ao arquivo de forma incremental.
* **Remoção (`remove`):** Remove linhas ou registros com base em um termo de busca.
* **Substituição (`replace`):** Atualiza um conteúdo antigo por um novo registro especificado.
* **Leitura Geral (`findAll`):** Retorna todo o conteúdo armazenado no arquivo.
* **Busca Específica (`findBy`):** Filtra e retorna linhas que correspondam à sentença informada.

---

## 🛠️ Estrutura do Código

O projeto separa contratos, implementações de E/S e a classe de execução:

```text
src/
└── com/
    └── myproject/
        ├── Main.java                        # Classe principal para execução e testes
        └── persistence/
            ├── FilePersistence.java         # Interface com as operações de contrato
            ├── NIOFilePersistence.java      # Implementação utilizando Java NIO (Channels/Buffers)
            └── NIO2FilePersistence.java     # Implementação utilizando Java NIO.2 (Files API)
```

### Exemplo de Estrutura de Dados (`user.csv`)

Os dados são estruturados no formato CSV (delimitados por ponto e vírgula):

```csv
Antonio;antonio@antonio.com;22/04/1973;
Lucas;lucas@lucas.com;08/12/1983;
George;george@george.com;21/05/1964;
Joao;joao@joao.com;03/09/1959;
Ana;ana@ana.com;18/10/1988;
```

---

## 💻 Demonstração de Uso

A classe `Main` demonstra o ciclo de vida da persistência, executando operações sequenciais de inserção, listagem, filtros e substituições:

```java
// Instanciação da persistência (ex: utilizando NIOFilePersistence)
FilePersistence persistence = new NIOFilePersistence("user.csv");

// Inserção de registros
persistence.write("Edson;edson@edson.com;26/08/1973;");
persistence.write("Maria;maria@edsomaria.com;12/01/1986;");

// Leitura completa de todos os registros
System.out.println(persistence.findAll());

// Buscas específicas por fragmentos
System.out.println(persistence.findBy("@luca"));

// Remoção e Substituição de dados
persistence.remove(";maria");
persistence.replace("26/08/", "Antonio;antonio@antonio.com;22/04/1973;");
```

---

## 🛠️ Pré-requisitos e Execução

Para rodar este projeto localmente, você precisará de:

* **Java JDK 11** ou superior instalado.
* Um terminal ou sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).

### Passos para execução:

1. Clone o repositório:
   
   ```bash
   git clone [https://github.com/enfarias/file-persistence-manager.git](https://github.com/enfarias/file-persistence-manager.git)
   ```
   
2. Navegue até o diretório do projeto e compile as classes:
   
   ```bash
   javac com/myproject/Main.java com/myproject/persistence/*.java
   ```
   
3. Execute o programa:
   
   ```bash
   java com.myproject.Main
   ```

---

Feito com ☕ por [Edson](https://github.com/enfarias).
