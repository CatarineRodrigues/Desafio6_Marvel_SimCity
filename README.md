# Desafio6_Marvel_SimCity

Marvel chegou em SimCity

Dessa vez quem chegou em SimCity foram os personagens da Marvel para
fechar essa temporada com chave de ouro e para isso eles trouxeram
juntos um aplicativo de personagens! Seu objetivo como pessoa
desenvolvedora é proporcionar que os habitantes de SimCity possam logar
nesse aplicativo, realizar registro e implementar funções de validação e
testes dentro dessa aplicação garantindo um produto de qualidade para
todos da cidade.

Requisitos de negócio
1. Eu como usuária quero após ver a tela de splash da aplicação ver
uma tela de login;

2. Eu como usuária quero ver nessa tela de login:
a. campos para eu digitar: email e senha
b. ver um texto escrito "Crie sua conta agora"
c. ver um botão de login;

3. Eu como usuária ao realizar o login quero poder ser autenticada com
sucesso e ir para a tela de home, caso ocorra algum erro quero
receber um toast com uma mensagem de feedback sendo "não foi
possível realizar o login";

4. Eu como usuária que poder ter acesso a opção se sair da aplicação
atravém de um item de menu chamado "Sair" que ao clicar quero ser
deslogada do aplicativo e voltar para a tela de login;

5. Eu como usuária na tela de login ao clicar em "Crie sua conta agora"
quero ir para uma tela de registro que contenha os campos para eu
poder digitar:
a. nome
b. email
c. senha

E que contenha um botão "REGISTRAR CONTA" que ao clicar quero poder
ser autenticada com sucesso e ir para a tela de home, caso ocorra algum
erro quero receber um toast com uma mensagem de feedback sendo "não
foi possível realizar o registro";

6. Eu como usuária ao estar na tela de home quero ver uma
mensagem "Olá <addNomeDoUsuário> esses são alguns dos
personagens da Marvel"

7. Como regra de negócio quero verificar se existe validação para todos
os campos de login e registro sendo eles:
a. validação de email;
b. validação de senhas menos que 8 digitos
c. validação de nomes menores de 3 digitos

8. Como regra de negócio quero que a aplicação possua testes
unitários para todos os métodos de validação de email, senha e
nomes;

9. Como regra de negócio quero que a aplicação possua testes de ui
utilizando Espresso validando as ações de login e registros sendo
elas:
a. inserir email inválido e senha correta, deve mostrar erro.
b. inserir email válido e senha incorreta, deve mostrar erro.
c. inserir email válido e senha correta, deve navegar para home,
validar se nome de usuário está visivél
Observação: mesmos testes para tela de Login e Resistro.

10. Como regra de negócio quero a geração dos relatórios de cobertura
de testes usando o Code Coverage do Android.
