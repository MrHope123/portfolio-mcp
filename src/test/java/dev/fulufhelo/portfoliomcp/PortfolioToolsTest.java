package dev.fulufhelo.portfoliomcp;

import dev.fulufhelo.portfoliomcp.data.PortfolioData;
import dev.fulufhelo.portfoliomcp.tools.PortfolioTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PortfolioToolsTest {

    @Autowired
    private PortfolioTools tools;

    @Test
    void profileReturnsCorrectName() {
        assertThat(tools.getProfile().name()).isEqualTo("Fulufhelo Maluleke");
    }

    @Test
    void experienceIsNotEmpty() {
        assertThat(tools.getExperience()).isNotEmpty();
    }

    @Test
    void projectsIncludesBankingApi() {
        assertThat(tools.getProjects())
            .anyMatch(p -> p.name().contains("Banking"));
    }

    @Test
    void skillsIncludesJava() {
        assertThat(tools.getSkills())
            .flatExtracting(PortfolioData.SkillCategory::skills)
            .anyMatch(s -> s.toLowerCase().contains("java"));
    }

    @Test
    void searchFindsDocker() {
        String result = tools.search("Docker");
        assertThat(result).containsIgnoringCase("docker");
    }

    @Test
    void searchReturnsNotFoundForGibberish() {
        String result = tools.search("xyzabc123notreal");
        assertThat(result).containsIgnoringCase("No results found");
    }
}
