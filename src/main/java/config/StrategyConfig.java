package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import strategy.*;

/**
 * This class provides configuration for the strategies used in the game.
 */
@Configuration
public class StrategyConfig {

    private final ApplicationContext applicationContext;

    /**
     * Constructs a new StrategyConfig with the specified application context.
     *
     * @param applicationContext the application context
     */
    @Autowired
    public StrategyConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Provides a bean of type PlotChoiceStrategy that represents the helicopter strategy.
     *
     * @return a new HelicopterStrategy
     */
    @Bean
    public PlotChoiceStrategy helicopterStrategy() {
        return new HelicopterStrategy(applicationContext, dressUpWithoutFirstAidKitStrategy(), pickThingsUpWithFirstAidKitStrategy());
    }

    /**
     * Provides a bean of type PlotChoiceStrategy that represents the news strategy.
     *
     * @return a new NewsStrategy
     */
    @Bean
    public PlotChoiceStrategy newsStrategy() {
        return new NewsStrategy(applicationContext, dressUpWithoutFirstAidKitStrategy(), pickThingsUpWithFirstAidKitStrategy());
    }

    /**
     * Provides a bean of type PlotChoiceStrategy that represents the dress up without first aid kit strategy.
     *
     * @return a new DressUpWithoutFirstAidKitStrategy
     */
    @Bean
    public PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy() {
        return new DressUpWithoutFirstAidKitStrategy(applicationContext);
    }

    /**
     * Provides a bean of type PlotChoiceStrategy that represents the pick things up with first aid kit strategy.
     *
     * @return a new PickThingsUpWithFirstAidKitStrategy
     */
    @Bean
    public PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy() {
        return new PickThingsUpWithFirstAidKitStrategy(applicationContext);
    }
}
