package instagram;

public interface IProfile {

	void subscribe(Profile p);

	void unsubscribe(Profile p);

	void notifySubscribers();

}
