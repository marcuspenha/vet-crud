# Sistema de Gerenciamento - Clínica Veterinária PetAnimal

**Disciplina:** Introdução à Orientação a Objetos e Estrutura de Dados
**Instituição:** UNINASSAU
**Professor:** Antonio Araújo Rodrigues

---

## Sobre o Projeto

Este repositório contém o código-fonte de um sistema CRUD (Create, Read, Update, Delete) desenvolvido em Java. O projeto foi elaborado como requisito avaliativo parcial, com o objetivo de aplicar os quatro pilares fundamentais da Programação Orientada a Objetos (POO): Abstração, Encapsulamento, Herança e Polimorfismo.

O software simula o fluxo de gerenciamento de uma clínica veterinária, permitindo o cadastro e manipulação de dados de proprietários, animais, veterinários e consultas. A aplicação é executada via console e utiliza estruturas de dados em memória (`ArrayList`) para a persistência temporária das informações, dispensando o uso de banco de dados relacional conforme especificado nos requisitos do trabalho.

---

## Funcionalidades Implementadas

O sistema oferece um menu interativo no console que permite a execução das seguintes operações:

### 1. Cadastro (Create)
* **Proprietários:** Registro de clientes contendo nome e telefone.
* **Veterinários:** Registro de profissionais contendo nome, telefone e CRMV.
* **Animais:** Registro de pets (subdivididos em classes `Cachorro` e `Gato`), associados obrigatoriamente a um proprietário previamente cadastrado.
* **Consultas:** Agendamento de atendimentos vinculando um animal, um veterinário, data, horário e descrição do motivo.

### 2. Leitura (Read)
* **Listagem de Animais:** Exibição de todos os animais cadastrados, incluindo dados do proprietário e demonstração do polimorfismo sonoro.
* **Listagem de Consultas:** Relatório detalhado de todos os agendamentos futuros.

### 3. Atualização (Update)
* Permite a busca de um animal pelo nome e a alteração de seus atributos (nome e idade).

### 4. Remoção (Delete)
* Permite a exclusão lógica de um registro de animal do sistema.

---

## Arquitetura e Pilares da POO

O desenvolvimento do código seguiu estritamente os conceitos de POO exigidos:

* **Abstração:** Implementada através da classe base `Animal`, que define a estrutura genérica dos pets e impede a instância de objetos indefinidos.
* **Encapsulamento:** Todos os atributos das classes de modelo (`Proprietario`, `Veterinario`, `Consulta`, `Animal`) são privados (`private`), sendo acessados e modificados exclusivamente através de métodos públicos (`getters` e `setters`).
* **Herança:** As classes `Cachorro` e `Gato` estendem a superclasse `Animal`, herdando seus comportamentos e atributos base.
* **Polimorfismo:** Evidenciado no método abstrato `emitirSom()`, que possui implementações distintas nas subclasses `Cachorro` e `Gato`, permitindo tratamento uniforme de objetos distintos.

---

## Tecnologias Utilizadas

* **Linguagem de Programação:** Java (JDK 8 ou superior).
* **Ambiente de Desenvolvimento:** Compatível com IntelliJ IDEA, Eclipse ou VS Code.
* **Bibliotecas Padrão:** `java.util` (Scanner, ArrayList, List).

---

## Estrutura do Projeto

A organização dos pacotes e classes segue a seguinte hierarquia:

```text
src/
└── br/com/clinicapet/
    ├── ClinicaPetMain.java   // Classe principal (Entry Point e lógica de Menu)
    ├── Animal.java           // Superclasse Abstrata
    ├── Cachorro.java         // Subclasse (Model)
    ├── Gato.java             // Subclasse (Model)
    ├── Proprietario.java     // Classe de Modelo
    ├── Veterinario.java      // Classe de Modelo
    └── Consulta.java         // Classe de Modelo (Associação)
