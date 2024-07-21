package com.catherine.my.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.catherine.my.game.visitor.NodeVisitor;
import com.catherine.my.game.visitor.OutputNodeVisitor;

/**
 * Configuration class for com.catherine.my.game.visitor components.
 * This class defines the beans related to node visitors in the application.
 */
@Configuration
public class VisitorConfig {

    /**
     * Creates and returns a {@link NodeVisitor} bean.
     * The {@link NodeVisitor} provided by this method is an instance of {@link OutputNodeVisitor},
     * which likely performs some specific formatting or processing of nodes.
     *
     * @return the {@link NodeVisitor} that handles the output processing of nodes
     */
    @Bean
    public NodeVisitor visitor() {
        return new OutputNodeVisitor();
    }
}

