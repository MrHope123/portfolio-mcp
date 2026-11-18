package dev.fulufhelo.portfoliomcp.tools;

import dev.fulufhelo.portfoliomcp.data.PortfolioData;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * MCP tools exposed to AI agents.
 * Each method becomes one callable tool.
 */
@Component
public class PortfolioTools {

    private final PortfolioData data;

    public PortfolioTools(PortfolioData data) {
        this.data = data;
    }

    @Tool(description = "Get Fulufhelo Maluleke's profile: name, title, location, email, GitHub and summary.")
    public PortfolioData.Profile getProfile() {
        return data.getProfile();
    }

    @Tool(description = "Get Fulufhelo's work experience, responsibilities and employment history.")
    public List<PortfolioData.Experience> getExperience() {
        return data.getExperience();
    }

    @Tool(description = "Get all of Fulufhelo's projects — both FNB enterprise projects and personal public projects. Includes tech stack and descriptions.")
    public List<PortfolioData.Project> getProjects() {
        return data.getProjects();
    }

    @Tool(description = "Get Fulufhelo's skills grouped by category: programming, back end, front end, databases, testing, tools, AI integration.")
    public List<PortfolioData.SkillCategory> getSkills() {
        return data.getSkills();
    }

    @Tool(description = "Get Fulufhelo's education: qualification, institution, years and specialisation.")
    public PortfolioData.Education getEducation() {
        return data.getEducation();
    }

    @Tool(description = "Get Fulufhelo's contact details: email address and GitHub profile URL.")
    public String getContact() {
        var profile = data.getProfile();
        return "Email: " + profile.email() + "\nGitHub: " + profile.github();
    }

    @Tool(description = "Search Fulufhelo's portfolio for a keyword. Returns matching projects, skills and experience entries. Use this to answer questions like 'does he know Docker?' or 'has he worked with PostgreSQL?'")
    public String search(@ToolParam(description = "The keyword or technology to search for") String keyword) {
        String lower = keyword.toLowerCase();
        StringBuilder result = new StringBuilder();

        // Search projects
        List<PortfolioData.Project> matchingProjects = data.getProjects().stream()
            .filter(p -> p.name().toLowerCase().contains(lower)
                || p.description().toLowerCase().contains(lower)
                || p.stack().stream().anyMatch(s -> s.toLowerCase().contains(lower)))
            .collect(Collectors.toList());

        if (!matchingProjects.isEmpty()) {
            result.append("Projects matching \"").append(keyword).append("\":\n");
            matchingProjects.forEach(p ->
                result.append("- ").append(p.name()).append(": ").append(p.description()).append("\n")
            );
        }

        // Search skills
        List<PortfolioData.SkillCategory> matchingSkills = data.getSkills().stream()
            .filter(cat -> cat.category().toLowerCase().contains(lower)
                || cat.skills().stream().anyMatch(s -> s.toLowerCase().contains(lower)))
            .collect(Collectors.toList());

        if (!matchingSkills.isEmpty()) {
            result.append("\nSkill categories matching \"").append(keyword).append("\":\n");
            matchingSkills.forEach(cat ->
                result.append("- ").append(cat.category()).append(": ")
                    .append(String.join(", ", cat.skills())).append("\n")
            );
        }

        // Search experience
        boolean experienceMatch = data.getExperience().stream()
            .anyMatch(e -> e.responsibilities().stream()
                .anyMatch(r -> r.toLowerCase().contains(lower)));

        if (experienceMatch) {
            result.append("\nAlso mentioned in work experience at FNB.\n");
        }

        return result.isEmpty()
            ? "No results found for \"" + keyword + "\" in Fulufhelo's portfolio."
            : result.toString().trim();
    }
}
