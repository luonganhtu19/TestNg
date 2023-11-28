package firebase.entity;

import java.util.List;

public class ValidateResult {
    private ValidateError[] errors;

    public ValidateResult(){

    }

    public ValidateResult(ValidateError[] errors){
        this.errors = errors;
    }

    public ValidateResult(List<ValidateError> errors){
        if (errors != null)
            this.errors=(ValidateError[]) errors.toArray(new ValidateError[errors.size()]);
    }

    public ValidateError[] getErrors(){return this.errors;}

    public void setErrors(ValidateError[] errors){
        this.errors =errors;
    }

    public boolean hasError(){
        return this.errors != null && this.errors.length !=0;
    }

    public void addError(ValidateError validateError){
        if (this.errors == null){
            this.errors = new ValidateError[]{validateError};
        }else {
            ValidateError[] newList = new ValidateError[this.errors.length+1];
            System.arraycopy(this.errors,0,newList,0,this.errors.length);
            newList[this.errors.length] = validateError;
            this.errors = newList;
        }
    }
}
