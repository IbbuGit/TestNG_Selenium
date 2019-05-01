package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransactions_Title_PostDefaultTransactions_PO;

public class AdminTransactions_Title_PostDefaultTransactions_PR extends Helper {

	public AdminTransactions_Title_PostDefaultTransactions_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void titlePostDefaultTransactions() throws Exception {

		switch (data("PostDefaultTransaction")) {

		case "OutToRepo":
			OutToRepo();
			break;
		case "VoidOutToRepo":
			VoidOutToRepo();
			break;
		case "Repossession":
			Repossession();
			break;
		case "Auction":
			Auction();
			break;
		case "Sale":
			Sale();
			break;
		case "Salvage":
			Salvage();
			break;
		case "CustomerRefund":
			CustomerRefund();
			break;
		default:
			break;
		}

		pdt_FinishPostDefaultTransaction();

	}

	public void OutToRepo() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_PageHeader(data("otr_PageHeader")),
				data("otr_PageHeader"));

		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_OutToRepoDetailsHeader(data("otr_OutToRepoDetailsHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_otr_OutToRepoDetailsHeader(data("otr_OutToRepoDetailsHeader"));

		assertAreEqual(
				"Verification Point", report, objAdminTransactions_Title_PostDefaultTransactions_PO
						.get_otr_OutToRepoDetailsHeader(data("otr_OutToRepoDetailsHeader")),
				data("otr_OutToRepoDetailsHeader"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.set_otr_OutToRepoCompany(data("otr_OutToRepoCompany"));
		objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_otr_VerifyPrincipalDue(data("otr_VerifyPrincipalDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_VerifyInterestDue(data("otr_VerifyInterestDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_VerifyLoanFeeDue(data("otr_VerifyLoanFeeDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_VerifyAmountOwed(data("otr_VerifyAmountOwed"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_Validation(data("otr_Validation"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_otr_Validation(data("otr_Validation"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_tran_VerifyUserId(data("tran_VerifyUserId"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_tran_PIN(data("tran_PIN"));

	}

	public void VoidOutToRepo() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);

		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_repVoid_Validation(data("repVoid_Validation"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_repVoid_Validation(data("repVoid_Validation"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.acceptAlert();

	}

	public void Repossession() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);

		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_rep_PageHeader(data("rep_PageHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_rep_PageHeader(data("rep_PageHeader"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_rep_PageHeader(data("rep_PageHeader")),
				data("rep_PageHeader"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_Company(data("rep_Company"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_RepoFee(data("rep_RepoFee"));
		Thread.sleep(2000);
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_RepossessedDate(data("rep_RepossessedDate"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_repossession_Validation(data("repossession_Validation"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_repossession_Validation(data("repossession_Validation"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_tran_VerifyUserId(data("tran_VerifyUserId"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_tran_PIN2(data("tran_PIN"));
	}

	public void Auction() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_auc_PageHeader(data("auc_PageHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_auc_PageHeader(data("auc_PageHeader"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_auc_PageHeader(data("auc_PageHeader")),
				data("auc_PageHeader"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.set_auc_AuctionCompany(data("auc_AuctionCompany"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_RepossessedDate(data("auc_DateOfAuction"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_auc_Comments(data("auc_Comments"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_auc_Validation(data("auc_Validation"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_auc_Validation(data("auc_Validation"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_tran_VerifyUserId(data("tran_VerifyUserId"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_tran_PIN2(data("tran_PIN"));
	}

	public void Sale() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_sale_PageHeader(data("sale_PageHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_sale_PageHeader(data("sale_PageHeader"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_sale_PageHeader(data("sale_PageHeader")),
				data("sale_PageHeader"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_RepossessedDate(data("sale_DateOfSale"));
		objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_sale_VerifyDefaultPrincipal(data("sale_VerifyDefaultPrincipal"));
		objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_sale_VerifyDefaultInterest(data("sale_VerifyDefaultInterest"));
		objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_sale_VerifyBalanceLoanFee(data("sale_VerifyBalanceLoanFee"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_sale_VerifyRepoFeeDue(data("sale_VerifyRepoFeeDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_sale_SaleValue(data("sale_SaleValue"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_sale_Validation(data("sale_Validation"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_sale_Validation(data("sale_Validation"));

	}

	public void Salvage() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);
		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_PageHeader(data("slv_PageHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_slv_PageHeader(data("slv_PageHeader"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_PageHeader(data("slv_PageHeader")),
				data("slv_PageHeader"));

		// objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_SalvageDetailsHeader(data("slv_SalvageDetailsHeader"));
		// objAdminTransactions_Title_PostDefaultTransactions_PO.isDisplayed_slv_SalvageDetailsHeader(data("slv_SalvageDetailsHeader"));

		assertAreEqual(
				"Verification Point", report, objAdminTransactions_Title_PostDefaultTransactions_PO
						.get_slv_SalvageDetailsHeader(data("slv_SalvageDetailsHeader")),
				data("slv_SalvageDetailsHeader"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.set_slv_SolvageCompany(data("slv_SolvageCompany"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_rep_RepossessedDate(data("sale_DateOfSalvage"));
		objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_slv_VerifyPrincipalDue(data("slv_VerifyPrincipalDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_VerifyInterestDue(data("slv_VerifyInterestDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_VerifyLoanFeeDue(data("slv_VerifyLoanFeeDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_VerifyRepoFeeDue(data("slv_VerifyRepoFeeDue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_VerifyAmountOwed(data("slv_VerifyAmountOwed"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_slv_SalvageValue(data("slv_SalvageValue"));
		objAdminTransactions_Title_PostDefaultTransactions_PO.set_slv_Comments(data("slv_Comments"));
	}

	public void CustomerRefund() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);
		objAdminTransactions_Title_PostDefaultTransactions_PO.get_tran_VerifyUserId(data("tran_VerifyUserId"));

	}

	public void pdt_FinishPostDefaultTransaction() throws Exception {
		AdminTransactions_Title_PostDefaultTransactions_PO objAdminTransactions_Title_PostDefaultTransactions_PO = new AdminTransactions_Title_PostDefaultTransactions_PO(
				driver, report);

		objAdminTransactions_Title_PostDefaultTransactions_PO.click_tran_SubmitButton(data("tran_SubmitButton"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.click_tran_CancelButton(data("tran_CancelButton"));

		objAdminTransactions_Title_PostDefaultTransactions_PO.click_tran_HistoryButton(data("tran_HistoryButton"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_otr_Validation(data("otr_Validation")),
				data("otr_Validation"));

		assertAreEqual("Verification Point", report, objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_repVoid_Validation(data("repVoid_Validation")), data("repVoid_Validation"));

		assertAreEqual("Verification Point", report, objAdminTransactions_Title_PostDefaultTransactions_PO
				.get_repossession_Validation(data("repossession_Validation")), data("repossession_Validation"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_auc_Validation(data("auc_Validation")),
				data("auc_Validation"));

		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_sale_Validation(data("sale_Validation")),
				data("sale_Validation"));
		assertAreEqual("Verification Point", report,
				objAdminTransactions_Title_PostDefaultTransactions_PO.get_slv_Validation(data("slv_Validation")),
				data("slv_Validation"));

		if (data("PostDefaultTransaction").equalsIgnoreCase("Repossession")) {
			objAdminTransactions_Title_PostDefaultTransactions_PO
					.click_tran_ValidationOKButton2(data("tran_ValidationOKButton"));
		} else {
			objAdminTransactions_Title_PostDefaultTransactions_PO
					.click_tran_ValidationOKButton(data("tran_ValidationOKButton"));

		}

	}

}
