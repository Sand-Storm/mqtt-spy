/***********************************************************************************
 * 
 * Copyright (c) 2014 Kamil Baczkowicz
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *    
 * The Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * 
 *    Kamil Baczkowicz - initial API and implementation and/or initial documentation
 *    
 */
package pl.baczkowicz.mqttspy;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;

import org.slf4j.LoggerFactory;

import pl.baczkowicz.mqttspy.configuration.ConfigurationManager;
import pl.baczkowicz.mqttspy.stats.StatisticsManager;
import pl.baczkowicz.mqttspy.ui.ViewManager;
import pl.baczkowicz.mqttspy.ui.connections.ConnectionManager;
import pl.baczkowicz.spy.eventbus.IKBus;
import pl.baczkowicz.spy.eventbus.KBus;
import pl.baczkowicz.spy.ui.events.LoadConfigurationFileEvent;
import pl.baczkowicz.spy.ui.utils.FxmlUtils;
import pl.baczkowicz.spy.ui.versions.VersionManager;

/** 
 * The main class, loading the app.
 */
public class Main extends Application
{	
	/** Name of the parameter supplied on the command line to indicate where to find the configuration file - optional. */
	private final static String CONFIGURATION_PARAMETER_NAME = "configuration";
	
	/** Name of the parameter supplied on the command line to indicate no configuration wanted - optional. */
	private final static String NO_CONFIGURATION_PARAMETER_NAME = "no-configuration";

	@Override
	/**
	 * Starts the application.
	 */
	public void start(final Stage primaryStage)
	{			
		final IKBus eventBus = new KBus();
				
		try
		{
			final ConfigurationManager configurationManager = new ConfigurationManager();			
			
			FxmlUtils.setParentClass(getClass());									
			
			final StatisticsManager statisticsManager = new StatisticsManager();
			final ViewManager viewManager = new ViewManager();
			final VersionManager versionManager = new VersionManager(configurationManager.getDefaultPropertyFile());	
			final ConnectionManager connectionManager = new ConnectionManager(eventBus, statisticsManager, configurationManager);							
			
			connectionManager.setViewManager(viewManager);
			
			viewManager.setEventBus(eventBus);
			viewManager.setConfigurationManager(configurationManager);
			viewManager.setConnectionManager(connectionManager);
			viewManager.setStatisticsManager(statisticsManager);
			viewManager.setVersionManager(versionManager);
			viewManager.setApplication(this);
			viewManager.init();
			
			viewManager.createMainWindow(primaryStage);
			
			// Show the main window
			primaryStage.show();
			
			// Load the config file if specified
			final String noConfig = this.getParameters().getNamed().get(NO_CONFIGURATION_PARAMETER_NAME); 
			final String configurationFileLocation = this.getParameters().getNamed().get(CONFIGURATION_PARAMETER_NAME);
			
			if (noConfig != null)
			{
				// Do nothing - no config wanted
			}
			else if (configurationFileLocation != null)
			{
				eventBus.publish(new LoadConfigurationFileEvent(new File(configurationFileLocation)));				
			}
			else
			{
				// If no configuration parameter is specified, use the user's home directory and the default configuration file name
				viewManager.loadDefaultConfigurationFile();						
			}
		}
		catch (Exception e)
		{
			LoggerFactory.getLogger(Main.class).error("Error while loading the main window", e);
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
