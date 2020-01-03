package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReader;
import dataProviders.CsvDataReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static CsvDataReader csvDataReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance( ) {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	public JsonDataReader getJsonReader(){
		return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
	
	public CsvDataReader getCsvReader(){
		return (csvDataReader == null) ? new CsvDataReader() : csvDataReader;
	}
}