package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import visitor.NodeVisitor;
import visitor.OutputNodeVisitor;

@Configuration
public class VisitorConfig {

    @Bean
    public NodeVisitor visitor() {
        return new OutputNodeVisitor();
    }
}
