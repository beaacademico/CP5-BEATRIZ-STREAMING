# 🎵 CHECKPOINT 5 — Sistema de Streaming de Música (Versão 5.0)

## 📌 Sobre o Projeto

Este projeto foi desenvolvido para o **Checkpoint 5** da disciplina de **Programação Orientada a Objetos em Java**.

A proposta consiste na criação de um **Sistema de Streaming de Música**, aplicando os principais conceitos de **POO**, com foco em:

- Polimorfismo
- Herança
- Sobrescrita de métodos (`@Override`)
- Casting
- `instanceof`
- Encapsulamento
- Listas polimórficas (`ArrayList`)
- Organização em múltiplas classes

---

## 👩‍💻 Aluna

**Beatriz Gonçalves da Silva**

---

## 🎯 Objetivo Acadêmico

Simular uma plataforma de streaming semelhante a Spotify / Deezer, permitindo o gerenciamento de usuários, reprodução de músicas e playlists automáticas.

---

# 🚀 Funcionalidades Implementadas

## 👤 Sistema Multiusuário

- Cadastro de usuários Free
- Cadastro de usuários Premium
- Login entre usuários cadastrados
- Listagem de contas criadas

---

## 🎵 Reprodução de Música

- Catálogo inicial com músicas cadastradas
- Reprodução individual
- Contagem total de reproduções
- Contagem por usuário

---

## 💎 Tipos de Conta

### Usuário Free

- Reprodução normal
- Exibição de anúncios a cada 3 músicas

### Usuário Premium

- Reprodução em alta qualidade
- Download de músicas
- Plano:
  - Mensal
  - Anual
  - Familiar

---

## 📂 Sistema de Playlists

### Playlist Personalizada

Criada manualmente pelo usuário.

### Playlist Automática

Gerada automaticamente pelo sistema com critérios como:

- Top Hits
- Mais Tocadas
- Recentes
- Rock

---

## 📊 Estatísticas do Sistema

Exibe:

- Total de usuários
- Quantidade Free
- Quantidade Premium
- Total de reproduções

---

# 🧠 Conceitos de Programação Utilizados

## 🔄 Polimorfismo

```java
Usuario usuario = new UsuarioPremium(...);
usuario.reproduzirMusica(musica);
