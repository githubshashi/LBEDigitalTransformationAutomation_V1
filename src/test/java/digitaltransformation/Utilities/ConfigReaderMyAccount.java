package digitaltransformation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderMyAccount {
	
	Properties Prop;
	//Properties ClassF_prop;

	public ConfigReaderMyAccount() {

		try {
			File src = new File("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			Prop = new Properties();
			Prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowsername() {
		String browsername=Prop.getProperty("browsername");
		return browsername;
	}

	public String getDriverPath() {
		String path = Prop.getProperty("driver_path");
		
		return path;
	}

	public String getDriverValue() {
		String value = Prop.getProperty("driver_value");
		
		return value;
	}

	public String getURL() {
		//return Prop.getProperty("SITurl");
		return Prop.getProperty("UATurl");
		//return Prop.getProperty("PRODurl");
		//return Prop.getProperty("MLdevPortal_url");
		
	}
	
	
	
	public String getUsername()
	{
	String username=Prop.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=Prop.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=Prop.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=Prop.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=Prop.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	
	
		// Home page web Elements configuration
	public String homePageTitle() {
		return Prop.getProperty("homePageTitle");
	}
	public String Homeicon_Click() {
		return Prop.getProperty("HomeIcon_btn");
	}
	public String homepageSignInbutton() {
		return Prop.getProperty("homepageSignInxpath");
	}
	public String whatservicebutton()
	{
		return Prop.getProperty("UATwhatservicebutton");
	}
	public String Counciltaxtab()
	{
		return Prop.getProperty("UATCouncilTax_btn");
		//return ClassD_prop.getProperty("CouncilTax_btn");
	}
	
	
	
 // SignIn page web Elements Configurations
	public String SignInPageTitle() {
		return Prop.getProperty("SignInPageTitle");
	}
	public String username() {
		return Prop.getProperty("txtUsernamexpath");
	}
	public String Password() {
		return Prop.getProperty("txtPasswordxpath");
	}
	public String SignInbutton() {
		return Prop.getProperty("btnSigninxpath");
	}
	
										// CouncilTax  Sub_Services list - Occupied Properties 
	
	public String classVlink()
	{   	return Prop.getProperty("ClassV_link");  	}
	
	
										// CouncilTax  Sub_Services list - Occupied Properties 
	
	public String VPDAlink()
	{   	return Prop.getProperty("VPDA_link");  	}
	
	
	public String classTlink()
	{   	return Prop.getProperty("ClassT_link");  	}
	
	public String classElink()
	{   	return Prop.getProperty("ClassE_link");  	}
	
	public String classJlink()
	{   	return Prop.getProperty("ClassJ_link");  	}
	
	public String classQlink()
	{   	return Prop.getProperty("ClassQ_link");  	}
	
	public String classHlink()
	{   	return Prop.getProperty("ClassH_link");  	}
	
	public String classRlink()
	{   	return Prop.getProperty("ClassR_link");  	}
	
	public String classKlink()
	{   	return Prop.getProperty("ClassK_link");  	}
	
	public String classFlink()
	{   	return Prop.getProperty("ClassF_link");  	}
	
	public String classIlink()
	{   	return Prop.getProperty("ClassI_link");  	}
	
	public String classBlink()
	{   	return Prop.getProperty("ClassB_link");  	}
	
	public String classLlink()
	{   	return Prop.getProperty("ClassL_link");  	}
	
	public String classDlink()
	{   	return Prop.getProperty("ClassD_link");  	}
	
	public String Counciltaxpagetitle()
	{ return Prop.getProperty("Counciltax_pagetitle");  }
	
	public String classG_link()
	{   	return Prop.getProperty("ClassG_link");  	}
	

	
	
	
	
	//------------------------------Title of 'Application Details ' Page of all the Sub_Services----------
	
	public String verifytitleclassD()
	{  return Prop.getProperty("Sub_Service_CT_PageTitle");   }
	
	public String verifytitleclassV()
	{  return Prop.getProperty("Sub_Service_CT_PageTitle");   }
	
	public String verifytitleclassG()
	{  return Prop.getProperty("Sub_Service_CT_PageTitle");   }
	
	public String SubServicetitle_labelName()
	{  return Prop.getProperty("Sub_Service_CT_PageTitle");   }
	
	
									
	//-------------------------------Select Apply for Self OR Onbehalf of another party---------
	
	public String ApplySelf_Onbehalf_dropdown()
	{ return Prop.getProperty("Self_Onbehalf"); }
	
	public String Authority_Act_dropdown()
	{ return Prop.getProperty("Authority_Act"); }
	
	public String tick_delegation()
	{ return Prop.getProperty("CheckboxForDelegation"); }
	
	public String Rep_Person_dropdown()
	{ return Prop.getProperty("RepresentPerson"); }
	
	public String Nextbtn()                         // Start the form
	{ return Prop.getProperty("Nextbtn"); }
	
	//-------------------------------Please complete details of the person you wish to act on behalf of (Delegation)---------
	
	public String FirstNamedelegation()
	{ return Prop.getProperty("Delegation_FirstName"); }
	
	public String Delegation_Firstname_Alphanumaric_check()
	{ return Prop.getProperty("Delegation_Firstname_Alphanumaric_Chk"); }
	
	public String LastNamedelegation()
	{ return Prop.getProperty("Delegation_LastName"); }
	
	public String Delegation_Lastname_Alphanumaric_check()
	{ return Prop.getProperty("Delegation_Lastname_Alphanumaric_Chk"); }
	
	public String DelegationPostcode()
	{ return Prop.getProperty("DelegationPostcode_txt"); }
	
	public String hiddendelegateaddresstagcitizen()
	{ return Prop.getProperty("hiddendelegateaddresstagtxt"); }
	
	//------
	
	public String DelegationGObutton()
	{ return Prop.getProperty("DelegationGo_btn"); }
	
	public String Delegationselectaddress()
	{ return Prop.getProperty("DelegationAddress_list"); }
	
	
	//------------------------------------------PageHeading---------------------
	
	public String heading1text()
	{
		return Prop.getProperty("Headingtxt1");
	}
	public String Declarationheadingtext()
	{
		return Prop.getProperty("Declarationpage");
	}
	public String Delegationheadingtext()
	{
		return Prop.getProperty("DelegationPageHeading");
	}
	
	
	//-------------------------------------------Accoounts Details page Class D----------
	
	public String tickboxCTA()
	{
		return Prop.getProperty("tickboxCTA");
	}
	
	public String dropdownsummons()
	{ return Prop.getProperty("summons_dpd"); }
	
	public String Acc_num()
	{ return Prop.getProperty("CTAccountnum_txt"); }
	
	public String enterpostcode()
	{ return Prop.getProperty("Postcode_txt"); }
	
	public String hiddenpersonaddresstagtextbox()
	{return Prop.getProperty("hiddenpersonaddresstagtxt");}
	
	public String PostcodeAddress_Options()
	{return Prop.getProperty("PostcodeAddress_Options_txt");}
	
	public String PostcodeAddress_Options_selected()
	{return Prop.getProperty("PostcodeAddress_Optionsselected_txt");}
	
	public String clickGo()
	{ return Prop.getProperty("Go_btn"); }
	

	
	//--------------------------------------------------------------------
							public String enterpostcodeonbehalf()
							{ return Prop.getProperty("OnbehalfPostcode_txt"); }
							
							public String Onbehalf_address_Option()
							{return Prop.getProperty("OnbehalfPostcodeAddress_Options_txt");}
						
							
							public String clickOnbehalf_Go()
							{ return Prop.getProperty("OnbehalfGo_btn"); }
							
							public String Onbehalf_selected_Address()
							{ return Prop.getProperty("OnbehalfPostcodeAddress_Optionsselected_txt"); }
	//------------------------------------------------------------------------
	
	public String mandatorycheck()
	{ return Prop.getProperty("MandatoryFieldsCheck"); }
	
	public String Firstname_Alphanumaric_check()
	{ return Prop.getProperty("Firstname_Alphanumaric_txt"); }
	
	public String Lastname_Alphanumaric_check()
	{ return Prop.getProperty("Lastname_Alphanumaric_txt"); }
	
	public String Mobilenumber_Invalid_check()
	{ return Prop.getProperty("Mobilenumber_Invalid_txt"); }
	
	public String firstnametxt()
	{ return Prop.getProperty("DetainedFirstName_txt"); }
	
	public String lastnametxt()
	{ return Prop.getProperty("DetainedLastName_txt"); }

	public String onbehalffirstnametxt()
	{ return Prop.getProperty("Onbehalffirstname_txt"); }
	
	public String onbehalflastnametxt()
	{ return Prop.getProperty("Onbehalflastname_txt"); }
	
	public String enteronbehalfpostcode()
	{ return Prop.getProperty("OnbehalfPostcode_txt"); }
	
	public String clickonbhalfGo()
	{ return Prop.getProperty("OnbehalfGo_btn"); }
	
	public String selectonbehalfaddress()
	{ return Prop.getProperty("OnbehalfAddress_list"); }
	
	public String telphonenumbertxt()
	{ return Prop.getProperty("Telephone_txt"); }
	
	public String emailaddresstxt()
	{ return Prop.getProperty("Email_txt"); }
	
//-------------------------------------------------------   NEXT, PREVIUOS, SAVEandEXIT  -------------------
	public String nextbtn2()
	{ return Prop.getProperty("Nextbtn2"); }
	
	public String SaveExit()
	{ return Prop.getProperty("SaveExit"); }
	
	public String Previous_btn()
	{ return Prop.getProperty("non-Previous_btn"); }
	
//-------------------------------------------------Application Details page for ClassD----------
	
	public String DatedetentioCommenced()
	{ return Prop.getProperty("date_detention_date"); }
	
	public String NameofPrison_txt()
	{ return Prop.getProperty("NameAddressPrison_txt"); }
	
	public String PrisonerNumber_txt()
	{ return Prop.getProperty("Prisonernumber_txt"); }
	
	public String DOB_date()
	{ return Prop.getProperty("PrisonerDOB_date"); }
	
	public String Custody_dpd()
	{ return Prop.getProperty("custody_dpd"); }
	
	public String Releasedate()
	{ return Prop.getProperty("expectedrelease_date"); }
	
	public String NonPayment_dpd()
	{ return Prop.getProperty("non-payment_dpd"); }
	

	
	
	//-------------------------------------------------Citizen Documents page page----------
	
	public String ADDFiles_btn()
	{ return Prop.getProperty("Addfiles_btn"); }
	
	public String ChooseFile_btn()
	{ return Prop.getProperty("Choose_btn"); }
	
	public String Addfile_Popup_btn()
	{ return Prop.getProperty("Add_popup_btn"); }
	
	public String PopupCancel_btn()
	{ return Prop.getProperty("Cancel_popup_btn"); }
	
	//------------------------------------------------Review Request Details---------------
	
	public String CheckBox()
	{ return Prop.getProperty("Checkbox"); }
	
	public String Review_btn()
	{ return Prop.getProperty("Review_btn"); }
	
	public String Edit_btn()
	{ return Prop.getProperty("Edit_btn"); }
	
	public String SaveClose_btn()
	{ return Prop.getProperty("SaveClose_btn"); }
	
	public String Submit_btn()
	{ return Prop.getProperty("Submit_btn"); }
	
	//------------------------------------------------Submition---------------
	
	public String Gotohome_btn()
	{ return Prop.getProperty("Gotohome_button"); }
	
	public String Casenumber()
	{ return Prop.getProperty("Case_number"); }
	
	public String Servicesummary_txt()   // Last Page Service summary heading text
	{
		return Prop.getProperty("ServiceSummary_heading_txt");
	}
	
	
//---------------------------------------------Class V---------------------------------------

		
		public String FirstNamediplomat_txt() 
		{ return Prop.getProperty("FirstNameofdiplomattxt");  }
		
		
		public String LastNameofdiplomat_txt() 
		{ return Prop.getProperty("LastNameofdiplomat1");  		}
		
		
		public String Residence_UnitedKingdom() 
		{		return Prop.getProperty("UnitedKingdom");			}
			
		public String tenancyagreement()
		{			return Prop.getProperty("tenancy_agreement");		}
		
		public String UKdiplomat()   
		{		 return  Prop.getProperty("UKdiplomat_txt");		}

		public String Diplomatic_txt()
		{			return Prop.getProperty("Diplomatic");		}
		
		public String Countryinternational_txt() 
		{		return Prop.getProperty("Countryinternational");		}

		public String British_citizen() 
		{			return Prop.getProperty("British_citizen_txt"); 		}

		public String UK_resident() 
		{ 		return Prop.getProperty("UK_resident_txt");		}

		public String Diplomatic_rank()
		{			return Prop.getProperty("FirstNameofdiplomat1"); 		}
		

//---------------------------------------------Class G---------------------------------------

		public String ClassG_FullNameofPerson() 
		{ 			return Prop.getProperty("FullNameOfPerson_txt");		}
	
		public String ClassG_PropertybecameUnoccupied() 
		{			return Prop.getProperty("PropertyUnOccupied_Date");		}
	
		public String ClassG_LegalNotice() 
		{			return Prop.getProperty("LegalNoticeIssued_dpd");		}
		
		public String ClassG_EffectiveDate() 
		{			return Prop.getProperty("EffectiveDateProhibition");		}
		
		public String ClassG_AnyFurtherInfo() 
		{			return Prop.getProperty("AnyfurtherInfo_txt");		}
	

//---------------------------------------------Class I---------------------------------------
		
		public String ClassI_FirstName_leftPropertyReceiveCare() 
		{			return Prop.getProperty("FirstName_leftPropertyReceiveCare_txt");		}
		
		public String ClassI_LastName_leftPropertyReceiveCare() 
		{			return Prop.getProperty("LastName_leftPropertyReceiveCare_txt");		}
		
		public String ClassI_PropertyUnoccupied_Date() 
		{			return Prop.getProperty("PropertyUnoccupied_Date");		}
		
		public String ClassI_OwnerTenant_Unoccupied_property() 
		{			return Prop.getProperty("OwnerTenant_Unoccupied_property_dpd");		}
		
		public String ClassI_Address_Person_receiving_care_Postcode() 
		{			return Prop.getProperty("Address_Person_receiving_care_Postcode");		}
		
		public String ClassI_Address_Person_receiving_care_GO() 
		{			return Prop.getProperty("Address_Person_receiving_care_Go");		}
		
		public String ClassI_Address_Person_receiving_care_dpd() 
		{			return Prop.getProperty("Address_Person_receiving_care_dpd");		}
		
		public String ClassI_Address_Person_receiving_care_Selectedfinal() 
		{			return Prop.getProperty("Address_Person_receiving_care_selected");		}
		
		public String ClassI_PersonMovetoAddress_Date() 
		{			return Prop.getProperty("PersonMovetoAddress_Date");		}
		
		public String ClassI_WhyCareProvided() 
		{			return Prop.getProperty("WhyCareProvided_dpd");		}
		
		public String ClassI_DescribeNatureOfCare() 
		{			return Prop.getProperty("DescribeNatureOfCare_txt");		}
		
		
		
//---------------------------------------------Class L---------------------------------------
 	
		public String ClassL_FirstName()
		{ 		return Prop.getProperty("Firstname_txt");		}
		
		public String ClassL_LastName()
		{ return Prop.getProperty("LastName_txt");  }
		
		public String ClassL_Property_Unoccupied()
		{ return Prop.getProperty("Property_unoccupied_Date");		}
		
		public String ClassL_PropertyUnfurnished()
		{ return Prop.getProperty("PropertyUnfurnished_dpd");		}
		
		public String ClassL_Repossesiondate()
		{ return Prop.getProperty("Repossesion_date");		}
		
		public String ClassL_Bank_Building_reposs()
		{ return Prop.getProperty("Bank_Building_reposs_txt");		}
		
		public String ClassL_further_Enquiry()
		{ return Prop.getProperty("further_Enquiry_txt");		}
		
		public String ClassL_TanencyStart()
		{ return Prop.getProperty("TanencyStart_Date");		}
		
		
		
//---------------------------------------------Class F---------------------------------------			
		
		public String ClassF_FirstNameInformant()
		{ 		return Prop.getProperty("FirstNameInformant_txt");		}
		
		public String ClassF_LastNameInformant()
		{ return Prop.getProperty("LastNameInformant_txt");  }
		
		public String ClassF_CTADeceasedPerson()
		{ return Prop.getProperty("CTADeceasedPerson_txt");		}
		
		public String ClassF_FirstName_Deceased()
		{ return Prop.getProperty("FirstName_Deceased_txt");		}
		
		public String ClassF_LastName_Deceased()
		{ return Prop.getProperty("LastName_Deceased_txt");		}
		
		public String ClassF_Person_Died()
		{ return Prop.getProperty("PersonDied_Date");		}
		
		public String ClassF_PropertyUnoccupied()
		{ return Prop.getProperty("PropertyUnoccupied_dpd");		}
		
		public String ClassF_Furnished_Unfurnished()
		{ return Prop.getProperty("Furnished_Unfurnished_dpd");		}
		
		public String ClassF_DateFurnitureRemoved()
		{ 		return Prop.getProperty("FurnitureRemoved_Date");		}
		
		public String ClassF_AdministrationGranted()
		{ return Prop.getProperty("AdministrationGranted_dpd");  }
		
		public String ClassF_AdministrationGrantedDate()
		{ return Prop.getProperty("AdministrationGranted_Date");		}
		
		public String ClassF_Name_Address_Administrator()
		{ return Prop.getProperty("Name_Address_Administrator_txt");		}
		
		public String ClassF_Name_Address_Solicitor()
		{ return Prop.getProperty("Name_Address_Solicitors_txt");		}
		
		public String ClassF_Deceased_Tenant_Owner()
		{ return Prop.getProperty("Deceased_Tenant_Owner_dpd");		}
		
		public String ClassF_TenancyEnded()
		{ return Prop.getProperty("TenancyEnded_dpd");		}
		
		public String ClassF_TenancyEndDate()
		{ return Prop.getProperty("TenancyEndDate");		}
		
		public String ClassF_Name_Address_Landlord()
		{ return Prop.getProperty("Name_Address_Landlord_txt");		}
		
		public String ClassF_Administration_Granted_ownership_beneficiarys()
		{ return Prop.getProperty("Administration_Granted_ownership_beneficiary_dpd");		}
		
		public String ClassF_Ownership_Transferred()
		{ return Prop.getProperty("Ownership_Transferred_Date");		}
		
		public String ClassF_Name_Address_NewOwner()
		{ return Prop.getProperty("Name_Address_NewOwner_txt");		}
		
		
		
		
//---------------------------------------------Class B---------------------------------------			
		
		
		public String ClassB_Name_Organisation()
		{ return Prop.getProperty("Name_Organisation_txt");		}
		
		public String ClassB_FirstName_MakingClaim_onbehalf_organisation()
		{ return Prop.getProperty("FirstName_MakingClaim_onbehalf_organisation_txt");		}
		
		public String ClassB_LastName_MakingClaim_onbehalf_organisation()
		{ return Prop.getProperty("LastName_MakingClaim_onbehalf_organisation_txt");		}
		
		public String ClassB_Organisation_liable_CT_Housing()
		{ return Prop.getProperty("Organisation_liable_CT_Housing_dpd");		}
		
		public String ClassB_Date_PropertyVacated()
		{ return Prop.getProperty("Date_PropertyVacated");		}
		
		public String ClassB_Property_OwnedLeased_organisation()
		{ return Prop.getProperty("Property_OwnedLeased_organisation_dpd");		}
		
		public String ClassB_BodyEstablishedCharitable()
		{ return Prop.getProperty("BodyEstablishedCharitable_dpd");		}
		
		public String ClassB_LastTenant_social_affordableRent()
		{ return Prop.getProperty("LastTenant_social_affordableRent_dpd");		}
		
		public String ClassB_CharitableObjectives_Organisation()
		{ return Prop.getProperty("CharitableObjectives_Organisation_dpd");		}
		
		public String ClassB_FirstName_PreviousTenant()
		{ return Prop.getProperty("FirstName_PreviousTenant_txt");		}
		
		public String ClassB_LastName_PreviousTenant()
		{ return Prop.getProperty("LastName_PreviousTenant_txt");		}
		
		public String ClassB_Property_Reoccupied()
		{ return Prop.getProperty("Property_Reoccupied_dpd");		}
		
		public String ClassB_FirstName_NewTenant()
		{ return Prop.getProperty("FirstName_NewTenant_txt");		}
		
		public String ClassB_LastName_NewTenant()
		{ return Prop.getProperty("LastName_NewTenant_txt");		}
		
		public String ClassB_NewTenant_StartDate()
		{ return Prop.getProperty("NewTenant_StartDate");		}
		
		public String ClassB_Details_property_used()
		{ return Prop.getProperty("Details_property_used_txt");		}
		

//---------------------------------------------Class K---------------------------------------	

		public String ClassK_FirstName_PropertyVacated()
		{ return Prop.getProperty("FirstName_PropertyVacated_txt");		}
		
		public String ClassK_LastName_propertyVacated()
		{ return Prop.getProperty("LastName_propertyVacated_txt");		}
		
		public String ClassK_Owner_Tenant_PropertyUnoccupied()
		{ return Prop.getProperty("Owner_Tenant_PropertyUnoccupied_dpd");		}
		
		public String ClassK_Date_propertyunoccupied()
		{ return Prop.getProperty("Date_propertyunoccupied");		}
		
		public String ClassK_AnyOtherAdultsResides()
		{ return Prop.getProperty("AnyOtherAdultsResides_dpd");		}
		
		public String ClassK_FirstName_Residents()
		{ return Prop.getProperty("FirstName_Residents_txt");		}
		
		public String ClassK_LastName_Residents()
		{ return Prop.getProperty("LastName_Residents_txt");		}
		
		public String ClassK_Person_student()
		{ return Prop.getProperty("Person_student_dpd");		}
		
		public String ClassK_ForwardingAddress()
		{ return Prop.getProperty("ForwardingAddress_txt");		}
		
		public String ClassK_UniversityCollegeName()
		{ return Prop.getProperty("UniversityCollegeName_txt");		}
		
		public String ClassK_Course_StartDate()
		{ return Prop.getProperty("Course_StartDate");		}
		
		public String ClassK_Course_EndDate()
		{ return Prop.getProperty("Course_EndDate");		}
		
		public String ClassK_UniversityCollege_You_Studying()
		{ return Prop.getProperty("UniversityCollege_You_Studying_txt");		}
		
		public String ClassK_Course_You_StartDate()
		{ return Prop.getProperty("Course_You_StartDate");		}
		
		public String ClassK_Course_You_EndDate()
		{ return Prop.getProperty("Course_You_EndDate");		}
		
		
//---------------------------------------------Class R---------------------------------------			
		
		
		public String ClassR_Name_Owner_pitchORmooring()
		{ return Prop.getProperty("Name_Owner_pitchORmooring_txt");		}
		
		public String ClassR_Boat_Carvan_dpd()
		{ return Prop.getProperty("Boat_Carvan_dpd");		}
		
		public String ClassR_Mooring_Pitch_Vacated_Date()
		{ return Prop.getProperty("Mooring_Pitch_Vacated_Date");		}
		
		
}
