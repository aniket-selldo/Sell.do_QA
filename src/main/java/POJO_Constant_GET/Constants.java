package POJO_Constant_GET;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	    public PreSale pre_sales;
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
		public ArrayList<Possession> getPossessions() {
			return possessions;
		}
		public void setPossessions(ArrayList<Possession> possessions) {
			this.possessions = possessions;
		}
		public ArrayList<PropertyType> getPropertyTypes() {
			return propertyTypes;
		}
		public void setPropertyTypes(ArrayList<PropertyType> propertyTypes) {
			this.propertyTypes = propertyTypes;
		}
		public BedroomTypes getBedroomTypes() {
			return bedroomTypes;
		}
		public void setBedroomTypes(BedroomTypes bedroomTypes) {
			this.bedroomTypes = bedroomTypes;
		}
		public ArrayList<IncomeType> getIncomeTypes() {
			return incomeTypes;
		}
		public void setIncomeTypes(ArrayList<IncomeType> incomeTypes) {
			this.incomeTypes = incomeTypes;
		}
		public ArrayList<EmailType> getEmailTypes() {
			return emailTypes;
		}
		public void setEmailTypes(ArrayList<EmailType> emailTypes) {
			this.emailTypes = emailTypes;
		}
		public ArrayList<PhoneType> getPhoneTypes() {
			return phoneTypes;
		}
		public void setPhoneTypes(ArrayList<PhoneType> phoneTypes) {
			this.phoneTypes = phoneTypes;
		}
		public ArrayList<LoanType> getLoanTypes() {
			return loanTypes;
		}
		public void setLoanTypes(ArrayList<LoanType> loanTypes) {
			this.loanTypes = loanTypes;
		}
		public ArrayList<AddressType> getAddressTypes() {
			return addressTypes;
		}
		public void setAddressTypes(ArrayList<AddressType> addressTypes) {
			this.addressTypes = addressTypes;
		}
		public ArrayList<EducationType> getEducationTypes() {
			return educationTypes;
		}
		public void setEducationTypes(ArrayList<EducationType> educationTypes) {
			this.educationTypes = educationTypes;
		}
		public ArrayList<WorkType> getWorkTypes() {
			return workTypes;
		}
		public void setWorkTypes(ArrayList<WorkType> workTypes) {
			this.workTypes = workTypes;
		}
		public ArrayList<SocialMediaType> getSocialMediaTypes() {
			return socialMediaTypes;
		}
		public void setSocialMediaTypes(ArrayList<SocialMediaType> socialMediaTypes) {
			this.socialMediaTypes = socialMediaTypes;
		}
		public ArrayList<CostDetail> getCostDetails() {
			return costDetails;
		}
		public void setCostDetails(ArrayList<CostDetail> costDetails) {
			this.costDetails = costDetails;
		}
		public ArrayList<FundingSource> getFundingSource() {
			return fundingSource;
		}
		public void setFundingSource(ArrayList<FundingSource> fundingSource) {
			this.fundingSource = fundingSource;
		}
		public ArrayList<Purpose> getPurpose() {
			return purpose;
		}
		public void setPurpose(ArrayList<Purpose> purpose) {
			this.purpose = purpose;
		}
		public ArrayList<TransactionType> getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(ArrayList<TransactionType> transactionType) {
			this.transactionType = transactionType;
		}
		public ArrayList<BuildingAge> getBuildingAge() {
			return buildingAge;
		}
		public void setBuildingAge(ArrayList<BuildingAge> buildingAge) {
			this.buildingAge = buildingAge;
		}
		public ArrayList<InterestedInResale> getInterestedInResale() {
			return interestedInResale;
		}
		public void setInterestedInResale(ArrayList<InterestedInResale> interestedInResale) {
			this.interestedInResale = interestedInResale;
		}
		public ArrayList<PropertyPurpose> getPropertyPurpose() {
			return propertyPurpose;
		}
		public void setPropertyPurpose(ArrayList<PropertyPurpose> propertyPurpose) {
			this.propertyPurpose = propertyPurpose;
		}
		public ArrayList<PropertyOwnership> getPropertyOwnership() {
			return propertyOwnership;
		}
		public void setPropertyOwnership(ArrayList<PropertyOwnership> propertyOwnership) {
			this.propertyOwnership = propertyOwnership;
		}
		public ArrayList<PropertyFurnishing> getPropertyFurnishing() {
			return propertyFurnishing;
		}
		public void setPropertyFurnishing(ArrayList<PropertyFurnishing> propertyFurnishing) {
			this.propertyFurnishing = propertyFurnishing;
		}
		public ArrayList<PropertyFacing> getPropertyFacing() {
			return propertyFacing;
		}
		public void setPropertyFacing(ArrayList<PropertyFacing> propertyFacing) {
			this.propertyFacing = propertyFacing;
		}
		public ArrayList<PropertyBathroom> getPropertyBathrooms() {
			return propertyBathrooms;
		}
		public void setPropertyBathrooms(ArrayList<PropertyBathroom> propertyBathrooms) {
			this.propertyBathrooms = propertyBathrooms;
		}
		public boolean isLeadFilterEnabled() {
			return leadFilterEnabled;
		}
		public void setLeadFilterEnabled(boolean leadFilterEnabled) {
			this.leadFilterEnabled = leadFilterEnabled;
		}
		public int getDefaultSiteVisitMinutes() {
			return defaultSiteVisitMinutes;
		}
		public void setDefaultSiteVisitMinutes(int defaultSiteVisitMinutes) {
			this.defaultSiteVisitMinutes = defaultSiteVisitMinutes;
		}
		public ArrayList<ProjectUnitArea> getProjectUnitAreas() {
			return projectUnitAreas;
		}
		public void setProjectUnitAreas(ArrayList<ProjectUnitArea> projectUnitAreas) {
			this.projectUnitAreas = projectUnitAreas;
		}
		public ArrayList<AllowedPropertyPurpose> getAllowedPropertyPurpose() {
			return allowedPropertyPurpose;
		}
		public void setAllowedPropertyPurpose(ArrayList<AllowedPropertyPurpose> allowedPropertyPurpose) {
			this.allowedPropertyPurpose = allowedPropertyPurpose;
		}
		public ArrayList<LeadStatus> getLead_statuses() {
			return lead_statuses;
		}
		public void setLead_statuses(ArrayList<LeadStatus> lead_statuses) {
			this.lead_statuses = lead_statuses;
		}
		public LeadStages getLead_stages() {
			return lead_stages;
		}
		public void setLead_stages(LeadStages lead_stages) {
			this.lead_stages = lead_stages;
		}
		public ArrayList<Object> getCompany_type() {
			return company_type;
		}
		public void setCompany_type(ArrayList<Object> company_type) {
			this.company_type = company_type;
		}
		public ArrayList<Object> getFunding_source() {
			return funding_source;
		}
		public void setFunding_source(ArrayList<Object> funding_source) {
			this.funding_source = funding_source;
		}
		public ArrayList<Object> getFurnishing() {
			return furnishing;
		}
		public void setFurnishing(ArrayList<Object> furnishing) {
			this.furnishing = furnishing;
		}
		public ArrayList<Object> getGender() {
			return gender;
		}
		public void setGender(ArrayList<Object> gender) {
			this.gender = gender;
		}
		public ArrayList<Object> getProperty_header_list() {
			return property_header_list;
		}
		public void setProperty_header_list(ArrayList<Object> property_header_list) {
			this.property_header_list = property_header_list;
		}
		public ArrayList<Object> getProperty_purpose() {
			return property_purpose;
		}
		public void setProperty_purpose(ArrayList<Object> property_purpose) {
			this.property_purpose = property_purpose;
		}
		public ArrayList<Object> getSalutation() {
			return salutation;
		}
		public void setSalutation(ArrayList<Object> salutation) {
			this.salutation = salutation;
		}
		public ArrayList<Object> getSite_visit_type() {
			return site_visit_type;
		}
		public void setSite_visit_type(ArrayList<Object> site_visit_type) {
			this.site_visit_type = site_visit_type;
		}
		public ArrayList<Object> getTransaction_type() {
			return transaction_type;
		}
		public void setTransaction_type(ArrayList<Object> transaction_type) {
			this.transaction_type = transaction_type;
		}
		public ArrayList<String> getInterested_property_stages() {
			return interested_property_stages;
		}
		public void setInterested_property_stages(ArrayList<String> interested_property_stages) {
			this.interested_property_stages = interested_property_stages;
		}
		public ArrayList<Project> getProjects() {
			return projects;
		}
		public void setProjects(ArrayList<Project> projects) {
			this.projects = projects;
		}
		public ArrayList<Campaign> getCampaigns() {
			return campaigns;
		}
		public void setCampaigns(ArrayList<Campaign> campaigns) {
			this.campaigns = campaigns;
		}
		public String getAllLeadsScId() {
			return allLeadsScId;
		}
		public void setAllLeadsScId(String allLeadsScId) {
			this.allLeadsScId = allLeadsScId;
		}
		public ArrayList<Ivr> getIvrs() {
			return ivrs;
		}
		public void setIvrs(ArrayList<Ivr> ivrs) {
			this.ivrs = ivrs;
		}
		public IvrSetting getIvrSetting() {
			return ivrSetting;
		}
		public void setIvrSetting(IvrSetting ivrSetting) {
			this.ivrSetting = ivrSetting;
		}
		public ArrayList<LeadLostReason> getLeadLostReasons() {
			return leadLostReasons;
		}
		public void setLeadLostReasons(ArrayList<LeadLostReason> leadLostReasons) {
			this.leadLostReasons = leadLostReasons;
		}
		public ArrayList<LeadUnqualifiedReason> getLeadUnqualifiedReasons() {
			return leadUnqualifiedReasons;
		}
		public void setLeadUnqualifiedReasons(ArrayList<LeadUnqualifiedReason> leadUnqualifiedReasons) {
			this.leadUnqualifiedReasons = leadUnqualifiedReasons;
		}
		public ArrayList<CallOutcome> getCallOutcomes() {
			return callOutcomes;
		}
		public void setCallOutcomes(ArrayList<CallOutcome> callOutcomes) {
			this.callOutcomes = callOutcomes;
		}
		public ArrayList<IvrBuilderDatum> getIvrBuilderData() {
			return ivrBuilderData;
		}
		public void setIvrBuilderData(ArrayList<IvrBuilderDatum> ivrBuilderData) {
			this.ivrBuilderData = ivrBuilderData;
		}
		public boolean isInventory_enabled() {
			return inventory_enabled;
		}
		public void setInventory_enabled(boolean inventory_enabled) {
			this.inventory_enabled = inventory_enabled;
		}
		public boolean isEnable_iris() {
			return enable_iris;
		}
		public void setEnable_iris(boolean enable_iris) {
			this.enable_iris = enable_iris;
		}
		public IrisBaseUrl getIris_base_url() {
			return iris_base_url;
		}
		public void setIris_base_url(IrisBaseUrl iris_base_url) {
			this.iris_base_url = iris_base_url;
		}
		public boolean isPost_sales_enabled() {
			return post_sales_enabled;
		}
		public void setPost_sales_enabled(boolean post_sales_enabled) {
			this.post_sales_enabled = post_sales_enabled;
		}
		public boolean isIncentives_enabled() {
			return incentives_enabled;
		}
		public void setIncentives_enabled(boolean incentives_enabled) {
			this.incentives_enabled = incentives_enabled;
		}
		public String getIncentive_duration() {
			return incentive_duration;
		}
		public void setIncentive_duration(String incentive_duration) {
			this.incentive_duration = incentive_duration;
		}
		public boolean isIpc_mode() {
			return ipc_mode;
		}
		public void setIpc_mode(boolean ipc_mode) {
			this.ipc_mode = ipc_mode;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		public boolean isEnable_push_notification() {
			return enable_push_notification;
		}
		public void setEnable_push_notification(boolean enable_push_notification) {
			this.enable_push_notification = enable_push_notification;
		}
		public ArrayList<User> getUsers() {
			return users;
		}
		public void setUsers(ArrayList<User> users) {
			this.users = users;
		}
		public ArrayList<DefaultSearchCriterion> getDefaultSearchCriteria() {
			return defaultSearchCriteria;
		}
		public void setDefaultSearchCriteria(ArrayList<DefaultSearchCriterion> defaultSearchCriteria) {
			this.defaultSearchCriteria = defaultSearchCriteria;
		}
		public BookingForm getBooking_form() {
			return booking_form;
		}
		public void setBooking_form(BookingForm booking_form) {
			this.booking_form = booking_form;
		}
		public ArrayList<BookingCancellationReason> getBookingCancellationReasons() {
			return bookingCancellationReasons;
		}
		public void setBookingCancellationReasons(ArrayList<BookingCancellationReason> bookingCancellationReasons) {
			this.bookingCancellationReasons = bookingCancellationReasons;
		}
		public PreSale getPre_sales() {
			return pre_sales;
		}
		public void setPre_sales(PreSale pre_sales) {
			this.pre_sales = pre_sales;
		}
		public ClientConfiguration getClient_configuration() {
			return client_configuration;
		}
		public void setClient_configuration(ClientConfiguration client_configuration) {
			this.client_configuration = client_configuration;
		}
		public ArrayList<ProjectUnitStage> getProject_unit_stages() {
			return project_unit_stages;
		}
		public void setProject_unit_stages(ArrayList<ProjectUnitStage> project_unit_stages) {
			this.project_unit_stages = project_unit_stages;
		}
		public ArrayList<Team> getTeams() {
			return teams;
		}
		public void setTeams(ArrayList<Team> teams) {
			this.teams = teams;
		}
		public String getDefault_hierarchy_id() {
			return default_hierarchy_id;
		}
		public void setDefault_hierarchy_id(String default_hierarchy_id) {
			this.default_hierarchy_id = default_hierarchy_id;
		}
		public ActivityCalenderTime getActivity_calender_time() {
			return activity_calender_time;
		}
		public void setActivity_calender_time(ActivityCalenderTime activity_calender_time) {
			this.activity_calender_time = activity_calender_time;
		}
		public ArrayList<LeadCustomField> getLead_custom_fields() {
			return lead_custom_fields;
		}
		public void setLead_custom_fields(ArrayList<LeadCustomField> lead_custom_fields) {
			this.lead_custom_fields = lead_custom_fields;
		}
		public ArrayList<Object> getFollowup_custom_fields() {
			return followup_custom_fields;
		}
		public void setFollowup_custom_fields(ArrayList<Object> followup_custom_fields) {
			this.followup_custom_fields = followup_custom_fields;
		}
		public ArrayList<SiteVisitCustomField> getSite_visit_custom_fields() {
			return site_visit_custom_fields;
		}
		public void setSite_visit_custom_fields(ArrayList<SiteVisitCustomField> site_visit_custom_fields) {
			this.site_visit_custom_fields = site_visit_custom_fields;
		}
		public ArrayList<BookingDetailCustomField> getBooking_detail_custom_fields() {
			return booking_detail_custom_fields;
		}
		public void setBooking_detail_custom_fields(ArrayList<BookingDetailCustomField> booking_detail_custom_fields) {
			this.booking_detail_custom_fields = booking_detail_custom_fields;
		}
		public ArrayList<Object> getCall_custom_fields() {
			return call_custom_fields;
		}
		public void setCall_custom_fields(ArrayList<Object> call_custom_fields) {
			this.call_custom_fields = call_custom_fields;
		}
		public ArrayList<CampaignSource> getCampaign_sources() {
			return campaign_sources;
		}
		public void setCampaign_sources(ArrayList<CampaignSource> campaign_sources) {
			this.campaign_sources = campaign_sources;
		}
		public InventoryConf getInventory_conf() {
			return inventory_conf;
		}
		public void setInventory_conf(InventoryConf inventory_conf) {
			this.inventory_conf = inventory_conf;
		}
		public boolean isWhatsapp_setting_available() {
			return whatsapp_setting_available;
		}
		public void setWhatsapp_setting_available(boolean whatsapp_setting_available) {
			this.whatsapp_setting_available = whatsapp_setting_available;
		}
		public boolean isWhatsapp_opt_in_enabled() {
			return whatsapp_opt_in_enabled;
		}
		public void setWhatsapp_opt_in_enabled(boolean whatsapp_opt_in_enabled) {
			this.whatsapp_opt_in_enabled = whatsapp_opt_in_enabled;
		}
		public boolean isWhatsapp_session_enabled() {
			return whatsapp_session_enabled;
		}
		public void setWhatsapp_session_enabled(boolean whatsapp_session_enabled) {
			this.whatsapp_session_enabled = whatsapp_session_enabled;
		}
		public Summernote getSummernote() {
			return summernote;
		}
		public void setSummernote(Summernote summernote) {
			this.summernote = summernote;
		}
		public int getPer_page() {
			return per_page;
		}
		public void setPer_page(int per_page) {
			this.per_page = per_page;
		}
		public ArrayList<String> getCountries() {
			return countries;
		}
		public void setCountries(ArrayList<String> countries) {
			this.countries = countries;
		}
		public ArrayList<String> getStates() {
			return states;
		}
		public void setStates(ArrayList<String> states) {
			this.states = states;
		}
		public KnowlarityPremiumCategories getKnowlarityPremiumCategories() {
			return knowlarityPremiumCategories;
		}
		public void setKnowlarityPremiumCategories(KnowlarityPremiumCategories knowlarityPremiumCategories) {
			this.knowlarityPremiumCategories = knowlarityPremiumCategories;
		}
		public ArrayList<BookingStage> getBooking_stages() {
			return booking_stages;
		}
		public void setBooking_stages(ArrayList<BookingStage> booking_stages) {
			this.booking_stages = booking_stages;
		}
		public ArrayList<ApiClient> getApi_clients() {
			return api_clients;
		}
		public void setApi_clients(ArrayList<ApiClient> api_clients) {
			this.api_clients = api_clients;
		}
		public CurrentUser getCurrent_user() {
			return current_user;
		}
		public void setCurrent_user(CurrentUser current_user) {
			this.current_user = current_user;
		}
		public ArrayList<Object> getBookingDetails() {
			return bookingDetails;
		}
		public void setBookingDetails(ArrayList<Object> bookingDetails) {
			this.bookingDetails = bookingDetails;
		}
		public String getAppBaseUrl() {
			return appBaseUrl;
		}
		public void setAppBaseUrl(String appBaseUrl) {
			this.appBaseUrl = appBaseUrl;
		}
		public ArrayList<BookingDetailStage> getBooking_detail_stages() {
			return booking_detail_stages;
		}
		public void setBooking_detail_stages(ArrayList<BookingDetailStage> booking_detail_stages) {
			this.booking_detail_stages = booking_detail_stages;
		}
		public OauthConfig getOauth_config() {
			return oauth_config;
		}
		public void setOauth_config(OauthConfig oauth_config) {
			this.oauth_config = oauth_config;
		}
		public ArrayList<String> getTask_statuses() {
			return task_statuses;
		}
		public void setTask_statuses(ArrayList<String> task_statuses) {
			this.task_statuses = task_statuses;
		}
		public ArrayList<String> getTask_priorities() {
			return task_priorities;
		}
		public void setTask_priorities(ArrayList<String> task_priorities) {
			this.task_priorities = task_priorities;
		}
		public ArrayList<String> getSms_statuses() {
			return sms_statuses;
		}
		public void setSms_statuses(ArrayList<String> sms_statuses) {
			this.sms_statuses = sms_statuses;
		}
		public ArrayList<String> getSms_types() {
			return sms_types;
		}
		public void setSms_types(ArrayList<String> sms_types) {
			this.sms_types = sms_types;
		}
		public ArrayList<String> getReceiver() {
			return receiver;
		}
		public void setReceiver(ArrayList<String> receiver) {
			this.receiver = receiver;
		}
		public ArrayList<String> getChannel() {
			return channel;
		}
		public void setChannel(ArrayList<String> channel) {
			this.channel = channel;
		}
		public ArrayList<String> getIntervalType() {
			return intervalType;
		}
		public void setIntervalType(ArrayList<String> intervalType) {
			this.intervalType = intervalType;
		}
		public ArrayList<String> getNotificationType() {
			return notificationType;
		}
		public void setNotificationType(ArrayList<String> notificationType) {
			this.notificationType = notificationType;
		}
		public ArrayList<NotificationSubType> getNotificationSubType() {
			return notificationSubType;
		}
		public void setNotificationSubType(ArrayList<NotificationSubType> notificationSubType) {
			this.notificationSubType = notificationSubType;
		}
		public ArrayList<String> getSv_event() {
			return sv_event;
		}
		public void setSv_event(ArrayList<String> sv_event) {
			this.sv_event = sv_event;
		}
		public ArrayList<String> getBilling_event() {
			return billing_event;
		}
		public void setBilling_event(ArrayList<String> billing_event) {
			this.billing_event = billing_event;
		}
		public SvVerificationConf getSv_verification_conf() {
			return sv_verification_conf;
		}
		public void setSv_verification_conf(SvVerificationConf sv_verification_conf) {
			this.sv_verification_conf = sv_verification_conf;
		}
		public ArrayList<String> getBreak_types() {
			return break_types;
		}
		public void setBreak_types(ArrayList<String> break_types) {
			this.break_types = break_types;
		}
		public RoutingConfiguration getRoutingConfiguration() {
			return routingConfiguration;
		}
		public void setRoutingConfiguration(RoutingConfiguration routingConfiguration) {
			this.routingConfiguration = routingConfiguration;
		}
		public ReassignmentReasons getReassignment_reasons() {
			return reassignment_reasons;
		}
		public void setReassignment_reasons(ReassignmentReasons reassignment_reasons) {
			this.reassignment_reasons = reassignment_reasons;
		}
		public ArrayList<LeadColumnsList> getLead_columns_list() {
			return lead_columns_list;
		}
		public void setLead_columns_list(ArrayList<LeadColumnsList> lead_columns_list) {
			this.lead_columns_list = lead_columns_list;
		}
		public ArrayList<Object> getLocations() {
			return locations;
		}
		public void setLocations(ArrayList<Object> locations) {
			this.locations = locations;
		}
		public String getAllBookingsScId() {
			return allBookingsScId;
		}
		public void setAllBookingsScId(String allBookingsScId) {
			this.allBookingsScId = allBookingsScId;
		}
		public ArrayList<Object> getCities() {
			return cities;
		}
		public void setCities(ArrayList<Object> cities) {
			this.cities = cities;
		}
		public Budget getBudget() {
			return budget;
		}
		public void setBudget(Budget budget) {
			this.budget = budget;
		}
		public ArrayList<Object> getProject_towers() {
			return project_towers;
		}
		public void setProject_towers(ArrayList<Object> project_towers) {
			this.project_towers = project_towers;
		}
		public HierarchyNodeData getHierarchyNodeData() {
			return hierarchyNodeData;
		}
		public void setHierarchyNodeData(HierarchyNodeData hierarchyNodeData) {
			this.hierarchyNodeData = hierarchyNodeData;
		}
		public ArrayList<FollowupCancellationReason> getFollowup_cancellation_reasons() {
			return followup_cancellation_reasons;
		}
		public void setFollowup_cancellation_reasons(ArrayList<FollowupCancellationReason> followup_cancellation_reasons) {
			this.followup_cancellation_reasons = followup_cancellation_reasons;
		}
}
