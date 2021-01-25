package com.tangzq.controller;


import com.tangzq.UserNameDb;
import com.tangzq.demo_seed.RandomDataGenerator;
import com.tangzq.model.Topic;
import com.tangzq.model.User_me;
import com.tangzq.repository.TopicRepository2;
import com.tangzq.service.CategoryService;
import com.tangzq.service.TopicService2;
import com.tangzq.MockTopic;
import com.tangzq.model.Category;
import com.tangzq.repository.CategoryRepository;
import com.tangzq.repository.ReplyRepository;
import com.tangzq.service.ReplyService;
import com.tangzq.service.TopicService2;
import com.tangzq.service.UserService;
import com.tangzq.repository.UserRepository;
//import com.tangzq.testUtils.curdTest;
//import com.tangzq.service.impl.TopicServiceImpl;
import com.tangzq.utils.CommonProps;
import com.tangzq.utils.ValidateCode;
//import com.tangzq.vo.IndexVo;
import com.tangzq.vo.IndexVo;
import com.tangzq.vo.LoginUserVo;
//import com.tangzq.vo.RegisterUserVo;
//import com.tangzq.vo.SearchVo;
import com.tangzq.vo.TopicVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 首页控制器
 * @author tangzhiqiang
 */

@Controller
@Slf4j
@RequestMapping(value = "/")
public class HomeController {

    public static final String VCODE_SESSION_KEY="validateCode";


    //    @Value("${appname}")
 //   private String configAppName;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ReplyRepository replyRepository;


    @Autowired
    private TopicService2 topicService;
    @PersistenceContext
    protected EntityManager entityManager;
    @PersistenceUnit(/*unitName = "test"*/)
    private EntityManagerFactory entityManagerFactory;
//
//
//    @Autowired
//    private TopicService topicService;
//
    @Autowired
    private CategoryService categoryService;
    @Autowired
    ReplyService replyService;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    TopicRepository2 topicRepository2;


    /**
     * 跳转到首页
     * @param vo 首页参数封装
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/")
//    public String home() {
    public String home(IndexVo vo, ModelMap modelMap) {

//        RandomDataGenerator rd = new RandomDataGenerator(topicService,categoryService,userService,topicRepository2,entityManager);
//        rd.setFakeData();

 /*       -------------------------------------------------*/
        User_me user1=  userRepository.findByUserName("admin");
        //Page<Topic> topics=(Page<Topic>)topicService.findByPage(vo);
        List<Topic> topics= (List<Topic>) topicService.findByPage(vo);

      //  modelMap.addAttribute("pager",topicService.findByPage(vo));
        modelMap.addAttribute("pager",topics);
        modelMap.addAttribute("catList",categoryService.findAll());
      //  modelMap.addAttribute("indexVo",vo);
        log.info(vo.toString());
      //  User_me user1=  userRepository.findByUserName("admin");


     List<Category> categoryList=  categoryRepository.findBycatname("admin");
    //     List<Reply> replies =  replyRepository.findAllByTopicid("1");
    //     Page<Topic> topicRepositories =  topicRepository.findByAuthorId("1");
//    curdTest.testInsert(sessionFactory);

//       List<Reply> =replyService.findReplyByTopicId()


/*
        MockTopic mock=new MockTopic();
        TopicVo topicVo= mock.getTopicVo();
        Category cat=mock.getCategory();
        topicService.addTopic(topicVo,cat);
        replyRepository.findAll();
        int  a=1;
        */

     cacheManager.getCache("links").get(Topic.class);
        log.info("controller //  start");
//        return "article/show";
       // return "index";
        return "hiFree";
    }

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(){
//    public String search(SearchVo searchVo, ModelMap modelMap){
//        modelMap.addAttribute("searchVo",searchVo);
//        modelMap.addAttribute("pager",topicService.search(searchVo));
        return "search";
    }

    /**
     * 注册页面
     * @return
     */

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public String register(ModelMap model) {
//        model.addAttribute("registerForm",new RegisterUserVo());
//        return "register";
//    }
//
//
//    /**
//     * 用户登录
//     * @return
//     */
//    @RequestMapping(value="/register",method = RequestMethod.POST)
//    public String doegister(@Valid @ModelAttribute("registerForm") RegisterUserVo registerUser, BindingResult result,
//                            HttpSession session,
//                            ModelMap model,
//                            RedirectAttributes redirectAttributes){
//
//        if(result.hasErrors()){
//            return "register";
//        }
//
//        String vcodeInSession = (String) session.getAttribute(VCODE_SESSION_KEY);
//        String submitCode = registerUser.getValidateCode();
//        if (!StringUtils.equals(vcodeInSession,submitCode)) {
//            result.rejectValue("validateCode",null,"验证码错误!");
//        }
//        if(null!=userService.findByUsername(registerUser.getUsername())){
//            result.rejectValue("username",null,"该用户名已经存在");
//        }
//        if(null!=userService.findUserByEmail(registerUser.getEmail())){
//            result.rejectValue("email",null,"该邮箱已经被注册");
//        }
//        if(result.hasErrors()){
//            return "register";
//        }
//
//        User savedUser=userService.createUser(registerUser);
//        if(null!=savedUser&&savedUser.getId()!=null){
//            redirectAttributes.addFlashAttribute("messageSuc","注册成功！");
//            return "redirect:/login";
//        }else{
//            model.addAttribute("messageErr","注册失败");
//            model.addAttribute("vo",registerUser);
//            return "register";
//        }
//    }
//
//
    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("loginForm",new LoginUserVo());
        return "login";
    }
    /**
     * 用户登录
     * @return
     */
//    @RequestMapping(value="/login",method = RequestMethod.GET)

//    public String doLogin(HttpSession session){
/*
      public String doLogin(@Valid @ModelAttribute("loginForm") LoginUserVo user, BindingResult result,
                          HttpSession session,
                          ModelMap model,
                          RedirectAttributes redirectAttributes){
         */
//    @Autowired
//     HttpSession session;
    @RequestMapping(value="/login",method = RequestMethod.POST)
     public String doLogin(@Valid @ModelAttribute("loginForm") LoginUserVo user,
                           HttpSession session,
                           BindingResult result,
                           ModelMap model,
                           RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "login";
        }
         //  return "login";

        String vcodeInSession = (String) session.getAttribute(VCODE_SESSION_KEY);
        String submitCode = user.getValidateCode();

        if (!StringUtils.equals(vcodeInSession,submitCode)) {
            result.rejectValue("validateCode",null,"验证码错误!");
            return "login";
        }
        if(!userService.isUserValid(user.getUsername(),user.getPassword())){
            model.addAttribute("messageErr","用户名或者密码错误");
            return "login";
        }

     session.setAttribute(CommonProps.LOGIN_USER_SESSION_KEY,userService.findUser(user.getUsername(),user.getPassword()));
        return "redirect:/";
    }



    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_ALL_MIXED, 4, null);
        request.getSession().setAttribute(VCODE_SESSION_KEY, verifyCode);
        response.setContentType("image/jpeg");
        BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        ImageIO.write(bim, "JPEG", response.getOutputStream());
    }


    /**
     * 退出系统
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    /**
     * 关于页面
     * @return
     */
    @RequestMapping(value = "/about")
   // @ResponseBody
    public TopicVo about() {
        TopicVo topic = (new MockTopic()).getTopicVo();
       // return "about";
        return topic;
      //  return "/inc/pagination";
    }




}
