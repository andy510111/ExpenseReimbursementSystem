package projectone.model;

import javax.persistence.*;

@Entity
@Table(name="reimbursement", schema="public")
public class Reimbursement {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="reimbursementId")
	private int reimbursementId;
	
	@Column(name="accepted")
	private boolean accepted;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="reimbursementType")
	private String reimbursementType;
	
	@Column(nullable=true, name="resolveTime")
	private String resolveTime;
	
	@Column(nullable=true, name="resolved")
	private boolean resolved;
	
	@Column(name="submitTime")
	private String submitTime;
	
	@Column(name="authorId")
	private int authorId;
	
	@Column(nullable=true, name="resolverId")
	private Integer resolverId;

	public Reimbursement(int reimbursementId, boolean accepted, float amount, String description,
			String reimbursementType, String resolveTime, boolean resolved, String submitTime, int authorId,
			Integer resolverId) {
		super();
		this.reimbursementId = reimbursementId;
		this.accepted = accepted;
		this.amount = amount;
		this.description = description;
		this.reimbursementType = reimbursementType;
		this.resolveTime = resolveTime;
		this.resolved = resolved;
		this.submitTime = submitTime;
		this.authorId = authorId;
		this.resolverId = resolverId;
	}
	
	public Reimbursement() {
		
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public Integer getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", accepted=" + accepted + ", amount=" + amount
				+ ", description=" + description + ", reimbursementType=" + reimbursementType + ", resolveTime="
				+ resolveTime + ", resolved=" + resolved + ", submitTime=" + submitTime + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + "]";
	}

}
