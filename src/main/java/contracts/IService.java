package contracts;

import com.training.junit.exceptions.EmailTooShortException;
import com.training.junit.exceptions.UserNotFoundException;

public interface IService {
	public boolean insert(String email, String name, String password) throws EmailTooShortException ;
	
	public boolean update(String email, String name, String password) throws UserNotFoundException;
	
	public boolean delete(String email) throws UserNotFoundException ;
	
	public Object getDetails(String email) throws UserNotFoundException ;
}
