package mvc;

import javax.servlet.http.HttpServletRequest;

public interface Canon {
	public String calc(HttpServletRequest request) throws CanonException;
}
