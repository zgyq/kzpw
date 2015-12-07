
package com.yf.website.web.interceptor;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.webwork.dispatcher.multipart.MultiPartRequestWrapper;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.ValidationAware;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.opensymphony.xwork.util.OgnlValueStack;

/** 
* a reusable FileUploadInterceptor, base on 
* com.opensymphony.webwork.interceptor.FileUploadInterceptor, for there are no 
* way to extend, so have to create this one. where [File Name] is the name 
* given to the file uploaded by the HTML form: 
* <ul> 
* <li>[File Name] : File - the actual File</li> 
* <li>[File Name]ContentType : String - the content type of the file</li> 
* <li>[File Name]FileName : String - the actual name of the file uploaded (not 
* the HTML name)</li> 
* </ul> 
* <p/>You can get access to these files by merely providing setters in your 
* action that coorespond to any of the three patterns above, such as 
* setDocument(File document), setDocumentContentType(String contentType), etc. 
* 
*/ 
public class FileUploadInterceptor implements Interceptor { 
    protected static final Log log = LogFactory.getLog(FileUploadInterceptor.class); 

    protected String allowedTypes; 
    protected String disallowedTypes; 
    protected Long maximumSize; 
    private static final String default_characterEncoding="GBK";

    private MultiPartRequestWrapper multiWrapper; 

    public void setAllowedTypes(String allowedTypes) { 
        this.allowedTypes = allowedTypes; 
    } 

    public void setDisallowedTypes(String disallowedTypes) { 
        this.disallowedTypes = disallowedTypes; 
    } 

    public void setMaximumSize(Long maximumSize) { 
        this.maximumSize = maximumSize; 
    } 

    public void destroy() { 

    } 

    public void init() { 

    } 

    public String intercept(ActionInvocation invocation) throws Exception {         
        if (!(ServletActionContext.getRequest() instanceof MultiPartRequestWrapper)) { 
            log.debug("bypass " + invocation.getProxy().getNamespace() + "/" + invocation.getProxy().getActionName()); 
            return invocation.invoke(); 
        } 
               
        multiWrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest(); 
        this.convertChartset();
        checkErrors(invocation); 
        bindFiles(invocation); 
        String result = "";
        try{        
            result= invocation.invoke();
        }catch(Exception e){
            cleanUpTempFiles();
            throw e;
        }
        cleanUpTempFiles();
         
        return result; 
    } 

    private void checkErrors(ActionInvocation invocation) { 
        if (multiWrapper.hasErrors()) { 
            Action action = invocation.getAction(); 
            Collection errors = multiWrapper.getErrors(); 
            Iterator i = errors.iterator(); 
            while (i.hasNext()) { 
                processErrorMessage(action, (String) i.next()); 
            } 
        } 
    } 

