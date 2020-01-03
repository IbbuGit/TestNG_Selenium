package pageClasses.QFund;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class InstallmentLoan_po extends BasePage{

	public InstallmentLoan_po(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}	
	
	@FindBy(name="negLoanAmt")
	private WebElement NegotiateLoanAmt_btn;
	
	@FindBy(name="collateralType")
	private WebElement ExpectedPaymentMethod_dropdown;
	
	@FindBy(name="requestBean.siilBean.disbType")
	private WebElement DispType_dropdown ;
	
	@FindBy(name="requestBean.siilBean.disbAmtFirst")
	private WebElement DispAmt_textbox ;
	
	@FindBy(name="requestBean.siilBean.emailConsentFlag")
	private WebElement ElectronicDocuments_dropdown ;
	
	@FindBy(name="requestBean.password")
	private WebElement Pin_textbox;
	
	@FindBy(name="finishLoan")
	private WebElement FinishLoan_btn;
	
	@FindBy(name="eeeComm")
	private WebElement Eligibility_btn;
	
	@FindBy(name="cancelLoan")
	private WebElement Cancel_btn;
	
	@FindBy(name="denyLoan")
	private WebElement Deny_btn;
	
	@FindBy(name="requestBean.siilBean.advAmt")
	private WebElement RequestedLoanAmt;
	
	@FindBy(xpath="//td[contains(@class,'LeftHeading')]")
	private WebElement InstallmentLoanCompletedSuccessfully_message;
	
	@FindBy(name="ok")
	private WebElement InstallmentLoanCompletedSuccessfully_btn;
	
	//InstallmentLoan Void Pageobjects//
	
	@FindBy(xpath="//td[(@class='leftHeading')]")
	private WebElement TransactionVoidedSuccessfully_message;
	
	@FindBy(name="checkno")
	private WebElement Anothertransaction_btn;
	
	@FindBy(name="tenderType")
	private WebElement Void_TenderType_drpdown;
	
	@FindBy(name="requestBean.password")
	private WebElement Void_Pin_textbox;
	
	@FindBy(name="history")
	private WebElement Void_History_btn;
	
	@FindBy(name="back")
	private WebElement Void_Back_btn;
	
	@FindBy(name="finish")
	private WebElement Void_Finish_btn;
	
	@FindBy(name="requestBean.siilBean.disbAmt")
	private WebElement TotalDisbAmt;
	
	@FindBy(id="OKBut")
	private WebElement ConfirmInstallmentLoan_btn;
	
	@FindBy(xpath="//input[contains(@onclick,'sel(13)')]")
	private WebElement SelectNoOfInstallments;
	
	@FindBy(xpath="//input[contains(@onclick,'sel(4)')]")
	private WebElement SelectNoOfInstallments2;
	
	@FindBy(name="requestBean.siilBean.checkopt")
	private WebElement NoOfCheck_dropdown;
	
	public void set_NoOfCheck_dropdown(String TestData) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
	   
		 while(isDisplayed(NoOfCheck_dropdown))
		 {
			  js.executeScript("window.scrollBy(0,400)");
			  break;
		 }
		doIT(NoOfCheck_dropdown, TestData);
	}
	
	public void click_ConfirmInstallmentLoan_btn(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmInstallmentLoan_btn));
		doIT(ConfirmInstallmentLoan_btn, data);
	}
	
	public boolean isDisplayed_SelectNoOfInstallments(){
		return isDisplayed(SelectNoOfInstallments);
	}
     
	public boolean isDisplayed_SelectNoOfInstallments2(){
		return isDisplayed(SelectNoOfInstallments2);
	}
	
	public void click_SelectNoOfInstallments(String data) {
		driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(1000,0)", "");
		doIT(SelectNoOfInstallments, data);
	}
	
	public void click_SelectNoOfInstallments2(String data) {
		driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(1000,0)", "");
		doIT(SelectNoOfInstallments2, data);
	}
	
	public void click_NegotiateLoanAmt_btn(String data) {
		doIT(NegotiateLoanAmt_btn, data);
	}
	
	public void set_ExpectedPaymentMethod_dropdown(String TestData) {
		doIT(ExpectedPaymentMethod_dropdown, TestData);
	}
	
	public void set_DispType_dropdown(String TestData) {
		doIT(DispType_dropdown, TestData);
	}
	
	public void set_DispAmt_textbox(String TestData) {
		wait.until(ExpectedConditions.elementToBeClickable(FinishLoan_btn));
		doIT(DispAmt_textbox, TestData);
	}
	
	public void set_ElectronicDocuments_dropdown (String TestData) {
		doIT(ElectronicDocuments_dropdown , TestData);
	}
	
	public void set_Pin_textbox (String TestData) {
		doIT(Pin_textbox , TestData);
	}

	public void  click_FinishLoan_btn(String data) {
		doIT( FinishLoan_btn, data);
	}
	
	public void click_Eligibility_btn(String data) {
		doIT( Eligibility_btn, data);
	}
	
	public void click_Cancel_btn(String data) {
		doIT(Cancel_btn, data);
	}
	
	public void click_Deny_btn(String data) {
		doIT(Deny_btn, data);
	}
	
	public String get_RequestedLoanAmt(String TestData) {
		return doIT(RequestedLoanAmt, TestData);
	}
	

	
	public void set_Void_TenderType_drpdown(String TestData) {
		doIT(Void_TenderType_drpdown, TestData);
	}
	
	public void set_Void_Pin_textbox(String TestData) {
		doIT( Void_Pin_textbox , TestData);
	}

	public void click_Void_History_btn(String data) {
		doIT(Void_History_btn, data);
	}
	
	public void click_Void_Back_btn(String data) {
		doIT(Void_Back_btn, data);
	}
	
	public void click_Void_Finish_btn(String data) {
		doIT(Void_Finish_btn, data);
	}
	
	public String get_TotalDisbAmt(String TestData) {
		return doIT(TotalDisbAmt, TestData);
	}
	
	public void click_InstallmentLoanCompletedSuccessfully_btn(String data) {
		doIT(InstallmentLoanCompletedSuccessfully_btn, data);
	}
	
	public String get_InstallmentLoanCompletedSuccessfully_message(String TestData) {
		return doIT(InstallmentLoanCompletedSuccessfully_message, TestData);
	}
	
	public void click_Anothertransaction_btn(String data) {
		doIT( Anothertransaction_btn, data);
	}
	
	public String get_TransactionVoidedSuccessfully_message(String TestData) {
		return doIT(TransactionVoidedSuccessfully_message, TestData);
	}
	
	//InstallmentLoan Void Payments Pageobjects//
	
	@FindBy(name="requestBean.siilBean.disbType")
	private WebElement VoidPaymentDisbType_dropdown;
	
	@FindBy(name="finish")
	private WebElement VoidEarlyPayOff_btn;
	
	@FindBy(name="finish")
	private WebElement VoidPayment_btn;
	
	public void set_VoidPaymentDisbType_dropdown(String data){
		wait.until(ExpectedConditions.elementToBeClickable(VoidPaymentDisbType_dropdown));
		doIT(  VoidPaymentDisbType_dropdown, data);
	}
	
	public void click_VoidEarlyPayOff_btn(String data) {
		doIT(  VoidEarlyPayOff_btn, data);
	}
	
	public void click_VoidPayment_btn(String data) {
		doIT( VoidPayment_btn, data);
	}
