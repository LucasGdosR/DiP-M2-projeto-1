# DEVin[House] · Módulo Back-End · Projeto 1
### **Nome do software:**
LABMedicine, referência ao LAB365, responsável pelo curso DEVinHouse.

### **Problema resolvido:**
Cadastro de pacientes, enfermeiros, e médicos em um hospital. Atualização de status de paciente conforme atendimento. Listagem dos usuários cadastrados com filtros opcionais.

### **Como executar:**
É um programa em Java puro. Basta baixar e rodar na sua IDE de preferência (IntelliJ, por exemplo), ou mesmo no terminal.

### **Possíveis melhorias:**
Máscaras / regex para validação de entrada de CPF e Telefone.

### **Técnicas e tecnologias utilizadas:**
Foi tudo feito em Java puro no Intellij IDEA, sem frameworks. Aproveitei o projeto para exercitar alguns conceitos, especificamente os design patterns **MVC**, **Composite**, e **Factory**, os princípios **SOLID**, o uso de classes abstratas e **herança**, o uso de **Generics**, e a técnica de **injeção de dependência**. Vamos por partes:
- MVC: o programa foi separado nos packages model, view, controller, e repository. Tudo referente a exibição e seleção de menus está em view; tudo referente às entidades está em model; o armazenamento das entidades está em repository; por fim, o controller é responsável por pegar dados do usuário e salvá-los no repository, assim como resgatar dados do repository.
- Composite: a classe abstrata Menu possui uma descrição, que é um texto a ser exibido, assim como um ponteiro para seu menu pai, formando um grafo. Os CompositeMenu tem uma lista de ponteiros para seus submenus, o que permite a exploração de um menu para outro e de volta. Além da estrutura de navegação, o padrão é utilizado para os CompositeMenus mostrarem sua descrição, seus submenus, e permitirem a captura do destino, enquanto que os LeafMenus passam um comando para o controller, e posteriormente mostram seu CompositeMenu pai.
- Factory: o MainMenuFactory é quem sabe como montar o menu a partir de todas as classes de menus existente. Ele recebe um controller, e passa ele para todos os menus.
- SOLID:
    - _S_: aplicado com a separação em MVC;
    - _O_: aplicado em código sem "if", "switch", etc, permitindo a extensão de novos menus criando mais classes de CompositeMenu/LeafMenu, inserindo novos métodos no controller, novas entidades no model;
    - _L_: a estrutura de herança entre Person e as entidades permite a substituição sem sobrescrita de métodos, assim como entre Menu e os menus;
    - _I_: não foram utilizadas interfaces, mas sim classes abstratas com alguns métodos abstratos. Todos foram implementados e utilizados;
    - _D_: foi utilizada agregação. Os repositórios são construídos no método Main e passados para o controller por injeção, enquanto o controller é passado por injeção para a factory. O baixo acoplamento permite uma fácil mudança de implementação.
- Herança: utilizada tanto nas entidades, que herdam de Person, e também de Worker, quanto nos menus, que herdam de CompositeMenu ou LeafMenu.
- Generics: foi feito uma única classe de repositório que recebe qualquer classe que estenda Person, que pode armazenar quaisquer entidades do modelo.
- Injeção de dependência: conforme _D_ do SOLID.

### Vídeo de demonstração:
https://drive.google.com/file/d/1Jnul_1NybW6bD7dLO0DfnXehlp0JV3vJ/view?usp=sharing

#### Estrutura dos menus:
![Blank board](https://user-images.githubusercontent.com/109366863/222175788-63a74f2c-7b39-4616-b771-9e88d07547ab.png)
