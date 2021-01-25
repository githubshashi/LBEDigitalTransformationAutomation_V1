package digitaltransformation.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import digitaltransformation.Pages.MyAccountClassT;
import digitaltransformation.Pages.MyAccountCouncilTax_SubServices;
import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class TC14_ClassT_ValidationCheck_SubmitCase extends BaseTest
{

	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassHConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	String Sub_ServicePageTitle="Portal- Create New Case · Ealing My Account";   // Title text of Council tax Sub service page list
	
	String FirstnameErrortext="First name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";   //Firstname invalid error message
	String LastnameErrortext="Last name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed"; //Lastname invalid error message 
	String LastnameErrortextatleasttwochar="Last name of the person liable for council tax for the unoccupied annexe- Error: this field should contain at least two characters" ; //Lastname error message for at least two char
	
	public static final String Sh_ClassT="ClassT";
		
	 public String SelectbyIndex = "Index";
	 public String Selectbyvalue = "value";
	 public String SelectbyVisibletext = "visibletext";
	 
	SoftAssert s_assert= new SoftAssert();
					
		@Test (groups = {"Apply_for_self"})
		public void ApplyForSelf() throws Exception 
		{		
			MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
			MyAccountClassT classt=new MyAccountClassT(driver);
			Utility ut=new Utility(driver);
			log4j_report.info("URL is opened");
			TestCasePass="Customer Selected Apply for self and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";   
			String Casenumber=null;		
		//	int i=0;  // for Apply for yourself make i=0
			
			Explicitwait(hp.WhatSerivice_button,10);
			hp.Click_WhatSerivice();
			log4j_report.info("User clicked on What Service you are looking for");
			
			Explicitwait(hp.CouncilTax_linkbutton,10);
			hp.ClickonCounciltax();	
			log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
			logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
			
			Explicitwait(ct.ClassTServicelink,10);
			ct.ClickonclassTlink();	
			log4j_report.info("User clicked on ClassT SubService ");
			logger.log(LogStatus.INFO, "Customer selected ClassT Sub_SubService");

			s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
	
			Explicitwait(ut.StartFormbutton,5);
			ut.Click_StartForm();    //Introduction Page Start button Button, Start the form and case will be saved in draft state initially
			log4j_report.info("User clicked on Start Form ");
			logger.log(LogStatus.INFO, "Customer Clicked Start form");
			
			Explicitwait(ut.ReturnPage_HeadingText,10);
			s_assert.assertEquals(AccountNumber_heading, ut.Page_heading());
			ut.tickboxCouncilTaxAccNo();
			ut.NEXT_2();                         //Account Number page next button
			log4j_report.info("User Do tick on Check box (Manually Enter Details) and clicked on NEXT button");
			logger.log(LogStatus.INFO, "Customer View the Account Number page and Filled the details and clicked NEXT button ");
			
			Explicitwait(ut.ReturnPage_HeadingText,5);
			s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
			
			ut.MandatoryFieldCheck();
			ut.Enter_CTAccountnumber(Utility.excelfilepath, 1, 2);
			ut.Postcode_SelectAddress(Sh_ClassT,1,2,3);    // "Address of the annexe or property it is attached to" field (Sheetname, Row, Colunm, Dropdown) 
			ut.FirstnamefieldValidation(classt.First_name_person_textbox, classt.FirstnameErrorText, FirstnameErrortext, logger);
			classt.Enter_Firstnameperson(Sh_ClassT,1,4);
			ut.LastnamefieldValidation(classt.Last_name_person_textbox, classt.LastnameErrorText, classt.LastnameErrorTextAtleastTwochar, LastnameErrortext, LastnameErrortextatleasttwochar, logger);
			classt.Enter_Lastnameperson(Sh_ClassT,1,5);
			ut.telphonenumber();
			ut.NEXT_2();				//This method will click on Account Details page next button
		
		
			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
			classt.Date_AnnexeUnoccupied(Sh_ClassT,1,7);
			classt.Why_AnnexeUnoccupied(Sh_ClassT, 1, 8);
			classt.Enter_AnnexeUsed_beforeUnoccupied(Sh_ClassT, 1, 9);
			ut.selectdropdownvalue(classt.council_Planning_Department_Dpd, SelectbyIndex, "1");
		
			ut.NEXT_2();            //This method will Click on Application Details page NEXT button
			log4j_report.info("User View the Application Details Page and Filled all the details and clicked NEXT button");
			logger.log(LogStatus.INFO, "Customer View the Application Details Page and Filled all the details and clicked NEXT button ");
			
			//ut.Uploadedocument();
			ut.NEXT_2();  //This method will click on Upload page NEXT button
			log4j_report.info("User Completes the Upload Page  and clicked NEXT button");
			logger.log(LogStatus.INFO, "Customer Completes the Upload Page  and clicked NEXT button ");
			
			s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
			ut.Select_summons(0);
			ut.ClickCheckBox();
			Explicitwait(ut.Submit_btn__DeclarationPage,10);
			ut.ClickSubmit_btn();
			log4j_report.info("User clicked Submit button");
			logger.log(LogStatus.INFO, "Customer  clicked Submit button ");
			
			s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
			String Service_Casenumber=ut.Casenumber(Casenumber);
			String AddScreenClassT=captureScrenshot(Screenshotname);	
			
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated theCase number is: "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassT,Service_Casenumber.substring(20, 30), 1, 1);
			
			logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassT));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");	
	
		}
		
		@Test (groups = {"Onbehalf_of_SomeOneElse"})
		public void Apply_onbehalfof_some_one_else() throws Exception 
		{	
			logger.log(LogStatus.INFO, "No Onbehalf of some one else for CLass T");
		}
}
