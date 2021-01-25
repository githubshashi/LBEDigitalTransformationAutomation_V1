package digitaltransformation.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import digitaltransformation.Pages.MyAccountClassH;
import digitaltransformation.Pages.MyAccountCouncilTax_SubServices;
import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class TC06_ClassH_ValidationCheck_SubmitCase extends BaseTest
{

	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassHConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	String Sub_ServicePageTitle="Portal- Create New Case · Ealing My Account";   // Title text of Council tax Sub service page list
	
//	String FirstnameErrortext="First name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";   //Firstname invalid error message
//	String LastnameErrortext="Last name of the person liable for council tax for the unoccupied annexe - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed"; //Lastname invalid error message 
//	String LastnameErrortextatleasttwochar="Last name of the person liable for council tax for the unoccupied annexe- Error: this field should contain at least two characters" ; //Lastname error message for at least two char
	
	public static final String Sh_ClassH="ClassH";
		
	 public String SelectbyIndex = "Index";
	 public String Selectbyvalue = "value";
	 public String SelectbyVisibletext = "visibletext";
	 
	SoftAssert s_assert= new SoftAssert();
					
		@Test (groups = {"Apply_for_self"})
		public void ApplyForSelf() throws Exception 
		{		
			MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
			MyAccountClassH ch=new MyAccountClassH(driver);
			Utility ut=new Utility(driver);
			log4j_report.info("URL is opened");
			TestCasePass="Customer Selected Apply for self and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";  
			String Casenumber=null;	
			
					Explicitwait(hp.WhatSerivice_button,10);
					hp.Click_WhatSerivice();
					log4j_report.info("User clicked on What Service you are looking for");
					
					Explicitwait(hp.CouncilTax_linkbutton,10);
					hp.ClickonCounciltax();	
					log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
					logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
					
					Explicitwait(ct.ClassHServicelink,10);
					ct.ClickonclassHlink();	
					log4j_report.info("User clicked on ClassH SubService ");
					logger.log(LogStatus.INFO, "Customer selected ClassH Sub_SubService");

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
					logger.log(LogStatus.INFO, "Customer View the Account Number page and Filled the details and clicked NEXT button");
					
					Explicitwait(ut.ReturnPage_HeadingText,5);
					s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
					
					ut.MandatoryFieldCheck();
					ut.Enter_CTAccountnumber(Utility.excelfilepath, 1, 2);
					ut.Postcode_SelectAddress(Sh_ClassH,1,2,3);    // "Address of the annexe or property it is attached to" field (Sheetname, Row, Colunm, Dropdown) 
					ch.Enter_Full_name_organisationORperson(Sh_ClassH, 1,4);
					ch.Enter_Contact_name(Sh_ClassH,1,5);
					ut.telphonenumber();
					ut.NEXT_2();				//This method will click on Account Details page next button
				
				
					s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
					ut.MandatoryFieldCheck();
					ch.Enter_Dateofproperty_unoccupied(Sh_ClassH, 1, 7);
					ut.selectdropdownvalue(ch.property_occupied_Dpd, SelectbyIndex, "1");   //Select [YES] to field "When the property is next occupied, will it be occupied by a minister of religion?"
					ch.Enter_Dateofproperty_become_occupied(Sh_ClassH,1,9);
					ch.Enter_denominationministerreligion(Sh_ClassH,1,10);
					ch.Enter_denominationwebsiteaddress(Sh_ClassH,1,11);
					ch.Enter_Ministerofreligion(Sh_ClassH,1,12);
					ut.NEXT_2();            //This method will Click on Application Details page NEXT button
					log4j_report.info("User View the Application Details Page and Filled all the details and clicked NEXT button");
					logger.log(LogStatus.INFO, "Customer View the Application Details Page and Filled all the details and clicked NEXT button ");
					
					ut.Uploadedocument();
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
					String AddScreenClassH=captureScrenshot(Screenshotname);	
					
					logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated the Case number is: "+Service_Casenumber);
					
					ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassH,Service_Casenumber.substring(20, 30), 1, 1);
					
					logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassH));
					System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
					ut.ClickGotohome_btn();
					s_assert.assertAll();
					System.out.println("Test Run Compleed ");	
				
		}
		
		@Test (groups = {"Onbehalf_of_SomeOneElse"})
		public void Apply_onbehalfof_some_one_else() throws Exception 
		{	
			MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
			MyAccountClassH ch=new MyAccountClassH(driver);
			Utility ut=new Utility(driver);
			
			TestCasePass="Customer Selected Onbehalf of Some one else and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Onbehalf of Some one else, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Onbehalf of Some one else' "; 
			String Casenumber=null;
			int i=1; // To Apply for onbehalf make i=1
			int j=2; //If 1 selects "This time only" option if 2 Selects "Indefinitely (until you advise us otherwise)"
			
			Explicitwait(hp.WhatSerivice_button,10);
			hp.Click_WhatSerivice();
			log4j_report.info("User clicked on What Service you are looking for");
			
			Explicitwait(hp.CouncilTax_linkbutton,10);
			hp.ClickonCounciltax();	
			log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
			logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
			
			Explicitwait(ct.ClassIServicelink,10);
			ct.ClickonclassHlink();	
			log4j_report.info("User clicked on ClassH SubService ");
			logger.log(LogStatus.INFO, "Customer selected ClassH Sub_SubService");

			s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
			
			ut.select_self_onbehalf(i);
				if(j==1)
				{
					ut.select_Authority_act(j);
					ut.Click_StartForm();		
					s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
					ut.FirstNamedelegationTextbox(Sh_ClassH,1,13);
					ut.LastNamedelegationTextbox(Sh_ClassH,1,14);
					ut.AddressdelegationTextbox(Sh_ClassH,1,15,16);     // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
					logger.log(LogStatus.INFO, "Customer Added New delegation");
					ut.NEXT_2();
					logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : This time only) ");	
				}
				else  
				{
					ut.select_Authority_act(j);
					ut.tickdelegationcheckbox();
					ut.Click_StartForm();
				
					s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
					ut.FirstNamedelegationTextbox(Sh_ClassH,1,13);
					ut.LastNamedelegationTextbox(Sh_ClassH,1,14);
					ut.AddressdelegationTextbox(Sh_ClassH,1,15,16);    // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
					ut.NEXT_2();
					logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : Indefinitly [until you advise us]) ");
					logger.log(LogStatus.INFO, "Customer Added New delegation");
					
				}
				
				s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());		
				ut.MandatoryFieldCheck();
				ut.Enter_CTAccountnumber(Utility.excelfilepath, 1, 2);
				ch.Enter_Full_name_organisationORperson(Sh_ClassH, 1,4);
				ch.Enter_Contact_name(Sh_ClassH,1,5);
				ut.telphonenumber();
				ut.NEXT_2();
				//ut.SAVE_AND_EXIT_2(); 	// If User wants to Save and Exit
				
				s_assert.assertEquals(AppDetails_heading, ut.Page_heading(), "Validating Application page Heading 'APPLICATION DETAILS'");
				
				ut.MandatoryFieldCheck();
				ch.Enter_Dateofproperty_unoccupied(Sh_ClassH, 1, 7);
				ut.selectdropdownvalue(ch.property_occupied_Dpd, SelectbyIndex, "1");   //Select [YES] to field "When the property is next occupied, will it be occupied by a minister of religion?"
				ch.Enter_Dateofproperty_become_occupied(Sh_ClassH,1,9);
				ch.Enter_denominationministerreligion(Sh_ClassH,1,10);
				ch.Enter_denominationwebsiteaddress(Sh_ClassH,1,11);
				ch.Enter_Ministerofreligion(Sh_ClassH,1,12);
				ut.NEXT_2();            //This method will Click on Application Details page NEXT button
				log4j_report.info("User View the Application Details Page and Filled all the details and clicked NEXT button");
				logger.log(LogStatus.INFO, "Customer View the Application Details Page and Filled all the details and clicked NEXT button ");
				
				ut.Uploadedocument();
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
				String AddScreenClassH=captureScrenshot(Screenshotname);	
				
				logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated the Case number is: "+Service_Casenumber);
				
				ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassH,Service_Casenumber.substring(20, 30), 1, 1);
				
				logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassH));
				System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
				ut.ClickGotohome_btn();
				s_assert.assertAll();
				System.out.println("Test Run Compleed ");	
			
		}	
			
}
