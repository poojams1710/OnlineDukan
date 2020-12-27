package project.OnlineDukan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pagecontroller {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(@RequestParam(name="logout",required=false)String logout) {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		
		if(logout!=null) {
			mv.addObject("message", "You have successfully logged out!");			
		}
		
		mv.addObject("userClickHome",true);
		return mv;				
	}


//    @RequestMapping(value="/test")
//    public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting) 
//    {
//    	if(greeting == null)
//    	{
//    		greeting = "Hellow Users  ";
//    	}
//	  ModelAndView mv	= new ModelAndView("page");
//    	mv.addObject("greeting",greeting);
//	   return mv;
//    }
//    
    
    @RequestMapping(value="/test/{greeting}")
    public ModelAndView test(@PathVariable("greeting")String greeting) 
    {
    	if(greeting == null)
    	{
    		greeting = "Hellow Users  ";
        }
	  ModelAndView mv	= new ModelAndView("page");
    	mv.addObject("greeting",greeting);
	   return mv;
    }
    
    
    
}