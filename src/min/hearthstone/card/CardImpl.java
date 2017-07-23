package min.hearthstone.card;

public abstract class CardImpl implements Card{

	private int tier;//카드 티어
	private String description;//카드 설명
	private Enum<CardPackage> cardPackage;//카드 패키지 오리지널만 구현
	private Enum<CardClass> cardClass;//카드 등급
	private Enum<CardState> cardState;//카드 상태. 유저가 쓸 수 있는 것인지, 운영상 필요한 카드인지 등등
	private Enum<CardJob> cardJob;//카드 직업 분류
	
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enum<CardPackage> getCardPackage() {
		return cardPackage;
	}
	public void setCardPackage(Enum<CardPackage> cardPackage) {
		this.cardPackage = cardPackage;
	}
	public Enum<CardClass> getCardClass() {
		return cardClass;
	}
	public void setCardClass(Enum<CardClass> cardClass) {
		this.cardClass = cardClass;
	}
	public Enum<CardState> getCardState() {
		return cardState;
	}
	public void setCardState(Enum<CardState> cardState) {
		this.cardState = cardState;
	}
	public Enum<CardJob> getCardJob() {
		return cardJob;
	}
	public void setCardJob(Enum<CardJob> cardJob) {
		this.cardJob = cardJob;
	}
	
	
	
}
