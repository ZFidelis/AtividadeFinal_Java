# AtividadeFinal_Java
Os alunos de Engenharia de Software foram desafiados a produzir uma aplicação em Java que utilize conceitos de orientação a objetos, tratamento de exceções, leitura e gravação de arquivos, e controle de versão com Git. O trabalho vale 5 pontos e é de tema livre. a equipe escolheu o tema de "Plataforma de Cursos online", com ajuda do ChatGPT, pois a equipe estava muito indecisa sobre qual tema escolher. Os dados serão guardados em aquivos .txt.

## Instruções de Execução
Ao iniciar o código ele irá pergutar se você gostaria de fazer login, criar conta, se esqueceu a senha ou se gostaria de sair. Ao clicar em "criar conta" você pode criar sua conta, selecionando o tipo de usuário e inserindo seus dados. Logo em seguida você pode fazer login. Após o login você pode seguir para 3 diferentes telas dependendo de seu usuário:

#### Menu Aluno:
No menu do aluno é possível se inscrever em um curso e ver os cursos em que está inscrito.

#### Menu Professor:
No menu do professor é possível cadastrar novos curso, ver os cursos que está lecionando, alterar seus dados como nome e senha e sair.

#### Menu Administrador:
No menu do administrador é possível excluir um curso, um aluno ou um professor, entrar no menu de professor e aluno, alterar os próprios dados como nome, senha e nivel de acesso e alterar todos os dados de aluno

## Classes
Existem 5 classes, a classe "Curso", a classe abstarata "Usuario", 3 classes que herdam usuario, "Aluno", "Professor" e "Administrador". as classes serão explicadas abaixo.
#### Curso:
Possui o método dadosCurso() que retorna titulo + descricao + nome do professor, adicionarAluno() que adiciona um aluno, mostrarAluno() que mostra os alunos no curso, um toString, um fromString e 5 Atributos:
- String titulo
- String descricao
- Int duracao
- String nomeProfessor
- ArrayList< Aluno > alunosInscritos

#### Usuario:
É possível criar 3 tipos de usuário, "Professor", "Aluno" e "Administrador".

Possui o método dadosUsuario() que retorna nome + email + senha, um toString e 3 Atributos:
- String nome
- String email
- String senha

#### Aluno:
Os alunos podem entrar em um curso e verificar os seus cursos.

Herda usuario, possui o método dadosAluno() que retorna super.dadosUsuario() + matricula, o método entrarCurso(String curso) que permite o aluno entrar em um curso, um toString, um fromString e 1 Atributo:
- Int matricula

#### Professor:
Os professores podem criar um curso, ver os cursos que ele leciona e mudar seus dados como nome e senha.

Herda usuario, possui o método dadosProfessor() que retorna super.dadosUsuario() + registro, o método criarCurso() que cria um curso, os métodos alterarNome(String novoNome), alterarSenha(String novaSenha) que permitem o professor a alterar nome e senha respectivamente, um toString, um fromString e 1 Atributo:
- Int registro

#### Administrador:
O administrador pode excluir cursos, alunos ou professores, acessar os outros dois menus, alterar seus dados como nome e senha e alterar dados de alunos.

Herda usuario, possui o método dadosAdministrador() que retorna super.dadosUsuario() + nivelAcesso, os métodos removerCurso(), removerAluno() e removerProfessor() que deletam curso, aluno e professor respectivamente, os métodos alterarNome(String novoNome), alterarSenha(String novaSenha) e alterarNivelAcesso(int novoRegistro) que permitem o administrador a alterar nome senha e nivel de acesso respectivamente, alterarDadosAluno() para alterar os dados de aluno, um toString, um fromString e 1 Atributo:
- Int nivelAcesso
