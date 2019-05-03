package grouptwo.quizexam.security;

import java.io.IOException;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.User;
import grouptwo.quizexam.utils.AppUtils;
@WebFilter("/*")
public class SecurityFilter implements Filter {

    
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse resp = (HttpServletResponse) response;
	     
		 String servletPath = req.getServletPath();
		
		 
		 User loginedUser = AppUtils.getLoginedUser(req.getSession());
		
		 if (servletPath.equals("/Login"))
		 {
	            chain.doFilter(request, response);
	            return;
	        }
	        HttpServletRequest wrapRequest = req;
	         
	 
	        if (loginedUser != null) {
	            // User Name
 	            String userName = loginedUser.getUserName(); 
	            String roles = loginedUser.getRoleObject().getRoleName();
	            
	            // GÃ³i request cÅ© bá»Ÿi má»™t Request má»›i vá»›i cÃ¡c thÃ´ng tin userName vÃ  Roles.
	            wrapRequest = new UserRoleRequestWrapper(userName, roles, req);
	            
	        }
	 
	       
	        if (SecurityUtils.isSeacurityPage(req)) {
	        	  
	            // Náº¿u ngÆ°á»�i dÃ¹ng chÆ°a Ä‘Äƒng nháº­p,
	            // Redirect (chuyá»ƒn hÆ°á»›ng) tá»›i trang Ä‘Äƒng nháº­p.
	        	 
	            if (loginedUser == null) {
	            	
	                String requestUri = catChuoi(wrapRequest.getContextPath(),req.getRequestURL()+"?"+req.getQueryString());
	                
	                // LÆ°u trá»¯ trang hiá»‡n táº¡i Ä‘á»ƒ redirect Ä‘áº¿n sau khi Ä‘Äƒng nháº­p thÃ nh cÃ´ng.
	                int redirectId = AppUtils.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
	                resp.sendRedirect(wrapRequest.getContextPath() + "/Login?redirectId=" + redirectId);
	                return;
	            }
	          
	            // Kiá»ƒm tra ngÆ°á»�i dÃ¹ng cÃ³ vai trÃ² há»£p lá»‡ hay khÃ´ng?
	   
	            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
	            
	            if (!hasPermission) {
	 
	                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Login");
	                dispatcher.forward(request, response);
	                return;
	            }
	        }
	       
	        chain.doFilter(wrapRequest, response);
	       
	    }
	 
	     
	
	private String catChuoi(String chuoicon,String chuoiCha)
		{
			
			int index1 = chuoiCha.indexOf(chuoicon);
	        return chuoiCha.substring(index1+chuoicon.length());
		}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

