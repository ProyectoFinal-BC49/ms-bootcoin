package com.nttdatabc.msbootcoin.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
  @Bean
  public NewTopic generateTopicVerifyModoPaymentYankiBootcoin() {
    Map<String, String> configuration = new HashMap<>();
    configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
    configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
    configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
    return TopicBuilder.name("verify-modepayment-yanki-bootcoin")
        .configs(configuration)
        .build();
  }
  @Bean
  public NewTopic generateTopicVerifyModoPaymentTransferenciaBootcoin() {
    Map<String, String> configuration = new HashMap<>();
    configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
    configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
    configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
    return TopicBuilder.name("verify-modepayment-transferencia-bootcoin")
        .configs(configuration)
        .build();
  }
  @Bean
  public NewTopic generateTopicValidationSuccess() {
    Map<String, String> configuration = new HashMap<>();
    configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
    configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
    configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
    return TopicBuilder.name("validation-transaction-success")
        .configs(configuration)
        .build();
  }
  @Bean
  public NewTopic generateTopicValidationError() {
    Map<String, String> configuration = new HashMap<>();
    configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
    configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
    configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
    return TopicBuilder.name("validation-transaction-error")
        .configs(configuration)
        .build();
  }
  @Bean
  public NewTopic generateTopicEffectDescount() {
    Map<String, String> configuration = new HashMap<>();
    configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
    configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
    configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
    return TopicBuilder.name("effect-transaction")
        .configs(configuration)
        .build();
  }
}
