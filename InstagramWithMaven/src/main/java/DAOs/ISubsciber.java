package DAOs;

import exceptions.DataBaseProblemException;
import instagram.Profile;

public interface ISubsciber {
	

	void addSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException;

	void removeSubscriber(Profile user, Profile subscriber) throws DataBaseProblemException;

}
