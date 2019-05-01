package dataProviders;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;

import testDataTypes.LoginData;

public class JsonDataReader {
	
	private List<LoginData> LoginDataList;

	public JsonDataReader(){
		LoginDataList = getLoginData(getDataFilePath("LoginData"));
	}
	
	private String getDataFilePath(String fileName){
		return FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() +fileName+".json";
	}

	private List<LoginData> getLoginData(String FilePath) {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(FilePath));
			LoginData[] loginData = gson.fromJson(bufferReader, LoginData[].class);
			return Arrays.asList(loginData);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + FilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}

	public final LoginData getLoginDataByScenario(String DataScenario){
		return LoginDataList.stream().filter(x -> x.dataScenarios.equalsIgnoreCase(DataScenario)).findAny().get();
	}
}