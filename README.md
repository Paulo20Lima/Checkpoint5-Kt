# Fundamentos Jetpack Compose Listas Lazy
# Turma: 3SIR
## Alunos e RMs
- Paulo Henrique da Silva Lima - RM 552444  
- Pedro Ruvieri Cavariani - RM 551380


Este projeto é um aplicativo Android desenvolvido em Kotlin, utilizando Jetpack Compose para a construção de interfaces modernas e reativas. O objetivo principal é demonstrar o uso de listas Lazy (LazyColumn e LazyRow) para exibir e filtrar jogos favoritos por estúdio.

## Funcionalidades

- Exibição de uma lista de jogos favoritos.
- Filtro de jogos por nome do estúdio, via campo de texto ou seleção direta.
- Lista horizontal de estúdios (StudioCard) para filtro rápido.
- Botão de limpar filtro, exibido apenas quando um filtro está ativo.
- Interface moderna utilizando Material 3.

## Estrutura do Projeto

```
app/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   │   └── carreiras/com/github/fundamentos_jetpack_compose_listas_lazy/
 │   │   │        ├── MainActivity.kt         # Tela principal e lógica de UI
 │   │   │        ├── components/
 │   │   │        │    ├── GameCard.kt       # Componente visual para jogos
 │   │   │        │    └── StudioCard.kt     # Componente visual para estúdios
 │   │   │        ├── model/
 │   │   │        │    └── Game.kt           # Modelo de dados para jogos
 │   │   │        ├── repository/
 │   │   │        │    ├── GameRepository.kt # Funções de acesso e filtro de dados
 │   │   │        │    └── ...
 │   │   │        └── ui/theme/              # Temas e estilos
 │   │   └── res/                            # Recursos (layouts, strings, etc)
 │   └── ...
 └── ...
```

## Como funciona

- A tela principal exibe uma lista de jogos e uma lista horizontal de estúdios.
- O usuário pode filtrar os jogos digitando o nome do estúdio ou clicando em um StudioCard.
- O filtro pode ser limpo facilmente com o botão "Limpar filtro".

## Como rodar o projeto

1. Clone este repositório:
   ```sh
   git clone <url-do-repositorio>
   ```
2. Abra o projeto no Android Studio.
3. Execute em um emulador ou dispositivo físico Android.

## Tecnologias utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Gradle Kotlin DSL**

## Screenshots

<img width="277" height="607" alt="image" src="https://github.com/user-attachments/assets/a86253ed-6788-4735-b0d9-6c4059214751" />
<img width="282" height="619" alt="image" src="https://github.com/user-attachments/assets/d00cde70-d91d-4096-a132-278bd171f826" />
<img width="280" height="607" alt="image" src="https://github.com/user-attachments/assets/836b247c-083f-48ae-b8e3-44313cfa5f90" />



## Autores
- Desenvolvido por Ewerton Carreira e pelos alunos Paulo e Pedro.

---

Este projeto é um exemplo didático para estudos de Jetpack Compose e listas dinâmicas no Android.

