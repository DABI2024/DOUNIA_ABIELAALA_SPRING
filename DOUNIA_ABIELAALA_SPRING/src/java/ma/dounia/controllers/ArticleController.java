/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.dounia.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import ma.dounia.model.Article;
import ma.dounia.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ma.dounia.service.ArticleServiceImp;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author DOUNIA ABIELAALA
 */
@Controller
     
public class ArticleController {  
//    ArticleServiceImp service = new ArticleServiceImp() ;
    @Autowired
     ArticleService service ;
    @RequestMapping("/NewArt")
	public ModelAndView newarticle() {
		return new ModelAndView("artform", "command", new Article());
	}
      @RequestMapping("/")    
    public String listarticle(Model m){    
        List<Article> list=service.getAll();
        m.addAttribute("list",list);  
        return "viewart";    
    } 
    @RequestMapping("/listart")    
    public String viewarticle(Model m){    
        List<Article> list=service.getAll();
        m.addAttribute("list",list);  
        return "viewart";    
    }  
  
        @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public String Ajouter(@ModelAttribute("art") Article art){
       service.create(art);
       return  "redirect:/";
    }
    
             @RequestMapping(value="/editart",method = RequestMethod.GET)
         public String delete(@RequestParam int id , Model m){ 
        Article art=service.getArticle(id);    
        m.addAttribute("command",art);  
        return "editform";    
    }
 @RequestMapping(value="/deleteart",method = RequestMethod.GET)
         public String delete(@RequestParam int id)
         { 
        service.deleteArticle(id); 
        return  "redirect:/listart";   
    }     
        /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("art") Article art){  
        
        service.updateArticle(art);
        return "redirect:/listart";    
    }   
    
}



// la bonne méthode
//     @RequestMapping(value="/editart",method = RequestMethod.GET)
//         public String delete(HttpServletRequest request, Model m){ 
//        int id = Integer.parseInt(request.getParameter("id"));
//        Article art=service.getArticle(id);    
//        m.addAttribute("command",art);  
//        return "editform";    
//    }

//        @RequestMapping(value="/deleteart/{id}", method = RequestMethod.GET)    
//    public String delete(@ModelAttribute("art") Article art, @PathVariable int id){ 
//         service.deleteArticle(id);    
//          return  "redirect:/listart.htm"; 
//    }
    
        /* It deletes record for the given id in URL and redirects to /viewemp */ 
//     @RequestMapping(value="/deleteart",method = RequestMethod.GET)
//         public String delete(HttpServletRequest request){ 
//           int id = Integer.parseInt(request.getParameter("id"));   
//        service.deleteArticle(id); 
//        return  "redirect:/listart.htm";   
//    }   
