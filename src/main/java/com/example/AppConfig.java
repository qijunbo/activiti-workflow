package com.example;

import javax.sql.DataSource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.activiti.ActivitiDemo;

@Configuration
public class AppConfig {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Bean
	@ConfigurationProperties(prefix = "app.datasource")
	public DataSource dataSource() {
		return new DriverManagerDataSource();
	}

	/**
	 * if you want share the database, use this configuration.
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "mysql.activiti")
	public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource) {
		StandaloneProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration();
		cfg.setDataSource(dataSource);
		return cfg;
	}

	/**
	 * if you want to use a different data source for ACTIVITI, you can
	 * configure it separately.
	 * 
	 * @return a standalone ProcessEngineConfiguration
	 */
	// @Bean
	// @ConfigurationProperties(prefix = "mysql.activiti")
	public ProcessEngineConfiguration processEngineConfiguration() {
		return new StandaloneProcessEngineConfiguration();
	}

	@Bean
	public ProcessEngine createProcessEngine(ProcessEngineConfiguration configuration) {

		ProcessEngine engine = configuration.buildProcessEngine();
		//@formatter:off
		if (LOG.isDebugEnabled()) {
			LOG.debug( String.format("ProcessEngine [%s] Version: [%s]", 
					engine.getName(), ProcessEngine.VERSION));
		}
		//@formatter:on
		return engine;
	}

	@Bean
	public RuntimeService createRuntimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean
	public RepositoryService createRepositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean
	public TaskService createTaskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean
	public ManagementService createManagementService(ProcessEngine processEngine) {
		return processEngine.getManagementService();
	}

	@Bean
	public IdentityService createIdentityService(ProcessEngine processEngine) {
		return processEngine.getIdentityService();
	}

	@Bean
	public HistoryService createHistoryService(ProcessEngine processEngine) {
		return processEngine.getHistoryService();
	}

	@Bean
	public FormService createFormService(ProcessEngine processEngine) {
		return processEngine.getFormService();
	}

	@Bean
	public ActivitiDemo demo() {
		return new ActivitiDemo();
	}

}
