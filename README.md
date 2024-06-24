# AtividadeFinal_Java
Os alunos de Engenharia de Software foram desafiados a produzir uma aplicação em Java que utilize conceitos de orientação a objetos, tratamento de exceções, leitura e gravação de arquivos, e controle de versão com Git. O trabalho vale 5 pontos e é de tema livre, a equipe decidiu fazer sobre o tema de Plataforma de Cursos online, onde é possível criar 3 tipos de usuário, "Professor", "Aluno" e "Administrador". Os alunos podem entrar em um curso e verificar os seus cursos. Os professores podem criar um curso, ver os cursos que ele leciona e mudar seus dados como nome e senha. O administrador pode excluir cursos, alunos ou professores, acessar os outros dois menus, alterar seus dados como nome e senha e alterar dados de alunos. Os dados serão guardados em aquivos .txt.

## Classes
Existem 5 classes, a classe "Curso", a classe abstarata "Usuario", 3 classes que herdam usuario, "Aluno", "Professor" e "Administrador". as classes serão explicadas abaixo.
#### Curso:
Possui o método dadosCurso() que retorna titulo + descricao + nome do professor, adicionarAluno() que adiciona um aluno, mostrarAluno() que mostra os alunos no curso, um toString, um fromString e 5 Atributos:
- titulo
- descricao
- duracao
- nomeProfessor
- ArrayList< Aluno > alunosInscritos

#### Usuario:
Possui o método dadosUsuario() que retorna nome + email + senha, um toString e 3 Atributos:
- nome
- email
- senha

#### Aluno:
Herda usuario, possui o método dadosAluno() que retorna super.dadosUsuario() + matricula, o método entrarCurso(String curso) que permite o aluno entrar em um curso, um toString, um fromString e 1 Atributo:
- matricula

#### Professor:
Herda usuario, possui o método dadosProfessor() que retorna super.dadosUsuario() + registro, o método criarCurso() que cria um curso, os métodos alterarNome(String novoNome), alterarSenha(String novaSenha) e alterarRegistro(int novoRegistro) que permitem o professor a alterar nome senha e registro respectivamente, um toString, um fromString e 1 Atributo:
- registro

#### Administrador:
Herda usuario, possui o método dadosAdministrador() que retorna super.dadosUsuario() + nivelAcesso, os métodos removerCurso(), removerAluno() e removerProfessor() que deletam curso, aluno e professor respectivamente, os métodos alterarNome(String novoNome), alterarSenha(String novaSenha) e alterarNivelAcesso(int novoRegistro) que permitem o administrador a alterar nome senha e nivel de acesso respectivamente, alterarDadosAluno() para alterar os dados de aluno, um toString, um fromString e 1 Atributo:
- nivelAcesso
