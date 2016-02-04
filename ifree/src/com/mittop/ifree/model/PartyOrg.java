package com.mittop.ifree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * 
* @packageName: net.risesoft.portal.model
* @ClassName: PartyOrg 
* @Description: 党员组织管理
* @author songzewei
* @date 2015年12月16日 下午4:17:03 
*
 */
@Entity
@Table(name = "cms_party_org")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "cms_party_org_sequence")
public class PartyOrg extends OrderEntity {

	
	private static final long serialVersionUID = 3362735027506224903L;

	/**
	 * 党支部名称
	 */
	private String orgName; 
	
	/**
	 * 党员人数
	 */
	private Integer partyMemberNum;
	
	/**
	 * 党支部书记
	 */
	private String secretary;
	
	/**
	 * 党支部副书记
	 */
	private String deputySecretary;
	
	/**
	 * 党支部委员
	 */
	private String committeeMember;
	
	/**
	 * 本届支部换届时间
	 */
	private Date changeDate;
	
	/**
	 * 党小组数
	 */
	private Integer teamNum;
	
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 附件
	 */
	private String attachment;


	@Column(columnDefinition="clob")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Length(max = 3000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getPartyMemberNum() {
		return partyMemberNum;
	}

	public void setPartyMemberNum(Integer partyMemberNum) {
		this.partyMemberNum = partyMemberNum;
	}

	@Length(max = 100)
	public String getSecretary() {
		return secretary;
	}

	public void setSecretary(String secretary) {
		this.secretary = secretary;
	}

	@Length(max = 100)
	public String getDeputySecretary() {
		return deputySecretary;
	}

	public void setDeputySecretary(String deputySecretary) {
		this.deputySecretary = deputySecretary;
	}

	@Length(max = 100)
	public String getCommitteeMember() {
		return committeeMember;
	}

	public void setCommitteeMember(String committeeMember) {
		this.committeeMember = committeeMember;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Integer getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}

}
