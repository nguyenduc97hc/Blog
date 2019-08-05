package com.codegym.cotroller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public ModelAndView listBlog(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogList",blogs);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public  ModelAndView saveBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Blog blog =blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Blog blog =blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView removeCustomer(@ModelAttribute Blog blog){
        blogService.delete(blog.getId());
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        return modelAndView;
    }
}
