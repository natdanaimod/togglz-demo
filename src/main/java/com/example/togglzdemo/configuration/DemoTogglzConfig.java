package com.example.togglzdemo.configuration;

import com.example.togglzdemo.DemoFeatures;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.activation.ActivationStrategyProvider;
import org.togglz.core.activation.DefaultActivationStrategyProvider;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.spi.FeatureProvider;

import java.util.List;

@Configuration
public class DemoTogglzConfig {

  @Bean
  public FeatureProvider featureProvider() {
    var featureProvider = new EnumBasedFeatureProvider();
    featureProvider.addFeatureEnum(DemoFeatures.class);
    return featureProvider;
  }

  @Bean
  public ActivationStrategyProvider activationStrategyProvider(List<ActivationStrategy> activationStrategies) {
    var activationStrategyProvider = new DefaultActivationStrategyProvider();
    activationStrategyProvider.addActivationStrategies(activationStrategies);
    return activationStrategyProvider;
  }

  @Bean
  public FeatureManager featureManager(StateRepository stateRepository,
                                       FeatureProvider featureProvider,
                                       ActivationStrategyProvider activationStrategyProvider) {
    return new FeatureManagerBuilder()
        .stateRepository(stateRepository)
        .featureProvider(featureProvider)
        .activationStrategyProvider(activationStrategyProvider)
        .build();
  }
}

