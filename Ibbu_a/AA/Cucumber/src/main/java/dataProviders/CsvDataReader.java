package dataProviders;

import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import managers.FileReaderManager;
import testDataTypes.LoginData;

public class CsvDataReader {

	private List<LoginData> LoginDataList;

	public CsvDataReader(){
		try {		
		LoginDataList = getLoginData(getDataFilePath("LoginData"));
		} catch (Exception e) {e.printStackTrace();}		
	}

	private String getDataFilePath(String fileName){
		return FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() +fileName+".csv";
	}

	private List<LoginData> getLoginData(String FilePath) throws Exception{
		return new CsvToBeanBuilder<LoginData>(new FileReader(FilePath)).withType(LoginData.class).build().parse();
	}

	public final LoginData getLoginDataByScenario(String DataScenario){
		return LoginDataList.stream().filter(x -> x.dataScenarios.equalsIgnoreCase(DataScenario)).findAny().get();
	}
}
