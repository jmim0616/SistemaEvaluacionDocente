package system.pack.helper;

import java.util.List;
import java.util.Map;

import system.pack.vo.TeacherBean;

public class JsonResponse <T, S>  {

	private T objectBean;
	
	private S objectEntity;
	
	private List<T> objectBeanList;
	
	private List<S> objectEntityList;
	
	private boolean isValid;
	
	private Map<String, String> errorMessages;
	
	private String successMessages;
	
	private String View;
	
	public JsonResponse () {
		
	}

	public T getObjectBean() {
		return objectBean;
	}

	public void setObjectBean(T objectBean) {
		this.objectBean = objectBean;
	}

	public S getObjectEntity() {
		return objectEntity;
	}

	public void setObjectEntity(S objectEntity) {
		this.objectEntity = objectEntity;
	}

	public List<T> getObjectBeanList() {
		return objectBeanList;
	}

	public void setObjectBeanList(List<T> objectBeanList) {
		this.objectBeanList = objectBeanList;
	}

	public List<S> getObjectEntityList() {
		return objectEntityList;
	}

	public void setObjectEntityList(List<S> objectEntityList) {
		this.objectEntityList = objectEntityList;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getSuccessMessages() {
		return successMessages;
	}

	public void setSuccessMessages(String successMessages) {
		this.successMessages = successMessages;
	}

	public String getView() {
		return View;
	}

	public void setView(String view) {
		View = view;
	}

	@Override
	public String toString() {
		return "JsonResponse [objectBean=" + objectBean + ", objectEntity=" + objectEntity + ", objectBeanList="
				+ objectBeanList + ", objectEntityList=" + objectEntityList + ", isValid=" + isValid
				+ ", errorMessages=" + errorMessages + ", successMessages=" + successMessages + ", View=" + View + "]";
	}

	
	
	
	
}