    protected void bindFiles(ActionInvocation invocation) { 
        Enumeration e = multiWrapper.getFileParameterNames(); 
        if (e != null) { 
            Action action = invocation.getAction(); 
            //Bind allowed Files 
            while (e.hasMoreElements()) { 
                try{
                    String inputName = (String) e.nextElement(); 
                    String[] contentType = multiWrapper.getContentTypes(inputName); 
                    String[] fileName = multiWrapper.getFileNames(inputName); 
                    File[] file = multiWrapper.getFiles(inputName); 
                    
                    if (file != null) { 
                        for (int i = 0; i < file.length; i++) { 
                            
                            String path=file[i].getAbsolutePath();
                            try {
                                path=new String(path.getBytes(/*"ISO-8859-1"*/),default_characterEncoding);
                            } catch (UnsupportedEncodingException e1) {
                                e1.printStackTrace();
                            }
                            File file2=new File(path);
                            
                            //file[i].renameTo(file2);
                            System.out.println("is Rename success?"+file[i].renameTo(file2));
                            file[i] = file2;
                            String name = fileName[i];
                            try {
                                name = new String(name.getBytes(/*"ISO-8859-1"*/), default_characterEncoding);
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                            fileName[i] = name;                        
                            log.info("file " + inputName + " " + contentType[i] + " " + fileName[i] + " " + file[i]);
                            
                        } 
                    } 
                    
                    
                    if (file == null) { 
                        processErrorMessage(action, inputName, "Could not upload file(s). Perhaps it is too large?"); 
                    } else if (acceptFile(file, contentType, inputName, action)) { 
                        invocation.getInvocationContext().getParameters().put(inputName, file); 
                        invocation.getInvocationContext().getParameters().put(inputName + "ContentType", contentType); 
                        invocation.getInvocationContext().getParameters().put(inputName + "FileName", fileName); 
                    } 
                }catch(Exception e2){
                    continue;
                }
            } 
        } 
    } 

    private void cleanUpTempFiles() { 
        Enumeration e = multiWrapper.getFileParameterNames();
        if (e != null) { 
            while (e.hasMoreElements()) {
                try{
                    String inputValue = (String) e.nextElement(); 
                    File[] file = multiWrapper.getFiles(inputValue); 
                    for (int i = 0; i < file.length; i++) { 
                        File f = file[i]; 
                        String path=file[i].getAbsolutePath();
                        try {
                            path=new String(path.getBytes(/*"ISO-8859-1"*/),default_characterEncoding);
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }
                        File file2=new File(path);    				
                        log.info("removing file " + inputValue + " " + file2); 
                        
                        if ((file2!= null) && file2.isFile()) { 
                            file2.delete(); 
                        } 
                    } 
                }catch(Exception e2){
                    continue;
                }
            } 
        } 
    } 

    //overload this method to modify accept behaviour 
    protected boolean acceptFile(File[] files, String[] contentTypes, String inputName, Action action) { 
        for (int i = 0; i < files.length; i++) { 
            File file = files[i]; 
            String contentType = contentTypes[i]; 
            log.debug("checking" + inputName + " " + file.getName() + " " + file.length() + " " + contentType); 
            if (maximumSize != null && maximumSize.longValue() < file.length()) 
                processErrorMessage(action, inputName, "File size is too big: " + inputName + " " + file.getName() + " " + file.length()); 
            else if (allowedTypes != null && allowedTypes.indexOf(contentType) < 0) 
                processErrorMessage(action, inputName, "Content-Type not allowed: " + inputName + " " + file.getName() + " " + contentType); 
            else if (disallowedTypes != null && disallowedTypes.indexOf(contentType) >= 0) 
                processErrorMessage(action, inputName, "Content-Type disallowed: " + inputName + " " + file.getName() + " " + contentType); 
            else { 
                log.debug("accepted"); 
                continue; 
            } 
            log.debug("not accepted"); 
            return false; 
        } 
        return true; 
    } 

    private void processErrorMessage(Action action, String errorMessage) { 
        processErrorMessage(action, null, errorMessage); 
    } 

    //TODO i18n 
    private void processErrorMessage(Action action, String field, String errorMessage) { 
        if (action instanceof ValidationAware) { 
            if (field != null) { 
                ((ValidationAware) action).addFieldError(field, errorMessage); 
            } else { 
                ((ValidationAware) action).addActionError(errorMessage); 
            } 
        } else { 
            log.error("[" + field + "] " + errorMessage); 
        } 

    } 
    
	private void convertChartset(){
		try{
			Map parameters=ActionContext.getContext().getParameters();
	        if (parameters != null) {
	            final OgnlValueStack stack = ActionContext.getContext().getValueStack();
	            for (Iterator iterator = parameters.entrySet().iterator();
	                    iterator.hasNext();) {
	                Map.Entry entry = (Map.Entry) iterator.next();
	                String[] objs=(String[])entry.getValue();
	                for(int i=0;i<objs.length;i++){
	                	objs[i]=new String(objs[i].getBytes("/*ISO-8859-1*/"),default_characterEncoding);
	                }
	                stack.setValue(entry.getKey().toString(), entry.getValue());
	            }
	        }
		}catch(Exception e){
			
		}
	}

} 
