# Autentication
A API desenvolvida teve por objetivo criar uma lógica para que as senhas criadas pelos usuários não sejam salvas no banco de dados de uma maneira que, caso ocorram violações de segurança, as senhas não estejam desprotegidas.

Dessa forma, utilizei do Spring Security, mais precisamente da interface 'PasswordEncoder' e  do método 'encoder'. Partindo da inserção dos atributos obrigatórios da classe 'User', e utilizando do Postman para as simulações, configurei o método para 'PostMapping' com o caminho '/insert'. Ao ser passada uma senha o método 'setPassword' é convocado e dentro dele é passado o 'encode' que realiza a codificação da senha. Quando o usuário é inserido no banco de dados a senha é salva na coluna 'password' estando criptografada e ao ser realizada a chamada deste usuário a visualização de sua senha original não é possível. 

## :camera_flash: /insert
<!-- You can add more screenshots here if you like -->
<img src="https://github.com/adelmoGama/autentication/blob/main/autentication.photos/insert.jpg" width="400">&emsp;
<img src="https://github.com/adelmoGama/autentication/blob/main/autentication.photos/findAll.jpg" width="400">&emsp;

Concluindo, para um possível 'Login' foi criado o método 'autentication' que consulta e verifica se o usuário chamado existe, primeiro verifica o email (um atributo com anotação '@unique=true' que não permite a repetição do valor) e depois utilizando do método 'matches' que compara a senha passada como 'tentaviva' com a que existe no banco. Sendo assim, é retornando um 'HttpStatus' de 'OK' para a igualdade ou de 'UNAUTHORIZED' para a não igualdade.

## :camera_flash: /autentication
<!-- You can add more screenshots here if you like -->
<img src="https://github.com/adelmoGama/autentication/blob/main/autentication.photos/autenticationTrue.jpg" width="400">&emsp;
<img src="https://github.com/adelmoGama/autentication/blob/main/autentication.photos/autenticationFalse.jpg" width="400">&emsp;

## Tecnologias
* JavaSE - 17
* Spring Boot
* Spring Security
* Maven
* JPA / Hibernate
* MySQL
* Tomcat
* Postman



### TODO
- Continuar estudando e aprender a utilizar da 'JWT' e incrementar ao projeto as suas funcionalidades

## Author
José Adelmo Gama Neto (follow me on [linkedin](https://www.linkedin.com/in/josé-adelmo-gama-neto-38091a22a))

## License
```
The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