/*
 *  Default Payment
 */
	@FindBy(name="transactionDataBean.paymentAmt")
	private WebElement PaymentAmt_textbox;
	
	  public void set_PaymentAmt_textbox(String TestData) {
		   PaymentAmt_textbox.clear();
			doIT(PaymentAmt_textbox , TestData);
		}
	 
	 public String get_PaymentAmt_textbox(String sPaymentAmt_textbox) {
			return doIT(PaymentAmt_textbox, sPaymentAmt_textbox).trim();
		}
	
	    @FindBy(name="transactionDataBean.tenderTypeFirst")
		private WebElement TenderType_drpdown;

		public void set_TenderType_drpdown(String TestData) {
			doIT(TenderType_drpdown, TestData);
		}
	
		@FindBy(name="transactionDataBean.tenderAmtFirst")
		private WebElement TenderAmt_textbox;
		
		 public void set_TenderAmt_textbox(String TestData) {
				doIT( TenderAmt_textbox , TestData);
			}

			@FindBy(name="transactionDataBean.ccmoNbrFirst")
			private WebElement CCMONumber_textbox;
			
			 public void set_CCMONumber_textbox(String TestData) {
					doIT( CCMONumber_textbox , TestData);
				}
			
			 @FindBy(name="Submit22")
			   private WebElement Finish_btn;
			
			 
			 public void click_Finish_btn(String data) {
					doIT( Finish_btn, data);
				}
				
			 @FindBy(xpath="//td[(@class='leftHeading')]")
				private WebElement DefaultPaymentSuccessfull_message;

			 
			 public String get_DefaultPaymentSuccessfull_message(String TestData) {
					return doIT(DefaultPaymentSuccessfull_message, TestData);
				} 
			 
			 @FindBy(name="transactionDataBean.paymentBalAmt")
				private WebElement DefaultBalance_message;

			 public String get_DefaultBalance_message(String TestData) {
					return doIT(DefaultBalance_message, TestData);
				} 
			 
			 @FindBy(name="password")
				private WebElement Pind_textbox;
			 
			 
			 public void set_Pind_textbox(String TestData) {
					doIT( Pind_textbox , TestData);
				} 
			 
			/*
			 * PaymentPlan
			 */
			 
			 @FindBy(xpath="//input[@onclick='onSubmit()']")
				private WebElement Next_Btn;
			 
			 @FindBy(name="collateralTypeId")
				private WebElement collateraltype_drpdwn;
			 
			 @FindBy(name="submitBtn")
				private WebElement FinishPaymentPlan_btn;
			 
			 @FindBy(name="OKBut")
				private WebElement ConfirmPP_btn;
			 
			 @FindBy(xpath="//td[@align='center']/table/tbody/tr/td/b")
				private WebElement PaymentPlan_message;
			 
			 @FindBy(name="password")
				private WebElement PinPP_Btn;
			 
			 public void set_PinPP_Btn(String data) {
					doIT( PinPP_Btn, data);
				}
			 
			 public void click_Next_Btn(String data) {
					doIT( Next_Btn, data);
				}
			 
			 public void set_collateraltype_drpdwn(String TestData) {
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				    js.executeScript("window.scrollBy(0,1000)", "");
					doIT( collateraltype_drpdwn , TestData);
				}
			 
			 public void click_FinishPaymentPlan_btn(String data) {
					doIT( FinishPaymentPlan_btn, data);
				}
			 
			 public void click_ConfirmPP_btn(String data) {
					doIT( ConfirmPP_btn, data);
				}
			 
			 public String get_PaymentPlan_message(String TestData) {
					return doIT(PaymentPlan_message, TestData);
				} 
			
			 /*
				 * void Payment Plan	
				 */
					 
					 
					 @FindBy(name="transactionDataBean.password")
						private WebElement VoidPinPP_textbox;
					 
					 
					 @FindBy(name="Submit22")
						private WebElement VoidFinishPP_Btn;
					 
					 
					 @FindBy(xpath="//td[@align='center']/b")
						private WebElement VoidPP_message;
					 
					 
					 public void set_VoidPinPP_textbox(String data) {
							doIT( VoidPinPP_textbox, data);
						}
					 
					 public void click_VoidFinishPP_Btn(String data) {
						 wait.until(ExpectedConditions.elementToBeClickable(VoidFinishPP_Btn));
							doIT( VoidFinishPP_Btn, data);
						} 
					 
					 public String get_VoidPP_message(String TestData) {
							return doIT(VoidPP_message, TestData);
				
					} 
		/*
		 *  RPP Payment
		 */
						
					 @FindBy(xpath="//td[(@class='leftHeading')]")
						private WebElement RPPPaymentSuccessfull_message;

					 
					 public String get_RPPPaymentSuccessfull_message(String TestData) {
							return doIT(RPPPaymentSuccessfull_message, TestData);
						} 
					 
					 
					 @FindBy(name="Submit33")
						private WebElement VoidFinishRP_Btn;
					 
					 
					 public void click_VoidFinishRP_Btn(String data) {
							doIT( VoidFinishRP_Btn, data);
						}
					 
					 
					 @FindBy(xpath="//td[@class='leftHeading']")
						private WebElement VoidRPPPaymentSuccessfull_message;
					 
					 
					 
					 public String get_VoidRPPPaymentSuccessfull_message(String TestData) {
							return doIT(VoidRPPPaymentSuccessfull_message, TestData);
			}
					 
					 /*
					  * WO Recovery
					  */
					 
					 
					 
					 @FindBy(name="requestBean.password")
						private WebElement WORecoveryPin_Btn;
					 
					 
					 public void set_WORecoveryPin_Btn(String data) {
							doIT(WORecoveryPin_Btn, data);
						}
					 
					 @FindBy(xpath="//td[@align='center']/b")
						private WebElement WORecoveryPaymentSuccessfull_message;
					 
					 
					 
					 public String get_WORecoveryPaymentSuccessfull_message(String TestData) {
							return doIT(WORecoveryPaymentSuccessfull_message, TestData);
			}
					 
					 
					 
}




