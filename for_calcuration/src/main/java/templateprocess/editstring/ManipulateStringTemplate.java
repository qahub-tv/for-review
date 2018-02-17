package templateprocess.editstring;

import templateprocess.TemplateProcess;

public class ManipulateStringTemplate implements TemplateProcess{

    private final ManipulateString manipulateString;

    public ManipulateStringTemplate(ManipulateString manipulateString){
        this.manipulateString = manipulateString;
    }
   
    @Override
    public Object executeTemplate(Object... targetOriginalString){
        
        if(targetOriginalString[0] instanceof String){
            String targetString = manipulateString.extractTargetString(targetOriginalString[0].toString());
            return manipulateString.manipulaleTargetString(targetString);
        }
        return "";
    }
}