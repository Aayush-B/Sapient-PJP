package contracts;

import com.training.junit.exceptions.UserNotFoundException;
import com.training.junit.services.User;

public interface IDAO {
	public boolean insert(User user) ;
	
	public boolean delete(String email) throws UserNotFoundException;
	
	public boolean update(User user) throws UserNotFoundException ;
	
	public Object getDetails(String email) throws UserNotFoundException;
	
}
