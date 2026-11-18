package dev.fulufhelo.portfoliomcp.config;

import dev.fulufhelo.portfoliomcp.tools.PortfolioTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider portfolioToolCallbackProvider(PortfolioTools tools) {
        return MethodToolCallbackProvider.builder()
            .toolObjects(tools)
            .build();
    }
}
