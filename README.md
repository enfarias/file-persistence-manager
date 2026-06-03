# 📂 File Persistence Manager (Java NIO)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

Uma solução modular e eficiente em Java para gerenciamento e persistência de dados em arquivos de texto (`.csv`), utilizando a API **Java NIO (New I/O)** para manipulação de arquivos de forma otimizada.

---

## 🚀 Funcionalidades

O projeto define uma abstração para persistência de dados em arquivos (`FilePersistence`), permitindo operações completas de CRUD baseadas em strings/sentenças:

* **Escrita (`write`):** Adiciona novos registros ao arquivo de forma incremental.
* **Remoção (`remove`):** Remove linhas ou registros com base em um termo de busca.
* **Substituição (`replace`):** Atualiza um conteúdo antigo por um novo registro especificado.
* **Leitura Geral (`findAll`):** Retorna todo o conteúdo armazenado no arquivo.
* **Busca Específica (`findBy`):** Filtra e retorna linhas que correspondam à sentença informada.

---

## 🛠️ Estrutura do Código

O projeto está dividido em pacotes que separam a lógica de abstração da implementação prática:

```text
src/
└── com/
    └── myproject/
        ├── Main.java                        # Classe principal para execução e testes
        └── persistence/
            ├── FilePersistence.java         # Interface com as operações de contrato
            └── NIOFilePersistence.java      # Implementação utilizando java.nio
```
### Exemplo de Estrutura de Dados (`user.csv`)

Os dados são gerenciados e persistidos no formato delimitado por ponto e vírgula dentro do diretório `managedFiles/NIO/`:

```csv
Antonio;antonio@antonio.com;22/04/1973;
Lucas;lucas@lucas.com;08/12/1983;
George;george@george.com;21/05/1964;
Joao;joao@joao.com;03/09/1959;
Ana;ana@ana.com;18/10/1988;
```

---

## 💻 Demonstração de Uso

A classe `Main` demonstra o ciclo de vida da manipulação do arquivo, executando operações sequenciais de inserção, busca, deleção e atualização:

```java
// Instanciação da persistência apontando para o arquivo desejado
FilePersistence persistence = new NIOFilePersistence("user.csv");

// Inserção de dados
persistence.write("Edson;edson@edson.com;26/08/1973;");

// Busca por fragmentos de texto
persistence.findBy("rge@");

// Remoção baseada em sentença
persistence.remove(";maria");

// Atualização de conteúdo existente
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
   git clone [https://github.com/enfarias/get-started.git](https://github.com/enfarias/get-started.git)
   ```
   
3. Navegue até o diretório do projeto e compile as classes:
   
   ```bash
   javac com/myproject/Main.java com/myproject/persistence/*.java
   ```
   
5. Execute o programa:
   
```bash
java com.myproject.Main
```

---

Feito com ☕ por [Edson](https://github.com/enfarias).
