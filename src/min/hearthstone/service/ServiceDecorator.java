package min.hearthstone.service;

public abstract class ServiceDecorator implements Service{

	protected Service target;

	public void setTarget(Service target) {
		this.target = target;
	}

	public ServiceDecorator() {
	}

	public ServiceDecorator(Service target) {
		this.target = target;
	}
	
}
