# Calculadora Digital Android

## Descrição
Aplicativo Android de calculadora com sistema de autenticação. O projeto implementa uma calculadora funcional com interface de login para controle de acesso.

![preview profile.](https://imgur.com/lugQQY5.png)


### Calculadora em Funcionamento
![Demo da Calculadora](Demo.gif)

## Funcionalidades

### Tela de Login (MainActivity)
- **Autenticação** com usuário e senha
- **Validação de credenciais** em tempo real
- **Interface limpa e intuitiva** com campos de entrada
- **Tratamento de erros** com mensagens informativas
- **Botão cancelar** para limpar os campos

**Credenciais padrão:**
- Usuário: `admin`
- Senha: `admin`

### Calculadora (SecondActivity)
- **Operações básicas**: adição (+), subtração (-), multiplicação (×), divisão (÷)
- **Operação de porcentagem** (%)
- **Display digital** com formatação automática
- **Botões numéricos** (0-9) com entrada responsiva
- **Ponto decimal** para números fracionários
- **Função Clear (C)** para limpar completamente
- **Função Delete (DEL)** para apagar último dígito
- **Botão de saída** para retornar à tela principal


## Tecnologias Utilizadas
```
- Android SDK
- Java como linguagem principal
- ConstraintLayout para layouts responsivos
- Material Design para componentes de UI
```

## Estrutura do Projeto

```
calculator_project/
├── MainActivity.java          # Tela de login e autenticação
├── SecondActivity.java        # Calculadora principal
├── res/layout/
│   ├── activity_main.xml      # Layout da tela de login
│   └── activity_second.xml    # Layout da calculadora
└── AndroidManifest.xml
```
### Personalizar Cores
As cores podem ser alteradas nos arquivos XML de layout:
- Botões de operação: `#FF9800` (laranja)
- Botões numéricos: `#504A4A` (cinza escuro)
- Botões de controle: `#B3B3B3` (cinza claro)

## Licença
Este projeto é desenvolvido para fins educacionais e está disponível sob licença MIT.

## Autores

| **Larissa Garcia** | **Amanda Errera** |
|:------------------:|:-----------------:|
| ![preview profile.](https://imgur.com/HC7cm66.png) | ![preview profile.](https://imgur.com/KXXBWuN.png) |
| [GitHub](https://github.com/EuLarissaGarcia) | [GitHub](https://github.com/Amanyti) |
| [LinkedIn](https://www.linkedin.com/in/eularissagarcia) | [LinkedIn](https://www.linkedin.com/in/amanda-errera-de-queiroz/) |

**Versão:** 1.0  
**Compatibilidade:** Android 5.0+ (API 21+)  
**Linguagem:** Java  
**IDE Recomendada:** Android Studio
