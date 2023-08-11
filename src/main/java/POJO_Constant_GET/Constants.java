package POJO_Constant_GET;

public class Constants {
	 @JsonProperty("Possessions") 
	    public ArrayList<Possession> possessions;
	    @JsonProperty("PropertyTypes") 
	    public ArrayList<PropertyType> propertyTypes;
	    @JsonProperty("BedroomTypes") 
	    public BedroomTypes bedroomTypes;
	    @JsonProperty("IncomeTypes") 
	    public ArrayList<IncomeType> incomeTypes;
	    @JsonProperty("EmailTypes") 
	    public ArrayList<EmailType> emailTypes;
	    @JsonProperty("PhoneTypes") 
	    public ArrayList<PhoneType> phoneTypes;
	    @JsonProperty("LoanTypes") 
	    public ArrayList<LoanType> loanTypes;
	    @JsonProperty("AddressTypes") 
	    public ArrayList<AddressType> addressTypes;
	    @JsonProperty("EducationTypes") 
	    public ArrayList<EducationType> educationTypes;
	    @JsonProperty("WorkTypes") 
	    public ArrayList<WorkType> workTypes;
	    @JsonProperty("SocialMediaTypes") 
	    public ArrayList<SocialMediaType> socialMediaTypes;
	    @JsonProperty("CostDetails") 
	    public ArrayList<CostDetail> costDetails;
	    @JsonProperty("FundingSource") 
	    public ArrayList<FundingSource> fundingSource;
	    @JsonProperty("Purpose") 
	    public ArrayList<Purpose> purpose;
	    @JsonProperty("TransactionType") 
	    public ArrayList<TransactionType> transactionType;
	    @JsonProperty("BuildingAge") 
	    public ArrayList<BuildingAge> buildingAge;
	    @JsonProperty("InterestedInResale") 
	    public ArrayList<InterestedInResale> interestedInResale;
	    @JsonProperty("PropertyPurpose") 
	    public ArrayList<PropertyPurpose> propertyPurpose;
	    @JsonProperty("PropertyOwnership") 
	    public ArrayList<PropertyOwnership> propertyOwnership;
	    @JsonProperty("PropertyFurnishing") 
	    public ArrayList<PropertyFurnishing> propertyFurnishing;
	    @JsonProperty("PropertyFacing") 
	    public ArrayList<PropertyFacing> propertyFacing;
	    @JsonProperty("PropertyBathrooms") 
	    public ArrayList<PropertyBathroom> propertyBathrooms;
	    @JsonProperty("LeadFilterEnabled") 
	    public boolean leadFilterEnabled;
	    @JsonProperty("DefaultSiteVisitMinutes") 
	    public int defaultSiteVisitMinutes;
	    @JsonProperty("ProjectUnitAreas") 
	    public ArrayList<ProjectUnitArea> projectUnitAreas;
	    @JsonProperty("AllowedPropertyPurpose") 
	    public ArrayList<AllowedPropertyPurpose> allowedPropertyPurpose;
	    public ArrayList<LeadStatus> lead_statuses;
	    public LeadStages lead_stages;
	    @JsonProperty("Company_type") 
	    public ArrayList<Object> company_type;
	    @JsonProperty("Funding_source") 
	    public ArrayList<Object> funding_source;
	    @JsonProperty("Furnishing") 
	    public ArrayList<Object> furnishing;
	    @JsonProperty("Gender") 
	    public ArrayList<Object> gender;
	    @JsonProperty("Property_header_list") 
	    public ArrayList<Object> property_header_list;
	    @JsonProperty("Property_purpose") 
	    public ArrayList<Object> property_purpose;
	    @JsonProperty("Salutation") 
	    public ArrayList<Object> salutation;
	    @JsonProperty("Site_visit_type") 
	    public ArrayList<Object> site_visit_type;
	    @JsonProperty("Transaction_type") 
	    public ArrayList<Object> transaction_type;
	    public ArrayList<String> interested_property_stages;
	    @JsonProperty("Projects") 
	    public ArrayList<Project> projects;
	    @JsonProperty("Campaigns") 
	    public ArrayList<Campaign> campaigns;
	    @JsonProperty("AllLeadsScId") 
	    public String allLeadsScId;
	    @JsonProperty("Ivrs") 
	    public ArrayList<Ivr> ivrs;
	    @JsonProperty("IvrSetting") 
	    public IvrSetting ivrSetting;
	    @JsonProperty("LeadLostReasons") 
	    public ArrayList<LeadLostReason> leadLostReasons;
	    @JsonProperty("LeadUnqualifiedReasons") 
	    public ArrayList<LeadUnqualifiedReason> leadUnqualifiedReasons;
	    @JsonProperty("CallOutcomes") 
	    public ArrayList<CallOutcome> callOutcomes;
	    @JsonProperty("IvrBuilderData") 
	    public ArrayList<IvrBuilderDatum> ivrBuilderData;
	    public boolean inventory_enabled;
	    public boolean enable_iris;
	    public IrisBaseUrl iris_base_url;
	    public boolean post_sales_enabled;
	    public boolean incentives_enabled;
	    public String incentive_duration;
	    public boolean ipc_mode;
	    public Client client;
	    public boolean enable_push_notification;
	    @JsonProperty("Users") 
	    public ArrayList<User> users;
	    @JsonProperty("DefaultSearchCriteria") 
	    public ArrayList<DefaultSearchCriterion> defaultSearchCriteria;
	    public BookingForm booking_form;
	    @JsonProperty("BookingCancellationReasons") 
	    public ArrayList<BookingCancellationReason> bookingCancellationReasons;
	    public PreSales pre_sales;
	    public ClientConfiguration client_configuration;
	    public ArrayList<ProjectUnitStage> project_unit_stages;
	    @JsonProperty("Teams") 
	    public ArrayList<Team> teams;
	    public String default_hierarchy_id;
	    public ActivityCalenderTime activity_calender_time;
	    public ArrayList<LeadCustomField> lead_custom_fields;
	    public ArrayList<Object> followup_custom_fields;
	    public ArrayList<SiteVisitCustomField> site_visit_custom_fields;
	    public ArrayList<BookingDetailCustomField> booking_detail_custom_fields;
	    public ArrayList<Object> call_custom_fields;
	    public ArrayList<CampaignSource> campaign_sources;
	    public InventoryConf inventory_conf;
	    public boolean whatsapp_setting_available;
	    public boolean whatsapp_opt_in_enabled;
	    public boolean whatsapp_session_enabled;
	    public Summernote summernote;
	    public int per_page;
	    public ArrayList<String> countries;
	    public ArrayList<String> states;
	    @JsonProperty("KnowlarityPremiumCategories") 
	    public KnowlarityPremiumCategories knowlarityPremiumCategories;
	    public ArrayList<BookingStage> booking_stages;
	    public ArrayList<ApiClient> api_clients;
	    public CurrentUser current_user;
	    @JsonProperty("BookingDetails") 
	    public ArrayList<Object> bookingDetails;
	    @JsonProperty("AppBaseUrl") 
	    public String appBaseUrl;
	    public ArrayList<BookingDetailStage> booking_detail_stages;
	    public OauthConfig oauth_config;
	    public ArrayList<String> task_statuses;
	    public ArrayList<String> task_priorities;
	    public ArrayList<String> sms_statuses;
	    public ArrayList<String> sms_types;
	    public ArrayList<String> receiver;
	    public ArrayList<String> channel;
	    public ArrayList<String> intervalType;
	    public ArrayList<String> notificationType;
	    public ArrayList<NotificationSubType> notificationSubType;
	    public ArrayList<String> sv_event;
	    public ArrayList<String> billing_event;
	    public SvVerificationConf sv_verification_conf;
	    public ArrayList<String> break_types;
	    @JsonProperty("RoutingConfiguration") 
	    public RoutingConfiguration routingConfiguration;
	    public ReassignmentReasons reassignment_reasons;
	    public ArrayList<LeadColumnsList> lead_columns_list;
	    @JsonProperty("Locations") 
	    public ArrayList<Object> locations;
	    @JsonProperty("AllBookingsScId") 
	    public String allBookingsScId;
	    public ArrayList<Object> cities;
	    public Budget budget;
	    public ArrayList<Object> project_towers;
	    @JsonProperty("HierarchyNodeData") 
	    public HierarchyNodeData hierarchyNodeData;
	    public ArrayList<FollowupCancellationReason> followup_cancellation_reasons;
}
