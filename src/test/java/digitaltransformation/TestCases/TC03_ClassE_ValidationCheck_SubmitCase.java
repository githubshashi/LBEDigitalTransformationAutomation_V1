package digitaltransformation.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import digitaltransformation.Pages.MyAccountClassE;
import digitaltransformation.Pages.MyAccountClassI;
import digitaltransformation.Pages.MyAccountCouncilTax_SubServices;
import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class TC03_ClassE_ValidationCheck_SubmitCase extends BaseTest
{
	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassEConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	String Sub_ServicePageTitle="Portal- Create New Case · Ealing My Account";   // Title text of Council tax Sub service page list
	
	String FirstnameErrortext="First name of the person who has left the property to receive care - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";   //Firstname invalid error message
	String LastnameErrortext="Last name of the person who has left the property to receive care - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed"; //Lastname invalid error message 
	String LastnameErrortextatleasttwochar="Last name of the person who has left the property to receive care- Error: this field should contain at least two characters" ; //Lastname error message for atleast two char
	
	public static final String Sh_ClassE="ClassE";
		
	 public String SelectbyIndex = "Index";
	 public String Selectbyvalue = "value";
	 public String SelectbyVisibletext = "visibletext";
	 
	SoftAssert s_assert= new SoftAssert();
					
		@Test (groups = {"Apply_for_self"})
		public void ApplyForSelf() throws Exception 
		{		
	
			MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
			MyAccountClassE ce=new MyAccountClassE(driver);
			Utility ut=new Utility(driver);
			log4j_report.info("URL is opened");
			TestCasePass="Customer Selected Apply for self and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";   
			String Casenumber=null;		
			int i=0;  // for Apply for yourself make i=0
			
			Explicitwait(hp.WhatSerivice_button,10);
			hp.Click_WhatSerivice();
			log4j_report.info("User clicked on What Service you are looking for");
			
			Explicitwait(hp.CouncilTax_linkbutton,10);
			hp.ClickonCounciltax();	
			log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
			logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
			
			Explicitwait(ct.ClassEServicelink,10);
			ct.ClickonclassElink();	
			log4j_report.info("User clicked on ClassE SubService ");
			logger.log(LogStatus.INFO, "Customer selected ClassE Sub_SubService");
			s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
			
			
			ut.select_self_onbehalf(i);
			log4j_report.info("User selected for yourself option ");
			logger.log(LogStatus.INFO, "Customer selected Applyforself Option");
			
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
			ut.Postcode_SelectAddress(Sh_ClassE,1,2,3);    // Address of Unoccupied Property field (Sheetname, Row, Colunm, Dropdown)  
			ut.FirstnamefieldValidation(ce.First_name_person_textbox, ce.FirstnameErrorText, FirstnameErrortext, logger);
			ut.LastnamefieldValidation(ce.Last_name_person_textbox, ce.LastnameErrorText, ce.LastnameErrorTextAtleastTwochar, LastnameErrortext, LastnameErrortextatleasttwochar, logger);
			ce.Enter_Firstname_person_residing_hospital_CareHome(Sh_ClassE, 1, 4);
			ce.Enter_Lastname_person_residing_hospital_CareHome(Sh_ClassE, 1, 5);
			ut.telphonenumber();		
			ut.NEXT_2();				//This method will click on Account Details page next button	
			
			
			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
			ce.Enter_Date_Moved_to_hospital(Sh_ClassE,1,2);     // Field - Date the person moved permanently to a hospital, nursing home or residential care home
			ut.selectdropdownvalue(ele, type, value);   		// Field - Does the person intend to return to the unoccupied property?
			ce.Enter_Name_address_hospital(Sh_ClassE,1,2);  	// Field - Name and address of hospital, nursing home or residential care home
			ce.Enter_dateofbirth(Sh_ClassE,1,2);  				// Field - "In order to assist us in verifying the claim for an exemption, please provide the patient or care home resident's date of birth"
			ce.Enter_NHSNumber(Sh_ClassE,1,2);    				// Field - If the person is now mainly resident in a hospital, in order to assist us in verifying the claim for an exemption, please provide their NHS number
			ut.selectdropdownvalue(ele, type, value);  			// Field - Is the patient or care home resident the owner or the tenant of the unoccupied property?
			ce.Enter_ENDDate(Sh_ClassE,1,2);					// Field - Please provide the tenancy end date, if known
			ce.Enter_Name_Address_landlord(Sh_ClassE,1,2);		// Field - Name and address of landlord
			ut.NEXT_2();            							//This method will Click on Application Details page NEXT button
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
			String AddScreenClassE=captureScrenshot(Screenshotname);	
			
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated the Case number is: "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassE,Service_Casenumber.substring(20, 30), 1, 1);
			
			logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassE));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
		
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");	
		}
		
		
}
