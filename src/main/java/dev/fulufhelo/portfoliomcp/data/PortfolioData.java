package dev.fulufhelo.portfoliomcp.data;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Static source of truth for all portfolio content.
 * Update this when your CV changes — the MCP tools read from here.
 */
@Component
public class PortfolioData {

    public Profile getProfile() {
        return new Profile(
            "Fulufhelo Maluleke",
            "Software Engineer",
            "Johannesburg, South Africa",
            "fulufhelomalulekefm@gmail.com",
            "https://github.com/MrHope123",
            "Software engineer with two years of experience developing and maintaining " +
            "banking applications with Java and Spring Boot at First National Bank. " +
            "Focused on secure REST APIs, automated testing, and working closely with DevOps to ship."
        );
    }

    public List<Experience> getExperience() {
        return List.of(
            new Experience(
                "Software Developer (ECM)",
                "First National Bank (FNB)",
                "October 2024",
                "October 2026",
                List.of(
                    "Wrote and maintained object-oriented Java code for an enterprise platform using Spring Boot.",
                    "Developed and supported REST APIs and integrations for document upload, retrieval and search.",
                    "Worked with PostgreSQL and MySQL, managing schema changes with Flyway and Liquibase.",
                    "Wrote and updated unit tests to confirm changes worked before release.",
                    "Monitored production behaviour using Splunk logs and fixed faults.",
                    "Migrated a legacy JBoss/WAR application to Spring Boot with javax-to-jakarta updates.",
                    "Used Git, Maven and Docker, working with DevOps on CI/CD pipelines."
                ),
                "Code is proprietary to FNB and not publicly available."
            )
        );
    }

    public List<Project> getProjects() {
        return List.of(
            new Project(
                "Hexaro Portal",
                "Content Management Admin Portal",
                "Built a React admin portal with a Spring Boot backend-for-frontend for file upload, " +
                "search, retrieval and metadata management.",
                List.of("Java 25", "Spring Boot 4", "React", "REST APIs"),
                null,
                true
            ),
            new Project(
                "TMS Self-Service",
                "Document Template Management",
                "Built a Spring Boot application to create, edit, download and generate PDF documents " +
                "from templates. Used PostgreSQL with Flyway migrations, Spring Security, Swagger/OpenAPI, and Docker.",
                List.of("Java", "Spring Boot", "PostgreSQL", "Flyway", "Spring Security", "Docker", "Swagger/OpenAPI"),
                null,
                true
            ),
            new Project(
                "Hexaro Hive",
                "Content Management REST API",
                "Developed REST API functionality for document upload, retrieval, search and updates. " +
                "Implemented file validation, document versioning and concurrency control with automated testing.",
                List.of("Java", "Spring Boot", "REST APIs", "JUnit"),
                null,
                true
            ),
            new Project(
                "Hexaro MCP",
                "AI Integration Microservice",
                "Built a Spring Boot microservice using the Model Context Protocol so AI agents can " +
                "search, fetch, upload and update enterprise content.",
                List.of("Java 25", "Spring AI", "Virtual Threads", "JSON-RPC", "Maven", "MCP"),
                null,
                true
            ),
            new Project(
                "DistributionService",
                "Legacy Java Migration",
                "Migrated a legacy JBoss/WAR application to Spring Boot JAR, moving javax to jakarta " +
                "annotations and updating the full unit test suite.",
                List.of("Java", "JBoss/WAR", "Spring Boot", "JUnit", "Maven"),
                null,
                true
            ),
            new Project(
                "Secure Banking API",
                "Personal Project — Public",
                "A Spring Boot REST API where customers sign up, log in, and move money between accounts. " +
                "Every customer can only access their own account. Enforced at the service layer with JWT auth. " +
                "80+ unit, controller and integration tests run on every PR in GitHub Actions.",
                List.of("Java 17", "Spring Boot 3", "Spring Security", "JWT", "Spring Data JPA", "Maven", "Docker", "GitHub Actions"),
                "https://github.com/MrHope123/MrHope_BankingApp",
                false
            )
        );
    }

    public List<SkillCategory> getSkills() {
        return List.of(
            new SkillCategory("Programming", List.of("Java (OOP)", "JavaScript", "Node.js")),
            new SkillCategory("Back End & APIs", List.of("Spring Boot", "Spring Security", "Spring Data JPA", "Hibernate", "REST APIs", "SOAP", "Swagger/OpenAPI")),
            new SkillCategory("Front End", List.of("React", "JavaScript", "HTML", "CSS")),
            new SkillCategory("Databases & SQL", List.of("SQL", "PostgreSQL", "MySQL", "Flyway", "Liquibase")),
            new SkillCategory("Testing & Reliability", List.of("JUnit", "Mockito", "Integration Testing", "Splunk")),
            new SkillCategory("Tools & Deployment", List.of("Git", "Maven", "Docker", "GitHub Actions", "Harness", "Bamboo", "OpenShift", "Rancher", "Jira", "Bitbucket")),
            new SkillCategory("AI Integration", List.of("Model Context Protocol (MCP)", "Spring AI", "AI-assisted development"))
        );
    }

    public Education getEducation() {
        return new Education(
            "Diploma in Computer Science",
            "Tshwane University of Technology",
            "2020",
            "2025",
            "Software Development"
        );
    }

    // ── Records ──────────────────────────────────────────────────────────────

    public record Profile(
        String name,
        String title,
        String location,
        String email,
        String github,
        String summary
    ) {}

    public record Experience(
        String role,
        String company,
        String startDate,
        String endDate,
        List<String> responsibilities,
        String note
    ) {}

    public record Project(
        String name,
        String subtitle,
        String description,
        List<String> stack,
        String githubUrl,
        boolean proprietary
    ) {}

    public record SkillCategory(
        String category,
        List<String> skills
    ) {}

    public record Education(
        String qualification,
        String institution,
        String startYear,
        String endYear,
        String specialisation
    ) {}
}
