package firebase.entity;

import java.util.ArrayList;
import java.util.List;

public class ValidateError {
    private String propertyName;
    private String propertyDisplayName;
    private List<String> errorMessage;
    private List<String> errorCode;

    public ValidateError(){

    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDisplayName() {
        return propertyDisplayName;
    }

    public void setPropertyDisplayName(String propertyDisplayName) {
        this.propertyDisplayName = propertyDisplayName;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(List<String> errorCode) {
        this.errorCode = errorCode;
    }

    public void addErrorMessage(String errorMessage){
        this.addErrorMessage(errorMessage,"");
    }
    public void addErrorMessage(String errorMessage, String errorCode){
        if (this.errorMessage == null) this.errorMessage = new ArrayList<>();
        if (this.errorCode==null) this.errorCode = new ArrayList<>();
        this.errorMessage.add(errorMessage);
        this.errorCode.add(errorCode);
    }
}
