package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import strategy.*;

@Configuration
public class StrategyConfig {

    private final ApplicationContext applicationContext;

    @Autowired
    public StrategyConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public PlotChoiceStrategy helicopterStrategy() {
        return new HelicopterStrategy(applicationContext, dressUpWithoutFirstAidKitStrategy(), pickThingsUpWithFirstAidKitStrategy());
    }

    @Bean
    public PlotChoiceStrategy newsStrategy() {
        return new NewsStrategy(applicationContext, dressUpWithoutFirstAidKitStrategy(), pickThingsUpWithFirstAidKitStrategy());
    }

    @Bean
    public PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy() {
        return new DressUpWithoutFirstAidKitStrategy(applicationContext);
    }

    @Bean
    public PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy() {
        return new PickThingsUpWithFirstAidKitStrategy(applicationContext);
    }
}
