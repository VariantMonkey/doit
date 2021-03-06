package com.doit.controllers.admin;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doit.service.IArticleService;
import com.doit.service.IBookService;
import com.doit.service.ICommentService;
import com.doit.service.ILinkService;
import com.doit.service.ISortService;
import com.doit.util.GenerateHtml;
import com.doit.util.HtmlRegexp;
import com.doit.vo.TArticle;
import com.doit.vo.TBook;
import com.doit.vo.TLink;
import com.doit.vo.TSort;
import com.doit.vo.TComment;


@Controller
@RequestMapping(value = "/sortAction")
public class AdminSortController {
	
	// 如果需要使用文章的服务，要在此先声明
	@Resource(name = "articleService")
	private IArticleService<TArticle> articleService;  // 声明IArticleService
	public IArticleService<TArticle> getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService<TArticle> articleService) {
		this.articleService = articleService;
	}
	
	@Resource(name = "bookService")
	private IBookService<TBook> bookService;  // 声明IBookService
	public IBookService<TBook> getBookService() {
		return bookService;
	}
	public void setBookService(IBookService<TBook> bookService) {
		this.bookService = bookService;
	}
	
	@Resource(name = "linkService")
	private ILinkService<TLink> linkService;  // 声明ILinkService
	public ILinkService<TLink> getLinkService() {
		return linkService;
	}
	public void setLinkService(ILinkService<TLink> linkService) {
		this.linkService = linkService;
	}
	
	@Resource(name = "sortService")
	private ISortService<TSort> sortService;  // 声明ISortService
	public ISortService<TSort> getSortService() {
		return sortService;
	}
	public void setSortService(ISortService<TSort> sortService) {
		this.sortService = sortService;
	}
	
	@Resource(name = "commentService")
	private ICommentService<TComment> commentService;  // 声明ITCommentService
	public ICommentService<TComment> getCommentService() {
		return commentService;
	}
	public void setCommentService(ICommentService<TComment> commentService) {
		this.commentService = commentService;
	}
	
	
	/****************供页面加载转向的ACTION******************/
	
	
	// 负责映射到新增分类页面
	@RequestMapping(value = "/addPage")
	public ModelAndView addPage() throws Exception{

		// 1.获取图书下的第一个子分类
		int bookFirstSortID = sortService.getFirstSortByFSort(3);
		// 2.获取笔记下的第一个子分类
		int noteFirstSortID = sortService.getFirstSortByFSort(8);
		// 3.组织父分类html代码
		GenerateHtml generateHtml = new GenerateHtml();
		String fSortHtml = generateHtml.generateAdminFSortHtml(3);
		
		// 1.把返回的数据放到相对应的key中
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("noteFirstSortID", noteFirstSortID);
		modelAndView.addObject("bookFirstSortID", bookFirstSortID);
		modelAndView.addObject("fSortHtml", fSortHtml);
		modelAndView.setViewName("/admin/column/sort/add_sort");
		
		// 2.把modelAndView返回
		return modelAndView;
	}
	
	
	// 负责映射到删除分类页面
	@RequestMapping(value = "/delPage/{fSort}/{page}", method = {RequestMethod.GET})
	public ModelAndView delPage(
			@PathVariable(value="fSort") Integer fSort, 
			@PathVariable(value="page") Integer page) throws Exception{

		// 1.获取父分类列表，并且选中传递的子分类
		GenerateHtml generateHtml = new GenerateHtml();
		String fSortHtml = generateHtml.generateAdminFSortHtml(fSort);
		// 2.根据父分类获得此分类下的总个数
		int count = sortService.getSortLength(fSort);
		// 3.根据父分类、页数、每页个数获取此分类下的分类列表
		// 因为前台分页插件的索引是从0开始，所以加1
		page = page +1;
		List <TSort> sorts = sortService.getSort(fSort, page, 6);
		String sortHtml = generateHtml.generateAdminSortDelHtml(sorts);
		// 3.获取笔记下的第一个子分类
		int noteFirstSortID = sortService.getFirstSortByFSort(8);
		// 4.获取图书下的第一个子分类
		int bookFirstSortID = sortService.getFirstSortByFSort(3);
		
		
		// 1.把返回的数据放到相对应的key中
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("count", count);  // 总数
		modelAndView.addObject("pageId", page-1);  // 当前页
		modelAndView.addObject("fSortId", fSort);
		modelAndView.addObject("fSortHtml", fSortHtml);
		modelAndView.addObject("sortHtml", sortHtml);
		modelAndView.addObject("noteFirstSortID", noteFirstSortID);
		modelAndView.addObject("bookFirstSortID", bookFirstSortID);
		modelAndView.setViewName("/admin/column/sort/del_sort");
		
		// 2.把modelAndView返回
		return modelAndView;
	}
	
	// 负责映射到修改分类页面
	@RequestMapping(value = "/updatePage/{fSort}/{page}", method = {RequestMethod.GET})
	public ModelAndView updatePage(
			@PathVariable(value="fSort") Integer fSort, 
			@PathVariable(value="page") Integer page) throws Exception{

		// 1.获取父分类列表，并且选中传递的子分类
		GenerateHtml generateHtml = new GenerateHtml();
		String fSortHtml = generateHtml.generateAdminFSortHtml(fSort);
		// 2.根据父分类获得此分类下的总个数
		int count = sortService.getSortLength(fSort);
		// 3.根据父分类、页数、每页个数获取此分类下的分类列表
		// 因为前台分页插件的索引是从0开始，所以加1
		page = page +1;
		List <TSort> sorts = sortService.getSort(fSort, page, 6);
		String sortHtml = generateHtml.generateAdminSortUpdateHtml(sorts);
		// 3.获取笔记下的第一个子分类
		int noteFirstSortID = sortService.getFirstSortByFSort(8);
		// 4.获取图书下的第一个子分类
		int bookFirstSortID = sortService.getFirstSortByFSort(3);
		
		
		// 1.把返回的数据放到相对应的key中
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("count", count);  // 总数
		modelAndView.addObject("pageId", page-1);  // 当前页
		modelAndView.addObject("fSortId", fSort);
		modelAndView.addObject("fSortHtml", fSortHtml);
		modelAndView.addObject("sortHtml", sortHtml);
		modelAndView.addObject("noteFirstSortID", noteFirstSortID);
		modelAndView.addObject("bookFirstSortID", bookFirstSortID);
		modelAndView.setViewName("/admin/column/sort/update_sort");
		
		// 2.把modelAndView返回
		return modelAndView;
	}
	
	
	/****************供AJAX请求的ACTION******************/
	
	@RequestMapping(value = "/addSort")
	public void addSort(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int fSortId = Integer.parseInt(request.getParameter("fSortId"));
		String sortName = URLDecoder.decode(URLDecoder.decode(request.getParameter("sortName"), "utf-8"), "utf-8");
		
		// 1.添加分类数据
		TSort sort = new TSort();
		sort.setF_Sort(fSortId);
		sort.setSort_Name(sortName);
		sortService.create(sort);
		
		// 3.返回添加状态信息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "1");
		jsonObject.put("msg", "添加分类成功");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject); 
	}
	
	
	@RequestMapping(value = "/delSort")
	public void delSort(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String selectId = request.getParameter("selectId");
		
		for(int i=0; i<selectId.split(";").length; i++){
			TSort sort = new TSort();
			sort.setSort_ID(Integer.parseInt(selectId.split(";")[i]));
			sortService.delete(sort);
		}
		
		// 3.返回添加状态信息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "1");
		jsonObject.put("msg", "删除分类成功");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject); 
	}
	
	@RequestMapping(value = "/getSort")
	public void getSort(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int selectId = Integer.parseInt(request.getParameter("selectId"));
		
		// 1.根据链接id获取分类内容
		TSort sort = sortService.getSortByID(selectId);
		String name = sort.getSort_Name();
		
		// 3.返回添加状态信息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "1");
		jsonObject.put("msg", "获取分类成功");
		jsonObject.put("id", selectId);
		jsonObject.put("name", name);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject); 
	}
	
	@RequestMapping(value = "/updateSort")
	public void updateSort(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = URLDecoder.decode(URLDecoder.decode(request.getParameter("name"), "utf-8"), "utf-8");
		
		// 首先取回需要修改的分类的数据
		TSort priSort = sortService.getSortByID(id);
		int fSort = priSort.getF_Sort();
		
		// 1.修改分类数据
		TSort sort = new TSort();
		sort.setSort_ID(id);
		sort.setSort_Name(name);
		sort.setF_Sort(fSort);
		sortService.update(sort);
		
		// 2.返回添加状态信息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "1");
		jsonObject.put("msg", "修改分类成功");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject); 
	}
	
}