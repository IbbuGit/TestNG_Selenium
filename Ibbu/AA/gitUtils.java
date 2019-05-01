

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class gitUtils {
	static String gitCmnd,shareFolder,userName,pwd;
	
	public static void main(String[] args) {
		gitCmnd=args[0];
		shareFolder=args[1];
		userName=args[2];
		pwd=args[3];
		new gitUtils().connectGIT();
	}
	
	public void connectGIT() {
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider(userName,pwd);
		try {
			
			
			String repoPath="C:\\Users\\mibrahim\\eclipse-workspace\\AA.AutomationFramework.ContactCenter";
			//String repoPath=System.getProperty("java.io.tmpdir")+"\\TestDataRepo";
			if(!new File(repoPath+"\\.git").exists()) {
				Git.cloneRepository()
				.setURI("https://code.advanceamerica.net/scm/testui/AA.ContactCenter")
				  //.setURI("https://code.advanceamerica.net/scm/testui/qfundxsandbox.qfund.net.testdata.git.git")
				  .setCredentialsProvider(cp)
				  .setDirectory(new File(repoPath))
				  .setBranch("refs/heads/development")
				  .call();
			}
			
			FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
			Repository repository = repositoryBuilder.setGitDir(new File(repoPath+"\\.git"))
	                .readEnvironment() // scan environment GIT_* variables
	                .findGitDir() // scan up the file system tree
	                .setMustExist(true)
	                .build();
			
			Git git=new Git(repository);	

			git.rm().addFilepattern(".project").call();
			//git.add().addFilepattern(".").call();
			
			File tempFolderFile_TD=new File(repoPath+"\\QFund_TestData.xlsx");
			File shareFolderFile_TD=new File(shareFolder+"\\QFund_TestData.xlsx");
			File shareFolderBackFile_TD=new File(shareFolder+"\\Backups\\QFund_TestData_"+new Date().toString().replace(" ","").replace(":","_")+".xlsx");

			File tempFolderFile_Config=new File(repoPath+"\\QFund_Config.xlsx");
			File shareFolderFile_Config=new File(shareFolder+"\\QFund_Config.xlsx");
			File shareFolderBackFile_Config=new File(shareFolder+"\\Backups\\QFund_Config_"+new Date().toString().replace(" ","").replace(":","_")+".xlsx");

			File tempFolderFile_PAM=new File(repoPath+"\\PAM_OnlineData.xlsx");
			File shareFolderFile_PAM=new File(shareFolder+"\\PAM_OnlineData.xlsx");
			File shareFolderBackFile_PAM=new File(shareFolder+"\\Backups\\PAM_OnlineData_"+new Date().toString().replace(" ","").replace(":","_")+".xlsx");

			
			if(gitCmnd.toUpperCase().equals("PULL")) {
				
			    FileUtils.copyFile(shareFolderFile_TD, shareFolderBackFile_TD,true);
			    FileUtils.copyFile(shareFolderFile_Config, shareFolderBackFile_Config,true);
			    FileUtils.copyFile(shareFolderFile_PAM, shareFolderBackFile_PAM,true);
			    Thread.sleep(3000);
			    
			    PullCommand pullCommand = git.pull();
			    pullCommand.setCredentialsProvider(cp);
			    pullCommand.call();
			    
			    FileUtils.copyFile(tempFolderFile_TD,shareFolderFile_TD, true);
			    FileUtils.copyFile(tempFolderFile_Config,tempFolderFile_Config, true);
			    FileUtils.copyFile(tempFolderFile_PAM,shareFolderFile_PAM, true);
			    Thread.sleep(3000);
			    
			    System.out.println("Data files pulled from bitbucket");
			    
			}else if(gitCmnd.toUpperCase().equals("PUSH")) {
				
				//git.add().addFilepattern("pom.xml");
						
//				git.rm().addFilepattern("QFund_TestData.xlsx").call();
//				git.rm().addFilepattern("QFund_Config.xlsx").call();
//				git.rm().addFilepattern("QPAM_OnlineData.xlsx").call();
//				
//				FileUtils.copyFile(shareFolderFile_TD,tempFolderFile_TD, true);
//				FileUtils.copyFile(shareFolderFile_Config,tempFolderFile_Config, true);
//				FileUtils.copyFile(shareFolderFile_PAM,tempFolderFile_PAM, true);
//				Thread.sleep(3000);
//				
//				git.add().addFilepattern("QFund_TestData.xlsx").call();
//				git.add().addFilepattern("QFund_Config.xlsx").call();
//				git.add().addFilepattern("PAM_OnlineData.xlsx").call();				

				CommitCommand commitCommand = git.commit();
				commitCommand.setMessage(new Date().toString()+" pushed");
				commitCommand.call();
				
			    // push to remote:
			    PushCommand pushCommand = git.push();
			    pushCommand.setCredentialsProvider(cp);
			    pushCommand.call();
			    
			    System.out.println("Data files pushed to bitbucket");
			}	
			
		    git.close();		
			
		} catch (Exception e) {
			
			System.out.println("Bitbucket commands not executed");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
