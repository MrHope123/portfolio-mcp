# portfolio-mcp

An MCP (Model Context Protocol) server that exposes my portfolio to AI agents.

Built with Java 21 and Spring Boot 3 — the same stack I used at FNB for Hexaro MCP.

## What it does

AI agents (Claude, Copilot, Cursor, etc.) can call these tools:

| Tool | Description |
|---|---|
| `getProfile` | Name, title, location, email, GitHub, summary |
| `getExperience` | Work history and responsibilities |
| `getProjects` | All projects — FNB enterprise and personal |
| `getSkills` | Skills grouped by category |
| `getEducation` | Qualification, institution, specialisation |
| `getContact` | Email and GitHub URL |
| `search` | Search the portfolio by keyword or technology |

## Run locally

```bash
./mvnw spring-boot:run
```

Server starts on `http://localhost:8080`.

MCP endpoint: `http://localhost:8080/mcp`

## Stack

- Java 21
- Spring Boot 3.4
- Spring AI MCP Server
- Maven
